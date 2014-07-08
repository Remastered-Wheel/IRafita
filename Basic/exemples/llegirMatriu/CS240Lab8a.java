import java.io.*;
import java.util.*;


public class CS240Lab8a
{

/**
 * @param args the command line arguments
 */
	static double [][] matrix = new double[3][3];
	static Scanner input = new Scanner(System.in);


	public static void main(String[] args) throws IOException 
	{
		// Variables
		String fileName = "ArrayValues.txt";




		// print description
		printDescription();

		// read the file
		readFile(fileName);

		// print the matrix
		printArray(fileName, matrix);

		// multiply the matrix
	//	multiplyArray(fileName, matrix);


	}


	// Program Description
	public static void printDescription()
	{
		System.out.println("Your program is to read data from a file named ArrayValues.txt and store the values in a 2D 3 X 3 array.  "
			+ "\nNext your program is to ask the user for a scalar multiplier \n"
			+ "which is then used to multiply each element of the 2D 3 X 3 array.\n\n"); 
						            }



		// Read File
		public static void readFile(String fileName) throws IOException
		{
			String line = "";

			FileInputStream inputStream = new FileInputStream(fileName);
			Scanner scanner = new Scanner(inputStream);
			DataInputStream in = new DataInputStream(inputStream);
			BufferedReader bf = new BufferedReader(new InputStreamReader(in));

			int lineCount = 0;
			String[] numbers;
			while ((line = bf.readLine()) != null)
			{
				numbers = line.split(" ");
				for (int i = 0; i < 3; i++)
				{
					matrix[lineCount][i] = Double.parseDouble(numbers[i]);
				}

				lineCount++;
			}
			bf.close();
		}


		// Print Array      
		public static void printArray(String fileName, double [][] array)
		{
			System.out.println("The matrix is:");

			for (int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++) 
				{
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}

	/*	public static double multiplyArray(String fileName, double[][] matrix)
		{
			double multiply = 0;

			System.out.println("Please enter the scalar multiplier to be used.");
			multiply = input.nextDouble();

			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					matrix[i][j] 

					return multiply;
				}}}*/


} // end of class
