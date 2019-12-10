package id.ac.its.waldo.rpscardgame;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;

public class Showdown extends JPanel {
	
	public void removeThis(Game frame) {
		frame.remove(this);
	}
	
	public Showdown(Game frame, int yourCard, int enemyCard) {
		setLayout(null);
		
		JButton card = new JButton("");
		card.setEnabled(false);
		card.setBounds(600, 60, 180, 240);
		add(card);
		
		JButton card_1 = new JButton("");
		card_1.setEnabled(false);
		card_1.setBounds(600, 420, 180, 240);
		add(card_1);
		
		JButton nextRound = new JButton("Next Round");
		nextRound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().add(new Wildcard(frame), "Wildcard");
				frame.showWildcard();
				removeThis(frame);
			}
		});
		nextRound.setVisible(false);
		nextRound.setBounds(1140, 340, 180, 40);
		add(nextRound);
		
		JLabel lbl = new JLabel();
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setBounds(1140, 140, 180, 40);
		lbl.setVisible(false);
		add(lbl);
		JLabel lbl2 = new JLabel();
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setBounds(1140, 180, 180, 40);
		lbl2.setVisible(false);
		add(lbl2);
		
		JButton flip = new JButton("Flip!");
		flip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ganti icon, tapi belum ada
				//tie
				if(yourCard == enemyCard) {
					//do nothing
				}
				//win condition
				else if((yourCard == 0) && (enemyCard == 2) || (yourCard > 0) && (enemyCard == yourCard-1)) {
					frame.updateWin();
				}
				//lose
				else {
					frame.updateLose();
				}
				lbl.setText("Score:");
				lbl2.setText("You " + frame.getYourScore() + "-" + frame.getEnemyScore() + " Opponent");
				lbl.setVisible(true);
				lbl2.setVisible(true);
				flip.setVisible(false);
				if(frame.getYourScore() == 10) {
//					lbl3.setVisible(true);
//					toMainMenu.setVisible(true);
//					quit.setVisible(true);
				}
				else if(frame.getEnemyScore() == 10) {
//					lbl4.setVisible(true);
//					toMainMenu.setVisible(true);
//					quit.setVisible(true);
				}
				else{
					nextRound.setVisible(true);
				}
			}
		});
		flip.setBounds(600, 340, 180, 40);
		add(flip);
		
	}
}
