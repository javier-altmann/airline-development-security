package api.aircrafts;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import spark.Router;

public class AircraftModule extends AbstractModule {

    @Override
    protected void configure() {
        Multibinder<Router> routerBinder = Multibinder.newSetBinder(binder(), Router.class);
        bind(AircraftRouter.class);
        routerBinder.addBinding().to(AircraftRouter.class);

    }
}
