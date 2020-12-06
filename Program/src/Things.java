package Supermario;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.List;
import java.awt.Toolkit;
public class Things {

	public int x,y;
	public int UnitWidth=30,UnitHeight=30;
	public int TotalWidth=0,TotalHeight=0;
	public Game game=null;
	protected boolean IsPaint=false;
	protected boolean avaliable=false;
	protected MarioMove mario=null;
	protected List<Things> things=null;
	protected static Image [] imgs = null;
	protected int XCurrentSpeed=3,YCurrentSpeed=3,XSpeed=3,YSpeed=3;
	protected State state = State.OnAir,CollisionBuilding=State.NoCollision,CollisionMonster=State.NoCollision;
	public Things(int x, int y, Game game) {
		this.x=x;
		this.y=y;
		this.game=game;
	}
	public void Paint(Graphics g) {
		CollisionWithMario(game.mario);
		Move();
	}

	public void Move() {
		mario=game.mario;
		if(mario.x+mario.XCurrentSpeed>600&&mario.Win==false)
		{
			x=x-mario.XCurrentSpeed;
		}
	}

	public Rectangle getRectangle()
	{
		return new Rectangle(x,y,TotalWidth,TotalHeight);
	}
	protected void CollisionWithMario(MarioMove mario) {
		if(this.IsPaint==false)
			return;
		
	}
	protected void Controller() {
		// TODO Auto-generated method stub
		
	}
	protected void Disappear() {
		if(IsPaint==true)
		{
			IsPaint=false;
		}
		else return;
	}


}
