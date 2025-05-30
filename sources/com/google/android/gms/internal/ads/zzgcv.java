package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* loaded from: classes2.dex */
final class zzgcv extends zzgcn implements Serializable {
    static final zzgcv zza = new zzgcv();

    private zzgcv() {
    }

    @Override // com.google.android.gms.internal.ads.zzgcn, java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        comparable.getClass();
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public final String toString() {
        return "Ordering.natural().reverse()";
    }
}
