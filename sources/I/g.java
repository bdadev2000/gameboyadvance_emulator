package I;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class g {
    public static Intent a(Context context, @Nullable BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i9) {
        return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i9);
    }
}
