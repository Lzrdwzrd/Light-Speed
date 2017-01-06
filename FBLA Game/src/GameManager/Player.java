package GameManager;

import java.awt.Shape;

public class Player
{
	
	private int x, y;
	private String direction;
	
	public void setX(int x)
	{
		
		this.x = x;
		
	}
	public void setY(int y)
	{
		
		this.y = y;
		
	}
	public void setDirection(String direction)
	{
		
		this.direction = direction;
		
	}
	
	public Player(int x, int y)
	{
		
		this.x = x;
		this.y = y;
		direction = "up";
		
	}
	
	public void update()
	{
		
		move();
		
	}
	
	public void move()
	{
		
		if (direction == "up")
		{
			y-=5;
		}else if (direction == "down")
		{
			y+=5;
		}else if (direction == "left")
		{
			x-=5;
		}else if (direction == "right")
		{
			x+=5;
		}
		
		
	}
	
	public int getX()
	{
		
		return x;
		
	}
	
	public int getY()
	{
		
		return y;
		
	}
	
	public void rotateLeft()
	{
		
		if (direction == "up"){
			direction = "left";
		}else if(direction == "left"){
			direction = "down";
		}else if(direction == "right"){
			direction = "up";
		}else if(direction == "down"){
			direction = "right";
		}
		
		
		
	}
	public void rotateRight()
	{
		
		
		if (direction == "up"){
			direction = "right";
		}else if(direction == "left"){
			direction = "up";
		}else if(direction == "right"){
			direction = "down";
		}else if(direction == "down"){
			direction = "left";
		}
		
		
		
	}
	
	
	
	
	
	
	
}
