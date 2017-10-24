package ui;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import spark.Router;
import spark.StaticFilesRouter;

public class UiModule extends AbstractModule {

    @Override
    protected void configure() {
        Multibinder<Router> routerBinder = Multibinder.newSetBinder(binder(), Router.class);
        routerBinder.addBinding().to(UiRouter.class);
        routerBinder.addBinding().to(StaticFilesRouter.class);

    }

}
