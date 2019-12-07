package id.ac.its.waldo.rpscardgame;

import java.util.Stack;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

public class Game extends JFrame {

	private JPanel contentPane;
	private Stack<Card> Deck;
	private CardLayout cardLayout;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game frame = new Game();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Game() {
		setTitle("RPS Card Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-10, -3, 1382, 778);
		Deck = new Stack<Card>();
		cardLayout = new CardLayout();
		contentPane = new JPanel();
		contentPane.setLayout(cardLayout);
		contentPane.add(new MainMenu(this), "Main Menu");
		contentPane.add(new Deckbuilder(this), "Deckbuilder");
		setContentPane(contentPane);
	}
	
	public void showMainMenu() {
		cardLayout.show(contentPane, "Main Menu");
	}
	
	public void showDeckbuilder() {
		cardLayout.show(contentPane, "Deckbuilder");
	}
	
	public void showRules() {
		
	}
	
	public void showMatch() {
		
	}
	
	public void pushDeck(Card card) {
		Deck.push(card);
	}
}
