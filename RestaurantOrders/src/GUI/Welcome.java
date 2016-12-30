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
		this.setTitle("���϶���ϵͳ");
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
		JButton button1 = new JButton("�����û�");
		JButton button2 = new JButton("���ǹ���Ա");
		JButton button3 = new JButton("�˳�ϵͳ");
		button1.setFont(new Font("�����п�", Font.BOLD, 36));
		button2.setFont(new Font("�����п�", Font.BOLD, 36));
		button3.setFont(new Font("�����п�", Font.BOLD, 36));
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
				int i = JOptionPane.showConfirmDialog(null, "ȷ���˳�ϵͳ��", "��ܰ��ʾ", JOptionPane.YES_NO_OPTION);
				if (i == 0)
					System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new Welcome();
	}
}