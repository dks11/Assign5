import java.io.*;
import java.util.Scanner;

public class Driver
{
	public static void main(String[] args) throws MissingFileNameArgumentException
	{
		if(args.length == 0)
		{
			throw new MissingFileNameArgumentException("Missing File Name");
		}
		
		FileReader f1;
		BufferedReader b1;
		Scanner stdin;
		Scanner scan;
		
		try
		{
		f1 = new FileReader(args[0]);
		b1 = new BufferedReader(f1);
		stdin = new Scanner(b1);
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
			return;
		}
		
		int numOfCust = stdin.nextInt();
		stdin.nextLine();
		String temp = stdin.nextLine();
		for(int i = 0; i < numOfCust; i++)
		{
			scan = new Scanner(temp);
			scan.useDelimiter(",");
			String custId = scan.next();
		}
		InvoiceLinkedList list = new InvoiceLinkedList();
		
		
		while(stdin.hasNext())
		{
			scan = new Scanner(stdin.nextLine());
			scan.useDelimiter(",");
			
			String customerId = scan.next();
			String invoiceId =  scan.next();
			double amount =  scan.nextDouble();
			Invoice inv1 = new Invoice(customerId,invoiceId,amount);
			list.addEnd(inv1);
		}
		list.print();
		/*
		Sorter.sort(list);
		
		list.print();
		*/
	}
}