package spark;


import com.google.inject.Inject;

import java.util.Set;

public class RouterManager {
    private final Set<Router> routers;

    @Inject
    public RouterManager(Set<Router> routers) {
        this.routers = routers;
    }

    /**
     * Initializes all routers.
     */
    public void initAllRouters() {

        routers.forEach(Router::routeWebSockets);

        routers.forEach(router -> {
            router.routeServices();
        });
    }

}
