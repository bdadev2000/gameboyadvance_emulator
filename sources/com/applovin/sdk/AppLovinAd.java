package com.applovin.sdk;

/* loaded from: classes.dex */
public interface AppLovinAd {
    @Deprecated
    long getAdIdNumber();

    @Deprecated
    String getAdValue(String str);

    @Deprecated
    String getAdValue(String str, String str2);

    AppLovinAdSize getSize();

    AppLovinAdType getType();

    String getZoneId();

    @Deprecated
    boolean isVideoAd();
}
