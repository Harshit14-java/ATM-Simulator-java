import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Pinchange extends JFrame implements ActionListener{
    String pinnumber;
    JPasswordField f1,f2;
    JButton change,back;

    Pinchange(String pinnumber){
        this.pinnumber= pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);

        JLabel pintext = new JLabel("New PIN:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Raleway",Font.BOLD,16));
        pintext.setBounds(165,320,180,25);
        image.add(pintext);

        f1 = new JPasswordField();
        f1.setFont(new Font("Raleway",Font.BOLD,16));
        f1.setBounds(330,320,180,25);
        image.add(f1);

        

        JLabel pintext2 = new JLabel("Re-enter new PIN:");
        pintext2.setForeground(Color.WHITE);
        pintext2.setFont(new Font("Raleway",Font.BOLD,16));
        pintext2.setBounds(165,360,180,25);
        image.add(pintext);

        f2 = new JPasswordField();
        f2.setFont(new Font("Raleway",Font.BOLD,16));
        f2.setBounds(330,360,180,25);
        image.add(f2);

        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);


        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        



        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){

           try{
              String npin = f1.getText();
              String rpin = f2.getText();

              if(!npin.equals(rpin)){
                  JOptionPane.showMessageDialog(null, "Entered pin does not match");
                  return;
              }

              if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "Pleas enter new PIN");
                return;
              }
              if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                return;
              }

              Conn c =  new Conn();
              String query1= "Update bank set pin='"+rpin+"' where pin = '"+pinnumber+"'";
              String query2= "Update login set pin='"+rpin+"' where pin = '"+pinnumber+"'";
              String query3= "Update pagethree set pin='"+rpin+"' where pin = '"+pinnumber+"'";

              c.s.executeUpdate(query1);
              c.s.executeUpdate(query2);
              c.s.executeUpdate(query3);

              JOptionPane.showMessageDialog(null,"Pin changed successfully");
              setVisible(false);
              new Transactions(rpin).setVisible(true);


        
           


        }catch(Exception e){
            System.out.println(e);
        }}
        else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }  
    }
    public static void main(String args[]){
        new Pinchange("").setVisible(true);
    }
}
