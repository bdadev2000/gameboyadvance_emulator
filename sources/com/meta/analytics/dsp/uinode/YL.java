package com.meta.analytics.dsp.uinode;

import android.content.Context;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl;
import com.facebook.ads.internal.util.process.ProcessUtils;

/* loaded from: assets/audience_network.dex */
public final class YL implements InterfaceC09657h {
    public static YL A07;
    public static byte[] A08;
    public static String[] A09 = {"kZNWMB05A80rolZkZr5gINRkemJedumA", "PGnlsDLswmZGHAGkHnqyou4j", "CQczeQcoxNMNqPeDO5UPH4delPie3CF6", "Ozs7AQnIuhnl4TF488yhCLnc3lqg3Tqv", "QUMQF15y8F49TOv2Mbtf3pi6YRJU7tsl", "iRM3Hx3PCEqf", "8yEJzjy1AvS4vnL", "zEXAgd0MZ6iopjt"};
    public C0W A00;
    public InterfaceC09456g A01;
    public C7g A02;
    public InterfaceC09767w A03;
    public C09828c A04;
    public JE A05;
    public InterfaceC1201Hj A06;

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A06(int r4, int r5, int r6) {
        /*
            byte[] r1 = com.meta.analytics.dsp.uinode.YL.A08
            int r0 = r4 + r5
            byte[] r3 = java.util.Arrays.copyOfRange(r1, r4, r0)
            r4 = 0
        L9:
            int r5 = r3.length
            java.lang.String[] r2 = com.meta.analytics.dsp.uinode.YL.A09
            r0 = 6
            r1 = r2[r0]
            r0 = 7
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L22
        L1c:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L22:
            java.lang.String[] r2 = com.meta.analytics.dsp.uinode.YL.A09
            java.lang.String r1 = "Hv2WK1fJh7GnXaP"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "jwUFRNkRPBL5IaL"
            r0 = 7
            r2[r0] = r1
            if (r4 >= r5) goto L5c
            r5 = r3[r4]
            int r5 = r5 - r6
            java.lang.String[] r2 = com.meta.analytics.dsp.uinode.YL.A09
            r0 = 4
            r1 = r2[r0]
            r0 = 0
            r2 = r2[r0]
            r0 = 26
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L48
            goto L1c
        L48:
            java.lang.String[] r2 = com.meta.analytics.dsp.uinode.YL.A09
            java.lang.String r1 = "3jbuj6iR6sIerVLqEJ9xAsC0KuP7QrbG"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "qsuffxm3RCjhy50iWQEl04Txy4tWGAPw"
            r0 = 3
            r2[r0] = r1
            int r0 = r5 + (-98)
            byte r0 = (byte) r0
            r3[r4] = r0
            int r4 = r4 + 1
            goto L9
        L5c:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meta.analytics.dsp.uinode.YL.A06(int, int, int):java.lang.String");
    }

    public static void A07() {
        A08 = new byte[]{-62, -11, -55, -10, -13, -62, -63, -62, -16, 2, Ascii.DLE, Ascii.DLE, 6, Ascii.FF, Ascii.VT, -67, 1, -2, 17, -2, -67, 6, Ascii.VT, 6, 17, 6, -2, 9, 6, Ascii.ETB, 2, 1, 33, Ascii.DC4, Ascii.US, Ascii.RS, 33, 35, 2, Ascii.DC4, 34, 34, Ascii.CAN, Ascii.RS, Ascii.GS, -13, Ascii.DLE, 35, Ascii.DLE, -8, Ascii.GS, Ascii.CAN, 35, Ascii.CAN, Ascii.DLE, Ascii.ESC, Ascii.CAN, 41, Ascii.DC4, 19};
        if (A09[1].length() == 32) {
            throw new RuntimeException();
        }
        String[] strArr = A09;
        strArr[2] = "XQj6tBQR93KUWcmqG7acynHpkyXbPHo4";
        strArr[3] = "0fPU7ngiro1m2vFzwgFa3cBnolZ3o5pA";
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final synchronized void A0C(C1635Ym c1635Ym) {
        if (this.A06 != null) {
            return;
        }
        this.A03 = A01(c1635Ym);
        InterfaceC1201Hj A05 = A05(c1635Ym, this.A03, A03(c1635Ym));
        this.A06 = A05;
        A09(c1635Ym, A00(c1635Ym, A05));
        A0A(c1635Ym, this.A06);
        A0B(c1635Ym, this.A06);
        InterfaceC1201Hj interfaceC1201Hj = this.A06;
        if (interfaceC1201Hj != null) {
            interfaceC1201Hj.A5m();
        }
    }

    static {
        A07();
    }

    public static AnonymousClass66 A00(C1635Ym c1635Ym, InterfaceC1201Hj interfaceC1201Hj) {
        if (!C1225Ih.A1P(c1635Ym) || interfaceC1201Hj == null) {
            return null;
        }
        return AnonymousClass67.A00().A00(interfaceC1201Hj);
    }

    public static InterfaceC09767w A01(C1635Ym c1635Ym) {
        return AbstractC09777x.A00().A00(c1635Ym, new YS());
    }

    public static synchronized YL A02() {
        YL yl;
        synchronized (YL.class) {
            if (A07 == null) {
                A07 = new YL();
            }
            yl = A07;
        }
        return yl;
    }

    public static RK A03(C1635Ym c1635Ym) {
        if (!C1225Ih.A1L(c1635Ym)) {
            return null;
        }
        return C1447Rc.A01(c1635Ym);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.meta.analytics.dsp.uinode.InterfaceC09657h
    /* renamed from: A04, reason: merged with bridge method [inline-methods] */
    public final synchronized InterfaceC1201Hj A86() {
        return this.A06;
    }

    public static InterfaceC1201Hj A05(C1635Ym c1635Ym, InterfaceC09767w interfaceC09767w, RK rk) {
        if (C1225Ih.A2E(c1635Ym) && rk != null && !ProcessUtils.isRemoteRenderingProcess()) {
            return AbstractC1470Rz.A00().A00(c1635Ym, interfaceC09767w, rk, K9.A04(c1635Ym), new YM(new K1(c1635Ym, A06(0, 0, 122), null, EnumC1246Jg.A07, 0, new C1251Jl(), LW.A01(C1225Ih.A0J(c1635Ym)), null, null, new C1707aZ()), c1635Ym), C1468Rx.A00().A00());
        }
        return null;
    }

    public static void A08() {
        String A06 = A06(8, 24, 59);
        if (A09[5].length() == 20) {
            throw new RuntimeException();
        }
        A09[5] = "4ii3kc4oT9MJsiDOLfNQb5ib2";
        AbstractC1255Jp.A05(A06(32, 28, 77), A06, A06(0, 8, 46));
    }

    public static void A09(C1635Ym c1635Ym, AnonymousClass66 anonymousClass66) {
        if (!C1225Ih.A1P(c1635Ym) || anonymousClass66 == null) {
            return;
        }
        AnonymousClass64.A00().A00(anonymousClass66, c1635Ym);
    }

    public static void A0A(C1635Ym c1635Ym, InterfaceC1201Hj interfaceC1201Hj) {
        if (!C1225Ih.A0h(c1635Ym) || interfaceC1201Hj == null) {
            return;
        }
        new C6R(c1635Ym, interfaceC1201Hj, new C6S(), DynamicLoaderImpl.getBidderTokenProviderApi().A00());
    }

    public static void A0B(C1635Ym c1635Ym, InterfaceC1201Hj interfaceC1201Hj) {
        if (interfaceC1201Hj == null) {
            return;
        }
        AbstractC1228Il.A00(c1635Ym, interfaceC1201Hj);
    }

    @Override // com.meta.analytics.dsp.uinode.InterfaceC09657h
    public final J2 A5u(C1635Ym c1635Ym) {
        return VQ.A01(c1635Ym);
    }

    @Override // com.meta.analytics.dsp.uinode.InterfaceC09657h
    public final synchronized C7g A6A(C09647f c09647f) {
        if (this.A02 == null) {
            this.A02 = new YN(this);
        }
        return this.A02;
    }

    @Override // com.meta.analytics.dsp.uinode.InterfaceC09657h
    public final synchronized InterfaceC09456g A6L() {
        if (this.A01 == null) {
            this.A01 = new C1637Yo();
        }
        return this.A01;
    }

    @Override // com.meta.analytics.dsp.uinode.InterfaceC09657h
    public final synchronized InterfaceC09767w A6j(C09647f c09647f) {
        if (this.A03 == null) {
            this.A03 = A01(c09647f.A01());
        }
        return this.A03;
    }

    @Override // com.meta.analytics.dsp.uinode.InterfaceC09657h
    public final synchronized AnonymousClass89 A6l(C09647f c09647f) {
        return new C1624Yb(c09647f);
    }

    @Override // com.meta.analytics.dsp.uinode.InterfaceC09657h
    public final synchronized InterfaceC09667i A6v(C09647f c09647f) {
        return new EO(this, c09647f);
    }

    @Override // com.meta.analytics.dsp.uinode.InterfaceC09657h
    public final synchronized C0W A77(C09647f c09647f) {
        if (!C1225Ih.A0v(c09647f)) {
            return null;
        }
        if (this.A00 == null) {
            this.A00 = C0X.A00().A00(new YQ(c09647f));
        }
        return this.A00;
    }

    @Override // com.meta.analytics.dsp.uinode.InterfaceC09657h
    public final synchronized C7k A7q(C09647f c09647f) {
        return new YO(c09647f);
    }

    @Override // com.meta.analytics.dsp.uinode.InterfaceC09657h
    public final C1635Ym A7r(Context context) {
        C1635Ym sdkContext = AbstractC09637e.A00();
        if (sdkContext == null) {
            C1635Ym sdkContext2 = new C1635Ym(context, this);
            AbstractC09637e.A01(sdkContext2);
            return sdkContext2;
        }
        return sdkContext;
    }

    @Override // com.meta.analytics.dsp.uinode.InterfaceC09657h
    public final synchronized JE A7s(C1635Ym c1635Ym) {
        if (this.A05 == null) {
            this.A05 = new VY(c1635Ym);
        }
        return this.A05;
    }

    @Override // com.meta.analytics.dsp.uinode.InterfaceC09657h
    public final synchronized C09828c A7y() {
        if (this.A04 == null) {
            this.A04 = new C09828c();
            A08();
        }
        return this.A04;
    }
}
