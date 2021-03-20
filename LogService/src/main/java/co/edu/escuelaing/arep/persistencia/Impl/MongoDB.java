package co.edu.escuelaing.arep.persistencia.Impl;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import spark.Request;
import spark.Response;

import java.util.Date;

    public class MongoDB {
        private MongoCollection<Document> data;

        public MongoClient mongoDB() {
            MongoClientURI uri = new MongoClientURI("mongodb+srv://PaulaG:<password>@cluster0.6tmym.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
            return  new MongoClient(uri);
        }

        public String insertMensaje(Request req, Response res) {
            try {
                Document document = new Document();
                document.put("Mensaje", req.queryParams("mensaje"));
                document.put("Fecha", new Date().toString());
                data.insertOne(new Document(document));
                insert(mongoDB(), document);
            } catch (Exception e) {
                System.out.println("No se pudo insertar los datos");
            }

            return getMensaje(mongoDB());
        }

        private void insert(MongoClient mongoClient, Document data) {
            MongoDatabase database = mongoClient.getDatabase("LogService");
            this.data = database.getCollection("Registro");
            this.data.insertOne(data);
        }

        private String getMensaje(MongoClient mongoClient){
            MongoDatabase database = mongoClient.getDatabase("LogService");
            data = database.getCollection("Registro");
            return Mensaje();
        }

        public String Mensaje() {
            StringBuilder jsonData = new StringBuilder("{\"mensajes\": [");
            int cont = 0;
            FindIterable<Document> resultados = data.find().sort(Sorts.descending("Id"));
            for (Document document : resultados) {
                String jsonMini = "";
                if (cont < 10) {
                    System.out.println(document.get("Mensaje") + " " + document.get("Fecha"));
                    jsonMini = "{\"mensaje\": \"" + document.get("Mensaje") + "\", \"fecha\": \"" + document.get("Fecha") + "\"},";
                    jsonData.append(jsonMini);
                }
                cont = cont + 1;
            }
            String temp = jsonData.toString();
            String newTemp = temp.substring(0, temp.length() - 1);
            newTemp += "]}";
            return newTemp;
        }
    }


