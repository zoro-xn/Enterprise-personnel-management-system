package 实训;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChangeDemo extends JFrame { // 继承JFrame类创建窗口

	// 标签组件设置标签
	JLabel jlpno = new JLabel("工      号：");
	JLabel jlname = new JLabel("姓      名：");
	JLabel jlsex = new JLabel("性      别：");
	JLabel jldepartment = new JLabel("部      门：");
	JLabel jldno = new JLabel("部 门  号：");
	JLabel jlduty = new JLabel("职      务：");
	JLabel jlrank = new JLabel("职务等级：");
	JLabel jlexperience = new JLabel("工作经验：");
	// 设置文本框大小(指定，列数)
	JTextField jtpno = new JTextField("", 20);
	JTextField jtname = new JTextField("", 20);
	JTextField jtsex = new JTextField("", 20);
	JTextField jtdepartment = new JTextField("", 20);
	JTextField jtdno = new JTextField("", 20);
	JTextField jtduty = new JTextField("", 20);
	JTextField jtrank = new JTextField("", 20);
	JTextField jtexperience = new JTextField("", 20);
	// 设置功能按键
	JButton buttonchange = new JButton("修改");
	JButton buttonreturn = new JButton("返回");

	public ChangeDemo() {
		// 设置面板组件
		JPanel jppno = new JPanel();
		JPanel jpname = new JPanel();
		JPanel jpsex = new JPanel();
		JPanel jpdno = new JPanel();
		JPanel jpdepartment = new JPanel();
		JPanel jpduty = new JPanel();
		JPanel jprank = new JPanel();
		JPanel jpexperience = new JPanel();
		// 用网格矩阵布局控件，创建1行1列的GridLayout对象
		JPanel jpforbutton = new JPanel(new GridLayout(1, 1));
		// 添加属性
		jppno.add(jlpno);
		jppno.add(jtpno);

		jpname.add(jlname);
		jpname.add(jtname);

		jpsex.add(jlsex);
		jpsex.add(jtsex);

		jpdepartment.add(jldepartment);
		jpdepartment.add(jtdepartment);

		jpdno.add(jldno);
		jpdno.add(jtdno);

		jpduty.add(jlduty);
		jpduty.add(jtduty);

		jprank.add(jlrank);
		jprank.add(jtrank);

		jpexperience.add(jlexperience);
		jpexperience.add(jtexperience);

		jpforbutton.add(buttonchange);
		jpforbutton.add(buttonreturn);
		// 创建事件监听器，添加监听事件
		buttonchange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 获取文本区内容
				String xdno = jtdno.getText();
				String xdepart = jtdepartment.getText();
				String xduty = jtduty.getText();
				String xname = jtname.getText();
				String xpno = jtpno.getText();
				String xrank = jtrank.getText();
				String xsex = jtsex.getText();
				String xexperience = jtexperience.getText();
				// 设置工资
				int num = Integer.parseInt(xrank) * 1000 + 5000;
				// 强制转换
				String xsalary = Integer.toString(num);
				// 先设置为空，方便释放内存节省空间
				Connection conn = null;
				// 下达select指令以查询数据库executeQuery()把数据库响应的查询结果存放在ResultSet类对象
				ResultSet res = null;
				Statement stat = null;
				// 对数据库中staff表的操作
				String sql = "SELECT pno,name,sex,dno,department,duty,rank,experience FROM staff;";
				try {// 抛出异常
						// 加载数据库
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

				} catch (Exception d) {
					System.out.println("jdbc failed!");
					d.printStackTrace();
				}
				try {
					// 连接数据库
					conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=yyy", "sa",
							"Xuyu2006@");
					stat = conn.createStatement(); // 获取执行SQL语句的prepareStatement对象
					res = stat.executeQuery(sql);
					while (res.next()) {
						String i = res.getString(1).trim(); // 去掉字符串两端的空格
						if (i.equals(jtpno.getText())) {
							// 对staff表的属性设置
							String sql2 = "UPDATE staff SET name='" + xname + "'  WHERE pno='" + jtpno.getText() + "'";
							String sql3 = "UPDATE staff SET sex='" + xsex + "'  WHERE pno='" + jtpno.getText() + "'";
							String sql4 = "UPDATE staff SET dno='" + xdno + "'  WHERE pno='" + jtpno.getText() + "'";
							String sql5 = "UPDATE staff SET department='" + xdepart + "'  WHERE pno='" + jtpno.getText()
									+ "'";
							String sql6 = "UPDATE staff SET duty='" + xduty + "'  WHERE pno='" + jtpno.getText() + "'";
							String sql7 = "UPDATE staff SET rank='" + xrank + "'  WHERE pno='" + jtpno.getText() + "'";
							String sql8 = "UPDATE staff SET experience='" + xexperience + "'  WHERE pno='"
									+ jtpno.getText() + "'";
							// 对salary表的属性设置
							String sql9 = "UPDATE salary SET pname='" + xname + "'  WHERE pno='" + jtpno.getText()
									+ "'";
							String sql10 = "UPDATE salary SET sex='" + xsex + "'  WHERE pno='" + jtpno.getText() + "'";
							String sql11 = "UPDATE salary SET dno='" + xdno + "'  WHERE pno='" + jtpno.getText() + "'";
							String sql12 = "UPDATE salary SET department='" + xdepart + "'  WHERE pno='"
									+ jtpno.getText() + "'";
							String sql13 = "UPDATE salary SET duty='" + xduty + "'  WHERE pno='" + jtpno.getText()
									+ "'";
							String sql14 = "UPDATE salary SET rank='" + xrank + "'  WHERE pno='" + jtpno.getText()
									+ "'";
							String sql15 = "UPDATE salary SET salary='" + xsalary + "'  WHERE pno='" + jtpno.getText()
									+ "'";

							stat = conn.createStatement(); // 获取执行SQL语句的prepareStatement对象
							// 更新staff表的操作
							stat.executeUpdate(sql2);
							stat.executeUpdate(sql3);
							stat.executeUpdate(sql4);
							stat.executeUpdate(sql5);
							stat.executeUpdate(sql6);
							stat.executeUpdate(sql7);
							stat.executeUpdate(sql8);
							// 更新salary表的操作
							stat.executeUpdate(sql9);
							stat.executeUpdate(sql10);
							stat.executeUpdate(sql11);
							stat.executeUpdate(sql12);
							stat.executeUpdate(sql13);
							stat.executeUpdate(sql14);
							stat.executeUpdate(sql15);
							try {
								stat.close(); // 用于JDBC连接数据库关闭资源
								conn.close(); // 关闭数据库
							} catch (SQLException ar) {
								ar.printStackTrace();
							}
							break;
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				} finally {
					try {
						conn.close();
					} catch (SQLException ar) {
						ar.printStackTrace();
					}
				}
			}
		});
		// 创建监听事件
		buttonreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.setTitle("修改员工信息");
		this.setLayout(new GridLayout(9, 1)); // 9行1列
		// 按键添加
		this.add(jppno);
		this.add(jpname);
		this.add(jpsex);
		this.add(jpdno);
		this.add(jpdepartment);
		this.add(jpduty);
		this.add(jprank);
		this.add(jpexperience);
		this.add(jpforbutton);
		this.setLocation(400, 300); // 位置
		this.setSize(350, 300); // 大小
		this.setVisible(true); // 可运行
	}
}
