package Seminars1;

import java.util.Arrays;
import java.util.Random;
import java.util.SortedMap;

public class MainService 
{

	private static final float GRAVITY = 9.80665f;
	
	public static void main(String[] args) 
	{
		// --------------- 0. Uzdevums -------------------
		String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt",
				"Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron",
		"Kate" };
	
		int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393,
				299, 343, 317, 265 };
	
		int how_many_elements = names.length;
		if(names.length > times.length)	how_many_elements = times.length;	
		
		for(int i = 0; i < how_many_elements; i++)
			System.out.println(names[i] + " " + times[i] + "sec");

		// --------------- 1. Uzdevums -------------------
		try
		{
			System.out.println("Your position: " + positionCalc(-10, 5, 20) + "m");
		}
		
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}	
		
		// --------------- 2. Uzdevums -------------------
		try
		{
			System.out.println("5! = " + factorialForLoop(5));
		}

		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}	

		// --------------- 3. Uzdevums -------------------
		try
		{
			double[] mas = generateArray(10, 3, 10);
			System.out.println(Arrays.toString(mas));
			System.out.println("Avarage value: " + getMean(mas));
			System.out.println("Sorted array: " + Arrays.toString(arraySort(mas)));
			System.out.println("Max value: " + getMax(mas));
			System.out.println("Min value: " + getMin(mas));
			double[][] arr2D = generateMatrix(4);
			System.out.println(Arrays.deepToString(arr2D));
		}
		

		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}	

		
		
	}
	
	

	
	
	// Ja main ir citas funkcijas, tās visticamāk būs static 
	private static double positionCalc(double initialVelocity, double
		initialPosition, double fallingTime) throws Exception
	{
		//x(t) = 0.5 × a*t^2 + v_0*t + x_0
		
		if(initialVelocity >= 0 && initialPosition >= 0 && fallingTime >= 0)
		{
			double result = 0.5 * GRAVITY * Math.pow(fallingTime, 2) + initialVelocity * fallingTime + initialPosition;
			return result;
		}
		
		else throw new Exception("Nevar aprekinat, jo kads no ievades datiem nav korekts");
	}
	
	private static int factorialForLoop(int N) throws Exception
	{
		if(N > 0)
		{
			int res = 1;
			for(int i = 1; i <= N; i++)
				res *= i;
			return res;
		}
		
		else throw new Exception("Nevar aprekinat, jo ievades N ir negativs vai 0");
	}
	
	private static double[] generateArray(int N, double lower, double upper) throws Exception
	{
		
		if(N <= 0) throw new Exception("Nevar izveidot masivu, kura garums ir negativs");
	
		double[] result = new double[N];
		Random rand = new Random();
		
		for(int i = 0; i < result.length; i++)
			result[i] = rand.nextDouble(lower, upper);
		
		return result;
	}
	
	private static double getMean(double[] array) throws Exception
	{
		if(array == null) throw new Exception("nevar aprekinat videjo vertibu, jo masiva nav elementu");
		if(array.length == 0) throw new Exception("nevar aprekinat videjo vertibu, jo masiva nav elementu");
		
		double sum = 0;
//		for(int i = 0; i < array.length; i++)
//			sum += array[i];
		
		for(double tempA : array)
		{
			sum += tempA;
		}
		double meanValue = sum/array.length;
		return meanValue;
	}
	
	private static double getMin(double[] array) throws Exception
	{
		double[] result = arraySort(array);
		return result[0];
	}
	
	private static double getMax(double[] array) throws Exception
	{
		double[] result = arraySort(array);
		return result[result.length-1];
	}
	
	private static double[] arraySort(double[] array) throws Exception
	{
		if(array == null) throw new Exception("nevar kartot, jo masiva nav elementu");
		if(array.length == 0) throw new Exception("nevar kartot, jo masiva nav elementu");
		
		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < array.length - 1; j++)
				if(array[i] < array[j]) 
				{
					double tempA = array[j];
					array[j] = array[i];
					array[i] = tempA;
				}
		}
		return array;
	}
	
	private static double[][] generateMatrix(int N) throws Exception
	{
		if(N <= 0) throw new Exception("Nevar izveidot masivu, kura garums ir negativs");
	
	
	double[][] array = new double[N][N];
	Random rand = new Random();
	
	
	for(int i = 0; i < array.length; i ++)
	{
		for(int j = 0; j < array.length; j++) 
		{
			array[i][j] = rand.nextDouble();
		}
	}
	
	return array;
	}
//	double getProduct(double[][] matrix, int i, int j)
//	{
//		
//	}
	
}
