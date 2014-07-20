package InterpretEntradaSortida;

import InterpretEntradaSortida.entradaFitxer;
import InterpretEntradaSortida.superNumberOrOperation;
import InterpretEntradaSortida.nombres;
import InterpretEntradaSortida.operation;

import java.util.Stack;
import java.util.ArrayDeque;


public class polac// extends superNumberOrOperation
{
	private ArrayDeque<superNumberOrOperation> contingut;

	public polac (String e)
	{
		entradaFitxer fitxer = new entradaFitxer ();
		ArrayDeque<String> QuaString = new ArrayDeque<String> ();
		QuaString.addAll (fitxer.LlistatEntrada (e));
		ConversorHumaRPN (QuaString);
	}

	private void ConversorHumaRPN (ArrayDeque<String> e)
	{
		Stack<superNumberOrOperation> pila = new Stack<superNumberOrOperation> ();
		contingut = new ArrayDeque<superNumberOrOperation> ();
		superNumberOrOperation tmpGeneral = new superNumberOrOperation ();
//		superNumberOrOperation tmpNombres = new nombres ();
		operation tmpOperacio = new operation ("+");
		String tmpS;

		Integer prioritat = new Integer (0);
//		contingut.offer (e.poll ()); No em puc donar tal luxe, ja que pot comensar tot amb parentesis.
		while (!e.isEmpty ())
		{
			tmpS = e.poll ();
			if (tmpGeneral.isNumeric (tmpS))
			{
				contingut.add (new nombres (tmpS));
			}else
			{
				tmpOperacio.get (tmpS);
				if (pila.isEmpty ())
				{
					prioritat = tmpOperacio.preference ();
					pila.push (new operation (tmpS));
				}else
				{
// Comenzem per casos extrems
					if (tmpOperacio.preference () == 100)
					{
						pila.push (new operation (tmpS));
					}else if (tmpOperacio.preference () == -100)
					{// Fins no trobar el que obra fer pop
						tmpOperacio = (operation) pila.pop ();
						while (tmpOperacio.preference () != -100)
						{
							contingut.add (tmpOperacio);
							tmpOperacio = (operation) pila.pop ();
						}
					}else
					{
// Ara, penso que aixo sobra. Ja que penso que nomes hi ha realment dos cassos.

// Vegam quan passo a net tots els apunts que agafo i comenzo a fer un pelet de diagrames de flux
// per poder entendre jo mateix que faig. El meu costum de programar sense saber que faig l'hauria de pedre un pelet.
						/*
						switch (prioritat.comprareTo (tmpOperacio.preference ()))
						{
							catch  0: contingut.offer (pila.pop ());
								  pila.push (new operation (tmpS));
								  break;
// Comensa a quedar menys per tenir el RPN preparat
// Tot i ser aixi em fa gracia, perque he estat pensant molt com fer-ho per algebraicament huma...
// Segurament una petita conversio de les meves formuletes a RPN sera necessaria.

// Si aixo es quan prioritat > preference:
							catch  1: pila.push (new operation (tmpS));
								  break;
							catch -1: contingut.offer (pila.pop ());
								  pila.push (new operation (tmpS));
								  break;
						}*/
// Ara ho fare amb un if
						/*if (prioritat > tmpOperacio)
							pila.push (new operation (tmpS));
						else
						{
							contingut.offer (pila.pop ());
							pila.push (new operation (tmpS));
						}*/
						if (prioritat <= tmpOperacio.preference ())
							contingut.add (pila.pop ());
						pila.push (new operation (tmpS));
					}
				}
			}
		}
// Aqui em de buidar si ho si la pila
		while (pila.isEmpty ())
			contingut.add (pila.pop ());
// Ara nomes queda testejar el mateix programa per a veure que passa.
	}

	@Override
	public String toString()
	{
		ArrayDeque<superNumberOrOperation> str = contingut.clone();
		String out = "\n" + str.poll ().LaTeX ();
		while (!str.isEmpty ())
			out += " " + str.poll ().LaTeX ();
		out += "\n";
		return out;
	}
}

// Ara per ara nomes em quedaria comprovar el correcte funcionament del pola gracies a uns testos.
// Preferiria possar uns quans exemples per a veure el resultat.

// Igual que la totalitat. Ja el millorare poc a poc.
// Pero per no bloqueixar-me en un sol pas, com que suposo que ja es funcional passarem al seguent nivell.
