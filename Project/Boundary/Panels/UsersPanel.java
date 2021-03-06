package Panels;

import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.JCheckBox;

import Book.Book;
import Book.Domain;
import Controller.UserController;
import Controller.BookController;
import MenuGUI.LoginGUI;
import Role.User;
import Role.UserStatus;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.spi.CalendarNameProvider;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

/**
 * 
 * This panel presents the User in the allUsers page
 * 
 * @author Almog Yamin
 */
public class UsersPanel extends JPanel {
	private LoginGUI screen;
	private JLabel lblAnswerfromserver;
	// private java.util.Date date;

	/**
	 * This is the constructor of the class UsersPanel -put the
	 * components on the screen and set their functionality.
	 * this panel show the User's details
	 * @param screen
	 * This is the main window-login
	 * @param u
	 * is a User which the panel shows his details
	 */
	public UsersPanel(LoginGUI screen, User u) {
		setBackground(Color.WHITE);
		setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(46, 200, 200)));
		setPreferredSize(new Dimension(577, 138));
		setLayout(null);

		JLabel lblUserid = new JLabel("UserID:");
		lblUserid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUserid.setBounds(22, 10, 147, 20);
		add(lblUserid);

		JLabel lblUderiddb = new JLabel(u.getUserID());
		lblUderiddb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUderiddb.setBounds(170, 10, 141, 20);
		add(lblUderiddb);

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(22, 40, 147, 20);
		add(lblFirstName);

		JLabel lblFirstnamedb = new JLabel(u.getFirstName());
		lblFirstnamedb.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFirstnamedb.setBounds(170, 40, 141, 20);
		add(lblFirstnamedb);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(22, 70, 147, 20);
		add(lblLastName);

		JLabel lblLastnamedb = new JLabel(u.getLastName());
		lblLastnamedb.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLastnamedb.setBounds(170, 70, 141, 20);
		add(lblLastnamedb);

		JLabel lblIdentityNumber = new JLabel("Identity Number:");
		lblIdentityNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdentityNumber.setBounds(22, 100, 161, 20);
		add(lblIdentityNumber);

		JLabel lblIdentityNumberdb = new JLabel(u.getIdentityNumber());
		lblIdentityNumberdb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdentityNumberdb.setForeground(Color.BLACK);
		lblIdentityNumberdb.setBounds(170, 100, 141, 20);
		add(lblIdentityNumberdb);

		lblAnswerfromserver = new JLabel();
		lblAnswerfromserver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAnswerfromserver.setBounds(342, 66, 212, 34);
		add(lblAnswerfromserver);

	}
}
// how to print the date right now:
// String dateRightNow = new
// SimpleDateFormat("yyyy/MM/dd").format(cal.getTime());
