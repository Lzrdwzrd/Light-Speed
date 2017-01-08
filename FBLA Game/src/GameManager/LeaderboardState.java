package GameManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class LeaderboardState extends GameState
{
	
	public LeaderboardState(GameStateManager gsm) {
		super(gsm);
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public void update() {
		// TODO Auto-generated method stub
		handleInput();
		
	}
	
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		g.setFont(new Font("Calibri", Font.BOLD, 23*5));
		g.setColor(Color.BLACK);
		g.drawString("Leaderboard: ", GamePanel.WIDTH/2-GamePanel.WIDTH/3-2, GamePanel.HEIGHT/8-2);
		g.drawString("Leaderboard: ", GamePanel.WIDTH/2-GamePanel.WIDTH/3, GamePanel.HEIGHT/8-2);
		g.drawString("Leaderboard: ", GamePanel.WIDTH/2-GamePanel.WIDTH/3-2, GamePanel.HEIGHT/8);
		g.drawString("Leaderboard: ", GamePanel.WIDTH/2-GamePanel.WIDTH/3+2, GamePanel.HEIGHT/8-2);
		g.drawString("Leaderboard: ", GamePanel.WIDTH/2-GamePanel.WIDTH/3+2, GamePanel.HEIGHT/8);
		g.drawString("Leaderboard: ", GamePanel.WIDTH/2-GamePanel.WIDTH/3+2, GamePanel.HEIGHT/8+2);
		g.drawString("Leaderboard: ", GamePanel.WIDTH/2-GamePanel.WIDTH/3-2, GamePanel.HEIGHT/8+2);
		g.drawString("Leaderboard: ", GamePanel.WIDTH/2-GamePanel.WIDTH/3, GamePanel.HEIGHT/8);
		g.drawString("Leaderboard: ", GamePanel.WIDTH/2-GamePanel.WIDTH/3, GamePanel.HEIGHT/8+2);
		g.setColor(Color.GREEN);
		g.drawString("Leaderboard: ", GamePanel.WIDTH/2-GamePanel.WIDTH/3, GamePanel.HEIGHT/8);
		
		BufferedReader fr = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("leaderboard.txt")));
		String currentLine;
		g.setFont(new Font("Calibri", Font.ITALIC, 15*5));
		g.setColor(Color.RED);
		try {
			int i = 0;
			while ((currentLine = fr.readLine()) != null) {
				
				g.drawString(currentLine, 10, GamePanel.HEIGHT/8+95+i);
				i+=50;
			}
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public void handleInput() {
		// TODO Auto-generated method stub
		if(Keys.isPressed(Keys.F1)) {
			gsm.setState(GameStateManager.MENU);
		}
	}
	
	
	
}
