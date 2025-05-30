package com.mbridge.msdk.thrid.okhttp.internal.ws;

import Q7.n0;
import com.mbridge.msdk.thrid.okhttp.Call;
import com.mbridge.msdk.thrid.okhttp.Callback;
import com.mbridge.msdk.thrid.okhttp.EventListener;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import com.mbridge.msdk.thrid.okhttp.Protocol;
import com.mbridge.msdk.thrid.okhttp.Request;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.thrid.okhttp.WebSocket;
import com.mbridge.msdk.thrid.okhttp.WebSocketListener;
import com.mbridge.msdk.thrid.okhttp.internal.Internal;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.connection.StreamAllocation;
import com.mbridge.msdk.thrid.okhttp.internal.ws.WebSocketReader;
import com.mbridge.msdk.thrid.okio.BufferedSink;
import com.mbridge.msdk.thrid.okio.BufferedSource;
import com.mbridge.msdk.thrid.okio.ByteString;
import com.mbridge.msdk.thrid.okio.Okio;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import x0.AbstractC2914a;

/* loaded from: classes3.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final List<Protocol> ONLY_HTTP1 = Collections.singletonList(Protocol.HTTP_1_1);
    private boolean awaitingPong;
    private Call call;
    private ScheduledFuture<?> cancelFuture;
    private boolean enqueuedClose;
    private ScheduledExecutorService executor;
    private boolean failed;
    private final String key;
    final WebSocketListener listener;
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private WebSocketWriter writer;
    private final Runnable writerRunnable;
    private final ArrayDeque<ByteString> pongQueue = new ArrayDeque<>();
    private final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque<>();
    private int receivedCloseCode = -1;

    /* loaded from: classes3.dex */
    public final class CancelRunnable implements Runnable {
        public CancelRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RealWebSocket.this.cancel();
        }
    }

    /* loaded from: classes3.dex */
    public static final class Close {
        final long cancelAfterCloseMillis;
        final int code;
        final ByteString reason;

        public Close(int i9, ByteString byteString, long j7) {
            this.code = i9;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j7;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Message {
        final ByteString data;
        final int formatOpcode;

        public Message(int i9, ByteString byteString) {
            this.formatOpcode = i9;
            this.data = byteString;
        }
    }

    /* loaded from: classes3.dex */
    public final class PingRunnable implements Runnable {
        public PingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RealWebSocket.this.writePingFrame();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Streams implements Closeable {
        public final boolean client;
        public final BufferedSink sink;
        public final BufferedSource source;

        public Streams(boolean z8, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.client = z8;
            this.source = bufferedSource;
            this.sink = bufferedSink;
        }
    }

    public RealWebSocket(Request request, WebSocketListener webSocketListener, Random random, long j7) {
        if ("GET".equals(request.method())) {
            this.originalRequest = request;
            this.listener = webSocketListener;
            this.random = random;
            this.pingIntervalMillis = j7;
            byte[] bArr = new byte[16];
            random.nextBytes(bArr);
            this.key = ByteString.of(bArr).base64();
            this.writerRunnable = new Runnable() { // from class: com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket.1
                @Override // java.lang.Runnable
                public void run() {
                    do {
                        try {
                        } catch (IOException e4) {
                            RealWebSocket.this.failWebSocket(e4, null);
                            return;
                        }
                    } while (RealWebSocket.this.writeOneFrame());
                }
            };
            return;
        }
        throw new IllegalArgumentException("Request must be GET: " + request.method());
    }

    private void runWriter() {
        ScheduledExecutorService scheduledExecutorService = this.executor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.writerRunnable);
        }
    }

    public void awaitTermination(int i9, TimeUnit timeUnit) throws InterruptedException {
        this.executor.awaitTermination(i9, timeUnit);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.WebSocket
    public void cancel() {
        this.call.cancel();
    }

    public void checkResponse(Response response) throws ProtocolException {
        if (response.code() == 101) {
            String header = response.header("Connection");
            if ("Upgrade".equalsIgnoreCase(header)) {
                String header2 = response.header("Upgrade");
                if ("websocket".equalsIgnoreCase(header2)) {
                    String header3 = response.header("Sec-WebSocket-Accept");
                    String base64 = ByteString.encodeUtf8(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
                    if (base64.equals(header3)) {
                        return;
                    } else {
                        throw new ProtocolException(n0.j("Expected 'Sec-WebSocket-Accept' header value '", base64, "' but was '", header3, "'"));
                    }
                }
                throw new ProtocolException(AbstractC2914a.e("Expected 'Upgrade' header value 'websocket' but was '", header2, "'"));
            }
            throw new ProtocolException(AbstractC2914a.e("Expected 'Connection' header value 'Upgrade' but was '", header, "'"));
        }
        throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + " " + response.message() + "'");
    }

    @Override // com.mbridge.msdk.thrid.okhttp.WebSocket
    public boolean close(int i9, String str) {
        return close(i9, str, 60000L);
    }

    public void connect(OkHttpClient okHttpClient) {
        OkHttpClient build = okHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        final Request build2 = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build();
        Call newWebSocketCall = Internal.instance.newWebSocketCall(build, build2);
        this.call = newWebSocketCall;
        newWebSocketCall.timeout().clearTimeout();
        this.call.enqueue(new Callback() { // from class: com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket.2
            @Override // com.mbridge.msdk.thrid.okhttp.Callback
            public void onFailure(Call call, IOException iOException) {
                RealWebSocket.this.failWebSocket(iOException, null);
            }

            @Override // com.mbridge.msdk.thrid.okhttp.Callback
            public void onResponse(Call call, Response response) {
                try {
                    RealWebSocket.this.checkResponse(response);
                    StreamAllocation streamAllocation = Internal.instance.streamAllocation(call);
                    streamAllocation.noNewStreams();
                    Streams newWebSocketStreams = streamAllocation.connection().newWebSocketStreams(streamAllocation);
                    try {
                        RealWebSocket realWebSocket = RealWebSocket.this;
                        realWebSocket.listener.onOpen(realWebSocket, response);
                        RealWebSocket.this.initReaderAndWriter("OkHttp WebSocket " + build2.url().redact(), newWebSocketStreams);
                        streamAllocation.connection().socket().setSoTimeout(0);
                        RealWebSocket.this.loopReader();
                    } catch (Exception e4) {
                        RealWebSocket.this.failWebSocket(e4, null);
                    }
                } catch (ProtocolException e9) {
                    RealWebSocket.this.failWebSocket(e9, response);
                    Util.closeQuietly(response);
                }
            }
        });
    }

    public void failWebSocket(Exception exc, Response response) {
        synchronized (this) {
            try {
                if (this.failed) {
                    return;
                }
                this.failed = true;
                Streams streams = this.streams;
                this.streams = null;
                ScheduledFuture<?> scheduledFuture = this.cancelFuture;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                ScheduledExecutorService scheduledExecutorService = this.executor;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdown();
                }
                try {
                    this.listener.onFailure(this, exc, response);
                } finally {
                    Util.closeQuietly(streams);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void initReaderAndWriter(String str, Streams streams) throws IOException {
        synchronized (this) {
            try {
                this.streams = streams;
                this.writer = new WebSocketWriter(streams.client, streams.sink, this.random);
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(str, false));
                this.executor = scheduledThreadPoolExecutor;
                if (this.pingIntervalMillis != 0) {
                    PingRunnable pingRunnable = new PingRunnable();
                    long j7 = this.pingIntervalMillis;
                    scheduledThreadPoolExecutor.scheduleAtFixedRate(pingRunnable, j7, j7, TimeUnit.MILLISECONDS);
                }
                if (!this.messageAndCloseQueue.isEmpty()) {
                    runWriter();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.reader = new WebSocketReader(streams.client, streams.source, this);
    }

    public void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            this.reader.processNextFrame();
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i9, String str) {
        Streams streams;
        if (i9 != -1) {
            synchronized (this) {
                try {
                    if (this.receivedCloseCode == -1) {
                        this.receivedCloseCode = i9;
                        this.receivedCloseReason = str;
                        streams = null;
                        if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                            Streams streams2 = this.streams;
                            this.streams = null;
                            ScheduledFuture<?> scheduledFuture = this.cancelFuture;
                            if (scheduledFuture != null) {
                                scheduledFuture.cancel(false);
                            }
                            this.executor.shutdown();
                            streams = streams2;
                        }
                    } else {
                        throw new IllegalStateException("already closed");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            try {
                this.listener.onClosing(this, i9, str);
                if (streams != null) {
                    this.listener.onClosed(this, i9, str);
                }
                return;
            } finally {
                Util.closeQuietly(streams);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String str) throws IOException {
        this.listener.onMessage(this, str);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(ByteString byteString) {
        try {
            if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(byteString);
                runWriter();
                this.receivedPingCount++;
            }
        } finally {
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(ByteString byteString) {
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    public synchronized boolean pong(ByteString byteString) {
        try {
            if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(byteString);
                runWriter();
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean processNextFrame() throws IOException {
        try {
            this.reader.processNextFrame();
            if (this.receivedCloseCode != -1) {
                return false;
            }
            return true;
        } catch (Exception e4) {
            failWebSocket(e4, null);
            return false;
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.WebSocket
    public synchronized long queueSize() {
        return this.queueSize;
    }

    public synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    public synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.WebSocket
    public Request request() {
        return this.originalRequest;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.WebSocket
    public boolean send(String str) {
        if (str != null) {
            return send(ByteString.encodeUtf8(str), 1);
        }
        throw new NullPointerException("text == null");
    }

    public synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    public void tearDown() throws InterruptedException {
        ScheduledFuture<?> scheduledFuture = this.cancelFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.executor.shutdown();
        this.executor.awaitTermination(10L, TimeUnit.SECONDS);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v6 */
    public boolean writeOneFrame() throws IOException {
        String str;
        int i9;
        Streams streams;
        synchronized (this) {
            try {
                if (this.failed) {
                    return false;
                }
                WebSocketWriter webSocketWriter = this.writer;
                ByteString poll = this.pongQueue.poll();
                Message message = 0;
                if (poll == null) {
                    Object poll2 = this.messageAndCloseQueue.poll();
                    if (poll2 instanceof Close) {
                        i9 = this.receivedCloseCode;
                        str = this.receivedCloseReason;
                        if (i9 != -1) {
                            streams = this.streams;
                            this.streams = null;
                            this.executor.shutdown();
                        } else {
                            this.cancelFuture = this.executor.schedule(new CancelRunnable(), ((Close) poll2).cancelAfterCloseMillis, TimeUnit.MILLISECONDS);
                            streams = null;
                        }
                    } else {
                        if (poll2 == null) {
                            return false;
                        }
                        str = null;
                        i9 = -1;
                        streams = null;
                    }
                    message = poll2;
                } else {
                    str = null;
                    i9 = -1;
                    streams = null;
                }
                try {
                    if (poll != null) {
                        webSocketWriter.writePong(poll);
                    } else if (message instanceof Message) {
                        ByteString byteString = message.data;
                        BufferedSink buffer = Okio.buffer(webSocketWriter.newMessageSink(message.formatOpcode, byteString.size()));
                        buffer.write(byteString);
                        buffer.close();
                        synchronized (this) {
                            this.queueSize -= byteString.size();
                        }
                    } else if (message instanceof Close) {
                        Close close = (Close) message;
                        webSocketWriter.writeClose(close.code, close.reason);
                        if (streams != null) {
                            this.listener.onClosed(this, i9, str);
                        }
                    } else {
                        throw new AssertionError();
                    }
                    Util.closeQuietly(streams);
                    return true;
                } catch (Throwable th) {
                    Util.closeQuietly(streams);
                    throw th;
                }
            } finally {
            }
        }
    }

    public void writePingFrame() {
        int i9;
        synchronized (this) {
            try {
                if (this.failed) {
                    return;
                }
                WebSocketWriter webSocketWriter = this.writer;
                if (this.awaitingPong) {
                    i9 = this.sentPingCount;
                } else {
                    i9 = -1;
                }
                this.sentPingCount++;
                this.awaitingPong = true;
                if (i9 != -1) {
                    StringBuilder sb = new StringBuilder("sent ping but didn't receive pong within ");
                    sb.append(this.pingIntervalMillis);
                    sb.append("ms (after ");
                    failWebSocket(new SocketTimeoutException(AbstractC2914a.g(sb, i9 - 1, " successful ping/pongs)")), null);
                    return;
                }
                try {
                    webSocketWriter.writePing(ByteString.EMPTY);
                } catch (IOException e4) {
                    failWebSocket(e4, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized boolean close(int i9, String str, long j7) {
        ByteString byteString;
        try {
            WebSocketProtocol.validateCloseCode(i9);
            if (str != null) {
                byteString = ByteString.encodeUtf8(str);
                if (byteString.size() > 123) {
                    throw new IllegalArgumentException("reason.size() > 123: ".concat(str));
                }
            } else {
                byteString = null;
            }
            if (!this.failed && !this.enqueuedClose) {
                this.enqueuedClose = true;
                this.messageAndCloseQueue.add(new Close(i9, byteString, j7));
                runWriter();
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(ByteString byteString) throws IOException {
        this.listener.onMessage(this, byteString);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.WebSocket
    public boolean send(ByteString byteString) {
        if (byteString != null) {
            return send(byteString, 2);
        }
        throw new NullPointerException("bytes == null");
    }

    private synchronized boolean send(ByteString byteString, int i9) {
        if (!this.failed && !this.enqueuedClose) {
            if (this.queueSize + byteString.size() > MAX_QUEUE_SIZE) {
                close(1001, null);
                return false;
            }
            this.queueSize += byteString.size();
            this.messageAndCloseQueue.add(new Message(i9, byteString));
            runWriter();
            return true;
        }
        return false;
    }
}
