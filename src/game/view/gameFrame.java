package game.view;

import javax.swing.JFrame;

import game.view.gamePanel;
import game.controller.gameController;

public class gameFrame extends JFrame
{
	private gamePanel appPanel;
	
	public gameFrame(gameController baseController)
	{
		appPanel = new gamePanel(baseController);
		setupFrame();
		
		
	}
	
/**
 * makes the frame for the game to go into
 */
	private void setupFrame()

	{

		setContentPane(appPanel);

		setLocation(5, 6);

		setSize(400, 400);

		setResizable(false);

		setVisible(true);

	}
}
