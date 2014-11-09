package databaseManager;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.zip.CRC32;
import Commons.CryptoUtil;


public class ProjDAO {
		
		//Get Token		
		public String getCDToken(String custid,String accid,String bankCode,double amount) throws Exception{
			    SimpleDateFormat d=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			    Calendar cal=Calendar.getInstance();
				String input =custid+" "+amount+" "+d.format(cal.getTime());
				System.out.println("insert into===>"+input);
			    CryptoUtil c=new CryptoUtil();
			    String s=c.encrypt(input);
			    return s;
		}
		
		public void insertTokenLog(String token,String custid,String accid,String bankCode,double amount){
			PreparedStatement ps=null;
			Connection con=null;
		    SimpleDateFormat d=new SimpleDateFormat("yyyy-MM-dd");
		    Calendar cal=Calendar.getInstance();
	        //bankCode = bankCode.concat("token");
		    bankCode="hdfctoken";
		    System.out.println("here");
	        String query = "insert into "+bankCode+" values ("+"'"+token+"','"+custid+"','"+accid+"','"+d.format(cal.getTime())+"',null,'A','G','General','"+(int)amount+"');";
			System.out.println(query);
	        try{
				con=DBConnection.getConnection();
				ps=con.prepareStatement(query);
				ps.execute();
			}catch(Exception e){
				System.out.println("Excpetion===>"+e.getMessage());
			}
		}
		
		public static void main(String args[]){
			ProjDAO p=new ProjDAO();
			p.insertTokenLog("123", "Anish", "123", "hdfc", 12);
		}
		
		}
