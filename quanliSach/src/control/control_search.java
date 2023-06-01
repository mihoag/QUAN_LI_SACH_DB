package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import JDBCUtil.JDBCUtil;
import quanliSach.search;

public class control_search implements ActionListener {

	private search s;
	public control_search(search s)
	{
		this.s = s;
	}
	public void timkiem(String a) throws SQLException
	{
		Connection c = JDBCUtil.getConnection();
		String sql = "select * from sach where tensach like N'%"+ a+"%'";
		Statement st = c.createStatement();
		ResultSet r = st.executeQuery(sql);
	    s.tb.setRowCount(0);
		while(r.next())
		{
			System.out.println(r.getString(1));
			String[] arr = {r.getString(1), r.getString(2),r.getString(3)};
			s.tb.addRow(arr);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = e.getActionCommand();
		if(str.equals("search"))
		{
		 String a = s.textField.getText();
		 try {
			 System.out.println(a);
			timkiem(a);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		
	}

}
