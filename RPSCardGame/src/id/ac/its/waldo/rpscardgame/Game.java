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
	private Stack<Card> enemyDeck;
	private ArrayList<Card> hand;
	private ArrayList<Card> enemyHand;
	private CardLayout cardLayout;
	private int yourScore = 0;
	private int enemyScore = 0;

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
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-10, -3, 1382, 778);
		deck = new Stack<Card>();
		hand = new ArrayList<Card>();
		enemyDeck = new Stack<Card>();
		enemyHand = new ArrayList<Card>();
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
		cardLayout.show(contentPane, "Play Card");
	}
	
	public void showShowdown() {
		cardLayout.show(contentPane, "Showdown");
	}
	
	public Stack<Card> getDeck(){
		return deck;
	}
	
	public ArrayList<Card> getHand(){
		return hand;
	}
	
	public Stack<Card> getEnemyDeck(){
		return enemyDeck;
	}
	
	public ArrayList<Card> getEnemyHand(){
		return enemyHand;
	}

	public void updateWin() {
		yourScore++;
	}
	
	public void updateLose() {
		enemyScore++;
	}
	
	public int getYourScore() {
		return yourScore;
	}
	
	public int getEnemyScore() {
		return enemyScore;
	}
	
	public void resetHand() {
		hand.clear();
		enemyHand.clear();
	}
	
	public void resetScore() {
		yourScore = 0;
		enemyScore = 0;
	}
	
	public void drawCards(int n, ArrayList<Card> hand, Stack<Card> deck) {
		for(int k=0;k<n;k++) {
			hand.add(deck.pop());
		}
	}
}
