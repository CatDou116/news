package uitl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FengZhuang {	
   
public	static Connection  getcon( ) {
	   Connection cun =null;
	   try {
		  
			Class.forName("com.mysql.jdbc.Driver");
			 cun =DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	   
	   return cun;	   
   }

public  ResultSet  getjie(String st,List lis) {
	Connection cun=this.getcon();
	ResultSet rs=null;
	try {
	PreparedStatement pst = cun.prepareStatement(st);
	if(lis!=null) {
	for(int i=0;i<lis.size();i++) {
		
		pst.setObject(i+1, lis.get(i));
		
		   }
	}
	   rs=pst.executeQuery();
	
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
   
	return rs;
}



public int  ZSG(String st1,List lis1) {
	Connection cun=this.getcon();
	int a=0;
	try {
	
	PreparedStatement pst = cun.prepareStatement(st1);
	if(lis1!=null) {
	for(int i=0;i<lis1.size();i++) {
		
		pst.setObject(i+1, lis1.get(i));
		
		   }  
	}
	   a=pst.executeUpdate();
	
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
   
	return a;
	

	
}





}
