import java.util.*;
public class Persona{
	String nombre;
	String apellidos;
	String email;
	String telefono;
	public Persona (String nombre, String apellidos, String email, String telefono){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
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
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	public void setApellido1(String apellidos){
		this.apellidos = apellidos;
	}
	public void setDireccion(String email){
		this.email = email;
	}
	public void setTelefono(String telefono){
		this.telefono = telefono;
	}
	public String toString(){
		return apellidos + ", " + nombre + ", " + email + ", " + telefono;
	}

}