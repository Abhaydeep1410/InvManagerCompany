/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author abhaydeep
 */

import java.sql.Connection;
import java.sql.DriverManager;
public class connectionClass {
	
	public Connection connection;
//    String databaseName="inv_db";
//    String tablename="table1";
//    String username="root";
//    String password="abhay1001!";
//    String url="jdbc:mysql://localhost:3306/"+databaseName;
//    
    
    public Connection getConnection(){
try{

//    connection = DriverManager.getConnection(url,username,password);
    String currentDir=System.getProperty("user.dir");

	connection = DriverManager.getConnection("jdbc:derby:"+currentDir+"/db");

}
catch (Exception e){
    System.out.println("database not found");
    e.printStackTrace();
}

        return  connection;
    }


}
