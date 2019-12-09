package id.ac.its.waldo.rpscardgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Wildcard extends JPanel {
	
	JButton returnCard1;
	JButton returnCard2;
	int discardedIndex1 = -1;
	int discardedIndex2 = -1;

	public void removeThis(Game frame) {
		frame.remove(this);
	}
	
	public Wildcard(Game frame) {
		setLayout(null);
		
		Stack<Card> deck = frame.getDeck();
		ArrayList<Card> hand = frame.getHand();
		frame.drawCards(1, hand, deck);
		
		ArrayList<JButton> cardSlots = new ArrayList<JButton>();
		for(int k=0;k<7;k++) {
			cardSlots.add(new JButton());
		}
		
		cardSlots.get(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardSlots.get(5).isEnabled()==false) {
					cardSlots.get(5).setEnabled(true);
					returnCard1 = cardSlots.get(0);
					discardedIndex1 = 0;
					cardSlots.get(0).setEnabled(false);
				}
				else if(cardSlots.get(6).isEnabled()==false) {
					cardSlots.get(6).setEnabled(true);
					returnCard2 = cardSlots.get(0);
					discardedIndex2 = 0;
					cardSlots.get(0).setEnabled(false);
				}
			}
		});
		cardSlots.get(0).setBounds(60, 420, 210, 280);
		add(cardSlots.get(0));
		
		cardSlots.get(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardSlots.get(5).isEnabled()==false) {
					cardSlots.get(5).setEnabled(true);
					returnCard1 = cardSlots.get(1);
					discardedIndex1 = 1;
					cardSlots.get(1).setEnabled(false);
				}
				else if(cardSlots.get(6).isEnabled()==false) {
					cardSlots.get(6).setEnabled(true);
					returnCard2 = cardSlots.get(1);
					discardedIndex2 = 1;
					cardSlots.get(1).setEnabled(false);
				}
			}
		});
		cardSlots.get(1).setBounds(320, 420, 210, 280);
		add(cardSlots.get(1));
		
		cardSlots.get(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardSlots.get(5).isEnabled()==false) {
					cardSlots.get(5).setEnabled(true);
					returnCard1 = cardSlots.get(2);
					discardedIndex1 = 2;
					cardSlots.get(2).setEnabled(false);
				}
				else if(cardSlots.get(6).isEnabled()==false) {
					cardSlots.get(6).setEnabled(true);
					returnCard2 = cardSlots.get(2);
					discardedIndex2 = 2;
					cardSlots.get(2).setEnabled(false);
				}
			}
		});
		cardSlots.get(2).setBounds(580, 420, 210, 280);
		add(cardSlots.get(2));
		
		cardSlots.get(3).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardSlots.get(5).isEnabled()==false) {
					cardSlots.get(5).setEnabled(true);
					returnCard1 = cardSlots.get(3);
					discardedIndex1 = 3;
					cardSlots.get(3).setEnabled(false);
				}
				else if(cardSlots.get(6).isEnabled()==false) {
					cardSlots.get(6).setEnabled(true);
					returnCard2 = cardSlots.get(3);
					discardedIndex2 = 3;
					cardSlots.get(3).setEnabled(false);
				}
			}
		});
		cardSlots.get(3).setBounds(840, 420, 210, 280);
		add(cardSlots.get(3));
		
		cardSlots.get(4).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardSlots.get(5).isEnabled()==false) {
					cardSlots.get(5).setEnabled(true);
					returnCard1 = cardSlots.get(4);
					discardedIndex1 = 4;
					cardSlots.get(4).setEnabled(false);
				}
				else if(cardSlots.get(6).isEnabled()==false) {
					cardSlots.get(6).setEnabled(true);
					returnCard2 = cardSlots.get(4);
					discardedIndex2 = 4;
					cardSlots.get(4).setEnabled(false);
				}
			}
		});
		cardSlots.get(4).setBounds(1100, 420, 210, 280);
		add(cardSlots.get(4));
		
		cardSlots.get(5).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnCard1.setEnabled(true);
				discardedIndex1 = -1;
				cardSlots.get(5).setEnabled(false);
			}
		});
		cardSlots.get(5).setEnabled(false);
		cardSlots.get(5).setBounds(320, 60, 210, 280);
		add(cardSlots.get(5));
		
		cardSlots.get(6).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnCard2.setEnabled(true);
				discardedIndex2 = -1;
				cardSlots.get(6).setEnabled(false);
			}
		});
		cardSlots.get(6).setEnabled(false);
		cardSlots.get(6).setBounds(840, 60, 210, 280);
		add(cardSlots.get(6));
		
		JLabel lbl = new JLabel("Wildcard Phase");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setBounds(580, 360, 210, 40);
		add(lbl);
		
		JButton confirm = new JButton("Confirm Discard");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardSlots.get(5).isEnabled()&&cardSlots.get(6).isEnabled()) {
					if(hand.get(discardedIndex1).getType()<4 && hand.get(discardedIndex2).getType()<4) {
						hand.remove(discardedIndex1);
						hand.remove(discardedIndex2);
						Card wildcard = new Card(4);
						hand.add(wildcard);
					}
					else if(hand.get(discardedIndex1).getType()==4 || hand.get(discardedIndex2).getType()==4) {
						JOptionPane.showMessageDialog(null, "Discard 1 wildcard or 2 regular cards.");
					}
				}
				else if(cardSlots.get(5).isEnabled()) {
					if(hand.get(discardedIndex1).getType()==4) {
						hand.remove(discardedIndex1);
						frame.drawCards(2, hand, deck);
					}
					else if(hand.get(discardedIndex1).getType()<4) {
						JOptionPane.showMessageDialog(null, "Discard 1 wildcard or 2 regular cards.");
					}
				}
				frame.getContentPane().add(new PlayCard(frame), "Play Card");
				frame.showPlayCard();
				removeThis(frame);
			}
		});
		confirm.setBounds(1100, 360, 210, 40);
		add(confirm);
	}
}
