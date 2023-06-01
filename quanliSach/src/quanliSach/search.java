package quanliSach;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import JDBCUtil.JDBCUtil;
import control.control_search;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.ScrollPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;

public class search extends JFrame {
	 public JTextField textField;
	 public DefaultTableModel tb;
     public JTable tbSach;
	
     public void hienthi()
     {
    	 try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "select * from sach";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				
				String[] arr = {rs.getString(1), rs.getString(2),rs.getString(3)};
				tb.addRow(arr);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
     }
	public search() {
		this.setTitle("search");
		this.setSize(600, 800);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		control_search ac=  new control_search(this);
		
		
		JLabel lblNewLabel = new JLabel("Tìm kiếm");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 10, 97, 42);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(136, 17, 296, 35);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("search");
		btnNewButton.setBackground(new Color(66, 176, 230));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.setBounds(442, 14, 111, 42);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(ac);
		
		JPanel p1 = new JPanel();
		p1.setBounds(10, 93, 566, 590);
		getContentPane().add(p1);
		
		
		
		tb = new DefaultTableModel();
		///////////////////////
		tb.addColumn("Mã sách");
		tb.addColumn("Tên sách");
		tb.addColumn("Mã NXB");
		
		p1.setLayout(new BorderLayout());
		tbSach = new JTable(tb);
		JScrollPane sc = new JScrollPane(tbSach, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		p1.add(sc,BorderLayout.CENTER);
	
		///
		hienthi();
		///
		this.setVisible(true);
	}
}
