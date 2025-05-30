package com.google.android.gms.ads.nativead;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.List;

/* loaded from: classes2.dex */
public interface NativeCustomFormatAd {

    @NonNull
    public static final String ASSET_NAME_VIDEO = "_videoMediaView";

    /* loaded from: classes2.dex */
    public interface DisplayOpenMeasurement {
        void setView(@NonNull View view);

        boolean start();
    }

    /* loaded from: classes2.dex */
    public interface OnCustomClickListener {
        void onCustomClick(@NonNull NativeCustomFormatAd nativeCustomFormatAd, @NonNull String str);
    }

    /* loaded from: classes2.dex */
    public interface OnCustomFormatAdLoadedListener {
        void onCustomFormatAdLoaded(@NonNull NativeCustomFormatAd nativeCustomFormatAd);
    }

    void destroy();

    @Nullable
    List<String> getAvailableAssetNames();

    @Nullable
    String getCustomFormatId();

    @NonNull
    DisplayOpenMeasurement getDisplayOpenMeasurement();

    @Nullable
    NativeAd.Image getImage(@NonNull String str);

    @Nullable
    MediaContent getMediaContent();

    @Nullable
    CharSequence getText(@NonNull String str);

    void performClick(@NonNull String str);

    void recordImpression();
}
