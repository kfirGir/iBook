package ManagmentGUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.MatteBorder;

import Book.Book;
import Controller.UserController;
import Extras.*;
import Controller.BookController;
import MenuGUI.LoginGUI;
import Panels.UserSubscriptionPanel;
import Role.User;
import Role.UserStatus;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The class take care of the request subscription that comes from the user.
 * After the worker get answer from the Credit Company he accept or decline the
 * request of the user for new subscription by clicking on the buttons.
 * 
 * @author Almog Yamin
 */
public class SetAccountSubscriptionGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	public JButton btnBack;
	private LoginGUI screen;
	private JPanel pann;
	public static JPanel panel;
	private JScrollPane scrollPaneMain;
	private ArrayList<User> searcRes;
	private User u;
	/**
	 * Constructor of the SetAccountSubscriptionGUI class
	 * @param screen This is the main window-login extends JFrame
	 * @author  Almog Yamin
	 */	
	public SetAccountSubscriptionGUI(LoginGUI screen) {
		super();
		this.screen = screen;
		pann = this;

		initialize();
	}
	/**
	 * This method initialize The window of set subscription gui - put the components on the screen and set their functionality
	 * The Worker get a list of all the users that wait for confirmation review, and click on a button to accept or decline each one of the users.
	 * @author Almog Yamin
	 */
	private void initialize() {

		this.setSize(850, 625);
		this.setLayout(null);

		JLabel lblHeaderSetAccountSubscription = new JLabel("Set Account Subscription");
		lblHeaderSetAccountSubscription.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblHeaderSetAccountSubscription.setBounds(355, 49, 260, 22);
		add(lblHeaderSetAccountSubscription);

		ImageIcon backIcon = new ImageIcon("Extras/Images/backIcon.png");
		btnBack = new JButton(backIcon);
		btnBack.setBounds(25, 35, 89, 30);
		add(btnBack);

		// Group the radio buttons.
		ButtonGroup group = new ButtonGroup();
		
		JLabel lblListOfUsers = new JLabel("LIST OF USERS WITH REQUESTED SUBSCRIPTION");
		lblListOfUsers.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblListOfUsers.setBounds(238, 110, 452, 33);
		add(lblListOfUsers);

		scrollPaneMain = new JScrollPane();
		scrollPaneMain.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneMain.setAutoscrolls(true);
		scrollPaneMain.setBounds(125, 160, 682, 392);
		add(scrollPaneMain);
		
		panel = new JPanel();
		panel.setIgnoreRepaint(true);
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel.setAutoscrolls(true);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollPaneMain.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		u = new User();
		searcRes = UserController.SearchUser("userID,firstName,lastName,subscriptionRequest,privilege",u,"subscriptionRequest <> \"" + 0 + "\"", screen.getClient());//call search book method from book controller
		if (searcRes != null) {
			for(User ut:searcRes)
				panel.add(new UserSubscriptionPanel(this.screen,ut));
		} else 
		{
			panel.setVisible(false);
			scrollPaneMain.setVisible(false);
			lblListOfUsers.setText("You don't have any new requests!");
			lblListOfUsers.setForeground(Color.GREEN);
		}


	}
}





