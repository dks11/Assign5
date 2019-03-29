/**
This is the linked list class of invoices
@author Dakota Staples
*/

public class InvoiceLinkedList
{
	/**
	This is the head node of the linked list
	*/
	private Node head;
	
	/**
	This is the tail node of the linked list
	*/
	private Node tail;
	
	/**
	This is the size of the linked list
	*/
	private int size;
	
	/**
	This is the constructor for the linked list, setting head and tail to null and size to 0
	*/
	public InvoiceLinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	/**
	This returns the size of the linked list
	@return the size of the linked list
	*/
	public int size()
	{
		return size;
	}

	/**
	This adds a node to the end of the list
	@param invoice the invoice that is being added
	*/
	public void addEnd(Invoice invoice)
	{
		Node addNode = new Node(invoice);
		
		if(head == null)
		{
			head = addNode;
			tail = addNode;
			tail.next = null;
			head.prev = null;
		}

		else
		{
			tail.next = addNode;
			addNode.prev = tail;
			tail = addNode;
		}
		size++;
	}

	/**
	This inserts a node into its correct position into the linked list, using the comparTo method
	@param invoice the invoice that is being inserted into position
	*/
	public void insert(Invoice invoice)
	{
		Node addNode = new Node(invoice);
	
		if(head == null)
		{
			head = addNode;
			tail = addNode;
		}

		else if(addNode.data.compareTo(head.data) < 0)
		{
			addNode.next = head;
			addNode.next.prev = addNode;
			head = addNode;
		}

		else
		{
			Node curr = head;

			while(curr.next != null && curr.data.compareTo(addNode.data) < 0)
			{
				curr = curr.next;
			}
			
			addNode.next = curr;
			addNode.prev = curr.prev;
			curr.prev = addNode;
			addNode.prev.next = addNode;
		}
		size++;
	}

	/**
	This gets the invoice at a selected index
	@return the invoice at the selected index
	*/
	public Invoice getIndex(int index)throws IndexOutOfBoundsException
	{
		if(index > size)
		{
			throw new IndexOutOfBoundsException("Index is too large");
		}
		
		if(index == 0)
		{
			return head.data;
		}
		
		if(index == size)
		{
			return tail.data;
		}
		
		else
		{
			Node curr = head;
			int i = 0;

			while(curr.next != null && i < index)
			{
				curr = curr.next;
				i++;
			}
			
			return curr.data;
		}
		
	}
	
	/**
	This removes a node from the list
	@param invoice The invoice to remove
	@return whether the removal was successful or not
	*/
	public boolean remove(Invoice invoice)
	{
		if (head == null)
		{
            return false; 
        }
		
		if (size == 1) 
		{ 
            head = null;
			tail = null;
			size--;
			return true;
        }
		
		if (tail.data.compareTo(invoice) == 0) 
		{ 
			tail = tail.prev;
			tail.next = null;
			size--;
			return true;
		}
		else
		{
			for (Node curr = head; curr != null; curr = curr.next) 
			{
				if (curr.data.compareTo(invoice) == 0) 
				{
					curr.prev.next = curr.next;
					curr.next.prev = curr.prev;
					size--;
					return true;
				}
			}
		}
		return false;
    }

	/**
	This swaps two nodes in the list
	@param Index1 the first index to swap
	*/
	public void swapValues(int Index1, int Index2)
	{	 
	
		Node temp;
		if(Index1 == 0)
			{
				temp = head;
			}
			
			if(Index2 == size)
			{
				temp = tail;
			}
			
			else
			{
				Node curr = head;
				int i = 0;

				while(curr.next != null && i < Index1)
				{
					curr = curr.next;
					i++;
				}
				
				temp = curr;
			}
			
		Node temp2;
		if(Index1 == 0)
			{
				temp2 = head;
			}
			
			if(Index2 == size)
			{
				temp2 = tail;
			}
			
			else
			{
				Node curr = head;
				int i = 0;

				while(curr.next != null && i < Index2)
				{
					curr = curr.next;
					i++;
				}
				
				temp2 = curr;
			}
			
			Node temp3 = new Node(temp.data);
			temp.data = temp2.data;
			temp2.data = temp3.data;

	}
	
	
	/**
	This prints the list forwards
	*/
	public void print()
	{
		double total = 0;
		Node curr = head; 
		System.out.println("Customer ID \t" +"Invoice Number \t" + "Amount");
		System.out.println("----------------------------------------------");

		while (curr != null) 
		{ 
			total += curr.data.getAmount();
			System.out.print(curr.data.getCustId() + "\t\t" + curr.data.getInvoiceId() + "\t" + curr.data.getAmount() + "\n"); 
			curr = curr.next; 
		}
		System.out.println("----------------------------------------------");
		System.out.println("Total Amount \t\t\t$" + total);
		System.out.println(" ");
		
	}
	
	/**
	This prints the list backwards
	*/
	public void printBackwards()
	{
		double total = 0;
		Node curr = tail; 
		System.out.println("Customer ID \t" +"Invoice Number \t" + "Amount");
		System.out.println("----------------------------------------------");

		while (curr != null) 
		{ 
			total += curr.data.getAmount();
			System.out.print(curr.data.getCustId() + "\t\t" + curr.data.getInvoiceId() + "\t" + curr.data.getAmount() + "\n"); 
			curr = curr.prev; 
		}
		System.out.println("----------------------------------------------");
		System.out.println("Total Amount \t\t\t$" + total);
		System.out.println(" ");
	}
	
	/**
	This gets a subset of the list based on customer id
	@param customerId The customer id to get the subset for
	@return The new subset linked list
	*/
	public InvoiceLinkedList getCustomerSublist(String customerId)
	{
		InvoiceLinkedList list2 = new InvoiceLinkedList();
		Node curr = head; 

        while (curr != null) 
		{ 
			if(curr.data.getCustId().equals(customerId))
			{
				Node addNode = new Node(curr.data);
				list2.addEnd(addNode.data);
			}
            curr = curr.next; 
		}
		return list2;
	}
	
	/**
	This gets the head node
	@return the head node
	*/
	public Node getHead()
	{
		return head;
	}
	
	/**
	This gets the tail node
	@return the tail node
	*/
	public Node getTail()
	{
		return tail;
	}

	/**
	This is the private node class within the linked list class
	*/
	private class Node
	{
		/**
		This is the data in a node
		*/
		public Invoice data;
		
		/**
		This is the previous pointer
		*/
		public Node prev;
		
		/**
		This is the next pointer
		*/
		public Node next;
		
		/**
		This is the constructor of the node
		@param dataIn The data to put in the node
		*/
		public Node(Invoice dataIn)
		{
			data = dataIn;
			prev = null;
			next = null;
		}
	}
}
