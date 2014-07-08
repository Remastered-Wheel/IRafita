package matrius;
/*
Aquesta es la primera versio. On no tenim ni variables ni arrels, ni solucionari d'equacions.
Perque? Simple, perque encara no he fet les classes que ho fassin.

Dependencies del futur
	variables
	arrels
	equacions
	complexos
	nombres de presisio infinita
	nombres de presisio finita
	Llibreria Itertools CAsero fet per mi. per a fer matrius facilment en strings stil python

De moment em costa pensar en mes tot i saber que en tindra mes.
*/
// Quan recordi, aqui importo les cossetes.
import java.util.*;
import java.io.*;
//import java.util.ArrayList; No taria mal fer-ho anar

// m'ha dit de fer anar Maven. Una llibreria de java

// Tambe voldria fer anar Git, i sobretot github. Ja veurem en un futur proxim

/**
 * Files per columnes
 * @author arnau
 */
// Ara no recordo per a res quina diferencia hi havia entre public, private... etc llarg
public class matriu implements Serializable
{
	private int columnes;
	private int files;
// Files // columnes
	private double [][] contingut;

// Puta merda
	static Scanner input = new Scanner(System.in);

// En referencia al editor de text, si detectes les llibreries en consequencia estaria be que sapigues que posar
// un cop ja has escrit el famos punt.


	// Aquest m'agradaria que no fos aqui... Aqui nomes tractar
	// amb matrius de numeros i punt.
// Representa que les dues primeres linies indiquen de quan es la
	// matriu
	public void inMatrixText (String fileName) throws IOException // FUNCIONA
	{
// De moment exageradament copy past
		String line = "";
		FileInputStream inputStream = new FileInputStream(fileName);
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
	}


// Cutre, per terminal, idea 1 FUNCIONA
	public void printMatrix ()
	{
		System.out.println ();
		for (int i = 0; i < files; i++)
		{
			for (int j = 0; j < columnes; j++)
			{
				System.out.print (contingut[i][j] + "	");
			}
		System.out.println ();
		}
	System.out.println ();
	}

/*
   Realment te molt bona pinta. Ara nomes queda quan evolucioni
   doncs tenir-ho tot prepararet per variables i altres.
*/
	public String LatexMatrix ()
	{
		String out = "\\begin{pmatrix}\n";
		int j, i;
		for (i = 0; i < files; i++)
		{
			out += "	" + Double.toString (contingut[i][0]);
			for (j = 1; j < columnes; j++)
			{
				out += "	&	" + Double.toString (contingut[i][j]);
			}
			out += "	\\\\\n";
		}
		out += "\\end{pmatrix}\n";
	return out;
	}

/*
   Aqui podem apreciar que ens falta el consepte d'equacionos i variables.
   Pero almenys ja es funcional.
*/
	public double determinant ()
	{
		if (columnes != files)
			return 0;
		if (files == 1)
			return contingut[0][0];
		if (files == 2)
			return (contingut[0][0] * contingut[1][1]) - (contingut[1][0] * contingut[0][1]);

		double tot = 0, nega = 0, tmpProd;
		int i, j;
	// Possitiu
		for (i = 0; i < columnes; i++)
		{
			tmpProd = 1;
			for (j = 0; j < columnes; j++)
				tmpProd *= contingut[(i+j)%files][j];
			tot += tmpProd;
		}
	// Negatiu
		for (i = 0; i < columnes; i++)
		{
			tmpProd = 1;
			for (j = 0; j < files; j++)
				tmpProd *= contingut[(i+j)%files][files - j - 1];
			nega += tmpProd;
		}
		return tot - nega;
	}

	// Encara no he testejat el determinant. Pero un cop fet, he de saber treure el menor
	// I un cop sapigut fer aixo. El adjunt.

// Crec que nomes sera per a fer adjunts. Aixi que dubto que sigui necessari definir columna i files
	private matriu GeneramMatriu (double [][] e, int efil, int ecol)
	{
		matriu lola = new matriu ();
		lola.defineColumnesAFiles (e, efil, ecol);
		return lola;
	}
// Com que em porta problemes o aixo crec sobre definir cada element... doncs aqui a lo guarro
	private void defineColumnesAFiles (double [][] e, int efil, int ecol)
	{
		columnes = ecol;
		files = efil;
		contingut = e;
	}

// Nou dubte, que son els cofactors d'una matriu??????

// Doncs si, encara no he testejat res que ja vull programar el adjunt.
	public void adjuntMatriu ()
	{
		double[][] sortida = new double [files][columnes];
		int i, j;
		for (i = 0; i < files; i++)
			for (j = 0; j < columnes; j++)
				sortida[i][j] = singe (j + i) * self.menor (i, j).determinant ();
		contingut = sortida;
	}

	private int signe (int k)
	{
		k %= 2;
		if (k == 0)
			return 1;
		return -1;
	}

// Uix, que encara no he fet el menor xD
	public matriu menor (int pfila, int pcolumna)
	{
		double [][] lili = new double [files - 1][columnes - 1];
		int i, j, ki = 0, kj = 0;
		for (i = 0; i < files - 1; i++)
		{
			if (i != pfila)
			{
				for (j = 0; < columnes - 1; j++)
				{
					if (j != pcolumna)
					{
						lili[i - ki][j - kj] = contingut[i][j];
					} else
					{
						kj = 1;
					}
				}
			} else
			{
				ki = 1;
			}
		}
		return GeneramMatriu (lili, files - 1, columnes - 1);
	}
	// Porto massa temps sense testejar el mateix programa....
	// Aixi que la seguent versio simplement sera aquest pero corregit i funcional.
	// potser alguna coseta mes. Pero no us feu gaires ilucions.
}
