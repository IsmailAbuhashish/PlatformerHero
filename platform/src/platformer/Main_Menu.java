package platformer;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

//Ismail, Faris, Nadeem
//Date: 21/3/2021
public class Main_Menu implements ActionListener, ItemListener {
	JTextArea h,w; int i;
	JLabel x;
	JButton btn;
	JCheckBox checkbox1;
	int width, height;
	boolean checked = false;
	JFrame frame = new JFrame("Main_Menu");
	JComboBox dropdown;
	String[] levellist = {"Level 1","Level 2","Level 3","Level 4","Level 5"};
	public Main_Menu() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(460, 500);
		frame.setLocation(430, 100);
		dropdown = new JComboBox(levellist);
		frame.add(dropdown);
		JPanel panel = new JPanel();
		panel.setLayout(null); 
		frame.add(panel);
		h = new JTextArea("1080");
		h.setBounds(160, 150, 50, 30);
		h.setEditable(true);
		h.setBackground(Color.white);
		x = new JLabel("x");
		x.setBounds(215, 160, 15, 15);
		w = new JTextArea("1920");
		w.setBounds(227, 150, 50, 30);
		w.setEditable(true);
		w.setBackground(Color.white);
		checkbox1 = new JCheckBox("Fullscreen");    
		checkbox1.setBounds(180,200, 100,50);
		btn = new JButton("OK");
		btn.setBounds(175,250,100,30);
		dropdown.setBounds(175,300,100,30);
		btn.addActionListener(this);
		checkbox1.addItemListener(this);
		panel.add(checkbox1);
		panel.add(h);
		panel.add(x);
		panel.add(w);
		panel.add(btn);
		frame.setVisible(true);
	}
	public void actionPerformed (ActionEvent e) {	

		if(!checked) {
			width = Integer.parseInt(w.getText());
			height = Integer.parseInt(h.getText());
			switch (dropdown.getSelectedIndex() + 1) {
			case 1:	
				new Main(new Levels().firstLevel(),20,20,width,height);
				break;
			case 2:	
				new Main(new Levels().secondLevel(),20,20,width,height);
				break;
			case 3:	
				new Main(new Levels().thirdLevel(),20,20,width,height);
				break;
			case 4:	
				new Main(new Levels().fourthLevel(),20,20,width,height);
				break;
			case 5:	
				break;
			}

			frame.setVisible(false);
			frame.dispose();

		}
		else {
			switch (dropdown.getSelectedIndex() + 1) {
			case 1:	
				new Main(new Levels().firstLevel(),20,20);
				break;
			case 2:
				new Main(new Levels().secondLevel(),20,20);
				break;
			case 3:
				new Main(new Levels().thirdLevel(),20,20);
				break;
			case 4:
				new Main(new Levels().fourthLevel(),20,20);
				break;
			case 5:
				break;
			}
		frame.setVisible(false);
		frame.dispose();
		}
	}

	public static void main(String[] args) {
		new Main_Menu();

	}

	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == 1) {
			checked = true;
			h.setEditable(false);
			h.setBackground(Color.LIGHT_GRAY);
			w.setEditable(false);
			w.setBackground(Color.LIGHT_GRAY);
		}
		else {
			checked = false;
			h.setEditable(true);
			h.setBackground(Color.white);
			w.setEditable(true);
			w.setBackground(Color.white);
		}
	}

}