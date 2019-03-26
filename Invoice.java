public class Invoice implements Comparable<T>
{
	private String customerId;
	private String invoiceId; 
	private double amount;

	public Invoice(String customerId, String invoiceId, double amount)
	{
		this.customerId = customerId;
		this.customerId = invoiceId;
		this.amount = amount;
	}
	
	public int compareTo(Invoice other)
	{
		if(this.customerId.equals(other.customerId) )
		{
			double TOLERANCE = 1E-14; 
			if((Math.abs(this.getAmount()-other.getAmount()) < TOLERANCE))
				return 0;
			else if((this.getAmount() -other.getAmount()) < TOLERANCE)
				return -1;
			else 
				return 1;
		}

		else if(this.customerId.compareTo(other.customerId) < 0)
			return -1;
		else
			return 1;
	}

	public double getAmount()
	{
		return amount;
	}

	public double getCustId()
	{
		return customerId;
	}
	
	public double getInvoiceId()
	{
		return invoiceId;
	}
}
		
			



		
