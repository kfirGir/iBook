package Book;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import Extras.Validation;
import client.DBgenericObject;
import command.DBtranslation;
/**
 * This class is the entity 'Review',here saved all the fields like they presents in the DB
 * In this class there are all the getters and setters of the entity Review.
 * When we use the DB-When we insert,delete and update from there we convert the data to be like it saved
 *  in DB and in this class it all happens.
 * @author Coral Carmeli
 *
 */
public class Review extends DBtranslation {

	private int reviewID;
	private String reviewDate;
	private String reviewContent;
	private int reviewStatus;
	private int bookID;
	private String UserSign;
	public static final int CONFIREMED=1;
	public static final int NOTCONFIREMED=0;
	public static final int NOTIFICATION=-1;
	
	/**
	 * Empty constructor of Review
	 */
	public Review(){
		super();
	}
	
	
	/**
	 *constructor of Review with 5 parameteres - reviewID & reviewDate & reviewContent & reviewStatus & bookID
	 */
	public Review(int reviewID, String reviewDate, String reviewContent,int reviewStatus, int bookID) {
		this(reviewDate,reviewContent,reviewStatus,bookID);
		setReviewID(reviewID);
	}
	
	/**
	 *constructor of Review with 4 parameteres - reviewDate & reviewContent & reviewStatus & bookID
	 */
	public Review( String reviewDate, String reviewContent,int reviewStatus, int bookID) {
		super();
		setReviewDate(reviewDate);
		setReviewContent(reviewContent);
		setReviewStatus(reviewStatus);
		setBookID(bookID);
	}
	
	/**
	 *constructor of Review with 3 parameteres - userSign & reviewContent & bookID
	 *this ctor set the status of the review to NOTIFICATION=-1
	 */
	public Review( String reviewContent, int bookID,String userSign) {
		super();
		Calendar time = Calendar.getInstance();
        String timeRightNow = String.format("%1$tY/%1$tm/%1$td", time);
		setReviewDate(timeRightNow);
		setReviewContent(reviewContent);
		setReviewStatus(NOTIFICATION);
		setBookID(bookID);
		setUserSign(userSign);
        
	}
	
	/**
	 *Getter of Domain ID
	 */
	public int getReviewID() {
		return reviewID;
	}
	public void setReviewID(int reviewID) {
		if(reviewID<0)
			throw new InputMismatchException("you have inserted wrong review ID");
		this.reviewID = reviewID;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		if (reviewDate == null || reviewDate.equals("") || Validation.DateValidation(reviewDate) == false)
			throw new InputMismatchException("you have inserted wrong review date");
		this.reviewDate=reviewDate;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		if (reviewContent == null || reviewContent.equals("") || Validation.regularValidation(reviewContent) == false)
			throw new InputMismatchException("you have inserted wrong Content");
		this.reviewContent = reviewContent;
	}
	public int getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(int reviewStatus) {
		switch(reviewStatus){
		case CONFIREMED:
			this.reviewStatus=CONFIREMED;
			break;
		case NOTCONFIREMED:
			this.reviewStatus=NOTCONFIREMED;
			break;
		case NOTIFICATION:
			this.reviewStatus=NOTIFICATION;
			break;
		default:
		throw new InputMismatchException("you have inserted wrong review status");
		}
		this.reviewStatus = reviewStatus;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		if(bookID<0)
			throw new InputMismatchException("you have inserted negative book ID");
		this.bookID = bookID;
	}
	@Override
	public String getClassName() {
		
		return "review";
	}
	@Override
	public String getAttributeToInsert() {
		return "(reviewDate,reviewContent,reviewStatus,bookID,userSign)";
	}
	@Override
	public String getValToInsert() {
		return String.format("(\"%s\",\"%s\",%d,%d,\"%s\")",reviewDate,reviewContent,reviewStatus,bookID,UserSign);
	}

	//convert array Which was obtained from DB to an actual Review
	//need to implement in all tables.!!!
		
		public static ArrayList<Review> convertBack(ArrayList<DBgenericObject> arr,String fromSentence) {
			 ArrayList<Review> convertedArr=new ArrayList<Review>();
			 
			for(DBgenericObject ob:arr)
					convertedArr.add(convertDBObject(ob, fromSentence));//for each val in arr this convert back to book
			
			return convertedArr;
			
		}
		
	//this convert specific  DBgenericObject to book according the fromSentence
		private static Review convertDBObject(DBgenericObject ob,String fromSentenceArray)
		{
			Review recover=new Review();
			 String[] fromSentence=fromSentenceArray.split(",");
			 for(int i=0;i<fromSentence.length;i++)
			 {
				 switch (fromSentence[i]) {
				case "reviewID":
					recover.setReviewID((int)ob.getValtoArray(i));
					break;
				case "reviewDate":
					Date d = (Date)ob.getValtoArray(i);
					String txtDate = new SimpleDateFormat("yyyy/MM/dd").format(d);
					recover.setReviewDate(txtDate);
					break;
				case "reviewContent":
					recover.setReviewContent((String)ob.getValtoArray(i));
					break;
				case "reviewStatus":
					recover.setReviewStatus((int)ob.getValtoArray(i));
					break;
				case "bookID":
					recover.setBookID((int)ob.getValtoArray(i));
					break;
				case "userSign":
					recover.setUserSign((String)ob.getValtoArray(i));
					break;

				default:
					throw new InputMismatchException("you have inserred wrong to search statment");
				 }//end switch
			 }//end for
			 return recover;
			
		}
		@Override
		public String toString() {
			return "Review [reviewID=" + reviewID + ", reviewDate=" + reviewDate + ", reviewContent=" + reviewContent
					+ ", reviewStatus=" + reviewStatus + ", bookID=" + bookID +",userSign="+ UserSign+"]";
		}

		public String getUserSign() {
			
			return UserSign;
		}

		public void setUserSign(String userSign) {
			if (userSign == null || userSign.equals("") || Validation.regularValidation(userSign) == false)
				throw new InputMismatchException("you have inserted wrong Content");
			this.UserSign = userSign;
		}
		
		
		
}

