

package ConciertoDB;

import java.util.*;

import com.mongodb.BasicDBObject;

public class Cliente {

	private int Bol_id;
	private int Cli_id;
	private String Cli_nombre;
	private Date Cli_fecha;
	private int Cli_celular;
	private String Cli_correo;

	public Cliente() {
	}

	public Cliente(int Bol_id, int Cli_id, String Cli_nombre, Date Cli_fecha, int Cli_celular, String Cli_correo) {
		this.Bol_id= Bol_id;
		this.Cli_id = Cli_id;
		this.Cli_nombre = Cli_nombre;
		this.Cli_fecha = Cli_fecha;
		this.Cli_celular = Cli_celular;
		this.Cli_correo = Cli_correo;

	}

	// Transformo un objecto que me da MongoDB a un Objecto Java
	
	public Cliente(BasicDBObject dBObjectcliente) {
		
		this.Bol_id = dBObjectcliente.getInt("Bol_id");
		this.Cli_id = dBObjectcliente.getInt("Cli_id");
		this.Cli_nombre = dBObjectcliente.getString("Cli_nombre");
		this.Cli_fecha = dBObjectcliente.getDate("Cli_fecha");
		this.Cli_celular = dBObjectcliente.getInt("Cli_celular");
		this.Cli_correo = dBObjectcliente.getString("Cli_correo");

	}

	public BasicDBObject dBObjectcliente() {

		// Creamos una instancia BasicDBObject

		BasicDBObject dBObjectcliente = new BasicDBObject();
		dBObjectcliente.append("Bol_id", this.getBol_id());
		dBObjectcliente.append("Cli_id", this.getCli_id());
		dBObjectcliente.append("Cli_nombre", this.getCli_nombre());
		dBObjectcliente.append("Cli_fecha", this.getCli_fecha());
		dBObjectcliente.append("Cli_celular", this.getCli_celular());
		dBObjectcliente.append("Cli_correo", this.getCli_correo());


		return dBObjectcliente;
	}



	public int getBol_id() {
		return Bol_id;
	}

	public void setBol_id(int bol_id) {
		Bol_id = bol_id;
	}

	public int getCli_id() {
		return Cli_id;
	}

	public void setCli_id(int cli_id) {
		Cli_id = cli_id;
	}

	public String getCli_nombre() {
		return Cli_nombre;
	}

	public void setCli_nombre(String cli_nombre) {
		Cli_nombre = cli_nombre;
	}

	public Date getCli_fecha() {
		return Cli_fecha;
	}

	public void setCli_fecha(Date cli_fecha) {
		Cli_fecha = cli_fecha;
	}

	public int getCli_celular() {
		return Cli_celular;
	}

	public void setCli_celular(int cli_celular) {
		Cli_celular = cli_celular;
	}

	public String getCli_correo() {
		return Cli_correo;
	}

	public void setCli_correo(String cli_correo) {
		Cli_correo = cli_correo;
	}

	@Override
	public String toString() {
		

		return "Boleto: " + this.getBol_id() + " / Id Cliente: " + this.getCli_id() + " / Nombre: " + 
		this.Cli_nombre + " / Fecha: " + this.Cli_fecha + " / Celular: " + this.Cli_celular + " / Correo: " + this.Cli_correo;
	}
}
