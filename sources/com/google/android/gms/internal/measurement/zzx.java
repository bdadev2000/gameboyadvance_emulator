package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzx extends zzal {
    private final Callable<Object> zzk;

    public zzx(String str, Callable<Object> callable) {
        super(str);
        this.zzk = callable;
    }

    @Override // com.google.android.gms.internal.measurement.zzal
    public final zzaq zza(zzh zzhVar, List<zzaq> list) {
        try {
            return zzj.zza(this.zzk.call());
        } catch (Exception unused) {
            return zzaq.zzc;
        }
    }
}
