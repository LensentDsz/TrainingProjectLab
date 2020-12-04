package Supermario;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

public class Bricks extends Things{

	
	protected static Image Bricks = null;
	protected int BricksWidth,BricksHeight;
	static
	{
		Bricks = tk.getImage(BackGround.class.getClassLoader().getResource("Img/Bricks.png"));
	}	
	Bricks(Game game ,int x , int y , int BricksWidth ,int BricksHeight){
		super(x,y,game);
		this.BricksWidth=BricksWidth;
		this.BricksHeight=BricksHeight;
		TotalWidth=30*BricksWidth;
		TotalHeight=30*BricksHeight;
	}
	public void Paint(Graphics g)
	{
		super.Paint(g);
		for(int i=0;i<BricksWidth;i++)
					{
						for(int j=0;j<BricksHeight;j++)
						{		
							g.drawImage(Bricks, x+(i-1)*UnitWidth,y+(j-1)*UnitHeight, null);
						}
					}
	}
}
