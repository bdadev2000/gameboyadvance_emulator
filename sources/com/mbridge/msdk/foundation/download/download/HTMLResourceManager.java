package com.mbridge.msdk.foundation.download.download;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.d;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ao;
import java.io.File;

/* loaded from: classes3.dex */
public class HTMLResourceManager {
    public static final int EXPIRE_TIME = 259200000;
    private static final String TAG = "HTMLResourceManager";
    private String mFileSaveSDDir;

    /* loaded from: classes3.dex */
    public static class ResourceManagerHolder {
        public static HTMLResourceManager instance = new HTMLResourceManager();

        private ResourceManagerHolder() {
        }
    }

    public static HTMLResourceManager getInstance() {
        return ResourceManagerHolder.instance;
    }

    public void cleanHtmlRes() {
        try {
            if (!TextUtils.isEmpty(this.mFileSaveSDDir)) {
                DownloadTask.getInstance().runTask(new a() { // from class: com.mbridge.msdk.foundation.download.download.HTMLResourceManager.1
                    @Override // com.mbridge.msdk.foundation.same.e.a
                    public void cancelTask() {
                    }

                    @Override // com.mbridge.msdk.foundation.same.e.a
                    public void pauseTask(boolean z8) {
                    }

                    @Override // com.mbridge.msdk.foundation.same.e.a
                    public void runTask() {
                        ab.a(HTMLResourceManager.this.mFileSaveSDDir);
                    }
                });
            }
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
        }
    }

    public String getHtmlContentFromUrl(String str) {
        try {
            File file = new File(this.mFileSaveSDDir + "/" + SameMD5.getMD5(ao.b(str)) + ".html");
            if (file.exists()) {
                return ab.b(file);
            }
            return null;
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public String getHtmlPathFromUrl(String str) {
        try {
            String str2 = this.mFileSaveSDDir + "/" + SameMD5.getMD5(ao.b(str)) + ".html";
            File file = new File(str2);
            if (file.exists()) {
                g b = h.a().b(c.m().k());
                if (b != null && !TextUtils.isEmpty(b.T())) {
                    d.a(str, file);
                }
                return "file:////" + str2;
            }
            return null;
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public void init() {
        this.mFileSaveSDDir = e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML);
    }

    public boolean saveResHtmlFile(String str, byte[] bArr) {
        try {
            ad.c(TAG, "saveResHtmlFile url:" + str);
            if (bArr != null && bArr.length > 0) {
                String str2 = this.mFileSaveSDDir + "/" + SameMD5.getMD5(ao.b(str)) + ".html";
                ad.c(TAG, "saveResHtmlFile folderName:" + str2);
                if (ab.a(bArr, new File(str2))) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception e4) {
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
                return false;
            }
            return false;
        }
    }

    private HTMLResourceManager() {
        init();
    }
}
