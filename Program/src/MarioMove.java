package Supermario;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.List;

public class MarioMove {
	protected static final int XSpeed = 10;
	protected static final int YSpeed = 5;
	protected static final int GUnitSpeed = 3;
	protected int XCurrentSpeed=0,YCurrentSpeed=0;
	protected int x=0,y=0,marioHeight=40,marioWidth=25;
	protected int XCurrentLocation=0,YCurrentLocation=0;
	protected Game game = null;
	protected boolean CanJump=true;
	protected boolean IsLive=true;
	protected boolean Win=false;
	protected State state = State.OnAir,collision=State.NoCollision;
	protected boolean PressJump,PressLeft,PressRight;
	private List<Things> things=null;
	public MarioMove(int x, int y, Game game) {
		this.x=x;
		this.y=y;
		this.game=game;
	}

	public void Paint(Graphics g) {
		move();
		
		if(this.IsLive==true)
		{
			setThings(game.map.things);
			collisionWithObjs();
		}
	}
	protected void die() {
		IsLive=false;
		collision=State.NoCollision;
		XCurrentSpeed=0;
		YCurrentSpeed=-YSpeed;
	}
	public void Win() {
		Win=true;
		XCurrentSpeed=XSpeed;
	}
	public void Press(KeyEvent e)
	{
		if(IsLive==false||Win==true)return;
		int press=e.getKeyCode();
		if (press==KeyEvent.VK_LEFT)
		{
			PressLeft=true;
		System.out.println("press left");
		}
		else if(press ==KeyEvent.VK_RIGHT) {
			PressRight=true;
		System.out.println("press right");
		}
		else if  (press ==KeyEvent.VK_SPACE)
		{
			PressJump=true;
		System.out.println("press space");
		}
		else {	
		}
	}
	public void Release(KeyEvent e)
	{
		if(Win==true)return;
		int press=e.getKeyCode();
		if (press==KeyEvent.VK_LEFT)
		{
			PressLeft=false;
		System.out.println("press left");
		}
		else if(press ==KeyEvent.VK_RIGHT) {
			PressRight=false;
		System.out.println("press right");
		}
		else if  (press ==KeyEvent.VK_SPACE)
		{
			PressJump=false;
		System.out.println("press space");
		}
		else {	
		}
	}
	private void move() {
		HorizontalMove();
		VerticalMove();
		if(y>600)
		{
			die();
		}
		else if (y<0)
		{
			die();
		}
		if(x>Game.FrameWidth&&Win==true)
		{
			XCurrentSpeed=0;
			YCurrentSpeed=0;
			IsLive=false;
			game.InGame=false;
			game.InMenu=true;
		}
	}
	
	private void HorizontalMove() {
		
		if(PressLeft==false&&PressRight==false)
		{
			XCurrentSpeed=0;
		}
		else if(PressLeft==true)
		{
			XCurrentSpeed=-XSpeed;
			
		}
		else if(PressRight==true)
		{
			XCurrentSpeed=XSpeed;
		}
		if(x+XCurrentSpeed>0&&x+XCurrentSpeed<800)
		{
			x=x+XCurrentSpeed;
			XCurrentLocation=x;
		}
		else if(Win==false)
			x=XCurrentLocation-200;
		if(collision==State.LeftCollision)
		{
			PressLeft=false;
			XCurrentSpeed=0;
		}
		else if (collision==State.RightCollision)
		{
			PressRight=false;
			XCurrentSpeed=0;
		}	
	}
	
	private void VerticalMove() {
		if(PressJump==true&&CanJump==true)
		{
			Jump();
			PressJump=false;
		}
		else if (state==State.OnGround&&YCurrentSpeed>0)
		{
			CanJump=true;
			YCurrentSpeed=1;
		}
		else if (state==State.OnAir)
		{
			YCurrentSpeed+=1;
		
		}
		if(collision==State.LeftCollision)
		{
			YCurrentSpeed=0;
		}
		else if(collision==State.RightCollision)
		{
			YCurrentSpeed=0;
		}
		else if(collision==State.GetHit)
		{
			YCurrentSpeed=0;
		}
		
		y+=YCurrentSpeed;
	}
	
	
	private void Jump() {
		if(CanJump==true&&state==State.OnGround)
		{
			YCurrentSpeed-=YSpeed*2;
			PressJump=false;
			CanJump=false;
			System.out.println("on ground jump");
		}
		state=State.OnAir;
		
	}

	public void setThings(List<Things> things) {
		this.things = things;
	}
	public void restart() {
		IsLive=true;
		Win=false;
		x=50;
		y=100;
		XCurrentSpeed=0;
		YCurrentSpeed=0;
	}
	public Rectangle getRectangle()
	{
		return new Rectangle(x,y,marioWidth,marioHeight);
	}
	public Rectangle getARectangle(int x,int y,int w,int h)
	{
		return new Rectangle(x,y,w,h);
	}
	public Rectangle getNextRectangle()
	{
		return new Rectangle(x+XCurrentSpeed,y+YCurrentSpeed,marioWidth,marioHeight);
	}
	protected void collisionWithObjs() 
	{
		if(IsLive==false) return;
		Things thing1=null;
		Things thing2=null;
		for(int i=0;i<things.size();i++)
		{
			Things thing=null;
			thing = things.get(i);
			
			if((x>thing.x&&x<thing.x+thing.TotalWidth&&y+marioHeight>thing.y&&y<thing.y+thing.TotalHeight)
				||(x+marioWidth>thing.x&&x+marioWidth<thing.x+thing.TotalWidth&&y>thing.y&&y<thing.y+thing.TotalHeight))//´©Ô½ÎïÌå¼ì²â1
			{
				if(thing.y>=y-marioHeight) 
				{
					y=thing.y-marioHeight;
					YCurrentSpeed=0;
					state=State.OnGround;
					CanJump=true;
					//System.out.println("on ground");
					return;
				}
				if(XCurrentSpeed>=0)
				{
					x=thing.x-marioWidth;
				}
				else
				{
					x=thing.x+thing.TotalWidth;
					
				}
				state=State.OnAir;
			//	System.out.println("on air");
			}

		else if(thing1==null&thing2==null)
		{
			state=State.OnAir;
		//	System.out.println("on air,no collision");
			collision=State.NoCollision;

		}

	}
	}
}

