package id.ac.its.waldo.rpscardgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PlayCard extends JPanel {
	
	private JButton returnCard;
	
	public PlayCard(Game frame) {
		setLayout(null);
		
		ArrayList<Card> hand = frame.getHand();
		
		ArrayList<JButton> cardSlots = new ArrayList<JButton>();
		for(int k=0;k<7;k++) {
			cardSlots.add(new JButton());
//			cardSlots.get(k).setEnabled(false);
		}
		
		cardSlots.get(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardSlots.get(6).isEnabled()==false) {
					cardSlots.get(6).setEnabled(true);
					returnCard = cardSlots.get(0);
					cardSlots.get(0).setEnabled(false);
				}
			}
		});
		cardSlots.get(0).setBounds(60, 420, 210, 280);
		add(cardSlots.get(0));
		
		cardSlots.get(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardSlots.get(6).isEnabled()==false) {
					cardSlots.get(6).setEnabled(true);
					returnCard = cardSlots.get(1);
					cardSlots.get(1).setEnabled(false);
				}
			}
		});
		cardSlots.get(1).setBounds(320, 420, 210, 280);
		add(cardSlots.get(1));
		
		cardSlots.get(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardSlots.get(6).isEnabled()==false) {
					cardSlots.get(6).setEnabled(true);
					returnCard = cardSlots.get(2);
					cardSlots.get(2).setEnabled(false);
				}
			}
		});
		cardSlots.get(2).setBounds(580, 420, 210, 280);
		add(cardSlots.get(2));
		
		cardSlots.get(3).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardSlots.get(6).isEnabled()==false) {
					cardSlots.get(6).setEnabled(true);
					returnCard = cardSlots.get(3);
					cardSlots.get(3).setEnabled(false);
				}
			}
		});
		cardSlots.get(3).setBounds(840, 420, 210, 280);
		add(cardSlots.get(3));
		
		cardSlots.get(4).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardSlots.get(6).isEnabled()==false) {
					cardSlots.get(6).setEnabled(true);
					returnCard = cardSlots.get(4);
					cardSlots.get(4).setEnabled(false);
				}
			}
		});
		cardSlots.get(4).setBounds(1100, 420, 210, 280);
		add(cardSlots.get(4));
		
		cardSlots.get(5).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardSlots.get(6).isEnabled()==false) {
					cardSlots.get(6).setEnabled(true);
					returnCard = cardSlots.get(5);
					cardSlots.get(5).setEnabled(false);
				}
			}
		});
		cardSlots.get(5).setBounds(320, 60, 210, 280);
		add(cardSlots.get(5));
		
		cardSlots.get(6).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnCard.setEnabled(true);
				cardSlots.get(6).setEnabled(false);
			}
		});
		cardSlots.get(6).setEnabled(false);
		cardSlots.get(6).setBounds(840, 60, 210, 280);
		add(cardSlots.get(6));
	}

}
