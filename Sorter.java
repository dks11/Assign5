/**
This is the sorter class, it sorts a given linked list
@author Dakota Staples
*/
public class Sorter{

	/**
	This is the sorting method that sorts the list
	@param list The linked list
	*/
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

			list.swapValues(min,i);
	    }
	}
	
}