package 实训;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddDemo extends JFrame { // 继承JFrame类创建窗口
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
	JButton buttonadd = new JButton("添加");
	JButton buttonreturn = new JButton("返回");

	public AddDemo() {
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

		jpforbutton.add(buttonadd);
		jpforbutton.add(buttonreturn);
		// 创建事件监听器，添加监听事件
		buttonadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 先设置为空，方便释放内存节省空间
				Connection conn = null;
				PreparedStatement ps = null;
				// 获取文本区内容
				String xdno = jtdno.getText();
				String xdepart = jtdepartment.getText();
				String xduty = jtduty.getText();
				String xname = jtname.getText();
				String xpno = jtpno.getText();
				String xrank = jtrank.getText();
				String xsex = jtsex.getText();
				// 对数据库中staff表的操作
				String sql = "INSERT INTO staff(pno,name,sex,dno,department,duty,rank,experience) "
						+ "values(?,?,?,?,?,?,?,?)";
				// 对数据库中salary表的操作
				String sql3 = "INSERT INTO salary(pno,pname,sex,dno,department,duty,rank,salary) "
						+ "values(?,?,?,?,?,?,?,?)";
				try { // 抛出异常
						// 加载数据库
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					System.out.println("JBDC success!");
				} catch (Exception a) {
					System.out.println("JBDC failed!");
					a.printStackTrace();
				}
				try {
					// 连接数据库
					conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=yyy", "sa",
							"Xuyu2006@");
					// 获取执行SQL语句的prepareStatement对象
					ps = conn.prepareStatement(sql);
					// staff表中属性设置
					ps.setString(1, xpno);
					ps.setString(2, xname);
					ps.setString(3, xsex);
					ps.setString(4, xdno);
					ps.setString(5, xdepart);
					ps.setString(6, xduty);
					ps.setString(7, xrank);
					ps.setString(8, jtexperience.getText());

					ps.executeUpdate(); // 用于执行SQL语句(更新计数)
					int i = Integer.parseInt(xrank); // 等级String强制转换为Int类型
					ps = conn.prepareStatement(sql3);
					ps.setString(1, xpno);
					ps.setString(2, xname);
					ps.setString(3, xsex);
					ps.setString(4, xdno);
					ps.setString(5, xdepart);
					ps.setString(6, xduty);
					ps.setString(7, xrank);
					ps.setInt(8, i * 1000 + 5000); // 计算工资
					ps.executeUpdate(); // 用于执行SQL语句(更新计数)
				} catch (SQLException b) {
					System.out.println("1 ");
					b.printStackTrace();
				} finally {
					try {
						conn.close(); // 关闭数据库
						System.out.println("close success!");
					} catch (SQLException c) {
						System.out.println("close failed! ");
						c.printStackTrace();
					}
				}
			}
		});
		// 创建监听事件
		buttonreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.setTitle("添加员工信息");
		this.setLayout(new GridLayout(9, 1)); // 9行1列
		// 按键的属性添加
		this.add(jppno);
		this.add(jpname);
		this.add(jpsex);
		this.add(jpdno);
		this.add(jpdepartment);
		this.add(jpduty);
		this.add(jprank);
		this.add(jpexperience);
		this.add(jpforbutton);
		this.setLocation(400, 300); // 设置位置
		this.setSize(350, 300); // 设置大小
		this.setVisible(true); // 可运行
	}
}
