import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Login extends JFrame implements ActionListener {

    JButton login,Clear,Sign;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login(){

        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("Icon/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        getContentPane().setBackground(Color.WHITE);

        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        Clear = new JButton("CLEAR");
        Clear.setBounds(450,300,100,30);
        Clear.setBackground(Color.BLACK);
        Clear.setForeground(Color.WHITE);
        Clear.addActionListener(this);
        add(Clear);

        Sign = new JButton("SIGN UP");
        Sign.setBounds(300,350,250,30);
        Sign.setBackground(Color.BLACK);
        Sign.setForeground(Color.WHITE);
        Sign.addActionListener(this);
        add(Sign);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

         JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Osward",Font.BOLD,20));
        cardno.setBounds(120,150,400,30);
        add(cardno);

        cardTextField= new JTextField();
        cardTextField.setBounds(300,150,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

         JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Osward",Font.BOLD,20));
        pin.setBounds(120,220,400,40);
        add(pin);

        pinTextField= new JPasswordField();
        pinTextField.setBounds(300,220,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
     
      public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==Clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()==login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where card_number='"+cardnumber+"' and pin='"+pinnumber+"'";
            try{
                ResultSet rs=conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Password.");
                }


            }catch(Exception e){
                System.out.println(e);
            }

        }
        else if(ae.getSource()==Sign){
            setVisible(false);
            new Pageone().setVisible(true);

        }
       
    }
    public static void main(String args[])
    {
        new Login();
    }

    
}
