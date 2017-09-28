import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class guiGame {

	private JFrame frame;
	//private JLabel healthLabel;
	//private JLabel enemyLabel;
	//private JLabel affectLabel;
	
	boolean gameOver = true;
	int playerHealth = 100;
	int enemyHealth = 100;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiGame window = new guiGame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public guiGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel enemyLabel = new JLabel("Enemy: 100");
		enemyLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		enemyLabel.setBounds(22, 67, 97, 23);
		frame.getContentPane().add(enemyLabel);
		
		JLabel healthLabel = new JLabel("Health: 100");
		healthLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		healthLabel.setBounds(22, 30, 97, 14);
		frame.getContentPane().add(healthLabel);
		
		JLabel affectLabel = new JLabel("");
		affectLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		affectLabel.setBounds(10, 101, 414, 87);
		frame.getContentPane().add(affectLabel);
		
		JButton handsButton = new JButton("Hands");
		JButton knifeButton = new JButton("Knife");
		JButton runButton = new JButton("Run");
		
		// Hands button
		handsButton.setBounds(89, 199, 79, 36);
		frame.getContentPane().add(handsButton);
		handsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random randomGenerator = new Random();
				int rng = randomGenerator.nextInt(100);
				// No affect
				if (rng<=15) { // 0 - 15 (15)
					affectLabel.setText("Creates no affect.");
				// Enemy hits
				}else if (rng<=40) { // 15 - 40 (25)
					affectLabel.setText("Creates no affect. Reduces health by 5.");
					playerHealth = playerHealth - 5;
					healthLabel.setText("Health: "+playerHealth);
					if (playerHealth<=0) {
						affectLabel.setText("You're dead! GAME OVER!");
						
						handsButton.setEnabled(false);
						knifeButton.setEnabled(false);
						runButton.setEnabled(false);
					}
				// Player hits
				}else if (rng<=100) { // 40 - 100 (60)
					affectLabel.setText("HIT! Reduces enemies health by 2.");
					enemyHealth = enemyHealth - 2;
					enemyLabel.setText("Enemy: "+enemyHealth);
					if (enemyHealth<=0) {
						affectLabel.setText("You defeated your enemy, YOU WIN!");
						
						handsButton.setEnabled(false);
						knifeButton.setEnabled(false);
						runButton.setEnabled(false);
					}
				}
			}
		});
		
		// Knife button
		knifeButton.setBounds(171, 199, 79, 36);
		frame.getContentPane().add(knifeButton);
		knifeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random randomGenerator = new Random();
				int rng = randomGenerator.nextInt(100);
				// No affect
				if (rng<=50) { // 0 - 50 (50)
					affectLabel.setText("Creates no affect.");
				// Enemy hits
				}else if (rng<=85) { // 50 - 85 (35)
					affectLabel.setText("Creates no affect. Reduces health by 5.");
					playerHealth = playerHealth - 5;
					healthLabel.setText("Health: "+playerHealth);
					if (playerHealth<=0) {
						affectLabel.setText("You're dead! GAME OVER!");
						
						handsButton.setEnabled(false);
						knifeButton.setEnabled(false);
						runButton.setEnabled(false);
					}
				// Player hits
				}else if (rng<=100) { // 80 - 100 (20)
					affectLabel.setText("HIT! Reduces enemies health by 8.");
					enemyHealth = enemyHealth - 8;
					enemyLabel.setText("Enemy: "+enemyHealth);
					if (enemyHealth<=0) {
						affectLabel.setText("You defeated your enemy, YOU WIN!");
						
						handsButton.setEnabled(false);
						knifeButton.setEnabled(false);
						runButton.setEnabled(false);
					}
				}
			}
		});
		
		// Run button
		runButton.setBounds(254, 199, 79, 36);
		frame.getContentPane().add(runButton);
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random randomGenerator = new Random();
				int rng = randomGenerator.nextInt(100);
				// Player flees fight
				if (rng<=50) { // 0 - 50 (50)
					affectLabel.setText("You run away from the enemy!");
				// Enemy hits
				}else if (rng<=100) { // 80 - 100 (20)
					playerHealth = playerHealth - 100;
					enemyLabel.setText("Player: "+playerHealth);
					if (playerHealth<=0) {
						affectLabel.setText("Well done, you turned around and got stabbed in the back. You fucked up. You are dead!");
						
						handsButton.setEnabled(false);
						knifeButton.setEnabled(false);
						runButton.setEnabled(false);
					}
				}
			}
		});
	}
}
