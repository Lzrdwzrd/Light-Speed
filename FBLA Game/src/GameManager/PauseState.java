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
		
		g.setColor(Color.BLACK);
		g.drawImage(PlayState.bg, 0, 0, 250, 180, null);
		
		
		g.setFont(new Font("Calibri", Font.BOLD, 30));
		g.setColor(Color.BLACK);
		g.drawString("FACT", 51, 20);
		g.setFont(new Font("Calibri", Font.BOLD, 30));
		g.setColor(Color.BLACK);
		g.drawString("FACT", 49, 20);
		g.setFont(new Font("Calibri", Font.BOLD, 30));
		g.setColor(Color.BLACK);
		g.drawString("FACT", 50, 21);
		g.setFont(new Font("Calibri", Font.BOLD, 30));
		g.setColor(Color.BLACK);
		g.drawString("FACT", 50, 19);
		g.setFont(new Font("Calibri", Font.BOLD, 30));
		g.setColor(Color.YELLOW);
		g.drawString("FACT", 50, 20);
		
		String fact = PlayState.getFact();
		int length = fact.length();
		
		g.setFont(new Font("Calibri", Font.PLAIN, 11));
		g.setColor(Color.CYAN);
		if (length > 342){
			g.drawString(fact.substring(304, 342), 5, 115);
			
		}
		if (length > 304){
			g.drawString(fact.substring(266, 304), 5, 105);
			
		}
		if (length > 266){
			g.drawString(fact.substring(228, 266), 5, 95);
			
		}
		if (length > 228){
			g.drawString(fact.substring(190, 228), 5, 85);
			
		}
		if (length > 190){
			g.drawString(fact.substring(152, 190), 5, 75);
			
		}
		if (length > 152){
			g.drawString(fact.substring(114, 152), 5, 65);
			
		}
		if (length > 114){
			g.drawString(fact.substring(76, 114), 5, 55);
			
		}
		if (length > 76){
			g.drawString(fact.substring(38, 76), 5, 45);
			
		}
		if (length > 38){
			g.drawString(fact.substring(0, 38), 5, 35);
		}
		
		
		
		
		
		
		
		
		
		
		if (length <= 76){g.drawString(fact.substring(38, length-1), 5, 45);}
		else if (length <= 114){g.drawString(fact.substring(76, length-1), 5, 55);}
		else if (length <= 152){g.drawString(fact.substring(114, length-1), 5, 65);}
		else if (length <= 190){g.drawString(fact.substring(152, length-1), 5, 75);}
		else if (length <= 228){g.drawString(fact.substring(190, length-1), 5, 85);}
		else if (length <= 266){g.drawString(fact.substring(228, length-1), 5, 95);}
		else if (length <= 304){g.drawString(fact.substring(266, length-1), 5, 105);}
		else if (length <= 342){g.drawString(fact.substring(304, length-1), 5, 115);}
		
		
		g.setColor(Color.RED);
		g.drawString(""+Math.round(tick/120.0), 5, 130);
		
	}
	public void handleInput() {}
	
}
