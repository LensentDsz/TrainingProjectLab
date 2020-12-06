package Supermario;

import java.awt.Graphics;

public class BackGroundConstructor {

	protected boolean Build =false;
	protected Game game = null;
	protected boolean Initialize = false;
	
	BackGroundConstructor(boolean build, Game game){
		this.Build=build;
		this.game=game;
	}
	public void Paint(Graphics g)
	{
		if(Build==false)
			BuildBackGround();
		BackGround bg=new BackGround(0,0,game);
		bg.Paint(g);
	}
	private void BuildBackGround() {
		BackGround bg;
		bg=new BackGround(0,0,game);
		Initialize=true;
		Build=false;
	}
	
}
