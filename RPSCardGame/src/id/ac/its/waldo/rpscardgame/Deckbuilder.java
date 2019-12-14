package id.ac.its.waldo.rpscardgame;

import java.awt.Image;
import javax.swing.JTextField;
import java.lang.Integer;
import javax.swing.JOptionPane;
import java.lang.Integer;
import java.text.NumberFormat;
import java.util.Collections;

import javax.swing.text.NumberFormatter;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Deckbuilder extends JPanel {

	public void removeThis(Game frame) {
		frame.remove(this);
	}
	
	public Deckbuilder(Game frame) {
		setLayout(null);
		
		JLabel label_1 = new JLabel();
		ImageIcon rockIcon = new ImageIcon("src/resources/rock.png");
		label_1.setIcon(rockIcon);
		label_1.setBounds(60, 56, 180, 240);
		add(label_1);
		
		JLabel label = new JLabel();
		ImageIcon paperIcon = new ImageIcon("src/resources/paper.png");
		label.setIcon(paperIcon);
		label.setBounds(480, 56, 180, 240);
		add(label);
		
		JLabel label_2 = new JLabel();
		ImageIcon scissorsIcon = new ImageIcon("src/resources/scissors.png");
		label_2.setIcon(scissorsIcon);
		label_2.setBounds(900, 56, 180, 240);
		add(label_2);
		
		NumberFormat format = NumberFormat.getIntegerInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setAllowsInvalid(false);
		formatter.setMinimum(0);
		formatter.setMaximum(30);
		
		JFormattedTextField formattedTextField = new JFormattedTextField(formatter);
		formattedTextField.setValue(0);
		formattedTextField.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField.setBounds(280, 150, 50, 50);
		add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField(formatter);
		formattedTextField_1.setValue(0);
		formattedTextField_1.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_1.setBounds(700, 150, 50, 50);
		add(formattedTextField_1);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField(formatter);
		formattedTextField_2.setValue(0);
		formattedTextField_2.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_2.setBounds(1130, 150, 50, 50);
		add(formattedTextField_2);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.showMainMenu();
				removeThis(frame);
			}
		});
		btnCancel.setBounds(558, 600, 250, 67);
		add(btnCancel);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer r=0,p=0,s=0;
				r=Integer.parseInt(formattedTextField.getText());
				p=Integer.parseInt(formattedTextField_1.getText());
				s=Integer.parseInt(formattedTextField_2.getText());
				if(r+p+s!=30) JOptionPane.showMessageDialog(null,"Deck should contain exactly 30 cards.");
				else {
					for(int k=0;k<r;k++) {
						Card card = new Card(0);
						frame.getDeck().push(card);
					}
					for(int k=0;k<p;k++) {
						Card card = new Card(1);
						frame.getDeck().push(card);
					}
					for(int k=0;k<s;k++) {
						Card card = new Card(2);
						frame.getDeck().push(card);
					}
					Collections.shuffle(frame.getDeck());
					frame.showMainMenu();
					removeThis(frame);
				}
			}
		});
		btnSave.setBounds(558, 500, 250, 67);
		add(btnSave);
	}
}
