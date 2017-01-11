package Book;
import java.sql.Date;
public class Order extends Cart {
	private Date buyDate;

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public Order(int userID,int bookID,int price,Date buyDate)
	{
		super(userID,bookID,price);
		this.status=false;
		this.buyDate=buyDate;
	}
	@Override
	public String getValToInsert() {
		int temp=0;
		if(status)
		temp=1;
		return (String.format("(%d,%d,%d,%f",getUserID(),getBookID(),temp,getPrice())+buyDate);
	}
	@Override
	public String getAttributeToInsert() {
		return "(userID,bookID,status,price,buyDate)";
	}

}