package co.edu.escuelaing.arep.persistencia;
import co.edu.escuelaing.arep.persistencia.Impl.MongoDB;
import spark.*;


public class LogService {
    public static String setData(Request req, Response res){
        MongoDB mongoDB= new MongoDB();
        return mongoDB.insertMensaje(req, res);
    }
}
