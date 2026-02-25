
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Date;
import java.sql.*;


public class Fastcash extends JFrame implements ActionListener{
    JButton a1,a2,a3,a4,a5,a6,back;
    String pinnumber;

    Fastcash(String pinnumber){
        this.pinnumber= pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Select the withdraw amount:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,18));
        text.setBounds(160,280,400,25);
        image.add(text);

        a1 = new JButton("Rs.100");
        a1.setFont(new Font("Raleway",Font.BOLD,16));
        a1.setBounds(150,397,100,30);
        a1.addActionListener(this);
        image.add(a1);
        
        a2 = new JButton("Rs.500");
        a2.setFont(new Font("Raleway",Font.BOLD,16));
        a2.setBounds(400,397,110,30);
        a2.addActionListener(this);
        image.add(a2);

        a3 = new JButton("Rs.1000");
        a3.setFont(new Font("Raleway",Font.BOLD,16));
        a3.setBounds(150,430,100,30);
        a3.addActionListener(this);
        image.add(a3);
        
        a4 = new JButton("Rs.2000");
        a4.setFont(new Font("Raleway",Font.BOLD,16));
        a4.setBounds(400,430,110,30);
        a4.addActionListener(this);
        image.add(a4);

        a5 = new JButton("Rs.5000");
        a5.setFont(new Font("Raleway",Font.BOLD,16));
        a5.setBounds(150,463,100,30);
        a5.addActionListener(this);
        image.add(a5);

        a6 = new JButton("Rs.10000");
        a6.setFont(new Font("Raleway",Font.BOLD,16));
        a6.setBounds(400,463,110,30);
        a6.addActionListener(this);
        image.add(a6);

        back = new JButton("Back");
        back.setFont(new Font("Raleway",Font.BOLD,16));
        back.setBounds(150,495,100,30);
        back.addActionListener(this);
        image.add(back);






         setSize(900,900);
         setLocation(300,0);
         setUndecorated(true);
         setVisible(true);


    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(4);
            Conn conn = new Conn();
            try{
                ResultSet rs = conn.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));

                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                    


                }

                if(ae.getSource()== back && balance<Integer.parseInt("amount")){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "Insert into bank values('"+pinnumber+"','"+date+"','withdraw','"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs."+amount+"Debited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            }catch(Exception e){
                System.out.println(e);
            }

        }
    }
    public static void main(String args[]){
        new Fastcash("");
    }
    
}
