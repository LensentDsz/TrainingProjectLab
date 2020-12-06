package Supermario;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

public class Ground extends Things{


	protected static  BufferedImage ground = null;
	protected static  BufferedImage grass = null;
	protected int GroundWidth=0;
	protected int GroundHeight=0;
		static{
			
			try {
				ground=ImageIO.read(new File("Img/Ground.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				grass=ImageIO.read(new File("Img/Grass.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			}
	 Ground(Game game,int x, int y, int GroundWidth , int GroundHeight ) {
		super(x, y, game);
		this.GroundHeight=GroundHeight;
		this.GroundWidth=GroundWidth;
		TotalWidth=UnitWidth*GroundWidth;
		TotalHeight=UnitHeight*GroundHeight;
	}

	public void Paint(Graphics g)
	{
		super.Paint(g);
		Image img = null;
		for(int i=1;i<=GroundWidth;i++)
		{
			for(int j=1;j<=GroundHeight;j++)
			{
				if(GroundHeight==1)
					img=grass;
				else
					img=ground;
				g.drawImage(img, x, y, UnitWidth*(i-1), UnitHeight*(j-1), null);
			}
			
		}
		
	}
	public Rectangle getRectangle()
	{
		return new Rectangle(x, y, UnitWidth*GroundWidth, UnitHeight*GroundHeight);
	}
	public void move() {
		super.Move();
	}
	protected void CollisionWithMario(MarioMove move) {
		
	}
}
