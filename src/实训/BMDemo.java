package ʵѵ;

import java.sql.*;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import ʵѵ.MainDemo;

public class BMDemo extends JFrame {
	// ������Ϊ�գ������ͷ��ڴ��ʡ�ռ�
	Connection conn = null;
	// �´�selectָ���Բ�ѯ���ݿ�executeQuery()�����ݿ���Ӧ�Ĳ�ѯ��������ResultSet�����
	PreparedStatement ps = null;
	ResultSet res = null;
	// ��ʾ���ݿ�����
	JTable jtable;
	JScrollPane jscrollpane = new JScrollPane(); // �������

	JButton buttonask = new JButton("��ѯ");

	JLabel jldepartment = new JLabel("��      �ţ�");
	JLabel jldno = new JLabel("�� ��  �ţ�");

	Vector columnNames = null; // ������
	Vector rowData = null; // ������

	JTextField jtdno = new JTextField("", 20);
	JTextField jtdepartment = new JTextField("", 20);

	public BMDemo() {
		// ��������󲼾ֿؼ�������1��1�е�GridLayout����
		JPanel jpforbutton = new JPanel(new GridLayout(1, 1));

		JPanel jpdno = new JPanel();
		JPanel jpdepartment = new JPanel();

		jpdno.add(jldno);
		jpdno.add(jtdno);

		jpdepartment.add(jldepartment);
		jpdepartment.add(jtdepartment);

		jpforbutton.add(buttonask);
		// �������
		columnNames = new Vector();
		columnNames.add("��      �ţ�");
		columnNames.add("��      ����");
		columnNames.add("��      ��: ");
		columnNames.add("ְ      ��");
		columnNames.add("ְ��ȼ���");
		rowData = new Vector();

		buttonask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {// �׳��쳣
						// �������ݿ�
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					// �������ݿ�
					conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=yyy", "sa",
							"Xuyu2006@");
					ps = conn.prepareStatement("SELECT pno,pname,sex,dno,duty,rank FROM salary ");
					res = ps.executeQuery();
					while (res.next()) {
						String i = res.getString(4).trim();

						if (i.equals(jtdno.getText())) {
							// ���������
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
		// ��ʾ���ݿ�����
		jtable = new JTable(rowData, columnNames);
		jscrollpane = new JScrollPane(jtable);

		this.add(jscrollpane);
		this.setTitle("������Ϣ��");

		this.setLayout(new GridLayout(4, 1));

		this.add(jpdno);
		this.add(jpdepartment);
		this.add(jpforbutton);

		this.setLocation(300, 300); // λ��
		this.setSize(500, 300); // ��С
		this.setVisible(true); // ������
		this.setResizable(false); // �û��������ɸı����ɴ��ڵĴ�С

	}
}
