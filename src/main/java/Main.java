
import api.ApiModule;
import api.ApiRouter;
import api.aircrafts.AircraftModule;
import api.aircrafts.AircraftRouter;
import api.destinations.DestinationModule;
import api.destinations.DestinationRouter;
import api.flights.FlightModule;
import api.flights.FlightRouter;
import api.itinerary.ItineraryModule;
import api.itinerary.ItineraryRouter;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import com.google.inject.multibindings.Multibinder;
import database.DatabaseModule;
import database.DatabaseRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Router;
import spark.RouterManager;
import spark.Spark;
import ui.UiModule;
import ui.UiRouter;

public final class Main extends AbstractModule {

    static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String... args) {
        Injector injector = Guice.createInjector(
                new UiModule(),
                new ApiModule(),
                new DestinationModule(),
                new FlightModule(),
                new AircraftModule(),
                new ItineraryModule(),
                new DatabaseModule());

        Spark.port(getHerokuAssignedPort());

        RouterManager routerManager = injector.getInstance(RouterManager.class);
        routerManager.initAllRouters();


    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }


    @Override
    protected void configure() {
        Multibinder<Router> routerBinder = Multibinder.newSetBinder(binder(), Router.class);

        bind(UiRouter.class);
        routerBinder.addBinding().to(UiRouter.class);

        bind(ApiRouter.class);
        routerBinder.addBinding().to(ApiRouter.class);

        bind(FlightRouter.class);
        routerBinder.addBinding().to(FlightRouter.class);

        bind(DestinationRouter.class);
        routerBinder.addBinding().to(DestinationRouter.class);

        bind(AircraftRouter.class);
        routerBinder.addBinding().to(AircraftRouter.class);

        bind(ItineraryRouter.class);
        routerBinder.addBinding().to(ItineraryRouter.class);

        bind(DatabaseRouter.class);
        routerBinder.addBinding().to(DatabaseRouter.class);
    }


}
