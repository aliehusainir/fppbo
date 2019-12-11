package id.ac.its.waldo.rpscardgame;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Mulligan extends JPanel {
	
	public void removeThis(Game frame) {
		frame.remove(this);
	}
	
	public Mulligan(Game frame) {
		setLayout(null);
		
		Stack<Card> deck = frame.getDeck();
		ArrayList<Card> hand = frame.getHand();
		frame.drawCards(5, hand, deck);
		
		Stack<Card> enemyDeck = frame.getEnemyDeck();
		ArrayList<Card> enemyHand = frame.getEnemyHand();
		for(int k=0;k<30;k++) {
			enemyDeck.add(new Card());
		}
		frame.drawCards(5, enemyHand, enemyDeck);
		
		ArrayList<JButton> cardSlots = new ArrayList<JButton>();
		for(int k=0;k<10;k++) {
			cardSlots.add(new JButton());
		}
		
		cardSlots.get(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardSlots.get(5).setEnabled(true);
				cardSlots.get(0).setEnabled(false);
			}
		});
		cardSlots.get(0).setBounds(60, 420, 180, 240);
		add(cardSlots.get(0));
		
		cardSlots.get(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardSlots.get(6).setEnabled(true);
				cardSlots.get(1).setEnabled(false);
			}
		});
		cardSlots.get(1).setBounds(276, 420, 180, 240);
		add(cardSlots.get(1));
		
		cardSlots.get(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardSlots.get(7).setEnabled(true);
				cardSlots.get(2).setEnabled(false);
			}
		});
		cardSlots.get(2).setBounds(492, 420, 180, 240);
		add(cardSlots.get(2));
		
		cardSlots.get(3).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardSlots.get(8).setEnabled(true);
				cardSlots.get(3).setEnabled(false);
			}
		});
		cardSlots.get(3).setBounds(708, 420, 180, 240);
		add(cardSlots.get(3));
		
		cardSlots.get(4).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardSlots.get(9).setEnabled(true);
				cardSlots.get(4).setEnabled(false);
			}
		});
		cardSlots.get(4).setBounds(924, 420, 180, 240);
		add(cardSlots.get(4));
		
		cardSlots.get(5).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardSlots.get(0).setEnabled(true);
				cardSlots.get(5).setEnabled(false);
			}
		});
		cardSlots.get(5).setEnabled(false);
		cardSlots.get(5).setBounds(60, 60, 180, 240);
		add(cardSlots.get(5));
		
		cardSlots.get(6).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardSlots.get(1).setEnabled(true);
				cardSlots.get(6).setEnabled(false);
			}
		});
		cardSlots.get(6).setEnabled(false);
		cardSlots.get(6).setBounds(276, 60, 180, 240);
		add(cardSlots.get(6));
		
		cardSlots.get(7).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardSlots.get(2).setEnabled(true);
				cardSlots.get(7).setEnabled(false);
			}
		});
		cardSlots.get(7).setEnabled(false);
		cardSlots.get(7).setBounds(492, 60, 180, 240);
		add(cardSlots.get(7));
		
		cardSlots.get(8).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardSlots.get(3).setEnabled(true);
				cardSlots.get(8).setEnabled(false);
			}
		});
		cardSlots.get(8).setEnabled(false);
		cardSlots.get(8).setBounds(708, 60, 180, 240);
		add(cardSlots.get(8));
		
		cardSlots.get(9).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardSlots.get(4).setEnabled(true);
				cardSlots.get(9).setEnabled(false);
			}
		});
		cardSlots.get(9).setEnabled(false);
		cardSlots.get(9).setBounds(924, 60, 180, 240);
		add(cardSlots.get(9));
		
//		for(int k=0;k<5;k++) {
//			if(hand.get(k).getType()==0);
//			else if(hand.get(k).getType()==1);
//			else if(hand.get(k).getType()==2);
//		}
		
		JLabel lbl = new JLabel("Mulligan Phase");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setBounds(600, 340, 180, 40);
		add(lbl);
		
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int k=0;k<5;k++) {
					if(cardSlots.get(k+5).isEnabled()) {
						deck.push(hand.remove(k));
						Collections.shuffle(deck);
						hand.add(k, deck.pop());
					}
//					cardSlots.get(k+5).setEnabled(false);
//					cardSlots.get(k).setEnabled(false);
				}
				frame.getContentPane().add(new Wildcard(frame), "Wildcard");
				frame.showWildcard();
				removeThis(frame);
			}
		});
		confirm.setBounds(1140, 340, 180, 40);
		add(confirm);
		
	}
}