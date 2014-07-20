package InterpretEntradaSortida;

public class superNumberOrOperation
{
	public static boolean isNumeric (String e)
	{ // Negatiu, sense decimal
		/*
		String str = new String (e);
		return str.matches ("-?\\d+(\\d+)?");
		*///Ara el meu sistema
		try
		{
			Integer l = new Integer.parseInt (e);
			return true;
		}catch (Exception Ex)
		{
			return false;
		}
	}
	public String LaTeX (){return "";}
}
