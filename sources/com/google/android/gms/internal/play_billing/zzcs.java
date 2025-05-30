package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzcn;
import com.google.android.gms.internal.play_billing.zzcs;
import com.mbridge.msdk.foundation.entity.o;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public abstract class zzcs<MessageType extends zzcs<MessageType, BuilderType>, BuilderType extends zzcn<MessageType, BuilderType>> extends zzay<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzfg zzc = zzfg.zzc();

    public static zzcs zzj(Class cls) {
        Map map = zzb;
        zzcs zzcsVar = (zzcs) map.get(cls);
        if (zzcsVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzcsVar = (zzcs) map.get(cls);
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException("Class initialization cannot fail.", e4);
            }
        }
        if (zzcsVar == null) {
            zzcsVar = (zzcs) ((zzcs) zzfp.zze(cls)).zzx(6, null, null);
            if (zzcsVar != null) {
                map.put(cls, zzcsVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzcsVar;
    }

    public static zzcs zzm(zzcs zzcsVar, byte[] bArr, zzcd zzcdVar) throws zzdc {
        zzcs zzz = zzz(zzcsVar, bArr, 0, bArr.length, zzcdVar);
        if (zzz != null && !zzz.zzk()) {
            zzdc zza = new zzfe(zzz).zza();
            zza.zzf(zzz);
            throw zza;
        }
        return zzz;
    }

    public static zzcx zzn() {
        return zzct.zzf();
    }

    public static zzcz zzo() {
        return zzem.zze();
    }

    public static Object zzp(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e4);
        } catch (InvocationTargetException e9) {
            Throwable cause = e9.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    public static Object zzq(zzec zzecVar, String str, Object[] objArr) {
        return new zzen(zzecVar, str, objArr);
    }

    public static void zzt(Class cls, zzcs zzcsVar) {
        zzcsVar.zzs();
        zzb.put(cls, zzcsVar);
    }

    public static final boolean zzv(zzcs zzcsVar, boolean z8) {
        zzcs zzcsVar2;
        byte byteValue = ((Byte) zzcsVar.zzx(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzel.zza().zzb(zzcsVar.getClass()).zzk(zzcsVar);
        if (z8) {
            if (true != zzk) {
                zzcsVar2 = null;
            } else {
                zzcsVar2 = zzcsVar;
            }
            zzcsVar.zzx(2, zzcsVar2, null);
        }
        return zzk;
    }

    private final int zzy(zzeo zzeoVar) {
        return zzel.zza().zzb(getClass()).zza(this);
    }

    private static zzcs zzz(zzcs zzcsVar, byte[] bArr, int i9, int i10, zzcd zzcdVar) throws zzdc {
        if (i10 == 0) {
            return zzcsVar;
        }
        zzcs zzl = zzcsVar.zzl();
        try {
            zzeo zzb2 = zzel.zza().zzb(zzl.getClass());
            zzb2.zzh(zzl, bArr, 0, i10, new zzbc(zzcdVar));
            zzb2.zzf(zzl);
            return zzl;
        } catch (zzdc e4) {
            e4.zzf(zzl);
            throw e4;
        } catch (zzfe e9) {
            zzdc zza = e9.zza();
            zza.zzf(zzl);
            throw zza;
        } catch (IOException e10) {
            if (e10.getCause() instanceof zzdc) {
                throw ((zzdc) e10.getCause());
            }
            zzdc zzdcVar = new zzdc(e10);
            zzdcVar.zzf(zzl);
            throw zzdcVar;
        } catch (IndexOutOfBoundsException unused) {
            zzdc zzg = zzdc.zzg();
            zzg.zzf(zzl);
            throw zzg;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzel.zza().zzb(getClass()).zzj(this, (zzcs) obj);
    }

    public final int hashCode() {
        if (!zzw()) {
            int i9 = this.zza;
            if (i9 == 0) {
                int zzd = zzd();
                this.zza = zzd;
                return zzd;
            }
            return i9;
        }
        return zzd();
    }

    public final String toString() {
        return zzee.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.play_billing.zzec
    public final /* synthetic */ zzeb zzE() {
        return (zzcn) zzx(5, null, null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzec
    public final /* synthetic */ zzeb zzF() {
        zzcn zzcnVar = (zzcn) zzx(5, null, null);
        zzcnVar.zzc(this);
        return zzcnVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzay
    public final int zza(zzeo zzeoVar) {
        if (zzw()) {
            int zza = zzeoVar.zza(this);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException(o.h(zza, "serialized size must be non-negative, was "));
        }
        int i9 = this.zzd & Integer.MAX_VALUE;
        if (i9 == Integer.MAX_VALUE) {
            int zza2 = zzeoVar.zza(this);
            if (zza2 >= 0) {
                this.zzd = (this.zzd & Integer.MIN_VALUE) | zza2;
                return zza2;
            }
            throw new IllegalStateException(o.h(zza2, "serialized size must be non-negative, was "));
        }
        return i9;
    }

    public final int zzd() {
        return zzel.zza().zzb(getClass()).zzb(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzec
    public final void zze(zzby zzbyVar) throws IOException {
        zzel.zza().zzb(getClass()).zzi(this, zzbz.zza(zzbyVar));
    }

    @Override // com.google.android.gms.internal.play_billing.zzec
    public final int zzf() {
        int i9;
        if (zzw()) {
            i9 = zzy(null);
            if (i9 < 0) {
                throw new IllegalStateException(o.h(i9, "serialized size must be non-negative, was "));
            }
        } else {
            i9 = this.zzd & Integer.MAX_VALUE;
            if (i9 == Integer.MAX_VALUE) {
                i9 = zzy(null);
                if (i9 >= 0) {
                    this.zzd = (this.zzd & Integer.MIN_VALUE) | i9;
                } else {
                    throw new IllegalStateException(o.h(i9, "serialized size must be non-negative, was "));
                }
            }
        }
        return i9;
    }

    public final zzcn zzg() {
        return (zzcn) zzx(5, null, null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzed
    public final /* synthetic */ zzec zzh() {
        return (zzcs) zzx(6, null, null);
    }

    public final zzcn zzi() {
        zzcn zzcnVar = (zzcn) zzx(5, null, null);
        zzcnVar.zzc(this);
        return zzcnVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzed
    public final boolean zzk() {
        return zzv(this, true);
    }

    public final zzcs zzl() {
        return (zzcs) zzx(4, null, null);
    }

    public final void zzr() {
        zzel.zza().zzb(getClass()).zzf(this);
        zzs();
    }

    public final void zzs() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final void zzu(int i9) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final boolean zzw() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public abstract Object zzx(int i9, Object obj, Object obj2);
}
