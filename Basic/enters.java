// Ja penso en crear una carpeta de nombres...
package Basic;

import java.util.*;
import java.io.*;

/*
Actualment nomes guardara sumes i productes. Com qui no vol la coseta
*/

/*
Tot i ser una idea molt simplona. Veig que la implementacio del
mateix comenza ja a esser un tant complexa.
*/
public class enters implements Serializable
{
	public int contingut;

	public enters (int e)
		contingut = e;
	public boolean esEnter ()
		return true;

	public enters add (enters e)
		return new enters (contingut + e.contingut);

	public String Latex ()
		return contingut.toString ();
}
