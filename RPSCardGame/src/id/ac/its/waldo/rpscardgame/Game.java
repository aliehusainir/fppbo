package id.ac.its.waldo.rpscardgame;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

public class Game extends JFrame {

	private JPanel contentPane;
	private Stack<Card> deck;
	private ArrayList<Card> hand;
//	private int rock = 0;
//	private int paper = 0;
//	private int scissors = 0;
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
		deck = new Stack<Card>();
		hand = new ArrayList<Card>();
		cardLayout = new CardLayout();
		contentPane = new JPanel();
		contentPane.setLayout(cardLayout);
		contentPane.add(new MainMenu(this), "Main Menu");
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
	
	public void showMulligan() {
		cardLayout.show(contentPane, "Mulligan");
	}
	
	public void showWildcard() {
		cardLayout.show(contentPane, "Wildcard");
	}
	
	public void showPlayCard() {
		
	}
	
	public void showShowdown() {
		
	}
	
	public Stack<Card> getDeck(){
		return deck;
	}
	
	public ArrayList<Card> getHand(){
		return hand;
	}

	public void drawCards(int n, ArrayList<Card> hand, Stack<Card> deck) {
		for(int k=0;k<n;k++) {
			hand.add(deck.pop());
		}
	}
}
