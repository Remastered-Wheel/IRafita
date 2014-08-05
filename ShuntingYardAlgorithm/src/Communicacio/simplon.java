package src.Communicacio;

import src.Absolut.Ricard;

import src.Exception.EntradaEx.FalsContingutFile;
import src.Exception.EntradaEx.NoExisteixFile;
import src.Exception.EntradaEx.NoTeContingut;

public class simplon
{
	Ricard borracho;
	public simplon ()
	{
		borracho = new Ricard ();
	}

	public void testejarCodi (String e)
	{
		inicia (e);
//		inicia ("ErrorNoExisteix.muhaha");
//		inicia ("errorFaltaSegonaPart.txt");
//		inicia ("errorBuit.txt");	// Problema k no accepta actualment els errors!!
	}

	private void inicia (String e)
	{
		try
		{
			borracho.entrada (e);
			System.out.println (borracho.mostra ());
//			System.out.println (ctrlE.getComEntra ());
//			System.out.println (ctrlE.visualitzaE ()); // igual k entra
//			System.out.println (ctrlE.visualitzaM ()); // com interpreta la maquina
//			System.out.println (ctrlE.visualitzaL ()); // pel LaTeX
		}catch (NoExisteixFile fre){System.out.println (fre);
		}catch (FalsContingutFile fre){System.out.println (fre);
		}//catch (NoTeContingut fre){System.out.println (fre);}
	}
}
