package Supermario;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;


public class Stars extends Things{

	protected static BufferedImage Stars = null;
	protected int XCurrentSpeed=3,YCurrentSpeed=15,YCurrentSpeeded=3;
	protected State CollisionWithMario = State.NoCollision;
	protected Boxs boxs=null;
	{
		try {
			Stars = ImageIO.read((ImageInputStream) new File("Img/Stars.png"));
		} catch (IOException e) {
			System.out.println("Unable load Stars!");
		}
	}

	Stars(int x, int y, Game game) {
		super(x,y,game);
		UnitWidth=23;
		UnitHeight=25;
		TotalWidth=23;
		TotalHeight=25;
		
	}
	Stars(int x, int y,Boxs boxs ,Game game) 
	{
		super(x, y, game);
		UnitWidth=23;
		UnitHeight=25;
		TotalWidth=23;
		TotalHeight=25;
		this.boxs=boxs;
	}


	public void Paint(Graphics g) {
		super.Paint(g);
		g.drawImage(Stars, x, y,null);
		Collision();
		
	}
	protected void Controller() {
		super.Controller();
		if(state==State.GetHit)
		{
			Disappear();
		}
		
	}
	protected void Disappear() {
		super.Disappear();
	}
	private void Collision() {
		Things thing1=null;
		Things thing2=null;
		for(int i=0;i<things.size();i++)
		{
			Things thing=null;
			thing = things.get(i);
			if((thing.IsPaint==true&&getNextRectangle().intersects(thing.getRectangle())==true
					&&(thing!=thing1&&thing!=thing2))||thing.CheckEat(this)
					||((x+XCurrentSpeed>thing.x&&x+XCurrentSpeed<thing.x+thing.TotalWidth&&y>thing.y&&y<thing.y+thing.TotalHeight)||(x+TotalWidth+XCurrentSpeed>thing.x&&x+TotalWidth+XCurrentSpeed<thing.x+thing.TotalWidth&&y>thing.y&&y<thing.y+thing.TotalHeight)))
			{
				if((x+XCurrentSpeed>thing.x&&x+XCurrentSpeed<thing.x+thing.TotalWidth&&y>thing.y&&y<thing.y+thing.TotalHeight)||(x+TotalWidth+XCurrentSpeed>thing.x&&x+TotalWidth+XCurrentSpeed<thing.x+thing.TotalWidth&&y>thing.y&&y<thing.y+thing.TotalHeight))
				{
					if(thing.y>=y) return;
					if(XCurrentSpeed>=0)
					{
						x=thing.x-TotalWidth;
					}
					else
					{
						x=thing.x+thing.TotalWidth;
					}
				}
				if(thing.CheckEat(this))
					if(thing.y>=y) return;
					x-=XCurrentSpeed;
					y-=YCurrentSpeed;
				}
				if(thing1==null)
				{
					thing1=thing;
				}
				else if(thing1!=null)
				{
					thing2=thing;
				}
				if(thing1!=null&&thing2!=null)
				{
				}
			}
		if(thing1!=null&&thing2==null)
		{
			if(y<=thing1.y)
			{
				y=thing1.y-TotalHeight;
				state=State.OnGround;
			}
			else
			{
				state=State.OnAir;
			}
			
			if(x>=thing1.x+thing1.TotalWidth&&XCurrentSpeed<0)
			{
				CollisionBuilding=State.LeftCollision;
				x=thing1.x+thing1.TotalWidth+XCurrentSpeed;	
				XCurrentSpeed=XCurrentSpeed;
			}
			else if(x+TotalWidth<=thing1.x&&XCurrentSpeed>0)
			{
				CollisionBuilding=State.RightCollision;
				x=thing1.x-TotalWidth-XCurrentSpeed;
				XCurrentSpeed=-XCurrentSpeed;
			}
			else if(y>=thing1.y+thing1.TotalHeight&&YCurrentSpeed<0)
			{
				CollisionBuilding=State.GetHit;
			}
			else
			{
				CollisionBuilding=State.NoCollision;
			}
		}
		else if(thing1!=null&&thing2!=null)
		{
			int ground=0;
			if(x+TotalWidth>=thing1.x&&x<=thing1.x+thing1.TotalWidth&&thing1.y>=y)
			{
				ground=1;
			}
			else if(x+TotalWidth>=thing2.x&&x<=thing2.x+thing2.TotalWidth&&thing2.y>=y)
			{
				ground=2;
			}
			else
			{
				return ;
			}
			Things thing = null;
			if(ground==1)
			{
				thing=thing2;
			}
			else if(ground==2)
			{
				thing=thing1;
			}
			if(x+TotalWidth>=thing.x+thing.TotalWidth&&XCurrentSpeed<=0)
			{
				CollisionBuilding=State.LeftCollision;
				XCurrentSpeed=-XCurrentSpeed;
			}
			else if(x<=thing.x&&XCurrentSpeed>=0)
			{
				CollisionBuilding=State.RightCollision;
				XCurrentSpeed=-XCurrentSpeed;
			}  
		}
		else if(thing1==null&thing2==null)
		{
			state=State.OnAir;
			CollisionBuilding=State.NoCollision;
			}
		}		
	}

