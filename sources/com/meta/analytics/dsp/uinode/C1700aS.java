package com.meta.analytics.dsp.uinode;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
import com.facebook.ads.S2SRewardedVideoAdExtendedListener;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.aS, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1700aS extends AbstractC08010q {
    public static byte[] A01;
    public static String[] A02 = {"7kSkrPID5YMo1WnvaMIgpKB6WIhQPZTc", "kYnVnFR0h3Yv", "", "4OZGrpocgzJPR2XOpe36kiptmUtlR1IY", "AELVZqmE3v", "ezzX0t3o6v3ClFiCUOYeN27kq8G", "mBbxV2ZqaJcWXY", "eL94qTtIFL"};
    public final /* synthetic */ C1698aQ A00;

    public static String A00(int i9, int i10, int i11) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i9, i9 + i10);
        for (int i12 = 0; i12 < copyOfRange.length; i12++) {
            copyOfRange[i12] = (byte) ((copyOfRange[i12] - i11) - 61);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-28, -13, -20, -53, -41, -42, -36, -38, -41, -44, -44, -51, -38, -120, -47, -37, -120, -42, -35, -44, -44};
    }

    static {
        A01();
    }

    public C1700aS(C1698aQ c1698aQ) {
        this.A00 = c1698aQ;
    }

    @Override // com.meta.analytics.dsp.uinode.AbstractC08010q
    public final void A06() {
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        s2SRewardedVideoAdExtendedListener = this.A00.A08;
        s2SRewardedVideoAdExtendedListener.onRewardServerFailed();
    }

    @Override // com.meta.analytics.dsp.uinode.AbstractC08010q
    public final void A07() {
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        s2SRewardedVideoAdExtendedListener = this.A00.A08;
        s2SRewardedVideoAdExtendedListener.onRewardServerSuccess();
    }

    @Override // com.meta.analytics.dsp.uinode.AbstractC08010q
    public final void A08() {
        RewardedVideoAd rewardedVideoAd;
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        rewardedVideoAd = this.A00.A03;
        if (rewardedVideoAd == null) {
            s2SRewardedVideoAdExtendedListener = this.A00.A08;
            s2SRewardedVideoAdExtendedListener.onRewardedVideoCompleted();
        }
    }

    @Override // com.meta.analytics.dsp.uinode.AbstractC08010q
    public final void A09() {
        RewardedVideoAd rewardedVideoAd;
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        rewardedVideoAd = this.A00.A03;
        if (rewardedVideoAd == null) {
            s2SRewardedVideoAdExtendedListener = this.A00.A08;
            s2SRewardedVideoAdExtendedListener.onRewardedVideoActivityDestroyed();
        }
    }

    @Override // com.meta.analytics.dsp.uinode.AbstractC08010q
    public final void A0A() {
        RewardedVideoAd rewardedVideoAd;
        RewardedVideoAd rewardedVideoAd2;
        long j7;
        RewardedVideoAd rewardedVideoAd3;
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        rewardedVideoAd = this.A00.A03;
        if (rewardedVideoAd != null) {
            rewardedVideoAd2 = this.A00.A03;
            C09385z c09385z = (C09385z) rewardedVideoAd2.buildShowAdConfig();
            long currentTimeMillis = System.currentTimeMillis();
            j7 = this.A00.A02;
            c09385z.A02(currentTimeMillis - j7);
            rewardedVideoAd3 = this.A00.A03;
            rewardedVideoAd3.show(c09385z.build());
            return;
        }
        s2SRewardedVideoAdExtendedListener = this.A00.A08;
        s2SRewardedVideoAdExtendedListener.onRewardedVideoClosed();
    }

    @Override // com.meta.analytics.dsp.uinode.AbstractC08010q
    public final void A0C() {
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        C2F c2f;
        this.A00.A07.A0E().A2j();
        s2SRewardedVideoAdExtendedListener = this.A00.A08;
        c2f = this.A00.A09;
        s2SRewardedVideoAdExtendedListener.onAdClicked(c2f.A00());
    }

    @Override // com.meta.analytics.dsp.uinode.AbstractC08010q
    public final void A0D() {
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        C2F c2f;
        s2SRewardedVideoAdExtendedListener = this.A00.A08;
        c2f = this.A00.A09;
        s2SRewardedVideoAdExtendedListener.onLoggingImpression(c2f.A00());
    }

    @Override // com.meta.analytics.dsp.uinode.AbstractC08010q
    public final void A0F(InterfaceC08000p interfaceC08000p) {
        FG fg;
        C2F c2f;
        C2F c2f2;
        FG fg2;
        C1F c1f;
        RewardedVideoAd rewardedVideoAd;
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        C2F c2f3;
        C1F c1f2;
        RewardedVideoAd rewardedVideoAd2;
        C1F c1f3;
        C2F c2f4;
        RewardedVideoAd rewardedVideoAd3;
        C1F c1f4;
        C2F c2f5;
        C2F c2f6;
        C2F c2f7;
        C1F c1f5;
        C2F c2f8;
        fg = this.A00.A05;
        if (fg == null) {
            this.A00.A07.A07().A9a(A00(0, 3, 70), C8A.A0N, new C8B(A00(3, 18, 43)));
            return;
        }
        AbstractC1743b9 abstractC1743b9 = (AbstractC1743b9) interfaceC08000p;
        c2f = this.A00.A09;
        if (c2f.A03 != null) {
            c2f8 = this.A00.A09;
            abstractC1743b9.A02(c2f8.A03);
        }
        c2f2 = this.A00.A09;
        int A0G = abstractC1743b9.A0G();
        String[] strArr = A02;
        if (strArr[4].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[4] = "61YjDYRNNN";
        strArr2[7] = "vT3ubuaNP5";
        c2f2.A00 = A0G;
        this.A00.A06 = true;
        C1698aQ c1698aQ = this.A00;
        fg2 = c1698aQ.A05;
        c1698aQ.A04 = fg2.A0G();
        c1f = this.A00.A04;
        if (c1f != null) {
            int i9 = 0;
            c1f4 = this.A00.A04;
            if (!c1f4.A0j()) {
                c1f5 = this.A00.A04;
                i9 = ((AbstractC1739b5) c1f5).A0v();
            }
            if (i9 > 0) {
                C1288Kz c1288Kz = new C1288Kz();
                C1636Yn c1636Yn = this.A00.A07;
                c2f5 = this.A00.A09;
                if (c1288Kz.A09(c1636Yn, c2f5.A06, i9)) {
                    c1288Kz.A08(this.A00.A07, true);
                    C1698aQ c1698aQ2 = this.A00;
                    C1636Yn c1636Yn2 = c1698aQ2.A07;
                    c2f6 = this.A00.A09;
                    String str = c2f6.A0D;
                    c2f7 = this.A00.A09;
                    c1698aQ2.A03 = c1288Kz.A07(c1636Yn2, str, c2f7.A06);
                } else {
                    C1698aQ c1698aQ3 = this.A00;
                    String[] strArr3 = A02;
                    if (strArr3[4].length() != strArr3[7].length()) {
                        String[] strArr4 = A02;
                        strArr4[4] = "df15N9yr5s";
                        strArr4[7] = "rrfEFjVt4q";
                        c1288Kz.A08(c1698aQ3.A07, false);
                    } else {
                        String[] strArr5 = A02;
                        strArr5[1] = "7AaEv1vCH3bw";
                        strArr5[5] = "Y1uo0lYkjhkOAjcvNvodbhiOq3C";
                        c1288Kz.A08(c1698aQ3.A07, false);
                    }
                }
            }
        }
        rewardedVideoAd = this.A00.A03;
        if (rewardedVideoAd == null) {
            s2SRewardedVideoAdExtendedListener = this.A00.A08;
            c2f3 = this.A00.A09;
            s2SRewardedVideoAdExtendedListener.onAdLoaded(c2f3.A00());
            return;
        }
        c1f2 = this.A00.A04;
        ((AbstractC1739b5) c1f2).A17(true);
        rewardedVideoAd2 = this.A00.A03;
        RewardedVideoAd.RewardedVideoAdLoadConfigBuilder withFailOnCacheFailureEnabled = rewardedVideoAd2.buildLoadAdConfig().withFailOnCacheFailureEnabled(true);
        c1f3 = this.A00.A04;
        RewardedVideoAd.RewardedVideoAdLoadConfigBuilder withRewardData = withFailOnCacheFailureEnabled.withRewardData(c1f3.A0J());
        c2f4 = this.A00.A09;
        RewardedVideoAd.RewardedVideoLoadAdConfig loadAdConfig = withRewardData.withAdExperience(c2f4.A02).withAdListener(new RewardedVideoAdListener() { // from class: com.facebook.ads.redexgen.X.25
            @Override // com.facebook.ads.AdListener
            public final void onAdClicked(Ad ad) {
            }

            @Override // com.facebook.ads.AdListener
            public final void onAdLoaded(Ad ad) {
                S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener2;
                C2F c2f9;
                s2SRewardedVideoAdExtendedListener2 = C1700aS.this.A00.A08;
                c2f9 = C1700aS.this.A00.A09;
                s2SRewardedVideoAdExtendedListener2.onAdLoaded(c2f9.A00());
            }

            @Override // com.facebook.ads.AdListener
            public final void onError(Ad ad, AdError adError) {
                C1F c1f6;
                S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener2;
                C2F c2f9;
                C1700aS.this.A00.A03 = null;
                c1f6 = C1700aS.this.A00.A04;
                ((AbstractC1739b5) c1f6).A17(false);
                s2SRewardedVideoAdExtendedListener2 = C1700aS.this.A00.A08;
                c2f9 = C1700aS.this.A00.A09;
                s2SRewardedVideoAdExtendedListener2.onAdLoaded(c2f9.A00());
            }

            @Override // com.facebook.ads.AdListener
            public final void onLoggingImpression(Ad ad) {
            }

            @Override // com.facebook.ads.RewardedVideoAdListener
            public final void onRewardedVideoClosed() {
                S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener2;
                s2SRewardedVideoAdExtendedListener2 = C1700aS.this.A00.A08;
                s2SRewardedVideoAdExtendedListener2.onRewardedVideoClosed();
            }

            @Override // com.facebook.ads.RewardedVideoAdListener
            public final void onRewardedVideoCompleted() {
                S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener2;
                s2SRewardedVideoAdExtendedListener2 = C1700aS.this.A00.A08;
                s2SRewardedVideoAdExtendedListener2.onRewardedVideoCompleted();
            }
        }).build();
        rewardedVideoAd3 = this.A00.A03;
        rewardedVideoAd3.loadAd(loadAdConfig);
    }

    @Override // com.meta.analytics.dsp.uinode.AbstractC08010q
    public final void A0G(C1242Jb c1242Jb) {
        C2F c2f;
        long j7;
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        C2F c2f2;
        this.A00.A0D(true);
        c2f = this.A00.A09;
        C0S A0E = c2f.A0B.A0E();
        j7 = this.A00.A01;
        A0E.A2m(C1294Lf.A01(j7), c1242Jb.A03().getErrorCode(), c1242Jb.A04());
        s2SRewardedVideoAdExtendedListener = this.A00.A08;
        c2f2 = this.A00.A09;
        s2SRewardedVideoAdExtendedListener.onError(c2f2.A00(), L1.A00(c1242Jb));
    }
}
