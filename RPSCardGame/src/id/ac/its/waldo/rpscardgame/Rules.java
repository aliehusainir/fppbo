package id.ac.its.waldo.rpscardgame;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Rules extends JPanel {

	public void removeThis(Game frame) {
		frame.remove(this);
	}
	
	public Rules(Game frame) {
		setLayout(null);
		
		JTextArea txtrRockPaperScissors = new JTextArea();
		txtrRockPaperScissors.setBackground(UIManager.getColor("Button.background"));
		txtrRockPaperScissors.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		txtrRockPaperScissors.setText("Rock, Paper, Scissors Card Game\r\n\r\n\r\n"
				+ "How to Play:\r\n\r\n\r\n"
				+ "Deckbuilding: Before you play, build a deck containing exactly 30 cards of any \r\n"
				+ "combination of Rock, Paper, and Scissors card.\r\n\r\n\r\n"
				+ "Opening Hand: At the beginning of the game, each player draws 5 cards from their deck \r\n"
				+ "for the opening hand.\r\n\r\n\r\n"
				+ "Mulligan Phase: Each player may return any number of cards from their opening hand, \r\n"
				+ "shuffle their deck, and draw the same amount of cards. This process may only be \r\n"
				+ "performed once.\r\n\r\n\r\n"
				+ "Wildcard Phase: Each player may discard any 2 regular cards and put a wildcard into their \r\n"
				+ "hand, or discard a wildcard and draw 2 cards from their deck.\r\n\r\n\r\n"
				+ "Play Phase: Each player whose hand is not empty must put a card face down from their \r\n"
				+ "hand. If a player plays a wildcard, they may choose to play it as Rock, Paper, or Scissors.\r\n\r\n\r\n"
				+ "Showdown Phase: Both players flip their cards at the same time, the player who wins the \r\n"
				+ "showdown gains a point. Then, go back to Wildcard Phase. The game ends when one \r\n"
				+ "player reaches 10 points. In the case of both players running out of cards, the game may \r\n"
				+ "result in a draw.");
		txtrRockPaperScissors.setBounds(347, 11, 777, 655);
		add(txtrRockPaperScissors);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.showMainMenu();
				removeThis(frame);
			}
		});
		btnNewButton.setBounds(596, 698, 180, 40);
		add(btnNewButton);
		
	}
}
