package Models;

public class ListasPokemon {
	
	protected String Nombre;
	protected String Numero;
	protected String NivelEvolucion;
	protected String Region;
	protected String Tipo;
	protected String Comentarios;
	
	
	//Constructor
	public ListasPokemon(String nombre, String numero, String nivelEvolucion, String region, String tipo,
			String comentarios) {
		super();
		this.Nombre = nombre;
		this.Numero = numero;
		this.NivelEvolucion = nivelEvolucion;
		this.Region = region;
		this.Tipo = tipo;
		this.Comentarios = comentarios;
	}
	
	//Getters y Setters
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}
	public String getNumero() {
		return Numero;
	}
	public void setNumero(String numero) {
		this.Numero = numero;
	}
	public String getNivelEvolucion() {
		return NivelEvolucion;
	}
	public void setNivelEvolucion(String nivelEvolucion) {
		this.NivelEvolucion = nivelEvolucion;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		this.Region = region;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		this.Tipo = tipo;
	}
	public String getComentarios() {
		return Comentarios;
	}
	public void setComentarios(String comentarios) {
		this.Comentarios = comentarios;
	}
	

}
