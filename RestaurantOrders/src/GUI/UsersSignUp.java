package GUI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UsersSignUp extends JFrame {
	private JTextField username;
	private JPasswordField password1;
	private JPasswordField password2;

	public UsersSignUp() {
		this.setTitle("用户注册");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(200, 200, 320, 400);
		this.setVisible(true);
		addLabel();
		addUsername();
		addPassword();
		addButton();
	}

	private void addLabel() {
		this.setLayout(null);
		JLabel label1 = new JLabel("用户名");
		JLabel label2 = new JLabel("密码");
		JLabel label3 = new JLabel("确认密码");
		label1.setFont(new Font("仿宋", Font.BOLD, 16));
		label2.setFont(new Font("仿宋", Font.BOLD, 16));
		label3.setFont(new Font("仿宋", Font.BOLD, 16));
		label1.setBounds(20, 80, 80, 20);
		label2.setBounds(20, 130, 80, 20);
		label3.setBounds(20, 180, 80, 20);
		this.add(label1);
		this.add(label2);
		this.add(label3);
	}

	private void addUsername() {
		this.setLayout(null);
		username = new JTextField();
		username.setBounds(100, 80, 200, 20);
		this.add(username);
	}

	private void addPassword() {
		this.setLayout(null);
		password1 = new JPasswordField();
		password2 = new JPasswordField();
		password1.setBounds(100, 130, 200, 20);
		password2.setBounds(100, 180, 200, 20);
		this.add(password1);
		this.add(password2);
	}

	private void addButton() {
		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 3, 5, 5));
		JButton button1 = new JButton("注册");
		JButton buttonNull = new JButton();
		JButton button2 = new JButton("返回");
		button1.setFont(new Font("仿宋", Font.BOLD, 20));
		buttonNull.setVisible(false);
		button2.setFont(new Font("仿宋", Font.BOLD, 20));
		panel.setPreferredSize(new Dimension(0, 40));
		panel.add(button1);
		panel.add(buttonNull);
		panel.add(button2);
		this.getContentPane().add(panel, BorderLayout.SOUTH);

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (username.getText().length() == 0
						|| password1.getPassword().length == 0
						|| password2.getPassword().length == 0) {
					new Message("用户名或密码不能为空！", 0);
				} else {
					if (!Arrays.equals(password1.getPassword(),
							password2.getPassword())) {
						new Message("两次输入的密码不一致！", 0);
					} else {
						try {
							new Users(username.getText(), String
									.valueOf(password1.getPassword()));
						} catch (IOException error) {
							error.printStackTrace();
						}
						new Message("注册成功！", 0);
					}
				}
			}
		});

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UsersSignUp.this.setVisible(false);
			}
		});
	}
}