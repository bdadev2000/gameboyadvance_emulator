package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.os.Bundle;

/* renamed from: androidx.core.app.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0424z {
    public static boolean a(RemoteInput remoteInput) {
        return remoteInput.getAllowFreeFormInput();
    }

    public static CharSequence[] b(RemoteInput remoteInput) {
        return remoteInput.getChoices();
    }

    public static Bundle c(Notification.Action action) {
        return action.getExtras();
    }

    public static Bundle d(RemoteInput remoteInput) {
        return remoteInput.getExtras();
    }

    public static String e(Notification notification) {
        return notification.getGroup();
    }

    public static CharSequence f(RemoteInput remoteInput) {
        return remoteInput.getLabel();
    }

    public static RemoteInput[] g(Notification.Action action) {
        return action.getRemoteInputs();
    }

    public static String h(RemoteInput remoteInput) {
        return remoteInput.getResultKey();
    }

    public static String i(Notification notification) {
        return notification.getSortKey();
    }
}
