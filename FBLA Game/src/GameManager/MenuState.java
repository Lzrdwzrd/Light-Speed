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
		g.fillRect(0, 0, 1920/GamePanel.SCALE, 1080/GamePanel.SCALE);
		g.drawImage(bg, 0, 0, 250, 180, null);
		
		if (repeats < 1){
			g.setFont(new Font("Calibri", Font.BOLD, 30));
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 0+(tick), 26);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 1+(tick+1), 26);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 2+(tick+2), 26);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 3+(tick+3), 26);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 4+(tick+4), 26);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 5+(tick+5), 26);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 6+(tick+6), 26);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 7+(tick+7), 26);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 8+(tick+8), 26);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 9+(tick+9), 26);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 10+(tick+10), 26);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 11+(tick+11), 26);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 12+(tick+12), 26);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 13+(tick+13), 26);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 14+(tick+14), 26);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 15+(tick+15), 26);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 16+(tick+16), 26);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 17+(tick+17), 26);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 18+(tick+18), 26);
			g.setColor(Color.RED);
			g.drawString("Light Speed", 19+(tick+19), 26);
		}else{
			g.setFont(new Font("Calibri", Font.BOLD, 30));
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 0+(20), 26);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 1+(20+1), 26);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 2+(20+2), 26);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 3+(20+3), 26);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 4+(20+4), 26);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 5+(20+5), 26);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 6+(20+6), 26);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 7+(20+7), 26);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 8+(20+8), 26);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 9+(20+9), 26);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 10+(20+10), 26);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 11+(20+11), 26);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 12+(20+12), 26);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 13+(20+13), 26);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 14+(20+14), 26);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 15+(20+15), 26);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 16+(20+16), 26);
			g.setColor(Color.ORANGE);
			g.drawString("Light Speed", 17+(20+17), 26);
			g.setColor(Color.YELLOW);
			g.drawString("Light Speed", 18+(20+18), 26);
			g.setColor(Color.RED);
			g.drawString("Light Speed", 19+(20+19), 26);
		}
		
		g.setFont(new Font("Calibri", Font.BOLD, 22));
		g.setColor(Color.CYAN);
		g.drawString(options[0], 50, 70);
		g.setColor(Color.BLUE);
		g.drawString(options[0], 51, 70);
		
		g.setFont(new Font("Calibri", Font.BOLD, 22));
		g.setColor(Color.CYAN);
		g.drawString(options[1], 50, 100);
		g.setColor(Color.BLUE);
		g.drawString(options[1], 51, 100);
		
		g.setFont(new Font("Calibri", Font.BOLD, 22));
		g.setColor(Color.CYAN);
		g.drawString(options[2], 50, 130);
		g.setColor(Color.BLUE);
		g.drawString(options[2], 51, 130);
		
		if (currentOption == 0){
			if (tick < 10){
				g.setColor(Color.BLUE);
				g.fillOval(30, 55, 10, 10);
				g.setColor(Color.CYAN);
				g.fillOval(31, 56, 8, 8);
			}else{
				g.setColor(Color.CYAN);
				g.fillOval(30, 55, 10, 10);
				g.setColor(Color.BLUE);
				g.fillOval(31, 56, 8, 8);
			}
			
		}else
		if (currentOption == 1){
			if (tick < 10){
				g.setColor(Color.BLUE);
				g.fillOval(30, 85, 10, 10);
				g.setColor(Color.CYAN);
				g.fillOval(31, 86, 8, 8);
			}else{
				g.setColor(Color.CYAN);
				g.fillOval(30, 85, 10, 10);
				g.setColor(Color.BLUE);
				g.fillOval(31, 86, 8, 8);
			}
		}else
		if (currentOption == 2){
			if (tick < 10){
				g.setColor(Color.BLUE);
				g.fillOval(30, 115, 10, 10);
				g.setColor(Color.CYAN);
				g.fillOval(31, 116, 8, 8);
			}else{
				g.setColor(Color.CYAN);
				g.fillOval(30, 115, 10, 10);
				g.setColor(Color.BLUE);
				g.fillOval(31, 116, 8, 8);
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
