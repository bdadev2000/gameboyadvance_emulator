package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdq;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzdu extends zzdq.zza {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ Bundle zze;
    private final /* synthetic */ zzdq zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdu(zzdq zzdqVar, String str, String str2, Bundle bundle) {
        super(zzdqVar);
        this.zzc = str;
        this.zzd = str2;
        this.zze = bundle;
        this.zzf = zzdqVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzdq.zza
    public final void zza() throws RemoteException {
        zzdb zzdbVar;
        zzdbVar = this.zzf.zzj;
        ((zzdb) Preconditions.checkNotNull(zzdbVar)).clearConditionalUserProperty(this.zzc, this.zzd, this.zze);
    }
}
