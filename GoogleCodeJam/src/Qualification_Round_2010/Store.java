package Qualification_Round_Africa_2010;
import java.util.Arrays;


public class Store 
{
    private int credit;
    private int noOfItems;
    private int[] costOfItems;
    
	/**
	 * @return the credit
	 */
	public int getCredit() {
		return credit;
	}
	/**
	 * @param credit the credit to set
	 */
	public void setCredit(int credit) {
		this.credit = credit;
	}
	/**
	 * @return the noOfItems
	 */
	public int getNoOfItems() {
		return noOfItems;
	}
	/**
	 * @param noOfItems the noOfItems to set
	 */
	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}
	/**
	 * @return the costOfItems
	 */
	public int[] getCostOfItems() {
		return costOfItems;
	}
	/**
	 * @param costOfItems the costOfItems to set
	 */
	public void setCostOfItems(int[] costOfItems) {
		this.costOfItems = costOfItems;
	}
	
	@Override
	public String toString() {
		return "Store [credit=" + credit + ", noOfItems=" + noOfItems
				+ ", costOfItems=" + Arrays.toString(costOfItems) + "]";
	} 

}
