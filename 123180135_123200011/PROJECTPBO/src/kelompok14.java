import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class kelompok14 extends JFrame {
    int b;
    
    JLabel nama = new JLabel ("PROGRAM PENJUALAN ROTI");
    JLabel namap = new JLabel ("Nama Pembeli");
    JLabel jbr = new JLabel ("Jenis Barang");
    String jb[] = {"1. Roti" , "2. Brownies"};
    JComboBox jb2 = new JComboBox (jb);
    JLabel namab = new JLabel ("Rasa");
    JLabel jmor = new JLabel ("Jumlah Order");
    JLabel hrg = new JLabel ("Harga");
    
    JTextField tnamap = new JTextField ();
    JTextField tnamab = new JTextField ();
    JTextField tjmor = new JTextField ();
    JTextField thrg = new JTextField ();
    JTextArea klr = new JTextArea ();
    JTextArea info = new JTextArea("Roti : Rp 10.000" + "\nBrownies : Rp 25.000");
    
    JButton smp = new JButton ("Simpan");
    JButton hps = new JButton ("Hapus");
    JButton lihat = new JButton ("Lihat Data");
    
   public void tampildata (){
    setSize(400,650);
    setLayout(null);
    setVisible(true);
    nama.setFont(new Font("Times New Roman", Font.BOLD, 14));
    nama.setForeground(Color.white);
    nama.setBounds(30,10,350,20);
    namap.setForeground(Color.black);
    namap.setBounds(20,50,150,20);
    jbr.setForeground(Color.black);
    jbr.setBounds(20,100,150,20);
    jb2.setBounds(110,100,130,20);
    namab.setForeground(Color.black);
    namab.setBounds(20,150,130,20);
    jmor.setForeground(Color.black);
    jmor.setBounds(20,200,130,20);
    hrg.setForeground(Color.black);
    hrg.setBounds(20,250,130,20);
    tnamap.setBounds(110,50,130,20);
    tnamab.setBounds(110,150,130,20);
    tjmor.setBounds(110,200,130,20);
    thrg.setBounds(110,250,130,20);
    klr.setBounds(20,340,300,100);
    smp.setBounds(20,290,100,20);
    hps.setBounds(130,290,100,20);
    lihat.setBounds(240,290,100,20);
    info.setBounds(250,100,130,50);
   
    
    add(nama);
    add(namap);
    add(jbr);
    add(jb2);
    add(namab);
    add(jmor);
    add(hrg);
    add(tnamap);
    add(tnamab);
    add(tjmor);
    add(thrg);
    add(klr);
    add(info);
    add(smp);
    add(hps);
    add(lihat);
    
    
        smp.addActionListener( new ActionListener (){
            @Override
        public void actionPerformed(ActionEvent e){
            

            
            
           
           if(tnamap.getText().equals("") || tnamab.getText().equals("") || tjmor.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Isi data dengan Benar");
            }else{
               
               if(jb2.getSelectedItem().equals("1. Roti")){
                 int order = Integer.parseInt(tjmor.getText());
                 int hsl = order * 10000;
                 thrg.setText(String.valueOf(hsl));
            }
            else if(jb2.getSelectedItem().equals("2. Brownies")){
                 int order = Integer.parseInt(tjmor.getText());
                 int hsl = order * 25000;
                 thrg.setText(String.valueOf(hsl));
            }
           try{
               auto();
               Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/roti", "root","");
               PreparedStatement stat = cn.prepareStatement("insert into tbl_roti values ('"+no+"','" + tnamap.getText() + "', '" + jb2.getSelectedItem() + "', '" + tnamab.getText() + "', '" + tjmor.getText()+ "', '" + thrg.getText() + "')");
               stat.execute();
}
           catch(SQLException el){
               JOptionPane.showMessageDialog(null, el);
           }klr.setText("Nama Pembeli : " +tnamap.getText() + "\nJenis Barang : " + jb2.getSelectedItem() + "\nNama Barang : " + tnamab.getText() + "\nJumlah Order : " + tjmor.getText() + "\nHarga : " + thrg.getText());
        }}
    });
  
        
        hps.addActionListener( new ActionListener (){
            @Override
        public void actionPerformed(ActionEvent e){
            tnamap.setText("");
            tnamab.setText("");
            tjmor.setText("");
            thrg.setText("");
            klr.setText("");
        }
    });
        
        lihat.addActionListener( new ActionListener (){
            @Override
        public void actionPerformed(ActionEvent e){
            
            tabel n = new tabel();
            n.setVisible(true);
            n.tabel();
        }
    });
   }
   String no;
     public void auto(){
       try{
           Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/roti", "root","");
           Statement st = cn.createStatement();
           String query = "SELECT MAX(No) from tbl_roti ";
           ResultSet rs = st.executeQuery(query);
           if(rs.next()){
               int a = rs.getInt(1);
               no = Integer.toString(a+1);
           }
           rs.close();
           st.close();
       }
       catch(Exception ex){
           System.out.println(ex);
       }
   }

    public static void main (String [] args)
    {
        kelompok14 a = new kelompok14();
        Color wrn = new Color(169, 169, 169);
        Container warna = a.getContentPane();
        warna.setBackground(wrn);
        a.tampildata();
    
    
    }

}
    
    
    
