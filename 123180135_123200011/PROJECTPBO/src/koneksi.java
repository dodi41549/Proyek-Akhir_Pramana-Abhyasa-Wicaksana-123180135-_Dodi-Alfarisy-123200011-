import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
class koneksi {
    
            
    
    public void panggildriver(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Sukses Memanggil Driver");
            
        }catch(ClassNotFoundException e){
            System.out.println("Gagal Memanggil Driver");
        }finally{
            System.out.println("Proses Pemanggilan Driver Selesai");
        }
    }
    public Connection cn = null;
    public Connection koneksi(){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/roti","root","");
            System.out.println("Berhasil Terkoneksi");
        }catch (SQLException e){
            System.out.println("Gagal Terkoneksi");
        }finally{
            System.out.println("Proses Pemanggilan Koneksi Selesai");
        }
        return cn;
    }
    
    public static void main (String[] args){
        koneksi b = new koneksi();
                b.panggildriver();
        
        
        }
    }
