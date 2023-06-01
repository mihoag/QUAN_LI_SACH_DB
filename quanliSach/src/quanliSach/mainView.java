package quanliSach;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import JDBCUtil.JDBCUtil;
import control.control;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class mainView extends JFrame {
	public JTextField txt_nxb;
	public JTextField txt_ten;
	public JTextField txt_diachi;
	public JTextField txt_dt;
    public JButton btn_pre;
    public JButton btn_next;
    public JButton btn_insert;
    public JButton btn_save;
    public JButton btn_delete;
    public JButton btn_;
    public JButton btn_edit;
    public JButton btn_search;
     public DefaultTableModel tb;
     public JTable tbSach;
    
    public ResultSet rs;
    
    
	/**
	 * Launch the application.

	/**
	 * Create the frame.
	 */
    public void hienthi()
    {
    	try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from NXB";
		    Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		    rs = st.executeQuery(sql);
		    tb.setRowCount(0);
		    while(rs.next())
		    {
		      String arr[] = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
		      tb.addRow(arr);
		    }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
	public mainView() {
		getContentPane().setLocation(-611, -26);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 700);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		this.setTitle("Quản lí sách");
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(255, 255, 202));
		pn1.setBounds(10, 10, 517, 353);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN NHÀ XUẤT BẢN");
		lblNewLabel.setBounds(57, 35, 412, 35);
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		pn1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã NXB");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(57, 80, 83, 42);
		pn1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên NXB");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(57, 132, 83, 42);
		pn1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Địa chỉ");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(57, 184, 83, 42);
		pn1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Điện thoại");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(54, 238, 101, 42);
		pn1.add(lblNewLabel_1_3);
		
		txt_nxb = new JTextField();
		txt_nxb.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt_nxb.setBounds(183, 86, 255, 35);
		pn1.add(txt_nxb);
		txt_nxb.setColumns(10);
		
		txt_ten = new JTextField();
		txt_ten.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt_ten.setColumns(10);
		txt_ten.setBounds(183, 139, 255, 35);
		pn1.add(txt_ten);
		
		txt_diachi = new JTextField();
		txt_diachi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt_diachi.setColumns(10);
		txt_diachi.setBounds(183, 190, 255, 35);
		pn1.add(txt_diachi);
		
		txt_dt = new JTextField();
		txt_dt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt_dt.setColumns(10);
		txt_dt.setBounds(183, 244, 255, 35);
		pn1.add(txt_dt);
		
		 btn_pre = new JButton("PRE");
		btn_pre.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btn_pre.setBackground(new Color(253, 163, 123));
		btn_pre.setBounds(72, 301, 131, 42);
		pn1.add(btn_pre);
		
		 btn_next = new JButton("NEXT");
		btn_next.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btn_next.setBackground(new Color(253, 163, 123));
		btn_next.setBounds(271, 301, 145, 42);
		pn1.add(btn_next);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(255, 217, 217));
		pn2.setBounds(537, 10, 239, 353);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		btn_insert = new JButton("INSERT");
		btn_insert.setBackground(new Color(0, 255, 255));
		btn_insert.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btn_insert.setBounds(23, 46, 188, 53);
		pn2.add(btn_insert);
		
		btn_save = new JButton("SAVE");
		btn_save.setBackground(new Color(0, 255, 255));
		btn_save.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btn_save.setBounds(23, 121, 188, 53);
		pn2.add(btn_save);
	
		
		btn_delete = new JButton("DELETE");
		btn_delete.setBackground(new Color(0, 255, 255));
		btn_delete.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btn_delete.setBounds(23, 199, 188, 53);
		pn2.add(btn_delete);
		
		btn_edit = new JButton("EDIT");
		btn_edit.setBackground(new Color(0, 255, 255));
		btn_edit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btn_edit.setBounds(23, 274, 188, 53);
		pn2.add(btn_edit);
		///////////
		
		btn_delete.setOpaque(true);
		btn_edit.setOpaque(true);
		btn_insert.setOpaque(true);
		btn_next.setOpaque(true);
		btn_pre.setOpaque(true);
		btn_save.setOpaque(true);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(10, 373, 766, 217);
		getContentPane().add(pn3);
		
		btn_search = new JButton("SEARCH");
		btn_search.setOpaque(true);
		btn_search.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btn_search.setBackground(Color.CYAN);
		btn_search.setBounds(10, 600, 165, 53);
		getContentPane().add(btn_search);
		btn_search.setOpaque(true);
		
		
		/////////////////////
		
		TitledBorder t1 = new TitledBorder(BorderFactory.createLineBorder(Color.black), "Thông tin chi tiết");
		t1.setTitleFont(new Font("Times New Roman", Font.PLAIN, 23));
		pn1.setBorder(t1);
		t1.setTitleColor(Color.RED);
		
		TitledBorder t2 = new TitledBorder(BorderFactory.createLineBorder(Color.black), "Thực hiện");
		t2.setTitleFont(new Font("Times New Roman", Font.PLAIN, 23));
		t2.setTitleColor(Color.RED);
		
		TitledBorder t3 = new TitledBorder(BorderFactory.createLineBorder(Color.black), "Danh sách nhà xuất bản");
		t3.setTitleFont(new Font("Times New Roman", Font.PLAIN, 23));
		t3.setTitleColor(Color.RED);
		
		pn2.setBorder(t2);
		pn3.setBorder(t3);
     //////////
		
		 tb = new DefaultTableModel();
		 tb.addColumn("Mã NXB");
		 tb.addColumn("Tên NXB");
		 tb.addColumn("Điện thoại");
		 tb.addColumn("Đia chỉ");
  
		 tbSach = new JTable(tb);
		 tbSach.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		 pn3.setLayout(new BorderLayout());
		 
		 JScrollPane sc = new JScrollPane(tbSach, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		 pn3.add(sc);
		 pn3.add(sc,BorderLayout.CENTER);
		 ////////////////////////////////
		 
		 btn_search.setIcon(new ImageIcon("src/icon/search.png"));
		 btn_delete.setIcon(new ImageIcon("src/icon/delete.png"));
		 btn_edit.setIcon(new ImageIcon("src/icon/edit.png"));
		 btn_save.setIcon(new ImageIcon("src/icon/save.png"));
		 btn_pre.setIcon(new ImageIcon("src/icon/pre.png"));
		 btn_next.setIcon(new ImageIcon("src/icon/next.png"));
		 btn_insert.setIcon(new ImageIcon("src/icon/insert.png"));
		 
		////////////
		 
		 hienthi();
		 
		///////////////
		 control ac = new control(this);
		 btn_pre.addActionListener(ac);
		 btn_next.addActionListener(ac);
		 btn_insert.addActionListener(ac);
		 btn_delete.addActionListener(ac);
		 btn_edit.addActionListener(ac);
		 btn_save.addActionListener(ac);
		 btn_search.addActionListener(ac);
		 //////////////////////////
		 
		 
		 ///////////
		this.setResizable(false);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new mainView();
	}
}
