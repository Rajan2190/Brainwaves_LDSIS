package account;

import java.sql.Connection;
import java.sql.Statement;

import database.DBConnection;

public class ManageAccount {

	public String CustomerID;
	public String AccountNo;
	public String Balance;

	public ManageAccount(String cust, String ano, String bal) {
		this.CustomerID = cust;
		this.AccountNo = ano;
		this.Balance = bal;
	}

	public void increaseBal(String custid, String a) {
		try {
			Connection c = DBConnection.getConnection();
			Statement st = c.createStatement();
			String sql = "update hfdcbank set Balance=" + Integer.parseInt(a) + " where custid='" + custid + "';";
			st.execute(sql);
		} catch (Exception e) {
			System.out.println("Error in manageaccount");
		}
	}

	public void decreaseBal(String custid, String a) {
		try {
			Connection c = DBConnection.getConnection();
			Statement st = c.createStatement();
			String sql = "update hfdcbank set Balance=" + Integer.parseInt(a) + " where custid='" + custid + "';";
			st.execute(sql);
		} catch (Exception e) {
			System.out.println("Error in manageaccount");
		}
	}

	public String getTokens(String a) {
		return "";
	}
}
