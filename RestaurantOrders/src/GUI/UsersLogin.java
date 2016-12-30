package GUI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UsersLogin extends JFrame {
	private String signsUsername;
	private String signsPassword;
	private JTextField username;
	private JPasswordField password;

	public UsersLogin() {
		this.setTitle("用户登录");
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
		label1.setFont(new Font("仿宋", Font.BOLD, 16));
		label2.setFont(new Font("仿宋", Font.BOLD, 16));
		label1.setBounds(20, 100, 80, 20);
		label2.setBounds(20, 150, 80, 20);
		this.add(label1);
		this.add(label2);
	}

	private void addUsername() {
		this.setLayout(null);
		username = new JTextField();
		username.setBounds(100, 100, 200, 20);
		this.add(username);
	}

	private void addPassword() {
		this.setLayout(null);
		password = new JPasswordField();
		password.setBounds(100, 150, 200, 20);
		this.add(password);
	}

	private void addButton() {
		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 3, 5, 5));
		JButton button1 = new JButton("登录");
		JButton button2 = new JButton("注册");
		JButton button3 = new JButton("返回");
		button1.setFont(new Font("仿宋", Font.BOLD, 20));
		button2.setFont(new Font("仿宋", Font.BOLD, 20));
		button3.setFont(new Font("仿宋", Font.BOLD, 20));
		panel.setPreferredSize(new Dimension(0, 40));
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		this.getContentPane().add(panel, BorderLayout.SOUTH);

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (username.getText().length() == 0 || password.getPassword().length == 0) {
					new Message("用户名或密码不能为空！", 0);
				} else {
					try {
						FileReader fr1 = new FileReader(".\\files\\users\\username.txt");
						BufferedReader reader1 = new BufferedReader(fr1);
						signsUsername = reader1.readLine();
						fr1.close();

						FileReader fr2 = new FileReader(".\\files\\users\\password.txt");
						BufferedReader reader2 = new BufferedReader(fr2);
						signsPassword = reader2.readLine();
						fr2.close();
					} catch (IOException error) {
						error.printStackTrace();
					}
					if (!(username.getText().equals(signsUsername))
							|| !(String.valueOf(password.getPassword()).equals(signsPassword))) {
						new Message("用户名或密码不正确！", 0);
					} else {
						UsersLogin.this.setVisible(false);
						new Message("登陆成功！", 1);
					}
				}
			}
		});

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UsersSignUp();
			}
		});

		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UsersLogin.this.setVisible(false);
				new Welcome();
			}
		});
	}
}