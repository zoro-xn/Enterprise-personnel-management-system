package ʵѵ;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainDemo {
	public static void main(String[] args) {
		JFrame jframe = new JFrame("��ҵ���¹���ϵͳ"); // ʹ��JFrame�ഴ�����ڣ�ͬʱ���ô��ڱ���
		Dimension d = new Dimension(300, 400); // ��װ�����ĸ߶ȺͿ��
		Point p = new Point(250, 350); // ֱ������ϵ�еĵ�
		jframe.setSize(d); // ��С
		jframe.setLocation(p); // λ��
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �����û��ڴ˴����Ϸ���close��ʱĬ��ִ�еĲ���
		jframe.setVisible(true); // ������
		// ���ù��ܰ���
		JButton button1 = new JButton("���");
		JButton button2 = new JButton("�޸�");
		JButton button3 = new JButton("��ѯ");
		JButton button4 = new JButton("ɾ��");
		JButton button5 = new JButton("���");
		JButton button6 = new JButton("����");
		// ��ʽ���֣����뷽ʽ����������
		FlowLayout flow = new FlowLayout(FlowLayout.LEFT, 20, 30);
		JPanel panel = new JPanel(flow); // ����һ�����
		panel.setSize(300, 400); // ��������С
		panel.setBackground(Color.darkGray); // ���ñ���ɫ
		// ��������ӵ������
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		// ��ȡ��������������
		jframe.getContentPane().add(panel);
		// �����¼���������Ϊ6�����󴴽������¼�
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDemo add = new AddDemo();
			}
		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeDemo change = new ChangeDemo();
			}
		});
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AskDemo ask = new AskDemo();
			}
		});
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteDemo delete = new DeleteDemo();
			}
		});
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LookDemo look = new LookDemo();
			}
		});
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BMDemo db = new BMDemo();
			}
		});
	}

}
