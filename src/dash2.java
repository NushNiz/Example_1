import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;


public class dash2 {

	JFrame Secframe;
	private JTextField s1;
	private JTextField s2;
	private JTextField s3;
	private JTextField s4;
	private JTextField s5;
	private JTextField s6;
	private JTextField s7;
	private JTextField s8;
	private JTextField s9;
	private JTextField s10;
	private JTextField s11;
	private JTextField s12;
	private JTextField q1;
	private JTextField q2;
	private JTextField q3;
	private JTextField q4;
	private JTextField q5;
	private JTextField q6;
	private JTextField q7;
	private JTextField q8;
	private JTextField q9;
	private JTextField q10;
	private JTextField q11;
	private JTextField q12;
	private JComboBox comboBox;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;
	private JLabel lblNewLabel_1_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dash2 window = new dash2();
					window.Secframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public dash2() {
		initialize();
		Connect();
	}

	Connection con;
	PreparedStatement pst;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JLabel lblNewLabel;
	
	public void Connect () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/dashboard","root","");
			Statement st = con.createStatement();
			 ResultSet r=st.executeQuery("SELECT * FROM dashboard WHERE ID = (SELECT MAX(id) FROM dashboard)");
			 while (r.next()) {
				 comboBox_1.addItem(r.getString("team1"));
				 comboBox_1.addItem(r.getString("team2"));
				 comboBox_2.addItem(r.getString("team1"));
				 comboBox_2.addItem(r.getString("team2"));
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
		Secframe = new JFrame();
		Secframe.setTitle("Cricket Score Dashboard");
		Secframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rasika\\eclipse-workspace\\Cricket Dashbord\\img\\ball.png"));
		Secframe.getContentPane().setBackground(new Color(240, 248, 255));
		Secframe.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Next");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dash3 dashh = new dash3();
				dashh.frame3.setVisible(true);
				Secframe.dispose();
				
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBackground(new Color(30, 144, 255));
		btnNewButton_1.setBounds(679, 632, 118, 28);
		Secframe.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Connect();
				
				String toss,team_name,player1,player2,player3,player4,player5,player6,player7,player8,player9,player10,player11,player12;
				
				toss = (String)comboBox.getSelectedItem();
				team_name = (String)comboBox_1.getSelectedItem();
				player1 = s1.getText();
				player2 = s2.getText();
				player3 = s3.getText();
				player4 = s4.getText();
				player5 = s5.getText();
				player6 = s6.getText();
				player7 = s7.getText();
				player8 = s8.getText();
				player9 = s9.getText();
				player10 =s10.getText();
				player11 =s11.getText();
				player12 =s12.getText();
				
				
				try {
					pst = con.prepareStatement("insert into teama(Toss,team_name,player1,player2,player3,player4,player5,player6,player7,player8,player9,player10,player11,player12)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					pst.setString(1, (String)comboBox.getSelectedItem());
					pst.setString(2, team_name);
					pst.setString(3, player1);
					pst.setString(4, player2);
					pst.setString(5, player3);
					pst.setString(6, player4);
					pst.setString(7,player5);
					pst.setString(8,player6);
					pst.setString(9, player7);
					pst.setString(10, player8);
					pst.setString(11, player9);
					pst.setString(12, player10);
					pst.setString(13, player11);
					pst.setString(14, player12);
					pst.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
				s1.setText("");
				s2.setText("");
				s3.setText("");
				s4.setText("");
				s5.setText("");
				s6.setText("");
				s7.setText("");
				s8.setText("");
				s9.setText("");
				s10.setText("");
				s11.setText("");
				s12.setText("");
				
				
				
				
				String ttoss,tteam_name,tplayer1,tplayer2,tplayer3,tplayer4,tplayer5,tplayer6,tplayer7,tplayer8,tplayer9,tplayer10,tplayer11,tplayer12;
				
				ttoss = (String)comboBox.getSelectedItem();
				tteam_name = (String)comboBox_2.getSelectedItem();
				tplayer1 = q1.getText();
				tplayer2 = q2.getText();
				tplayer3 = q3.getText();
				tplayer4 = q4.getText();
				tplayer5 = q5.getText();
				tplayer6 = q6.getText();
				tplayer7 = q7.getText();
				tplayer8 = q8.getText();
				tplayer9 = q9.getText();
				tplayer10 =q10.getText();
				tplayer11 =q11.getText();
				tplayer12 =q12.getText();
				
				
				try {
					pst = con.prepareStatement("insert into teamb(toss,team_name,player1,player2,player3,player4,player5,player6,player7,player8,player9,player10,player11,player12)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					pst.setString(1, (String)comboBox.getSelectedItem());
					pst.setString(2, tteam_name);
					pst.setString(3, tplayer1);
					pst.setString(4, tplayer2);
					pst.setString(5, tplayer3);
					pst.setString(6, tplayer4);
					pst.setString(7,tplayer5);
					pst.setString(8,tplayer6);
					pst.setString(9, tplayer7);
					pst.setString(10, tplayer8);
					pst.setString(11, tplayer9);
					pst.setString(12, tplayer10);
					pst.setString(13, tplayer11);
					pst.setString(14, tplayer12);
					pst.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				JOptionPane.showMessageDialog(null,"add success!");
				
				q1.setText("");
				q2.setText("");
				q3.setText("");
				q4.setText("");
				q5.setText("");
				q6.setText("");
				q7.setText("");
				q8.setText("");
				q9.setText("");
				q10.setText("");
				q11.setText("");
				q12.setText("");
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setBounds(551, 632, 118, 28);
		Secframe.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Toss");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(256, 24, 46, 14);
		Secframe.getContentPane().add(lblNewLabel_1);
		
		s1 = new JTextField();
		s1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		s1.setColumns(10);
		s1.setBackground(new Color(255, 255, 255));
		s1.setBounds(125, 158, 205, 28);
		Secframe.getContentPane().add(s1);
		
		s2 = new JTextField();
		s2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		s2.setColumns(10);
		s2.setBackground(new Color(255, 255, 255));
		s2.setBounds(125, 197, 205, 28);
		Secframe.getContentPane().add(s2);
		
		s3 = new JTextField();
		s3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		s3.setColumns(10);
		s3.setBackground(new Color(255, 255, 255));
		s3.setBounds(125, 236, 205, 28);
		Secframe.getContentPane().add(s3);
		
		s4 = new JTextField();
		s4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		s4.setColumns(10);
		s4.setBackground(new Color(255, 255, 255));
		s4.setBounds(125, 275, 205, 28);
		Secframe.getContentPane().add(s4);
		
		s5 = new JTextField();
		s5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		s5.setColumns(10);
		s5.setBackground(new Color(255, 255, 255));
		s5.setBounds(125, 314, 205, 28);
		Secframe.getContentPane().add(s5);
		
		s6 = new JTextField();
		s6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		s6.setColumns(10);
		s6.setBackground(new Color(255, 255, 255));
		s6.setBounds(125, 353, 205, 28);
		Secframe.getContentPane().add(s6);
		
		s7 = new JTextField();
		s7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		s7.setColumns(10);
		s7.setBackground(new Color(255, 255, 255));
		s7.setBounds(125, 392, 205, 28);
		Secframe.getContentPane().add(s7);
		
		s8 = new JTextField();
		s8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		s8.setColumns(10);
		s8.setBackground(new Color(255, 255, 255));
		s8.setBounds(125, 431, 205, 28);
		Secframe.getContentPane().add(s8);
		
		s9 = new JTextField();
		s9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		s9.setColumns(10);
		s9.setBackground(new Color(255, 255, 255));
		s9.setBounds(125, 470, 205, 28);
		Secframe.getContentPane().add(s9);
		
		s10 = new JTextField();
		s10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		s10.setColumns(10);
		s10.setBackground(new Color(255, 255, 255));
		s10.setBounds(125, 509, 205, 28);
		Secframe.getContentPane().add(s10);
		
		s11 = new JTextField();
		s11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		s11.setColumns(10);
		s11.setBackground(new Color(255, 255, 255));
		s11.setBounds(125, 548, 205, 28);
		Secframe.getContentPane().add(s11);
		
		s12 = new JTextField();
		s12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		s12.setColumns(10);
		s12.setBackground(new Color(255, 255, 255));
		s12.setBounds(125, 587, 205, 28);
		Secframe.getContentPane().add(s12);
		
		q1 = new JTextField();
		q1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		q1.setColumns(10);
		q1.setBackground(new Color(255, 255, 255));
		q1.setBounds(510, 158, 205, 28);
		Secframe.getContentPane().add(q1);
		
		q2 = new JTextField();
		q2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		q2.setColumns(10);
		q2.setBackground(new Color(255, 255, 255));
		q2.setBounds(510, 197, 205, 28);
		Secframe.getContentPane().add(q2);
		
		q3 = new JTextField();
		q3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		q3.setColumns(10);
		q3.setBackground(new Color(255, 255, 255));
		q3.setBounds(510, 236, 205, 28);
		Secframe.getContentPane().add(q3);
		
		q4 = new JTextField();
		q4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		q4.setColumns(10);
		q4.setBackground(new Color(255, 255, 255));
		q4.setBounds(510, 275, 205, 28);
		Secframe.getContentPane().add(q4);
		
		q5 = new JTextField();
		q5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		q5.setColumns(10);
		q5.setBackground(new Color(255, 255, 255));
		q5.setBounds(510, 314, 205, 28);
		Secframe.getContentPane().add(q5);
		
		q6 = new JTextField();
		q6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		q6.setColumns(10);
		q6.setBackground(new Color(255, 255, 255));
		q6.setBounds(510, 353, 205, 28);
		Secframe.getContentPane().add(q6);
		
		q7 = new JTextField();
		q7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		q7.setColumns(10);
		q7.setBackground(new Color(255, 255, 255));
		q7.setBounds(510, 392, 205, 28);
		Secframe.getContentPane().add(q7);
		
		q8 = new JTextField();
		q8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		q8.setColumns(10);
		q8.setBackground(new Color(255, 255, 255));
		q8.setBounds(510, 431, 205, 28);
		Secframe.getContentPane().add(q8);
		
		q9 = new JTextField();
		q9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		q9.setColumns(10);
		q9.setBackground(new Color(255, 255, 255));
		q9.setBounds(510, 470, 205, 28);
		Secframe.getContentPane().add(q9);
		
		q10 = new JTextField();
		q10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		q10.setColumns(10);
		q10.setBackground(new Color(255, 255, 255));
		q10.setBounds(510, 509, 205, 28);
		Secframe.getContentPane().add(q10);
		
		q11 = new JTextField();
		q11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		q11.setColumns(10);
		q11.setBackground(new Color(255, 255, 255));
		q11.setBounds(510, 548, 205, 28);
		Secframe.getContentPane().add(q11);
		
		q12 = new JTextField();
		q12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		q12.setColumns(10);
		q12.setBackground(new Color(255, 255, 255));
		q12.setBounds(510, 587, 205, 28);
		Secframe.getContentPane().add(q12);
		
		JLabel lblNewLabel_1_1 = new JLabel("Squad");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(208, 130, 55, 17);
		Secframe.getContentPane().add(lblNewLabel_1_1);
		
		comboBox = new JComboBox();
		comboBox.addItem("Team One");
		comboBox.addItem("Team Two");
		comboBox.setBounds(312, 22, 205, 28);
		Secframe.getContentPane().add(comboBox);
		
		lblNewLabel_1_2 = new JLabel("Team One");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(125, 70, 75, 14);
		Secframe.getContentPane().add(lblNewLabel_1_2);
		
		lblNewLabel_1_3 = new JLabel("Team Two");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(510, 70, 75, 14);
		Secframe.getContentPane().add(lblNewLabel_1_3);
		
		lblNewLabel_1_4 = new JLabel("Squad");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(580, 133, 55, 17);
		Secframe.getContentPane().add(lblNewLabel_1_4);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(125, 91, 205, 28);
		Secframe.getContentPane().add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(510, 91, 205, 28);
		Secframe.getContentPane().add(comboBox_2);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\rasika\\eclipse-workspace\\Cricket Dashbord\\img\\Untitled-1.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(125, 157, 584, 458);
		Secframe.getContentPane().add(lblNewLabel);
		Secframe.setBounds(100, 100, 823, 710);
		Secframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
