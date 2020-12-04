package Supermario;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

public class Pipe extends Things{
	
	protected static BufferedImage Pipes = null;
	protected int PipeWidth,PipeHeight;
	{
		try {
			Pipes = ImageIO.read((ImageInputStream) new File("Img/Pipes.png"));
		} catch (IOException e) {
			System.out.println("Unable load Pipes!");
		}
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
