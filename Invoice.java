/**
This represents an invoice object
@author Dakota Staples
*/
public class Invoice implements Comparable<Invoice>
{
	/**
	The customer ID
	*/
	private String customerId;
	
	/**
	The invoice ID
	*/
	private String invoiceId; 
	
	/**
	The amount of the invoice
	*/
	private double amount;

	/**
	The constructor for the invoice object
	@param customerId The customer ID
	@param invoiceId The invoice ID
	@param amount The amount of the invoice
	*/
	public Invoice(String customerId, String invoiceId, double amount)
	{
		this.customerId = customerId;
		this.invoiceId = invoiceId;
		this.amount = amount;
	}
	
	/**
	This compares one invoice to another by customerID then amount
	@param other The other invoice
	*/
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

	/**
	This gets the invoice amount
	@return the invoice amount
	*/
	public double getAmount()
	{
		return amount;
	}

	/**
	This gets the customer ID
	@return the customer ID
	*/
	public String getCustId()
	{
		return customerId;
	}
	
	/**
	This gets the invoice ID
	@return the invoice ID
	*/
	public String getInvoiceId()
	{
		return invoiceId;
	}
}
		
			



		
