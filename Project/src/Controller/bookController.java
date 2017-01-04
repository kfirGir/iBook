package Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import command.searchCommand;
import client.DBSQLhandler;
import client.DBgenericObject;
import Book.book;
import Book.domain;

public class bookController {

	public static ArrayList<book> SearchBook(book b,String condition,DBSQLhandler client)
	{
		// filed is need to look like "bookID,author,..."
		client.searchInDB(new searchCommand<book>(b,condition, "bookID, author"));//call command and client ask to search a book
		while(!client.GetGotMessag()){//search book in db
			try{
			Thread.sleep(500);
			}
			catch(InterruptedException ex)
			{
				System.out.println("InterruptedException "+ex);
			}
		}
		try {
			
			return  (ArrayList<book>) client.getResultObject();
		} catch (SQLException e) {
			return null;
		}
	}
	
	public static ArrayList<domain> GetAllDomain(DBSQLhandler client)
	{
		// filed is need to look like "bookID,author,..."
		//client.getAllTable((new showAllCommand<domain>("domain")));
		return null;

	}
}
