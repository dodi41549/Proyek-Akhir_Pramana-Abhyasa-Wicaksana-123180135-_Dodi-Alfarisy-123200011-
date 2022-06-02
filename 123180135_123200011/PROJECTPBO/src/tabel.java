import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class tabel extends JFrame{
     JTable table= new JTable();
     DefaultTableModel model = new DefaultTableModel();
     JScrollPane scroll=new JScrollPane(table);
     
     JTextField kd = new JTextField();
     JButton hps = new JButton ("Hapus");
    
     
     
     
     public tabel(){
        setLayout(null);
        setTitle("Detail ");
        setVisible(true);
        setSize(650,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        JButton kmb = new JButton ("Kembali");
        kmb.setBounds(350,290,100,20);
        add(kmb);
        kd.setBounds(10,290,100,20);
        add(kd);
        hps.setBounds(110,290,100,20);
        add(hps);
     
        
        
        getContentPane().setLayout(null);
        getContentPane().add(scroll,BorderLayout.CENTER);    
        scroll.setBounds(20, 40, 600, 200);
        
       
        kmb.addActionListener(new ActionListener(){
            @Override
    public void actionPerformed(ActionEvent e) {
            kelompok14 a = new kelompok14();
            a.setSize(400,650);
            a.setLayout(null);
            a.tampildata();
            a.setVisible(true);
            Color wrn = new Color(204, 102, 255);
        Container warna = a.getContentPane();
        warna.setBackground(wrn);
            dispose();

    }
        });
        
        hps.addActionListener(new ActionListener(){
            @Override
    public void actionPerformed(ActionEvent e) {
            HapusData();
            dispose();
            tabel x = new tabel();
            x.tabel();
            x.setVisible(true);
    }
     });
        }
     
     public void HapusData(){ 
    int i = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus data ini?",
                        "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if(i == 0){
    try {   
       Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/roti","root","");
        String query = "DELETE FROM tbl_roti WHERE No ='"+ kd.getText() +"'";
        PreparedStatement st = cn.prepareStatement(query);
        st.executeUpdate();
        
        
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        kd.setText("");
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
        System.err.println(""+e);
        } 
    }
    }     
  public void tabel(){
       
        model.fireTableDataChanged();
        model.getDataVector().removeAllElements();
        table.setModel(model);
        model.addColumn("No");
        model.addColumn("Nama Pembeli");
        model.addColumn("Jenis Barang");
        model.addColumn("Rasa");
        model.addColumn("Jumlah Order");
        model.addColumn("Harga");
        
         
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/roti","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from tbl_roti order by No ASC");
      
            
           while(rs.next()){
                Object[] obj = new Object[6];
                obj[0]=rs.getString(1);
                obj[1]=rs.getString(2);
                obj[2]=rs.getString(3);
                obj[3]=rs.getString(4);
                obj[4]=rs.getString(5);
                obj[5]=rs.getString(6);
                model.addRow(obj);   
            }
           rs.close();
           st.close();
           con.close();
        }catch(SQLException e){
            
        }
        }
  
public static void main(String[]args)
        {
            tabel a= new tabel();
a.tabel();
            
        }

    
       
    }
                
