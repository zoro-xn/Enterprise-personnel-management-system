package ʵѵ;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChangeDemo extends JFrame { // �̳�JFrame�ഴ������

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
	JButton buttonchange = new JButton("�޸�");
	JButton buttonreturn = new JButton("����");

	public ChangeDemo() {
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

		jpforbutton.add(buttonchange);
		jpforbutton.add(buttonreturn);
		// �����¼�����������Ӽ����¼�
		buttonchange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ��ȡ�ı�������
				String xdno = jtdno.getText();
				String xdepart = jtdepartment.getText();
				String xduty = jtduty.getText();
				String xname = jtname.getText();
				String xpno = jtpno.getText();
				String xrank = jtrank.getText();
				String xsex = jtsex.getText();
				String xexperience = jtexperience.getText();
				// ���ù���
				int num = Integer.parseInt(xrank) * 1000 + 5000;
				// ǿ��ת��
				String xsalary = Integer.toString(num);
				// ������Ϊ�գ������ͷ��ڴ��ʡ�ռ�
				Connection conn = null;
				// �´�selectָ���Բ�ѯ���ݿ�executeQuery()�����ݿ���Ӧ�Ĳ�ѯ��������ResultSet�����
				ResultSet res = null;
				Statement stat = null;
				// �����ݿ���staff��Ĳ���
				String sql = "SELECT pno,name,sex,dno,department,duty,rank,experience FROM staff;";
				try {// �׳��쳣
						// �������ݿ�
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

				} catch (Exception d) {
					System.out.println("jdbc failed!");
					d.printStackTrace();
				}
				try {
					// �������ݿ�
					conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=yyy", "sa",
							"Xuyu2006@");
					stat = conn.createStatement(); // ��ȡִ��SQL����prepareStatement����
					res = stat.executeQuery(sql);
					while (res.next()) {
						String i = res.getString(1).trim(); // ȥ���ַ������˵Ŀո�
						if (i.equals(jtpno.getText())) {
							// ��staff�����������
							String sql2 = "UPDATE staff SET name='" + xname + "'  WHERE pno='" + jtpno.getText() + "'";
							String sql3 = "UPDATE staff SET sex='" + xsex + "'  WHERE pno='" + jtpno.getText() + "'";
							String sql4 = "UPDATE staff SET dno='" + xdno + "'  WHERE pno='" + jtpno.getText() + "'";
							String sql5 = "UPDATE staff SET department='" + xdepart + "'  WHERE pno='" + jtpno.getText()
									+ "'";
							String sql6 = "UPDATE staff SET duty='" + xduty + "'  WHERE pno='" + jtpno.getText() + "'";
							String sql7 = "UPDATE staff SET rank='" + xrank + "'  WHERE pno='" + jtpno.getText() + "'";
							String sql8 = "UPDATE staff SET experience='" + xexperience + "'  WHERE pno='"
									+ jtpno.getText() + "'";
							// ��salary�����������
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

							stat = conn.createStatement(); // ��ȡִ��SQL����prepareStatement����
							// ����staff��Ĳ���
							stat.executeUpdate(sql2);
							stat.executeUpdate(sql3);
							stat.executeUpdate(sql4);
							stat.executeUpdate(sql5);
							stat.executeUpdate(sql6);
							stat.executeUpdate(sql7);
							stat.executeUpdate(sql8);
							// ����salary��Ĳ���
							stat.executeUpdate(sql9);
							stat.executeUpdate(sql10);
							stat.executeUpdate(sql11);
							stat.executeUpdate(sql12);
							stat.executeUpdate(sql13);
							stat.executeUpdate(sql14);
							stat.executeUpdate(sql15);
							try {
								stat.close(); // ����JDBC�������ݿ�ر���Դ
								conn.close(); // �ر����ݿ�
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
		// ���������¼�
		buttonreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.setTitle("�޸�Ա����Ϣ");
		this.setLayout(new GridLayout(9, 1)); // 9��1��
		// �������
		this.add(jppno);
		this.add(jpname);
		this.add(jpsex);
		this.add(jpdno);
		this.add(jpdepartment);
		this.add(jpduty);
		this.add(jprank);
		this.add(jpexperience);
		this.add(jpforbutton);
		this.setLocation(400, 300); // λ��
		this.setSize(350, 300); // ��С
		this.setVisible(true); // ������
	}
}
