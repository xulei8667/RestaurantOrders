package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Admin.AddItem;
import Admin.CheckItem;
import Admin.DeleteItem;

public class AdminWindow extends JFrame {
	ImageIcon image;

	public AdminWindow() {
		image = new ImageIcon(".//files//images//AdminWindow.jpg");
		image.setImage(image.getImage().getScaledInstance(800, 750, Image.SCALE_DEFAULT));
		this.setTitle("网上订餐系统（管理员版）");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(200, 200, 1000, 800);
		this.setVisible(true);
		addImage();
		addButton();
	}

	private void addImage() {
		JLabel label = new JLabel(image);
		label.setBounds(200, 0, 800, 750);
		this.add(label);
	}

	private void addButton() {
		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1, 20, 20));
		JButton button1 = new JButton("查看菜品");
		JButton button2 = new JButton("添加菜品");
		JButton button3 = new JButton("删除菜品");
		JButton button4 = new JButton("退出系统");
		button1.setFont(new Font("华文彩云", Font.BOLD, 36));
		button2.setFont(new Font("华文彩云", Font.BOLD, 36));
		button3.setFont(new Font("华文彩云", Font.BOLD, 36));
		button4.setFont(new Font("华文琥珀", Font.BOLD, 36));
		panel.setPreferredSize(new Dimension(200, 0));
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		this.getContentPane().add(panel, BorderLayout.WEST);

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminWindow.this.setVisible(false);
				new CheckItem(0);
			}
		});

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminWindow.this.setVisible(false);
				new AddItem();
			}
		});

		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminWindow.this.setVisible(false);
				new DeleteItem();
			}
		});

		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "确定退出系统？", "温馨提示", JOptionPane.YES_NO_OPTION);
				if (i == 0)
					System.exit(0);
			}
		});
	}
}