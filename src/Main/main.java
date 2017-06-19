package Main;
import Models.*;
import Contenedor.*;
import Models.Listas.*;
import Ventanas.*;
@SuppressWarnings("unused")
public class main {

	public static void main(String[] args) {
		ListasPokemon L1= new ListasPokemon("Charmander","1", "Charizard", "Hawai", "Fuego", "Tranquilo");
		ListasPokemon L2= new ListasPokemon("Bulbasur","1", "bulb", "Lejos", "Agua", "Tranquilo");
		ListasPokemon L3= new ListasPokemon("Picachu","1", "Pica", "Hawai", "Electricidad", "Tranquilo");
	
				//Listas de Pokemon Añadidas
				Listas.ListasPokemon.add(L1);
				Listas.ListasPokemon.add(L2);
				Listas.ListasPokemon.add(L3);

	}

}
