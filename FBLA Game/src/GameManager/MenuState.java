// The main menu GameState.

/*
 * 
 * 
 * Background is blurry game environment
 * Make cool title/ menu buttons
 * 
 * 
 */

package GameManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MenuState extends GameState {
	
	private BufferedImage bg;
	
	private int currentOption = 0;
	private int tick = 0;
	private int repeats = 0;
	private String[] options = {
		"Start",
		"Help",
		"Quit"
	};
	
	public MenuState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		
		GamePanel.resetFPS();
		try {
			bg = ImageIO.read(new File("src/GameManager/icetextureblurred.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TODO: Jukebox load music, initialize background
		
	}
	
	public void update() {
		
		handleInput();
		if (tick < 20){
			tick++;
		}
		else{
			tick = 0;
			repeats++;
		}
	}
	
	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		g.drawImage(bg, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
		
		if (repeats < 1){
			g.setFont(new Font("Calibri", Font.BOLD, 30*5));
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 0+(tick)*5, 26*5);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 1+(tick+1)*5, 26*5);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 2+(tick+2)*5, 26*5);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 3+(tick+3)*5, 26*5);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 4+(tick+4)*5, 26*5);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 5+(tick+5)*5, 26*5);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 6+(tick+6)*5, 26*5);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 7+(tick+7)*5, 26*5);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 8+(tick+8)*5, 26*5);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 9+(tick+9)*5, 26*5);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 10+(tick+10)*5, 26*5);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 11+(tick+11)*5, 26*5);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 12+(tick+12)*5, 26*5);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 13+(tick+13)*5, 26*5);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 14+(tick+14)*5, 26*5);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 15+(tick+15)*5, 26*5);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 16+(tick+16)*5, 26*5);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 17+(tick+17)*5, 26*5);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 18+(tick+18)*5, 26*5);
			g.setColor(Color.RED);
			g.drawString("Light Speed", 19+(tick+19)*5, 26*5);
		}else{
			g.setFont(new Font("Calibri", Font.BOLD, 30*5));
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 0+(20)*5, 26*5);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 1+(20+1)*5, 26*5);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 2+(20+2)*5, 26*5);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 3+(20+3)*5, 26*5);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 4+(20+4)*5, 26*5);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 5+(20+5)*5, 26*5);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 6+(20+6)*5, 26*5);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 7+(20+7)*5, 26*5);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 8+(20+8)*5, 26*5);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 9+(20+9)*5, 26*5);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 10+(20+10)*5, 26*5);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 11+(20+11)*5, 26*5);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 12+(20+12)*5, 26*5);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 13+(20+13)*5, 26*5);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 14+(20+14)*5, 26*5);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 15+(20+15)*5, 26*5);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 16+(20+16)*5, 26*5);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 17+(20+17)*5, 26*5);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 18+(20+18)*5, 26*5);
			g.setColor(Color.RED);
			g.drawString("Light Speed", 19+(20+19)*5, 26*5);
		}
		
		g.setFont(new Font("Calibri", Font.BOLD, 22*5));
		g.setColor(Color.CYAN);
		g.drawString(options[0], 50*5, 70*5);
		g.setColor(Color.BLUE);
		g.drawString(options[0], 51*5, 70*5);
		
		g.setFont(new Font("Calibri", Font.BOLD, 22*5));
		g.setColor(Color.CYAN);
		g.drawString(options[1], 50*5, 100*5);
		g.setColor(Color.BLUE);
		g.drawString(options[1], 51*5, 100*5);
		
		g.setFont(new Font("Calibri", Font.BOLD, 22*5));
		g.setColor(Color.CYAN);
		g.drawString(options[2], 50*5, 130*5);
		g.setColor(Color.BLUE);
		g.drawString(options[2], 51*5, 130*5);
		
		if (currentOption == 0){
			if (tick < 10){
				g.setColor(Color.BLUE);
				g.fillOval(30*5, 55*5, 10*5, 10*5);
				g.setColor(Color.CYAN);
				g.fillOval(31*5, 56*5, 8*5, 8*5);
			}else{
				g.setColor(Color.CYAN);
				g.fillOval(30*5, 55*5, 10*5, 10*5);
				g.setColor(Color.BLUE);
				g.fillOval(31*5, 56*5, 8*5, 8*5);
			}
			
		}else
		if (currentOption == 1){
			if (tick < 10){
				g.setColor(Color.BLUE);
				g.fillOval(30*5, 85*5, 10*5, 10*5);
				g.setColor(Color.CYAN);
				g.fillOval(31*5, 86*5, 8*5, 8*5);
			}else{
				g.setColor(Color.CYAN);
				g.fillOval(30*5, 85*5, 10*5, 10*5);
				g.setColor(Color.BLUE);
				g.fillOval(31*5, 86*5, 8*5, 8*5);
			}
		}else
		if (currentOption == 2){
			if (tick < 10){
				g.setColor(Color.BLUE);
				g.fillOval(30*5, 115*5, 10*5, 10*5);
				g.setColor(Color.CYAN);
				g.fillOval(31*5, 116*5, 8*5, 8*5);
			}else{
				g.setColor(Color.CYAN);
				g.fillOval(30*5, 115*5, 10*5, 10*5);
				g.setColor(Color.BLUE);
				g.fillOval(31*5, 116*5, 8*5, 8*5);
			}
		}
		
		
		
	}
	
	public void handleInput() {
		if((Keys.isPressed(Keys.DOWN) || Keys.isPressed(Keys.S)) && currentOption < options.length - 1) {
			JukeBox.play("menuoption");
			currentOption++;
		}
		if((Keys.isPressed(Keys.UP) || Keys.isPressed(Keys.W)) && currentOption > 0) {
			JukeBox.play("menuoption");
			currentOption--;
		}
		if(Keys.isPressed(Keys.ENTER) || Keys.isPressed(Keys.SPACE)) {
			JukeBox.play("collect");
			selectOption();
		}
	}
	
	private void selectOption() {
		if(currentOption == 0) {
			gsm.setState(GameStateManager.PLAY);
		}
		if(currentOption == 1) {
			gsm.setState(GameStateManager.HELP);
		}
		if(currentOption == 2) {
			System.exit(0);
		}
	}
	
}
