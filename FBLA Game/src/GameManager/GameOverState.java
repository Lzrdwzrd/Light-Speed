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
		
		int xSegment = GamePanel.WIDTH/16;
		int ySegment = GamePanel.HEIGHT/16;
		
			
		
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
			g.setColor(Color.YELLOW);
			g.setFont(new Font("Calibri", Font.BOLD, GamePanel.HEIGHT/9));
			g.drawString("CONGRATULATIONS!", (3*(xSegment/2) + xSegment/20), 3*ySegment);
			g.drawString("CONGRATULATIONS!", (3*(xSegment/2)- xSegment/20), 3*ySegment);
			g.drawString("CONGRATULATIONS!", 3*(xSegment/2), (3*ySegment + ySegment/30));
			g.drawString("CONGRATULATIONS!", 3*(xSegment/2), (3*ySegment - ySegment/30));
			g.setColor(Color.RED);
			g.drawString("CONGRATULATIONS!", 3*(xSegment/2), 3*ySegment);
		
			g.setFont(new Font("Calibri", Font.PLAIN, GamePanel.HEIGHT/10));
			g.drawString("You reached Level: " + PlayState.getLevel() + "!", 3*xSegment, 5*ySegment);
		
			g.setColor(Color.YELLOW);
			g.setFont(new Font("Calibri", Font.PLAIN, GamePanel.HEIGHT/12));
			g.drawString("Press f1 to return to the menu.", 3*xSegment, 14*ySegment);
			
		
		
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.F1)) {
			gsm.setState(GameStateManager.MENU);
		}
	}
	
}