package conf;

public enum Enviroment {
    APP_CONTEXT("aerolineas"),
    APP_VERSION("0.0.1"),
    API_CONTEXT("api");

    private String property;

    Enviroment(String property) {
        this.property = property;

    }


    public String getProperty() {
        return property;
    }
}
