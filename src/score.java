import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class score {

	JFrame frames;
	private JTextField txtPlayerName;
	private JTextField tname1;
	private JTextField txtR;
	private JTextField txt4;
	private JTextField txt6;
	private JTextField txtW;
	private JTextField txtMatchScore;
	private JTextField tname2;
	private JTextField teamb;
	private JTextField txtrb;
	private JTextField txt4b;
	private JTextField txt6b;
	private JTextField txtwb;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					score window = new score();
					window.frames.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public score() {
		initialize();
		Connect ();
		Connect2 ();
		Connect3 ();
		Connect4 ();
		Connect5 ();
	}
	
	Connection con;
	PreparedStatement pst;
	private JTextField txteb;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	
	public void Connect () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/dashboard","root","");
			Statement st = con.createStatement();
			 ResultSet r=st.executeQuery("SELECT * FROM dashboard WHERE ID = (SELECT MAX(id) FROM dashboard)");
			 while (r.next()) {
				tname1.setText(r.getString("team2"));
				tname2.setText(r.getString("team1"));
			 }
		}
		catch (ClassNotFoundException ex){

			}
		catch (SQLException ex){

		}
	}
	public void Connect2 () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/dashboard","root","");
			Statement st = con.createStatement();
			ResultSet r=st.executeQuery("SELECT * FROM score WHERE match_id_p = (SELECT MAX(match_id_p) FROM score)");
			while (r.next()) {
				txtPlayerName.setText(r.getString("player_name"));
				txtR.setText(r.getString("score"));
				txt4.setText(r.getString("fours"));
				txt6.setText(r.getString("sixes"));
			}
		}
		catch (ClassNotFoundException ex){
			
		}
		catch (SQLException ex){
			
		}
	}
	
	public void Connect3 () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/dashboard","root","");
			Statement st = con.createStatement();
			ResultSet r=st.executeQuery("SELECT * FROM bowling WHERE match_id = (SELECT MAX(match_id) FROM bowling)");
			while (r.next()) {
				teamb.setText(r.getString("player_name"));
				txtrb.setText(r.getString("score"));
				txt4b.setText(r.getString("fours"));
				txt6b.setText(r.getString("sixes"));
				txtwb.setText(r.getString("wickets"));
				txteb.setText(r.getString("extras"));
				
			}
		}
		catch (ClassNotFoundException ex){
			
		}
		catch (SQLException ex){
			
		}
	}
	
	public void Connect4 () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/dashboard","root","");
			Statement st = con.createStatement();
			ResultSet r=st.executeQuery("SELECT * FROM score where mid=(select mid from score order by mid desc limit 1 )");
			int sum = 0;
			while (r.next()) {
			     String score = r.getString("score");
				 sum += Integer.parseInt(score);
			}
			txtMatchScore.setText(""+sum);
			
		}
		catch (ClassNotFoundException ex){
			
		}
		catch (SQLException ex){
			
		}
	}
	public void Connect5 () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/dashboard","root","");
			Statement st = con.createStatement();
			ResultSet r=st.executeQuery("SELECT * FROM bowling where mid=(select mid from bowling order by mid desc limit 1 )");
			int sum = 0;
			while (r.next()) {
			     String score = r.getString("wickets");
				 sum += Integer.parseInt(score);
			}
			txtW.setText(""+sum);
			
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
		frames = new JFrame();
		frames.setTitle("Cricket Score Dashboard");
		frames.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rasika\\eclipse-workspace\\Cricket Dashbord\\img\\ball.png"));
		frames.getContentPane().setBackground(Color.WHITE);
		frames.setBounds(100, 100, 1000, 500);
		frames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frames.getContentPane().setLayout(null);
		
		lblNewLabel_10 = new JLabel("Wickets");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_10.setBackground(Color.WHITE);
		lblNewLabel_10.setBounds(867, 303, 66, 42);
		frames.getContentPane().add(lblNewLabel_10);
		
		lblNewLabel_9 = new JLabel("Extras");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_9.setBackground(Color.WHITE);
		lblNewLabel_9.setBounds(791, 303, 66, 42);
		frames.getContentPane().add(lblNewLabel_9);
		
		lblNewLabel_7 = new JLabel("4s");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBackground(Color.WHITE);
		lblNewLabel_7.setBounds(639, 303, 66, 42);
		frames.getContentPane().add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("6s");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBackground(Color.WHITE);
		lblNewLabel_8.setBounds(715, 303, 66, 42);
		frames.getContentPane().add(lblNewLabel_8);
		
		lblNewLabel_6 = new JLabel("Runs");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBackground(Color.WHITE);
		lblNewLabel_6.setBounds(560, 303, 66, 42);
		frames.getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_5 = new JLabel("6s");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBackground(Color.WHITE);
		lblNewLabel_5.setBounds(193, 303, 66, 42);
		frames.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_3 = new JLabel("4s");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setBounds(105, 303, 66, 42);
		frames.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Runs");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(26, 303, 66, 42);
		frames.getContentPane().add(lblNewLabel_4);
		
		txtPlayerName = new JTextField();
		txtPlayerName.setEditable(false);
		txtPlayerName.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlayerName.setText("Player Name");
		txtPlayerName.setBounds(26, 167, 145, 29);
		frames.getContentPane().add(txtPlayerName);
		txtPlayerName.setColumns(10);
		
		tname1 = new JTextField();
		tname1.setEditable(false);
		tname1.setFont(new Font("Tahoma", Font.BOLD, 18));
		tname1.setHorizontalAlignment(SwingConstants.CENTER);
		tname1.setText("Team Name");
		tname1.setBounds(26, 133, 145, 29);
		frames.getContentPane().add(tname1);
		tname1.setColumns(10);
		
		txtR = new JTextField();
		txtR.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtR.setHorizontalAlignment(SwingConstants.CENTER);
		txtR.setText("R");
		txtR.setColumns(10);
		txtR.setBounds(26, 229, 66, 63);
		frames.getContentPane().add(txtR);
		
		txt4 = new JTextField();
		txt4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txt4.setText("4s");
		txt4.setHorizontalAlignment(SwingConstants.CENTER);
		txt4.setColumns(10);
		txt4.setBounds(105, 229, 66, 63);
		frames.getContentPane().add(txt4);
		
		txt6 = new JTextField();
		txt6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txt6.setText("6s");
		txt6.setHorizontalAlignment(SwingConstants.CENTER);
		txt6.setColumns(10);
		txt6.setBounds(193, 229, 66, 63);
		frames.getContentPane().add(txt6);
		
		txtW = new JTextField();
		txtW.setEditable(false);
		txtW.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtW.setText("W");
		txtW.setHorizontalAlignment(SwingConstants.CENTER);
		txtW.setColumns(10);
		txtW.setBounds(329, 133, 66, 63);
		frames.getContentPane().add(txtW);
		
		txtMatchScore = new JTextField();
		txtMatchScore.setEditable(false);
		txtMatchScore.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtMatchScore.setHorizontalAlignment(SwingConstants.CENTER);
		txtMatchScore.setColumns(10);
		txtMatchScore.setBounds(176, 133, 117, 63);
		frames.getContentPane().add(txtMatchScore);
		
		tname2 = new JTextField();
		tname2.setEditable(false);
		tname2.setFont(new Font("Tahoma", Font.BOLD, 18));
		tname2.setText("Team Name");
		tname2.setHorizontalAlignment(SwingConstants.CENTER);
		tname2.setColumns(10);
		tname2.setBounds(560, 133, 150, 29);
		frames.getContentPane().add(tname2);
		
		teamb = new JTextField();
		teamb.setEditable(false);
		teamb.setFont(new Font("Tahoma", Font.BOLD, 16));
		teamb.setText("Player Name");
		teamb.setHorizontalAlignment(SwingConstants.CENTER);
		teamb.setColumns(10);
		teamb.setBounds(560, 167, 150, 29);
		frames.getContentPane().add(teamb);
		
		txtrb = new JTextField();
		txtrb.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtrb.setText("R");
		txtrb.setHorizontalAlignment(SwingConstants.CENTER);
		txtrb.setColumns(10);
		txtrb.setBounds(560, 229, 66, 63);
		frames.getContentPane().add(txtrb);
		
		txt4b = new JTextField();
		txt4b.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txt4b.setText("4s");
		txt4b.setHorizontalAlignment(SwingConstants.CENTER);
		txt4b.setColumns(10);
		txt4b.setBounds(639, 229, 66, 63);
		frames.getContentPane().add(txt4b);
		
		txt6b = new JTextField();
		txt6b.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txt6b.setText("6s");
		txt6b.setHorizontalAlignment(SwingConstants.CENTER);
		txt6b.setColumns(10);
		txt6b.setBounds(715, 229, 66, 63);
		frames.getContentPane().add(txt6b);
		
		txtwb = new JTextField();
		txtwb.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtwb.setText("W");
		txtwb.setHorizontalAlignment(SwingConstants.CENTER);
		txtwb.setColumns(10);
		txtwb.setBounds(867, 229, 66, 63);
		frames.getContentPane().add(txtwb);
		
		JLabel lblNewLabel = new JLabel("Cricket Score Board");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel.setBounds(346, 22, 319, 63);
		frames.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblNewLabel_1.setBounds(303, 133, 25, 63);
		frames.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("REFRESH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect ();
				Connect2 ();
				Connect3 ();
				Connect4 ();
				Connect5 ();
			}
		});
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton.setBounds(390, 359, 196, 56);
		frames.getContentPane().add(btnNewButton);
		
		txteb = new JTextField();
		txteb.setText("E");
		txteb.setHorizontalAlignment(SwingConstants.CENTER);
		txteb.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txteb.setColumns(10);
		txteb.setBounds(791, 229, 66, 63);
		frames.getContentPane().add(txteb);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 74));
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\rasika\\eclipse-workspace\\Cricket Dashbord\\img\\image.jpg"));
		lblNewLabel_2.setBounds(0, 0, 984, 461);
		frames.getContentPane().add(lblNewLabel_2);
	}
}
