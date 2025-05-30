package com.mbridge.msdk.c.a;

import android.content.Context;
import android.os.Build;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.f.e;
import com.mbridge.msdk.foundation.same.net.f.f;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.out.MBConfiguration;

/* loaded from: classes3.dex */
public final class c extends com.mbridge.msdk.foundation.same.net.f.c {
    public c(Context context) {
        super(context);
    }

    @Override // com.mbridge.msdk.foundation.same.net.f.c
    public final void addExtraParams(String str, e eVar) {
        super.addExtraParams(str, eVar);
        eVar.a("platform", "1");
        eVar.a("os_version", Build.VERSION.RELEASE);
        eVar.a(CampaignEx.JSON_KEY_PACKAGE_NAME, z.e(this.mContext));
        eVar.a("app_version_name", z.p(this.mContext));
        eVar.a("app_version_code", z.q(this.mContext) + "");
        eVar.a("orientation", z.r(this.mContext) + "");
        eVar.a("model", z.h());
        eVar.a("brand", z.x());
        eVar.a("gaid2", com.mbridge.msdk.foundation.tools.e.b());
        int l = z.l(this.mContext);
        eVar.a("network_type", l + "");
        eVar.a("network_str", z.a(this.mContext, l));
        eVar.a("language", z.s(this.mContext));
        eVar.a("timezone", z.y());
        eVar.a("useragent", z.g());
        eVar.a("sdk_version", MBConfiguration.SDK_VERSION);
        eVar.a("screen_size", z.i(this.mContext) + "x" + z.g(this.mContext));
        d.a(this.mContext, eVar);
        f.d(eVar);
    }
}
