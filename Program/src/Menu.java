package Supermario;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu 
{
	protected Game game;
	protected boolean Initialize=false;
	protected JButton ButtonStart=null,ButtonScore=null,ButtonRestart=null,ButtonExit=null;
	protected JLabel LabelBackGround=null,LabelTitle=null,LabelGameover=null,LabelWin=null;
	protected JFrame FrameScore=null;
	protected BackGroundConstructor bg=null;
	protected Map map=null;
	protected Container menu;
	Menu(Game game)
	{
		this.game=game;
	}
	
	public void Paint(Graphics g)
	{
		if(Initialize==true) {
			if(game.mario.IsLive==true)
			{
				bg.Paint(g);
				ButtonStart.repaint();
				ButtonExit.repaint();
				LabelBackGround.repaint();
				
			}
			else if(game.mario.IsLive==false)
			{
				
				bg.Paint(g);
				ButtonExit.repaint();
				ButtonRestart.repaint();
				System.out.println("dead");
				if(game.mario.Win==true)
				{
					LabelWin.repaint();
				}
				else
					LabelGameover.repaint();
			}
			if(game.InGame==false) {
				if(game.InMenu==true)
				{
					if(game.mario.IsLive==false)
					{
						if(game.mario.Win==false)
						{
							ButtonExit.setVisible(true);
							ButtonRestart.setVisible(true);
							LabelGameover.setVisible(true);
							LabelWin.setVisible(false);
						}
						else
						{
							ButtonExit.setVisible(true);
							ButtonRestart.setVisible(true);
							LabelGameover.setVisible(false);
							LabelWin.setVisible(true);
						}
					}
					
				}
			}
		}
		else if(Initialize==false)
		{
			menu=game.getContentPane();
			LabelBackGround = new JLabel();
			LabelTitle = new JLabel();
			LabelGameover = new JLabel();
			LabelWin = new JLabel();
			
			LabelBackGround.setBounds(0, 0, 800, 600);
			LabelBackGround.setBackground(Color.blue);
			LabelBackGround.setVisible(true);
			game.LabelBackGround = this.LabelBackGround;
			menu.add(LabelBackGround);
			FrameScore = new JFrame();
			
			LabelTitle = new JLabel("SuperMario") ;	
			LabelTitle.setFont(new Font("SuperMario",Font.BOLD,45));
			LabelTitle.setBounds(285,50,300,200);
			game.LabelTitle=this.LabelTitle;
			
			LabelGameover= new JLabel("GAME OVER");
			LabelGameover.setFont(new Font("GAME OVER",Font.BOLD,55));
			LabelGameover.setBounds(255,100,400,200);
			LabelGameover.setVisible(false);
			game.LabelGameover=this.LabelGameover;
			
			LabelWin= new JLabel("YOU WIN");
			LabelWin.setFont(new Font("YOU WIN",Font.BOLD,55));
			LabelWin.setBounds(285,130,300,150);
			LabelWin.setVisible(false);
			game.LabelWin=this.LabelWin;
			
			
			LabelBackGround.add(LabelTitle);
			LabelBackGround.add(LabelGameover);
			LabelBackGround.add(LabelWin);
			game.getContentPane().add(LabelBackGround,null);
			
			ButtonStart=new Button("Start");
			ButtonStart.setBounds(300, 180, 224, 35);
			ButtonStart.addActionListener(new ButtonListener(this));
			ButtonStart.setContentAreaFilled(false);
			game.ButtonStart=this.ButtonStart;
			
			ButtonScore=new Button("Score");
			ButtonScore.setBounds(300, 250, 224, 35);
			ButtonScore.addActionListener(new ButtonListener(this));
			ButtonScore.setContentAreaFilled(false);
			game.ButtonScore=this.ButtonScore;
			
			ButtonExit=new Button("Exit");
			ButtonExit.setBounds(300, 330, 224, 35);
			ButtonExit.addActionListener(new ButtonListener(this));
			ButtonExit.setContentAreaFilled(false);
			game.ButtonExit=this.ButtonExit;
			
			ButtonRestart=new Button("Restart");
			ButtonRestart.setBounds(300, 280, 224, 35);
			ButtonRestart.addActionListener(new ButtonListener(this));
			ButtonRestart.setContentAreaFilled(false);
			ButtonRestart.setVisible(false);
			game.ButtonRestart=this.ButtonRestart;
			
			LabelBackGround.add(ButtonStart);
			LabelBackGround.add(ButtonScore);
			LabelBackGround.add(ButtonExit);
			LabelBackGround.add(ButtonRestart);
			game.getContentPane().add(LabelBackGround,null);
			menu=game.getContentPane();
			
			bg=new BackGroundConstructor(true,game);
			Initialize=true;
		}
	}
	private class ButtonListener implements ActionListener
	{
		Game game=null;
		Menu menu = null;
		ButtonListener(Menu menu)
		{
			this.menu=menu;
			this.game=menu.game;
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==menu.ButtonStart)
			{
				game.InMenu=false;
				game.InGame=true;	
				game.setFocusable(true);
				System.out.println("start");
			}
			else if (e.getSource()==menu.ButtonExit)
			{
				System.exit(0);
			}
			else if (e.getSource()==menu.ButtonRestart)
			{
				game.mario.restart();
				game.map.restart(true);
				game.InMenu=false;
				game.InGame=true;
				game.setFocusable(true);
				
			}
			
		}
		
	}
}
