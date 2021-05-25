package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.dao;
import model.model;

public class insert extends JFrame implements ActionListener {
	
	JLabel namaMenu = new JLabel("Nama menu:");
	JTextField namatext= new JTextField();
	
	JLabel hargaMenu = new JLabel("Harga menu:");
	JTextField hargatext = new JTextField();
	
	JLabel stockMenu = new JLabel("Stok menu:");
	JTextField stocktext = new JTextField();
	
	JButton submit = new JButton("Submit");
	JButton home = new JButton ("Home");
	
	public insert() {
		insertFrame();
	}
	
	private void insertFrame() {
		setTitle("BobaCool");
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		
		initInsert();
		initComponent();
		
		setVisible(true);
	}
	
	private void initInsert() {
		JLabel InsertTitle = new JLabel("Insert Menu");
		InsertTitle.setHorizontalAlignment(JLabel.CENTER);
		Font font = new Font("Chiller", Font.BOLD, 30);
		InsertTitle.setFont(font);
		add(InsertTitle);
	}
	
	private void initComponent() {
		JPanel insert = new JPanel();
		insert.setLayout(new GridLayout(4,2));
		
		JPanel insertname = new JPanel(); 
		insertname.setLayout(new GridLayout (1,2)); 
		insertname.add(namaMenu);
		insertname.add(namatext);
		insert.add(insertname); 
		
		JPanel insertharga = new JPanel(); 
		insertharga.setLayout(new GridLayout (1,2)); 
		insertharga.add(hargaMenu);
		insertharga.add(hargatext);
		insert.add(insertharga); 
		
		JPanel insertstock = new JPanel(); 
		insertstock.setLayout(new GridLayout (1,2)); 
		insertstock.add(stockMenu);
		insertstock.add(stocktext);
		insert.add(insertstock); 
		
		JPanel button = new JPanel(); 
		button.setLayout(new GridLayout (1,2));
		button.add(home);
		button.add(submit);
		insert.add(button); 
		
		
		add(insert);
		
		submit.addActionListener(this);
		home.addActionListener(this);
		
	}
	
	private String createRandomCode(JTextField code) {
		Random rand = new Random();
		  String id = "BC - ";
		    for(int i =0; i < 5; i++) {
		       id += rand.nextInt(10);
		    }
			return id;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(submit)) {
			dao controller = new dao();
			controller.insert(createRandomCode(namatext), namatext.getText(), hargatext.getText(), stocktext.getText()); 
			namatext.setText(null);
			hargatext.setText(null);
			stocktext.setText(null);
		}
		else if(e.getSource().equals(home)) {
			new home(); 
			setVisible(false); 
			}
	}
}
