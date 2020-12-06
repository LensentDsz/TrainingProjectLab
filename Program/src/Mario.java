package Supermario;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

public class Mario extends MarioMove{
	protected static BufferedImage MarioImage = null;
	protected int MarioWidth=15,MarioHeight=25;
	protected int InGameWidth=0,InGameHeight=0;
	protected int IsPaint=0;
	{
		try {
			MarioImage = ImageIO.read(new File("Img/Mario.png"));
		} catch (IOException e) {
		//	System.out.println("Unable load Mario!");
		}
	}
	public Mario(int x, int y,Game game) {
		super(x, y, game);
		InGameWidth=MarioWidth;
		InGameHeight=MarioHeight;
	}
	public void Paint(Graphics g)
	{
		super.Paint(g);
		if(IsPaint==0)
		{
			g.drawImage(MarioImage, -300, -300, null);
			IsPaint=1;
		}
		PaintMario(g);
		
		if(IsLive==false)
			return;
	}
	public void Restart()
	{
		super.restart();
	}
	protected void PaintMario(Graphics g)
	{
		g.drawImage(MarioImage, x, y, null);
		//System.out.println("mario");
	}
	
	
}
