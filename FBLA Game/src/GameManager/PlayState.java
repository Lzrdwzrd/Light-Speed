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
		level = 0;
		fps = 20;
		GamePanel.setFPS(fps);
		try {
			bg = ImageIO.read(this.getClass().getResource("icetexture.jpg"));
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
					break;
				}
				
				
			}
			
		}
		
		for (Rectangle r : obstacles)
		{
			
			for (Point p : phitboxPoints)
			{
				
				if (r.contains(p))
				{
					
					gsm.setState(GameStateManager.GAMEOVER);
					
				}
				
			}
			
		}
		
		//Test Commit code line
		
		coinsLeft = coinPoints.size();
		
		if (coinsLeft == 0)
		{
			nextLevel();
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
		
		gsm.setPaused(true);
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
		g.setColor(Color.BLACK);
		g.drawImage(bg, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
		//TODO: PLAYER DRAWING-- NEEDS ANIMATION
		//TODO
		//TODO
		//TODO
		//TODO
		g.setColor(Color.ORANGE);
		g.fill(phitbox);
		g.setColor(Color.YELLOW);
		
		for (Rectangle point : coinPoints)
		{
			
			g.fillRect((int) (point.getX()), (int) (point.getY()), GamePanel.WIDTH/64, GamePanel.WIDTH/64);
			
		}
		
		for (Rectangle r : obstacles)
		{
			
			g.setColor(Color.RED);
			g.fill(r);
			
		}
		
		
	}
	
	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		if (Keys.isPressed(Keys.LEFT)){
			
			p.rotateLeft();
			
		}
		if (Keys.isPressed(Keys.RIGHT)){

			p.rotateRight();
			
		}
		if (Keys.isPressed(Keys.F1))
		{
			gsm.setState(GameStateManager.MENU);
		}
			
		
	}
	
	public static int getLevel()
	{
		return level;
	}
	

	
	
}
