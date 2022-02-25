import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.text.JTextComponent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class dash5 {

	JFrame frame5;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dash5 window = new dash5();
					window.frame5.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public dash5() {
		initialize();
		Connect();
	}
	
	Connection con;
	PreparedStatement pst;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JTextField textField_4;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField teamname1;
	private JTextField teamb;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField mid;
	
	private int i = 0;
	private int j = 0;
	private int k = 0;
	private int l = 0;
	private int m = 0;
	private int n = 0;
	private int o = 0;
	private int p = 0;
	private int q = 0;
	private int r = 0;
	private int s = 0;
	private int t = 0;
	private int u = 0;
	private int balls=1;
	private int overs=0;
	
	public void Connect () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/dashboard","root","");
			Statement st = con.createStatement();
			 ResultSet r=st.executeQuery("SELECT * FROM dashboard WHERE ID = (SELECT MAX(id) FROM dashboard)");
			 while (r.next()) {
				teamname1.setText(r.getString("team2"));
				teamb.setText(r.getString("team1"));
			 }
			
		}
		catch (ClassNotFoundException ex){

			}
		catch (SQLException ex){

		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame5 = new JFrame();
		frame5.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rasika\\eclipse-workspace\\Cricket Dashbord\\img\\ball.png"));
		frame5.setTitle("Cricket Score Dashboard");
		frame5.getContentPane().setBackground(new Color(240, 248, 255));
		frame5.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setText("0");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(39, 181, 89, 23);
		frame5.getContentPane().add(textField);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setHorizontalTextPosition(SwingConstants.CENTER);
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxNewCheckBox.setBounds(251, 87, 29, 28);
		frame5.getContentPane().add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("OUT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connect();
				
				String teamname,player_name,mid2,four,six,score,balls;
								
				teamname = teamname1.getText();
				player_name = textField_4.getText();
				mid2= mid.getText();
				four= textField_2.getText();
				six= textField_3.getText();
				score= textField.getText();
				balls= textField_13.getText();
				
				
				
				try {
					pst = con.prepareStatement("insert into score(mid,player_name,score,team_name,balls,fours,sixes)values(?,?,?,?,?,?,?)");
					pst.setString(1, mid2);
					pst.setString(2, player_name);
					pst.setString(3, score);
					pst.setString(4, teamname);
					pst.setString(5, balls);
					pst.setString(6, four);
					pst.setString(7, six);
					pst.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				textField_4.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField.setText("");
				textField_13.setText("");
				
				
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(390, 87, 89, 28);
		frame5.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1_2 = new JLabel("Batsman  :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(39, 88, 89, 23);
		frame5.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Strike*");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(291, 92, 89, 23);
		frame5.getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Runs");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_2.setBounds(39, 154, 89, 23);
		frame5.getContentPane().add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Balls");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_3.setBounds(152, 154, 89, 23);
		frame5.getContentPane().add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("4s");
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_4.setBounds(269, 154, 89, 23);
		frame5.getContentPane().add(lblNewLabel_1_2_4);
		
		JLabel lblNewLabel_1_2_5 = new JLabel("6s");
		lblNewLabel_1_2_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_5.setBounds(388, 154, 89, 23);
		frame5.getContentPane().add(lblNewLabel_1_2_5);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(138, 87, 97, 23);
		frame5.getContentPane().add(textField_4);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_1.setText("0");
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(269, 404, 97, 23);
		frame5.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("0");
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(269, 181, 97, 23);
		frame5.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("0");
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(388, 181, 97, 23);
		frame5.getContentPane().add(textField_3);
		
		JLabel lblNewLabel_1_2_6 = new JLabel("Batsman  :");
		lblNewLabel_1_2_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_6.setBounds(548, 88, 89, 23);
		frame5.getContentPane().add(lblNewLabel_1_2_6);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Runs");
		lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_2_1.setBounds(548, 154, 89, 23);
		frame5.getContentPane().add(lblNewLabel_1_2_2_1);
		
		textField_5 = new JTextField();
		textField_5.setText("0");
		textField_5.setToolTipText("");
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(548, 181, 89, 23);
		frame5.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setText("0");
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_6.setColumns(10);
		textField_6.setBackground(Color.WHITE);
		textField_6.setBounds(661, 181, 97, 23);
		frame5.getContentPane().add(textField_6);
		
		JLabel lblNewLabel_1_2_3_1 = new JLabel("Balls");
		lblNewLabel_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_3_1.setBounds(661, 154, 89, 23);
		frame5.getContentPane().add(lblNewLabel_1_2_3_1);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_7.setColumns(10);
		textField_7.setBackground(Color.WHITE);
		textField_7.setBounds(647, 87, 97, 23);
		frame5.getContentPane().add(textField_7);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		chckbxNewCheckBox_1.setHorizontalTextPosition(SwingConstants.CENTER);
		chckbxNewCheckBox_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxNewCheckBox_1.setBounds(760, 87, 29, 28);
		frame5.getContentPane().add(chckbxNewCheckBox_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Strike*");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1_1.setBounds(800, 92, 89, 23);
		frame5.getContentPane().add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_4_1 = new JLabel("4s");
		lblNewLabel_1_2_4_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_4_1.setBounds(778, 154, 89, 23);
		frame5.getContentPane().add(lblNewLabel_1_2_4_1);
		
		textField_8 = new JTextField();
		textField_8.setText("0");
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_8.setColumns(10);
		textField_8.setBackground(Color.WHITE);
		textField_8.setBounds(778, 181, 97, 23);
		frame5.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setText("0");
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_9.setColumns(10);
		textField_9.setBackground(Color.WHITE);
		textField_9.setBounds(899, 181, 97, 23);
		frame5.getContentPane().add(textField_9);
		
		JLabel lblNewLabel_1_2_5_1 = new JLabel("6s");
		lblNewLabel_1_2_5_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_5_1.setBounds(899, 154, 89, 23);
		frame5.getContentPane().add(lblNewLabel_1_2_5_1);
		
		JButton btnNewButton_2 = new JButton("OUT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connect();
				
				String teamname,player_name,mid2,four,six,score,balls;
								
				teamname = teamname1.getText();
				player_name = textField_7.getText();
				mid2= mid.getText();
				four= textField_8.getText();
				six= textField_9.getText();
				score= textField_5.getText();
				balls= textField_6.getText();
				
				
				
				try {
					pst = con.prepareStatement("insert into score(mid,player_name,score,team_name,balls,fours,sixes)values(?,?,?,?,?,?,?)");
					pst.setString(1, mid2);
					pst.setString(2, player_name);
					pst.setString(3, score);
					pst.setString(4, teamname);
					pst.setString(5, balls);
					pst.setString(6, four);
					pst.setString(7, six);
					pst.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setBounds(899, 87, 89, 28);
		frame5.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1_2_7 = new JLabel("Bowler  :");
		lblNewLabel_1_2_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_7.setBounds(291, 342, 89, 23);
		frame5.getContentPane().add(lblNewLabel_1_2_7);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_10.setColumns(10);
		textField_10.setBackground(Color.WHITE);
		textField_10.setBounds(390, 342, 97, 23);
		frame5.getContentPane().add(textField_10);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("");
		chckbxNewCheckBox_2.setHorizontalTextPosition(SwingConstants.CENTER);
		chckbxNewCheckBox_2.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxNewCheckBox_2.setBounds(503, 339, 29, 28);
		frame5.getContentPane().add(chckbxNewCheckBox_2);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("END");
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1_2.setBounds(543, 342, 89, 23);
		frame5.getContentPane().add(lblNewLabel_1_2_1_2);
		
		textField_11 = new JTextField();
		textField_11.setText("0");
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_11.setColumns(10);
		textField_11.setBackground(Color.WHITE);
		textField_11.setBounds(495, 404, 97, 23);
		frame5.getContentPane().add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setText("0");
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_12.setColumns(10);
		textField_12.setBackground(Color.WHITE);
		textField_12.setBounds(383, 404, 97, 23);
		frame5.getContentPane().add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setText("0");
		textField_13.setToolTipText("");
		textField_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_13.setColumns(10);
		textField_13.setBackground(Color.WHITE);
		textField_13.setBounds(152, 181, 97, 23);
		frame5.getContentPane().add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setText("0");
		textField_14.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_14.setColumns(10);
		textField_14.setBackground(Color.WHITE);
		textField_14.setBounds(152, 404, 89, 23);
		frame5.getContentPane().add(textField_14);
		
		JLabel lblNewLabel_1_2_2_2 = new JLabel("Runs");
		lblNewLabel_1_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_2_2.setBounds(152, 381, 89, 23);
		frame5.getContentPane().add(lblNewLabel_1_2_2_2);
		
		JLabel lblNewLabel_1_2_3_2 = new JLabel("Overs");
		lblNewLabel_1_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_3_2.setBounds(269, 381, 89, 23);
		frame5.getContentPane().add(lblNewLabel_1_2_3_2);
		
		JLabel lblNewLabel_1_2_4_2 = new JLabel("4s");
		lblNewLabel_1_2_4_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_4_2.setBounds(383, 381, 89, 23);
		frame5.getContentPane().add(lblNewLabel_1_2_4_2);
		
		JLabel lblNewLabel_1_2_5_2 = new JLabel("6s");
		lblNewLabel_1_2_5_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_5_2.setBounds(495, 381, 89, 23);
		frame5.getContentPane().add(lblNewLabel_1_2_5_2);
		
		textField_15 = new JTextField();
		textField_15.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_15.setColumns(10);
		textField_15.setBackground(Color.WHITE);
		textField_15.setBounds(390, 283, 248, 23);
		frame5.getContentPane().add(textField_15);
		
		JLabel lblNewLabel_1_2_7_1 = new JLabel("Batsman  :");
		lblNewLabel_1_2_7_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_7_1.setBounds(291, 284, 89, 23);
		frame5.getContentPane().add(lblNewLabel_1_2_7_1);
		
		textField_16 = new JTextField();
		textField_16.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_16.setColumns(10);
		textField_16.setBackground(Color.WHITE);
		textField_16.setBounds(400, 502, 313, 23);
		frame5.getContentPane().add(textField_16);
		
		JLabel lblNewLabel_1_2_7_1_1 = new JLabel("Additional Info  :");
		lblNewLabel_1_2_7_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_7_1_1.setBounds(269, 503, 129, 23);
		frame5.getContentPane().add(lblNewLabel_1_2_7_1_1);
		
		JLabel lblNewLabel_1_2_8 = new JLabel("Scoreboard Manager");
		lblNewLabel_1_2_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_8.setBounds(39, 11, 152, 23);
		frame5.getContentPane().add(lblNewLabel_1_2_8);
		
		teamname1 = new JTextField();
		teamname1.setToolTipText("");
		teamname1.setEditable(false);
		teamname1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		teamname1.setColumns(10);
		teamname1.setBackground(Color.WHITE);
		teamname1.setBounds(138, 52, 97, 23);
		frame5.getContentPane().add(teamname1);
		
		JLabel lblNewLabel_1_2_9 = new JLabel("Team :");
		lblNewLabel_1_2_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_9.setBounds(39, 52, 89, 23);
		frame5.getContentPane().add(lblNewLabel_1_2_9);
		
		teamb = new JTextField();
		teamb.setToolTipText("");
		teamb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		teamb.setEditable(false);
		teamb.setColumns(10);
		teamb.setBackground(Color.WHITE);
		teamb.setBounds(138, 342, 97, 23);
		frame5.getContentPane().add(teamb);
		
		JLabel lblNewLabel_1_2_9_1 = new JLabel("Team :");
		lblNewLabel_1_2_9_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_9_1.setBounds(39, 342, 89, 23);
		frame5.getContentPane().add(lblNewLabel_1_2_9_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Change Batting");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dash3 dashh = new dash3();
				dashh.frame3.setVisible(true);
				frame5.dispose();
				
			}
		});
		btnNewButton_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1_1_1.setBounds(269, 536, 158, 28);
		frame5.getContentPane().add(btnNewButton_1_1_1);
		
		JButton btnMinus = new JButton("-");
		btnMinus.setForeground(Color.WHITE);
		btnMinus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMinus.setBackground(new Color(30, 144, 255));
		btnMinus.setBounds(39, 249, 89, 23);
		frame5.getContentPane().add(btnMinus);
		frame5.setBounds(100, 100, 1038, 651);
		frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton_1_2 = new JButton("+");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				textField.setText(""+ ++i);
			}
		});
		
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText(""+ --i);
				
			}
		});
		
		
		
		btnNewButton_1_2.setForeground(Color.WHITE);
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_2.setBackground(new Color(30, 144, 255));
		btnNewButton_1_2.setBounds(39, 215, 89, 23);
		frame5.getContentPane().add(btnNewButton_1_2);
		
		JLabel lblNewLabel_1_2_5_2_2 = new JLabel("Wickets");
		lblNewLabel_1_2_5_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_5_2_2.setBounds(725, 381, 89, 23);
		frame5.getContentPane().add(lblNewLabel_1_2_5_2_2);
		
		textField_17 = new JTextField();
		textField_17.setText("0");
		textField_17.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_17.setColumns(10);
		textField_17.setBackground(Color.WHITE);
		textField_17.setBounds(725, 404, 97, 23);
		frame5.getContentPane().add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setText("0");
		textField_18.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_18.setColumns(10);
		textField_18.setBackground(Color.WHITE);
		textField_18.setBounds(616, 404, 97, 23);
		frame5.getContentPane().add(textField_18);
		
		JLabel lblNewLabel_1_2_5_2_1 = new JLabel("Extras");
		lblNewLabel_1_2_5_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_5_2_1.setBounds(616, 381, 89, 23);
		frame5.getContentPane().add(lblNewLabel_1_2_5_2_1);
		
		JButton btnNewButton_1_2_2 = new JButton("+");
		btnNewButton_1_2_2.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
					if(balls>5) {
						overs++;
						balls=0;
					}
					textField_1.setText(""+overs + "." + balls);
					balls++;
				}
		});
		btnNewButton_1_2_2.setForeground(Color.WHITE);
		btnNewButton_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_2_2.setBackground(new Color(30, 144, 255));
		btnNewButton_1_2_2.setBounds(269, 438, 97, 23);
		frame5.getContentPane().add(btnNewButton_1_2_2);
		
		JButton btnNewButton_1_2_3 = new JButton("+");
		btnNewButton_1_2_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				textField_2.setText(""+ ++k);
				
			}
		});
		btnNewButton_1_2_3.setForeground(Color.WHITE);
		btnNewButton_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_2_3.setBackground(new Color(30, 144, 255));
		btnNewButton_1_2_3.setBounds(269, 215, 97, 23);
		frame5.getContentPane().add(btnNewButton_1_2_3);
		
		JButton btnNewButton_1_2_4 = new JButton("+");
		btnNewButton_1_2_4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				textField_3.setText(""+ ++l);
				
			}
		});
		btnNewButton_1_2_4.setForeground(Color.WHITE);
		btnNewButton_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_2_4.setBackground(new Color(30, 144, 255));
		btnNewButton_1_2_4.setBounds(388, 214, 97, 24);
		frame5.getContentPane().add(btnNewButton_1_2_4);
		
		JButton btnMinus_1 = new JButton("-");
		btnMinus_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_13.setText(""+ --j);
			}
		});
		btnMinus_1.setForeground(Color.WHITE);
		btnMinus_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMinus_1.setBackground(new Color(30, 144, 255));
		btnMinus_1.setBounds(152, 251, 97, 23);
		frame5.getContentPane().add(btnMinus_1);
		
		JButton btnNewButton_1_2_3_1 = new JButton("+");
		btnNewButton_1_2_3_1.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				textField_13.setText(""+ ++j);
			}
		});
		btnNewButton_1_2_3_1.setForeground(Color.WHITE);
		btnNewButton_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_2_3_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1_2_3_1.setBounds(152, 215, 97, 23);
		frame5.getContentPane().add(btnNewButton_1_2_3_1);
		
		JButton btnNewButton_1_2_1 = new JButton("+");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_5.setText(""+ ++m);
			}
		});
		btnNewButton_1_2_1.setForeground(Color.WHITE);
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_2_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1_2_1.setBounds(548, 216, 89, 23);
		frame5.getContentPane().add(btnNewButton_1_2_1);
		
		JButton btnNewButton_1_2_3_1_1 = new JButton("+");
		btnNewButton_1_2_3_1_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				textField_6.setText(""+ ++n);
			}
		});
		btnNewButton_1_2_3_1_1.setForeground(Color.WHITE);
		btnNewButton_1_2_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_2_3_1_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1_2_3_1_1.setBounds(661, 216, 97, 23);
		frame5.getContentPane().add(btnNewButton_1_2_3_1_1);
		
		JButton btnNewButton_1_2_3_2 = new JButton("+");
		btnNewButton_1_2_3_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				textField_8.setText(""+ ++o);
				
			}
		});
		btnNewButton_1_2_3_2.setForeground(Color.WHITE);
		btnNewButton_1_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_2_3_2.setBackground(new Color(30, 144, 255));
		btnNewButton_1_2_3_2.setBounds(778, 216, 97, 23);
		frame5.getContentPane().add(btnNewButton_1_2_3_2);
		
		JButton btnNewButton_1_2_4_1 = new JButton("+");
		btnNewButton_1_2_4_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				textField_9.setText(""+ ++p);
				
			}
		});
		btnNewButton_1_2_4_1.setForeground(Color.WHITE);
		btnNewButton_1_2_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_2_4_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1_2_4_1.setBounds(899, 215, 95, 24);
		frame5.getContentPane().add(btnNewButton_1_2_4_1);
		
		JButton btnNewButton_1_2_3_1_2 = new JButton("+");
		btnNewButton_1_2_3_1_2.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				textField_14.setText(""+ ++q);
				
			}
		});
		btnNewButton_1_2_3_1_2.setForeground(Color.WHITE);
		btnNewButton_1_2_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_2_3_1_2.setBackground(new Color(30, 144, 255));
		btnNewButton_1_2_3_1_2.setBounds(152, 438, 89, 23);
		frame5.getContentPane().add(btnNewButton_1_2_3_1_2);
		
		JButton btnNewButton_1_2_3_1_2_1 = new JButton("+");
		btnNewButton_1_2_3_1_2_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				textField_11.setText(""+ ++s);
				
			}
		});
		btnNewButton_1_2_3_1_2_1.setForeground(Color.WHITE);
		btnNewButton_1_2_3_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_2_3_1_2_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1_2_3_1_2_1.setBounds(495, 438, 97, 23);
		frame5.getContentPane().add(btnNewButton_1_2_3_1_2_1);
		
		JButton btnNewButton_1_2_3_1_2_2 = new JButton("+");
		btnNewButton_1_2_3_1_2_2.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				textField_18.setText(""+ ++t);
			
			}
		});
		btnNewButton_1_2_3_1_2_2.setForeground(Color.WHITE);
		btnNewButton_1_2_3_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_2_3_1_2_2.setBackground(new Color(30, 144, 255));
		btnNewButton_1_2_3_1_2_2.setBounds(616, 438, 97, 23);
		frame5.getContentPane().add(btnNewButton_1_2_3_1_2_2);
		
		JButton btnNewButton_1_2_3_1_2_3 = new JButton("+");
		btnNewButton_1_2_3_1_2_3.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				textField_17.setText(""+ ++u);
				
			}
		});
		btnNewButton_1_2_3_1_2_3.setForeground(Color.WHITE);
		btnNewButton_1_2_3_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_2_3_1_2_3.setBackground(new Color(30, 144, 255));
		btnNewButton_1_2_3_1_2_3.setBounds(725, 438, 97, 23);
		frame5.getContentPane().add(btnNewButton_1_2_3_1_2_3);
		
		JButton btnNewButton_1_2_3_1_2_4 = new JButton("+");
		btnNewButton_1_2_3_1_2_4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				textField_12.setText(""+ ++r);
			
			}
		});
		btnNewButton_1_2_3_1_2_4.setForeground(Color.WHITE);
		btnNewButton_1_2_3_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_2_3_1_2_4.setBackground(new Color(30, 144, 255));
		btnNewButton_1_2_3_1_2_4.setBounds(383, 438, 97, 23);
		frame5.getContentPane().add(btnNewButton_1_2_3_1_2_4);
		
		JButton btnNewButton_3_1_1 = new JButton("Over End");
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connect();
				
				String teamname,player_name,mid2,four,six,score,balls,extras,wickets;
								
				teamname = teamb.getText();
				player_name = textField_10.getText();
				mid2= mid.getText();
				four= textField_12.getText();
				six= textField_11.getText();
				score= textField_14.getText();
				balls= textField_1.getText();
				extras= textField_18.getText();
				wickets= textField_17.getText();
				
				
				try {
					pst = con.prepareStatement("insert into bowling(mid,player_name,score,team_name,balls,fours,sixes,extras,wickets)values(?,?,?,?,?,?,?,?,?)");
					pst.setString(1, mid2);
					pst.setString(2, player_name);
					pst.setString(3, score);
					pst.setString(4, teamname);
					pst.setString(5, balls);
					pst.setString(6, four);
					pst.setString(7, six);
					pst.setString(8, extras);
					pst.setString(9,wickets);
					pst.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				textField.setText("");
				textField_11.setText("");
				textField_12.setText("");
				textField_14.setText("");
				textField_10.setText("");
				textField_18.setText("");
				textField_17.setText("");
			}
		});
		btnNewButton_3_1_1.setForeground(Color.WHITE);
		btnNewButton_3_1_1.setBackground(Color.RED);
		btnNewButton_3_1_1.setBounds(702, 341, 120, 28);
		frame5.getContentPane().add(btnNewButton_3_1_1);
		
		JLabel lblNewLabel_1_2_10 = new JLabel("Match ID :");
		lblNewLabel_1_2_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_10.setBounds(417, 12, 89, 23);
		frame5.getContentPane().add(lblNewLabel_1_2_10);
		
		mid = new JTextField();
		mid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mid.setColumns(10);
		mid.setBackground(Color.WHITE);
		mid.setBounds(516, 11, 97, 23);
		frame5.getContentPane().add(mid);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setText(""+0);
				textField.setText(""+0);
				textField_3.setText(""+0);
				textField_13.setText(""+0);
			}
		});
		btnReset.setForeground(Color.WHITE);
		btnReset.setBackground(Color.RED);
		btnReset.setBounds(390, 128, 89, 28);
		frame5.getContentPane().add(btnReset);
		
		JButton btnMinus_1_1 = new JButton("-");
		btnMinus_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setText(""+ --k);
				
			}
		});
		btnMinus_1_1.setForeground(Color.WHITE);
		btnMinus_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMinus_1_1.setBackground(new Color(30, 144, 255));
		btnMinus_1_1.setBounds(269, 251, 97, 23);
		frame5.getContentPane().add(btnMinus_1_1);
		
		JButton btnMinus_1_1_1 = new JButton("-");
		btnMinus_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setText(""+ --l);
			}
		});
		btnMinus_1_1_1.setForeground(Color.WHITE);
		btnMinus_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMinus_1_1_1.setBackground(new Color(30, 144, 255));
		btnMinus_1_1_1.setBounds(388, 251, 97, 23);
		frame5.getContentPane().add(btnMinus_1_1_1);
		
		JButton btnMinus_1_1_1_1 = new JButton("-");
		btnMinus_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_5.setText(""+ --m);
			}
		});
		btnMinus_1_1_1_1.setForeground(Color.WHITE);
		btnMinus_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMinus_1_1_1_1.setBackground(new Color(30, 144, 255));
		btnMinus_1_1_1_1.setBounds(548, 251, 89, 23);
		frame5.getContentPane().add(btnMinus_1_1_1_1);
		
		JButton btnMinus_1_1_1_1_1 = new JButton("-");
		btnMinus_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_6.setText(""+ --n);
			}
		});
		btnMinus_1_1_1_1_1.setForeground(Color.WHITE);
		btnMinus_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMinus_1_1_1_1_1.setBackground(new Color(30, 144, 255));
		btnMinus_1_1_1_1_1.setBounds(661, 251, 97, 23);
		frame5.getContentPane().add(btnMinus_1_1_1_1_1);
		
		JButton btnMinus_1_1_1_1_1_1 = new JButton("-");
		btnMinus_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_8.setText(""+ --o);
			}
		});
		btnMinus_1_1_1_1_1_1.setForeground(Color.WHITE);
		btnMinus_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMinus_1_1_1_1_1_1.setBackground(new Color(30, 144, 255));
		btnMinus_1_1_1_1_1_1.setBounds(778, 251, 97, 23);
		frame5.getContentPane().add(btnMinus_1_1_1_1_1_1);
		
		JButton btnMinus_1_1_1_1_1_1_1 = new JButton("-");
		btnMinus_1_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_9.setText(""+ --p);
			}
		});
		btnMinus_1_1_1_1_1_1_1.setForeground(Color.WHITE);
		btnMinus_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMinus_1_1_1_1_1_1_1.setBackground(new Color(30, 144, 255));
		btnMinus_1_1_1_1_1_1_1.setBounds(899, 251, 97, 23);
		frame5.getContentPane().add(btnMinus_1_1_1_1_1_1_1);
		
		JButton btnMinus_2 = new JButton("-");
		btnMinus_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_14.setText(""+ --q);
			}
		});
		btnMinus_2.setForeground(Color.WHITE);
		btnMinus_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMinus_2.setBackground(new Color(30, 144, 255));
		btnMinus_2.setBounds(152, 472, 89, 23);
		frame5.getContentPane().add(btnMinus_2);
		
		JButton btnMinus_2_1 = new JButton("-");
		btnMinus_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_12.setText(""+ --r);
			}
		});
		btnMinus_2_1.setForeground(Color.WHITE);
		btnMinus_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMinus_2_1.setBackground(new Color(30, 144, 255));
		btnMinus_2_1.setBounds(383, 468, 97, 23);
		frame5.getContentPane().add(btnMinus_2_1);
		
		JButton btnMinus_2_1_1 = new JButton("-");
		btnMinus_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_11.setText(""+ --s);
			}
		});
		btnMinus_2_1_1.setForeground(Color.WHITE);
		btnMinus_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMinus_2_1_1.setBackground(new Color(30, 144, 255));
		btnMinus_2_1_1.setBounds(495, 472, 97, 23);
		frame5.getContentPane().add(btnMinus_2_1_1);
		
		JButton btnMinus_2_1_1_1 = new JButton("-");
		btnMinus_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_18.setText(""+ --t);
			}
		});
		btnMinus_2_1_1_1.setForeground(Color.WHITE);
		btnMinus_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMinus_2_1_1_1.setBackground(new Color(30, 144, 255));
		btnMinus_2_1_1_1.setBounds(616, 468, 97, 23);
		frame5.getContentPane().add(btnMinus_2_1_1_1);

		JButton btnMinus_2_1_1_1_1 = new JButton("-");
		btnMinus_2_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_17.setText(""+ --u);
			}
		});
		btnMinus_2_1_1_1_1.setForeground(Color.WHITE);
		btnMinus_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMinus_2_1_1_1_1.setBackground(new Color(30, 144, 255));
		btnMinus_2_1_1_1_1.setBounds(725, 472, 97, 23);
		frame5.getContentPane().add(btnMinus_2_1_1_1_1);
		
		JButton btnMinus_2_1_2 = new JButton("Reset");
		btnMinus_2_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				overs = 0;
				balls =0;
				textField_1.setText(""+overs + "." + balls);
			}
		});
		btnMinus_2_1_2.setForeground(Color.WHITE);
		btnMinus_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMinus_2_1_2.setBackground(new Color(30, 144, 255));
		btnMinus_2_1_2.setBounds(269, 472, 97, 23);
		frame5.getContentPane().add(btnMinus_2_1_2);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Inning End");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect();
				
				String teamaa,teamnameb,addinfo,midd;
								
				teamaa = teamname1.getText();
				teamnameb = teamb.getText();
				addinfo= textField_16.getText();
				midd= mid.getText();

				try {
					pst = con.prepareStatement("insert into inningend(teamnamea,teamnameb,addinfo,mid)values(?,?,?,?)");
					pst.setString(1, teamaa);
					pst.setString(2, teamnameb);
					pst.setString(3, addinfo);
					pst.setString(4, midd);
					pst.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				textField_16.setText("");

			}
		});
		btnNewButton_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1_1_1.setBackground(Color.RED);
		btnNewButton_1_1_1_1.setBounds(563, 536, 150, 28);
		frame5.getContentPane().add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_2 = new JButton("Score Board");
		btnNewButton_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				score dashh = new score();
				dashh.frames.setVisible(true);
			}
		});
		btnNewButton_1_1_1_2.setForeground(Color.WHITE);
		btnNewButton_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1_1_2.setBackground(new Color(30, 144, 255));
		btnNewButton_1_1_1_2.setBounds(433, 536, 120, 28);
		frame5.getContentPane().add(btnNewButton_1_1_1_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("_______________________________________________________________________________________________________________________________");
		lblNewLabel_1_1.setBounds(39, 33, 944, 14);
		frame5.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("_______________________________________________________________________________________________________________________________");
		lblNewLabel_1_1_1.setBounds(39, 305, 944, 14);
		frame5.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\rasika\\eclipse-workspace\\Cricket Dashbord\\img\\Untitled-1.png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(205, 94, 584, 458);
		frame5.getContentPane().add(lblNewLabel_1);
		
		
		
		
	}
}
