package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public abstract class zzbhr extends zzbae implements zzbhs {
    public zzbhr() {
        super("com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    @Override // com.google.android.gms.internal.ads.zzbae
    public final boolean zzdF(int i9, Parcel parcel, Parcel parcel2, int i10) throws RemoteException {
        zzbjd zzbjdVar;
        switch (i9) {
            case 2:
                float zze = zze();
                parcel2.writeNoException();
                parcel2.writeFloat(zze);
                return true;
            case 3:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbaf.zzc(parcel);
                zzj(asInterface);
                parcel2.writeNoException();
                return true;
            case 4:
                IObjectWrapper zzi = zzi();
                parcel2.writeNoException();
                zzbaf.zzf(parcel2, zzi);
                return true;
            case 5:
                float zzg = zzg();
                parcel2.writeNoException();
                parcel2.writeFloat(zzg);
                return true;
            case 6:
                float zzf = zzf();
                parcel2.writeNoException();
                parcel2.writeFloat(zzf);
                return true;
            case 7:
                com.google.android.gms.ads.internal.client.zzdq zzh = zzh();
                parcel2.writeNoException();
                zzbaf.zzf(parcel2, zzh);
                return true;
            case 8:
                boolean zzl = zzl();
                parcel2.writeNoException();
                int i11 = zzbaf.zza;
                parcel2.writeInt(zzl ? 1 : 0);
                return true;
            case 9:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzbjdVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnMediaContentChangedListener");
                    if (queryLocalInterface instanceof zzbjd) {
                        zzbjdVar = (zzbjd) queryLocalInterface;
                    } else {
                        zzbjdVar = new zzbjd(readStrongBinder);
                    }
                }
                zzbaf.zzc(parcel);
                zzm(zzbjdVar);
                parcel2.writeNoException();
                return true;
            case 10:
                boolean zzk = zzk();
                parcel2.writeNoException();
                int i12 = zzbaf.zza;
                parcel2.writeInt(zzk ? 1 : 0);
                return true;
            default:
                return false;
        }
    }
}
