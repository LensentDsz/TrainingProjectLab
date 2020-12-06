package Supermario;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

public class Bricks extends Things{

	
	protected static Image Bricks = null;
	static
	{
		try {
			Bricks=ImageIO.read(new File("Img/Bricks.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	Bricks(Game game ,int x , int y ){
		super(x,y,game);
	
		TotalWidth=30;
		TotalHeight=30;
	}
	public void Paint(Graphics g)
	{
		super.Paint(g);
		g.drawImage(Bricks, x,y, null);

	}
}
