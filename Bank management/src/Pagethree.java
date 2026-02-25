import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Pagethree extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5;
    JButton submit,cancel;
    String formno;

    Pagethree(String formno){
        this.formno= formno;
        setLayout(null);

    
   
   

    JLabel l1 = new JLabel("Page 3: Account Details");
    l1.setFont(new Font("Raleway",Font.BOLD,22));
    l1.setBounds(280,40,400,40);
    add(l1);

    JLabel type= new JLabel("Account Type");
    type.setFont(new Font("Raleway",Font.BOLD,22));
    type.setBounds(100,140,200,30);
    add(type);

    r1= new JRadioButton("Saving Account");
    r1.setFont(new Font("Raleway",Font.BOLD,16));
    r1.setBackground(Color.WHITE);
    r1.setBounds(100,180,150,20);
    add(r1);

    r2= new JRadioButton("Fix Deposit Account");
    r2.setFont(new Font("Raleway",Font.BOLD,16));
    r2.setBackground(Color.WHITE);
    r2.setBounds(350,180,250,20);
    add(r2);

    r3= new JRadioButton("Current Account");
    r3.setFont(new Font("Raleway",Font.BOLD,16));
    r3.setBackground(Color.WHITE);
    r3.setBounds(100,220,250,20);
    add(r3);

    r4= new JRadioButton("Reccuring Deposit Account");
    r4.setFont(new Font("Raleway",Font.BOLD,16));
    r4.setBackground(Color.WHITE);
    r4.setBounds(350,220,250,20);
    add(r4);

    ButtonGroup button = new ButtonGroup();
    button.add(r1);
    button.add(r2);
    button.add(r3);
    button.add(r4);

    JLabel card= new JLabel("Card Number:");
    card.setFont(new Font("Raleway",Font.BOLD,22));
    card.setBounds(100,300,200,30);
    add(card);

    JLabel number = new JLabel("XXXX-XXXX-XXXX-6754");
    number.setFont(new Font("Raleway",Font.BOLD,16));
    number.setBounds(350,300,300,30);
    add(number);

    JLabel detail= new JLabel("(Your 16-digit card number)");
    detail.setFont(new Font("Raleway",Font.BOLD,12));
    detail.setBounds(100,330,200,15);
    add(detail);

    JLabel pin = new JLabel("PIN:");
    pin.setFont(new Font("Raleway",Font.BOLD,22));
    pin.setBounds(100,350,200,30);
    add(pin);

    JLabel det = new JLabel("(Your 4-digit password)");
    det.setFont(new Font("Raleway",Font.BOLD,12));
    det.setBounds(100,380,200,15);
    add(det);

    JLabel pnumber = new JLabel("XXXX");
    pnumber.setFont(new Font("Raleway",Font.BOLD,16));
    pnumber.setBounds(350,350,200,30);
    add(pnumber);

    JLabel service = new JLabel("Services Required:");
    service.setFont(new Font("Raleway",Font.BOLD,22));
    service.setBounds(100,430,200,30);
    add(service);

    c1= new JCheckBox("ATM Card");
    c1.setBackground(Color.WHITE);
    c1.setFont(new Font("Raleway",Font.BOLD,16));
    c1.setBounds(100,470,200,30);
    add(c1);

    c2 = new JCheckBox("Internet Banking");
    c2.setBackground(Color.WHITE);
    c2.setFont(new Font("Raleway",Font.BOLD,16));
    c2.setBounds(350,470,200,30);
    add(c2);

    c3= new JCheckBox("Mobile Banking");
    c3.setBackground(Color.WHITE);
    c3.setFont(new Font("Raleway",Font.BOLD,16));
    c3.setBounds(100,510,200,30);
    add(c3);

    c4=new JCheckBox("Cheque Book");
    c4.setBackground(Color.WHITE);
    c4.setFont(new Font("Raleway",Font.BOLD,16));
    c4.setBounds(350,510,200,30);
    add(c4);

    c5 = new JCheckBox("I hearb declare that the above entered details are correct to the best of my knowledge");
    c5.setBackground(Color.WHITE);
    c5.setFont(new Font("Raleway",Font.BOLD,12));
    c5.setBounds(100,650,600,30);
    add(c5);

    submit = new JButton("Submit");
    submit.setBackground(Color.BLACK);
    submit.setForeground(Color.WHITE);
    submit.setFont(new Font("Raleway",Font.BOLD,14));
    submit.setBounds(250,720,100,30);
    submit.addActionListener(this);
    add(submit);

    cancel = new JButton("Cancel");
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.WHITE);
    cancel.setFont(new Font("Raleway",Font.BOLD,14));
    cancel.setBounds(420,720,100,30);
    cancel.addActionListener(this);
    add(cancel);

     getContentPane().setBackground(Color.WHITE);


     setSize(850,820);
    setLocation(350,0);
    setVisible(true);

    


    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String type = null;
            if(r1.isSelected()){
                type = "Savings Account";
            }else if(r2.isSelected()){
                type= "Fix Deposit Account";
            }else if(r3.isSelected()){
                type="Current Account";
            }else if(r4.isSelected()){
                type="Reccuring Deposit Account";

            }
            Random random = new Random();
            String number = ""+ Math.abs((random.nextLong() %90000000L)+504093600000000L);

            String pin = ""+ Math.abs((random.nextLong()%9000L)+1000L);
            String service="";
            if(c1.isSelected()){
                service=service+"ATM Card";
            }else if(c2.isSelected()){
                service = service+"Internet Banking";

            }else if(c3.isSelected()){
                service= service+"Mobile Banking";
            }else if(c4.isSelected()){
                service=service+"Cheque Book";
            }else if(c5.isSelected()){
                service=service+"E-Statement";
            }
            try{

                if(type == null){
                    JOptionPane.showMessageDialog(null, "Account type is required");
                    return;
                }
                if(!c5.isSelected()){
                     JOptionPane.showMessageDialog(null, "Please accept the declaration");
                     return;
                }
                  else {
                    Conn conn = new Conn();
                    String query ="insert into pagethree(formno, account_type, card_number, pin, service) " +"values('"+formno+"','"+type+"','"+number+"','"+pin+"','"+service+"')";

                    String query2 ="insert into login(formno, card_number, pin) " +"values('"+formno+"','"+number+"','"+pin+"')";
                  
                    conn.s.executeUpdate(query);
                    conn.s.executeUpdate(query2);
                    

                    JOptionPane.showMessageDialog(null,"Card Number: "+ number+"\n PIN: "+pin);
                    setVisible(false);
                    new Deposit(pin).setVisible(false);
                }

            }catch(Exception e){
                System.out.println(e);
            }
            

        }else if( ae.getSource()==cancel){
           setVisible(false);
           new Login().setVisible(true);

        }
    }
    public static void main(String args[]){
        new Pagethree("");

    }
}