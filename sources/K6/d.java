package K6;

import F7.p;
import Q7.InterfaceC0253v;
import T7.o;
import T7.s;
import com.tools.arruler.ui.component.language.LanguageActivity;
import t7.AbstractC2712a;
import t7.y;
import x7.EnumC2928a;
import y7.AbstractC2960i;

/* loaded from: classes3.dex */
public final class d extends AbstractC2960i implements p {

    /* renamed from: g, reason: collision with root package name */
    public int f1652g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ LanguageActivity f1653h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(LanguageActivity languageActivity, w7.f fVar) {
        super(2, fVar);
        this.f1653h = languageActivity;
    }

    @Override // y7.AbstractC2952a
    public final w7.f c(Object obj, w7.f fVar) {
        return new d(this.f1653h, fVar);
    }

    @Override // F7.p
    public final Object g(Object obj, Object obj2) {
        return ((d) c((InterfaceC0253v) obj, (w7.f) obj2)).i(y.f23029a);
    }

    @Override // y7.AbstractC2952a
    public final Object i(Object obj) {
        EnumC2928a enumC2928a = EnumC2928a.b;
        int i9 = this.f1652g;
        if (i9 != 0) {
            if (i9 == 1) {
                AbstractC2712a.f(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            AbstractC2712a.f(obj);
            o a6 = r6.h.f22921e.i().a("ca-app-pub-6691965685689933/8589803081");
            c cVar = new c(this.f1653h, null);
            this.f1652g = 1;
            if (s.b(a6, cVar, this) == enumC2928a) {
                return enumC2928a;
            }
        }
        return y.f23029a;
    }
}
