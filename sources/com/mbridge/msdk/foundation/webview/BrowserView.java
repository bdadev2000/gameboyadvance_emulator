package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.z;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class BrowserView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private CampaignEx f16112a;
    private String b;

    /* renamed from: c, reason: collision with root package name */
    private a f16113c;

    /* renamed from: d, reason: collision with root package name */
    private WebView f16114d;

    /* renamed from: e, reason: collision with root package name */
    private ProgressBar f16115e;

    /* renamed from: f, reason: collision with root package name */
    private ToolBar f16116f;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void a(WebView webView, int i9, String str, String str2);

        void a(WebView webView, String str);

        void a(WebView webView, String str, Bitmap bitmap);

        boolean b(WebView webView, String str);

        void c(WebView webView, String str);
    }

    public BrowserView(Context context, CampaignEx campaignEx) {
        super(context);
        this.f16112a = campaignEx;
        init();
    }

    public void destroy() {
        WebView webView = this.f16114d;
        if (webView != null) {
            webView.stopLoading();
            this.f16114d.setWebViewClient(null);
            this.f16114d.destroy();
            this.f16114d = null;
            removeAllViews();
        }
    }

    public void init() {
        setOrientation(1);
        setGravity(17);
        ProgressBar progressBar = new ProgressBar(getContext());
        this.f16115e = progressBar;
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(-1, 4));
        try {
            if (this.f16114d == null) {
                this.f16114d = a();
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            this.f16114d.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            ad.b("BrowserView", "webview is error", th);
        }
        this.f16116f = new ToolBar(getContext());
        this.f16116f.setLayoutParams(new LinearLayout.LayoutParams(-1, ai.a(getContext(), 40.0f)));
        this.f16116f.setBackgroundColor(-1);
        addView(this.f16115e);
        WebView webView = this.f16114d;
        if (webView != null) {
            addView(webView);
        }
        addView(this.f16116f);
        this.f16115e.initResource(true);
        this.f16116f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.BACKWARD).setEnabled(false);
        this.f16116f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.FORWARD).setEnabled(false);
        this.f16116f.setOnItemClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                boolean z8;
                if (BrowserView.this.f16114d != null) {
                    BrowserView.this.f16114d.stopLoading();
                }
                String str = (String) view.getTag();
                boolean z9 = false;
                if (TextUtils.equals(str, com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.BACKWARD)) {
                    BrowserView.this.f16116f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.FORWARD).setEnabled(true);
                    if (BrowserView.this.f16114d != null && BrowserView.this.f16114d.canGoBack()) {
                        BrowserView.this.f16114d.goBack();
                    }
                    View item = BrowserView.this.f16116f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.BACKWARD);
                    if (BrowserView.this.f16114d != null && BrowserView.this.f16114d.canGoBack()) {
                        z9 = true;
                    }
                    item.setEnabled(z9);
                    return;
                }
                if (TextUtils.equals(str, com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.FORWARD)) {
                    BrowserView.this.f16116f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.BACKWARD).setEnabled(true);
                    if (BrowserView.this.f16114d != null && BrowserView.this.f16114d.canGoForward()) {
                        BrowserView.this.f16114d.goForward();
                    }
                    View item2 = BrowserView.this.f16116f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.FORWARD);
                    if (BrowserView.this.f16114d != null && BrowserView.this.f16114d.canGoForward()) {
                        z9 = true;
                    }
                    item2.setEnabled(z9);
                    return;
                }
                if (TextUtils.equals(str, com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.REFRESH)) {
                    View item3 = BrowserView.this.f16116f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.BACKWARD);
                    if (BrowserView.this.f16114d != null && BrowserView.this.f16114d.canGoBack()) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    item3.setEnabled(z8);
                    View item4 = BrowserView.this.f16116f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.FORWARD);
                    if (BrowserView.this.f16114d != null && BrowserView.this.f16114d.canGoForward()) {
                        z9 = true;
                    }
                    item4.setEnabled(z9);
                    if (BrowserView.this.f16114d != null) {
                        BrowserView.this.f16114d.loadUrl(BrowserView.this.b);
                        return;
                    }
                    return;
                }
                if (TextUtils.equals(str, com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.EXITS) && BrowserView.this.f16113c != null) {
                    BrowserView.this.f16113c.a();
                }
            }
        });
    }

    public void loadUrl(String str) {
        WebView webView = this.f16114d;
        if (webView != null) {
            webView.loadUrl(str);
        }
    }

    public void setListener(a aVar) {
        this.f16113c = aVar;
    }

    public void setWebView(WebView webView) {
        this.f16114d = webView;
    }

    private WebView a() {
        WebChromeClient webChromeClient;
        WebView webView = new WebView(getContext());
        try {
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setAppCacheEnabled(true);
            settings.setAppCacheMaxSize(5242880L);
            settings.setAllowFileAccess(true);
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(false);
            settings.setSavePassword(false);
            settings.setDatabaseEnabled(true);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    settings.setSafeBrowsingEnabled(false);
                } catch (Throwable th) {
                    ad.b("BrowserView", th.getMessage());
                }
            }
            settings.setMediaPlaybackRequiresUserGesture(false);
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
            try {
                settings.setMixedContentMode(0);
            } catch (Exception e4) {
                ad.b("BrowserView", e4.getMessage());
            }
            settings.setDatabaseEnabled(true);
            String path = getContext().getDir("database", 0).getPath();
            settings.setDatabasePath(path);
            settings.setGeolocationEnabled(true);
            settings.setGeolocationDatabasePath(path);
            try {
                Method declaredMethod = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(settings, Boolean.FALSE);
            } catch (Exception e9) {
                ad.b("BrowserView", e9.getMessage());
            }
        } catch (Throwable th2) {
            ad.b("BrowserView", th2.getMessage());
        }
        webView.setDownloadListener(new com.mbridge.msdk.foundation.same.g.a(this.f16112a));
        webView.setWebViewClient(new WebViewClient() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.2
            @Override // android.webkit.WebViewClient
            public final void onLoadResource(WebView webView2, String str) {
                super.onLoadResource(webView2, str);
                ad.c("BrowserView", "onLoadResource 开始! = " + str);
                if (BrowserView.this.f16113c != null) {
                    BrowserView.this.f16113c.a(webView2, str);
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onPageFinished(WebView webView2, String str) {
                if (BrowserView.this.f16113c != null) {
                    BrowserView.this.f16113c.c(webView2, str);
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onPageStarted(WebView webView2, String str, Bitmap bitmap) {
                ad.c("BrowserView", "开始! = " + str);
                BrowserView.this.b = str;
                if (BrowserView.this.f16113c != null) {
                    BrowserView.this.f16113c.a(webView2, str, bitmap);
                }
                BrowserView.this.f16115e.setVisible(true);
                BrowserView.this.f16115e.setProgressState(5);
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedError(WebView webView2, int i9, String str, String str2) {
                if (BrowserView.this.f16113c != null) {
                    BrowserView.this.f16113c.a(webView2, i9, str, str2);
                }
            }

            @Override // android.webkit.WebViewClient
            public final boolean onRenderProcessGone(WebView webView2, RenderProcessGoneDetail renderProcessGoneDetail) {
                if (webView2 != null) {
                    try {
                        ViewGroup viewGroup = (ViewGroup) webView2.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(webView2);
                        }
                        webView2.destroy();
                    } catch (Throwable th3) {
                        ad.b("BrowserView", th3.getMessage());
                        return true;
                    }
                }
                if (BrowserView.this.f16113c != null) {
                    BrowserView.this.f16113c.a();
                }
                return true;
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                ad.c("BrowserView", "js大跳! = " + str);
                BrowserView.this.f16116f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.BACKWARD).setEnabled(true);
                BrowserView.this.f16116f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.FORWARD).setEnabled(false);
                if (BrowserView.this.f16113c == null) {
                    return false;
                }
                return BrowserView.this.f16113c.b(webView2, str);
            }
        });
        if (z.s() <= 10) {
            webChromeClient = new WebChromeClient() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.3
                @Override // android.webkit.WebChromeClient
                public final boolean onJsAlert(WebView webView2, String str, String str2, JsResult jsResult) {
                    return true;
                }

                @Override // android.webkit.WebChromeClient
                public final boolean onJsConfirm(WebView webView2, String str, String str2, JsResult jsResult) {
                    return true;
                }

                @Override // android.webkit.WebChromeClient
                public final boolean onJsPrompt(WebView webView2, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                    return true;
                }

                @Override // android.webkit.WebChromeClient
                public final void onProgressChanged(WebView webView2, int i9) {
                    if (i9 == 100) {
                        BrowserView.this.f16115e.setProgressState(7);
                        new Handler().postDelayed(new Runnable() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.3.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                BrowserView.this.f16115e.setVisible(false);
                            }
                        }, 200L);
                    }
                }
            };
        } else {
            webChromeClient = new WebChromeClient() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.4
                @Override // android.webkit.WebChromeClient
                public final void onProgressChanged(WebView webView2, int i9) {
                    if (i9 == 100) {
                        BrowserView.this.f16115e.setProgressState(7);
                        new Handler().postDelayed(new Runnable() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.4.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                BrowserView.this.f16115e.setVisible(false);
                            }
                        }, 200L);
                    }
                }
            };
        }
        webView.setWebChromeClient(webChromeClient);
        return webView;
    }

    public BrowserView(Context context) {
        super(context);
        init();
    }

    public BrowserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
