// GameState that shows logo.

package GameManager;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class IntroState extends GameState {
	
	private BufferedImage logo;
	
	private int alpha;
	private int ticks;
	
	private final int FADE_IN = 60;
	private final int LENGTH = 60;
	private final int FADE_OUT = 60;
	
	public IntroState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		Game.getWindow().setVisible(false);
		JukeBox.load("mapmove.wav", "mapmove");
		JukeBox.load("MenuMusic.mp3", "MenuMusic");
		JukeBox.load("tilechange.wav", "tilechange");
		JukeBox.load("collect.wav", "collect");
		JukeBox.load("bgmusic.mp3", "bgmusic");
		JukeBox.load("collect.wav", "collect");
		JukeBox.load("menuoption.wav", "menuoption");
		JukeBox.load("hurt.mp3", "hurt");
		ticks = 0;
		try {
			logo = ImageIO.read(this.getClass().getResource("AuthorsLogo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Game.getWindow().setVisible(true);
		JukeBox.play("mapmove");
	}
	
	public void update() {
		handleInput();
		ticks++;
		if(ticks < FADE_IN) {
			alpha = (int) (255 - 255 * (1.0 * ticks / FADE_IN));
			if(alpha < 0) alpha = 0;
		}
		if(ticks > FADE_IN + LENGTH) {
			alpha = (int) (255 * (1.0 * ticks - FADE_IN - LENGTH) / FADE_OUT);
			if(alpha > 255) alpha = 255;
		}
		if(ticks > FADE_IN + LENGTH + FADE_OUT) {
			JukeBox.loop("MenuMusic");
			gsm.setState(GameStateManager.MENU);
		}
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		g.drawImage(logo, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
		g.setColor(new Color(0, 0, 0, alpha));
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.ENTER)) {
			JukeBox.loop("MenuMusic");
			gsm.setState(GameStateManager.MENU);
		}
	}
	
}