package Supermario;

import java.awt.Graphics;
import java.awt.Image;

public class Pipe extends Things{
	
	protected static Image Pipes = null;
	protected int PipeWidth,PipeHeight;
	static
	{
		Pipes = tk.getImage(BackGround.class.getClassLoader().getResource("Img/Pipes.png"));
	}	
	public Pipe(int x, int y, Game game) {
		super(x, y, game);
		TotalWidth=UnitWidth*2;
		TotalHeight=UnitWidth*PipeHeight;
	}
	public void draw(Graphics g)
	{
		super.Paint(g);
		g.drawImage(Pipes, x+UnitWidth, y+UnitHeight,null);
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
}
