package id.ac.its.waldo.rpscardgame;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Mulligan extends JPanel {

	public Mulligan(Game frame) {
		setLayout(null);
		
		Stack<Card> deck = frame.getDeck();
		ArrayList<Card> hand = frame.getHand();
		frame.drawCards(5, hand, deck);
		
		JLabel lblCard = new JLabel("card");
		lblCard.setBounds(163, 383, 48, 14);
		add(lblCard);
		
		JLabel lblCard_1 = new JLabel("card");
		lblCard_1.setBounds(311, 383, 48, 14);
		add(lblCard_1);
		
		JLabel lblCard_2 = new JLabel("card");
		lblCard_2.setBounds(470, 383, 48, 14);
		add(lblCard_2);
		
		JLabel lblCard_3 = new JLabel("card");
		lblCard_3.setBounds(617, 383, 48, 14);
		add(lblCard_3);
		
		JLabel lblCard_4 = new JLabel("card");
		lblCard_4.setBounds(751, 383, 48, 14);
		add(lblCard_4);
		
		ArrayList<JLabel> cardSlots = new ArrayList<JLabel>();
		cardSlots.add(lblCard);
		cardSlots.add(lblCard_1);
		cardSlots.add(lblCard_2);
		cardSlots.add(lblCard_3);
		cardSlots.add(lblCard_4);
		
		for(int k=0;k<5;k++) {
			if(hand.get(k).getType()==0);
			else if(hand.get(k).getType()==1);
			else if(hand.get(k).getType()==2);
		}
	}
}