package com.mbridge.msdk.thrid.okhttp;

import com.mbridge.msdk.thrid.okhttp.internal.Util;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import x0.AbstractC2914a;

/* loaded from: classes3.dex */
public final class Challenge {
    private final Map<String, String> authParams;
    private final String scheme;

    public Challenge(String str, Map<String, String> map) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        }
        if (map != null) {
            this.scheme = str;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey() == null ? null : entry.getKey().toLowerCase(Locale.US), entry.getValue());
            }
            this.authParams = Collections.unmodifiableMap(linkedHashMap);
            return;
        }
        throw new NullPointerException("authParams == null");
    }

    public Map<String, String> authParams() {
        return this.authParams;
    }

    public Charset charset() {
        String str = this.authParams.get("charset");
        if (str != null) {
            try {
                return Charset.forName(str);
            } catch (Exception unused) {
            }
        }
        return Util.ISO_8859_1;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            if (challenge.scheme.equals(this.scheme) && challenge.authParams.equals(this.authParams)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.authParams.hashCode() + AbstractC2914a.b(899, 31, this.scheme);
    }

    public String realm() {
        return this.authParams.get("realm");
    }

    public String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }

    public Challenge withCharset(Charset charset) {
        if (charset != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(this.authParams);
            linkedHashMap.put("charset", charset.name());
            return new Challenge(this.scheme, linkedHashMap);
        }
        throw new NullPointerException("charset == null");
    }

    public Challenge(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        }
        if (str2 != null) {
            this.scheme = str;
            this.authParams = Collections.singletonMap("realm", str2);
            return;
        }
        throw new NullPointerException("realm == null");
    }
}
