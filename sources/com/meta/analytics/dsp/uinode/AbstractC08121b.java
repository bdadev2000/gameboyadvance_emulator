package com.meta.analytics.dsp.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.1b, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC08121b {
    public static byte[] A00;
    public static String[] A01 = {"supQtyS8W3onVuHqEhPkAVSqBybkIcHU", "ff4vqjx7fpIi29JjE6r", "RJO08Ilt3bxePyobo0aBvpyFdtgNFIs", "R3lU2DY6GPkOKTyjngiZTwzyGAILDPw1", "PTr0crZaDt8NiWq0Xd4", "se", "v6JOSQzBecuGYHkCCuEqCb8OFKq6lcaT", "KM7IQOG2bb6CTRDJ7wtiRs"};

    public static String A02(int i9, int i10, int i11) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i9, i9 + i10);
        int i12 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A01[3].charAt(30) != 'w') {
                break;
            }
            A01[0] = "2ucutjIi0db0Y5lwkQhEiYj5DZ";
            if (i12 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i12] = (byte) ((copyOfRange[i12] - i11) - 90);
            if (A01[5].length() == 26) {
                break;
            }
            String[] strArr = A01;
            strArr[7] = "yFgBEeCsPvrqNYYpqLUckp";
            strArr[2] = "OqUlVlD6dU1uZ6pPsuYDm2OxFFgTM2s";
            i12++;
        }
        throw new RuntimeException();
    }

    public static void A0C() {
        A00 = new byte[]{Ascii.VT, 52, 55, 59, 45, -24, 9, 44, Ascii.VT, 55, 54, 60, 49, 54, 61, 45, -24, Ascii.US, 41, 60, 43, 48, 49, 54, 47, 2, 46, 45, 51, 40, 45, 52, 36, -33, 54, 32, 51, 34, 39, 40, 45, 38, -33, 51, 46, -33, 49, 36, 34, 36, 40, 53, 36, -33, 32, 45, -33, 40, 45, -20, 38, 32, 44, 36, -33, 49, 36, 54, 32, 49, 35, -2, 42, 41, 47, 36, 41, 48, 32, -37, 50, Ascii.FS, 47, Ascii.RS, 35, 36, 41, 34, -37, 47, 42, -37, 45, 32, Ascii.RS, 32, 36, 49, 32, -37, 54, 44, 48, Ascii.FS, 41, 47, 36, 47, 52, 56, 54, Ascii.RS, 48, 45, 45, 32, 41, Ascii.RS, 52, 56, -86, -53, -64, -55, -60, -55, -62, 123, -60, -55, 123, -74, -50, -64, -66, -50, -72, -50, -10, Ascii.ETB, Ascii.FF, Ascii.NAK, Ascii.DLE, Ascii.NAK, Ascii.SO, -57, Ascii.DLE, Ascii.NAK, -43, -43, -43, -32, -13, 5, -17, 0, -14, -82, -9, -4, -82, -23, 1, -13, -15, 1, -21, 1, 7, Ascii.US, Ascii.GS, 36, 8, 37, 36, 35, 40, 36, 39, Ascii.SUB, Ascii.EM, -51, -31, -32, -37, -49, -40, -43, -49, -41, -53, -43, -38, -53, -28, 52, 72, 71, 66, 54, 63, 60, 54, 62, 50, 66, 67, 56, 65, 60, 65, 58, -5, 4, 7, Ascii.VT, -3, -9, -7, -4, Ascii.NAK, 33, 32, 38, Ascii.ESC, 32, 39, Ascii.ETB, 17, 41, 19, 38, Ascii.NAK, Ascii.SUB, Ascii.ESC, 32, Ascii.EM, 54, 66, 65, 71, 60, 65, 72, 56, 50, 74, 52, 71, 54, 59, 60, 65, 58, 50, 57, 66, 69, 50, 69, 56, 74, 52, 69, 55, -33, -35, -26, -35, -22, -31, -37, -41, -22, -35, -17, -39, -22, -36, 9, 7, Ascii.DLE, 7, Ascii.DC4, Ascii.VT, 5, 1, Ascii.SYN, 7, Ascii.SUB, Ascii.SYN, 71, 58, 76, 54, 71, 57, 52, 62, 67, 52, 77, 70, 62, 60, 67, 5, 2, 1, 0, 5, 1, 4, -9, -10};
    }

    static {
        A0C();
    }

    public static C1X A00(JSONObject jSONObject) {
        return new C1W().A06(A08(jSONObject)).A07(A07(jSONObject)).A05(A09(jSONObject)).A04(A06(jSONObject)).A08();
    }

    public static C08171g A01(JSONObject jSONObject) {
        return new C08161f().A06(A0A(jSONObject)).A07(A0B(jSONObject)).A05(A05(jSONObject)).A04(A04(jSONObject)).A08();
    }

    public static String A03(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(A02(279, 12, 72));
        String A02 = A02(172, 9, 91);
        return optJSONObject == null ? A02 : optJSONObject.optString(A02(306, 9, 56), A02);
    }

    public static String A04(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(A02(279, 12, 72));
        String A02 = A02(120, 18, 1);
        return optJSONObject == null ? A02 : optJSONObject.optString(A02(181, 14, 18), A02);
    }

    public static String A05(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(A02(279, 12, 72));
        String A02 = A02(138, 13, 77);
        return optJSONObject == null ? A02 : optJSONObject.optString(A02(195, 17, 121), A02);
    }

    public static String A06(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(A02(279, 12, 72));
        String A02 = A02(0, 8, 110);
        return optJSONObject == null ? A02 : optJSONObject.optString(A02(212, 8, 62), A02);
    }

    public static String A07(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(A02(279, 12, 72));
        String A02 = A02(71, 49, 97);
        return optJSONObject == null ? A02 : optJSONObject.optString(A02(237, 28, 121), A02);
    }

    public static String A08(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(A02(279, 12, 72));
        String A02 = A02(25, 46, 101);
        return optJSONObject == null ? A02 : optJSONObject.optString(A02(265, 14, 30), A02);
    }

    public static String A09(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(A02(279, 12, 72));
        String A02 = A02(8, 17, 110);
        return optJSONObject == null ? A02 : optJSONObject.optString(A02(220, 17, 88), A02);
    }

    public static String A0A(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(A02(279, 12, 72));
        String A02 = A02(151, 17, 52);
        return optJSONObject == null ? A02 : optJSONObject.optString(A02(291, 11, 123), A02);
    }

    public static String A0B(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(A02(279, 12, 72));
        String A02 = A02(168, 4, 90);
        if (optJSONObject == null) {
            return A02;
        }
        if (A01[5].length() == 26) {
            throw new RuntimeException();
        }
        A01[6] = "TCZjzw6sPrB30puBIiA7RO8MkqmMxMbX";
        return optJSONObject.optString(A02(302, 4, 121), A02);
    }
}
