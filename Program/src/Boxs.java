package Supermario;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Boxs extends Things{
	
	protected static Image Boxs = null;
	protected int PipeWidth,PipeHeight;
	protected Stars stars = null;
	static
	{
		try {
			Boxs=ImageIO.read(new File("Img/Boxs.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Boxs( Game game,int x, int y) {
		super(x, y, game);
		UnitWidth=30;
		UnitHeight=30;
		TotalWidth=30;
		TotalHeight=30;
	}
	public void Paint(Graphics g)
	{
		super.Paint(g);
		g.drawImage(Boxs, x, y,null);
		if(stars!=null)
			stars.Paint(g);
	}
	protected void CollisionWithMario(MarioMove mario)
	{
		super.CollisionWithMario(mario);
		if(mario.getNextRectangle().intersects(this.getRectangle()))
		{
			if(mario.y<=y+TotalHeight)
			{
				CollisionBuilding=State.GetHit;
			}
		}
		else
		{
			CollisionBuilding=State.NoCollision;
		}
	}
	protected void Controller()
	{
		super.Controller();
		if(CollisionBuilding==State.GetHit)
		{
			stars = new Stars(x+UnitWidth/5,y-25,this,game);
			game.Score+=1;
		}
	}
	

}
