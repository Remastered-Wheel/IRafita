package InterpretEntradaSortida;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
// Per un futur, intentar canviar el Array per un Queue

import java.util.Scanner;
import java.io.DataInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;


/*
Despres fer llista: LlistatEntrada
	    matriu: MatriuEntrada
*/
public class entradaFitxer
{
	private File fitxer;

// Si equacions:
	private ArrayList<String> contingut;

// Si matriu:
	private double [][] contingutMatriu;
	private int columnes;
	private int files;

	private boolean  EntradaManualString (String e)
	{
		fitxer = new File (e);
		if (fitxer.exists ())
		{
			return true;
		}
		System.out.println ("El fitxer no existeix.");
		return false;
	}

	private boolean EntradaManualFileMatriu ()
	{
		try
		{
// De moment exageradament copy past
			String line = "";
			FileInputStream inputStream = new FileInputStream(fitxer);
			Scanner scanner = new Scanner (inputStream);
			DataInputStream in = new DataInputStream (inputStream);
			BufferedReader bf = new BufferedReader (new InputStreamReader (in));

			files = Integer.parseInt (bf.readLine ());
			columnes = Integer.parseInt (bf.readLine ());
			contingutMatriu = new double [files][columnes];

			int lineCount = 0;
			String[] numbers;
			while ((line = bf.readLine ()) != null)
			{
				numbers = line.split (" ");
				for (int i = 0; i < columnes; i++)
				{
					contingutMatriu[lineCount][i] = Double.parseDouble (numbers[i]);
				}
				lineCount++;
			}
			bf.close();
			return true;
		}catch (Exception exept)
		{
			return false;
		}
	}

/*
Les equacions hauran d'acabar amb un punt.
*/
	private boolean EntradaManualFile ()
	{
		try
		{
			FileInputStream inputStream = new FileInputStream(fitxer);
			Scanner scanner = new Scanner (inputStream);
			DataInputStream in = new DataInputStream (inputStream);
			BufferedReader bf = new BufferedReader (new InputStreamReader (in));

			contingut = new ArrayList<String> ();
			//contingut.addAll (bf.readLine ().split (" "));
			String[] tmp = bf.readLine ().split (" ");
			int i;
			for (i = 0; !tmp[i].equals ("."); i++)
				contingut.add (tmp[i]);
			return true;
		}catch (Exception Exce){
			return false;
		}
	}

/*
Aparentment funciona adequadament. Tot un exit.
*/
	public ArrayList<String> LlistatEntrada (String e)
	{
		if (EntradaManualString (e))
			if (EntradaManualFile ())
				return contingut;
		System.out.println ("Hi ha agut un problema a nivell Entrada Fitxer.");
		contingut.clear ();
		return contingut;
	}

// Ara queda fer per les matrius. Ara ho provem
	public double [][] MatriuEntrada (String e)
	{
		if (EntradaManualString (e))
			if (EntradaManualFileMatriu ())
				return contingutMatriu;
		System.out.println ("Hi ha un problema a nivell Entrada Fitxer");
		return contingutMatriu;
	}

	public int getColumna (){return columnes;}
	public int getFila (){return files;}
}


// Em critico pq fa molt que no faig cap test

/*
Progecte en un futur inmediat

Fer que el mateix fitxer especifiqui realment que sentra.
Si matriu dimensions d'aquesta

Si Una sola equacio, llavors dit el grau maxim, despres disminuir d'un en un per exemple o marcar el grau d'una altre forma mes humana

Si sistema d'equacions

Ho una mera operacio simplona


Teoricament. La mateixa interficie... que funcionara amb events i terminal (en aixo compto), tindrem que podra generar tot aixo per a tenir
com un historial de tot el que anem fent si esque es desitjat... (semi configurable ho amb historial limitat)
*/
