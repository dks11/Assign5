public class Sorter
{
	
	public static void sort(InvoiceLinkedList list)
	{
		for(int i = 0; i < list.size()-1; i++) 
            if(list.getIndex(i).compareTo(list.getIndex(i+1)) < 0)
			{
				list.swapValues(i,i+1);
			}
	
	}

}