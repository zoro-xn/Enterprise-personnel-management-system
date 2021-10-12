package ʵѵ;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class LookDemo extends JFrame { // �̳�JFrame�ഴ������

	// ������Ϊ�գ������ͷ��ڴ��ʡ�ռ�
	Connection conn = null;
	PreparedStatement ps = null;
	// �´�selectָ���Բ�ѯ���ݿ�executeQuery()�����ݿ���Ӧ�Ĳ�ѯ��������ResultSet�����
	ResultSet res = null;
	JTable jtable; // ��ʾ���ݿ�����
	JScrollPane jscrollpane = new JScrollPane(); // �������

	Vector columnNames = null; // ������
	Vector rowData = null; // ������

	public LookDemo() {
		// ��������󲼾ֿؼ�������1��1�е�GridLayout����
		JPanel jpforbutton = new JPanel(new GridLayout(1, 1));
		// �������
		columnNames = new Vector();
		columnNames.add("��      �ţ�");
		columnNames.add("��      ����");
		columnNames.add("��      ��: ");
		columnNames.add("�� �� �ţ�");
		columnNames.add("��      ��  ��");
		columnNames.add("ְ      ��");
		columnNames.add("ְ��ȼ���");
		columnNames.add("��      �ʣ�");
		rowData = new Vector();

		try {
			// �׳��쳣
			// �������ݿ�
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// �������ݿ�
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=yyy", "sa", "Xuyu2006@");
			ps = conn.prepareStatement("SELECT * FROM salary");
			res = ps.executeQuery();
			while (res.next()) {
				// ���������
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
		// ��ʾ���ݿ�����
		jtable = new JTable(rowData, columnNames);
		jscrollpane = new JScrollPane(jtable);

		this.add(jscrollpane);
		this.setTitle("Ա����Ϣ��");
		// 2��5��
		this.setLayout(new GridLayout(2, 5));
		this.add(jpforbutton);
		this.setLocation(300, 300); // λ��
		this.setSize(500, 300); // ��С
		this.setVisible(true); // ������
		this.setResizable(false); // �û��������ɸı����ɴ��ڵĴ�С
	}

}
