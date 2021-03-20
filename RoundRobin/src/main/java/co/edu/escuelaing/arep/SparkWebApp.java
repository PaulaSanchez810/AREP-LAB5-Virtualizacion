package co.edu.escuelaing.arep;

import spark.Request;
import spark.Response;

import java.io.IOException;

import static spark.Spark.*;


public class SparkWebApp
{
    private static ApiClient httpClient = new ApiClient();
    public static void main(String[] args) {
        port(getPort());
        staticFileLocation("/static");
        get("/", SparkWebApp::buildHomePage);
        get("/GetMessages", SparkWebApp::getBuild);
        post("/GetMessages", SparkWebApp::postBuild);
    }

    private static Object postBuild(Request request, Response response) throws IOException {

        httpClient.postMessage(request.body(),"/GetMessages");
        httpClient.roundRobin();
        return  "";
    }


    private static String getBuild(Request req, Response res) throws IOException {
        res.status(200);
        res.type("application/json");
        String response = httpClient.getMessages("/GetMessages");
        httpClient.roundRobin();
        return response;
    }

    private static String buildHomePage(Request request, Response response) {
        response.redirect("index.html");
        return "";
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
