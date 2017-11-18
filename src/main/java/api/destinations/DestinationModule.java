package api.destinations;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import spark.Router;

public class DestinationModule extends AbstractModule {

    @Override
    protected void configure() {
        Multibinder<Router> routerBinder = Multibinder.newSetBinder(binder(), Router.class);
        bind(DestinationRouter.class);
        routerBinder.addBinding().to(DestinationRouter.class);

    }
}
