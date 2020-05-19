
package ConciertoDB;

import com.mongodb.BasicDBObject;

public class Lugar {

	private int Fun_id;
	private int Cli_id;

	public Lugar() {
	}

	public Lugar(int Fun_id, int Cli_id) {
		this.Fun_id= Fun_id;
		this.Cli_id = Cli_id;

	}

	// Transformo un objecto que me da MongoDB a un Objecto Java
	
	public Lugar(BasicDBObject dBObjectlugar) {
		
		this.Fun_id = dBObjectlugar.getInt("Fun_id");
		this.Cli_id = dBObjectlugar.getInt("Cli_id");

	}

	public BasicDBObject dBObjectcliente() {

		// Creamos una instancia BasicDBObject

		BasicDBObject dBObjectlugar = new BasicDBObject();
		dBObjectlugar.append("Fun_id", this.getFun_id());
		dBObjectlugar.append("Cli_id", this.getCli_id());


		return dBObjectlugar;
	}



	public int getFun_id() {
		return Fun_id;
	}

	public void setFun_id(int fun_id) {
		Fun_id = fun_id;
	}

	public int getCli_id() {
		return Cli_id;
	}

	public void setCli_id(int cli_id) {
		Cli_id = cli_id;
	}

	@Override
	public String toString() {
		
		return "Funcion: " + this.getFun_id() + " / Id Cliente: " + this.getCli_id();
	}
}