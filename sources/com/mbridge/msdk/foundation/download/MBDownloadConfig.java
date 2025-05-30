package com.mbridge.msdk.foundation.download;

import android.os.Handler;
import com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper;
import com.mbridge.msdk.foundation.download.utils.ILogger;
import com.mbridge.msdk.foundation.download.utils.Objects;

/* loaded from: classes3.dex */
public class MBDownloadConfig {
    private Handler databaseHandler;
    private IDatabaseOpenHelper databaseHelper;
    private long defaultConnectTimeout;
    private long defaultPingInterval;
    private long defaultReadTimeout;
    private long defaultWriteTimeout;
    private ILogger logger;
    private int maxRequests;
    private int maxRequestsPerHost;

    /* loaded from: classes3.dex */
    public static final class Builder {
        private Handler databaseHandler;
        private IDatabaseOpenHelper databaseHelper;
        private String databaseName;
        private int databaseVersion;
        private long defaultConnectTimeout;
        private long defaultPingInterval;
        private long defaultReadTimeout;
        private long defaultWriteTimeout;
        private ILogger logger;
        private int maxRequests;
        private int maxRequestsPerHost;
        private String tableName;

        public Builder() {
            this(null);
        }

        public final MBDownloadConfig build() {
            return new MBDownloadConfig(this);
        }

        public final Builder setDatabaseHandler(Handler handler) {
            this.databaseHandler = handler;
            return this;
        }

        public final Builder setDatabaseOpenHelper(IDatabaseOpenHelper iDatabaseOpenHelper) {
            this.databaseHelper = iDatabaseOpenHelper;
            return this;
        }

        public final Builder setDefaultConnectTimeout(long j7) {
            this.defaultConnectTimeout = j7;
            return this;
        }

        public final Builder setDefaultPingInterval(long j7) {
            this.defaultPingInterval = j7;
            return this;
        }

        public final Builder setDefaultReadTimeout(long j7) {
            this.defaultReadTimeout = j7;
            return this;
        }

        public final Builder setDefaultWriteTimeout(long j7) {
            this.defaultWriteTimeout = j7;
            return this;
        }

        public final Builder setLogger(ILogger iLogger) {
            this.logger = iLogger;
            return this;
        }

        public final Builder setMaxRequests(int i9) {
            this.maxRequests = i9;
            return this;
        }

        public final Builder setMaxRequestsPerHost(int i9) {
            this.maxRequestsPerHost = i9;
            return this;
        }

        public Builder(MBDownloadConfig mBDownloadConfig) {
            this.databaseName = "";
            this.databaseVersion = -1;
            this.defaultConnectTimeout = 20000L;
            this.defaultPingInterval = 10L;
            this.defaultReadTimeout = 20000L;
            this.defaultWriteTimeout = 20000L;
            this.logger = new ILogger() { // from class: com.mbridge.msdk.foundation.download.MBDownloadConfig.Builder.1
                @Override // com.mbridge.msdk.foundation.download.utils.ILogger
                public void log(String str, Exception exc) {
                }

                @Override // com.mbridge.msdk.foundation.download.utils.ILogger
                public void log(String str, String str2) {
                }
            };
            this.maxRequests = 64;
            this.maxRequestsPerHost = 20;
            this.tableName = Command.DEFAULT_DATABASE_TABLE_NAME;
            if (Objects.isNotNull(mBDownloadConfig)) {
                this.databaseHandler = mBDownloadConfig.getDatabaseHandler();
                this.logger = mBDownloadConfig.getLogger();
                this.defaultReadTimeout = mBDownloadConfig.getDefaultReadTimeout();
                this.defaultConnectTimeout = mBDownloadConfig.getDefaultConnectTimeout();
                this.maxRequests = mBDownloadConfig.getMaxRequests();
                this.defaultWriteTimeout = mBDownloadConfig.getDefaultWriteTimeout();
                this.maxRequests = mBDownloadConfig.getMaxRequests();
                this.maxRequestsPerHost = mBDownloadConfig.getMaxRequestsPerHost();
                this.defaultPingInterval = mBDownloadConfig.getDefaultPingInterval();
            }
        }
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public Handler getDatabaseHandler() {
        return this.databaseHandler;
    }

    public IDatabaseOpenHelper getDatabaseHelper() {
        return this.databaseHelper;
    }

    public long getDefaultConnectTimeout() {
        return this.defaultConnectTimeout;
    }

    public long getDefaultPingInterval() {
        return this.defaultPingInterval;
    }

    public long getDefaultReadTimeout() {
        return this.defaultReadTimeout;
    }

    public long getDefaultWriteTimeout() {
        return this.defaultWriteTimeout;
    }

    public ILogger getLogger() {
        return this.logger;
    }

    public int getMaxRequests() {
        return this.maxRequests;
    }

    public int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    private MBDownloadConfig(Builder builder) {
        this.databaseHelper = builder.databaseHelper;
        this.logger = builder.logger;
        this.databaseHandler = builder.databaseHandler;
        this.defaultConnectTimeout = builder.defaultConnectTimeout;
        this.defaultReadTimeout = builder.defaultReadTimeout;
        this.defaultWriteTimeout = builder.defaultWriteTimeout;
        this.maxRequests = builder.maxRequests;
        this.maxRequestsPerHost = builder.maxRequestsPerHost;
        this.defaultPingInterval = builder.defaultPingInterval;
    }

    public static Builder newBuilder(MBDownloadConfig mBDownloadConfig) {
        return new Builder(mBDownloadConfig);
    }
}
