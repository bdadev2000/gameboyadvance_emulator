package com.mbridge.msdk.out.reveue;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinEventParameters;
import com.mbridge.msdk.foundation.tools.ai;
import java.net.URLEncoder;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MBridgeRevenueParamsEntity {
    public static final String ATTRIBUTION_PLATFORM_ADBRIX = "Adbrix";
    public static final String ATTRIBUTION_PLATFORM_ADJUST = "Adjust";
    public static final String ATTRIBUTION_PLATFORM_AIRVRIDGE = "Airbridge";
    public static final String ATTRIBUTION_PLATFORM_APPSFLYER = "AppsFlyer";
    public static final String ATTRIBUTION_PLATFORM_APP_METRICA = "AppMetrica";
    public static final String ATTRIBUTION_PLATFORM_APSALAR = "Apsalar";
    public static final String ATTRIBUTION_PLATFORM_BRANCH = "Branch";
    public static final String ATTRIBUTION_PLATFORM_DATA_EYE = "DataEye";
    public static final String ATTRIBUTION_PLATFORM_FOX = "Fox";
    public static final String ATTRIBUTION_PLATFORM_JUST_TRACK = "JustTrack";
    public static final String ATTRIBUTION_PLATFORM_KOCHAVA = "Kochava";
    public static final String ATTRIBUTION_PLATFORM_MY_TRACKER = "MyTracker";
    public static final String ATTRIBUTION_PLATFORM_REYUN = "Reyun";
    public static final String ATTRIBUTION_PLATFORM_SINGULAR = "Singular";
    public static final String ATTRIBUTION_PLATFORM_SOLAR_ENGINE = "SolarEngine";
    public static final String ATTRIBUTION_PLATFORM_TALKING_DATA = "TalkingData";
    public static final String ATTRIBUTION_PLATFORM_TENJIN = "Tenjin";
    public static final String ATTRIBUTION_PLATFORM_UMENG = "Umeng";
    private JSONObject eventInfoJsonObject = new JSONObject();
    private String mediationName;
    private String mmpName;
    private String mmpUserId;
    private String traceId;

    /* loaded from: classes3.dex */
    public @interface AttributionPlatform {
    }

    public MBridgeRevenueParamsEntity(String str, String str2) {
        setMmpName(str);
        setMmpUserId(str2);
        setTraceId(ai.d());
    }

    public String getMediationName() {
        return this.mediationName;
    }

    public String getMmpName() {
        return this.mmpName;
    }

    public String getMmpUserId() {
        return this.mmpUserId;
    }

    public String getReportData() {
        try {
            return "event_info=" + URLEncoder.encode(this.eventInfoJsonObject.toString(), "utf-8");
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setAdType(String str) {
        try {
            this.eventInfoJsonObject.put("mediation_ad_type", str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setBidType(Boolean bool) {
        try {
            this.eventInfoJsonObject.put("bid_type", bool);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setCurrency(String str) {
        try {
            this.eventInfoJsonObject.put(AppLovinEventParameters.REVENUE_CURRENCY, str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setDspInfo(String str, String str2) {
        try {
            this.eventInfoJsonObject.put("dsp_name", str);
            this.eventInfoJsonObject.put("dsp_id", str2);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setEventTime(String str) {
        try {
            this.eventInfoJsonObject.put("event_time", str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setExtData(JSONObject jSONObject) {
        try {
            this.eventInfoJsonObject.put("extra_data", jSONObject);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setMediationName(String str) {
        try {
            this.mediationName = str;
            this.eventInfoJsonObject.put("mediation_name", str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setMediationUnitId(String str) {
        try {
            this.eventInfoJsonObject.put("mediation_unit_id", str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setMmpName(String str) {
        this.mmpName = str;
        try {
            this.eventInfoJsonObject.put("mmp_name", str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setMmpUserId(String str) {
        this.mmpUserId = str;
        try {
            this.eventInfoJsonObject.put("mmp_user_id", str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setNetworkInfo(JSONObject jSONObject) {
        String jSONObject2;
        try {
            JSONObject jSONObject3 = this.eventInfoJsonObject;
            if (jSONObject == null) {
                jSONObject2 = JsonUtils.EMPTY_JSON;
            } else {
                jSONObject2 = jSONObject.toString();
            }
            jSONObject3.put("network_unit_info", jSONObject2);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setNetworkName(String str) {
        try {
            this.eventInfoJsonObject.put("network_name", str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setPrecision(String str) {
        try {
            this.eventInfoJsonObject.put("precision", str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setRevenue(String str) {
        try {
            this.eventInfoJsonObject.put("revenue", str);
            setEventTime((System.currentTimeMillis() / 1000) + "");
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setSourceData(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mediation_source_data", str);
            jSONObject.put("adNetwork_source_data", str2);
            this.eventInfoJsonObject.put("all_info", jSONObject);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setTraceId(String str) {
        this.traceId = str;
        try {
            this.eventInfoJsonObject.put("trace_id", str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
