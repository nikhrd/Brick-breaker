package brickBreaker;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.*;
import javax.swing.Timer;

public class gamePlay extends JPanel implements KeyListener,ActionListener{
	private boolean play=false;
	private int score=0;
	private int totalBricks=25;
	private Timer time;
	private int delay=8;
	private int playerX=310;
	private int ballposx=120;
	private int ballposy=350;
	private int ballXdir=-1;
	private int ballYdir=-2;
	
	private MapGenerator map;
	
	public gamePlay() {
		map = new MapGenerator(3,7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		requestFocusInWindow();
		time=new Timer(delay,this);
		time.start();
	}
	
	public void paint(Graphics g) {
		//for background
		g.setColor(Color.black);
		g.fillRect(1,1,692,592);
		
		//drawing map
		map.draw((Graphics2D)g);
		
		//borders
		/*g.setColor(Color.red);
		g.fillRect(0, 0, 3,592);
		g.fillRect(0, 0, 692,3);
		g.fillRect(691, 0, 3,592);*/
		
		//the paddle
		g.setColor(Color.green);
		g.fillRect(playerX, 550, 100, 8);
		
		//ball
		g.setColor(Color.cyan);
		g.fillOval(ballposx, ballposy, 20, 20);
		
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		time.start();
		if(play) {
			if(new Rectangle(ballposx,ballposy,20,20).intersects(new Rectangle(playerX,550,100,8))) {
				ballYdir = -ballYdir;
			}
			ballposx += ballXdir;
			ballposy += ballYdir;
			
			if(ballposx<0) {
				ballXdir = -ballXdir;
			}
			if(ballposy<0) {
				ballYdir = -ballYdir;
			}
			if(ballposx>670) {
				ballXdir = -ballXdir;
			}
		}
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(playerX >=600) {
				playerX=600;
			}
			else {
				moveRight();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(playerX <10) {
				playerX=10;
			}
			else {
				moveLeft();
			}
		}	
	}
	public void moveRight() {
		play=true;
		playerX +=20;
		repaint();
	}
	public void moveLeft() {
		play=true;
		playerX -=20;
		repaint();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
}
