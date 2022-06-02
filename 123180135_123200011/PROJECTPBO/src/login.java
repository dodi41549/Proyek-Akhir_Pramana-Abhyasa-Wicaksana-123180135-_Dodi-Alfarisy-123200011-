import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame implements ActionListener{
    JLabel user, pass, form;
    JTextField txtuser;
    JPasswordField txtpass;
    JButton login = new JButton();
    public login(){
        form = new JLabel();
        form.setFont(new Font("Times New Roman",1,15));
        form.setForeground(Color.black);
        form.setText("FORM LOGIN");
        form.setBounds(180, 10, 150, 25);
        add(form);
        
        user = new JLabel();
        user.setFont(new Font("jokerman",1,12));
        user.setText("USERNAME");
        user.setBounds(90, 50, 100, 25);
        add(user);
        
        txtuser = new JTextField();
        txtuser.setFont(new Font("times new roman",1,14));
        txtuser.setBounds(210, 50, 200, 25);
        add(txtuser);
        
        pass = new JLabel();
        pass.setFont(new Font("jokerman",1,12));
        pass.setText("PASSWORD");
        pass.setBounds(90, 85, 100, 25);
        add(pass);
        
        txtpass = new JPasswordField();
        txtpass.setFont(new Font("times new roman",1,14));
        txtpass.setBounds(210, 85, 200, 25);
        add(txtpass);
        
        login.setFont(new Font("times new roman",1,14));
        login.setBounds(210, 120, 100, 25);
        login.setText("LOGIN");
        login.addActionListener(this);
        add(login);
        
        /*JFrame*/
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("CREATED BY KELOMPOK 14");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 200);
        this.setVisible(true);
    }
    
    public static void main(String[] args){
        JFrame.setDefaultLookAndFeelDecorated(true);
        login pt = new login();
        Color wrn = new Color(255, 255, 255);
        Container warna = pt.getContentPane();
        warna.setBackground(wrn);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("LOGIN")){
            if(txtuser.getText().equals("kelompok14") && txtpass.getText().equals("kelompok14")){
                kelompok14 l = new kelompok14();
                Color wrn = new Color(204, 102, 255);
                Container warna = l.getContentPane();
                warna.setBackground(wrn);
                l.setVisible(true);
                l.tampildata();
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Isi Username atau Password dengan benar!");
            }
        }
    } 
}
