package ʵѵ;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import ʵѵ.MainDemo;

public class AskDemo extends JFrame { // �̳�JFrame�ഴ������

	// ��ǩ������ñ�ǩ
	JLabel jlpno = new JLabel("��      �ţ�");
	JLabel jlname = new JLabel("��      ����");
	JLabel jlsex = new JLabel("��      ��");
	JLabel jldepartment = new JLabel("��      �ţ�");
	JLabel jldno = new JLabel("�� ��  �ţ�");
	JLabel jlduty = new JLabel("ְ      ��");
	JLabel jlrank = new JLabel("ְ��ȼ���");
	JLabel jlsalary = new JLabel("��      �ʣ�");
	// ����(ͨ�����Ų�ѯ)
	JTextField jtpno = new JTextField("", 20);
	// ������������Ϊ��ʼ״̬
	JLabel jname = new JLabel();
	JLabel jsex = new JLabel();
	JLabel jdepartment = new JLabel();
	JLabel jdno = new JLabel();
	JLabel jduty = new JLabel();
	JLabel jrank = new JLabel();
	JLabel jsalary = new JLabel();

	JButton buttonask = new JButton("��ѯ");
	JButton buttonreturn = new JButton("����");

	public AskDemo() {
		// ����������
		JPanel jppno = new JPanel();
		JPanel jpname = new JPanel();
		JPanel jpsex = new JPanel();
		JPanel jpdno = new JPanel();
		JPanel jpdepartment = new JPanel();
		JPanel jpduty = new JPanel();
		JPanel jprank = new JPanel();
		JPanel jpsalary = new JPanel();
		// ��������󲼾ֿؼ�������1��1�е�GridLayout����
		JPanel jpforbutton = new JPanel(new GridLayout(1, 1));
		// �������
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

		// �����¼�����������Ӽ����¼�
		buttonask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ������Ϊ�գ������ͷ��ڴ��ʡ�ռ�
				Connection conn = null;
				// �´�selectָ���Բ�ѯ���ݿ�executeQuery()�����ݿ���Ӧ�Ĳ�ѯ��������ResultSet�����
				ResultSet res = null;
				Statement stat = null;
				// �����ݿ���salary��Ĳ���
				String sql = "SELECT pno,pname,sex,dno,department,duty,rank,salary FROM salary;";
				try {// �׳��쳣
						// �������ݿ�
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					System.out.println("jdbc success!");
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
						if (i.equals(jtpno.getText())) // ���ѯ�Ĺ�����ͬ
						{
							// ����������ʾ����
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
		// ���������¼�
		buttonreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.setTitle("Ա��������");
		this.setLayout(new GridLayout(9, 1)); // 9��1��
		// �������
		this.add(jppno);
		this.add(jpname);
		this.add(jpsex);
		this.add(jpdno);
		this.add(jpdepartment);
		this.add(jpduty);
		this.add(jprank);
		this.add(jpsalary);
		this.add(jpforbutton);
		this.setLocation(400, 300); // λ��
		this.setSize(350, 300); // ��С
		this.setVisible(true); // ������

	}

}
