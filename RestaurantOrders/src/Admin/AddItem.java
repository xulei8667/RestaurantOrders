package Admin;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Data.Data;
import GUI.AdminWindow;
import GUI.Message;

public class AddItem extends JFrame {
	private JTextField textBox1;
	private JTextField textBox2;
	private JTextField textBox3;
	private JTextField textBox4;

	public AddItem() {
		this.setTitle("添加菜品");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(200, 200, 400, 500);
		this.setVisible(true);
		addTextBox();
		addButton();
	}

	private void addTextBox() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 2, 10, 10));
		JLabel label1 = new JLabel("菜品名称");
		label1.setFont(new Font("仿宋", Font.BOLD, 36));
		textBox1 = new JTextField();
		JLabel label2 = new JLabel("菜品价格");
		label2.setFont(new Font("仿宋", Font.BOLD, 36));
		textBox2 = new JTextField();
		JLabel label3 = new JLabel("菜品销量");
		label3.setFont(new Font("仿宋", Font.BOLD, 36));
		textBox3 = new JTextField();
		JLabel label4 = new JLabel("菜品评价");
		label4.setFont(new Font("仿宋", Font.BOLD, 36));
		textBox4 = new JTextField();
		panel.setPreferredSize(new Dimension(0, 400));
		panel.add(label1);
		panel.add(textBox1);
		panel.add(label2);
		panel.add(textBox2);
		panel.add(label3);
		panel.add(textBox3);
		panel.add(label4);
		panel.add(textBox4);
		this.getContentPane().add(panel, "North");
	}

	private void addButton() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout());
		JButton button1 = new JButton("添加");
		button1.setFont(new Font("仿宋", Font.BOLD, 20));
		JButton button2 = new JButton("返回");
		button2.setFont(new Font("仿宋", Font.BOLD, 20));
		panel.setPreferredSize(new Dimension(0, 50));
		panel.add(button1);
		panel.add(button2);
		this.getContentPane().add(panel, "South");

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Data data = new Data(textBox1.getText(), textBox2.getText(), textBox3.getText(), textBox4.getText());
				try {
					BufferedWriter writer1 = new BufferedWriter(new FileWriter(".\\files\\item\\NameData.txt", true));
					BufferedWriter writer2 = new BufferedWriter(new FileWriter(".\\files\\item\\PriceData.txt", true));
					BufferedWriter writer3 = new BufferedWriter(new FileWriter(".\\files\\item\\SalesData.txt", true));
					BufferedWriter writer4 = new BufferedWriter(new FileWriter(".\\files\\item\\AssessData.txt", true));
					writer1.write(data.getName());
					writer1.newLine();
					writer2.write(data.getPrice());
					writer2.newLine();
					writer3.write(data.getSales());
					writer3.newLine();
					writer4.write(data.getAssess());
					writer4.newLine();
					writer1.close();
					writer2.close();
					writer3.close();
					writer4.close();
				} catch (IOException error) {
					error.printStackTrace();
				}
				new Message("添加成功！", 0);
			}
		});

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddItem.this.setVisible(false);
				new AdminWindow();
			}
		});
	}
}