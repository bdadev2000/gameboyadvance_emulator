package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public abstract class zzbvf extends zzbae implements zzbvg {
    public zzbvf() {
        super("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public static zzbvg zzI(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        if (queryLocalInterface instanceof zzbvg) {
            return (zzbvg) queryLocalInterface;
        }
        return new zzbve(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzbae
    public final boolean zzdF(int i9, Parcel parcel, Parcel parcel2, int i10) throws RemoteException {
        switch (i9) {
            case 1:
                Bundle bundle = (Bundle) zzbaf.zza(parcel, Bundle.CREATOR);
                zzbaf.zzc(parcel);
                zzl(bundle);
                parcel2.writeNoException();
                return true;
            case 2:
                parcel2.writeNoException();
                return true;
            case 3:
                zzt();
                parcel2.writeNoException();
                return true;
            case 4:
                zzr();
                parcel2.writeNoException();
                return true;
            case 5:
                zzo();
                parcel2.writeNoException();
                return true;
            case 6:
                Bundle bundle2 = (Bundle) zzbaf.zza(parcel, Bundle.CREATOR);
                zzbaf.zzc(parcel);
                zzs(bundle2);
                parcel2.writeNoException();
                zzbaf.zze(parcel2, bundle2);
                return true;
            case 7:
                zzu();
                parcel2.writeNoException();
                return true;
            case 8:
                zzm();
                parcel2.writeNoException();
                return true;
            case 9:
                zzx();
                parcel2.writeNoException();
                return true;
            case 10:
                zzi();
                parcel2.writeNoException();
                return true;
            case 11:
                boolean zzH = zzH();
                parcel2.writeNoException();
                int i11 = zzbaf.zza;
                parcel2.writeInt(zzH ? 1 : 0);
                return true;
            case 12:
                parcel.readInt();
                parcel.readInt();
                zzbaf.zzc(parcel);
                parcel2.writeNoException();
                return true;
            case 13:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbaf.zzc(parcel);
                zzk(asInterface);
                parcel2.writeNoException();
                return true;
            case 14:
                zzv();
                parcel2.writeNoException();
                return true;
            case 15:
                int readInt = parcel.readInt();
                String[] createStringArray = parcel.createStringArray();
                int[] createIntArray = parcel.createIntArray();
                zzbaf.zzc(parcel);
                zzp(readInt, createStringArray, createIntArray);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
