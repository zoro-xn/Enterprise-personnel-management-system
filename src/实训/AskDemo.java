package 实训;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import 实训.MainDemo;

public class AskDemo extends JFrame { // 继承JFrame类创建窗口

	// 标签组件设置标签
	JLabel jlpno = new JLabel("工      号：");
	JLabel jlname = new JLabel("姓      名：");
	JLabel jlsex = new JLabel("性      别：");
	JLabel jldepartment = new JLabel("部      门：");
	JLabel jldno = new JLabel("部 门  号：");
	JLabel jlduty = new JLabel("职      务：");
	JLabel jlrank = new JLabel("职务等级：");
	JLabel jlsalary = new JLabel("工      资：");
	// 工号(通过工号查询)
	JTextField jtpno = new JTextField("", 20);
	// 其他属性设置为初始状态
	JLabel jname = new JLabel();
	JLabel jsex = new JLabel();
	JLabel jdepartment = new JLabel();
	JLabel jdno = new JLabel();
	JLabel jduty = new JLabel();
	JLabel jrank = new JLabel();
	JLabel jsalary = new JLabel();

	JButton buttonask = new JButton("查询");
	JButton buttonreturn = new JButton("返回");

	public AskDemo() {
		// 设置面板组件
		JPanel jppno = new JPanel();
		JPanel jpname = new JPanel();
		JPanel jpsex = new JPanel();
		JPanel jpdno = new JPanel();
		JPanel jpdepartment = new JPanel();
		JPanel jpduty = new JPanel();
		JPanel jprank = new JPanel();
		JPanel jpsalary = new JPanel();
		// 用网格矩阵布局控件，创建1行1列的GridLayout对象
		JPanel jpforbutton = new JPanel(new GridLayout(1, 1));
		// 添加属性
		jppno.add(jlpno);
		jppno.add(jtpno);

		jpname.add(jlname);
		jpname.add(jname);

		jpsex.add(jlsex);
		jpsex.add(jsex);

		jpdno.add(jldepartment);
		jpdno.add(jdepartment);

		jpdepartment.add(jldno);
		jpdepartment.add(jdno);

		jpduty.add(jlduty);
		jpduty.add(jduty);

		jprank.add(jlrank);
		jprank.add(jrank);

		jpsalary.add(jlsalary);
		jpsalary.add(jsalary);

		jpforbutton.add(buttonask);
		jpforbutton.add(buttonreturn);

		// 创建事件监听器，添加监听事件
		buttonask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 先设置为空，方便释放内存节省空间
				Connection conn = null;
				// 下达select指令以查询数据库executeQuery()把数据库响应的查询结果存放在ResultSet类对象
				ResultSet res = null;
				Statement stat = null;
				// 对数据库中salary表的操作
				String sql = "SELECT pno,pname,sex,dno,department,duty,rank,salary FROM salary;";
				try {// 抛出异常
						// 加载数据库
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					System.out.println("jdbc success!");
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
						if (i.equals(jtpno.getText())) // 与查询的工号相同
						{
							// 其他属性显示出来
							jname.setText(res.getString(2));
							jsex.setText(res.getString(3));
							jdno.setText(res.getString(4));
							jdepartment.setText(res.getString(5));
							jduty.setText(res.getString(6));
							jrank.setText(res.getString(7));
							jsalary.setText(res.getString(8));
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
		}

		);
		// 创建监听事件
		buttonreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.setTitle("员工工资条");
		this.setLayout(new GridLayout(9, 1)); // 9行1列
		// 按键添加
		this.add(jppno);
		this.add(jpname);
		this.add(jpsex);
		this.add(jpdno);
		this.add(jpdepartment);
		this.add(jpduty);
		this.add(jprank);
		this.add(jpsalary);
		this.add(jpforbutton);
		this.setLocation(400, 300); // 位置
		this.setSize(350, 300); // 大小
		this.setVisible(true); // 可运行

	}

}
