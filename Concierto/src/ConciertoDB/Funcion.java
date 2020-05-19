

package ConciertoDB;

import com.mongodb.BasicDBObject;

public class Funcion {


	private int Bol_id;
	private int Fun_id;
	private String Fun_nombre;
	private int Fun_precio;
	private int Fun_cant_pers;
	private String Fun_fecha_Publ;

	public Funcion() {
	}

	public Funcion(int Bol_id, int Fun_id, String Fun_nombre, int Fun_precio, int Fun_cant_pers, String Cun_fecha_Publ) {
		this.Bol_id= Bol_id;
		this.Fun_id = Fun_id;
		this.Fun_nombre = Fun_nombre;
		this.Fun_precio = Fun_precio;
		this.Fun_cant_pers = Fun_cant_pers;
		this.Fun_fecha_Publ = Fun_fecha_Publ;

	}

	// Transformo un objecto que me da MongoDB a un Objecto Java
	
	public Funcion(BasicDBObject dBObjectfuncion) {
		
		this.Bol_id = dBObjectfuncion.getInt("Bol_id");
		this.Fun_id = dBObjectfuncion.getInt("Fun_id");
		this.Fun_nombre = dBObjectfuncion.getString("Fun_nombre");
		this.Fun_precio = dBObjectfuncion.getInt("Fun_precio");
		this.Fun_cant_pers = dBObjectfuncion.getInt("Fun_cant_pers");
		this.Fun_fecha_Publ = dBObjectfuncion.getString("Fun_fecha_Publ");

	}

	public BasicDBObject dBObjectfuncion() {

		// Creamos una instancia BasicDBObject

		BasicDBObject dBObjectfuncion = new BasicDBObject();
		dBObjectfuncion.append("Bol_id", this.getBol_id());
		dBObjectfuncion.append("Fun_id", this.getFun_id());
		dBObjectfuncion.append("Fun_nombre", this.getFun_nombre());
		dBObjectfuncion.append("Fun_precio", this.getFun_precio());
		dBObjectfuncion.append("Fun_cant_pers", this.getFun_cant_pers());
		dBObjectfuncion.append("Fun_fecha_Publ", this.getFun_fecha_Publ());


		return dBObjectfuncion;
	}


	public int getBol_id() {
		return Bol_id;
	}

	public void setBol_id(int bol_id) {
		Bol_id = bol_id;
	}

	public int getFun_id() {
		return Fun_id;
	}

	public void setFun_id(int fun_id) {
		Fun_id = fun_id;
	}

	public String getFun_nombre() {
		return Fun_nombre;
	}

	public void setFun_nombre(String fun_nombre) {
		Fun_nombre = fun_nombre;
	}

	public int getFun_precio() {
		return Fun_precio;
	}

	public void setFun_precio(int fun_precio) {
		Fun_precio = fun_precio;
	}

	public int getFun_cant_pers() {
		return Fun_cant_pers;
	}

	public void setFun_cant_pers(int fun_cant_pers) {
		Fun_cant_pers = fun_cant_pers;
	}

	public String getFun_fecha_Publ() {
		return Fun_fecha_Publ;
	}

	public void setFun_fecha_Publ(String fun_fecha_Publ) {
		Fun_fecha_Publ = fun_fecha_Publ;
	}

	@Override
	

	public String toString() {
		

		return "Boleto: " + this.getBol_id() + " / Id Funcion: " + this.getFun_id() + " / Nombre del nombre: " +
		this.Fun_nombre + " / Precio: " + this.Fun_precio + " / Cantidad de personas: " + this.Fun_cant_pers 
		+ " / Fecha de publicacion: " + this.Fun_fecha_Publ;
	}
}
