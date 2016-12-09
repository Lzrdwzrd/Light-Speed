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
		g.drawImage(bg, 0, 0, 230, 190, null);
		
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Calibri", Font.BOLD, 30));
		g.drawString("HELP", 21, 30);
		g.drawString("HELP", 19, 30);
		g.drawString("HELP", 20, 31);
		g.drawString("HELP", 20, 29);
		g.setColor(Color.RED);
		g.drawString("HELP", 20, 30);
		
		
		g.setFont(new Font("Calibri", Font.PLAIN, 13));
		g.setColor(Color.BLACK);
		g.drawString("F1 returns you to the main menu.", 11, 50);
		
		
		g.setFont(new Font("Calibri", Font.PLAIN, 13));
		g.setColor(Color.BLACK);
		g.drawString("F1 returns you to the main menu.", 11, 50);
		g.drawString("Escape pauses the game.", 11, 65);
		
		g.drawString("F1 returns you to the main menu.", 9, 50);
		g.drawString("Escape pauses the game.", 9, 65);
		
		g.drawString("F1 returns you to the main menu.", 10, 51);
		g.drawString("Escape pauses the game.", 10, 66);
		
		g.drawString("F1 returns you to the main menu.", 10, 49);
		g.drawString("Escape pauses the game.", 10, 64);

		g.setColor(Color.ORANGE);
		g.drawString("F1 returns you to the main menu.", 10, 50);
		g.drawString("Escape pauses the game.", 10, 65);
		
		
		
		g.setColor(Color.BLACK);
		g.drawString("Turn with the arrow keys.", 10-1, 90);
		g.drawString("Avoid 'spikes' and collect 'coins'.", 10-1, 105);
		g.drawString("Collecting all coins increases level.", 10-1, 120);
		g.drawString("Difficulty raises with level.", 10-1, 135);
		
		g.drawString("Turn with the arrow keys.", 10+1, 90);
		g.drawString("Avoid 'spikes' and collect 'coins'.", 10+1, 105);
		g.drawString("Collecting all coins increases level.", 10+1, 120);
		g.drawString("Difficulty raises with level.", 10+1, 135);
		
		g.drawString("Turn with the arrow keys.", 10, 90+1);
		g.drawString("Avoid 'spikes' and collect 'coins'.", 10, 105+1);
		g.drawString("Collecting all coins increases level.", 10, 120+1);
		g.drawString("Difficulty raises with level.", 10, 135+1);
		
		g.drawString("Turn with the arrow keys.", 10, 90-1);
		g.drawString("Avoid 'spikes' and collect 'coins'.", 10, 105-1);
		g.drawString("Collecting all coins increases level.", 10, 120-1);
		g.drawString("Difficulty raises with level.", 10, 135-1);
		
		g.setColor(Color.YELLOW);
		g.drawString("Turn with the arrow keys.", 10, 90);
		g.drawString("Avoid 'spikes' and collect 'coins'.", 10, 105);
		g.drawString("Collecting all coins increases level.", 10, 120);
		g.drawString("Difficulty raises with level.", 10, 135);
		
		
		
		
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		if (Keys.isPressed(Keys.F1)){
			gsm.setState(GameStateManager.MENU);
		}
	}

}
