import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.sql.*;
import java.util.logging.Logger;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class dashbord {

	JFrame frame;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t6;
	private JTextField t7;
	private JTextField t8;
	private JTextField t9;
	private JTextField t10;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_7;
	private JComboBox t5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashbord window = new dashbord();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public dashbord() {
		initialize();
		Connect();
	}

	
	Connection con;
	PreparedStatement pst;
	protected Object dashbord;
	private JLabel lblNewLabel_6;
	
	public void Connect () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/dashboard","root","");
		
		}
		catch (ClassNotFoundException ex){

			}
		catch (SQLException ex){

		}
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Cricket Score Dashboard");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rasika\\eclipse-workspace\\Cricket Dashbord\\img\\ball.png"));
		frame.setBackground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setBounds(100, 100, 830, 642);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect();
				
				String team1,team2,date,venue,matchtype,matchrefree,onfieldumpire1,onfieldumpire2,tvumpire,fourthumpire;
				
				team1 = t1.getText();
				team2 = t2.getText();
				date = t3.getText();
				venue = t4.getText();
				matchtype = (String)t5.getSelectedItem();
				matchrefree = t6.getText();
				onfieldumpire1 = t7.getText();
				onfieldumpire2 = t8.getText();
				tvumpire = t9.getText();
				fourthumpire = t10.getText();
				
				
				try {
					pst = con.prepareStatement("insert into dashboard(team1,team2,date,venue,matchtype,matchrefree,onfieldumpire1,onfieldumpire2,tvumpire,fourthumpire)values(?,?,?,?,?,?,?,?,?,?)");
					pst.setString(1, team1);
					pst.setString(2, team2);
					pst.setString(3, date);
					pst.setString(4, venue);
					pst.setString(5,(String)t5.getSelectedItem());
					pst.setString(6,matchrefree);
					pst.setString(7, onfieldumpire1);
					pst.setString(8, onfieldumpire2);
					pst.setString(9, tvumpire);
					pst.setString(10, fourthumpire);
					pst.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				JOptionPane.showMessageDialog(null,"add success!");
				
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t6.setText("");
				t7.setText("");
				t8.setText("");
				t9.setText("");
				t10.setText("");
				
				
			}
		});
		btnNewButton.setBounds(545, 544, 118, 28);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Next");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dash2 dash = new dash2();
				dash.Secframe.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(673, 544, 118, 28);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Score Board Manager");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(10, 11, 234, 28);
		frame.getContentPane().add(lblNewLabel);
		
		t1 = new JTextField();
		t1.setBackground(new Color(255, 255, 255));
		t1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t1.setBounds(128, 93, 205, 28);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t2.setColumns(10);
		t2.setBackground(new Color(255, 255, 255));
		t2.setBounds(487, 93, 205, 28);
		frame.getContentPane().add(t2);
		
		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t3.setColumns(10);
		t3.setBackground(new Color(255, 255, 255));
		t3.setBounds(487, 175, 205, 28);
		frame.getContentPane().add(t3);
		
		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t4.setColumns(10);
		t4.setBackground(new Color(255, 255, 255));
		t4.setBounds(487, 218, 205, 28);
		frame.getContentPane().add(t4);
		
		t6 = new JTextField();
		t6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t6.setColumns(10);
		t6.setBackground(new Color(255, 255, 255));
		t6.setBounds(487, 326, 205, 28);
		frame.getContentPane().add(t6);
		
		t7 = new JTextField();
		t7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t7.setColumns(10);
		t7.setBackground(new Color(255, 255, 255));
		t7.setBounds(128, 395, 254, 28);
		frame.getContentPane().add(t7);
		
		t8 = new JTextField();
		t8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t8.setColumns(10);
		t8.setBackground(new Color(255, 255, 255));
		t8.setBounds(438, 395, 254, 28);
		frame.getContentPane().add(t8);
		
		t9 = new JTextField();
		t9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t9.setColumns(10);
		t9.setBackground(new Color(255, 255, 255));
		t9.setBounds(128, 463, 254, 28);
		frame.getContentPane().add(t9);
		
		t10 = new JTextField();
		t10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t10.setColumns(10);
		t10.setBackground(new Color(255, 255, 255));
		t10.setBounds(438, 463, 254, 28);
		frame.getContentPane().add(t10);
		
		lblNewLabel_1 = new JLabel("Team");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(128, 68, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_4 = new JLabel("VS");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(402, 100, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_8 = new JLabel("On field Umpires");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setBounds(128, 374, 164, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("TV Umpire");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_9.setBounds(128, 438, 79, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("4th Umpire");
		lblNewLabel_10.setBackground(new Color(0, 0, 0));
		lblNewLabel_10.setForeground(new Color(0, 0, 0));
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_10.setBounds(567, 438, 118, 14);
		frame.getContentPane().add(lblNewLabel_10);
		
		lblNewLabel_2 = new JLabel("Team");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(487, 70, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Date");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(128, 182, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_5 = new JLabel("Venue");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(128, 225, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6_1 = new JLabel("Match Refree");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6_1.setBounds(128, 333, 153, 14);
		frame.getContentPane().add(lblNewLabel_6_1);
		
		lblNewLabel_7 = new JLabel("Match Type");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(128, 275, 97, 22);
		frame.getContentPane().add(lblNewLabel_7);
		
		t5 = new JComboBox();
		t5.setBackground(new Color(192, 192, 192));
		t5.addItem("One day");
		t5.addItem("Test");
		t5.addItem("T20");
		t5.addItem("LPL");
		t5.setBounds(487, 277, 205, 28);
		frame.getContentPane().add(t5);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\rasika\\eclipse-workspace\\Cricket Dashbord\\img\\Untitled-1.png"));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(116, 114, 584, 458);
		frame.getContentPane().add(lblNewLabel_6);
	}
}
