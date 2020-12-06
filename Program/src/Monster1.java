package Supermario;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Monster1 extends Things{
	protected static Image Monster1 = null;
	protected Direction direction=Direction.Left;
	protected int XCurrentSpeed=1;
	protected boolean hit=false;
	static{
		
		try {
			Monster1=ImageIO.read(new File("Img/Monster1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	Monster1(int x , int y , Game game )
	{
		super(x,y,game);
			XCurrentSpeed=-XCurrentSpeed;
			UnitWidth=28;
			UnitHeight=37;
			TotalWidth=30;
			TotalHeight=30;
			
	}
	public void Paint(Graphics g)
	{
		super.Paint(g);
		g.drawImage(Monster1, x, y, null);
		//System.out.println("monster 1");
		
	}
	public void move() {
		super.Move();
		HorizontalMove();
		VerticalMove();
	}
	protected void HorizontalMove() {
		x=x+XCurrentSpeed;
	}
	private void VerticalMove() {

	}

}

