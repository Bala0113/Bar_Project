package bar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;

public class start {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();	
		frame.getContentPane().setBackground(new Color(215, 226, 183));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
		
		
//Asztal1
		JButton btnAsztal1 = new JButton("1");
		btnAsztal1.setBackground(new Color(218, 168, 1));
		btnAsztal1.setBounds(50, 50, 200,100);
		btnAsztal1.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnAsztal1);
		
		ArrayList<Ital> lista1 = new ArrayList<Ital>();
		Asztal asztal1 = new Asztal(1,lista1); 
		
		btnAsztal1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				fizetes f =new fizetes();
				f.fizetes(asztal1);
			}	
		});
		
		
//Asztal2
		JButton btnAsztal2 = new JButton("2");
		btnAsztal2.setBackground(new Color(218, 168, 1));
		btnAsztal2.setBounds(300, 50, 200,100);
		btnAsztal2.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnAsztal2);
		
		ArrayList<Ital> lista2 = new ArrayList<Ital>();
		Asztal asztal2 = new Asztal(1,lista2); 
		
		btnAsztal2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				fizetes f =new fizetes();
				f.fizetes(asztal2);	
			}	
		});

		
//Asztal3
		JButton btnAsztal3 = new JButton("3");
		btnAsztal3.setBackground(new Color(218, 168, 1));
		btnAsztal3.setBounds(550, 50, 200,100);
		btnAsztal3.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnAsztal3);
		
		ArrayList<Ital> lista3 = new ArrayList<Ital>();
		Asztal asztal3 = new Asztal(1,lista3); 
		
		btnAsztal3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				fizetes f =new fizetes();
				f.fizetes(asztal3);
			}	
		});
		
		
//Asztal4
		JButton btnAsztal4 = new JButton("4");
		btnAsztal4.setBackground(new Color(218, 168, 1));
		btnAsztal4.setBounds(50, 200, 200,100);
		btnAsztal4.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnAsztal4);
		
		ArrayList<Ital> lista4 = new ArrayList<Ital>();
		Asztal asztal4 = new Asztal(1,lista4); 
		
		btnAsztal4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				fizetes f =new fizetes();
				f.fizetes(asztal4);
			}	
		});
		
		
//Asztal5
		JButton btnAsztal5 = new JButton("5");
		btnAsztal5.setBackground(new Color(218, 168, 1));
		btnAsztal5.setBounds(300, 200, 200,100);
		btnAsztal5.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnAsztal5);
		
		ArrayList<Ital> lista5 = new ArrayList<Ital>();
		Asztal asztal5 = new Asztal(1,lista5); 
		
		btnAsztal5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				fizetes f =new fizetes();
				f.fizetes(asztal5);
			}	
		});
		
		
//Asztal6
		JButton btnAsztal6 = new JButton("6");
		btnAsztal6.setBackground(new Color(218, 168, 1));
		btnAsztal6.setBounds(550, 200, 200,100);
		btnAsztal6.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnAsztal6);
		
		ArrayList<Ital> lista6 = new ArrayList<Ital>();
		Asztal asztal6 = new Asztal(1,lista6); 
		
		btnAsztal6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				fizetes f =new fizetes();
				f.fizetes(asztal6);
			}	
		});
		
		
//Asztal7
		JButton btnAsztal7 = new JButton("Terasz 1");
		btnAsztal7.setBackground(new Color(218, 168, 1));
		btnAsztal7.setBounds(150, 350, 200,100);
		btnAsztal7.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnAsztal7);
		
		ArrayList<Ital> lista7 = new ArrayList<Ital>();
		Asztal asztal7 = new Asztal(1,lista7); 
		
		btnAsztal7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				fizetes f =new fizetes();
				f.fizetes(asztal7);
			}	
		});
		
		
//Asztal8
		JButton btnAsztal8 = new JButton("Terasz 2");
		btnAsztal8.setBackground(new Color(218, 168, 1));
		btnAsztal8.setBounds(550, 350, 200,100);
		btnAsztal8.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnAsztal8);
		
		ArrayList<Ital> lista8 = new ArrayList<Ital>();
		Asztal asztal8 = new Asztal(1,lista8); 
		
		btnAsztal8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				fizetes f =new fizetes();
				f.fizetes(asztal8);
			}	
		});
		
		
//kilepes
		JButton btnExit = new JButton("Kil�p�s");
		btnExit.setBackground(new Color(218, 168, 1));
		btnExit.setBounds(700, 700, 100,100);
		btnExit.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
				

//Fizetes gomb
		JButton btnFizetes = new JButton("Azonnali fizetes");
		btnFizetes.setBackground(new Color(218, 168, 1));
		btnFizetes.setBounds(400, 550, 300,100);
		btnFizetes.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnFizetes);
		ArrayList<Ital> lista9 = new ArrayList<Ital>();
		Asztal asztal9 = new Asztal(1,lista9); 
		
		btnFizetes.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				fizetes f =new fizetes();
				f.fizetes(asztal9);
			}	
		});
		
		frame.setVisible(true);
	}

}
