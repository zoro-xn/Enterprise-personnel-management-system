package 实训;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainDemo {
	public static void main(String[] args) {
		JFrame jframe = new JFrame("企业人事管理系统"); // 使用JFrame类创建窗口，同时设置窗口标题
		Dimension d = new Dimension(300, 400); // 封装构件的高度和宽度
		Point p = new Point(250, 350); // 直角坐标系中的点
		jframe.setSize(d); // 大小
		jframe.setLocation(p); // 位置
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置用户在此窗体上发起“close”时默认执行的操作
		jframe.setVisible(true); // 可运行
		// 设置功能按键
		JButton button1 = new JButton("添加");
		JButton button2 = new JButton("修改");
		JButton button3 = new JButton("查询");
		JButton button4 = new JButton("删除");
		JButton button5 = new JButton("浏览");
		JButton button6 = new JButton("部门");
		// 流式布局，对齐方式从左到右排列
		FlowLayout flow = new FlowLayout(FlowLayout.LEFT, 20, 30);
		JPanel panel = new JPanel(flow); // 构建一个面板
		panel.setSize(300, 400); // 设置面板大小
		panel.setBackground(Color.darkGray); // 设置背景色
		// 将按键添加到面板中
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		// 获取内容面板添加内容
		jframe.getContentPane().add(panel);
		// 创建事件监听器，为6个对象创建监听事件
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
