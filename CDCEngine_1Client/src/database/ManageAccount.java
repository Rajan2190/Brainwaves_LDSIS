package database;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.CryptoPrimitive;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.Statement;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.mysql.jdbc.ResultSet;

import Controller.CryptoUtil;

import database.DBConnection;

public class ManageAccount {

	public String verifyToken(String token,String bankCode,String accountID){
		CryptoUtil c=new CryptoUtil();
		String data=null;
		boolean flag=false;
		String arr[];
		try {
			data=c.decrypt(token);
			try {
				Connection con = DBConnection.getConnection();
				Statement st = con.createStatement();
				bankCode=bankCode.concat("token");
				String sql = "select tokenID from " + bankCode + " where tokenID='" + token + "';";
				System.out.println("Update sql===>"+sql);
				ResultSet rs=(ResultSet) st.executeQuery(sql);
				if(rs.next()){
					flag=true;
					try {
						sql = "update hdfctoken set ActiveInactive=" + "I" + " where accountno='" + accountID + "';";
						System.out.println("Update sql===>"+sql);
						st.execute(sql);
					} catch (Exception e) {
						System.out.println("Error in manageaccount");
					}
				}else{
					flag=false;
				}
			} catch (Exception e) {
				System.out.println("Error in manageaccount");
			}
			if(flag){
				arr=data.split("\\s+");
				return arr[1];
			}else{
				return "0";
			}
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "0";
	}

	
	
}