
package airlinemanagementsystem;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JTextField tfname,tfphonenumber,tfaadhar,tfnationality,tfaddress;
    JRadioButton rbmale,rbfemale;
    
    public AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("ADD CUSTOMER DETAILES");
        heading.setBounds(250,20,500,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        JLabel lbname=new JLabel("Name");
        lbname.setBounds(60,80,150,25);
        lbname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbname);
        
        tfname=new JTextField();
        tfname.setBounds(220,80,150,25);
        add(tfname);
        
        JLabel lbnationality=new JLabel("Nationality");
        lbnationality.setBounds(60,130,150,25);
        lbnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbnationality);
        
        tfnationality=new JTextField();
        tfnationality.setBounds(220,130,150,25);
        add(tfnationality);
        
        JLabel lbaadhar=new JLabel("Aadhar Number");
        lbaadhar.setBounds(60,180,150,25);
        lbaadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbaadhar);
        
        tfaadhar=new JTextField();
        tfaadhar.setBounds(220,180,150,25);
        add(tfaadhar);
        
        JLabel lbaddress=new JLabel("Address");
        lbaddress.setBounds(60,230,150,25);
        lbaddress.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbaddress);
        
        tfaddress=new JTextField();
        tfaddress.setBounds(220,230,150,25);
        add(tfaddress);
        
        JLabel lbgender=new JLabel("Gender");
        lbgender.setBounds(60,280,150,25);
        lbgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbgender);
        
        ButtonGroup gendergroup=new ButtonGroup();
        
        rbmale=new JRadioButton("Male");
        rbmale.setBounds(220,280,70,25);
        add(rbmale);
        
        rbfemale=new JRadioButton("Female");
        rbfemale.setBounds(300,280,70,25);
        add(rbfemale);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        
        JLabel lbphonenumber=new JLabel("Phone Number");
        lbphonenumber.setBounds(60,330,150,25);
        lbphonenumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbphonenumber);
        
        tfphonenumber=new JTextField();
        tfphonenumber.setBounds(220,330,150,25);
        add(tfphonenumber);
        
        JButton save=new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220,380,150,30);
        save.addActionListener(this);
        add(save);
        
        ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel lbimage=new JLabel(image);
        lbimage.setBounds(450,80,280,400);
        add(lbimage);
        
        setSize(900,600);
        setLocation(300,150);
        setVisible(true);
    }
     
    public void actionPerformed(ActionEvent ae){
        String name=tfname.getText();
        String nationality=tfnationality.getText();
        String phonenumber=tfphonenumber.getText();
        String address=tfaddress.getText();
        String aadhar=tfaadhar.getText();
        String gender=null;
        if(rbmale.isSelected()){
            gender="male";
        }
        else{
            gender="Female";
        }
        try{
            Conn conn=new Conn();
            String query="insert into passenger values('"+name+"','"+nationality+"','"+phonenumber+"','"+address+"','"+aadhar+"','"+gender+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
            setVisible(false);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new AddCustomer();
    }
}
