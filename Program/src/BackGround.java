package Supermario;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

public class BackGround {
	
	protected BufferedImage BG = null;
	public String BGName;
	public int x = 0, y = 0 ;
	protected Game game=null;
	protected MarioMove mario=null;
	protected BackGround bg=null;
	
	{
		try {
			BG = ImageIO.read(new File("Img/BackGround.jpg"));
		} catch (IOException e) {
			System.out.println("Unable load BackGround!");
		}
	}
	
	BackGround(int x , int y , Game game) {
		this.game=game;
		this.x=x;
		this.y=y;
		
	}
	public void Paint(Graphics g)
	{
		g.drawImage(BG, x, y, null);
		Refresh(bg);
	}
	protected void Refresh(BackGround bg)
	{
		if(this.x<=-Game.FrameWidth)
		{
			this.x=Game.FrameWidth;
		}
		if(bg!=null)
		{
			if(bg.x<=0&&bg.x>=-Game.FrameWidth)
			{
				this.x=bg.x+Game.FrameWidth;
			}
		}
	}

}
