package 实训;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class LookDemo extends JFrame { // 继承JFrame类创建窗口

	// 先设置为空，方便释放内存节省空间
	Connection conn = null;
	PreparedStatement ps = null;
	// 下达select指令以查询数据库executeQuery()把数据库响应的查询结果存放在ResultSet类对象
	ResultSet res = null;
	JTable jtable; // 显示数据库数据
	JScrollPane jscrollpane = new JScrollPane(); // 滚动面板

	Vector columnNames = null; // 列名称
	Vector rowData = null; // 行数据

	public LookDemo() {
		// 用网格矩阵布局控件，创建1行1列的GridLayout对象
		JPanel jpforbutton = new JPanel(new GridLayout(1, 1));
		// 添加列名
		columnNames = new Vector();
		columnNames.add("工      号：");
		columnNames.add("姓      名：");
		columnNames.add("性      别: ");
		columnNames.add("部 门 号：");
		columnNames.add("部      门  ：");
		columnNames.add("职      务：");
		columnNames.add("职务等级：");
		columnNames.add("工      资：");
		rowData = new Vector();

		try {
			// 抛出异常
			// 加载数据库
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 连接数据库
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=yyy", "sa", "Xuyu2006@");
			ps = conn.prepareStatement("SELECT * FROM salary");
			res = ps.executeQuery();
			while (res.next()) {
				// 添加行数据
				Vector hang = new Vector();
				hang.add(res.getString(1));
				hang.add(res.getString(2));
				hang.add(res.getString(3));
				hang.add(res.getString(4));
				hang.add(res.getString(5));
				hang.add(res.getString(6));
				hang.add(res.getString(7));
				hang.add(res.getString(8));
				rowData.add(hang);

			}
			System.out.println("load  success!");
		} catch (Exception q) {
			q.printStackTrace();
			System.out.println("load failed!");
		} finally {
			try {

				res.close();
				ps.close();
				conn.close();

				System.out.println("close success!");
			} catch (SQLException o) {
				o.printStackTrace();
				System.out.println("close failed!");
			}
		}
		// 显示数据库数据
		jtable = new JTable(rowData, columnNames);
		jscrollpane = new JScrollPane(jtable);

		this.add(jscrollpane);
		this.setTitle("员工信息表");
		// 2行5列
		this.setLayout(new GridLayout(2, 5));
		this.add(jpforbutton);
		this.setLocation(300, 300); // 位置
		this.setSize(500, 300); // 大小
		this.setVisible(true); // 可运行
		this.setResizable(false); // 用户不可自由改变生成窗口的大小
	}

}
