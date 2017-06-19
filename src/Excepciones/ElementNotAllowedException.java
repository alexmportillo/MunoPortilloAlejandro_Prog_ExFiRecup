package Excepciones;

///Utiliza esta opción para añadir un ID definido por el usuario en combinación con
//Código de serialización personalizado si el tipo sufrió cambios estructurales
//Cambios desde su primer lanzamiento.

@SuppressWarnings("serial")
public class ElementNotAllowedException extends RuntimeException{
	
	public ElementNotAllowedException(String msg)  {
		super("[No Nulos]: " + msg);
	}
}
