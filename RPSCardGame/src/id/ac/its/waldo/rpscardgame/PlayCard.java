package id.ac.its.waldo.rpscardgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PlayCard extends JPanel {
	
	private JButton returnCard;
	private int playedCard = -1;
	private int enemyPlayedCard = -1;
	
	public void removeThis(Game frame) {
		frame.remove(this);
	}
	
	public PlayCard(Game frame) {
		setLayout(null);
		
		ArrayList<Card> hand = frame.getHand();
		ArrayList<Card> enemyHand = frame.getEnemyHand();
		if (!enemyHand.isEmpty()) {
			enemyPlayedCard = new Random().nextInt(enemyHand.size());
		}
		
		ArrayList<JButton> cardSlots = new ArrayList<JButton>();
		for(int k=0;k<7;k++) {
			cardSlots.add(new JButton());
			cardSlots.get(k).setEnabled(false);
		}
		for(int k=0;k<hand.size();k++) {
			cardSlots.get(k).setEnabled(true);
		}
		
		ImageIcon rockIcon = new ImageIcon("src/resources/rock.png");
		ImageIcon paperIcon = new ImageIcon("src/resources/paper.png");
		ImageIcon scissorsIcon = new ImageIcon("src/resources/scissors.png");
		for(int k=0;k<hand.size();k++) {
			if(hand.get(k).getType()==0) {
				cardSlots.get(k).setIcon(rockIcon);
			}
			else if(hand.get(k).getType()==1) {
				cardSlots.get(k).setIcon(paperIcon);
			}
			else if(hand.get(k).getType()==2) {
				cardSlots.get(k).setIcon(scissorsIcon);
			}
		}
		
		cardSlots.get(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardSlots.get(6).isEnabled()==false) {
					cardSlots.get(6).setIcon(cardSlots.get(0).getIcon());
					cardSlots.get(6).setEnabled(true);
					returnCard = cardSlots.get(0);
					playedCard = 0;
					cardSlots.get(0).setEnabled(false);
				}
			}
		});
		cardSlots.get(0).setBounds(60, 420, 180, 240);
		add(cardSlots.get(0));
		
		cardSlots.get(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardSlots.get(6).isEnabled()==false) {
					cardSlots.get(6).setIcon(cardSlots.get(1).getIcon());
					cardSlots.get(6).setEnabled(true);
					returnCard = cardSlots.get(1);
					playedCard = 1;
					cardSlots.get(1).setEnabled(false);
				}
			}
		});
		cardSlots.get(1).setBounds(276, 420, 180, 240);
		add(cardSlots.get(1));
		
		cardSlots.get(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardSlots.get(6).isEnabled()==false) {
					cardSlots.get(6).setIcon(cardSlots.get(2).getIcon());
					cardSlots.get(6).setEnabled(true);
					returnCard = cardSlots.get(2);
					playedCard = 2;
					cardSlots.get(2).setEnabled(false);
				}
			}
		});
		cardSlots.get(2).setBounds(492, 420, 180, 240);
		add(cardSlots.get(2));
		
		cardSlots.get(3).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardSlots.get(6).isEnabled()==false) {
					cardSlots.get(6).setIcon(cardSlots.get(3).getIcon());
					cardSlots.get(6).setEnabled(true);
					returnCard = cardSlots.get(3);
					playedCard = 3;
					cardSlots.get(3).setEnabled(false);
				}
			}
		});
		cardSlots.get(3).setBounds(708, 420, 180, 240);
		add(cardSlots.get(3));
		
		cardSlots.get(4).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardSlots.get(6).isEnabled()==false) {
					cardSlots.get(6).setIcon(cardSlots.get(4).getIcon());
					cardSlots.get(6).setEnabled(true);
					returnCard = cardSlots.get(4);
					playedCard = 4;
					cardSlots.get(4).setEnabled(false);
				}
			}
		});
		cardSlots.get(4).setBounds(924, 420, 180, 240);
		add(cardSlots.get(4));
		
		cardSlots.get(5).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardSlots.get(6).isEnabled()==false) {
					cardSlots.get(6).setIcon(cardSlots.get(5).getIcon());
					cardSlots.get(6).setEnabled(true);
					returnCard = cardSlots.get(5);
					playedCard = 5;
					cardSlots.get(5).setEnabled(false);
				}
			}
		});
		cardSlots.get(5).setBounds(1140, 420, 180, 240);
		add(cardSlots.get(5));
		
		cardSlots.get(6).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardSlots.get(6).setIcon(null);
				returnCard.setEnabled(true);
				playedCard = -1;
				cardSlots.get(6).setEnabled(false);
			}
		});
		cardSlots.get(6).setEnabled(false);
		cardSlots.get(6).setBounds(600, 60, 180, 240);
		add(cardSlots.get(6));
		
		JLabel lbl = new JLabel("Play a card");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setBounds(600, 340, 180, 40);
		add(lbl);
		
		String options[] = {"Rock", "Paper", "Scissors"};
		JComboBox<String> box = new JComboBox<String>(options);
		box.setEditable(true);
		
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardSlots.get(6).isEnabled()) {
					if(hand.get(playedCard).getType()==3) {
						JOptionPane.showMessageDialog(null, box, "Play wildcard as:", JOptionPane.QUESTION_MESSAGE);
						if(box.getSelectedItem()=="Rock") {
							frame.add(new Showdown(frame, 0, enemyHand.get(enemyPlayedCard).getType()), "Showdown");
						}
						else if(box.getSelectedItem()=="Paper") {
							frame.add(new Showdown(frame, 1, enemyHand.get(enemyPlayedCard).getType()), "Showdown");
						}
						else if(box.getSelectedItem()=="Scissors") {
							frame.add(new Showdown(frame, 2, enemyHand.get(enemyPlayedCard).getType()), "Showdown");
							
						}
					}
					else {
						if(hand.get(playedCard).getType()==0) {
							frame.add(new Showdown(frame, 0, enemyHand.get(enemyPlayedCard).getType()), "Showdown");
						}
						else if(hand.get(playedCard).getType()==1) {
							frame.add(new Showdown(frame, 1, enemyHand.get(enemyPlayedCard).getType()), "Showdown");
						}
						else if(hand.get(playedCard).getType()==2) {
							frame.add(new Showdown(frame, 2, enemyHand.get(enemyPlayedCard).getType()), "Showdown");
						}
					}
					hand.remove(playedCard);
					enemyHand.remove(enemyPlayedCard);
					frame.showShowdown();
					removeThis(frame);
				}
				else{
					JOptionPane.showMessageDialog(null, "Choose a card to play.");
				}
			}
		});
		confirm.setBounds(1140, 340, 180, 40);
		add(confirm);
	}

}
