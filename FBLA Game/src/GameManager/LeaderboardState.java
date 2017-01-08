package GameManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
public class LeaderboardState extends GameState
{
	
	public LeaderboardState(GameStateManager gsm) {
		super(gsm);
	}
	private File f = null;
	private BufferedReader fr = null;
	private StringBuilder sb = null;
	public void init() {
		// TODO Auto-generated method stub
		f = new File(System.getProperty("user.home") + "\\Light-Speed\\leaderboard.txt");
		if (!f.exists()){
			
			try {
				f.mkdirs();
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		fr = null;
		try {
			fr = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		String currentLine;
		try {
			
			sb = new StringBuilder();
			while ((currentLine = fr.readLine()) != null) {
				
				sb.append(currentLine + System.getProperty("line.separator"));
			}
			fr.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
		
		g.setFont(new Font("Calibri", Font.ITALIC, 15*5));
		g.setColor(Color.RED);
		
		int i = 0;
		int i2 = 0;
		String[] currentLine = sb.toString().split(System.getProperty("line.separator"));
		while (i2 < currentLine.length) 
		{
			
			g.drawString(currentLine[i2], 10, GamePanel.HEIGHT/8+95+i);
			i+=50;
			i2++;
		}
			
		
		
		
		
	}

	public void handleInput() {
		// TODO Auto-generated method stub
		if(Keys.isPressed(Keys.F1)) {
			gsm.setState(GameStateManager.MENU);
		}
	}
	
	
	
}
