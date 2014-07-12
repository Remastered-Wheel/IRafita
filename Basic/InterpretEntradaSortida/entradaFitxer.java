package InterpretEntradaSortida;

import java.io.File;
import java.io.InputStream;


public class entradaFitxer ()
{
	public boolean  EntradaManualString (String e)
	{
		File file = new file (e);
		if (file.exists ())
		{
			return EntradaManualFile (File file);
		}
		System.out.println ("El fitxer no existeix.");
		return false;
	}

	public boolean EntradaManualFileMatriu (File e)
	{
		try
		{
// De moment exageradament copy past
			String line = "";
			FileInputStream inputStream = new FileInputStream(e);
			Scanner scanner = new Scanner (inputStream);
			DataInputStream in = new DataInputStream (inputStream);
			BufferedReader bf = new BufferedReader (new InputStreamReader (in));

			columnes = Integer.parseInt (bf.readLine ());
			files = Integer.parseInt (bf.readLine ());
			contingut = new double [files][columnes];

			int lineCount = 0;
			String[] numbers;
			while ((line = bf.readLine ()) != null)
			{
				numbers = line.split (" ");
				for (int i = 0; i < columnes; i++)
				{
					contingut[lineCount][i] = Double.parseDouble (numbers[i]);
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

	public boolean EntradaManualFile (File e)
	{
		try
		{
			FileInputStream inputStream = new FileInputStream(e);
			Scanner scanner = new Scanner (inputStream);
			DataInputStream in = new DataInputStream (inputStream);
			BufferedReader bf = new BufferedReader (new InputStreamReader (in));

			ArrayList<String> contingut = new ArrayList<String> ();
			contingut.addAll (bf.readLine ().split (" "));
			return true;
		}catch{return false;}
	}
}


// Em critico pq fa molt que no faig cap test
