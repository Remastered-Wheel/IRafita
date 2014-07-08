package matrius;

import java.util.Scanner;
import java.io.*;

import matrius.matriu;

public class provaMatriu
{
	public static void main(String[] args) throws IOException
	{
		String a = "lolaMola";
		//String a = new String (Files.readAllBytes ("lolaMola"));
		System.out.println (a);

		matriu lola = new matriu ();
		lola.inMatrixText (a);
		lola.printMatrix ();
		System.out.println("Ara be el que mola de debo:");
		System.out.println (lola.LatexMatrix ());
	}
}
