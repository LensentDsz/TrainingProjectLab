package Supermario;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

public class Map {

	protected boolean build=false;
	protected Game game = null;
	public List<Things> things = new LinkedList<Things>();
	protected MarioMove mario;

	Map(boolean build ,Game game)
	{
		this.game=game;
		this.build=build;
	}
	
	public void Paint(Graphics g)
	{
		Build();
		for(int i=0;i<things.size();i++)
		{
			Things thing = things.get(i);
		
				thing.Paint(g);
				//System.out.println("paint map");
		}
	}

	protected void Build() {
		if(build==true)
		{
			things.add(new Ground(game,-100,430,20,10));
			things.add(new Monster1(150,400,game));
			things.add(new Boxs(game,420,360));
			things.add(new Bricks(game,450,360));	
			things.add(new Ground(game,300,400,5,2));
			things.add(new Ground(game,600,430,20,10));
			things.add(new Bricks(game,650,400));
			things.add(new Bricks(game,680,400));
			things.add(new Bricks(game,680,370));
			things.add(new Bricks(game,710,400));
			things.add(new Bricks(game,710,370));
			things.add(new Bricks(game,710,340));
			things.add(new Bricks(game,800,310));
			things.add(new Bricks(game,830,310));
			things.add(new Bricks(game,860,310));
			things.add(new Boxs(game,890,340));
			things.add(new Boxs(game,920,340));
			
		}
		build=false;
	//	System.out.println("build success");
	}
	public void restart(boolean build) {
		
		things.removeAll(things);
		this.build=build;
		Build();
	}
}
