

public class InvoiceLinkedList
{
	private Node head, tail;
	
	private int size;
	
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
		}

		else
		{
			addNode.prev =tail;
   			tail.next = head;
    			tail = addNode;
		}
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
			int i = 0

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
			for (Node curr = head; curr != null; curr = curr.next()) 
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
		
