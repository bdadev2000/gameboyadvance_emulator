package com.mbridge.msdk.out;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.mbnative.c.b;
import com.mbridge.msdk.mbnative.d.a;
import com.mbridge.msdk.out.NativeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MBNativeHandler extends b implements BaseExtraInterfaceForHandler {
    private static final String TAG = "com.mbridge.msdk.out.MBNativeHandler";
    public static final String TEMPLATE_ID = "id";
    public static final String TEMPLATE_NUM = "ad_num";
    private static String mUnitID;
    private a adListener;
    private com.mbridge.msdk.click.a clickControler;
    private Context context;
    private Map<String, Object> map;
    private com.mbridge.msdk.mbnative.f.a nativeProvider;
    private List<NativeListener.Template> templateList;
    private NativeListener.NativeTrackingListener trackingListener;

    /* loaded from: classes3.dex */
    public static class KeyWordInfo {
        String keyWordPN;
        String keyWorkVN;

        public KeyWordInfo(String str, String str2) {
            this.keyWordPN = str;
            this.keyWorkVN = str2;
        }

        public String getKeyWordPN() {
            return this.keyWordPN;
        }

        public String getKeyWorkVN() {
            return this.keyWorkVN;
        }

        public void setKeyWordPN(String str) {
            this.keyWordPN = str;
        }

        public void setKeyWorkVN(String str) {
            this.keyWorkVN = str;
        }
    }

    public MBNativeHandler(Context context) {
        this.adListener = new a();
        this.context = context;
        if (c.m().c() == null && context != null) {
            c.m().b(context);
        }
        Map<String, Object> map = this.map;
        if (map == null || !map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
            return;
        }
        String str = (String) this.map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a aVar = this.adListener;
        if (aVar != null) {
            aVar.a(str);
        }
        String e4 = ai.e(str);
        if (TextUtils.isEmpty(e4)) {
            return;
        }
        ai.b(str, e4);
    }

    public static Map<String, Object> getNativeProperties(String str, String str2) {
        HashMap hashMap = new HashMap();
        mUnitID = str2;
        hashMap.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
        String str3 = MBridgeConstans.PLACEMENT_ID;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        hashMap.put(str3, str);
        hashMap.put(MBridgeConstans.PLUGIN_NAME, new String[]{MBridgeConstans.PLUGIN_NATIVE});
        hashMap.put(MBridgeConstans.PROPERTIES_LAYOUT_TYPE, 0);
        return hashMap;
    }

    public static String getTemplateString(List<NativeListener.Template> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (NativeListener.Template template : list) {
                        stringBuffer.append("{\"id\":");
                        stringBuffer.append(template.getId() + ",");
                        stringBuffer.append("\"ad_num\":");
                        stringBuffer.append(template.getAdNum() + "},");
                    }
                    return "[{$native_info}]".replace("{$native_info}", stringBuffer.subSequence(0, stringBuffer.lastIndexOf(",")));
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    private boolean loadMB() {
        Map<String, Object> map = this.properties;
        if (map != null && map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
            List<NativeListener.Template> list = this.templateList;
            if (list != null && list.size() > 0) {
                try {
                    this.properties.put(MBridgeConstans.NATIVE_INFO, buildTemplateString());
                } catch (Exception unused) {
                    ad.d(TAG, "MBSDK set template error");
                }
            }
            try {
                this.properties.put(MBridgeConstans.PROPERTIES_HANDLER_CONTROLLER, this);
                if (this.nativeProvider == null) {
                    com.mbridge.msdk.mbnative.f.a aVar = new com.mbridge.msdk.mbnative.f.a(this.adListener, this.trackingListener);
                    this.nativeProvider = aVar;
                    aVar.a(this.context, (Resources) null, this.properties);
                }
                this.nativeProvider.a();
                return true;
            } catch (Exception e4) {
                e4.printStackTrace();
                return true;
            }
        }
        ad.d(TAG, "no unit id.");
        return true;
    }

    private boolean loadMBFrame() {
        List<NativeListener.Template> list = this.templateList;
        if (list != null && list.size() > 0) {
            try {
                this.properties.put(MBridgeConstans.NATIVE_INFO, buildTemplateString());
            } catch (Exception unused) {
                ad.d(TAG, "MBSDK set template error");
            }
        }
        try {
            this.properties.put(MBridgeConstans.PROPERTIES_HANDLER_CONTROLLER, this);
            if (this.nativeProvider == null) {
                com.mbridge.msdk.mbnative.f.a aVar = new com.mbridge.msdk.mbnative.f.a(this.adListener, this.trackingListener);
                this.nativeProvider = aVar;
                aVar.a(this.context, (Resources) null, this.properties);
            }
            this.nativeProvider.b();
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return true;
        }
    }

    public void addTemplate(NativeListener.Template template) {
        if (template != null) {
            if (this.templateList == null) {
                this.templateList = new ArrayList();
            }
            this.templateList.add(template);
        }
    }

    public String buildTemplateString() {
        try {
            List<NativeListener.Template> list = this.templateList;
            if (list != null && list.size() > 0) {
                StringBuffer stringBuffer = new StringBuffer();
                for (NativeListener.Template template : this.templateList) {
                    stringBuffer.append("{\"id\":");
                    stringBuffer.append(template.getId() + ",");
                    stringBuffer.append("\"ad_num\":");
                    stringBuffer.append(template.getAdNum() + "},");
                }
                return "[{$native_info}]".replace("{$native_info}", stringBuffer.subSequence(0, stringBuffer.lastIndexOf(",")));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void clearCacheByUnitid(String str) {
        try {
            if (an.a(str)) {
                return;
            }
            e.a(g.a(c.m().c())).c(str);
            if (!com.mbridge.msdk.e.b.a()) {
                c.m().b(str);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void clearVideoCache() {
        try {
            com.mbridge.msdk.mbnative.f.a aVar = this.nativeProvider;
            if (aVar != null) {
                aVar.c();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public a getAdListener() {
        return this.adListener;
    }

    public String getCreativeIdWithUnitId() {
        com.mbridge.msdk.mbnative.f.a aVar = this.nativeProvider;
        if (aVar != null) {
            return aVar.f();
        }
        return "";
    }

    public String getRequestId() {
        com.mbridge.msdk.mbnative.f.a aVar = this.nativeProvider;
        if (aVar != null) {
            return aVar.e();
        }
        return "";
    }

    public NativeListener.NativeTrackingListener getTrackingListener() {
        return this.trackingListener;
    }

    public void handleResult(Campaign campaign, String str) {
        String str2;
        if (this.clickControler == null) {
            Map<String, Object> map = this.map;
            if (map != null) {
                str2 = (String) map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
            } else {
                str2 = null;
            }
            this.clickControler = new com.mbridge.msdk.click.a(this.context, str2);
        }
        this.clickControler.a(campaign, str);
    }

    @Override // com.mbridge.msdk.out.MBCommonHandler
    public boolean load() {
        Map<String, Object> map = this.properties;
        if (map != null && map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
            loadMB();
            return true;
        }
        ad.d(TAG, "no unit id.");
        return true;
    }

    public boolean loadFrame() {
        Map<String, Object> map = this.properties;
        if (map != null && map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
            loadMBFrame();
            return true;
        }
        ad.d(TAG, "no unit id.");
        return true;
    }

    public void registerView(View view, Campaign campaign) {
        if (this.nativeProvider == null) {
            this.nativeProvider = new com.mbridge.msdk.mbnative.f.a(this.adListener, this.trackingListener);
            Map<String, Object> map = this.properties;
            if (map != null) {
                map.put(MBridgeConstans.PROPERTIES_HANDLER_CONTROLLER, this);
            }
            this.nativeProvider.a(this.context, (Resources) null, this.properties);
        }
        this.nativeProvider.a(view, campaign);
    }

    @Override // com.mbridge.msdk.out.MBCommonHandler
    public void release() {
        com.mbridge.msdk.mbnative.f.a aVar = this.nativeProvider;
        if (aVar != null) {
            aVar.d();
        }
        this.trackingListener = null;
        c.m().b(mUnitID);
    }

    public void setAdListener(NativeListener.NativeAdListener nativeAdListener) {
        a aVar = new a(nativeAdListener);
        this.adListener = aVar;
        aVar.a(mUnitID);
        com.mbridge.msdk.mbnative.f.a aVar2 = this.nativeProvider;
        if (aVar2 != null) {
            aVar2.a(this.adListener);
        }
    }

    @Override // com.mbridge.msdk.out.BaseExtraInterfaceForHandler
    public void setExtraInfo(JSONObject jSONObject) {
        c.m().a(mUnitID, jSONObject);
    }

    public void setMustBrowser(boolean z8) {
        ah.b = z8;
    }

    public void setTrackingListener(NativeListener.NativeTrackingListener nativeTrackingListener) {
        this.trackingListener = nativeTrackingListener;
        com.mbridge.msdk.mbnative.f.a aVar = this.nativeProvider;
        if (aVar != null) {
            aVar.a(nativeTrackingListener);
        }
    }

    public void unregisterView(View view, Campaign campaign) {
        if (this.nativeProvider == null) {
            this.nativeProvider = new com.mbridge.msdk.mbnative.f.a(this.adListener, this.trackingListener);
            Map<String, Object> map = this.properties;
            if (map != null) {
                map.put(MBridgeConstans.PROPERTIES_HANDLER_CONTROLLER, this);
            }
            this.nativeProvider.a(this.context, (Resources) null, this.properties);
        }
        this.nativeProvider.b(view, campaign);
        c.m().b(mUnitID);
    }

    public void registerView(View view, List<View> list, Campaign campaign) {
        if (this.nativeProvider == null) {
            this.nativeProvider = new com.mbridge.msdk.mbnative.f.a(this.adListener, this.trackingListener);
            Map<String, Object> map = this.properties;
            if (map != null) {
                map.put(MBridgeConstans.PROPERTIES_HANDLER_CONTROLLER, this);
            }
            this.nativeProvider.a(this.context, (Resources) null, this.properties);
        }
        this.nativeProvider.a(view, list, campaign);
    }

    public void unregisterView(View view, List<View> list, Campaign campaign) {
        if (this.nativeProvider == null) {
            this.nativeProvider = new com.mbridge.msdk.mbnative.f.a(this.adListener, this.trackingListener);
            Map<String, Object> map = this.properties;
            if (map != null) {
                map.put(MBridgeConstans.PROPERTIES_HANDLER_CONTROLLER, this);
            }
            this.nativeProvider.a(this.context, (Resources) null, this.properties);
        }
        this.nativeProvider.b(view, list, campaign);
        c.m().b(mUnitID);
    }

    public MBNativeHandler(Map<String, Object> map, Context context) {
        super(map, context);
        this.adListener = new a();
        this.context = context;
        this.map = map;
        if (c.m().c() == null && context != null) {
            c.m().b(context);
        }
        if (map != null) {
            try {
                if (map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID) && map.get(MBridgeConstans.PROPERTIES_UNIT_ID) != null && (map.get(MBridgeConstans.PROPERTIES_UNIT_ID) instanceof String) && map.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH) && map.get(MBridgeConstans.NATIVE_VIDEO_WIDTH) != null && (map.get(MBridgeConstans.NATIVE_VIDEO_WIDTH) instanceof Integer) && map.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT) && map.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT) != null) {
                    boolean z8 = map.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT) instanceof Integer;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (map == null || !map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
            return;
        }
        String str = (String) map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a aVar = this.adListener;
        if (aVar != null) {
            aVar.a(str);
        }
        String e4 = ai.e(str);
        if (TextUtils.isEmpty(e4)) {
            return;
        }
        ai.b(str, e4);
    }
}
