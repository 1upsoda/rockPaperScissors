package game.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import game.view.gameFrame;
import game.controller.gameController;
//import game.model.Weapon;

public class gamePanel extends JPanel
{
	
	private SpringLayout baseLayout;
	private gameController baseController;
	private JButton btnRock, btnPaper, btnScissors;
	private int wins, losses;
	private int draws;
	private gameFrame appFrame;
	private JTextField answer;
	private JLabel lblWins;
	private JLabel lblDraws;
	private JLabel lblLosses;
	
	/**
	 * sets the game panel up, and puts all the needed things inside
	 * @param baseController
	 */
	public gamePanel(gameController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		btnRock = new JButton("Rock");
		btnRock.setEnabled(true);
		btnPaper = new JButton("Papier");
		btnScissors = new JButton("Schere");
		answer = new JTextField();
		lblWins = new JLabel("Wins: 0");
		lblDraws = new JLabel("Draws: 0");
		lblLosses = new JLabel("Losses: 0");
		wins = 0;
		draws = 0;
		losses = 0;
		setupPanel();
		setupLayout();
		setupListeners();
		
	}


	/**
	 * sets up the things inside the panel
	 */

	private void setupPanel()
	{
		setBackground(Color.YELLOW);
		setLayout(baseLayout);
		answer = new JTextField();
		
		answer.setEditable(false);
		answer.setText("results here");
		add(btnRock);
		add(btnPaper);
		add(btnScissors);
		add(answer);
		add(lblWins);
		add(lblDraws);
		add(lblLosses);
	}
	/**
	 * sets the layouts of all of the buttons, labels and results area
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, btnRock, 31, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, btnRock, -118, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, btnScissors, 0, SpringLayout.NORTH, btnRock);
		baseLayout.putConstraint(SpringLayout.SOUTH, answer, -59, SpringLayout.NORTH, btnPaper);
		baseLayout.putConstraint(SpringLayout.WEST, btnScissors, 6, SpringLayout.EAST, btnPaper);
		baseLayout.putConstraint(SpringLayout.NORTH, btnPaper, 0, SpringLayout.NORTH, btnRock);
		baseLayout.putConstraint(SpringLayout.WEST, btnPaper, 6, SpringLayout.EAST, btnRock);
		baseLayout.putConstraint(SpringLayout.WEST, lblWins, 0, SpringLayout.WEST, btnRock);
		baseLayout.putConstraint(SpringLayout.NORTH, lblDraws, 32, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, lblWins, 0, SpringLayout.NORTH, lblDraws);
		baseLayout.putConstraint(SpringLayout.WEST, lblDraws, 0, SpringLayout.WEST, btnPaper);
		baseLayout.putConstraint(SpringLayout.NORTH, lblLosses, 32, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, lblLosses, 0, SpringLayout.WEST, btnScissors);
		baseLayout.putConstraint(SpringLayout.WEST, answer, -21, SpringLayout.WEST, btnRock);
		baseLayout.putConstraint(SpringLayout.EAST, answer, 379, SpringLayout.WEST, this);
	}
	/**
	 * the buttons that you push to choose what you play as
	 */
	private void setupListeners()
	{
		btnRock.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{	
				/**
				 * the random choice for the computer to choose
				 * 0=rock
				 * 1 = paper
				 * 2= scissors
				 */
				int randomComputerChoice = 0;
				randomComputerChoice = (int) (Math.random() * 3);
				if(randomComputerChoice == 0)
				{
					answer.setText("You chose rock, the computer chose rock, it is a tie");
					draws++;
					answer.setVisible(true);
					lblDraws.setText("Draws: " +draws+ "");
				}
				else if(randomComputerChoice == 1)
				{
					answer.setText("You chose rock, the computer chose paper, you lost");
					answer.setVisible(true);
					losses++;
					lblLosses.setText("Losses: " +losses+ "");
				}
				else if(randomComputerChoice == 2)
				{
					answer.setText("You chose rock, the computer chose scissors, you Won!");
					answer.setVisible(true);
					wins++;
					lblWins.setText("Wins: " +wins+ "");
				}
				
				
			}
		});
		
		btnPaper.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{				
				int randomComputerChoice = 0;
				randomComputerChoice = (int) (Math.random() * 3);
				if(randomComputerChoice == 0)
				{
					answer.setText("You chose paper, the computer chose rock, you Won!");
					wins++;
					answer.setVisible(true);
					lblWins.setText("Wins: " +wins+ "");
				}
				else if(randomComputerChoice == 1)
				{
					answer.setText("You chose paper, the computer chose paper, it is a tie");
					answer.setVisible(true);
					draws++;
					lblDraws.setText("Draws: " +draws+ "");
				}
				else if(randomComputerChoice == 2)
				{
					answer.setText("You chose paper, the computer chose scissors, you lost");
					answer.setVisible(true);
					losses++;
					lblLosses.setText("Losses: " +losses+ "");
				}
			}
		});
		
		btnScissors.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{				
				int randomComputerChoice = 0;
				randomComputerChoice = (int) (Math.random() * 3);
				if(randomComputerChoice == 0)
				{
					answer.setText("You chose scissors, the computer chose rock, you lost");
					losses++;
					answer.setVisible(true);
					lblLosses.setText("Losses: " +losses+ "");
				}
				else if(randomComputerChoice == 1)
				{
					answer.setText("You chose scissors, the computer chose paper, you win!");
					answer.setVisible(true);
					wins++;
					lblWins.setText("Wins: " +wins+ "");
				}
				else if(randomComputerChoice == 2)
				{
					answer.setText("You chose scissors, the computer chose scissors, it is a tie");
					answer.setVisible(true);
					draws++;
					lblDraws.setText("Draws: " +draws+ "");
				}
			}
		});
	}
}
