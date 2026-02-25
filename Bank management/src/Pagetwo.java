import javax.swing.*;
import java. awt.*;
import java.awt.event.*;


public class Pagetwo extends JFrame implements ActionListener {
    JTextField  panField,aadharField;
    JRadioButton senioRadioButton,seniorJRadioButton,yes,no;
    JComboBox religions,categories,incomes,edu,occu;
    JButton next;
    String formno;
    
    Pagetwo(String formno){
        this.formno= formno;
        setLayout(null);
        
         setTitle("NEW ACCOUNT APPLICATION FORM PAGE:2");

         JLabel header = new JLabel("Page:2 ADDITIONAL DETAILS");
         header.setFont(new Font("Raleway",Font.BOLD,28));
         header.setBounds(220,70,400,40);
         add(header);

         JLabel religion = new JLabel("Religion: ");
         religion.setFont(new Font("Raleway",Font.BOLD,20));
         religion.setBounds(100,190,100,30);
         add(religion);

         String valreligion[]={"","Hindu","Muslim","Sikh","Christian","Others"};
          religions = new JComboBox(valreligion);
         religions.setBounds(350,190,400,30);
         religions.setBackground(Color.WHITE);
         add(religions);

         JLabel category= new JLabel("Category: ");
         category.setFont(new Font("Raleway",Font.BOLD,20));
         category.setBounds(100,240,100,30);
         add(category);

         String valcategory[] = {"","General","OBC","ST","SC","Others"};
          categories = new JComboBox(valcategory);
         categories.setBounds(350,240,400,30);
         categories.setBackground(Color.WHITE);
         add(categories);


         JLabel income = new JLabel("Income:");
         income.setFont(new Font("Raleway",Font.BOLD,20));
         income.setBounds(100,290,100,30);
         add(income);

         String valincome[]={"","Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
          incomes = new JComboBox(valincome);
         incomes.setBounds(350,290,400,30);
         incomes.setBackground(Color.WHITE);
         add(incomes);

         JLabel education = new JLabel("Education: ");
         education.setFont( new Font("Raleway",Font.BOLD,20));
         education.setBounds(100,340,180,30);
         add(education);

         String valedu[]={"","Non-Graduation","Graduation","Post-Graduation","Doctrale","Others"};
          edu = new JComboBox(valedu);
         edu.setBounds(350,340,400,30);
         edu.setBackground(Color.WHITE);
         add(edu);


         JLabel occupation = new JLabel("Occupation:");
         occupation.setFont(new Font("Raleway",Font.BOLD,20));
         occupation.setBounds(100,390,180,30);
         add(occupation);

         String valoccu[]={"","Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
          occu = new JComboBox(valoccu);
         occu.setBounds(350,390,400,30);
         occu.setBackground(Color.WHITE);
         add(occu);

        

         JLabel pan = new JLabel("PAN Number:");
         pan.setFont(new Font("Raleway",Font.BOLD,20));
         pan.setBounds(100,440,180,30);
         add(pan);

         panField = new JTextField();
         panField.setFont(new Font("Raleway",Font.BOLD,14));
         panField.setBounds(350,440,400,30);
         add(panField);

         JLabel aadhar = new JLabel("Aadhar number:");
         aadhar.setFont(new Font("Raleway",Font.BOLD,20));
         aadhar.setBounds(100,490,180,30);
         add(aadhar);

         aadharField = new JTextField();
         aadharField.setFont(new Font("Raleway",Font.BOLD,14));
         aadharField.setBounds(350,490,400,30);
         add(aadharField);


         JLabel senior = new JLabel("Senior Citizen:");
         senior.setFont(new Font("Raleway",Font.BOLD,20));
         senior.setBounds(100,540,180,30);
         add(senior);

         senioRadioButton= new JRadioButton("Yes");
         senioRadioButton.setFont(new Font("Raleway",Font.BOLD,14));
         senioRadioButton.setBounds(350,540,60,30);
         senioRadioButton.setBackground(Color.WHITE);
         add(senioRadioButton);

         seniorJRadioButton= new JRadioButton("No");
         seniorJRadioButton.setFont(new Font("Raleway",Font.BOLD,14));
         seniorJRadioButton.setBounds(500,540,60,30);
         seniorJRadioButton.setBackground(Color.WHITE);
         add(seniorJRadioButton);

         ButtonGroup seniButtonGroup= new ButtonGroup();
         seniButtonGroup.add(senioRadioButton);
         seniButtonGroup.add(seniorJRadioButton);

         JLabel eaccount = new JLabel("Existing Account:");
         eaccount.setFont(new Font("Raleway",Font.BOLD,20));
         eaccount.setBounds(100,590,180,30);
         add(eaccount);

         yes = new JRadioButton("Yes");
         yes.setFont(new Font("Raleway",Font.BOLD,14));
         yes.setBounds(350,590,60,30);
         yes.setBackground(Color.WHITE);
         add(yes);

         no= new JRadioButton("No");
         no.setFont(new Font("Raleway",Font.BOLD,14));
         no.setBounds(500,590,60,30);
         no.setBackground(Color.WHITE);
         add(no);

         ButtonGroup option = new ButtonGroup();
         option.add(yes);
         option.add(no);

         next = new JButton("Next");
         next.setFont(new Font("Raleway",Font.BOLD,14));
         next.setBounds(630,640,100,30);
         next.setBackground(Color.BLACK);
         next.setForeground(Color.WHITE);
         next.addActionListener(this);
         add(next);


         getContentPane().setBackground(Color.WHITE);
         setSize(850,800);
         setLocation(350,10);
         setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
        String religion =(String) religions.getSelectedItem(); 
        String category= (String) categories.getSelectedItem();
        String income =(String) incomes.getSelectedItem();
        String education = (String) edu.getSelectedItem();
        String occupation = (String) occu.getSelectedItem();
        String pan = panField.getText();
        String aadhar = aadharField.getText();
        String senior  = null;
        if(senioRadioButton.isSelected()){
            senior= "Yes";
        }else if(seniorJRadioButton.isSelected()){
            senior="No";
        }
        String eaccount=null;
        if(yes.isSelected()){
            eaccount="Yes";

        }else if(no.isSelected()){
            eaccount="No";
        
        }
               
        try{

            if(pan.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter your PAN-Number");
            }else if(aadhar.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter your Aadhar Number");
            }else{
                Conn a=new Conn();
               String query ="insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+senior+"','"+eaccount+"')";

                a.s.executeUpdate(query);

                setVisible(false);
                new Pagethree(formno).setVisible(true);


            } 
            
          
            
        }catch(Exception e){
            System.out.println(e);
        }
          

       
                                
        

    }
    public static void main(String args[]){
        new Pagetwo("");
    }
   
    
}
