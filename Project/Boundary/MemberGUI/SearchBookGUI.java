package MemberGUI;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import client.DBgenericObject;
import command.searchCommand;
import command.showAllCommand;
import Book.Book;
import Book.Domain;
import Book.SearchToBook;
import Book.SubjectToBook;
import Controller.FormatController;
import Controller.BookController;
import ManagmentGUI.RemovePartReviewGUI;
import MenuGUI.LoginGUI;
import Role.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.SwingConstants;

/**
 * The class take care of the Search book functionality- after the user insert the details he want search according to them-
 * the method gather all the information and do the requested manipultions to give the user the requested results.
 * @author  Coral Carmeli
 */
public class SearchBookGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	public JButton btnBack;
	private LoginGUI screen;
	private JPanel pann;
	private ImageIcon backIcon;
	private JLabel lblSearchBook;
	private JCheckBox chckbxTitle;
	private JCheckBox chckbxAuthor;
	private JCheckBox chckbxLanguage;
	private JCheckBox chckbxSummary;
	private JCheckBox chckbxContents ;
	private JTextField textTitle;
	private JTextField textAuthor;
	private JCheckBox chckbxKeywords;
	private JCheckBox chckbxDomain;
	private JComboBox<Domain> comboBoxDomain;
	private JTextField textFieldLanguage;
	private JTextField textFieldKeywords;
	private JTextField textFieldSummary;
	private JTextField textFieldContents;
	private JButton btnSearch;
	private int flagIsEmpty=0;
	private int flagError;
	private int flagNotFoundBook;
	private int flagNotFoundBook2;
	private ArrayList<Book> bookKeywordsChoose=null;
	private ArrayList<Book> bookDomainList=null;
	private ArrayList<Book> tempBookList = null;
	private ArrayList<Book> tempBookListBookList1 = null;	
	private ArrayList<Book> tempBookListBookList2 = null;
	private ArrayList<Book> tempBookListBookList3 = null;
	/**
	 * Constructor of the SearchBookGUI class
	 * @param screen This is the main window-login
	 * @author  Coral Carmeli
	 */	
	public SearchBookGUI(LoginGUI screen) {
		super();
		this.screen = screen;
		pann = this;
		initialize();	
	}
	/**
	 * This method initialize The window of search book-puts the components on the screen and set their functionality
	 * @author  Coral Carmeli
	 */
	private void initialize() {

		this.setSize(850, 625);
		this.setLayout(null);
		String domains[] = new String[3];

		for (int i = 0; i < 3; i++) {
			domains[i] = "Domain " + i;
		}

		backIcon = new ImageIcon("Extras/Images/backIcon.png");
		btnBack = new JButton(backIcon);// declaration of back button
		btnBack.setBounds(35, 25, 89, 30);
		add(btnBack);
		
		lblSearchBook = new JLabel("Search Book");
		lblSearchBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchBook.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblSearchBook.setBounds(355, 49, 175, 22);
		add(lblSearchBook);

		chckbxTitle = new JCheckBox("Title");
		chckbxTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxTitle.setBounds(90, 150, 111, 30);
		add(chckbxTitle);

		chckbxAuthor = new JCheckBox("Author");
		chckbxAuthor.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxAuthor.setBounds(90, 200, 111, 30);
		add(chckbxAuthor);

		chckbxLanguage = new JCheckBox("Language");
		chckbxLanguage.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxLanguage.setBounds(90, 250, 111, 30);
		add(chckbxLanguage);

		chckbxSummary = new JCheckBox("Summary");
		chckbxSummary.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxSummary.setBounds(90, 300, 111, 30);
		add(chckbxSummary);

		chckbxContents = new JCheckBox("Contents");
		chckbxContents.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxContents.setBounds(90, 350, 111, 30);
		add(chckbxContents);

		chckbxKeywords = new JCheckBox("Keywords");
		chckbxKeywords.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxKeywords.setBounds(90, 400, 111, 30);
		add(chckbxKeywords);

		chckbxDomain = new JCheckBox("Domain");
		chckbxDomain.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxDomain.setBounds(90, 450, 111, 30);
		add(chckbxDomain);
		comboBoxDomain = new JComboBox<Domain>();
		comboBoxDomain.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Domain d=new Domain();
		ArrayList<Domain> domainList=FormatController.GetAllDomain(d, screen.getClient());
		
		for (Domain d1:domainList) {
			comboBoxDomain.addItem(d1);
		}
		comboBoxDomain.setBounds(210, 452, 150, 30);
		add(comboBoxDomain);

		textFieldSummary = new JTextField();
		textFieldSummary.setBounds(210, 302, 150, 30);
		add(textFieldSummary);
		textFieldSummary.setColumns(10);

		textFieldContents = new JTextField();
		textFieldContents.setColumns(10);
		textFieldContents.setBounds(210, 352, 150, 30);
		add(textFieldContents);

		textFieldKeywords = new JTextField();
		textFieldKeywords.setColumns(10);
		textFieldKeywords.setBounds(210, 402, 150, 30);
		add(textFieldKeywords);

		textTitle = new JTextField();
		textTitle.setBounds(210, 150, 150, 30);
		add(textTitle);
		textTitle.setColumns(10);

		textAuthor = new JTextField();
		textAuthor.setBounds(210, 202, 150, 30);
		add(textAuthor);
		textAuthor.setColumns(10);

		textFieldLanguage = new JTextField();
		textFieldLanguage.setBounds(210, 252, 150, 30);
		add(textFieldLanguage);
		textFieldLanguage.setColumns(10);
		
		/**
		 * The button 'search' responsible on the functionality of the method
		 * The logic of the search is in this listener.
		 * first,the action check if one of the check boxs are chose and if not show an error message.
		 * next, the action notice who of the first 5 check box is chosen and compose some condition.
		 * according to the check box selectedd- the condition gather togheter with some intersections if needed.
		 * finally-the method show the user the requested search.
		 * @author Coral Carmeli
		 * @author Almog Yamin
		 */
		ArrayList<Book> bookss=new ArrayList<Book>();
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
// //////////////////////button back to Search book GUI// /////////////////////////////////////////////
				SearchBook sb = new SearchBook(screen,bookss);
				sb.btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//SearchBookGUI pan=new SearchBookGUI(screen);
						screen.setContentPane(pann);
					}
// //////////////////////button back to Search book GUI/////////////////////////////////////////////
				});
				Book b=new Book();
				flagIsEmpty = 0;
				flagError=0;
				flagNotFoundBook = 0;
				flagNotFoundBook2 = 0;
				
				if((chckbxTitle.isSelected()||chckbxLanguage.isSelected()||chckbxAuthor.isSelected()||chckbxSummary.isSelected()||chckbxContents.isSelected()||chckbxDomain.isSelected()||chckbxKeywords.isSelected()))
				{
					String condition = "";//initialize the condition
					if (chckbxTitle.isSelected())
						if(textTitle.getText().isEmpty())
							flagIsEmpty = 1;
						else
							condition +="title LIKE '%"+textTitle.getText().trim() +"%'";
					if (chckbxLanguage.isSelected()) {
						if(textFieldLanguage.getText().isEmpty())
							flagIsEmpty = 1;
						else
						{
							if (!condition.equals(""))
								condition += " && ";
							condition += "language LIKE '%" + textFieldLanguage.getText().trim() + "%'";//add "language" to condition
						}
					}
					if (chckbxAuthor.isSelected()) {
						if(textAuthor.getText().isEmpty())
							flagIsEmpty = 1;
						else
						{
							if (!condition.equals(""))
								condition += " && ";
							condition += "author LIKE '%" + textAuthor.getText().trim() + "%'";//add "author" to condition
						}
					}
					if (chckbxSummary.isSelected()) {
						if(textFieldSummary.getText().isEmpty())
							flagIsEmpty = 1;
						else
						{
							if (!condition.equals(""))
								condition += " && ";
							condition += "summary LIKE '%" + textFieldSummary.getText() + "%'";//add "summary" to condition
						}
					}
					if (chckbxContents.isSelected()) {
						if(textFieldContents.getText().isEmpty())
							flagIsEmpty = 1;
						else
						{
							if (!condition.equals(""))
								condition += " && ";
							condition += "content LIKE '%" +textFieldContents.getText() + "%'";//add "content" to condition
						}
					}
					if (!condition.equals(""))
						condition+=" && bookEnable=\""+1+"\"";
					if (chckbxDomain.isSelected()) 
						{	
							SubjectToBook s=new SubjectToBook();
							Domain d=(Domain)comboBoxDomain.getSelectedItem();
							ArrayList<SubjectToBook> subjectDomainList=FormatController.SearchBookInSubjectToBookAccordingDomain("bookID", s, "DomainID=\""+d.getDomainID()+"\"", screen.getClient());
							if(subjectDomainList!=null)
							{
								Book b1=new Book();
								ArrayList<Book> allBooks=BookController.SearchBook("bookID,title,language,author,summary,content,keyword,price", b1, "bookEnable=\""+1+"\"", screen.getClient());
								bookDomainList = new ArrayList<Book>();
								for(Book b2:allBooks)
									for(SubjectToBook s1:subjectDomainList)
										if(b2.getBookID()==s1.getBookID())
											bookDomainList.add(b2);
							}	
							else
								flagNotFoundBook = 1;													
					}
					if (chckbxKeywords.isSelected()) {
						if(textFieldKeywords.getText().isEmpty())
							flagIsEmpty = 1;
						else
						{
							bookKeywordsChoose = new ArrayList<Book> ();
							bookKeywordsChoose=BookController.searchKeywords(textFieldKeywords.getText(),screen.getClient());
							if(bookKeywordsChoose==null)
								flagNotFoundBook = 1;
						}
					}
					if(flagError == 0)
						if(flagIsEmpty == 0)
							if(flagNotFoundBook == 0)//the best schenario
							{
								tempBookList = new ArrayList<Book> ();
								tempBookListBookList1 = new ArrayList<Book>();	
								tempBookListBookList2 = new ArrayList<Book>();
								tempBookListBookList3 = new ArrayList<Book>();
								if(!(condition == ""))
								{
										
									tempBookList = BookController.SearchBook("bookID,title,language,author,summary,content,keyword,price",b,condition, screen.getClient());//call search book method from book controller
									if(tempBookList!=null)
									{
										if ( bookKeywordsChoose!= null) 
										{	
											for(Book b1:bookKeywordsChoose)
												for(int i=0;i<tempBookList.size();i++)
													if(tempBookList.get(i).getBookID()==b1.getBookID())
														tempBookListBookList1.add(b1);
											if(tempBookListBookList1.isEmpty())
												flagNotFoundBook2=1;	
										}
										else
											if(chckbxKeywords.isSelected())
												flagNotFoundBook2=1;
										
										if( bookDomainList!= null)
										{
											for(Book b1:bookDomainList)
												for(int i=0;i<tempBookList.size();i++)
													if(tempBookList.get(i).getBookID()==b1.getBookID())
														tempBookListBookList2.add(b1);
											if(tempBookListBookList2.isEmpty())
												flagNotFoundBook2=1;
										}
										else
											if(chckbxDomain.isSelected())
												flagNotFoundBook2=1;
										if(chckbxDomain.isSelected()&&(chckbxKeywords.isSelected()))
										{
											for(Book b1:tempBookListBookList1)
												for(Book b2:tempBookListBookList2)
													if(b1.getBookID()==b2.getBookID())
														tempBookListBookList3.add(b1);
													
											if(!tempBookListBookList3.isEmpty())
												tempBookList=tempBookListBookList3;
											else
												flagNotFoundBook2=1;				
										}
										else if(chckbxKeywords.isSelected())
											tempBookList=tempBookListBookList1;
										else if(chckbxDomain.isSelected())
											tempBookList=tempBookListBookList2;				
									}
									else
										flagNotFoundBook2=1;								
								}
								else
								{
									if(chckbxDomain.isSelected()&&(chckbxKeywords.isSelected()))
									{
										tempBookList = new ArrayList<Book>();
										if(( bookKeywordsChoose!= null) && ( bookDomainList!= null) )
										{	
											for(Book b1:bookDomainList)
											{
												for(int i=0;i<bookKeywordsChoose.size();i++)
													if(bookKeywordsChoose.get(i).getBookID()==b1.getBookID())
														tempBookList.add(b1);
											}
											if(tempBookList.isEmpty())
												flagNotFoundBook2=1;
										}
										else
											flagNotFoundBook2=1;
									
									}
									else if(chckbxKeywords.isSelected())											
												if(bookKeywordsChoose!= null)
													tempBookList = bookKeywordsChoose;
												else
													flagNotFoundBook2=1;																					
									else if(chckbxDomain.isSelected())									
										if(bookDomainList!= null)
											tempBookList = bookDomainList;
										else
											flagNotFoundBook2=1;																						
								}
								if(flagNotFoundBook2 == 0 )
								{
									textFieldLanguage.setText("");
									textFieldKeywords.setText("");
									textFieldSummary.setText("");
									textFieldContents.setText("");
									textTitle.setText("");
									textAuthor.setText("");
									chckbxContents.setSelected(false);
									chckbxTitle.setSelected(false);
									chckbxAuthor.setSelected(false);
									chckbxLanguage.setSelected(false);
									chckbxSummary.setSelected(false);
									chckbxKeywords.setSelected(false);
									chckbxDomain.setSelected(false);
									Date d = new Date();
									boolean isdate = false;
									for(Book b3:tempBookList)
									{
										SearchToBook stb = new SearchToBook();
										ArrayList<SearchToBook> stbList = new ArrayList<SearchToBook>();
										stbList = BookController.SearchSearchToBook("SearchDate", stb, "bookID=\"" + b3.getBookID() + "\" && SearchDate=\"" + new SimpleDateFormat("yyyy/MM/dd").format(d) +"\"", screen.getClient());
										if(stbList != null)
											isdate = BookController.UpdateSearchToBook(stb, "numberOfSearches = numberOfSearches + 1", "bookID=\"" + b3.getBookID() + "\" && SearchDate=\"" + new SimpleDateFormat("yyyy/MM/dd").format(d) +"\""  , screen.getClient());
										else
										{
											stb= new SearchToBook(b3.getBookID() , new SimpleDateFormat("yyyy/MM/dd").format(d) , 1);
											BookController.InsertSearchToBook(stb, screen.getClient());
										}
											
									}
									sb.setList(tempBookList);
									screen.setContentPane(sb);
								}
								else//no result books
									JOptionPane.showMessageDialog(screen,"There is no results", "Warning",JOptionPane.WARNING_MESSAGE);
								}
							else//no result books
								JOptionPane.showMessageDialog(screen,"There is no results", "Warning",JOptionPane.WARNING_MESSAGE);
						else//one of the fields is empty
							JOptionPane.showMessageDialog(screen,"Please fill the empty fields", "Warning",JOptionPane.WARNING_MESSAGE);
					else//There are no books in the system
						JOptionPane.showMessageDialog(screen,"There are no books in the system", "Warning",JOptionPane.WARNING_MESSAGE);
				}
				else//nothing selected
					JOptionPane.showMessageDialog(screen,"Nothing is selected", "Warning",JOptionPane.WARNING_MESSAGE);
				

			}
		});
		btnSearch.setBounds(388, 537, 97, 30);
		add(btnSearch);
		
		JLabel lblSearchBookGif = new JLabel("");
		lblSearchBookGif.setIcon(new ImageIcon("Extras/Images/Search50.png"));
		lblSearchBookGif.setBounds(480, 27, 69, 62);
		add(lblSearchBookGif);
	}
}
