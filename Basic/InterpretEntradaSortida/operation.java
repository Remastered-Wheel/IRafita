package InterpretEntradaSortida;

import InterpretEntradaSortida.superNumberOrOperation;
// Aqui sera lleugerament imporantet
public class operation extends superNumberOrOperation
{
	private int prioritat;
	public int preference (){return prioritat;}
	private String operacio;
	public operation (String e){get (e);}
	public void get (String e)
	{
// Mentres no tingui les classes fetes per les operacions
		operacio = e;
		switch (e)
		{
			case "+":	prioritat = 1;
					break;
			case "-":	prioritat = 1;
					break;
			case "*":	prioritat = 2;
					break;
			case "/":	prioritat = 2;
					break;
			case "^":	prioritat = 3;
					break;
			case "sqrt":	prioritat = 3;
					break;
			case "(":	prioritat = 100;
					break;
			case ")":	prioritat = -100;
					break;
		}
	}
	public String LaTeX (){return operacio;}
}

/*
Tinc previst fer una classe de cada coseta.
Suma, resta, producte, mcd ....
*/
