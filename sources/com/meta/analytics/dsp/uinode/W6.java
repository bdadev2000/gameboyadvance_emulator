package com.meta.analytics.dsp.uinode;

import android.util.Pair;
import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup;

/* loaded from: assets/audience_network.dex */
public abstract class W6 extends AbstractC1176Gj {
    public static String[] A01 = {"JXADnguvwbjBsYgslHoSHgr2xxMnawNn", "", "jNEAQ3UZ70aM1hHDYV2CS20ieNSkmYbb", "bnkACY5tQbsoiCdyBJgaOjSRI0w0kmrQ", "gVGuKveDeddXJzh5PaouiQlIwgfOoZnh", "qzMEUGGJ0FpDLYRljtzJ24rj8XT6rBKz", "LijUR", "ZVB7ZDT4TSe2rtQPBLBW6RwhtV59NTLq"};
    public C1171Ge A00;

    public abstract Pair<AB[], InterfaceC1173Gg[]> A0V(C1171Ge c1171Ge, int[][][] iArr, int[] iArr2) throws C10079c;

    /* JADX WARN: Incorrect condition in loop: B:3:0x0004 */
    /* JADX WARN: Incorrect condition in loop: B:6:0x000b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A0Q(com.meta.analytics.dsp.uinode.AA[] r6, com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup r7) throws com.meta.analytics.dsp.uinode.C10079c {
        /*
            int r5 = r6.length
            r4 = 0
            r3 = 0
        L3:
            int r0 = r6.length
            if (r3 >= r0) goto L25
            r2 = r6[r3]
            r1 = 0
        L9:
            int r0 = r7.A01
            if (r1 >= r0) goto L22
            com.facebook.ads.internal.exoplayer2.thirdparty.Format r0 = r7.A01(r1)
            int r0 = r2.AGe(r0)
            r0 = r0 & 7
            if (r0 <= r4) goto L1f
            r5 = r3
            r4 = r0
            r0 = 4
            if (r4 != r0) goto L1f
            return r5
        L1f:
            int r1 = r1 + 1
            goto L9
        L22:
            int r3 = r3 + 1
            goto L3
        L25:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meta.analytics.dsp.uinode.W6.A0Q(com.facebook.ads.redexgen.X.AA[], com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup):int");
    }

    public static int[] A0R(AA aa, TrackGroup trackGroup) throws C10079c {
        int[] iArr = new int[trackGroup.A01];
        for (int i9 = 0; i9 < trackGroup.A01; i9++) {
            iArr[i9] = aa.AGe(trackGroup.A01(i9));
        }
        return iArr;
    }

    public static int[] A0S(AA[] aaArr) throws C10079c {
        int[] iArr = new int[aaArr.length];
        for (int i9 = 0; i9 < iArr.length; i9++) {
            iArr[i9] = aaArr[i9].AGg();
        }
        return iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0065, code lost:
    
        if (r3 == r8) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0067, code lost:
    
        r2 = new int[r4.A01];
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008d, code lost:
    
        r8 = r13[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009b, code lost:
    
        if (com.meta.analytics.dsp.uinode.W6.A01[4].charAt(3) == 'u') goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009d, code lost:
    
        r2 = A0R(r8, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a2, code lost:
    
        com.meta.analytics.dsp.uinode.W6.A01[1] = "";
        r2 = A0R(r8, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008a, code lost:
    
        if (r3 == r8) goto L17;
     */
    @Override // com.meta.analytics.dsp.uinode.AbstractC1176Gj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.meta.analytics.dsp.uinode.C1177Gk A0T(com.meta.analytics.dsp.uinode.AA[] r13, com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray r14) throws com.meta.analytics.dsp.uinode.C10079c {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meta.analytics.dsp.uinode.W6.A0T(com.facebook.ads.redexgen.X.AA[], com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray):com.facebook.ads.redexgen.X.Gk");
    }

    @Override // com.meta.analytics.dsp.uinode.AbstractC1176Gj
    public final void A0U(Object obj) {
        this.A00 = (C1171Ge) obj;
    }
}
