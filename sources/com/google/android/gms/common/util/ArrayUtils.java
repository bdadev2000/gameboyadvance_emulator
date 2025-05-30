package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

@KeepForSdk
/* loaded from: classes2.dex */
public final class ArrayUtils {
    private ArrayUtils() {
    }

    @NonNull
    @KeepForSdk
    public static <T> T[] concat(@NonNull T[]... tArr) {
        if (tArr.length != 0) {
            int i9 = 0;
            for (T[] tArr2 : tArr) {
                i9 += tArr2.length;
            }
            T[] tArr3 = (T[]) Arrays.copyOf(tArr[0], i9);
            int length = tArr[0].length;
            for (int i10 = 1; i10 < tArr.length; i10++) {
                T[] tArr4 = tArr[i10];
                int length2 = tArr4.length;
                System.arraycopy(tArr4, 0, tArr3, length, length2);
                length += length2;
            }
            return tArr3;
        }
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass(), 0));
    }

    @NonNull
    @KeepForSdk
    public static byte[] concatByteArrays(@NonNull byte[]... bArr) {
        if (bArr.length != 0) {
            int i9 = 0;
            for (byte[] bArr2 : bArr) {
                i9 += bArr2.length;
            }
            byte[] copyOf = Arrays.copyOf(bArr[0], i9);
            int length = bArr[0].length;
            for (int i10 = 1; i10 < bArr.length; i10++) {
                byte[] bArr3 = bArr[i10];
                int length2 = bArr3.length;
                System.arraycopy(bArr3, 0, copyOf, length, length2);
                length += length2;
            }
            return copyOf;
        }
        return new byte[0];
    }

    @KeepForSdk
    public static boolean contains(@Nullable int[] iArr, int i9) {
        if (iArr != null) {
            for (int i10 : iArr) {
                if (i10 == i9) {
                    return true;
                }
            }
        }
        return false;
    }

    @NonNull
    @KeepForSdk
    public static <T> ArrayList<T> newArrayList() {
        return new ArrayList<>();
    }

    @Nullable
    @KeepForSdk
    public static <T> T[] removeAll(@NonNull T[] tArr, @NonNull T... tArr2) {
        int length;
        int i9;
        if (tArr == null) {
            return null;
        }
        if (tArr2 != null && (length = tArr2.length) != 0) {
            Class<?> cls = tArr2.getClass();
            T[] tArr3 = (T[]) ((Object[]) Array.newInstance(cls.getComponentType(), tArr.length));
            if (length == 1) {
                i9 = 0;
                for (T t9 : tArr) {
                    if (!Objects.equal(tArr2[0], t9)) {
                        tArr3[i9] = t9;
                        i9++;
                    }
                }
            } else {
                int i10 = 0;
                for (T t10 : tArr) {
                    if (!contains(tArr2, t10)) {
                        tArr3[i10] = t10;
                        i10++;
                    }
                }
                i9 = i10;
            }
            if (tArr3 == null) {
                return null;
            }
            if (i9 == tArr3.length) {
                return tArr3;
            }
            return (T[]) Arrays.copyOf(tArr3, i9);
        }
        return (T[]) Arrays.copyOf(tArr, tArr.length);
    }

    @NonNull
    @KeepForSdk
    public static <T> ArrayList<T> toArrayList(@NonNull T[] tArr) {
        ArrayList<T> arrayList = new ArrayList<>(tArr.length);
        for (T t9 : tArr) {
            arrayList.add(t9);
        }
        return arrayList;
    }

    @NonNull
    @KeepForSdk
    public static int[] toPrimitiveArray(@Nullable Collection<Integer> collection) {
        int i9 = 0;
        if (collection != null && !collection.isEmpty()) {
            int[] iArr = new int[collection.size()];
            Iterator<Integer> it = collection.iterator();
            while (it.hasNext()) {
                iArr[i9] = it.next().intValue();
                i9++;
            }
            return iArr;
        }
        return new int[0];
    }

    @Nullable
    @KeepForSdk
    public static Integer[] toWrapperArray(@Nullable int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        Integer[] numArr = new Integer[length];
        for (int i9 = 0; i9 < length; i9++) {
            numArr[i9] = Integer.valueOf(iArr[i9]);
        }
        return numArr;
    }

    @KeepForSdk
    public static void writeArray(@NonNull StringBuilder sb, @NonNull double[] dArr) {
        int length = dArr.length;
        for (int i9 = 0; i9 < length; i9++) {
            if (i9 != 0) {
                sb.append(",");
            }
            sb.append(dArr[i9]);
        }
    }

    @KeepForSdk
    public static void writeStringArray(@NonNull StringBuilder sb, @NonNull String[] strArr) {
        int length = strArr.length;
        for (int i9 = 0; i9 < length; i9++) {
            if (i9 != 0) {
                sb.append(",");
            }
            sb.append("\"");
            sb.append(strArr[i9]);
            sb.append("\"");
        }
    }

    @KeepForSdk
    public static <T> boolean contains(@NonNull T[] tArr, @Nullable T t9) {
        int length = tArr != null ? tArr.length : 0;
        int i9 = 0;
        while (true) {
            if (i9 >= length) {
                break;
            }
            if (!Objects.equal(tArr[i9], t9)) {
                i9++;
            } else if (i9 >= 0) {
                return true;
            }
        }
        return false;
    }

    @KeepForSdk
    public static void writeArray(@NonNull StringBuilder sb, @NonNull float[] fArr) {
        int length = fArr.length;
        for (int i9 = 0; i9 < length; i9++) {
            if (i9 != 0) {
                sb.append(",");
            }
            sb.append(fArr[i9]);
        }
    }

    @KeepForSdk
    public static void writeArray(@NonNull StringBuilder sb, @NonNull int[] iArr) {
        int length = iArr.length;
        for (int i9 = 0; i9 < length; i9++) {
            if (i9 != 0) {
                sb.append(",");
            }
            sb.append(iArr[i9]);
        }
    }

    @KeepForSdk
    public static void writeArray(@NonNull StringBuilder sb, @NonNull long[] jArr) {
        int length = jArr.length;
        for (int i9 = 0; i9 < length; i9++) {
            if (i9 != 0) {
                sb.append(",");
            }
            sb.append(jArr[i9]);
        }
    }

    @KeepForSdk
    public static <T> void writeArray(@NonNull StringBuilder sb, @NonNull T[] tArr) {
        int length = tArr.length;
        for (int i9 = 0; i9 < length; i9++) {
            if (i9 != 0) {
                sb.append(",");
            }
            sb.append(tArr[i9]);
        }
    }

    @KeepForSdk
    public static void writeArray(@NonNull StringBuilder sb, @NonNull boolean[] zArr) {
        int length = zArr.length;
        for (int i9 = 0; i9 < length; i9++) {
            if (i9 != 0) {
                sb.append(",");
            }
            sb.append(zArr[i9]);
        }
    }
}
