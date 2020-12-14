package hospitalisation;

import java.net.UnknownHostException;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class Creating_collection {

    public static void main( String args[] ) throws UnknownHostException{
        DB db;
        try (MongoClient mongo = new MongoClient("localhost", 27017)) {
            db = mongo.getDB("My_DB");
        }
        DBCollection Patients = db.getCollection("Patients");
        DBCollection Dossier = db.getCollection("Dossier");
        DBCollection Dossier_administratif = db.getCollection("Dossier_administratif");
        DBCollection Dossier_medical = db.getCollection("Dossier_medical");
        DBCollection Employe = db.getCollection("Employe");
        DBCollection Examen = db.getCollection("Examen");
        DBCollection Factures = db.getCollection("Factures");
        DBCollection Hopital = db.getCollection("Hopital");
        DBCollection Lits = db.getCollection("Lits");
        DBCollection Personnel_administratif = db.getCollection("Personnel_administratif");
        DBCollection Personnel_medical = db.getCollection("Personnel_medical");
        DBCollection Salle_hospitalisation = db.getCollection("Salle_hospitalisation");
    }
}
