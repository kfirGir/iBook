package ManagmentGUI;


import javax.swing.JPanel;

import MenuGUI.LoginGUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;



/**
 * The class represent a mini  GUI menu  for inventory management
 * @author Hen Saada
 * 
 */
public class InventoryManagmentGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	public JButton btnBack;
	private LoginGUI screen;
	private JPanel pann;
	/**
	 * The class of build the panel GUI to mini menu for inventory management
	 * @param screen 
	 * LoginGUI extends JFrame
	 * @author Hen Saada
	 * 
	 */
	public InventoryManagmentGUI(LoginGUI screen) {
		super();
		this.screen=screen;
		pann=this;

		initialize();
	}

	
	
	/**
	 * This method initialize The window of inventory manager,puts the components on the screen and set their functionality that is add ,delete or update a book
	 * @author  hen saada
	 * 
	 */
	private void initialize() {
		
		this.setSize(850, 625);
		this.setLayout(null);	
		
		JLabel lblHeader = new JLabel("Inventory Managment");
		lblHeader.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblHeader.setBounds(325, 40, 255, 40);
		add(lblHeader);

		JLabel lblinventoryGif = new JLabel("");
		lblinventoryGif.setIcon(new ImageIcon("Extras/Images/inventory.gif"));
		lblinventoryGif.setBounds(555, 155, 375, 505);
		add(lblinventoryGif);
		
		JButton btnDelete = new JButton("Delete book");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InventoryManagmentDeleteGUI del=new InventoryManagmentDeleteGUI(screen); 
				del.btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						screen.setContentPane(pann);
					}
				});
				screen.setContentPane(del);//send to search book window
			}
		
		});
	
		
		btnDelete.setBounds(191, 110, 145, 30);
		add(btnDelete);
		JButton btnAddupdate = new JButton("Add book");
		btnAddupdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddupdate.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				AddOrUpdateBookGUI aOu=new AddOrUpdateBookGUI(screen,1); // 1 means add 
				aOu.btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						screen.setContentPane(pann);
					}
				});
				screen.setContentPane(aOu);//send to search book window
			}
		});
		btnAddupdate.setBounds(366, 110, 122, 30);
		add(btnAddupdate);
		ImageIcon backIcon =new ImageIcon("Extras/Images/backIcon.png");
		 btnBack = new JButton(backIcon);
		btnBack.setBounds(35, 25, 89, 23);
		add(btnBack);
		
		JButton btnUpdateBook = new JButton("Update book");
		btnUpdateBook.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdateBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InventoryManagmentSearchForUpdateGUI search=new InventoryManagmentSearchForUpdateGUI(screen,pann); // 0 means update
				search.btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						screen.setContentPane(pann);
					}
				});
				screen.setContentPane(search);//send to search book window
			}
		});
		btnUpdateBook.setBounds(512, 110, 145, 30);
		add(btnUpdateBook);
	
	}
}