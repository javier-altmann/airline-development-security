package api.routes;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import spark.Router;

public class RouteModule extends AbstractModule {

    @Override
    protected void configure() {
        Multibinder<Router> routerBinder = Multibinder.newSetBinder(binder(), Router.class);
        bind(RouteRouter.class);
        routerBinder.addBinding().to(RouteRouter.class);

    }
}
