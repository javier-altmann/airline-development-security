package database;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import spark.Router;

public class DatabaseModule extends AbstractModule {

    @Override
    protected void configure() {
        Multibinder<Router> routerBinder = Multibinder.newSetBinder(binder(), Router.class);
        bind(DatabaseRouter.class);
        routerBinder.addBinding().to(DatabaseRouter.class);

    }
}
