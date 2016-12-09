// Congratulations for finishing the game.
// Gives you a rank based on how long it took
// you to beat the game.

// Under two minutes = Speed Demon
// Under three minutes = Adventurer
// Under four minutes = Beginner
// Four minutes or greater = Bumbling Idiot

package GameManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class GameOverState extends GameState {
	
	public GameOverState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		
		GamePanel.resetFPS();
		
	}
	
	public void update() 
	{
		handleInput();
	}
	
	public void draw(Graphics2D g) {
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Calibri", Font.BOLD, 30));
		g.drawString("Game Over", 21, 30);
		g.drawString("Game Over", 19, 30);
		g.drawString("Game Over", 20, 31);
		g.drawString("Game Over", 20, 29);
		g.setColor(Color.RED);
		g.drawString("Game Over", 20, 30);
		
		g.setFont(new Font("Calibri", Font.PLAIN, 13));
		g.drawString("Highest level reached: " + PlayState.getLevel(), 15, 60);
		
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Calibri", Font.PLAIN, 13));
		g.drawString("Press f1 to return to the menu.", 13, 80);
		
		
		
		
		
		
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.F1)) {
			gsm.setState(GameStateManager.MENU);
		}
	}
	
}