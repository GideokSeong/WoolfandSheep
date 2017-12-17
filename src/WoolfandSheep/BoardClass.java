package WoolfandSheep;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class BoardClass extends JFrame{

	private int length = 4;
	private Container contents;
	Sheep Sheep = new Sheep(7, 0);
	Woolf []Woolf = new Woolf[length];


	private JButton[][] squares = new JButton[8][8];
	private Color colorBlack = Color.BLACK;
	private Color colorOrange = Color.ORANGE;

	private ImageIcon sheep = new ImageIcon("sheep.PNG");
	private ImageIcon woolf = new ImageIcon("wolf.PNG");


	public BoardClass()
	{
		super("Sheep and wolf game"); 

		Woolf[0] = new Woolf(0,1);
		Woolf[1] = new Woolf(0,3);
		Woolf[2] = new Woolf(0,5);
		Woolf[3] = new Woolf(0,7);

		contents = getContentPane();
		contents.setLayout(new GridLayout(8, 8));

		ButtonHandler buttonhandler = new ButtonHandler();

		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{


				squares[i][j] = new JButton();
				if((i+j)%2!=0) // it allows to show black blocks
				{
					squares[i][j].setBackground(colorBlack);
				}
				else
				{
					squares[i][j].setBackground(colorOrange);
				}
				contents.add(squares[i][j]);
				squares[i][j].addActionListener(buttonhandler);
			}
		}


		/*System.out.println(SheepClass.getSheeprow());
		System.out.println(SheepClass.getSheepcol());
		System.out.println(Woolf[0].getWoolfcol());*/



		squares[Sheep.getSheeprow()][Sheep.getSheepcol()].setIcon(sheep);
		/*squares[Woolf[0].getWoolfrow()][Woolf[0].getWoolfcol()].setIcon(woolf);
		squares[Woolf[1].getWoolfrow()][Woolf[1].getWoolfcol()].setIcon(woolf);
		squares[Woolf[2].getWoolfrow()][Woolf[2].getWoolfcol()].setIcon(woolf);
		squares[Woolf[3].getWoolfrow()][Woolf[3].getWoolfcol()].setIcon(woolf);
		 */
		setSize(500,500);
		setResizable(false);
		setLocationRelativeTo(null); //centers window
		setVisible(true);

	}


	private boolean isValidMove(int i, int j)
	{

		int rowDelta = Math.abs(i-Sheep.getSheeprow());
		int colDelta = Math.abs(j-Sheep.getSheepcol());

		if((rowDelta==1) && (colDelta==1))
		{
			return true;
		}

		return false;
	}


	private void processClick(int i, int j)
	{
			
		if(isValidMove(i,j)==false)
		{
				//JOptionPane.showMessageDialog(null, "You have to move only one box in black board");
				return;
		}
		
		squares[Sheep.getSheeprow()][Sheep.getSheepcol()].setIcon(null);
		squares[i][j].setIcon(sheep);
		Sheep.setSheeprow(i);
		Sheep.setSheepcol(j);

	}



	private class ButtonHandler implements ActionListener,MouseListener
	{
		public void actionPerformed(ActionEvent e) 
		{



			Object source = e.getSource();

			for(int i=0;i<8;i++)
			{
				for(int j=0;j<8;j++)
				{

					if(source==squares[i][j])
					{
						System.out.println("i = " +i+ "j = " +j);
						processClick(i,j);
						return;
					}

				}
			}

		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.print("Hi I'm pressed");
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}


		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}



	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub



		new BoardClass(); 
	}
}
