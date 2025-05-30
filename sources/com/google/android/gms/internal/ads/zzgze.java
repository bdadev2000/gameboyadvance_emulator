package com.google.android.gms.internal.ads;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import x0.AbstractC2914a;

/* loaded from: classes2.dex */
public final class zzgze {
    private final byte[] zza;

    private zzgze(byte[] bArr, int i9, int i10) {
        byte[] bArr2 = new byte[i10];
        this.zza = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i10);
    }

    public static zzgze zzb(byte[] bArr) {
        if (bArr != null) {
            return new zzgze(bArr, 0, bArr.length);
        }
        throw new NullPointerException("data must be non-null");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgze)) {
            return false;
        }
        return Arrays.equals(((zzgze) obj).zza, this.zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        byte[] bArr = this.zza;
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (byte b : bArr) {
            sb.append("0123456789abcdef".charAt((b & 255) >> 4));
            sb.append("0123456789abcdef".charAt(b & Ascii.SI));
        }
        return AbstractC2914a.e("Bytes(", sb.toString(), ")");
    }

    public final int zza() {
        return this.zza.length;
    }

    public final byte[] zzc() {
        byte[] bArr = this.zza;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }
}
