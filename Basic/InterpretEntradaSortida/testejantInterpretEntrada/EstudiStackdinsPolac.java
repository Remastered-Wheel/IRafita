package InterpretEntradaSortida.testejantInterpretEntrada;

import InterpretEntradaSortida.polac;

// Com hem canviat el polac, ara es infuncional
public class EstudiStackdinsPolac
{
	public static void main (String[] args)
	{
		polac ex = new polac ("equacio.provaSimple1.t");
	}
}
/* el que contenia pola per a funcionar adecuadament
package InterpretEntradaSortida;

import InterpretEntradaSortida.entradaFitxer;
import InterpretEntradaSortida.superNumberOrOperation;

import java.util.Stack;
import java.util.Queue;
import java.util.ArrayList;



// Confio que el array list eliminar-lo aviat
public class polac extends superNumberOrOperation
{
	private Queue<superNumberOrOperation> contingut;

	public polac (String e)
	{
		entradaFitxer fitxer = new entradaFitxer ();
		ArrayList<String> llistaString = fitxer.LlistatEntrada (e);
		//
		//Experiment actual meu
		//
		System.out.println ("Comenza:");

		int i;
		for (i = 0; i < llistaString.size (); i++)
			System.out.print ("|" + llistaString.get (i) + "|");

		System.out.println ("");
		System.out.println ("Acaba la Llista Simple.");
		//
		//Acaba el meu experiment
		//
		Stack<String> entradaArrayToStack = new Stack<String> ();
		entradaArrayToStack.addAll (llistaString);
		Stack<String> experiment = new Stack<String> ();

		experiment.addAll (entradaArrayToStack);

		System.out.println ("Primera Pila");
		while (!entradaArrayToStack.empty())
			System.out.print ("|" + entradaArrayToStack.pop () + "|");
		System.out.println ("");
		System.out.println ("Ara comensaar la segona");
		while (!experiment.empty())
			System.out.print ("|" + experiment.pop () + "|");
		System.out.println ("");
		System.out.println ("Acabem el nostre experiment.");
	}
}




/*
public static boolean isNumeric(String str)
{
	return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
}
*/
