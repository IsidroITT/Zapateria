
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Toshiba-PC
 */
public class ConexionBD {
    /**
     *Metodo de conexion con la base de datos
     */
    public static Connection getConetion(){
     
        String connectionURL="jdbc:sqlserver://;serverName=172.16.213.128;"
                + "databaseName=PRUEBA_ISIDRO;"
                + "user=sa;"
                + "password=kanna@123;";
    
        try{
        Connection con=DriverManager.getConnection(connectionURL);
            System.out.println("Conectado con exito");
        return con;
        }catch(SQLException e){
        System.out.println(e.toString());
            System.out.println("No se ha podido establecer conexion");
        return null;
        }

    }
    
    public static void main(String[] args) {
       ConexionBD hola = new ConexionBD();
       System.out.println("Esperando conexion... \n");
       hola.getConetion();
        
    }
}