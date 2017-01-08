// Congratulations for finishing the game.

package GameManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import javax.swing.JOptionPane;

public class GameOverState extends GameState {
	private boolean dataEntered = false;
	public GameOverState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		
		dataEntered = false;
		GamePanel.resetFPS();
		
	}
	
	public void update() 
	{
		if (dataEntered == false)
		{
		String playerName = JOptionPane.showInputDialog("What is your name?");
		if (playerName == null || playerName.equals(""))
		{
			playerName = "Unknown";
		}
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(System.getProperty("user.home") + "\\Light-Speed\\leaderboard.txt")));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HashMap<String, Integer> scores = new HashMap<String, Integer>();
		scores.put(playerName, PlayState.getLevel());
		System.out.println(scores);
		String currentLine;
		try {
			
			while ((currentLine = br.readLine()) != null) 
			{
				String[] currentLineData = currentLine.trim().split(":");
				int score = Integer.parseInt(currentLineData[1].trim());
				
				scores.put(currentLineData[0], score);
				System.out.println(currentLineData);
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ArrayList<Integer> scoreInts = new ArrayList<Integer>();
		int previous = -1;
		int i = 0;
		
		for (int score : scores.values())
		{
			
			if (score >= previous && i >= 0)
			{
				scoreInts.add(i, new Integer(score));
			}else
			{
				scoreInts.add(score);
			}
			previous = score;
			i++;
			
		}
		
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> newScores = new ArrayList<Integer>();
		ArrayList<Integer> alreadyhas = new ArrayList<Integer>();
		for (int it : scoreInts)
		{
			
			if (!alreadyhas.contains(it))
				newScores.add(it);
			alreadyhas.add(it);
			
		}
		for (int score : newScores)
		{
			
			ArrayList<String> keys = getKeysByValue(scores, score);
			
			for (String s : keys)
			{
				
				sb.append(s + ": " + score + System.getProperty("line.separator"));
				
			}
			
			
		}
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(new File(System.getProperty("user.home") + "\\Light-Speed\\leaderboard.txt")));
				bw.write(sb.toString());
				
				
				
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				try{
				      if(bw!=null)
				    	  bw.close();
				   }catch(Exception ex){
				       System.out.println("Error in closing the BufferedWriter"+ex);
				    }
			}
			
		}
		dataEntered = true;
		handleInput();
	}
	public void draw(Graphics2D g) {
		
		int xSegment = GamePanel.WIDTH/16;
		int ySegment = GamePanel.HEIGHT/16;
		
			
			
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
			g.setColor(Color.YELLOW);
			g.setFont(new Font("Calibri", Font.BOLD, GamePanel.HEIGHT/9));
			g.drawString("CONGRATULATIONS!", (3*(xSegment/2) + xSegment/20), 3*ySegment);
			g.drawString("CONGRATULATIONS!", (3*(xSegment/2)- xSegment/20), 3*ySegment);
			g.drawString("CONGRATULATIONS!", 3*(xSegment/2), (3*ySegment + ySegment/30));
			g.drawString("CONGRATULATIONS!", 3*(xSegment/2), (3*ySegment - ySegment/30));
			g.setColor(Color.RED);
			g.drawString("CONGRATULATIONS!", 3*(xSegment/2), 3*ySegment);
		
			g.setFont(new Font("Calibri", Font.PLAIN, GamePanel.HEIGHT/10));
			g.drawString("You reached Level: " + PlayState.getLevel() + "!", 3*xSegment, 5*ySegment);
			
			g.setColor(Color.YELLOW);
			g.setFont(new Font("Calibri", Font.PLAIN, GamePanel.HEIGHT/12));
			g.drawString("Press f1 to return to the menu.", 3*xSegment, 14*ySegment);
			
		
		
	}
	public static <T, E> ArrayList<T> getKeysByValue(Map<T, E> map, E value) {
	    ArrayList<T> keys = new ArrayList<T>();
	    for (Entry<T, E> entry : map.entrySet()) {
	        if (Objects.equals(value, entry.getValue())) {
	            keys.add(entry.getKey());
	        }
	    }
	    return keys;
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.F1) && dataEntered) {
			gsm.setState(GameStateManager.MENU);
		}
	}
	
}