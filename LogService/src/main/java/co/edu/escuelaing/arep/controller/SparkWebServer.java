package co.edu.escuelaing.arep.controller;
import co.edu.escuelaing.arep.persistencia.LogService;
import com.google.gson.Gson;
import org.eclipse.jetty.http.HttpStatus;
import org.json.JSONObject;
import spark.*;

import static spark.Spark.*;


/**
 * Hello world!
 *
 */
public class SparkWebServer {
    public static void main(String[] args) {
        port(getPort());
        put("/LogService", LogService::setData);
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 60001;
    }

}
