package ʵѵ;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DeleteDemo extends JFrame { // �̳�JFrame�ഴ������

	// ͨ����ѯ���Ž���ɾ����Ϣ
	JLabel jlpno = new JLabel("��      �ţ�");

	JTextField jtpno = new JTextField("", 20);

	JButton buttondelete = new JButton("ɾ��");
	JButton buttonreturn = new JButton("����");

	public DeleteDemo() {
		// ����panel�ؼ�
		JPanel jpnumber = new JPanel();
		// ��������󲼾ֿؼ�������1��1�е�GridLayout����
		JPanel jpforbutton = new JPanel(new GridLayout(1, 1));

		jpnumber.add(jlpno);
		jpnumber.add(jtpno);

		jpforbutton.add(buttondelete);
		jpforbutton.add(buttonreturn);
		// ���������¼�
		buttondelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pno = jtpno.getText();
				// ������Ϊ�գ������ͷ��ڴ��ʡ�ռ�
				Connection conn = null;
				// �´�selectָ���Բ�ѯ���ݿ�executeQuery()�����ݿ���Ӧ�Ĳ�ѯ��������ResultSet�����
				ResultSet res = null;
				Statement stat = null;
				String sql = "DELETE FROM salary WHERE pno='" + pno + "'";
				String sql2 = "DELETE FROM staff WHERE pno='" + pno + "'";
				try {// �׳��쳣
						// �������ݿ�
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (Exception a) {
					a.printStackTrace();
				}
				try {// �������ݿ�
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
		// ���������¼�
		buttonreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.setTitle("ɾ��Ա����Ϣ");
		this.setLayout(new GridLayout(9, 1)); // 9��1��
		// �������
		this.add(jpnumber);
		this.add(jpforbutton);
		this.setLocation(400, 300); // λ��
		this.setSize(350, 300); // ��С
		this.setVisible(true); // ������
	}

}
