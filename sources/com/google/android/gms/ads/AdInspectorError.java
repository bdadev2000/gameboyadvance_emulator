package com.google.android.gms.ads;

import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public final class AdInspectorError extends AdError {
    public static final int ERROR_CODE_ALREADY_OPEN = 3;
    public static final int ERROR_CODE_FAILED_TO_LOAD = 1;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_NOT_IN_TEST_MODE = 2;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface AdInspectorErrorCode {
    }

    public AdInspectorError(int i9, @NonNull String str, @NonNull String str2) {
        super(i9, str, str2);
    }

    @Override // com.google.android.gms.ads.AdError
    public int getCode() {
        return super.getCode();
    }
}
