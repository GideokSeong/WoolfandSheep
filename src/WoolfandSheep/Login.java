package WoolfandSheep;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Login implements ActionListener{

	JFrame jframe1 = new JFrame();
	JFrame jframe2 = new JFrame();
	private JLabel labelID;
	private JLabel labelPass;
	private JTextField IDfield;
	private JTextField Passfield;
	private JButton Cancel;
	private JButton Register;
	private JButton Login;
	private Font font1;
	private Font font2;
	
	
	public Login()
	{
		
		
		font1 = new Font("Impact",Font.PLAIN,16);
		labelID = new JLabel("Username: ");
		labelID.setBounds(80,100,100,30);
		labelID.setForeground(Color.black);
		labelID.setFont(font1);
		
		jframe1.add(labelID);
		
		font1 = new Font("Impact",Font.PLAIN,16);
		labelID = new JLabel("Password: ");
		labelID.setBounds(80,140,100,30);
		labelID.setForeground(Color.black);
		labelID.setFont(font1);
		
		jframe1.add(labelID);
		
		
		IDfield = new JTextField();
		IDfield.setBounds(160, 110, 200, 20);
		Passfield = new JTextField();
		Passfield.setBounds(160, 150, 200, 20);
		
		jframe1.add(IDfield);
		jframe1.add(Passfield);
		
		font2 = new Font("µ¸¿ò",Font.BOLD,16);
		Cancel = new JButton("Cancel");
		Cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jframe1 = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(jframe1, "Confirm if you want to exit","Login Systems",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				System.exit(0);
			}
		});
		
		Cancel.setFont(font2);
		Cancel.setBounds(60,200,100,30);
		Cancel.setForeground(Color.white);
		Cancel.setBackground(Color.red);
		jframe1.add(Cancel);
		
		font2 = new Font("µ¸¿ò",Font.BOLD,16);
		Login = new JButton("Login");
		Login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
					
					
					Statement select = connect.createStatement();
					String query = "select * from login where username=? and password=? ";
					

					
					PreparedStatement pst = connect.prepareStatement(query);
					pst.setString(1, IDfield.getText());
					pst.setString(2, Passfield.getText());
					ResultSet rs = pst.executeQuery();
					
					int count = 0;
					while(rs.next())
					{
						count = count+1;
					}
					if(count == 1)
					{
						JOptionPane.showMessageDialog(null, "Username and password is correct");
						JFrame jf = new JFrame();
						jf.setVisible(true);
						jframe1.dispose();
						new Practice();
					}
					else if(count>1)
					{
						JOptionPane.showMessageDialog(null, "Duplicate Username and password");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Username and password is not correct Try again..");
					}
				
					
					rs.close();
					select.close();
					
				}catch(Exception ex)
				{
					JOptionPane.showConfirmDialog(null, "Username and password is not correct Try again..");
				}
				
			}
		});
		Login.setFont(font2);
		Login.setBounds(170,200,100,30);
		Login.setForeground(Color.white);
		Login.setBackground(Color.cyan);
		jframe1.add(Login);
		
		font2 = new Font("µ¸¿ò",Font.BOLD,16);
		Register = new JButton("register");
		Register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				jframe1.dispose();
				register rg = new register();
				rg.setVisible(true);
			}
		});
		Register.setFont(font2);
		Register.setBounds(280,200,100,30);
		Register.setForeground(Color.blue);
		Register.setBackground(Color.yellow);
		jframe1.add(Register);
		
		
		
		
		jframe1.setBounds(400,300,450,400);
		jframe1.setLayout(null);
		jframe1.setTitle("Login page");
		jframe1.setLocationRelativeTo(null);
		jframe1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe1.setVisible(true);
	
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			new Login();
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
