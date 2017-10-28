
import api.ApiRouter;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import com.google.inject.multibindings.Multibinder;
import spark.Router;
import spark.RouterManager;
import spark.Spark;
import spark.Sparks;
import ui.UiModule;
import ui.UiRouter;

public final class Main extends AbstractModule {

    public static void main(String... args) {
        try {
            Injector injector = Guice.createInjector(new UiModule());

            Spark.port(getHerokuAssignedPort());


            RouterManager routerManager = injector.getInstance(RouterManager.class);
            routerManager.initAllRouters();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
    }
}
