/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikasi;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @jentari20103015
 */
public class dbkoneksi {
    String JDRIVER = "com.mysgl.sj.jdbc";
    String URL = "jdbc:mysql://localhost:3306/data_mhs";
    String USER = "root";
    String PWD = "";
    
    private static Connection koneksi;
    
    public Connection koneksi(){
        if(this.koneksi == null){
            try{
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                koneksi = DriverManager.getConnection(URL, USER, PWD);
                System.out.println("YEIY");
            }catch(Exception e){
                System.out.println("eror");
            }
        }
        return this.koneksi;
    }
    
    
}




