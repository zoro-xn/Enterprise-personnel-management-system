package 实训;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DeleteDemo extends JFrame { // 继承JFrame类创建窗口

	// 通过查询工号进行删除信息
	JLabel jlpno = new JLabel("工      号：");

	JTextField jtpno = new JTextField("", 20);

	JButton buttondelete = new JButton("删除");
	JButton buttonreturn = new JButton("返回");

	public DeleteDemo() {
		// 设置panel控件
		JPanel jpnumber = new JPanel();
		// 用网格矩阵布局控件，创建1行1列的GridLayout对象
		JPanel jpforbutton = new JPanel(new GridLayout(1, 1));

		jpnumber.add(jlpno);
		jpnumber.add(jtpno);

		jpforbutton.add(buttondelete);
		jpforbutton.add(buttonreturn);
		// 创建监听事件
		buttondelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pno = jtpno.getText();
				// 先设置为空，方便释放内存节省空间
				Connection conn = null;
				// 下达select指令以查询数据库executeQuery()把数据库响应的查询结果存放在ResultSet类对象
				ResultSet res = null;
				Statement stat = null;
				String sql = "DELETE FROM salary WHERE pno='" + pno + "'";
				String sql2 = "DELETE FROM staff WHERE pno='" + pno + "'";
				try {// 抛出异常
						// 加载数据库
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (Exception a) {
					a.printStackTrace();
				}
				try {// 连接数据库
					conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=yyy", "sa",
							"Xuyu2006@");
					stat = conn.createStatement();
					stat.executeUpdate(sql);
					stat.executeUpdate(sql2);
				} catch (SQLException h) {
					h.printStackTrace();
				} finally {
					try {
						conn.close();
						System.out.println("close success!");
					} catch (SQLException j) {
						System.out.println("close failed!");
						j.printStackTrace();
					}
				}
			}
		});
		// 创建监听事件
		buttonreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.setTitle("删除员工信息");
		this.setLayout(new GridLayout(9, 1)); // 9行1列
		// 按键添加
		this.add(jpnumber);
		this.add(jpforbutton);
		this.setLocation(400, 300); // 位置
		this.setSize(350, 300); // 大小
		this.setVisible(true); // 可运行
	}

}
