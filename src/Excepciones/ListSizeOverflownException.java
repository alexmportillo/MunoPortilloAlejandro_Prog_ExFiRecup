package Excepciones;

///Utiliza esta opción para añadir un ID definido por el usuario en combinación con
// Código de serialización personalizado si el tipo sufrió cambios estructurales
//Cambios desde su primer lanzamiento.

@SuppressWarnings("serial")
public class ListSizeOverflownException extends RuntimeException {

	public ListSizeOverflownException(String msg)  {
		super("[Supered Size(8)]: " + msg);
	}
}
