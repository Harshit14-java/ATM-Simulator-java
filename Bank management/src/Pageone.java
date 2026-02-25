import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Pageone extends JFrame implements ActionListener{
    long Random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
    JButton next;
    JRadioButton male,female,others,married,unmarried;
     JDateChooser dateChooser;



    Pageone() {
        setLayout(null);
        Random ran =new Random();
         Random = Math.abs((ran.nextLong()%9000L)+1000L);


        JLabel formno = new JLabel("APPLICATION FORM NO."+ Random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

         JLabel personeldetail = new JLabel("Page 1- Personal Details ");
        personeldetail .setFont(new Font("Raleway",Font.BOLD,22));
        personeldetail .setBounds(290,80,400,30);
        add(personeldetail );

        JLabel name = new JLabel("Name: ");
        name .setFont(new Font("Raleway",Font.BOLD,20));
        name .setBounds(100,140,100,30);
        add(name );

         nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name: ");
        fname .setFont(new Font("Raleway",Font.BOLD,20));
        fname .setBounds(100,190,200,30);
        add(fname );

         fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);

         JLabel gender = new JLabel("Gender: ");
        gender .setFont(new Font("Raleway",Font.BOLD,20));
        gender .setBounds(100,290,200,30);
        add(gender );

         male= new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);

         female = new JRadioButton("Female");
        female.setBounds(450,290,80,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel dob = new JLabel("Date of birth: ");
        dob  .setFont(new Font("Raleway",Font.BOLD,20));
        dob  .setBounds(100,240,200,30);
        add(dob  );

         dateChooser =new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);



        JLabel email = new JLabel("Email: ");
        email  .setFont(new Font("Raleway",Font.BOLD,20));
        email  .setBounds(100,340,200,30);
        add(email  );

         emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);

        JLabel martial = new JLabel("Marital Status: ");
        martial  .setFont(new Font("Raleway",Font.BOLD,20));
        martial  .setBounds(100,390,200,30);
        add(martial  );

         married=new JRadioButton("Married");
        married.setBounds(300,390,80,30);
        married.setBackground(Color.WHITE);
        add(married);

         unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);  
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

         others = new JRadioButton("Other");
        others.setBounds(600,390,80,30);
        others.setBackground(Color.WHITE);
        add(others);

        ButtonGroup maritaButtonGroup=new ButtonGroup();
        maritaButtonGroup.add(married);
        maritaButtonGroup.add(unmarried);
        maritaButtonGroup.add(others);

        JLabel address = new JLabel("Address: ");
        address  .setFont(new Font("Raleway",Font.BOLD,20));
        address  .setBounds(100,440,200,30);
        add(address  );

         addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);

        JLabel city = new JLabel("City: ");
        city  .setFont(new Font("Raleway",Font.BOLD,20));
        city  .setBounds(100,490,200,30);
        add(city  );

         cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);

        JLabel state = new JLabel("State ");
        state  .setFont(new Font("Raleway",Font.BOLD,20));
        state  .setBounds(100,540,200,30);
        add(state  );

         stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);

        JLabel pincode = new JLabel("Pin code ");
        pincode  .setFont(new Font("Raleway",Font.BOLD,20));
        pincode  .setBounds(100,590,200,30);
        add(pincode  );

         pincodeTextField=new JTextField();
        pincodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pincodeTextField.setBounds(300,590,400,30);
        add(pincodeTextField);

         next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,640,80,30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        String formno = " " + Random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        }else if (female.isSelected()){
            gender = "Female";
        }
        String email = emailTextField.getText();
        String marital=null;
        if(married.isSelected()){
            marital= "Married";
        }else if(unmarried.isSelected()){
            marital="Unmarried";
        }else if(others.isSelected()){
            marital="Others";
        }
        String Address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pincodeTextField.getText();
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the name");
            }else if(fname.equals("")){
                 JOptionPane.showMessageDialog(null, "Please enter the Father's name");
                
            }else if(dob.equals("")){
                 JOptionPane.showMessageDialog(null, "Please enter the Date of Birth");
                
            }else if(gender.equals("")){
                 JOptionPane.showMessageDialog(null, "Please Select gender");
                
            }else if(email.equals("")){
                 JOptionPane.showMessageDialog(null, "Please enter Email");
                
            }else if(marital.equals("")){
                 JOptionPane.showMessageDialog(null, "Please Select Marital Status");
                 
                
            }else if(Address.equals("")){
                 JOptionPane.showMessageDialog(null, "Please enter Address");
                 
                
            }else if(city.equals("")){
                 JOptionPane.showMessageDialog(null, "Please enter City");
                 
                
            }else if(state.equals("")){
                 JOptionPane.showMessageDialog(null, "Please enter State");
                 
                
            }else if(pin.equals("")){
                 JOptionPane.showMessageDialog(null, "Please enter PIN");
                 
                
            }else{
                Conn c=new Conn();
                String query ="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+Address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);
            }


        }catch(Exception e){
            System.out.println(e);
        }
        if(ae.getSource()==next){
            setVisible(false);
            new Pagetwo(formno).setVisible(true);
        }



    }
    public static void main(String[] args) {
        new Pageone();
        
    }
}

    
 