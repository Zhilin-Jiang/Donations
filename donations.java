import java.io.*;
import java.util.Scanner;
public class donations {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		final int MaxId = 50;//max of numbers we can have
		int [] idNumbers = new int[MaxId];
		double [] donations = new double[MaxId];
		int numId;
		numId = readFile(idNumbers, donations, MaxId);
		printFile(idNumbers, donations, numId);//print the unsorted input
		System.out.println("After selection sort(ID)\n");
		selectionSort(idNumbers, donations, numId);
		printFile(idNumbers, donations, numId);//print the numbers and donations in selection sort
		System.out.println("After bubble sort(Donation)\n");
		bubbleSort(idNumbers, donations, numId);
		printFile(idNumbers, donations, numId);//print the numbers and donations in bubble sort
	}
	public static int readFile(int[] id, double[]donation, int maxId)throws IOException{
		int donorCount = 0;
		File myinput = new File("myinput.txt");
		Scanner inputFile = new Scanner(myinput);
		while (inputFile.hasNext()) 
		{
			id[donorCount] = inputFile.nextInt();//count the id
			donation[donorCount] = inputFile.nextDouble();//count the donation
			donorCount++;
		}
		inputFile.close();
		return donorCount; 
	}
	public static void printFile(int[] id, double[] donation, int numId)
	{
		System.out.println("ID \t\tDonations");
		for (int count = 0; count < numId; count++)
		{
		   System.out.printf("%d \t\t%6.2f", id[count], donation[count]);
		   System.out.println();
		}
		System.out.println("\n");
	}
	public static void selectionSort(int[] id, double[] donation, int numId)
	{
		int sortId;
		double sortDonation;
		for(int i = 0; i < numId; i++)
		{
			for(int j = i + 1; j < numId; j++)
				if(id[i]>id[j])
				{
					sortId = id[i];
					id[i] = id[j];
					id[j] = sortId;
					sortDonation = donation[i];
					donation[i] = donation[j];
					donation[j] = sortDonation;
				}
		}
	}
	public static void bubbleSort(int[] id, double[] donation, int numId)
	{
		int sortId;
		double sortDonation;
		boolean swapped;
		do {
			swapped = false;
			for(int i = 0; i < numId-1; i++)
			{
				if(donation[i] > donation[i+1])
				{
					
					sortId = id[i];
					id[i] = id[i+1];
					id[i+1] = sortId;
					sortDonation = donation[i];
					donation[i] = donation[i+1];
					donation[i+1] = sortDonation;
					swapped = true;
				}
			}
		}while(swapped);
	}

}
