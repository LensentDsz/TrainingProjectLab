package Supermario;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;
public class Game extends JFrame{

	public final static int FrameWidth=800,FrameHeight=600;
	protected boolean InGame=false,InMenu=true,Initialize=false;
	
	 JLabel LabelBackGround=null,LabelTitle=null, LabelWin=null,LabelGameover=null;
	 JButton ButtonStart=null;
	 JButton ButtonScore=null;
	 JButton ButtonExit=null;
	 JButton ButtonRestart=null;
	 Thread thread=null;
	 MarioMove mario = new Mario(100,100,this);
	 Map map = new Map(true,this);
	 BackGroundConstructor bg=new BackGroundConstructor(true,this);
	 Menu menu = new Menu(this);
	 public int Score;
	 protected Image g1 = null;
	 Graphics g2=null;
	 
	Game(){
		super();
		this.setBounds(0, 0, FrameWidth, FrameHeight);
		this.setVisible(true);
		this.setResizable(false);
		this.addWindowListener(new GameWindowListener());
		this.setLayout(null);
		this.setBackground(Color.white);
	}

	public void paint(Graphics g)
	{
	
		if(Initialize==false)
		{
			if(g1 == null)
			{
				g1 = this.createImage(FrameWidth,FrameHeight);
			}
			g2 = g1.getGraphics();
			Initialize=true;
		}
		if(mario.IsLive==false&&mario.y>600)
		{
			InGame=false;
			InMenu=true;
		}
		if(InMenu==true)
		{
			menu.Paint(g2);
			LabelBackGround.setIcon(new ImageIcon(g1));
		}
		else if(InMenu==false)
		{
			ButtonStart.setVisible(false);
			ButtonScore.setVisible(false);
			ButtonExit.setVisible(false);
			ButtonRestart.setVisible(false);
			LabelBackGround.setVisible(false);
		}
		if(InGame==true)
		{
			bg.Paint(g2);
			map.Paint(g2);
			mario.Paint(g2);
		//	System.out.println("ingame");
		}
		else if(InGame==false)
		{
			
		}
			
		g.drawImage(g1, 0, 0, null);
	}
	public void paintComponents(Graphics g)
	{
		super.paintComponents(g);
	}
	private class KeyboardListener extends KeyAdapter
	{

		public void keyPressed(KeyEvent e) {
			mario.Press(e);
		}
		public void keyReleased(KeyEvent e) {
			mario.Release(e);
		}
	}
	
	private class GameMouseListener implements MouseListener
	{

		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}
		
	}

	private class PaintThread implements Runnable
	{
		public void run()
		{
			while(true)
			{
				repaint();
				try {
					Thread.sleep(49);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void launchFrame() {
		this.setTitle("Super Mario");
		thread=new Thread(new PaintThread());
		thread.start();
		this.addKeyListener(new KeyboardListener());
		this.addMouseListener(new GameMouseListener());
		
	}
	public static void main(String args[])
	{
		Game game = new Game();
		game.launchFrame();
	}
	
}
