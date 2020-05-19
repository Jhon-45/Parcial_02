

package ConciertoDB;

import com.mongodb.BasicDBObject;

public class Boleto {

	private int Bol_id;
	private String Bol_nombre;

	public Boleto() {
	}

	public Boleto(int Bol_id, String Bol_nombre) {
		this.Bol_id= Bol_id;
		this.Bol_nombre = Bol_nombre;
	}

	// Transformo un objecto que me da MongoDB a un Objecto Java
	
	public Boleto(BasicDBObject dBObjectboleto) {
		
		this.Bol_id = dBObjectboleto.getInt("Bol_id");
		this.Bol_nombre = dBObjectboleto.getString("Bol_nombre");

	}

	public BasicDBObject dBObjectboleto() {

		// Creamos una instancia BasicDBObject

		BasicDBObject dBObjectboleto = new BasicDBObject();
		dBObjectboleto.append("Bol_id", this.getBol_id());
		dBObjectboleto.append("Bol_nombre", this.getBol_nombre());

		return dBObjectboleto;
	}

	
	public int getBol_id() {
		return Bol_id;
	}

	public void setBol_id(int bol_id) {
		Bol_id = bol_id;
	}

	public String getBol_nombre() {
		return Bol_nombre;
	}

	public void setBol_nombre(String bol_nombre) {
		Bol_nombre = bol_nombre;
	}

	@Override
	public String toString() {
	
		return "Boleto: " + this.getBol_id() + " / Nombre: " + this.Bol_nombre;
	}
}
