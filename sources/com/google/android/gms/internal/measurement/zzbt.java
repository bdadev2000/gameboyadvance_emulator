package com.google.android.gms.internal.measurement;

import com.google.android.gms.ads.AdError;
import com.mbridge.msdk.foundation.entity.o;
import java.util.Iterator;
import java.util.List;
import x0.AbstractC2914a;

/* loaded from: classes2.dex */
public final class zzbt extends zzay {
    public zzbt() {
        this.zza.add(zzbv.ASSIGN);
        this.zza.add(zzbv.CONST);
        this.zza.add(zzbv.CREATE_ARRAY);
        this.zza.add(zzbv.CREATE_OBJECT);
        this.zza.add(zzbv.EXPRESSION_LIST);
        this.zza.add(zzbv.GET);
        this.zza.add(zzbv.GET_INDEX);
        this.zza.add(zzbv.GET_PROPERTY);
        this.zza.add(zzbv.NULL);
        this.zza.add(zzbv.SET_PROPERTY);
        this.zza.add(zzbv.TYPEOF);
        this.zza.add(zzbv.UNDEFINED);
        this.zza.add(zzbv.VAR);
    }

    @Override // com.google.android.gms.internal.measurement.zzay
    public final zzaq zza(String str, zzh zzhVar, List<zzaq> list) {
        String str2;
        int i9 = 0;
        switch (zzbs.zza[zzg.zza(str).ordinal()]) {
            case 1:
                zzg.zza(zzbv.ASSIGN, 2, list);
                zzaq zza = zzhVar.zza(list.get(0));
                if (zza instanceof zzas) {
                    if (zzhVar.zzb(zza.zzf())) {
                        zzaq zza2 = zzhVar.zza(list.get(1));
                        zzhVar.zzc(zza.zzf(), zza2);
                        return zza2;
                    }
                    throw new IllegalArgumentException(AbstractC2914a.d("Attempting to assign undefined value ", zza.zzf()));
                }
                throw new IllegalArgumentException(AbstractC2914a.d("Expected string for assign var. got ", zza.getClass().getCanonicalName()));
            case 2:
                zzg.zzb(zzbv.CONST, 2, list);
                if (list.size() % 2 == 0) {
                    while (i9 < list.size() - 1) {
                        zzaq zza3 = zzhVar.zza(list.get(i9));
                        if (zza3 instanceof zzas) {
                            zzhVar.zzb(zza3.zzf(), zzhVar.zza(list.get(i9 + 1)));
                            i9 += 2;
                        } else {
                            throw new IllegalArgumentException(AbstractC2914a.d("Expected string for const name. got ", zza3.getClass().getCanonicalName()));
                        }
                    }
                    return zzaq.zzc;
                }
                throw new IllegalArgumentException(o.h(list.size(), "CONST requires an even number of arguments, found "));
            case 3:
                if (list.isEmpty()) {
                    return new zzaf();
                }
                zzaf zzafVar = new zzaf();
                Iterator<zzaq> it = list.iterator();
                while (it.hasNext()) {
                    zzaq zza4 = zzhVar.zza(it.next());
                    if (!(zza4 instanceof zzaj)) {
                        zzafVar.zzb(i9, zza4);
                        i9++;
                    } else {
                        throw new IllegalStateException("Failed to evaluate array element");
                    }
                }
                return zzafVar;
            case 4:
                if (list.isEmpty()) {
                    return new zzap();
                }
                if (list.size() % 2 == 0) {
                    zzap zzapVar = new zzap();
                    while (i9 < list.size() - 1) {
                        zzaq zza5 = zzhVar.zza(list.get(i9));
                        zzaq zza6 = zzhVar.zza(list.get(i9 + 1));
                        if (!(zza5 instanceof zzaj) && !(zza6 instanceof zzaj)) {
                            zzapVar.zza(zza5.zzf(), zza6);
                            i9 += 2;
                        } else {
                            throw new IllegalStateException("Failed to evaluate map entry");
                        }
                    }
                    return zzapVar;
                }
                throw new IllegalArgumentException(o.h(list.size(), "CREATE_OBJECT requires an even number of arguments, found "));
            case 5:
                zzg.zzb(zzbv.EXPRESSION_LIST, 1, list);
                zzaq zzaqVar = zzaq.zzc;
                while (i9 < list.size()) {
                    zzaqVar = zzhVar.zza(list.get(i9));
                    if (!(zzaqVar instanceof zzaj)) {
                        i9++;
                    } else {
                        throw new IllegalStateException("ControlValue cannot be in an expression list");
                    }
                }
                return zzaqVar;
            case 6:
                zzg.zza(zzbv.GET, 1, list);
                zzaq zza7 = zzhVar.zza(list.get(0));
                if (zza7 instanceof zzas) {
                    return zzhVar.zza(zza7.zzf());
                }
                throw new IllegalArgumentException(AbstractC2914a.d("Expected string for get var. got ", zza7.getClass().getCanonicalName()));
            case 7:
            case 8:
                zzg.zza(zzbv.GET_PROPERTY, 2, list);
                zzaq zza8 = zzhVar.zza(list.get(0));
                zzaq zza9 = zzhVar.zza(list.get(1));
                if ((zza8 instanceof zzaf) && zzg.zzb(zza9)) {
                    return ((zzaf) zza8).zza(zza9.zze().intValue());
                }
                if (zza8 instanceof zzak) {
                    return ((zzak) zza8).zza(zza9.zzf());
                }
                if (zza8 instanceof zzas) {
                    if ("length".equals(zza9.zzf())) {
                        return new zzai(Double.valueOf(zza8.zzf().length()));
                    }
                    if (zzg.zzb(zza9) && zza9.zze().doubleValue() < zza8.zzf().length()) {
                        return new zzas(String.valueOf(zza8.zzf().charAt(zza9.zze().intValue())));
                    }
                }
                return zzaq.zzc;
            case 9:
                zzg.zza(zzbv.NULL, 0, list);
                return zzaq.zzd;
            case 10:
                zzg.zza(zzbv.SET_PROPERTY, 3, list);
                zzaq zza10 = zzhVar.zza(list.get(0));
                zzaq zza11 = zzhVar.zza(list.get(1));
                zzaq zza12 = zzhVar.zza(list.get(2));
                if (zza10 != zzaq.zzc && zza10 != zzaq.zzd) {
                    if ((zza10 instanceof zzaf) && (zza11 instanceof zzai)) {
                        ((zzaf) zza10).zzb(zza11.zze().intValue(), zza12);
                    } else if (zza10 instanceof zzak) {
                        ((zzak) zza10).zza(zza11.zzf(), zza12);
                    }
                    return zza12;
                }
                throw new IllegalStateException(AbstractC2914a.k("Can't set property ", zza11.zzf(), " of ", zza10.zzf()));
            case 11:
                zzg.zza(zzbv.TYPEOF, 1, list);
                zzaq zza13 = zzhVar.zza(list.get(0));
                if (zza13 instanceof zzax) {
                    str2 = AdError.UNDEFINED_DOMAIN;
                } else if (zza13 instanceof zzag) {
                    str2 = "boolean";
                } else if (zza13 instanceof zzai) {
                    str2 = "number";
                } else if (zza13 instanceof zzas) {
                    str2 = "string";
                } else if (zza13 instanceof zzar) {
                    str2 = "function";
                } else if (!(zza13 instanceof zzat) && !(zza13 instanceof zzaj)) {
                    str2 = "object";
                } else {
                    throw new IllegalArgumentException(String.format("Unsupported value type %s in typeof", zza13));
                }
                return new zzas(str2);
            case 12:
                zzg.zza(zzbv.UNDEFINED, 0, list);
                return zzaq.zzc;
            case 13:
                zzg.zzb(zzbv.VAR, 1, list);
                Iterator<zzaq> it2 = list.iterator();
                while (it2.hasNext()) {
                    zzaq zza14 = zzhVar.zza(it2.next());
                    if (zza14 instanceof zzas) {
                        zzhVar.zza(zza14.zzf(), zzaq.zzc);
                    } else {
                        throw new IllegalArgumentException(AbstractC2914a.d("Expected string for var name. got ", zza14.getClass().getCanonicalName()));
                    }
                }
                return zzaq.zzc;
            default:
                return zza(str);
        }
    }
}
