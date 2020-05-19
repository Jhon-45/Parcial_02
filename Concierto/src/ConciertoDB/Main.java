
package ConciertoDB;

import java.net.UnknownHostException;
import java.util.*;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class Main {

	public static void main(String args[]) {
		
		ArrayList<Cliente> Cli = new ArrayList<Cliente>();
		ArrayList<Boleto> Bol = new ArrayList<Boleto>();
		ArrayList<Funcion> Fun = new ArrayList<Funcion>();
		ArrayList<Lugar> Lug = new ArrayList<Lugar>();
	
		
		
		
		Bol.add(new Boleto(1010, "General"));
		Bol.add(new Boleto(1020, "Palco"));
		Bol.add(new Boleto (1030, "VIP"));
		
		Fun.add(new Funcion(1010, 2030, "Camp rock", 502000, 3000, "2019-05-11" ));
		Fun.add(new Funcion(1030, 2040, "Vivir la vida", 820000, 5000, "2001-05-11" ));
		
		Lug.add(new Lugar(2030, 1094285683));
		Lug.add(new Lugar(2040, 1198935683));
		
		
		try {
		//Conexion al Server de MongoDB Pasandole el host y el puerto

			MongoClient mongoClient = new MongoClient("localhost", 27017);

		//Conexion a la base de datos

			DB db = mongoClient.getDB("ConciertoDB");

		//Obtenemos una coleccion para trabajar con ella

			DBCollection collection = db.getCollection("Cliente");
			DBCollection collection1 = db.getCollection("Boleto");
			DBCollection collection2 = db.getCollection("Funcion");
			DBCollection collection3 = db.getCollection("Lugar");

			
		// CRUD ( Create - Read - Update - Delete )

			// "CREATE" -> Metemos los objetos del Concierto (o documentos en Mongo) en la coleccion 

			for (Cliente Cl : Cli) {
				collection.insert(Cl.dBObjectcliente());
			}
			for (Boleto Bo : Bol) {
				collection1.insert(Bo.dBObjectboleto());
			}
			for (Funcion Fu : Fun) {
				collection2.insert(Fu.dBObjectfuncion());
			}
			/*for (Lugar Lu : Lug) {
				collection3.insert(Lu.dBObjectlugar());
			}
			*/
//--------------------------------------------------------------------------------------------------------------------------------------------------
			// "READ" -> Leemos todos los documentos de la base de datos
/*
			int numDocumentos = (int) collection.getCount();
			System.out.println("Numero de Documentos en la coleccion Cliente: " + numDocumentos + "\n");
			DBCursor cursor = collection.find();
			try {
				while (cursor.hasNext()) {
					System.out.println(cursor.next().toString());
				}
			} finally {
				cursor.close();
			}
			
			int numDocumentos1 = (int) collection1.getCount();
			System.out.println("Numero de Documentos en la coleccion Boleto: " + numDocumentos1 + "\n");
			DBCursor cursor1 = collection1.find();
			try {
				while (cursor1.hasNext()) {
					System.out.println(cursor1.next().toString());
				}
			} finally {
				cursor1.close();
			}
			
			int numDocumentos2 = (int) collection2.getCount();
			System.out.println("Numero de Documentos en la coleccion Funcion: " + numDocumentos2 + "\n");
			DBCursor cursor2 = collection2.find();
			try {
				while (cursor2.hasNext()) {
					System.out.println(cursor2.next().toString());
				}
			} finally {
				cursor2.close();
			}
			
			int numDocumentos3 = (int) collection3.getCount();
			System.out.println("Numero de Documentos en la coleccion Lugar: " + numDocumentos3 + "\n");
			DBCursor cursor3 = collection3.find();
			try {
				while (cursor3.hasNext()) {
					System.out.println(cursor3.next().toString());
				}
			} finally {
				cursor3.close();
			}
			
			// "READ" -> Hacemos una Query con condiciones (Buscar Clientes) y lo pasamos a un objeto Java

			System.out.println("\n Clientes que van a comprar boleto para el concierto");
			DBObject query = new BasicDBObject("ubicacion", new BasicDBObject("$regex", "General"));
			cursor = collection.find(query);
			try {
				while (cursor.hasNext()) {
					Cliente Cli1 = new Cliente((BasicDBObject) cursor.next());
					System.out.println(Cli1.toString());
				}
			} finally {
				cursor.close();
			}
		//}

			// "UPDATE" -> Actualizamos el costo del Boleto. Sumamos 50000 a los Clientes que paguen menos de 800.000
			
			DBObject find = new BasicDBObject("Costo", new BasicDBObject("$lte", 900000));
			DBObject updated = new BasicDBObject().append("$inc", new BasicDBObject().append("Costo", 50000));
			collection1.update(find, updated, false, true);
			try {
				while (cursor1.hasNext()) {
					System.out.println(cursor1.next().toString());
				}
			} finally {
				cursor1.close();
			}
			
			//"DELETE" -> Borramos todos los Clientes que no van a asistir al Concierto
			//DBObject findDoc = new BasicDBObject("_", true);
			//collection.remove(findDoc);
			 
			 */

		// PASO FINAL: Cerrar la conexion
			mongoClient.close();

		} catch (Exception ex) {
			System.out.println("Exception al conectar al server de Mongo: " + ex.getMessage());
		}

	}
}