

public class InvoiceLinkedList
{
	private Node head, tail;
	
	private int size;
	
	public InvoiceLinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	public int size()
	{
		return size;
	}

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

	public void insert(Invoice invoice)
	{
		Node addNode = new Node(invoice);
	
		if(head == null)
		{
			head = addNode;
			tail = addNode;
		}

		else if(addNode.data.compareTo(invoice) < 0)
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
			
			addNode.next = curr.next;
			addNode.prev = curr;
			curr.next = addNode;
			addNode.next.prev = addNode;
		}
		size++;
	}

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
	
	
	
	public void print()
	{
		Node curr = head; 
		System.out.println("Customer ID \t" +"Invoice Number \t" + "Amount");
		System.out.println("----------------------------------------------");

		while (curr != null) 
		{ 
			System.out.print(curr.data.getCustId() + "\t\t" + curr.data.getInvoiceId() + "\t" + curr.data.getAmount() + "\n"); 
			curr = curr.next; 
		}
	}
	
	public void printBackwards()
	{
		Node curr = tail; 

        while (curr != null) 
		{ 
            System.out.print(curr.data + " "); 
            curr = curr.prev; 
		}
	}
	
	public InvoiceLinkedList getCustomerSublist(String customerId)
	{
		InvoiceLinkedList list2 = new InvoiceLinkedList();
		Node curr = head; 

        while (curr != null) 
		{ 
			if(curr.data.getCustId() == customerId)
			{
				Node addNode = new Node(curr.data);
				list2.addEnd(addNode.data);
			}
            curr = curr.next; 
		}
		return list2;
	}
	
	public Node getHead()
	{
		return head;
	}
	
	public Node getTail()
	{
		return tail;
	}
	
	public Node createNode()
	{
		Node curr = null;
		return curr;
	}

	private class Node
	{
		public Invoice data;
		public Node prev, next;
		
		public Node(Invoice dataIn)
		{
			data = dataIn;
			prev = null;
			next = null;
		}
	}
}
