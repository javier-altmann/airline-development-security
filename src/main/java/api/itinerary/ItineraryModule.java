package api.itinerary;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import spark.Router;

public class ItineraryModule extends AbstractModule {

    @Override
    protected void configure() {
        Multibinder<Router> routerBinder = Multibinder.newSetBinder(binder(), Router.class);
        bind(ItineraryRouter.class);
        routerBinder.addBinding().to(ItineraryRouter.class);

    }
}
