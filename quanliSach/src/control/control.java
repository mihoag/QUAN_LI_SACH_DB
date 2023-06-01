package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import JDBCUtil.JDBCUtil;
import quanliSach.mainView;
import quanliSach.search;

public class control implements ActionListener{
   private mainView v;
   private int pos = 0;
   public control(mainView v)
   {
	   this.v = v;
   } 
   
   public boolean check_tontai(String ma)
   {
	   
	   try {
		   Connection con = JDBCUtil.getConnection();
           String sql = "select * from NXB where ma = ?";
           
		   PreparedStatement p = con.prepareStatement(sql);
		   p.setString(1, ma);
		   
		   ResultSet r = p.executeQuery();
		   return r.next();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	   
	   return true;
   }
   public void insert(String id, String ten, String dc, String dt)
   {
	    try {
			Connection con = JDBCUtil.getConnection();
			String sql = "insert into NXB values (?,?,?,?)";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, id);
			p.setString(2,ten);
			p.setString(3, dc);
			p.setString(4, dt);
			
			int ck = p.executeUpdate();
			if(ck > 0)
			{
				System.out.println("them thanh cong");
			}
			else
			{
				System.out.println("them that bai");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
   }
   public void update(String id, String ten, String dc, String dt)
   {
	   try {
			Connection con = JDBCUtil.getConnection();
			String sql = "update NXB set hoten = ?, diachi = ?, dt = ? where ma = ?";
			
			PreparedStatement p = con.prepareStatement(sql);
		
			p.setString(4, id);
			p.setString(1,ten);
			p.setString(2, dc);
			p.setString(3, dt);
			
			int ck = p.executeUpdate();
			if(ck > 0)
			{
				System.out.println("cap nhat thanh cong");
			}
			else
			{
				System.out.println("cap nhat that bai");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
   }
   
   public void delete(String id)
   {
	   try {
			Connection con = JDBCUtil.getConnection();
			String sql = "delete from NXB where ma = ?";
			
			PreparedStatement p = con.prepareStatement(sql);
		
			p.setString(1, id);
			int ck = p.executeUpdate();
			if(ck > 0)
			{
				System.out.println("xoa thanh cong");
			}
			else
			{
				System.out.println("xoa that bai");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
   }
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	String str = e.getActionCommand();
	if(str.equals("NEXT"))
	{
	   	if(pos == v.tbSach.getRowCount())
	   	{
	   	return;	
	   	}
	   	else
	   	{
	   		pos++;
	   	}
	   	try {
			v.rs.absolute(pos);
		    v.txt_nxb.setText(v.rs.getString(1));
		    v.txt_ten.setText(v.rs.getString(2));
		    v.txt_diachi.setText(v.rs.getString(3));
		    v.txt_dt.setText(v.rs.getString(4));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   	
	}
	else if(str.equals("PRE"))
	{
		if(pos <= 1)
		{
			return;
		}
		else 
		{
			pos--;
		}
		try {
			v.rs.absolute(pos);
		    v.txt_nxb.setText(v.rs.getString(1));
		    v.txt_ten.setText(v.rs.getString(2));
		    v.txt_diachi.setText(v.rs.getString(3));
		    v.txt_dt.setText(v.rs.getString(4));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	else if(str.equals("INSERT"))
	{
		String id = v.txt_nxb.getText();
		String ten = v.txt_ten.getText();
		String dc = v.txt_diachi.getText();
		String dt = v.txt_dt.getText();
		
		if(check_tontai(id))
		{
		  JOptionPane.showMessageDialog(null, "Mã đã tồn tại");
		  return;
		}
		insert(id, ten, dc, dt);
		v.hienthi();
		
	}
	else if(str.equals("DELETE"))
	{
		String id = v.txt_nxb.getText();
		if(!check_tontai(id))
		{
			JOptionPane.showMessageDialog(null, "Mã khong tồn tại");	
			return;
		}
		delete(id);
		v.hienthi();
	}
	else if(str.equals("EDIT"))
	{
		String id = v.txt_nxb.getText();
		String ten = v.txt_ten.getText();
		String dc = v.txt_diachi.getText();
		String dt = v.txt_dt.getText();
		if(!check_tontai(id))
		{
			JOptionPane.showMessageDialog(null, "Mã khong tồn tại");	
			return;
		}
	    int r = JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn sửa", "Thông báo", JOptionPane.YES_NO_OPTION);
	    if(r == JOptionPane.NO_OPTION)
	    {
	        return;	
	    }
	    update(id, ten, dc, dt);
	    v.hienthi();	
	}
	else if(str.equals("SAVE"))
	{
        
	}
	else if(str.equals("SEARCH"))
	{
		new search();
	}
}

}