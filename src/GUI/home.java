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

public class home extends JFrame implements ActionListener{


	Font font = new Font("Chiller", Font.BOLD, 100);
	
	JButton insert = new JButton("Insert Menu");
	JButton view= new JButton("View Menu");
	JButton update = new JButton("Update Menu");
	JButton delete = new JButton("Delete Menu");
	JButton exit = new JButton("Exit Menu");

	public home () {
		homeFrame();
	}

	private void homeFrame() {
		setTitle ("BobaCool");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());
		
		initTitle();
		initLabel();
		
		setVisible(true); 
		
	}
	
	private void initTitle() {
		JLabel title = new JLabel("BobaCool");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(font);
		add(title);
		
	}
	
	private void initLabel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1,2));
		panel1.add(insert);
		panel1.add(view);
		panel.add(panel1);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,2));
		panel2.add(update);
		panel2.add(delete);
		panel.add(panel2);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1,0));
		panel3.add(exit);
		panel.add(panel3);
		
		insert.addActionListener(this);
		view.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
		exit.addActionListener(this);
		
		add(panel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == insert){
			new insert();
			setVisible(false);
		}else if(e.getSource() == view ){
			new view();
			setVisible(false);
		}
		else if(e.getSource() == update){
			new update();
			setVisible(false);
		}
		else if(e.getSource() == delete){
			new delete();
			setVisible(false);
		}
		else if(e.getSource() == exit){
			System.exit(0);
		}
	}
		
}

