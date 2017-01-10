package Book;

import java.util.ArrayList;
import java.util.InputMismatchException;

import client.DBgenericObject;
import command.DBtranslation;

public class SubjectToBook extends DBtranslation {
	private int bookID;
	private int domainID;
	private String nameSubject;

	//empty constactor
	private SubjectToBook(){
		super();
	}
	public SubjectToBook(int bookID, int domainID, String nameSubject) {
		super();
		this.bookID = bookID;
		this.domainID = domainID;
		this.nameSubject = nameSubject;
	}
	public SubjectToBook(int domainID, String nameSubject) {
		super();
		this.domainID = domainID;
		this.nameSubject = nameSubject;
	}

	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getNameSubject() {
		return nameSubject;
	}
	public void setNameSubject(String nameSubject) {
		this.nameSubject = nameSubject;
	}
	public int getDomainID() {
		return domainID;
	}
	public void setDomainID(int domainID) {
		this.domainID = domainID;
	}
	@Override
	public String getClassName() {
		return "subjecttobook";
	}
	@Override
	public String getAttributeToInsert() {
		
		return "(bookID,domainID,nameSubject)";
	}
	@Override
	public String getValToInsert() {
		return String.format("(\"%s\",\"%s\",\"%s\")",bookID,domainID,nameSubject);
		
	}
	
	//convert array Which was obtained from DB to an actual Subject
	//need to implement in all tables.!!!
		
		public static ArrayList<SubjectToBook> convertBack(ArrayList<DBgenericObject> arr,String fromSentence) {
			 ArrayList<SubjectToBook> convertedArr=new ArrayList<SubjectToBook>();
			 
			for(DBgenericObject ob:arr)
					convertedArr.add(convertDBObject(ob, fromSentence));//for each val in arr this convert back to book
			
			return convertedArr;
			
		}
	
	//this convert specific  DBgenericObject to Subject according the fromSentence
	private static SubjectToBook convertDBObject(DBgenericObject ob,String fromSentenceArray)
	{
		SubjectToBook recover=new SubjectToBook();
		 String[] fromSentence=fromSentenceArray.split(",");
		 for(int i=0;i<fromSentence.length;i++)
		 {
			 switch (fromSentence[i]) {
			case "bookID":
				recover.setBookID((int)ob.getValtoArray(i));
				break;
			case "domainID":
				recover.setDomainID((int)ob.getValtoArray(i));
				break;
			case "nameSubject":
				recover.setNameSubject((String)ob.getValtoArray(i));
				break;

			default:
				throw new InputMismatchException("you have inserred wrong to search statment");
			 }//end switch
		 }//end for
		 return recover;
		
	}
	@Override
	public String toString() {
		return "Subject [bookID=" + bookID + ", domainID=" + domainID + ", nameSubject=" + nameSubject + "]";
	}
	
}