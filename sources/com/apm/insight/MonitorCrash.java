package com.apm.insight;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.apm.insight.l.q;
import com.apm.insight.runtime.ConfigManager;
import com.apm.insight.runtime.o;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class MonitorCrash {
    private static volatile boolean sAppMonitorCrashInit = false;
    Config mConfig;
    AttachUserData mCustomData;
    AttachUserData mCustomLongData;
    HeaderParams mParams;
    HashMap<String, String> mTagMap = new HashMap<>();

    /* loaded from: classes.dex */
    public class Config {
        String mAid;
        String mChannel;
        String mDeviceId;
        String[] mPackageName;
        String mSSID;
        String[] mSoList;
        String[] mThreadList;
        String mUID;
        long mVersionInt = -1;
        String mVersionStr;

        public Config() {
        }

        public Config setChannel(String str) {
            this.mChannel = str;
            com.apm.insight.j.b.d();
            return this;
        }

        public Config setDeviceId(String str) {
            this.mDeviceId = str;
            com.apm.insight.j.b.d();
            return this;
        }

        public Config setPackageName(String str) {
            return setPackageName(str);
        }

        public Config setSSID(String str) {
            this.mSSID = str;
            com.apm.insight.j.b.d();
            return this;
        }

        public Config setSoList(String[] strArr) {
            this.mSoList = strArr;
            com.apm.insight.j.b.d();
            return this;
        }

        public Config setThreadList(String[] strArr) {
            this.mThreadList = strArr;
            com.apm.insight.j.b.d();
            return this;
        }

        public Config setUID(String str) {
            this.mUID = str;
            com.apm.insight.j.b.d();
            return this;
        }

        public Config setPackageName(String... strArr) {
            this.mPackageName = strArr;
            com.apm.insight.j.b.d();
            return this;
        }
    }

    /* loaded from: classes.dex */
    public interface HeaderParams {
        Map<String, Object> getCommonParams();
    }

    private MonitorCrash(Context context, String str, long j7, String str2) {
        Config config = new Config();
        this.mConfig = config;
        config.mAid = str;
        config.mVersionInt = j7;
        config.mVersionStr = str2;
        h.a(context, this);
    }

    @Nullable
    public static MonitorCrash init(Context context, String str, long j7, String str2) {
        if (sAppMonitorCrashInit) {
            return null;
        }
        synchronized (MonitorCrash.class) {
            try {
                if (sAppMonitorCrashInit) {
                    return null;
                }
                sAppMonitorCrashInit = true;
                o.a(context, true, true, true, true, 0L);
                return new MonitorCrash(context, str, j7, str2);
            } finally {
            }
        }
    }

    public static MonitorCrash initSDK(Context context, String str, long j7, String str2, String str3) {
        o.a(context, true, true, true, true, 0L);
        MonitorCrash monitorCrash = new MonitorCrash(str, j7, str2, str3);
        monitorCrash.config().setPackageName(str3);
        return monitorCrash;
    }

    public MonitorCrash addTags(String str, String str2) {
        this.mTagMap.put(str, str2);
        return this;
    }

    @NonNull
    public Config config() {
        return this.mConfig;
    }

    public void registerCrashCallback(ICrashCallback iCrashCallback, CrashType crashType) {
        if (this == h.b) {
            o.a(iCrashCallback, crashType);
        } else {
            o.a((ICrashCallback) new b(this.mConfig.mAid, iCrashCallback), crashType);
        }
    }

    public void registerOOMCallback(IOOMCallback iOOMCallback) {
        if (this == h.b) {
            o.a(iOOMCallback);
        } else {
            o.a(new b(this.mConfig.mAid, iOOMCallback));
        }
    }

    public void reportCustomErr(String str, String str2, Throwable th) {
        com.apm.insight.f.b.a(this, th, str, true, null, str2, "core_exception_monitor");
    }

    public MonitorCrash setCustomDataCallback(AttachUserData attachUserData) {
        this.mCustomData = attachUserData;
        return this;
    }

    public MonitorCrash setReportUrl(String str) {
        int i9;
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        int indexOf = str.indexOf("://");
        if (indexOf < 0) {
            str = "https://".concat(str);
            i9 = 8;
        } else {
            i9 = indexOf + 3;
        }
        int indexOf2 = str.indexOf("/", i9);
        if (indexOf2 >= 0) {
            str = str.substring(0, indexOf2);
        }
        q.a((Object) ("set url " + str));
        i.i().setLaunchCrashUrl(str + ConfigManager.EXCEPTION_URL_SUFFIX);
        i.i().setJavaCrashUploadUrl(str + ConfigManager.JAVA_URL_SUFFIX);
        i.i().setNativeCrashUrl(str + ConfigManager.NATIVE_URL_SUFFIX);
        i.i().setConfigUrl(str + ConfigManager.CONFIG_URL_SUFFIX);
        return this;
    }

    public MonitorCrash withOtherHeaders(@Nullable HeaderParams headerParams) {
        this.mParams = headerParams;
        return this;
    }

    private MonitorCrash(String str, long j7, String str2, String... strArr) {
        Config config = new Config();
        this.mConfig = config;
        config.mAid = str;
        config.mVersionInt = j7;
        config.mVersionStr = str2;
        config.mPackageName = strArr;
        h.a(this);
    }

    public static MonitorCrash initSDK(Context context, String str, long j7, String str2, String str3, String[] strArr) {
        o.a(context, true, true, true, true, 0L);
        MonitorCrash monitorCrash = new MonitorCrash(str, j7, str2, str3);
        monitorCrash.config().setPackageName(str3).setSoList(strArr);
        return monitorCrash;
    }

    public static MonitorCrash initSDK(Context context, String str, long j7, String str2, String... strArr) {
        o.a(context, true, true, true, true, 0L);
        MonitorCrash monitorCrash = new MonitorCrash(str, j7, str2, strArr);
        monitorCrash.config().setPackageName(strArr);
        return monitorCrash;
    }

    public static MonitorCrash initSDK(Context context, String str, long j7, String str2, String[] strArr, String[] strArr2) {
        o.a(context, true, true, true, true, 0L);
        MonitorCrash monitorCrash = new MonitorCrash(str, j7, str2, strArr);
        monitorCrash.config().setPackageName(strArr).setSoList(strArr2);
        return monitorCrash;
    }
}
