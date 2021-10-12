package 实训;

import java.sql.*;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import 实训.MainDemo;

public class BMDemo extends JFrame {
	// 先设置为空，方便释放内存节省空间
	Connection conn = null;
	// 下达select指令以查询数据库executeQuery()把数据库响应的查询结果存放在ResultSet类对象
	PreparedStatement ps = null;
	ResultSet res = null;
	// 显示数据库数据
	JTable jtable;
	JScrollPane jscrollpane = new JScrollPane(); // 滚动面板

	JButton buttonask = new JButton("查询");

	JLabel jldepartment = new JLabel("部      门：");
	JLabel jldno = new JLabel("部 门  号：");

	Vector columnNames = null; // 列名称
	Vector rowData = null; // 行数据

	JTextField jtdno = new JTextField("", 20);
	JTextField jtdepartment = new JTextField("", 20);

	public BMDemo() {
		// 用网格矩阵布局控件，创建1行1列的GridLayout对象
		JPanel jpforbutton = new JPanel(new GridLayout(1, 1));

		JPanel jpdno = new JPanel();
		JPanel jpdepartment = new JPanel();

		jpdno.add(jldno);
		jpdno.add(jtdno);

		jpdepartment.add(jldepartment);
		jpdepartment.add(jtdepartment);

		jpforbutton.add(buttonask);
		// 添加列名
		columnNames = new Vector();
		columnNames.add("工      号：");
		columnNames.add("姓      名：");
		columnNames.add("性      别: ");
		columnNames.add("职      务：");
		columnNames.add("职务等级：");
		rowData = new Vector();

		buttonask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {// 抛出异常
						// 加载数据库
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					// 连接数据库
					conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=yyy", "sa",
							"Xuyu2006@");
					ps = conn.prepareStatement("SELECT pno,pname,sex,dno,duty,rank FROM salary ");
					res = ps.executeQuery();
					while (res.next()) {
						String i = res.getString(4).trim();

						if (i.equals(jtdno.getText())) {
							// 添加行数据
							Vector hang = new Vector();
							hang.add(res.getString(1));
							hang.add(res.getString(2));
							hang.add(res.getString(3));
							hang.add(res.getString(5));
							hang.add(res.getString(6));
							rowData.add(hang);

						}
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
					} catch (SQLException ar) {
						ar.printStackTrace();
					}
				}
			}
		});
		// 显示数据库数据
		jtable = new JTable(rowData, columnNames);
		jscrollpane = new JScrollPane(jtable);

		this.add(jscrollpane);
		this.setTitle("部门信息表");

		this.setLayout(new GridLayout(4, 1));

		this.add(jpdno);
		this.add(jpdepartment);
		this.add(jpforbutton);

		this.setLocation(300, 300); // 位置
		this.setSize(500, 300); // 大小
		this.setVisible(true); // 可运行
		this.setResizable(false); // 用户不可自由改变生成窗口的大小

	}
}
