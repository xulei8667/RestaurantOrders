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

public class Welcome extends JFrame {
	ImageIcon image;
	
	public Welcome() {
		image = new ImageIcon(".//files//images//Welcome.jpg");
		image.setImage(image.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT));
		this.setTitle("网上订餐系统");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(200, 200, 900, 750);
		this.setVisible(true);
		addImage();
		addButton();
	}

	private void addImage() {
		JLabel label = new JLabel(image);
		label.setBounds(0, 0, 900, 600);
		this.add(label);
	}

	private void addButton() {
		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 3, 0, 0));
		JButton button1 = new JButton("我是用户");
		JButton button2 = new JButton("我是管理员");
		JButton button3 = new JButton("退出系统");
		button1.setFont(new Font("华文行楷", Font.BOLD, 36));
		button2.setFont(new Font("华文行楷", Font.BOLD, 36));
		button3.setFont(new Font("华文行楷", Font.BOLD, 36));
		panel.setPreferredSize(new Dimension(0, 100));
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		this.getContentPane().add(panel, BorderLayout.SOUTH);

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Welcome.this.setVisible(false);
				new UsersLogin();
			}
		});

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Welcome.this.setVisible(false);
				new AdminLogin();
			}
		});

		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "确定退出系统？", "温馨提示", JOptionPane.YES_NO_OPTION);
				if (i == 0)
					System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new Welcome();
	}
}