package com.google.android.gms.measurement.internal;

import java.util.Map;

/* loaded from: classes2.dex */
final class zzhb implements com.google.android.gms.internal.measurement.zzo {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzgt zzb;

    public zzhb(zzgt zzgtVar, String str) {
        this.zza = str;
        this.zzb = zzgtVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzo
    public final String zza(String str) {
        Map map;
        map = this.zzb.zzc;
        Map map2 = (Map) map.get(this.zza);
        if (map2 != null && map2.containsKey(str)) {
            return (String) map2.get(str);
        }
        return null;
    }
}
