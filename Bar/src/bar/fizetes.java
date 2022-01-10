package bar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Desktop;

public class fizetes {
	
	DefaultListModel<String> l1 = new DefaultListModel<>(); 
	DefaultListModel<String> l2 = new DefaultListModel<>(); 
	DefaultListModel<String> l3 = new DefaultListModel<>();
	int kapottpenz;
	int vegosszeg;
	int visszajaro;
	String osszeg;
	
	public void fizetes( Asztal asztal) {


//Ablak
		JFrame frame = new JFrame();
		frame.getContentPane().setBackground(new Color(215, 226, 183));
		frame.setSize(800,800);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
		
//Lista 
        JList<String> list = new JList<>(l1);  
        list.setBounds(50, 50, 150, 500);  
        list.setBorder(new LineBorder(Color.BLACK));
        frame.add(list);   
//Lista 1
        JList<String> list1 = new JList<>(l2);  
        list1.setBounds(200, 50, 60, 500); 
        list1.setBorder(new LineBorder(Color.BLACK)); 
        frame.add(list1);   
//Lista 2
        JList<String> list2 = new JList<>(l3);  
        list2.setBounds(200, 550, 60, 20);  
        list2.setBorder(new LineBorder(Color.BLACK));
        frame.add(list2);   
		
//"�sszesen		
      		JTextField osszesen = new JTextField("�SSZESEN:");
      		osszesen.setBounds(50, 550, 150, 20);
      		frame.add(osszesen);   
      		
if(asztal.getRendeles().size() != 0) {
	frissites(asztal.getRendeles());
	DefaultListModel<String> model = (DefaultListModel) list2.getModel();
	model.clear();
	osszeg=osszegfrissites(asztal.getRendeles());
	l3.addElement(osszeg);
}
        
//egyeb lista		
		Beolvasas.beolvasas();
		String[] egyeb = new String[Beolvasas.ItalLap.size()];
		for(int i =0;i<Beolvasas.ItalLap.size();i++) {
			egyeb[i]=Beolvasas.ItalLap.get(i).getNev();
		}
		
		final JComboBox<String> cb = new JComboBox<String>(egyeb);
		ArrayList<JLabel> lblLista = new ArrayList<JLabel>();
		
		cb.setMaximumSize(cb.getPreferredSize());
	    cb.setBounds(600, 100,100,100);
		frame.add(cb);
	    lblLista.add(new JLabel(cb.getItemAt(cb.getSelectedIndex())));

//hozzaad gomb		
		JButton btnHozzaad = new JButton("+");
		btnHozzaad.setBackground(new Color(218, 168, 1));
		btnHozzaad.setBounds(600, 0, 100, 100);
		frame.add(btnHozzaad);
		btnHozzaad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a =cb.getItemAt(cb.getSelectedIndex());
				for(int i =0 ;i<Beolvasas.ItalLap.size();i++) {
					if(a.equals(Beolvasas.ItalLap.get(i).getNev())){
						asztal.getRendeles().add(Beolvasas.ItalLap.get(i));
						l1.addElement(Beolvasas.ItalLap.get(i).getNev()+ " " + Beolvasas.ItalLap.get(i).getMennyiseg());
						l2.addElement(Beolvasas.ItalLap.get(i).getAr1());
						osszegfrissites(asztal.getRendeles());
					}
				}
			}
		});
  		
//vissza gomb
		JButton btnExit = new JButton("Vissza");
		btnExit.setBackground(new Color(218, 168, 1));
		btnExit.setBounds(700, 700, 100, 100);
		btnExit.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
		
			}
		});
		
//t�rl�s gomb
		JButton btnDelete = new JButton("-");
		btnDelete.setBackground(new Color(218, 168, 1));
		btnDelete.setBounds(700, 0, 100, 100);
		btnDelete.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[]parts = list.getSelectedValue().split(" ");
				int index = list.getSelectedIndex();
				String deleteNev = parts[0];
				String deleteMennyiseg = parts[1];
				DefaultListModel<String> model = (DefaultListModel) list.getModel();
				DefaultListModel<String> model1 = (DefaultListModel) list1.getModel();
				if (index != -1) {
				    model.remove(index);
				    model1.remove(index);
				    model.clear();
				    model1.clear();
				}
				torles(asztal.getRendeles(),deleteNev,deleteMennyiseg);
				
				frissites(asztal.getRendeles());
				
				DefaultListModel<String> model2 = (DefaultListModel) list2.getModel();
				model2.clear();
				osszeg=osszegfrissites(asztal.getRendeles());
				l3.addElement(osszeg);
			}
		});
	
//frissites gomb
		JButton btnRefresh = new JButton("Friss�t�s");
		btnRefresh.setBackground(new Color(218, 168, 1));
		btnRefresh.setBounds(300, 450, 200, 100);
		btnRefresh.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<String> model = (DefaultListModel) list2.getModel();
				model.clear();
				osszeg=osszegfrissites(asztal.getRendeles());
				l3.addElement(osszeg);
		}		
		});

		
//�rhat� t�mb			
			JTextField f1 = new JTextField("0");
			f1.setBounds(350, 200, 100,50);
			frame.add(f1);	
		
//fizetes gomb
			JButton btnPayment = new JButton("Fizet�s");
			btnPayment.setBackground(new Color(218, 168, 1));
			btnPayment.setBounds(300, 300, 200, 100);
			btnPayment.setBorder(new LineBorder(Color.BLACK));
			frame.add(btnPayment);
			btnPayment.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					kapottpenz =Integer.parseInt(f1.getText());
						if (kapottpenz >= vegosszeg) {
							visszajaro = kapottpenz-vegosszeg;
							

							try {
								kiiras(asztal.getRendeles());
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							asztal.getRendeles().clear();
							frame.dispose();
						}
			}
		});
	
			
//Dreher
		JButton btndreher = new JButton("Dreher");
		btndreher.setBackground(new Color(218, 168, 1));
		btndreher.setBounds(0, 600, 100, 100);
		btndreher.setBorder(new LineBorder(Color.BLACK));
		frame.add(btndreher);	
		Ital dreher = new Ital("Dreher",450, "450", "0,5l");
		
		btndreher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asztal.getRendeles().add(dreher);
				l1.addElement(dreher.getNev() + " " + dreher.getMennyiseg());
				l2.addElement(dreher.getAr1());
			}
		});
		
//Soproni
		JButton btnSoproni = new JButton("Soproni");
		btnSoproni.setBackground(new Color(218, 168, 1));
		btnSoproni.setBounds(100, 600, 100, 100);
		btnSoproni.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnSoproni);	
		Ital soproni = new Ital("Soproni",430, "430", "0,5l");

		btnSoproni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asztal.getRendeles().add(soproni);
				l1.addElement(soproni.getNev() + " " + soproni.getMennyiseg());
				l2.addElement(soproni.getAr1());
			}
		});
		
//P�csi
		JButton btnPecsi = new JButton("P�csi");
		btnPecsi.setBackground(new Color(218, 168, 1));
		btnPecsi.setBounds(200, 600, 100, 100);
		btnPecsi.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnPecsi);	
		Ital pecsi = new Ital("P�csi",420, "420", "0,5l");

		btnPecsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asztal.getRendeles().add(pecsi);
				l1.addElement(pecsi.getNev() + " " + pecsi.getMennyiseg());
				l2.addElement(pecsi.getAr1());
			}
		});

//feherbor
		JButton btnfeherbor = new JButton("Feh�rbor");
		btnfeherbor.setBackground(new Color(218, 168, 1));
		btnfeherbor.setBounds(300, 600, 100, 100);
		btnfeherbor.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnfeherbor);	
		borok feherbor = new borok("Feh.bor",350, "350", "0,3l",fajtak.Feh�r);

		btnfeherbor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asztal.getRendeles().add(feherbor);
				l1.addElement(feherbor.getNev() + " " + feherbor.getMennyiseg());
				l2.addElement(feherbor.getAr1());
			}
		});
		

//V�r�sbor
		JButton btnVorosbor = new JButton("V�r�sbor");
		btnVorosbor.setBackground(new Color(218, 168, 1));
		btnVorosbor.setBounds(400, 600, 100, 100);
		btnVorosbor.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnVorosbor);	
		borok vorosbor = new borok("V�r.bor",250, "350", "0,3l", fajtak.V�r�s);

		btnVorosbor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asztal.getRendeles().add(vorosbor);
				l1.addElement(vorosbor.getNev() + " " + vorosbor.getMennyiseg());
				l2.addElement(vorosbor.getAr1());
			}
		});	
		
//Roz�
		JButton btnRoze = new JButton("Roz�");
		btnRoze.setBackground(new Color(218, 168, 1));
		btnRoze.setBounds(300, 700, 100, 100);
		btnRoze.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnRoze);	
		borok Roze = new borok("Roz�",300, "350", "0,3l",fajtak.Roz�);

		btnRoze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asztal.getRendeles().add(Roze);
				l1.addElement(Roze.getNev() + " " + Roze.getMennyiseg());
				l2.addElement(Roze.getAr1());
			}
		});	
		
//Sz�da
		JButton btnSzoda = new JButton("Sz�da");
		btnSzoda.setBackground(new Color(218, 168, 1));
		btnSzoda.setBounds(400, 700, 100, 100);
		btnSzoda.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnSzoda);	
		Ital soda = new Ital("Sz�da",20, "20", "0,2l");

		btnSzoda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asztal.getRendeles().add(soda);
				l1.addElement(soda.getNev() + " " + soda.getMennyiseg());
				l2.addElement(soda.getAr1());
			}
		});	
		
//Dreher poh�r
		JButton btnpdreher = new JButton("DreherPohar");
		btnpdreher.setBackground(new Color(218, 168, 1));
		btnpdreher.setBounds(0, 700, 100, 100);
		btnpdreher.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnpdreher);	
		Ital pdreher = new Ital("Dreher",350, "350", "0,3l");

		btnpdreher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asztal.getRendeles().add(pdreher);
				l1.addElement(pdreher.getNev() + " " + pdreher.getMennyiseg());
				l2.addElement(pdreher.getAr1());
			}
		});

//Soproni poh�r
		JButton btnPSoproni = new JButton("SoproniPohar");
		btnPSoproni.setBackground(new Color(218, 168, 1));
		btnPSoproni.setBounds(100, 700, 100, 100);
		btnPSoproni.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnPSoproni);	
		Ital Psoproni = new Ital("Soproni",320, "320", "0,3l");

		btnPSoproni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asztal.getRendeles().add(Psoproni);
				l1.addElement(Psoproni.getNev() + " " + Psoproni.getMennyiseg());
				l2.addElement(Psoproni.getAr1());
			}
		});

//P�csi poh�r
		JButton btnPPecsi = new JButton("P�csiPohar");
		btnPPecsi.setBackground(new Color(218, 168, 1));
		btnPPecsi.setBounds(200, 700, 100, 100);
		btnPPecsi.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnPPecsi);	
		Ital Ppecsi = new Ital("P�csi",300, "300", "0,3l");

		btnPPecsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asztal.getRendeles().add(Ppecsi);
				l1.addElement(Ppecsi.getNev() + " " + Ppecsi.getMennyiseg());
				l2.addElement(Ppecsi.getAr1());
			}
		});

//Vodka
		JButton btnVodka = new JButton("Vodka");
		btnVodka.setBackground(new Color(218, 168, 1));
		btnVodka.setBounds(500, 700, 100, 100);
		btnVodka.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnVodka);	
		Ital Vodka = new Ital("Vodka",700, "700", "4cl");

		btnVodka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asztal.getRendeles().add(Ppecsi);
				l1.addElement(Vodka.getNev() + " " + Vodka.getMennyiseg());
				l2.addElement(Vodka.getAr1());
			}
		});

//Whisky
		JButton btnWhisky = new JButton("Whisky");
		btnWhisky.setBackground(new Color(218, 168, 1));
		btnWhisky.setBounds(500, 600, 100, 100);
		btnWhisky.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnWhisky);	
		Ital Whisky = new Ital("Whisky",700, "700", "4cl");

		btnWhisky.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asztal.getRendeles().add(Whisky);
				l1.addElement(Whisky.getNev() + " " + Whisky.getMennyiseg());
				l2.addElement(Whisky.getAr1());
			}
		});

//J�ger
		JButton btnJager = new JButton("J�ger");
		btnJager.setBackground(new Color(218, 168, 1));
		btnJager.setBounds(600, 700, 100, 100);
		btnJager.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnJager);	
		Ital Jager = new Ital("J�ger",700, "700", "4cl");

		btnJager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asztal.getRendeles().add(Jager);
				l1.addElement(Jager.getNev() + " " + Jager.getMennyiseg());
				l2.addElement(Jager.getAr1());
			}
		});

//Unicum
		JButton btnUnicum = new JButton("Unicum");
		btnUnicum.setBackground(new Color(218, 168, 1));
		btnUnicum.setBounds(600, 600, 100, 100);
		btnUnicum.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnUnicum);	
		Ital Unicum = new Ital("Unicum",700, "700", "4cl");

		btnUnicum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asztal.getRendeles().add(Unicum);
				l1.addElement(Unicum.getNev() + " " + Unicum.getMennyiseg());
				l2.addElement(Unicum.getAr1());
			}
		});

//Gin
		JButton btnGin = new JButton("Gin");
		btnGin.setBackground(new Color(218, 168, 1));
		btnGin.setBounds(700, 600, 100, 100);
		btnGin.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnGin);	
		Ital Gin = new Ital("Gin",700, "700", "4cl");

		btnGin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asztal.getRendeles().add(Gin);
				l1.addElement(Gin.getNev() + " " + Gin.getMennyiseg());
				l2.addElement(Gin.getAr1());
			}
		});
//Coca-Cola
		JButton btnPCoca = new JButton("Coca-Cola");
		btnPCoca.setBackground(new Color(218, 168, 1));
		btnPCoca.setBounds(700, 500, 100,100);
		btnPCoca.setBorder(new LineBorder(Color.BLACK));
				frame.add(btnPCoca);	
		Ital Coca = new Ital("Cola",350, "350", "0,5l");

		btnPCoca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asztal.getRendeles().add(Coca);
				l1.addElement(Coca.getNev() + " " + Coca.getMennyiseg());
				l2.addElement(Coca.getAr1());
			}
		});

//Sprite
		JButton btnSprite = new JButton("Sprite");
		btnSprite.setBackground(new Color(218, 168, 1));
		btnSprite.setBounds(600, 500, 100,100);
		btnSprite.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnSprite);	
		Ital Sprite = new Ital("Sprite",350, "350", "0,5l");

		btnSprite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asztal.getRendeles().add(Sprite);
				l1.addElement(Sprite.getNev() + " " + Sprite.getMennyiseg());
				l2.addElement(Sprite.getAr1());
			}
		});

//Redbull
		JButton btnRedbull = new JButton("Redbull");
		btnRedbull.setBackground(new Color(218, 168, 1));
		btnRedbull.setBounds(700, 400, 100,100);
		btnRedbull.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnRedbull);	
		Ital Redbull = new Ital("Redbull",350, "350", "0,33l");

		btnRedbull.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asztal.getRendeles().add(Redbull);
				l1.addElement(Redbull.getNev() + " " + Redbull.getMennyiseg());
				l2.addElement(Redbull.getAr1());
			}
		});
		
//Tonic
		JButton btnTonic = new JButton("Tonic");
		btnTonic.setBackground(new Color(218, 168, 1));
		btnTonic.setBounds(600, 400, 100,100);
		btnTonic.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnTonic);	
		Ital Tonic = new Ital("Tonic",350, "350", "0,5l");

		btnTonic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asztal.getRendeles().add(Tonic);
				l1.addElement(Tonic.getNev() + " " + Tonic.getMennyiseg());
				l2.addElement(Tonic.getAr1());
			}
		});

		
//Narancs
		JButton btnNarancs = new JButton("Narancs");
		btnNarancs.setBackground(new Color(218, 168, 1));
		btnNarancs.setBounds(700, 300, 100,100);
		btnNarancs.setBorder(new LineBorder(Color.BLACK));
		frame.add(btnNarancs);	
		Ital Narancs = new Ital("Narancs",350, "350", "0,5l");

		btnNarancs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asztal.getRendeles().add(Narancs);
				l1.addElement(Narancs.getNev() + " " + Narancs.getMennyiseg());
				l2.addElement(Narancs.getAr1());
			}
		});
		
		
		frame.setVisible(true);  
	}
	
	public void torles(ArrayList<Ital> lista, String nev, String mennyiseg) {
		for(int i=0;i<lista.size();i++) {
			if(nev.equals(lista.get(i).getNev()) && mennyiseg.equals(lista.get(i).getMennyiseg()) ) {
				lista.remove(i);
				break;
			}
		}
	}
	
	public String osszegfrissites(ArrayList<Ital> lista) {
		Integer sum = 0;
		for(int i =0;i<lista.size();i++) {
			sum = sum + lista.get(i).getAr();
		}
		String osszeg = String.valueOf(sum);
		vegosszeg = Integer.parseInt(osszeg);
		return osszeg;
	}

	
//friss�t�s	
	public void frissites(ArrayList<Ital> lista) {
		for(int i =0;i<lista.size();i++) {
			l1.addElement(lista.get(i).getNev() + " " + lista.get(i).getMennyiseg());
			l2.addElement(lista.get(i).getAr1());
		}
	}
	
	public void kiiras(ArrayList<Ital> lista) throws IOException {
		FileWriter myWriter = new FileWriter(".\\szamla.txt");
		
		for(int i=0;i<lista.size();i++) {
			myWriter.write(lista.get(i).getNev() + "\t-\t");
			myWriter.write(lista.get(i).getMennyiseg() + "\t-\t");
			myWriter.write(lista.get(i).getAr1() + "ft\n"); 
		}
		
		for(int i=0;i<38;i++) 
		{
			myWriter.write("-");
		}
		
		myWriter.write("\n�sszesen:\t\t\t" + vegosszeg + "ft\n");
		myWriter.write("Fizetett:\t\t\t" + kapottpenz + "ft\n");
		myWriter.write("Visszaj�r�:\t\t\t" + visszajaro + "ft\n");
		
		Desktop.getDesktop().open(new File(".\\szamla.txt"));
	    myWriter.close();
	}
}