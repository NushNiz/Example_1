


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;

	

public class Loading {
	
	static Timer timer;
	
	public static void main(String[] args) {

		/*JLabel label = new JLabel();
		label.setText("Cricket Score Board");
		label.setVisible(true);
		label.setLayout(null);*/

		JFrame frame2 = new JFrame("progress bar");
		frame2.setTitle("Cricket Score Dashboard");
		frame2.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rasika\\eclipse-workspace\\Cricket Dashbord\\img\\ball.png"));
		frame2.getContentPane().setBackground(new Color(240, 248, 255));
		frame2.setBounds(100,100,852,549);
		frame2.setVisible(true);
		frame2.getContentPane().setLayout(null);
		
		JProgressBar progress = new JProgressBar();
		progress.setBounds(318,287,175,29);
		progress.setStringPainted(true);
		progress.setForeground(Color.BLUE);
		progress.setBackground(Color.LIGHT_GRAY);
		progress.setBorder(new LineBorder(Color.DARK_GRAY));
		progress.setVisible(true);
		frame2.getContentPane().add(progress);
		
		JToggleButton onoff = new JToggleButton("START");
		onoff.setBackground(new Color(30, 144, 255));
		onoff.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(onoff.isSelected()) {
					timer.start();
				}else {
					timer.stop();
				}
				
			}});
		onoff.setBounds(360,363,100,29);
		frame2.getContentPane().add(onoff);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\rasika\\eclipse-workspace\\Cricket Dashbord\\img\\Untitled-1.png"));
		lblNewLabel.setBounds(126, 60, 569, 396);
		frame2.getContentPane().add(lblNewLabel);
		
		timer = new Timer(30, new ActionListener() {
			
			private int x=0;

			@Override
			public void actionPerformed(ActionEvent e) {
				
				progress.setValue(x++);
				if(x==100) {
					timer.stop();
					dashbord dash = new dashbord();
					dash.frame.setVisible(true);
					frame2.dispose();
				}
				
			}
			
		});
		
		
		
	}
}