package Admin;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Data.Data;
import GUI.AdminWindow;
import GUI.Message;

public class DeleteItem extends JFrame {
	private JTextField textBox;
	private ArrayList<Data> dataList;

	public DeleteItem() {
		this.setTitle("É¾³ý²ËÆ·");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(200, 200, 400, 200);
		this.setVisible(true);
		addTextBox();
		addButton();
	}

	private void addTextBox() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2, 10, 10));
		JLabel label = new JLabel("²ËÆ·Ãû³Æ");
		label.setFont(new Font("·ÂËÎ", Font.BOLD, 36));
		textBox = new JTextField();
		panel.setPreferredSize(new Dimension(0, 100));
		panel.add(label);
		panel.add(textBox);
		this.getContentPane().add(panel, "North");
	}

	private void addButton() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout());
		JButton button1 = new JButton("É¾³ý");
		button1.setFont(new Font("·ÂËÎ", Font.BOLD, 20));
		JButton button2 = new JButton("·µ»Ø");
		button2.setFont(new Font("·ÂËÎ", Font.BOLD, 20));
		panel.setPreferredSize(new Dimension(0, 50));
		panel.add(button1);
		panel.add(button2);
		this.getContentPane().add(panel, "South");

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "È·¶¨É¾³ý²ËÆ·£¿", "ÎÂÜ°ÌáÊ¾", JOptionPane.YES_NO_OPTION);
				if (i == 0) {
					try {
						BufferedReader reader1 = new BufferedReader(new FileReader(".\\files\\item\\NameData.txt"));
						BufferedReader reader2 = new BufferedReader(new FileReader(".\\files\\item\\PriceData.txt"));
						BufferedReader reader3 = new BufferedReader(new FileReader(".\\files\\item\\SalesData.txt"));
						BufferedReader reader4 = new BufferedReader(new FileReader(".\\files\\item\\AssessData.txt"));
						String line1 = null;
						String line2 = null;
						String line3 = null;
						String line4 = null;
						dataList = new ArrayList<Data>();
						int n = 0;
						while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null
								&& (line3 = reader3.readLine()) != null && (line4 = reader4.readLine()) != null) {
							Data data = new Data(line1, line2, line3, line4);
							dataList.add(data);
							if (data.getName().equals(textBox.getText())) {
								dataList.remove(data);
								new Message("É¾³ý³É¹¦£¡", 0);
								n++;
							}
						}
						if (n == 0)
							new Message("Î´ÕÒµ½²ËÆ·£¡", 0);
						reader1.close();
						reader2.close();
						reader3.close();
						reader4.close();
					} catch (IOException error) {
						error.printStackTrace();
					}

					try {
						BufferedWriter writer1 = new BufferedWriter(new FileWriter(".\\files\\item\\NameData.txt"));
						BufferedWriter writer2 = new BufferedWriter(new FileWriter(".\\files\\item\\PriceData.txt"));
						BufferedWriter writer3 = new BufferedWriter(new FileWriter(".\\files\\item\\SalesData.txt"));
						BufferedWriter writer4 = new BufferedWriter(new FileWriter(".\\files\\item\\AssessData.txt"));
						writer1.write("");
						writer2.write("");
						writer3.write("");
						writer4.write("");
						writer1.close();
						writer2.close();
						writer3.close();
						writer4.close();
					} catch (IOException error) {
						error.printStackTrace();
					}

					try {
						BufferedWriter writer1 = new BufferedWriter(
								new FileWriter(".\\files\\item\\NameData.txt", true));
						BufferedWriter writer2 = new BufferedWriter(
								new FileWriter(".\\files\\item\\PriceData.txt", true));
						BufferedWriter writer3 = new BufferedWriter(
								new FileWriter(".\\files\\item\\SalesData.txt", true));
						BufferedWriter writer4 = new BufferedWriter(
								new FileWriter(".\\files\\item\\AssessData.txt", true));
						for (int j = 0; j < dataList.size(); j++) {
							writer1.write(dataList.get(j).getName());
							writer1.newLine();
							writer2.write(dataList.get(j).getPrice());
							writer2.newLine();
							writer3.write(dataList.get(j).getSales());
							writer3.newLine();
							writer4.write(dataList.get(j).getAssess());
							writer4.newLine();
						}
						writer1.close();
						writer2.close();
						writer3.close();
						writer4.close();
					} catch (IOException error) {
						error.printStackTrace();
					}
				}
			}
		});

		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DeleteItem.this.setVisible(false);
				new AdminWindow();
			}
		});
	}
}