package com.mbridge.msdk.playercommon.exoplayer2.extractor;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class ChunkIndex implements SeekMap {
    private final long durationUs;
    public final long[] durationsUs;
    public final int length;
    public final long[] offsets;
    public final int[] sizes;
    public final long[] timesUs;

    public ChunkIndex(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.sizes = iArr;
        this.offsets = jArr;
        this.durationsUs = jArr2;
        this.timesUs = jArr3;
        int length = iArr.length;
        this.length = length;
        if (length > 0) {
            this.durationUs = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.durationUs = 0L;
        }
    }

    public final int getChunkIndex(long j7) {
        return Util.binarySearchFloor(this.timesUs, j7, true, true);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public final long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public final SeekMap.SeekPoints getSeekPoints(long j7) {
        int chunkIndex = getChunkIndex(j7);
        SeekPoint seekPoint = new SeekPoint(this.timesUs[chunkIndex], this.offsets[chunkIndex]);
        if (seekPoint.timeUs < j7 && chunkIndex != this.length - 1) {
            int i9 = chunkIndex + 1;
            return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.timesUs[i9], this.offsets[i9]));
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public final boolean isSeekable() {
        return true;
    }

    public final String toString() {
        return "ChunkIndex(length=" + this.length + ", sizes=" + Arrays.toString(this.sizes) + ", offsets=" + Arrays.toString(this.offsets) + ", timeUs=" + Arrays.toString(this.timesUs) + ", durationsUs=" + Arrays.toString(this.durationsUs) + ")";
    }
}
