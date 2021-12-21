package test.interceptor;

import esa.commons.collection.AttributeKey;
import io.esastack.restlight.core.DeployContext;
import io.esastack.restlight.core.config.RestlightOptions;
import io.esastack.restlight.core.interceptor.Interceptor;
import io.esastack.restlight.core.interceptor.InterceptorFactory;
import io.esastack.restlight.core.interceptor.InterceptorPredicate;
import io.esastack.restlight.server.context.RequestContext;
import io.esastack.restlight.server.route.Routing;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AttributeInterceptor implements InterceptorFactory {

    @Override
    public Optional<Interceptor> create(DeployContext<? extends RestlightOptions> ctx, Routing route) {
        return Optional.of(new Interceptor() {
            @Override
            public InterceptorPredicate predicate() {
                return new InterceptorPredicate() {
                    @Override
                    public boolean test(RequestContext requestContext) {
                        return true;
                    }
                };
            }

            @Override
            public boolean preHandle(RequestContext context, Object handler) throws Exception {
                context.attrs().attr(AttributeKey.stringKey("value")).set("88");
                return true;
            }

        });
    }
}
