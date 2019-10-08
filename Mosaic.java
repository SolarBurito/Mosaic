import java.awt.*;
import javax.swing.*;
import java.util.Random;



class TileDraw extends JPanel{
	private int height;
	private int area = height*height;
	private int fontSize =  area/3;
	private String letter;
	private Color color;
	private Color fontColor;

	public int getHeight(){return height;}
	public String getLetter(){return letter;}
	public Color getColor(){return color;}

	public void setHeight(int height_){height = height_;}
	public void setLetter(String letter_){ letter=letter_;}
	public void setColor(Color color_){ color=color_;}
	public void setFontColor(Color color_){ fontColor=color_;}




	public TileDraw(int height_, String letter_, Color color_){
		super();
		randomizeTile();
	}

	public void randomizeTile(){
		Random rng = new Random();
		int r = rng.nextInt(255);
		int g = rng.nextInt(255);
		int b = rng.nextInt(255);
		setColor(new Color(r,g,b));
		setFontColor(new Color(GetContrastingColor(r),GetContrastingColor(g),GetContrastingColor(b)));


		char l_ = (char) (rng.nextInt(26) + 'A');
		String l = String.valueOf(l_);
		setLetter(l);
	}

	private static int GetContrastingColor(int color_) {
    	return ((color_+128)%256);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);


		g.setColor(color);
		g.fillRect(10,10, getHeight() - 10, getHeight() -10);

		g.setColor(fontColor);
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
		g.drawString(getLetter(),getHeight(),getHeight());
	}
}

class MosaicFrame extends JFrame{


}

class TilePanel extends JPanel{

}

class ButtonPanel{
	
}

public class Mosaic{
	public static void main(String[] args){
		System.out.println("Starting Mosaic...");
	}
}