package brickBreaker;
import javax.swing.*;
public class brickB {
	public static void main(String[] args) {
		JFrame jf=new JFrame("Brick Breaker");
		new gamePlay();
		jf.setBounds(10,10,700,600);
		jf.setLayout(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
}
