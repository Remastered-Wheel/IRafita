package Basic;

import Basic.enters;

import java.util.*;
import java.io.*;

/*
Actualment nomes guardara sumes i productes. Com qui no vol la coseta
Enters, sera nomes per transformar el desagradable binari al perfecte
nombre
*/

/*
Tot i ser una idea molt simplona. Veig que la implementacio del
mateix comenza ja a esser un tant complexa.
*/

/*
noto gran complexitat per el ordre de computar...
*/
public class conjuntEnters extends enters implements Serializable
{
// No se com ordenar les operacions logiques...
// Tinc pensat el que programacio I em va mostrar...
// Pero ara no el recordo
// Se que estava guardat en una de les llistes de problemes de
// programacio I	


// Proposta meva. Vegam que tal. tot com entre parentesis i voila!

	private String operacio;
	private Object contingut1;
	private Object contingut2;

	public conjuntEnters (Object e1, Object e2, String eoper)
	{
		contingut1 = e1;
		contingut2 = e2;
		operacio = eoper;
	}

	public enters opera ()
	{
		switch (operacio)
		{
		case "Suma": return sumar ();
		case "Resta": return restar ();
		}
	}

	private boolean esEnter ()
		return false;

	private enters sumar ()
	{
		if (contingut1.esEnter ())
		{
			return contingut1.add (contingut2);
		}else{
			if (contingut2.esEnter ())
			{
				contingut2.add (contingut1.opera ());
			}else{
				return contingut1.opera ().add (contingut2.opera ());
			}
		}
	}

	private enters restar ()
	{
		return new enters (8);
	}

	private 

}
