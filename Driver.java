import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
This is the sorter class, it sorts a given linked list
@author Dakota Staples
*/
public class Driver
{
	public static void main(String[] args) throws MissingFileNameArgumentException
	{
		//Checks if the file name is not supplied
		if(args.length == 0)
		{
			throw new MissingFileNameArgumentException("Missing File Name");
		}
		
		FileReader f1;
		BufferedReader b1;
		Scanner stdin;
		Scanner scan;
		
		//Trying to make the file reading objects 
		try
		{
		f1 = new FileReader(args[0]);
		b1 = new BufferedReader(f1);
		stdin = new Scanner(b1);
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found");
			return;
		}
		
		//gets the number of customers
		int numOfCust = stdin.nextInt();
		
		//gets the next line for scanning 
		stdin.nextLine();
		String temp = stdin.nextLine();
		scan = new Scanner(temp);
		scan.useDelimiter(",");
		
		String[] custId = new String[numOfCust];
		InvoiceLinkedList list;
		
		
		try
		{
			//Scanning the customerIds into an array
			for(int i = 0; i < numOfCust; i++)
			{
				custId[i] = scan.next();
			}

			list = new InvoiceLinkedList();
			
			//Scanning the invoices into an linked list
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
		}
		
		catch(InputMismatchException e)
		{
			System.out.println("Wrong Input Given");
			return;
		}
		
		
		list.print();
		
		System.out.println("-------------------------------------------");
		
		Sorter.sort(list);	
		
		list.print();
		
		System.out.println("-------------------------------------------");
		
		System.out.println("Please Enter The Returns File Name ");
		scan = new Scanner(System.in);
		String fileName = scan.nextLine();
		
		//Trying to make the file reading objects 
		try
		{
		f1 = new FileReader(fileName);
		b1 = new BufferedReader(f1);
		stdin = new Scanner(b1);
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found");
			return;
		}
		
		//Checking the returns file and updating the linked list accordingly
		try
		{
			while(stdin.hasNext())
			{
				scan = new Scanner(stdin.nextLine());
				scan.useDelimiter(",");
				
				int code = scan.nextInt();
				String customerId = scan.next();
				String invoiceId =  scan.next();
				double amount =  scan.nextDouble();
				
				Invoice inv1 = new Invoice(customerId,invoiceId,amount);
				
				if(code == 750)
				{
					list.remove(inv1);
				}
				
				else if(code == 850)
				{
					list.insert(inv1);
				}
				
			}
		}
		
		catch(InputMismatchException e)
		{
			System.out.println("Wrong Input Given");
			return;
		}
		
		InvoiceLinkedList list2;
		
		//getting the customer sublist and printing it out forwards and backwards
		for(int i = 0; i <= numOfCust-1; i++)
		{
			list2 = list.getCustomerSublist(custId[i]);
			list2.print();
			list2.printBackwards();
		}
		
		
		
	}
}