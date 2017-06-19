package Excepciones;

///Utiliza esta opci�n para a�adir un ID definido por el usuario en combinaci�n con
//C�digo de serializaci�n personalizado si el tipo sufri� cambios estructurales
//Cambios desde su primer lanzamiento.

@SuppressWarnings("serial")
public class ElementNotAllowedException extends RuntimeException{
	
	public ElementNotAllowedException(String msg)  {
		super("[No Nulos]: " + msg);
	}
}
