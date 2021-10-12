package ʵѵ;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddDemo extends JFrame { // �̳�JFrame�ഴ������
	// ��ǩ������ñ�ǩ
	JLabel jlpno = new JLabel("��      �ţ�");
	JLabel jlname = new JLabel("��      ����");
	JLabel jlsex = new JLabel("��      ��");
	JLabel jldepartment = new JLabel("��      �ţ�");
	JLabel jldno = new JLabel("�� ��  �ţ�");
	JLabel jlduty = new JLabel("ְ      ��");
	JLabel jlrank = new JLabel("ְ��ȼ���");
	JLabel jlexperience = new JLabel("�������飺");
	// �����ı����С(ָ��������)
	JTextField jtpno = new JTextField("", 20);
	JTextField jtname = new JTextField("", 20);
	JTextField jtsex = new JTextField("", 20);
	JTextField jtdepartment = new JTextField("", 20);
	JTextField jtdno = new JTextField("", 20);
	JTextField jtduty = new JTextField("", 20);
	JTextField jtrank = new JTextField("", 20);
	JTextField jtexperience = new JTextField("", 20);
	// ���ù��ܰ���
	JButton buttonadd = new JButton("���");
	JButton buttonreturn = new JButton("����");

	public AddDemo() {
		// ����������
		JPanel jppno = new JPanel();
		JPanel jpname = new JPanel();
		JPanel jpsex = new JPanel();
		JPanel jpdno = new JPanel();
		JPanel jpdepartment = new JPanel();
		JPanel jpduty = new JPanel();
		JPanel jprank = new JPanel();
		JPanel jpexperience = new JPanel();
		// ��������󲼾ֿؼ�������1��1�е�GridLayout����
		JPanel jpforbutton = new JPanel(new GridLayout(1, 1));
		// �������
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
		// �����¼�����������Ӽ����¼�
		buttonadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ������Ϊ�գ������ͷ��ڴ��ʡ�ռ�
				Connection conn = null;
				PreparedStatement ps = null;
				// ��ȡ�ı�������
				String xdno = jtdno.getText();
				String xdepart = jtdepartment.getText();
				String xduty = jtduty.getText();
				String xname = jtname.getText();
				String xpno = jtpno.getText();
				String xrank = jtrank.getText();
				String xsex = jtsex.getText();
				// �����ݿ���staff��Ĳ���
				String sql = "INSERT INTO staff(pno,name,sex,dno,department,duty,rank,experience) "
						+ "values(?,?,?,?,?,?,?,?)";
				// �����ݿ���salary��Ĳ���
				String sql3 = "INSERT INTO salary(pno,pname,sex,dno,department,duty,rank,salary) "
						+ "values(?,?,?,?,?,?,?,?)";
				try { // �׳��쳣
						// �������ݿ�
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					System.out.println("JBDC success!");
				} catch (Exception a) {
					System.out.println("JBDC failed!");
					a.printStackTrace();
				}
				try {
					// �������ݿ�
					conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=yyy", "sa",
							"Xuyu2006@");
					// ��ȡִ��SQL����prepareStatement����
					ps = conn.prepareStatement(sql);
					// staff������������
					ps.setString(1, xpno);
					ps.setString(2, xname);
					ps.setString(3, xsex);
					ps.setString(4, xdno);
					ps.setString(5, xdepart);
					ps.setString(6, xduty);
					ps.setString(7, xrank);
					ps.setString(8, jtexperience.getText());

					ps.executeUpdate(); // ����ִ��SQL���(���¼���)
					int i = Integer.parseInt(xrank); // �ȼ�Stringǿ��ת��ΪInt����
					ps = conn.prepareStatement(sql3);
					ps.setString(1, xpno);
					ps.setString(2, xname);
					ps.setString(3, xsex);
					ps.setString(4, xdno);
					ps.setString(5, xdepart);
					ps.setString(6, xduty);
					ps.setString(7, xrank);
					ps.setInt(8, i * 1000 + 5000); // ���㹤��
					ps.executeUpdate(); // ����ִ��SQL���(���¼���)
				} catch (SQLException b) {
					System.out.println("1 ");
					b.printStackTrace();
				} finally {
					try {
						conn.close(); // �ر����ݿ�
						System.out.println("close success!");
					} catch (SQLException c) {
						System.out.println("close failed! ");
						c.printStackTrace();
					}
				}
			}
		});
		// ���������¼�
		buttonreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.setTitle("���Ա����Ϣ");
		this.setLayout(new GridLayout(9, 1)); // 9��1��
		// �������������
		this.add(jppno);
		this.add(jpname);
		this.add(jpsex);
		this.add(jpdno);
		this.add(jpdepartment);
		this.add(jpduty);
		this.add(jprank);
		this.add(jpexperience);
		this.add(jpforbutton);
		this.setLocation(400, 300); // ����λ��
		this.setSize(350, 300); // ���ô�С
		this.setVisible(true); // ������
	}
}
