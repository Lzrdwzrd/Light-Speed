// The pause GameState can only be activated
// by calling GameStateManager#setPaused(true).

package GameManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class PauseState extends GameState {
	
	private double tick = 120*10;
	
	public PauseState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() 
	{
		tick = 120*10;
	}
	
	public void update() {
		handleInput();
		GamePanel.setFPS(120);
		if (tick/120.0 <= 0)
		{
			gsm.setPaused(false);
			tick = 120*10;
		}
		else
		{
			tick--;
		}
	}
	
	public void draw(Graphics2D g) {
		
		int xSegment = GamePanel.WIDTH/16;
		int ySegment = GamePanel.HEIGHT/16;
		
		g.setColor(Color.BLACK);
		g.drawImage(PlayState.bg, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
		
		
		g.setFont(new Font("Calibri", Font.BOLD, GamePanel.HEIGHT/6));
		g.setColor(Color.BLACK);
		g.drawString("FACT", (6*xSegment + xSegment/20), 2*ySegment);
		g.setFont(new Font("Calibri", Font.BOLD, GamePanel.HEIGHT/6));
		g.setColor(Color.BLACK);
		g.drawString("FACT", (6*xSegment - xSegment/20), 2*ySegment);
		g.setFont(new Font("Calibri", Font.BOLD, GamePanel.HEIGHT/6));
		g.setColor(Color.BLACK);
		g.drawString("FACT", 6*xSegment, (2*ySegment + ySegment/30));
		g.setFont(new Font("Calibri", Font.BOLD, GamePanel.HEIGHT/6));
		g.setColor(Color.BLACK);
		g.drawString("FACT", 6*xSegment, (2*ySegment - ySegment/30));
		g.setFont(new Font("Calibri", Font.BOLD, GamePanel.HEIGHT/6));
		g.setColor(Color.YELLOW);
		g.drawString("FACT", 6*xSegment, 2*ySegment);
		
		String fact = PlayState.getFact();
		int length = fact.length();
		
		g.setFont(new Font("Calibri", Font.PLAIN, GamePanel.HEIGHT/16));
		g.setColor(Color.CYAN);

		if (length > 342){
			g.drawString(fact.substring(304, 342), 2*xSegment, 12*ySegment);
			
		}
		if (length > 304){
			g.drawString(fact.substring(266, 304), 2*xSegment, 11*ySegment);
			
		}
		if (length > 266){
			g.drawString(fact.substring(228, 266), 2*xSegment, 10*ySegment);
			
		}
		if (length > 228){
			g.drawString(fact.substring(190, 228), 2*xSegment, 9*ySegment);
			
		}
		if (length > 190){
			g.drawString(fact.substring(152, 190), 2*xSegment, 8*ySegment);
			
		}
		if (length > 152){
			g.drawString(fact.substring(114, 152), 2*xSegment, 7*ySegment);
			
		}
		if (length > 114){
			g.drawString(fact.substring(76, 114), 2*xSegment, 6*ySegment);
			
		}
		if (length > 76){
			g.drawString(fact.substring(38, 76), 2*xSegment, 5*ySegment);
			
		}
		if (length > 38){
			g.drawString(fact.substring(0, 38), 2*xSegment, 4*ySegment);
		}
		
		
		
		
		
		
		
		
		
		
		if (length <= 76){g.drawString(fact.substring(38, length-1), 2*xSegment, 5*ySegment);}
		else if (length <= 114){g.drawString(fact.substring(76, length-1), 2*xSegment, 6*ySegment);}
		else if (length <= 152){g.drawString(fact.substring(114, length-1), 2*xSegment, 7*ySegment);}
		else if (length <= 190){g.drawString(fact.substring(152, length-1), 2*xSegment, 8*ySegment);}
		else if (length <= 228){g.drawString(fact.substring(190, length-1), 2*xSegment, 9*ySegment);}
		else if (length <= 266){g.drawString(fact.substring(228, length-1), 2*xSegment, 10*ySegment);}
		else if (length <= 304){g.drawString(fact.substring(266, length-1), 2*xSegment, 11*ySegment);}
		else if (length <= 342){g.drawString(fact.substring(304, length-1), 2*xSegment, 12*ySegment);}
		
		
		g.setColor(Color.RED);
		g.drawString(""+Math.round(tick/120.0), 5, 130);
		
	}
	public void handleInput() {}
	
}
