

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
import Controller.bookController;
import MenuGUI.LoginGUI;
import Panels.*;
import Role.User;
import Role.UserStatus;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetAccountSubscriptionGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	public JButton btnBack;
	private LoginGUI screen;
	private JPanel pann;
	public static JPanel panel;
	private JScrollPane scrollPaneMain;
	private ArrayList<User> searcRes;
	private User u;

	public SetAccountSubscriptionGUI(LoginGUI screen) {
		super();
		this.screen = screen;
		pann = this;

		initialize();
	}

	private void initialize() {

		this.setSize(850, 625);
		this.setLayout(null);

		JLabel lblHeaderSetAccountSubscription = new JLabel("Set Account Subscription");
		lblHeaderSetAccountSubscription.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHeaderSetAccountSubscription.setBounds(355, 49, 207, 22);
		add(lblHeaderSetAccountSubscription);

		ImageIcon backIcon = new ImageIcon("src/images/backIcon.png");
		btnBack = new JButton(backIcon);
		btnBack.setBounds(39, 52, 89, 23);
		add(btnBack);

		// Group the radio buttons.
		ButtonGroup group = new ButtonGroup();
		
		JLabel lblListOfUsers = new JLabel("LIST OF USERS WITH REQUESTED SUBSCRIPTION");
		lblListOfUsers.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListOfUsers.setBounds(287, 111, 369, 33);
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
		//panel.add(new UserSubscriptionPanel(screen , u));
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
		//JOptionPane.showMessageDialog(screen,"not found any user to be updated by his subscription method\n", "Warning",
		//		JOptionPane.WARNING_MESSAGE);
	//	panel.add(new UserSubscriptionPanel(screen , u));
	//	panel.add(new UserSubscriptionPanel(screen));
		//panel.add(new UserSubscriptionPanel(screen));
	//	panel.add(new UserSubscriptionPanel(screen));
	//	panel.add(new UserSubscriptionPanel(screen));
	//	panel.add(new UserSubscriptionPanel(screen));
	//	panel.add(new UserSubscriptionPanel(screen));
		
		/*
		 * ����� ������ ����� ���� JRadioButton catButton = new
		 * JRadioButton(catString); catButton.setMnemonic(KeyEvent.VK_C);
		 * catButton.setActionCommand(catString);
		 * 
		 * JRadioButton dogButton = new JRadioButton(dogString);
		 * dogButton.setMnemonic(KeyEvent.VK_D);
		 * dogButton.setActionCommand(dogString);
		 * 
		 * JRadioButton rabbitButton = new JRadioButton(rabbitString);
		 * rabbitButton.setMnemonic(KeyEvent.VK_R);
		 * rabbitButton.setActionCommand(rabbitString);
		 * 
		 * JRadioButton pigButton = new JRadioButton(pigString);
		 * pigButton.setMnemonic(KeyEvent.VK_P);
		 * pigButton.setActionCommand(pigString);
		 * 
		 * //Group the radio buttons. ButtonGroup group = new ButtonGroup();
		 * group.add(birdButton); group.add(catButton); group.add(dogButton);
		 * group.add(rabbitButton); group.add(pigButton);
		 * 
		 * //Register a listener for the radio buttons.
		 * birdButton.addActionListener(this);
		 * catButton.addActionListener(this); dogButton.addActionListener(this);
		 * rabbitButton.addActionListener(this);
		 * pigButton.addActionListener(this);
		 */

	}
}





