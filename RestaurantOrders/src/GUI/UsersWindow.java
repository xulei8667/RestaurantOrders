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

import Admin.CheckItem;
import Users.AddShoppingCart;
import Users.CheckShoppingCart;
import Users.DeleteShoppingCart;

public class UsersWindow extends JFrame {
	ImageIcon image;
	
	public UsersWindow() {
		image = new ImageIcon(".//files//images//UsersWindow.jpg");
		image.setImage(image.getImage().getScaledInstance(800, 750, Image.SCALE_DEFAULT));
		this.setTitle("���϶���ϵͳ���û��棩");
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
		panel.setLayout(new GridLayout(5, 1, 20, 20));
		JButton button1 = new JButton("�鿴��Ʒ");
		JButton button2 = new JButton("�鿴���ﳵ");
		JButton button3 = new JButton("��ӹ��ﳵ");
		JButton button4 = new JButton("ɾ�����ﳵ");
		JButton button5 = new JButton("�˳�ϵͳ");
		button1.setFont(new Font("���Ĳ���", Font.BOLD, 36));
		button2.setFont(new Font("���Ĳ���", Font.BOLD, 30));
		button3.setFont(new Font("���Ĳ���", Font.BOLD, 30));
		button4.setFont(new Font("���Ĳ���", Font.BOLD, 30));
		button5.setFont(new Font("��������", Font.BOLD, 36));
		panel.setPreferredSize(new Dimension(200, 0));
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		this.getContentPane().add(panel, BorderLayout.WEST);

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UsersWindow.this.setVisible(false);
				new CheckItem(1);
			}
		});
		
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UsersWindow.this.setVisible(false);
				new CheckShoppingCart();
			}
		});
		
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UsersWindow.this.setVisible(false);
				new AddShoppingCart();
			}
		});
		
		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UsersWindow.this.setVisible(false);
				new DeleteShoppingCart();
			}
		});

		button5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "ȷ���˳�ϵͳ��", "��ܰ��ʾ", JOptionPane.YES_NO_OPTION);
				if (i == 0)
					System.exit(0);
			}
		});
	}
}