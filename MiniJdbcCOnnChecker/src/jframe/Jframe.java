package jframe;

import javax.print.attribute.standard.Destination;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.border.BevelBorder;

import com.mysql.cj.exceptions.UnableToConnectException;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Jframe extends JFrame{

	private static final long serialVersionUID = 1L;
	public JTextField textField1;
	public JTextField textField2;
	public JTextField textField3;
	public JTextField textField4;
	public JLabel lblserver;
	Connection conn = null;

	public Jframe() {
		setForeground(Color.GREEN);
		setBackground(Color.RED);
		setVisible(true);
		setBounds(600, 200, 300, 400);
		setDefaultCloseOperation(Jframe.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);
//		setResizable(false);

		JLabel label1 = new JLabel("DataBase Management System");
		label1.setBounds(37, 38, 222, 15);
		getContentPane().add(label1);

		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setBounds(12, 101, 81, 15);
		getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(12, 137, 81, 15);
		getContentPane().add(lblPassword);

		textField1 = new JTextField();
		textField1.setBounds(100, 99, 159, 19);
		getContentPane().add(textField1);
		textField1.setColumns(10);
		textField2 = new JTextField();
		textField2.setBounds(100, 135, 159, 19);
		getContentPane().add(textField2);
		textField2.setColumns(10);
		
		
		
		JLabel forgetpsswd = new JLabel("Forget Password ?");
		forgetpsswd.setBackground(Color.YELLOW);
		forgetpsswd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://me.forgetpasswd.com"));
				} catch (IOException | URISyntaxException e1) {
					e1.printStackTrace();
				}

			}
		});
		forgetpsswd.setBounds(100, 203, 139, 15);
		getContentPane().add(forgetpsswd);
		forgetpsswd.setForeground(Color.blue);
		
		lblserver = new JLabel("Server:");
		lblserver.setBounds(12, 74, 81, 15);
		getContentPane().add(lblserver);
		
		textField3 = new JTextField();
		textField3.setBounds(100, 72, 114, 19);
		getContentPane().add(textField3);
		textField3.setColumns(10);
		textField3.setText("localhost");
		
		JLabel lblDatabase = new JLabel("Database:");
		lblDatabase.setBounds(12, 172, 81, 15);
		getContentPane().add(lblDatabase);
		
		textField4 = new JTextField();
		textField4.setBounds(100, 172, 159, 19);
		getContentPane().add(textField4);
		textField4.setColumns(10);
		
	
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(119, 244, 95, 25);
		getContentPane().add(btnLogin);

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
						try {
							
							String serverString = textField3.getText() + "/" + textField4.getText();
							String usernameString = textField1.getText();
							String passwordString = textField2.getText();
//							String databaseString = textField4.getText();
							Connection conn = DriverManager.getConnection("jdbc:mysql://"+serverString,usernameString,passwordString);
							JOptionPane.showMessageDialog(btnLogin, "Connected!!!");
							
							setVisible(false);
							
							new jframe2(serverString ,usernameString , passwordString).setVisible(true);
						
						} catch (SQLException | ClassNotFoundException e2) {
							JOptionPane.showMessageDialog(btnLogin, "Not Connected!!!");
						
					}
			}
		});
	}

	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					Jframe frame = new Jframe();
//					jframe2 frame2  = new jframe2();
				} catch (Exception e) {
					System.out.println("Error");
				}
				
			}
		});
		
	}
}

	

