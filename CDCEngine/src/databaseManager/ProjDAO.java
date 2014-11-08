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
import java.util.Date;
import java.util.HashMap;
import java.util.zip.CRC32;

import Commons.Encrypt;


public class ProjDAO {
		
		//Get Token		
		public String getCDToken(String custid,String accid,String bankCode,double amount) throws Exception{
			 String algorithm = "RC2";   //successfully tested with AES, Blowfish, DES, DESede, RC2
		        Encrypt cryptHandler = new Encrypt(algorithm);
		        String input =custid+" "+accid+" "+bankCode+" "+amount;
		        byte[] encryptedBytes = cryptHandler.encrypt(input);
		        System.out.println("Encrypted result of 'Hello World' : " + encryptedBytes);
		        String s=new String(encryptedBytes);
		        System.out.println(encryptedBytes.toString());
			return encryptedBytes.toString();
		}
		
		//Insert scheme details in to database
		/*public boolean insertContactDetails(SchemeVO schemeInfo,PersonVO personInfo){
			String sname=schemeInfo.getSchemeName();
			String fund=schemeInfo.getFundFrom();
			String focus=schemeInfo.getFocus();
			String dept=schemeInfo.getDepartnment();
			String intiation=schemeInfo.getInitiation();
			String objective=schemeInfo.getObjective();
			String eligibility=schemeInfo.getEligibility();
			String registration=schemeInfo.getRegistration();
			String documents=schemeInfo.getDocuments();
			String benefits=schemeInfo.getBenefits();
			String addtional_condition=schemeInfo.getAdditionalCondition();
			String url=schemeInfo.getUrl();
			String category=schemeInfo.getCategory();
			String bpl=schemeInfo.getBpl();
			String caste=schemeInfo.getCaste();
			String minAge=schemeInfo.getMinAge();
			String maxAge=schemeInfo.getMaxAge();
			String maritialStatus=schemeInfo.getMartialStatus();
			String gender=schemeInfo.getGender();
			String income=schemeInfo.getIncome();
			String occupation=schemeInfo.getOccupation();
			String geography=schemeInfo.getGeography();
			String clamitiy=schemeInfo.getCalamity();
			String disability=schemeInfo.getDisability();
			String lossOfLife=schemeInfo.getLossOfLife();
			Connection con=null;
			PreparedStatement ps=null;
			String insertContact="insert into scheme(sname,fund,dept,focus,init,objective,eligibility,registration,doc,benefit,additional_condition,url,category,isVerified) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				con=DBConnection.getConnection();
				ps=con.prepareStatement(insertContact);
				ps.setString(1,sname);
				ps.setString(2,fund);
				ps.setString(3, dept);
				ps.setString(4,focus);
				ps.setString(5,intiation);
				ps.setString(6,objective);
				ps.setString(7, eligibility);
				ps.setString(8,registration);
				ps.setString(9,documents);
				ps.setString(10, benefits);
				ps.setString(11, addtional_condition);
				ps.setString(12, url);
				ps.setString(13, category);
				ps.setString(14, "NO");
				ps.executeUpdate();
				
				//retrieve latest schemeID
				String schemeIDQuery="select max(sid) sid from scheme";
				String sid="";
				ps=con.prepareStatement(schemeIDQuery);
				ResultSet schemeResultSet=ps.executeQuery();
				if(schemeResultSet.next()){
					sid=schemeResultSet.getString("sid");
				}
				System.out.println("sid====>"+sid);
				
				//update ssid
				String category_map_Query1="update scheme set ssid=? where sid=?";
				ps=con.prepareStatement(category_map_Query1);
				ps.setString(1,sid);
				ps.setString(2,sid);
				ps.executeUpdate();
				
				//insert into category_map
				String category_map_Query="insert into category_map(bpl,caste,minage,maxage,mstatus,gender,income,occupation,geography,calamity,disability,lossOfLife,category,sid) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				ps=con.prepareStatement(category_map_Query);
				ps.setString(1,bpl);
				ps.setString(2,caste);
				ps.setString(3,minAge);
				ps.setString(4,maxAge);
				ps.setString(5,maritialStatus);
				ps.setString(6,gender);
				ps.setString(7,income);
				ps.setString(8, occupation);
				ps.setString(9, geography);
				ps.setString(10, clamitiy);
				ps.setString(11, disability);
				ps.setString(12, lossOfLife);
				ps.setString(13, category);
				ps.setString(14, sid);
				int n1=ps.executeUpdate();
				System.out.println("here goes the n value"+n1);
				
				//insert into person_insert
				String pName=personInfo.getpName();
				String emailID=personInfo.getEmailID();
				String contactNo=personInfo.getContactNO();
				String sysDate=ProjDAO.getSysDate();
				String person_insert_Query="insert into person_insert(pname,emailID,contactNo,pdate,sid) values(?,?,?,?,?)";
				ps=con.prepareStatement(person_insert_Query);
				ps.setString(1,pName);
				ps.setString(2,emailID);
				ps.setString(3,contactNo);
				ps.setString(4,sysDate);
				ps.setString(5, sid);
				int n=ps.executeUpdate();	
				if(n>0){
					return true;
				}
				
			} catch (SQLException e) {
				System.out.println("ContactDAO:::::insertContactDetails::::"+e.getMessage());
			}finally{
				DBConnection.closeConnection(con, ps);
			}
			return false;
		}
		public static String getSysDate(){
			 String pattern = "MM/dd/yyyy hh:mm:ss";
			    SimpleDateFormat format = new SimpleDateFormat(pattern);
			    return format.format(new Date());
		}
		public ArrayList getDropDownValues(){
			Connection con=null;
			PreparedStatement ps=null;
			String selectQuery="select * from info";
			ArrayList dropDownList=new ArrayList();
			DropDownVO dropvo=null;
			try {
				con=DBConnection.getConnection();
				ps=con.prepareStatement(selectQuery);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					dropvo=new DropDownVO();
					dropvo.setAttFlag(rs.getString("attr_val"));
					dropvo.setAttName(rs.getString("attr_name"));
					dropDownList.add(dropvo);
				}
				
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
			return dropDownList;
		}
		public static String getPolicyCount(){
			Connection con=null;
			PreparedStatement ps=null;
			String query="select count(*) count from scheme";
			String count="0";
			try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				count=rs.getString("count");
			}
			}catch(Exception e){
				System.out.println(e.getMessage());
				
			}
			return count;
			
		}
		public static ArrayList getTopContributor(){
			Connection con=null;
			PreparedStatement ps=null;
			String query="select count(*) count,pname from person_insert group by pname order by count(*) desc";
			String count="0";
			String pname="";
			ArrayList<String> list=new ArrayList<String>();
			try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				count=rs.getString("count");
				pname=rs.getString("pname");
			}
			list.add(count);
			list.add(pname);
			}catch(Exception e){
				System.out.println(e.getMessage());
				
			}
			return list;
			
		}
		public static ArrayList getTopFourContributor(){
			Connection con=null;
			PreparedStatement ps=null;
			String query="select * from scheme order by sid desc";
			String sname="";
			String objective="";
			ArrayList<String> list=new ArrayList<String>();
			try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				sname=rs.getString("sname");
				objective=rs.getString("objective");
				list.add(sname);
				list.add(objective);
			}
			}catch(Exception e){
				System.out.println(e.getMessage());
				
			}
			return list;			
		}
		public ArrayList getAllSchemeList(){
			Connection con=null;
			PreparedStatement ps=null;
			String query="select * from scheme order by ssid,sid";
			ArrayList list=new ArrayList();
			SchemeVO schemeVO=null;
			try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			String sid="";
			String ssid="";
			boolean flag=false;
			boolean first=true;
			HashMap h=null;
			while(rs.next()){
				schemeVO=new SchemeVO();
				schemeVO.setSchemeName(rs.getString("sname"));
				schemeVO.setEligibility(rs.getString("eligibility"));
				schemeVO.setObjective(rs.getString("objective"));
				schemeVO.setDocuments(rs.getString("doc"));
				schemeVO.setBenefits(rs.getString("benefit"));
				schemeVO.setUrl(rs.getString("url"));
				schemeVO.setValidateCount(rs.getString("validate_count"));
				schemeVO.setCategory(rs.getString("category"));
				schemeVO.setIsVerified(rs.getString("isVerified"));
				sid=rs.getString("sid");
				ssid=rs.getString("ssid");
				schemeVO.setsID(sid);
				schemeVO.setSsid(ssid);
				System.out.println("sid==>"+sid);
				System.out.println("ssid===>"+ssid);
				if(sid.equalsIgnoreCase(ssid)){
					if(first)
					{
					h=new HashMap();
					h.put(sid, schemeVO);
					first=false;
					}
					else
					{
						list.add(h);
						h=new HashMap();
						h.put(sid, schemeVO);
						
					}
				}else{
					h.put(sid, schemeVO);
				}
				
			}
			list.add(h);
			
			}catch(Exception e){
				System.out.println("lest dksadk===>"+e.getMessage());
				
			}
			return list;
			
		}
		public boolean updateScheme(SchemeVO schemeInfo){
			Connection con=null;
			PreparedStatement ps=null;
			String query="insert into scheme(ssid,sname,objective,eligibility,doc,url,isVerified) values(?,?,?,?,?,?,?)";
			ArrayList<SchemeVO> list=new ArrayList<SchemeVO>();
			String sname=schemeInfo.getSchemeName();
			String sid=schemeInfo.getsID();
			String objective=schemeInfo.getObjective();
			String eligibility=schemeInfo.getEligibility();
			String documents=schemeInfo.getDocuments();
			String url=schemeInfo.getUrl();
			try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1,sid);
			ps.setString(2,sname);
			ps.setString(3, objective);
			ps.setString(4,eligibility);
			ps.setString(5,documents);
			ps.setString(6,url);
			ps.setString(7, "NO");
			int n=ps.executeUpdate();	
			if(n>0){
				return true;
			}
			}catch(Exception e){
				System.out.println(e.getMessage());
				
			}
			return false;
		}*/
}
