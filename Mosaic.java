import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;



class TileDraw extends JPanel{
	private int red, green, blue, shape;
	private int height = 84;
	private int fontSize = height/3;
	private String letter;
	private Color color, fontColor;
	Random rng = new Random();


	public TileDraw(){
		super();
		randomizeTile();
	}

	public void randomizeTile(){
		red = rng.nextInt(255);
		green = rng.nextInt(255);
		blue = rng.nextInt(255);
		color = new Color(red,green,blue);
		fontColor = new Color(GetContrastingColor(red),GetContrastingColor(green),GetContrastingColor(blue));

		letter = "" + (char) (rng.nextInt(26) + 'A');
		shape = rng.nextInt(2);

		System.out.println(this.toString());
	}

	private static int GetContrastingColor(int color_) {
    	return ((color_+128)%256);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);

		int panelHeight = height;
		int panelWidth = height;

		g.setColor(color);
		

		if (shape == 0){
			g.fillRect(10,10,height,height);
		}else{
			g.fillOval(10,10,height,height);
		}



        g.setColor(new Color(GetContrastingColor(red),GetContrastingColor(green),GetContrastingColor(blue)));

        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        int stringX = (panelWidth/2);
        int stringY = (panelHeight/2);
        g.drawString(letter,stringX,stringY);


	}

	public String toString(){
		String out;
		if (shape == 0){
			out = String.format("Shape: Square --- Color (RGB): %d %d %d --- Letter: %s", red, green, blue, letter);
		}else{
			out = String.format("Shape: Circle --- Color (RGB): %d %d %d --- Letter: %s", red, green, blue, letter);

		}

		return out;
	}

}

class MosaicFrame extends JFrame implements ActionListener{
	private ArrayList<TileDraw> tileList;
	JPanel buttonPanel = new JPanel();
	JButton randomize = new JButton("Randomize");


	public MosaicFrame(){
		setBounds(200,1000,1280,1280);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		contentPane.add(buttonPanel, BorderLayout.SOUTH);

		buttonPanel.add(randomize);
		randomize.addActionListener(this);

		JPanel tilePanel = new JPanel();
		contentPane.add(tilePanel, BorderLayout.CENTER);
		tilePanel.setLayout(new GridLayout(12,12));


		tileList = new ArrayList<TileDraw>();
		System.out.println("Start Paint***");

		for(int i = 1; i < 145; i++){
			TileDraw tile = new TileDraw();
			tileList.add(tile);
			tilePanel.add(tile);
		}
	}

	public void actionPerformed(ActionEvent e){
		if (e.getSource() == randomize){
			for (TileDraw tile : tileList){
				tile.randomizeTile();
			}
		}else{
			}
		

		repaint();
	}

}


public class Mosaic{
	public static void main(String[] args){
		System.out.println("Starting Mosaic...");

		MosaicFrame myFrame = new MosaicFrame();
		myFrame.setVisible(true);
	}
}