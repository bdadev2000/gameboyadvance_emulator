package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzab implements Parcelable.Creator<zzaa> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzaa createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Status status = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(readHeader) != 1) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                status = (Status) SafeParcelReader.createParcelable(parcel, readHeader, Status.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzaa(status);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzaa[] newArray(int i9) {
        return new zzaa[i9];
    }
}
