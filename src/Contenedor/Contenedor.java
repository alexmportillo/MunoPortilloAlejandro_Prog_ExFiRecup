package Contenedor;
//Importamos modelo ListasPokemon
import Models.ListasPokemon;
//Importamos modelo Listas
import Models.Listas;

//Clase Contenedor para poder realizar las comparaciones,y saber si el pokemon aparece en la lista
public class Contenedor {
	public static Listas<ListasPokemon> LPokemon = new Listas<>(
			(ListasPokemon a, ListasPokemon b) -> b.getNumero().compareTo(a.getNumero()));
	
	public static Listas<ListasPokemon> getListasPokemon() {
		return getListasPokemon();
	}
}