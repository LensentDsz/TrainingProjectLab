package Supermario;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton{
	protected Game game = null;
	protected String name=null;
	protected static Image Start = null;
	protected static Image Score = null;
	protected static Image Exit = null;
	protected static Image Restart = null;
	protected ImageIcon icon=null;
	{
	try {
		Start = ImageIO.read(new File("Img/Start.png"));
	} catch (IOException e) {
		System.out.println("Unable load Start!");
	}
	try {
		Score = ImageIO.read(new File("Img/Score.png"));
	} catch (IOException e) {
		System.out.println("Unable load Score!");
	}
	try {
		Exit = ImageIO.read(new File("Img/Exit.png"));
	} catch (IOException e) {
		System.out.println("Unable load Exit!");
	}
	try {
		Restart = ImageIO.read(new File("Img/Restart.png"));
	} catch (IOException e) {
		System.out.println("Unable load Restart!");
	}
	}
	Button(String name)
	{
		super();
		this.name=name;
		this.game=game;
		if(name=="Start")
			icon= new ImageIcon(Start);
		if(name=="Score")
			icon= new ImageIcon(Score);
		if(name=="Exit")
			icon= new ImageIcon(Exit);
		if(name=="Restart")
			icon= new ImageIcon(Restart);
		super.setIcon(icon);
	}
}
