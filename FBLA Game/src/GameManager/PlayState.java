// The main playing GameState.
/*
 * 
 * 
 * move line around a space while collecting coins and avoiding spikes
 * 
 * 
 */

package GameManager;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;

public class PlayState extends GameState {
	
private Player p;
	public static BufferedImage bg;
	public static int level;
	private int coinsLeft;
	private ArrayList<Rectangle> coinPoints;
	private ArrayList<Rectangle> obstacles;
	private Rectangle phitbox;
	private ArrayList<Point> phitboxPoints;
	private Rectangle noObstacles;
	private static ArrayList<String> facts;
	private int fps = 20;
	private int walktick = 0;
	private int lives = 3;
	private int invulnerableTicks = 0;
	private BufferedImage heart, book, fire, frontview0, frontview1, frontview2, frontview3, backview0, backview1, backview2, backview3, leftview0, leftview1, leftview2, leftview3, leftview4, rightview0, rightview1, rightview2, rightview3, rightview4;
	
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
		// TODO Auto-generated constructor stub
	}
	
	public static String getFact()
	{
		
		return facts.get(level);
		
	}
	

	@Override
	//init() method is basically just a constructor for this. it's just easier to understand because it stands for initialization.
	public void init() {
		// TODO Auto-generated method stub
		
		//IMAGES
		
		
		try {
			
			
			
			book = ImageIO.read(this.getClass().getResource("book.png"));
			fire = ImageIO.read(this.getClass().getResource("fire.png"));
			frontview0 = ImageIO.read(this.getClass().getResource("frontViewCharacter0000.png"));
			frontview1 = ImageIO.read(this.getClass().getResource("frontViewCharacter0001.png"));
			frontview2 = ImageIO.read(this.getClass().getResource("frontViewCharacter0002.png"));
			frontview3 = ImageIO.read(this.getClass().getResource("frontViewCharacter0003.png"));
			backview0 = ImageIO.read(this.getClass().getResource("backViewCharacter0000.png"));
			backview1 = ImageIO.read(this.getClass().getResource("backViewCharacter0001.png"));
			backview2 = ImageIO.read(this.getClass().getResource("backViewCharacter0002.png"));
			backview3 = ImageIO.read(this.getClass().getResource("backViewCharacter0003.png"));
			leftview0 = ImageIO.read(this.getClass().getResource("leftViewCharacter0000.png"));
			leftview1 = ImageIO.read(this.getClass().getResource("leftViewCharacter0001.png"));
			leftview2 = ImageIO.read(this.getClass().getResource("leftViewCharacter0002.png"));
			leftview3 = ImageIO.read(this.getClass().getResource("leftViewCharacter0003.png"));
			leftview4 = ImageIO.read(this.getClass().getResource("leftViewCharacter0004.png"));
			rightview0 = ImageIO.read(this.getClass().getResource("rightViewCharacter0000.png"));
			rightview1 = ImageIO.read(this.getClass().getResource("rightViewCharacter0001.png"));
			rightview2 = ImageIO.read(this.getClass().getResource("rightViewCharacter0002.png"));
			rightview3 = ImageIO.read(this.getClass().getResource("rightViewCharacter0003.png"));
			rightview4 = ImageIO.read(this.getClass().getResource("rightViewCharacter0004.png"));
			
			heart = ImageIO.read(this.getClass().getResource("heart.png"));
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		JukeBox.loop("bgmusic");
		
		level = 0;
		fps = 20;
		GamePanel.setFPS(fps);
		try {
			bg = ImageIO.read(this.getClass().getResource("floor.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p = new Player(GamePanel.WIDTH/2, GamePanel.HEIGHT/2);
		
		obstacles = new ArrayList<Rectangle>();
		noObstacles = new Rectangle((GamePanel.WIDTH/2-GamePanel.WIDTH/12), 0, GamePanel.WIDTH/6, GamePanel.HEIGHT);
		
		coinsLeft = 0;
		coinPoints = new ArrayList<Rectangle>();
		phitbox = new Rectangle(p.getX()-GamePanel.WIDTH/64, p.getY()-GamePanel.HEIGHT/64, GamePanel.WIDTH/32, GamePanel.WIDTH/32);
		phitboxPoints = new ArrayList<Point>();
		
		facts = new ArrayList<String>();
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("randomfacts.txt")));
			
			String s = "";
			while ((s = br.readLine()) != null)
			{
				
				facts.add(s);
				
			}
			
			br.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Collections.shuffle(facts, new Random(System.nanoTime()));
		
		
		
		
		
	}
	
	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		GamePanel.setFPS(fps);
		if (p.getX() >= 0 && p.getY() >= 0 && p.getX() <= GamePanel.WIDTH && p.getY() <= GamePanel.HEIGHT)
		{
			p.move();
		}
		else
		{
			p.rotateRight();
			p.rotateRight();
			p.move();
		}
		
		
		phitbox.setBounds(p.getX(), p.getY(), GamePanel.WIDTH/32, GamePanel.WIDTH/32);
		phitboxPoints.clear();
		for (int x = (int) phitbox.getX(); x <= phitbox.getMaxX(); x++)
		{
			for (int y = (int) phitbox.getY(); y <= phitbox.getMaxY(); y++)
			{
				phitboxPoints.add(new Point(x, y));
			}
		}
		
		
		
		Iterator<Rectangle> it = coinPoints.iterator();
		
		while (it.hasNext())
		{
			
			Rectangle point = it.next();
			
			for (Point p : phitboxPoints)
			{
				if (point.contains(p))
				{
					
					it.remove();
					JukeBox.play("collect");
					break;
				}
				
				
			}
			
		}
		
		for (Rectangle r : obstacles)
		{
			
			for (Point p : phitboxPoints)
			{
				
				if (r.contains(p) && invulnerableTicks == 0)
				{
					lives--;
					JukeBox.play("hurt");
					if (lives == 0){
						JukeBox.stop("bgmusic");
						gsm.setState(GameStateManager.GAMEOVER);
					}
					invulnerableTicks = 14;
				}
				
			}
			
		}
		
		//Test Commit code line
		
		coinsLeft = coinPoints.size();
		
		if (coinsLeft == 0)
		{
			nextLevel();
		}
		
		if (invulnerableTicks > 0)
		{
			invulnerableTicks--;
		}
		
		handleInput();
		
		
	}
	
	public void nextLevel()
	{
		level++;
		
		p.setX(GamePanel.WIDTH/2);
		p.setY(GamePanel.HEIGHT/2);
		p.setDirection("up");
		int i = 0;
		while (i < 10)
		{
			coinPoints.add(new Rectangle(ThreadLocalRandom.current().nextInt(50, GamePanel.WIDTH - 10), ThreadLocalRandom.current().nextInt(50, GamePanel.HEIGHT - 10), 
					GamePanel.WIDTH/64, GamePanel.WIDTH/64));
			i++;
		}
		obstacles.clear();
		i = 0;
		while (i < 15)
		{
			Point point = new Point(ThreadLocalRandom.current().nextInt(10, GamePanel.WIDTH - 10), ThreadLocalRandom.current().nextInt(10, GamePanel.HEIGHT - 10));
			Rectangle r = new Rectangle((int) point.getX(), (int) point.getY(), GamePanel.WIDTH/64, GamePanel.WIDTH/64);
			obstacles.add(r);
			
				
				if (noObstacles.contains(point) || phitbox.contains(point) || coinPoints.contains(point))
				{
					
					obstacles.remove(r);
					
				}
				
				
			
			i++;
		}
		
		for (Iterator<Rectangle> it = obstacles.iterator(); it.hasNext();)
		{
			
			Rectangle r = it.next();
			
			for (Rectangle p : coinPoints)
			{
				
				
				if (r.contains(p))
				{
					
					it.remove();
					
				}
				
			}
			
		}
		
		
		
		
		
		fps += 10;
		JukeBox.play("tilechange");
		gsm.setPaused(true);
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
		g.setColor(Color.BLACK);
		g.drawImage(bg, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
		
		if (lives >= 1)
		{
			
			g.drawImage(heart, 10, 10, 50, 50, null);
			
		}
		if (lives >= 2)
		{
			
			g.drawImage(heart, 65, 10, 50, 50, null);
			
		}
		if (lives == 3)
		{
			
			g.drawImage(heart, 120, 10, 50, 50, null);
			
		}
		
		
		g.setColor(Color.YELLOW);
		
		for (Rectangle point : coinPoints)
		{
			
			
			
			g.drawImage(book, (int) point.getX(), (int) point.getY(), GamePanel.WIDTH/64, GamePanel.HEIGHT/64, null);
			
			
		}
		
		for (Rectangle r : obstacles)
		{
			
			
				g.drawImage(fire, (int) r.getX(), (int) r.getY(), (int) r.getWidth(), (int) r.getHeight(), null);
			
			
			
		}
		
		
		
		
		if (p.getDirection().equals("up"))
		{
			
				if (walktick == 0)
				{
					
					
						g.drawImage(backview0, (int) phitbox.getX(),	(int) phitbox.getY(), (int) phitbox.getWidth(), (int) phitbox.getHeight(), null);
					
					walktick++;
				}
				else if (walktick == 1)
				{
					
					g.drawImage(backview1, (int) phitbox.getX(),	(int) phitbox.getY(), (int) phitbox.getWidth(), (int) phitbox.getHeight(), null);
					walktick++;
				}
				else if (walktick == 2)
				{
					
					g.drawImage(backview2, (int) phitbox.getX(),	(int) phitbox.getY(), (int) phitbox.getWidth(), (int) phitbox.getHeight(), null);
					walktick++;
				}
				else if (walktick == 3)
				{
					
					g.drawImage(backview3, (int) phitbox.getX(),	(int) phitbox.getY(), (int) phitbox.getWidth(), (int) phitbox.getHeight(), null);
					walktick = 0;
				}
			
		}
		
		
		if (p.getDirection().equals("down"))
		{
			if (walktick == 0)
			{
				
				g.drawImage(frontview0, (int) phitbox.getX(),	(int) phitbox.getY(), (int) phitbox.getWidth(), (int) phitbox.getHeight(), null);
				walktick++;
			}
			else if (walktick == 1)
			{
				
				g.drawImage(frontview1, (int) phitbox.getX(),	(int) phitbox.getY(), (int) phitbox.getWidth(), (int) phitbox.getHeight(), null);
				walktick++;
			}
			else if (walktick == 2)
			{
				
				g.drawImage(frontview2, (int) phitbox.getX(),	(int) phitbox.getY(), (int) phitbox.getWidth(), (int) phitbox.getHeight(), null);
				walktick++;
			}
			else if (walktick == 3)
			{
				
				g.drawImage(frontview3, (int) phitbox.getX(),	(int) phitbox.getY(), (int) phitbox.getWidth(), (int) phitbox.getHeight(), null);
				walktick = 0;
			}
			
		}
		
		if (p.getDirection().equals("left"))
		{
			if (walktick == 0)
			{
				
				g.drawImage(leftview0, (int) phitbox.getX(),	(int) phitbox.getY(), (int) phitbox.getWidth(), (int) phitbox.getHeight(), null);
				walktick++;
			}
			else if (walktick == 1)
			{
				
				g.drawImage(leftview1, (int) phitbox.getX(),	(int) phitbox.getY(), (int) phitbox.getWidth(), (int) phitbox.getHeight(), null);
				walktick++;
			}
			else if (walktick == 2)
			{
				
				g.drawImage(leftview2, (int) phitbox.getX(),	(int) phitbox.getY(), (int) phitbox.getWidth(), (int) phitbox.getHeight(), null);
				walktick++;
			}
			else if (walktick == 3)
			{
				
				g.drawImage(leftview3, (int) phitbox.getX(),	(int) phitbox.getY(), (int) phitbox.getWidth(), (int) phitbox.getHeight(), null);
				walktick++;
			}
			else if (walktick == 4)
			{
				
				g.drawImage(leftview4, (int) phitbox.getX(),	(int) phitbox.getY(), (int) phitbox.getWidth(), (int) phitbox.getHeight(), null);
				walktick = 0;
			}
			
		}
		
		if (p.getDirection().equals("right"))
		{
			if (walktick == 0)
			{
				
				g.drawImage(rightview0, (int) phitbox.getX(),	(int) phitbox.getY(), (int) phitbox.getWidth(), (int) phitbox.getHeight(), null);
				walktick++;
			}
			else if (walktick == 1)
			{
				
				g.drawImage(rightview1, (int) phitbox.getX(),	(int) phitbox.getY(), (int) phitbox.getWidth(), (int) phitbox.getHeight(), null);
				walktick++;
			}
			else if (walktick == 2)
			{
				
				g.drawImage(rightview2, (int) phitbox.getX(),	(int) phitbox.getY(), (int) phitbox.getWidth(), (int) phitbox.getHeight(), null);
				walktick++;
			}
			else if (walktick == 3)
			{
				
				g.drawImage(rightview3, (int) phitbox.getX(),	(int) phitbox.getY(), (int) phitbox.getWidth(), (int) phitbox.getHeight(), null);
				walktick++;
			}
			else if (walktick == 4)
			{
				
				g.drawImage(rightview4, (int) phitbox.getX(),	(int) phitbox.getY(), (int) phitbox.getWidth(), (int) phitbox.getHeight(), null);
				walktick = 0;
			}
			
		}
		
	}
	
	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		if (Keys.isPressed(Keys.LEFT)){
			
			p.rotateLeft();
			walktick = 0;
			
		}
		if (Keys.isPressed(Keys.RIGHT)){

			p.rotateRight();
			walktick = 0;
		}
		if (Keys.isPressed(Keys.F1))
		{
			JukeBox.stop("bgmusic");
			JukeBox.play("tilechange");
			gsm.setState(GameStateManager.MENU);
			
		}
			
		
	}
	
	public static int getLevel()
	{
		return level;
	}
	

	
	
}
