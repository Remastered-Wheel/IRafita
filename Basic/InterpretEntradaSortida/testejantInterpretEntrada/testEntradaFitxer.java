package InterpretEntradaSortida.testejantInterpretEntrada;

import InterpretEntradaSortida.entradaFitxer;
import java.util.ArrayList;

public class testEntradaFitxer
{
	public static void main (String[] args)
	{
		entradaFitxer equacio = new entradaFitxer ();
		ArrayList<String> llistat = equacio.LlistatEntrada ("equacio.provaSimple1.t");

		System.out.println ("Comenza:");

		int i;
		for (i = 0; i < llistat.size (); i++)
			System.out.print ("|" + llistat.get (i) + "|");

		System.out.println ("");
		System.out.println ("Acaba la Llista Simple.");
/*
Aparentment, la llista esta completada. Ara faltaria rebisar la matriu
*/
		double [][] RarCollons = equacio.MatriuEntrada ("matriu.provaSimple1.t");
		int columna = equacio.getColumna ();
		int fila = equacio.getFila ();
		System.out.println ("La matriu remolona");
		int j;
		for (i = 0; i < fila; i++)
		{
			for (j = 0; j < columna; j++)
				System.out.print (" " + RarCollons[i][j]);
			System.out.println ("");
		}
		System.out.println ("Acaba la matriu");
	}
}

/*
Sembla ser que tot funciona correctament. Ja en un futur millorarem el control de les entrades per detallar que volem realment entrar
Per ara em sembla una feina exageradament correcta.
*/
