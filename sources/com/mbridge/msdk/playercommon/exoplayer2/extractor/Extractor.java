package com.mbridge.msdk.playercommon.exoplayer2.extractor;

import java.io.IOException;

/* loaded from: classes3.dex */
public interface Extractor {
    public static final int RESULT_CONTINUE = 0;
    public static final int RESULT_END_OF_INPUT = -1;
    public static final int RESULT_SEEK = 1;

    void init(ExtractorOutput extractorOutput);

    int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException;

    void release();

    void seek(long j7, long j9);

    boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException;
}
