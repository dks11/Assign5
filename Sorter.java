
public class Sorter{

	public static void sort(InvoiceLinkedList list){
		int min;
		Invoice temp;

		for (int i = 0; i < list.size()-1; i++)
	    {
			min = i;
			for (int scan = i+1; scan < list.size(); scan++)
			{
		    	if (list.getIndex(scan).compareTo(list.getIndex(min)) < 0)
					min = scan;
			}

			// Swap the values
			list.swapValues(min,i);
	    }
	}
	
}