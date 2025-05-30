package com.mbridge.msdk.playercommon.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class EventMessage implements Metadata.Entry {
    public static final Parcelable.Creator<EventMessage> CREATOR = new Parcelable.Creator<EventMessage>() { // from class: com.mbridge.msdk.playercommon.exoplayer2.metadata.emsg.EventMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EventMessage createFromParcel(Parcel parcel) {
            return new EventMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EventMessage[] newArray(int i9) {
            return new EventMessage[i9];
        }
    };
    public final long durationMs;
    private int hashCode;
    public final long id;
    public final byte[] messageData;
    public final long presentationTimeUs;
    public final String schemeIdUri;
    public final String value;

    public EventMessage(String str, String str2, long j7, long j9, byte[] bArr, long j10) {
        this.schemeIdUri = str;
        this.value = str2;
        this.durationMs = j7;
        this.id = j9;
        this.messageData = bArr;
        this.presentationTimeUs = j10;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || EventMessage.class != obj.getClass()) {
            return false;
        }
        EventMessage eventMessage = (EventMessage) obj;
        if (this.presentationTimeUs == eventMessage.presentationTimeUs && this.durationMs == eventMessage.durationMs && this.id == eventMessage.id && Util.areEqual(this.schemeIdUri, eventMessage.schemeIdUri) && Util.areEqual(this.value, eventMessage.value) && Arrays.equals(this.messageData, eventMessage.messageData)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i9;
        if (this.hashCode == 0) {
            String str = this.schemeIdUri;
            int i10 = 0;
            if (str != null) {
                i9 = str.hashCode();
            } else {
                i9 = 0;
            }
            int i11 = (527 + i9) * 31;
            String str2 = this.value;
            if (str2 != null) {
                i10 = str2.hashCode();
            }
            long j7 = this.presentationTimeUs;
            int i12 = (((i11 + i10) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31;
            long j9 = this.durationMs;
            int i13 = (i12 + ((int) (j9 ^ (j9 >>> 32)))) * 31;
            long j10 = this.id;
            this.hashCode = Arrays.hashCode(this.messageData) + ((i13 + ((int) (j10 ^ (j10 >>> 32)))) * 31);
        }
        return this.hashCode;
    }

    public final String toString() {
        return "EMSG: scheme=" + this.schemeIdUri + ", id=" + this.id + ", value=" + this.value;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(this.schemeIdUri);
        parcel.writeString(this.value);
        parcel.writeLong(this.presentationTimeUs);
        parcel.writeLong(this.durationMs);
        parcel.writeLong(this.id);
        parcel.writeByteArray(this.messageData);
    }

    public EventMessage(Parcel parcel) {
        this.schemeIdUri = parcel.readString();
        this.value = parcel.readString();
        this.presentationTimeUs = parcel.readLong();
        this.durationMs = parcel.readLong();
        this.id = parcel.readLong();
        this.messageData = parcel.createByteArray();
    }
}
