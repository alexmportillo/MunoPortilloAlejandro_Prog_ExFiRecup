package Excepciones;

///Utiliza esta opci�n para a�adir un ID definido por el usuario en combinaci�n con
// C�digo de serializaci�n personalizado si el tipo sufri� cambios estructurales
//Cambios desde su primer lanzamiento.

@SuppressWarnings("serial")
public class ListSizeOverflownException extends RuntimeException {

	public ListSizeOverflownException(String msg)  {
		super("[Supered Size(8)]: " + msg);
	}
}
