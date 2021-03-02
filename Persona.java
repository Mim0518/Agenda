import java.sql.Date;

public class Persona{
	String nombre;
	String apellidos;
	String email;
	String telefono;
	String fecha;
	public Persona (String nombre, String apellidos, String email, String telefono, String fecha){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
		this.fecha = fecha;
	}
	public String getNombre(){
		return nombre;
	}
	public String getApellidos(){
		return apellidos;
	}
	public String getDireccion(){
		return email;
	}
	public String getTelefono(){
		return telefono;
	}
	public String getFecha(){
		return fecha;
	}
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	public void setApellidos(String apellidos){
		this.apellidos = apellidos;
	}
	public void setDireccion(String email){
		this.email = email;
	}
	public void setTelefono(String telefono){
		this.telefono = telefono;
	}
	public void setFecha(String fecha){
		this.fecha = fecha;
	}
	public String toString(){
		return nombre + "," + apellidos + "," + email + "," + telefono + "," + fecha;
	}

}