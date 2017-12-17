package WoolfandSheep;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;


public class register {

	private JFrame jframe2 = new JFrame();
	private JLabel userFname = new JLabel();
	private JLabel userLname = new JLabel();
	private JLabel userId = new JLabel();
	private JLabel userPw = new JLabel();
	private JLabel userRetypePw = new JLabel();
	private JLabel userMail = new JLabel(); 
	private JLabel pdSecu = new JLabel();
	private JLabel pdSecu2 = new JLabel();
	
	private JTextField Fname_tf = new JTextField();
	private JTextField Lname_tf = new JTextField();
	private JTextField Id_tf = new JTextField();
	private JTextField Pw_tf = new JTextField();
	private JTextField RetypePw_tf = new JTextField();
	private JTextField Mail_tf = new JTextField();
	
	private Font font1;
	private Font font2;
	
	private JButton Back;
	private JButton Exit;
	private JButton Submit;
	
	public register()
	{
		font1 = new Font("Impact",Font.PLAIN,16);
		font2 = new Font("Impact",Font.PLAIN,12);
		
		
		userFname = new JLabel("First name: ");
		userFname.setBounds(40,40,100,30);
		userFname.setForeground(Color.black);
		userFname.setFont(font1);
		Fname_tf = new JTextField();
		Fname_tf.setBounds(120, 50, 200, 20);
		jframe2.add(Fname_tf);
		
		userLname = new JLabel("Last name: ");
		userLname.setBounds(40,80,100,30);
		userLname.setForeground(Color.black);
		userLname.setFont(font1);
		Lname_tf = new JTextField();
		Lname_tf.setBounds(120, 90, 200, 20);
		jframe2.add(Lname_tf);
		
		userId = new JLabel("Username: ");
		userId.setBounds(40,120,100,30);
		userId.setForeground(Color.black);
		userId.setFont(font1);
		Id_tf = new JTextField();
		Id_tf.setBounds(120, 130, 200, 20);
		jframe2.add(Id_tf);
		
		userPw = new JLabel("Password: ");
		userPw.setBounds(40,160,100,30);
		userPw.setForeground(Color.black);
		userPw.setFont(font1);
		Pw_tf = new JTextField();
		Pw_tf.setBounds(120, 170, 200, 20);
		jframe2.add(Pw_tf);
		
		pdSecu = new JLabel("Password should include more than 8 digits and two characters");
		pdSecu.setBounds(40,180,350,30);
		pdSecu.setForeground(Color.red);
		pdSecu.setFont(font2);
				
				
		userRetypePw = new JLabel("Retype Pass: ");
		userRetypePw.setBounds(40,200,100,30);
		userRetypePw.setForeground(Color.black);
		userRetypePw.setFont(font1);
		RetypePw_tf = new JTextField();
		RetypePw_tf.setBounds(120, 210, 200, 20);
		jframe2.add(RetypePw_tf);
		
		pdSecu2 = new JLabel("Retype above password");
		pdSecu2.setBounds(40,220,150,30);
		pdSecu2.setForeground(Color.red);
		pdSecu2.setFont(font2);
		
		userMail = new JLabel("User Mail: ");
		userMail.setBounds(40,240,100,30);
		userMail.setForeground(Color.black);
		userMail.setFont(font1);
		Mail_tf = new JTextField();
		Mail_tf.setBounds(120, 250, 200, 20);
		jframe2.add(Mail_tf);
		
		font2 = new Font("µ¸¿ò",Font.BOLD,16);
		Back = new JButton("Back");
		Back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jframe2.dispose();
				Login lg = new Login();
				lg.setVisible(true);
				
			}
		});
		
		Back.setFont(font2);
		Back.setBounds(60,280,100,30);
		Back.setForeground(Color.white);
		Back.setBackground(Color.blue);
		jframe2.add(Back);
		
		
		Exit = new JButton("Exit");
		Exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jframe2 = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(jframe2, "Confirm if you want to exit","Login Systems",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				System.exit(0);
			}
		});
		
		Exit.setFont(font2);
		Exit.setBounds(180,280,100,30);
		Exit.setForeground(Color.white);
		Exit.setBackground(Color.blue);
		jframe2.add(Exit);
		
		Submit = new JButton("Submit");
		Submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
					
					
					Statement select = connect.createStatement();
					String query = "insert into login values(?,?,?,?,?)";
					

					
					PreparedStatement pst = connect.prepareStatement(query);
					pst.setString(1, Pw_tf.getText());
					/*if(Pw_tf.getText()!=RetypePw_tf.getText())
					{
						JOptionPane.showMessageDialog(null, "Password should be matched with retype password");
						return;
					}
					if(Pw_tf.getText().length()!=8)
					{
						JOptionPane.showMessageDialog(null, "Password should be 8 digits");
					}*/
					pst.setString(2, Fname_tf.getText());
					pst.setString(3, Lname_tf.getText());
					pst.setString(4, Mail_tf.getText());
					pst.setString(5, Id_tf.getText());
					
					
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data inserted successfully");
					
				}catch(ClassNotFoundException | SQLException ex)
				{
					JOptionPane.showMessageDialog(null, "Data inserted wrongly");
				}
			}
		});
		
		Submit.setFont(font2);
		Submit.setBounds(300,280,100,30);
		Submit.setForeground(Color.white);
		Submit.setBackground(Color.blue);
		jframe2.add(Submit);
		
		jframe2.add(userFname);
		jframe2.add(userLname);
		jframe2.add(userId);
		jframe2.add(userPw);
		jframe2.add(userRetypePw);
		jframe2.add(userMail);
		jframe2.add(pdSecu);
		jframe2.add(pdSecu2);
		
		
		jframe2.setBounds(400,300,450,400);
		jframe2.setLayout(null);
		jframe2.setTitle("Registration page");
		jframe2.setLocationRelativeTo(null);
		jframe2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe2.setVisible(true);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	
}
