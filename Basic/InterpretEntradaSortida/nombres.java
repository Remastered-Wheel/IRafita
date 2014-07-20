package InterpretEntradaSortida;

import InterpretEntradaSortida.superNumberOrOperation;

// Actualment nomes acceptarem enters
public class nombres extends superNumberOrOperation
{
	private int contingut;

	public nombres (String e)
	{
		try
		{
			contingut = (int) Integer.parseInt (e);
		}catch (Exception Ex)
		{
			System.out.println ("Algo no funciona");
		}
	}
//	public void get (String e){contingut = Integer.parseInt (e);}
	public int valor (){return contingut;}
	public String LaTeX (){return contingut.toString ();}
}
