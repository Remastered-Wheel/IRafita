package InterpretEntradaSortida.testejantInterpretEntrada;

import InterpretEntradaSortida.entradaFitxer;
import java.util.ArrayList;

public class testEntradaFitxer
{
	public static void main (String[] args)
	{
		entradaFitxer equacio = new entradaFitxer ();
		ArrayList<String> llistat = equacio.LlistatEntrada ("equacio.provaSimple1");

		System.out.println ("Comenza:");

		int i;
		for (i = 0; i < llistat.size (); i++)
			System.out.print ("|" + llistat.get (i) + "|");

		System.out.println ("Acaba la Llista Simple.");
/*
Aparentment, la llista esta completada. Ara faltaria rebisar la matriu
*/
	}
}
