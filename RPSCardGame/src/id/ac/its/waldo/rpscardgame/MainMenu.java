package id.ac.its.waldo.rpscardgame;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainMenu extends JPanel {
	
	public MainMenu(Game frame) {
		setLayout(null);
		
		JButton btnDeckbuilder = new JButton("Deckbuilder");
		btnDeckbuilder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.showDeckbuilder();
			}
		});
		btnDeckbuilder.setBounds(558, 451, 250, 67);
		add(btnDeckbuilder);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setBounds(558, 351, 250, 67);
		add(btnPlay);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuit.setBounds(558, 651, 250, 67);
		add(btnQuit);
		
		JButton btnRules = new JButton("Rules");
		btnRules.setBounds(558, 551, 250, 67);
		add(btnRules);
		
		JLabel label = new JLabel("");
		label.setBounds(358, 64, 650, 254);
		add(label);

	}
}
