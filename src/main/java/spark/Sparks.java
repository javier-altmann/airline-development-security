package spark;

import java.io.IOException;
import java.net.Socket;

public final class Sparks {

    /**
     * Checks if a port is available.
     *
     * @param port to check
     * @return true is available
     */

    public static boolean isAvailablePort(int port) {
        try (Socket ignored = new Socket("localhost", port)) {
            return false;
        } catch (IOException ex) {
            return true;
        }
    }


}
