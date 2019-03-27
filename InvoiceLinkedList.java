

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
        if (Index1 != Index2)
		{
  
			Node curr1 = head; 
			while (curr1 != null && curr1.data != getIndex(Index1) ) 
			{ 
				curr1 = curr1.next; 
			} 
	  
			Node curr2 = head; 
			while (curr2 != null && curr2.data != getIndex(Index2) ) 
			{ 
				curr2 = curr2.next; 
			} 
	  
				if (curr1 != null || curr2 != null) 
				{
					if (curr1.prev != null) 
						curr1.prev.next = curr2; 
					else 
						head = curr2; 
			  
					if (curr2.prev != null) 
						curr2.prev.next = curr1; 
					else 
						head = curr1; 
			  
					Node temp = curr1.next; 
					curr1.next = curr2.next; 
					curr2.next = temp; 
				}
		} 
/*
	  Node node1 = getNode(Index1);
	  Node node2 = getNode(Index2);
	  
      if (node1.next == node2 || node2.next == node1) 
      { 
          node1.prev.next = node2; 
          node2.prev = node1.prev; 
		  
          node2.next.next = node1;
          node1.next = node2.next; 
		  
          node1.prev = node2; 
          node2.next = node1; 
      } 
      else 
      { 
          node2.prev = node1.prev); 
          node2.next = node1.next;
		  
          node1.next.prev = node2; 
          previousNode1.setNext(y);
		  
          node1.prev = node2.prev; 
          node1.next = node2.next;
		  
          node2.next.prev = node1; 
          node2.prev.next = node1; 
      }  
*/

/*
	  Node temp = getNode(Index1); 
      Node temp2 = getNode(Index2); 
      getNode(Index1) = temp2; 
      getNode(Index2) = temp; 
*/
	}
	
	
	
	public Node getNode(int index)throws IndexOutOfBoundsException
	{
		if(index > size)
		{
			throw new IndexOutOfBoundsException("Index is too large");
		}
		
		if(index == 0)
		{
			return head;
		}
		
		if(index == size)
		{
			return tail;
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
			
			return curr;
		}
		
	}

	public void print()
	{
		Node curr = head; 

        while (currNode != null) 
		{ 
            System.out.print(curr.data + " "); 
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
	
	public void getCustomerSublist (String customerId)
	

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
		
