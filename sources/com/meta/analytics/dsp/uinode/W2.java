package com.meta.analytics.dsp.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* loaded from: assets/audience_network.dex */
public final class W2 implements InterfaceC1179Gm {
    public static byte[] A08;
    public int A00;
    public int A01;
    public int A02;
    public C1178Gl[] A03;
    public final int A04;
    public final boolean A05;
    public final byte[] A06;
    public final C1178Gl[] A07;

    static {
        A01();
    }

    public static String A00(int i9, int i10, int i11) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i9, i9 + i10);
        for (int i12 = 0; i12 < copyOfRange.length; i12++) {
            copyOfRange[i12] = (byte) ((copyOfRange[i12] ^ i11) ^ 19);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A08 = new byte[]{100, 104, 40, 19, Ascii.CAN, 5, Ascii.CR, Ascii.CAN, Ascii.RS, 9, Ascii.CAN, Ascii.EM, 93, Ascii.FS, 17, 17, Ascii.DC2, Ascii.RS, Ascii.FS, 9, Ascii.DC4, Ascii.DC2, 19, 71, 93};
    }

    public W2(boolean z8, int i9) {
        this(z8, i9, 0);
    }

    public W2(boolean z8, int i9, int i10) {
        AbstractC1192Ha.A03(i9 > 0);
        AbstractC1192Ha.A03(i10 >= 0);
        this.A05 = z8;
        this.A04 = i9;
        this.A01 = i10;
        this.A03 = new C1178Gl[i10 + 100];
        if (i10 > 0) {
            this.A06 = new byte[i10 * i9];
            for (int i11 = 0; i11 < i10; i11++) {
                this.A03[i11] = new C1178Gl(this.A06, i11 * i9);
            }
        } else {
            this.A06 = null;
        }
        this.A07 = new C1178Gl[1];
    }

    public final synchronized int A02() {
        return this.A00 * this.A04;
    }

    public final synchronized void A03() {
        if (this.A05) {
            A04(0);
        }
    }

    public final synchronized void A04(int i9) {
        boolean targetBufferSizeReduced = i9 < this.A02;
        this.A02 = i9;
        if (targetBufferSizeReduced) {
            AGj();
        }
    }

    @Override // com.meta.analytics.dsp.uinode.InterfaceC1179Gm
    public final synchronized C1178Gl A3X() {
        C1178Gl c1178Gl;
        this.A00++;
        int i9 = this.A01;
        if (i9 > 0) {
            C1178Gl[] c1178GlArr = this.A03;
            int i10 = i9 - 1;
            this.A01 = i10;
            c1178Gl = c1178GlArr[i10];
            c1178GlArr[i10] = null;
        } else {
            c1178Gl = new C1178Gl(new byte[this.A04], 0);
        }
        return c1178Gl;
    }

    @Override // com.meta.analytics.dsp.uinode.InterfaceC1179Gm
    public final int A7D() {
        return this.A04;
    }

    @Override // com.meta.analytics.dsp.uinode.InterfaceC1179Gm
    public final synchronized void AEW(C1178Gl c1178Gl) {
        C1178Gl[] c1178GlArr = this.A07;
        c1178GlArr[0] = c1178Gl;
        AEX(c1178GlArr);
    }

    @Override // com.meta.analytics.dsp.uinode.InterfaceC1179Gm
    public final synchronized void AEX(C1178Gl[] c1178GlArr) {
        int i9 = this.A01;
        int length = c1178GlArr.length + i9;
        C1178Gl[] c1178GlArr2 = this.A03;
        if (length >= c1178GlArr2.length) {
            this.A03 = (C1178Gl[]) Arrays.copyOf(c1178GlArr2, Math.max(c1178GlArr2.length * 2, i9 + c1178GlArr.length));
        }
        for (C1178Gl c1178Gl : c1178GlArr) {
            if (c1178Gl.A01 == this.A06 || c1178Gl.A01.length == this.A04) {
                C1178Gl[] c1178GlArr3 = this.A03;
                int i10 = this.A01;
                this.A01 = i10 + 1;
                c1178GlArr3[i10] = c1178Gl;
            } else {
                throw new IllegalArgumentException(A00(2, 23, 110) + System.identityHashCode(c1178Gl.A01) + A00(0, 2, 91) + System.identityHashCode(this.A06) + A00(0, 2, 91) + c1178Gl.A01.length + A00(0, 2, 91) + this.A04);
            }
        }
        this.A00 -= c1178GlArr.length;
        notifyAll();
    }

    @Override // com.meta.analytics.dsp.uinode.InterfaceC1179Gm
    public final synchronized void AGj() {
        int A04 = IF.A04(this.A02, this.A04);
        int targetAllocationCount = this.A00;
        int highIndex = Math.max(0, A04 - targetAllocationCount);
        int targetAvailableCount = this.A01;
        if (highIndex >= targetAvailableCount) {
            return;
        }
        if (this.A06 != null) {
            int lowIndex = 0;
            int i9 = targetAvailableCount - 1;
            while (lowIndex <= i9) {
                C1178Gl highAllocation = this.A03[lowIndex];
                if (highAllocation.A01 == this.A06) {
                    lowIndex++;
                } else {
                    C1178Gl lowAllocation = this.A03[i9];
                    if (lowAllocation.A01 != this.A06) {
                        i9--;
                    } else {
                        C1178Gl[] c1178GlArr = this.A03;
                        c1178GlArr[lowIndex] = lowAllocation;
                        int targetAllocationCount2 = i9 - 1;
                        c1178GlArr[i9] = highAllocation;
                        i9 = targetAllocationCount2;
                        lowIndex++;
                    }
                }
            }
            highIndex = Math.max(highIndex, lowIndex);
            int targetAllocationCount3 = this.A01;
            if (highIndex >= targetAllocationCount3) {
                return;
            }
        }
        Arrays.fill(this.A03, highIndex, this.A01, (Object) null);
        this.A01 = highIndex;
    }
}
