package Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

//Importamos las Excepciones
//Hemos creado para nulos y para que no supere un valor de más de 80
import Excepciones.ListSizeOverflownException;
import Excepciones.ElementNotAllowedException;


@SuppressWarnings("serial")
public class Listas<E>extends ArrayList<E> {
	public static ArrayList<ListasPokemon> ListasPokemon = new ArrayList<ListasPokemon>();
	//public static final String ListasPokemon = null;
	// Dlecaracion de constantes y variables
	private final byte MAX_SIZE = 80;
	private Comparator<E> comparador;

	
	@SuppressWarnings("unchecked")
	public Listas(Comparator<ListasPokemon> comparador) {
		this.comparador = (Comparator<E>) comparador;
	}

	// Sobreescribimos los metodos necesarios para nuestro comportamiento
	
	@Override
	public boolean add(E element) {
		if (element != null) {
			if (this.size() < MAX_SIZE) {
				super.add(element);
				//Ordenamos usando el metodo SORT
				Collections.sort(this, comparador);
				return true;
			} else {
				throw new ListSizeOverflownException("No supere el tamaño mayor a 80");
			}
		} else {
			throw new ElementNotAllowedException("No se Permiten Nulls");
		}
	}

	//Coleccion añadida y Ordenada
	@Override
	public boolean addAll(Collection<? extends E> collection) throws ListSizeOverflownException {

		if (collection.size() + this.size() < MAX_SIZE) {
			super.addAll(collection);
			Collections.sort(this, comparador);
			return true;
		} else {
			throw new ListSizeOverflownException("No cabemos tantos");
		}
	}

	/**
	 * AÃ±ade un objeto en un indice concreto y ordena la lista despues
	 */
	@Override
	public void add(int index, E element) {
		if (element != null) {
			if (this.size() != MAX_SIZE) {
				if (index < MAX_SIZE) {
					super.add(index, element);
					Collections.sort(this, comparador);
				} else {
					throw new ListSizeOverflownException("Supera los indices en la cola");
				}
			} else {
				throw new ListSizeOverflownException("Superado más de 80 en la cola");
			}
		} else {
			throw new ElementNotAllowedException("No se Permiten Nulls");
		}
	}

	/**
	 * AÃ±ade una coleccion a partir de un indice concreto y ordena despues
	 */
	@Override
	public boolean addAll(int index, Collection<? extends E> c) throws ListSizeOverflownException {
		if (index < MAX_SIZE) {
			if (c.size() + index < MAX_SIZE) {
				super.addAll(index, c);
				Collections.sort(this, comparador);
				return true;
			} else {
				throw new ListSizeOverflownException("No se Permiten Nulls");
			}
		} else {
			throw new ListSizeOverflownException("No se Permiten Nulls");
		}
	}

}