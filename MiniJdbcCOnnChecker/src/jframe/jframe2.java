package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.DatabaseMetaData;
import com.mysql.cj.protocol.Resultset;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;

public class jframe2 extends Jframe {

	public JPanel contentPane;
	public JTable table;
	
	
	public jframe2(String  serverString, String usernameString, String passwordString) throws SQLException , ClassNotFoundException{
		
		System.out.println(passwordString);
		System.out.println(usernameString);
		System.out.println(serverString);
		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTables = new JLabel("Tables");
		lblTables.setBounds(202, 35, 55, 15);
		contentPane.add(lblTables);
		
		Connection conn = DriverManager.getConnection(serverString , usernameString , passwordString);
		DatabaseMetaData metadata = (DatabaseMetaData) conn.getMetaData();
		String tabletype[]  = {"TABLE"};		
		Resultset  rstables = (Resultset) metadata.getTables(null, "%", "%", tabletype);
		System.out.println(rstables);
//		
		
		
		
	}
		public Connection getConnection(String  serverString, String usernameString, String passwordString) {
			return conn;
		}
		
	
	
}
