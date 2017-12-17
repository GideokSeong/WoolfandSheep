package WoolfandSheep;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class Practice extends JFrame implements MouseListener, MouseMotionListener{

	JLayeredPane layeredPane;
	JPanel Board;
	JLabel Piece;
	int xAdjustment;
	int yAdjustment;
	Point []parentLo = new Point[4]; 
	
	public Practice()
	{
		
		Dimension boardSize = new Dimension(600, 600);
		
		layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane);
		layeredPane.setPreferredSize(boardSize);
		layeredPane.addMouseListener(this);
		layeredPane.addMouseMotionListener(this);

		Board = new JPanel();
		layeredPane.add(Board, JLayeredPane.DEFAULT_LAYER);
		Board.setLayout( new GridLayout(8, 8) );
		Board.setPreferredSize(boardSize);
		Board.setBounds(0, 0, boardSize.width, boardSize.height);

		for (int i = 0; i < 64; i++) {
			
			JPanel square = new JPanel( new BorderLayout() );
			Board.add( square );

			int row = (i / 8) % 2;
			if (row == 0)
				square.setBackground( i % 2 == 0 ? Color.orange : Color.black );
			else
				square.setBackground( i % 2 == 0 ? Color.black : Color.orange );
		
		}
		
		
		
		JLabel piece = new JLabel( new ImageIcon("sheep.PNG") );
		JPanel panel = (JPanel)Board.getComponent(56);
		panel.add(piece);
		
		piece = new JLabel(new ImageIcon("wolf.PNG"));
		panel = (JPanel)Board.getComponent(1);
		panel.add(piece);
		
		piece = new JLabel(new ImageIcon("wolf.PNG"));
		panel = (JPanel)Board.getComponent(3);
		panel.add(piece);
		
		piece = new JLabel(new ImageIcon("wolf.PNG"));
		panel = (JPanel)Board.getComponent(5);
		panel.add(piece);
		
		piece = new JLabel(new ImageIcon("wolf.PNG"));
		panel = (JPanel)Board.getComponent(7);
		panel.add(piece);
	
		
		
		
		
		
		
		
		
		
		
		//setBounds(500,500,500,500);
		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE );
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


				new Practice(); 
		
	}
		@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		Piece = null;
		Component c =  Board.findComponentAt(e.getX(), e.getY());
		
		if (c instanceof JPanel) 
			return;
		
		Point parentLocation = c.getParent().getLocation();
		
		
		
		
		
		xAdjustment = parentLocation.x - e.getX();
		yAdjustment = parentLocation.y - e.getY();
		
		
		
		/*System.out.println(xAdjustment);
		System.out.println(yAdjustment);
		System.out.println(e.getX());
		System.out.println(e.getY());*/
		
		System.out.println(parentLocation.x);
		System.out.println(parentLocation.y);
		
		
		Piece = (JLabel)c;
		Piece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
		Piece.setSize(Piece.getWidth(), Piece.getHeight());
		layeredPane.add(Piece, JLayeredPane.DRAG_LAYER);
			
		
		
		
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		if(Piece == null) return;

		Piece.setVisible(false);
		Component c =  Board.findComponentAt(e.getX(), e.getY());
		
		
		if (c instanceof JLabel){
			Container parent = c.getParent();
			parent.remove(0);
			parent.add(Piece);
		}
		else {
			Container parent = (Container)c;
			parent.add(Piece);
		}

		Piece.setVisible(true);
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
