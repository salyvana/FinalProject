package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.dao;
import model.model;

public class updatesubmit extends JFrame implements ActionListener {

	Font font = new Font("Chiller", Font.BOLD, 30);
	
	JLabel namaMenu = new JLabel("Nama menu:");
	JTextField namatext= new JTextField();
	
	JLabel hargaMenu = new JLabel("Harga menu:");
	JTextField hargatext = new JTextField();
	
	JLabel stockMenu = new JLabel("Stok menu:");
	JTextField stocktext = new JTextField();
	
	JLabel codeMenu = new JLabel("Code menu: ");
	JTextField codetext = new JTextField();
	
	JButton submit = new JButton("Submit");
	JButton home = new JButton ("Home");
	
	public updatesubmit() {
		submitFrame(); 
	}
	

	private void submitFrame() {
		setTitle("BobaCool");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		
		submitTitle();
		submitComponent();
		
		setVisible(true);
	}
	
	private void submitTitle() {
		JLabel submitTitle = new JLabel("Insert New Menu");
		submitTitle.setHorizontalAlignment(JLabel.CENTER);
		submitTitle.setFont(font);
		add(submitTitle);
	}
	
	private void submitComponent() {
		JPanel submitPanel = new JPanel();
		submitPanel.setLayout(new GridLayout(4,2));
	
		submitPanel.add(namaMenu);
		submitPanel.add(namatext);
		
		submitPanel.add(hargaMenu);
		submitPanel.add(hargatext);
		
		submitPanel.add( stockMenu);
		submitPanel.add(stocktext);
		
		submitPanel.add(submit);
		submitPanel.add(home);
		
		
		add(submitPanel);
		
		submit.addActionListener(this);
		home.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(submit)) {
			dao controller = new dao();
			controller.update(namatext.getText(), hargatext.getText(), stocktext.getText());
		}
		else if(e.getSource().equals(home)){
			new home();
			setVisible(false);
		}
	}

}
