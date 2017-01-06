package GameManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HelpState extends GameState{
	
	private BufferedImage bg;

	public HelpState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		GamePanel.resetFPS();
		try {
			bg = ImageIO.read(new File("src/GameManager/question.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		handleInput();
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawImage(bg, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
		
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Calibri", Font.BOLD, 200));
		g.drawString("HELP", 105, 150);
		g.drawString("HELP", 95, 150);
		g.drawString("HELP", 100, 155);
		g.drawString("HELP", 100, 145);
		g.setColor(Color.RED);
		g.drawString("HELP", 100, 150);
		
		
		g.setFont(new Font("Calibri", Font.PLAIN, 13*5));
		g.setColor(Color.BLACK);
		g.drawString("F1 returns you to the main menu.", 11*5, 50*5);
		
		
		g.setFont(new Font("Calibri", Font.PLAIN, 13*5));
		g.setColor(Color.BLACK);
		g.drawString("F1 returns you to the main menu.", 11*5, 50*5);
		
		
		g.drawString("F1 returns you to the main menu.", 9*5, 50*5);
		
		
		g.drawString("F1 returns you to the main menu.", 10*5, 51*5);
		
		
		g.drawString("F1 returns you to the main menu.", 10*5, 49*5);
		

		g.setColor(Color.ORANGE);
		g.drawString("F1 returns you to the main menu.", 10*5, 50*5);
		
		
		
		
		g.setColor(Color.BLACK);
		g.drawString("Turn with the arrow keys.", 9*5, 90*5);
		g.drawString("Avoid 'spikes' and collect 'coins'.", 9*5, 105*5);
		g.drawString("Collecting all coins increases level.", 9*5, 120*5);
		g.drawString("Difficulty raises with level.", 9*5, 135*5);
		
		g.drawString("Turn with the arrow keys.", 9*5, 90*5);
		g.drawString("Avoid 'spikes' and collect 'coins'.", 9*5, 105*5);
		g.drawString("Collecting all coins increases level.", 9*5, 120*5);
		g.drawString("Difficulty raises with level.", 9*5, 135*5);
		
		g.drawString("Turn with the arrow keys.", 10*5, 91*5);
		g.drawString("Avoid 'spikes' and collect 'coins'.", 10*5, 106*5);
		g.drawString("Collecting all coins increases level.", 10*5, 121*5);
		g.drawString("Difficulty raises with level.", 10*5, 136*5);
		
		g.drawString("Turn with the arrow keys.", 10*5, 89*5);
		g.drawString("Avoid 'spikes' and collect 'coins'.", 10*5, 104*5);
		g.drawString("Collecting all coins increases level.", 10*5, 119*5);
		g.drawString("Difficulty raises with level.", 10*5, 134*5);
		
		g.setColor(Color.YELLOW);
		g.drawString("Turn with the arrow keys.", 10*5, 90*5);
		g.drawString("Avoid 'spikes' and collect 'coins'.", 10*5, 105*5);
		g.drawString("Collecting all coins increases level.", 10*5, 120*5);
		g.drawString("Difficulty raises with level.", 10*5, 135*5);
		
		
		
		
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		if (Keys.isPressed(Keys.F1)){
			gsm.setState(GameStateManager.MENU);
		}
	}

}
