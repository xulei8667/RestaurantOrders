package Users;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Admin.CheckItem;
import Data.Data;
import GUI.AdminWindow;
import GUI.UsersWindow;

public class CheckShoppingCart extends JFrame {
	ArrayList<Data> dataList;

	public CheckShoppingCart() {
		this.setTitle("查看购物车");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		readData();
		this.setBounds(200, 200, 800, (dataList.size() + 1) * 100);
		this.setVisible(true);
		addLabel();
		addButton();
	}

	private void readData() {
		try {
			BufferedReader reader1 = new BufferedReader(new FileReader(".\\files\\shoppingCart\\NameCart.txt"));
			BufferedReader reader2 = new BufferedReader(new FileReader(".\\files\\shoppingCart\\PriceCart.txt"));
			BufferedReader reader3 = new BufferedReader(new FileReader(".\\files\\shoppingCart\\SalesCart.txt"));
			BufferedReader reader4 = new BufferedReader(new FileReader(".\\files\\shoppingCart\\AssessCart.txt"));
			String line1 = null;
			String line2 = null;
			String line3 = null;
			String line4 = null;
			dataList = new ArrayList<Data>();
			while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null
					&& (line3 = reader3.readLine()) != null && (line4 = reader4.readLine()) != null) {
				dataList.add(new Data(line1, line2, line3, line4));
			}
		} catch (IOException error) {
			error.printStackTrace();
		}
	}

	private void addLabel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(dataList.size() + 1, 4, 10, 10));
		JLabel label1 = new JLabel("菜品名称");
		label1.setFont(new Font("黑体", Font.BOLD, 20));
		label1.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label1);
		JLabel label2 = new JLabel("菜品价格");
		label2.setFont(new Font("黑体", Font.BOLD, 20));
		label2.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label2);
		JLabel label3 = new JLabel("菜品销量");
		label3.setFont(new Font("黑体", Font.BOLD, 20));
		label3.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label3);
		JLabel label4 = new JLabel("菜品评价");
		label4.setFont(new Font("黑体", Font.BOLD, 20));
		label4.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label4);
		for (int i = 0; i < dataList.size(); i++) {
			JLabel jl1 = new JLabel(dataList.get(i).getName());
			jl1.setFont(new Font("仿宋", Font.BOLD, 16));
			jl1.setHorizontalAlignment(JLabel.CENTER);
			panel.add(jl1);
			JLabel jl2 = new JLabel(dataList.get(i).getPrice());
			jl2.setFont(new Font("仿宋", Font.BOLD, 16));
			jl2.setHorizontalAlignment(JLabel.CENTER);
			panel.add(jl2);
			JLabel jl3 = new JLabel(dataList.get(i).getSales());
			jl3.setFont(new Font("仿宋", Font.BOLD, 16));
			jl3.setHorizontalAlignment(JLabel.CENTER);
			panel.add(jl3);
			JLabel jl4 = new JLabel(dataList.get(i).getAssess());
			jl4.setFont(new Font("仿宋", Font.BOLD, 16));
			jl4.setHorizontalAlignment(JLabel.CENTER);
			panel.add(jl4);
		}
		panel.setPreferredSize(new Dimension(0, (dataList.size() + 1) * 50));
		this.getContentPane().add(panel, "North");
	}

	private void addButton() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 4, 5, 5));
		JButton buttonNull1 = new JButton();
		JButton buttonNull2 = new JButton();
		JButton buttonNull3 = new JButton();
		JButton button = new JButton("返回");
		buttonNull1.setVisible(false);
		buttonNull2.setVisible(false);
		buttonNull3.setVisible(false);
		button.setFont(new Font("仿宋", Font.BOLD, 20));
		panel.add(buttonNull1);
		panel.add(buttonNull2);
		panel.add(buttonNull3);
		panel.add(button);
		panel.setPreferredSize(new Dimension(0, 50));
		this.getContentPane().add(panel, "South");

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CheckShoppingCart.this.setVisible(false);
				new UsersWindow();
			}
		});
	}
}