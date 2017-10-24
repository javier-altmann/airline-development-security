package spark;

public interface Router {

    default void routeWebSockets() {
    }

    void routeServices();


}
