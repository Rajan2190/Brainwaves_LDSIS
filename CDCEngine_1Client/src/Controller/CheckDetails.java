package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.zip.CRC32;

import database.DBConnection;

@WebServlet("/CheckDetails")
public class CheckDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckDetails() {
        super();
    }   

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher;
		try {
			String CustomerID = request.getParameter("CustomerID");
			String Password = request.getParameter("Password");
			//System.out.println("uname: " + CustomerID + " pwd: " + Password);
			CRC32 crc = new CRC32();
			crc.update(Password.getBytes());
			Password = String.valueOf(crc.getValue());
			Connection c = DBConnection.getConnection();
			boolean flag = false;
			Statement st = c.createStatement();
			String sql = "select * from hdfcbank;";
			ResultSet rs = st.executeQuery(sql);
			String par = "Home.jsp?";
			String balance=null;
			while(rs.next()){
				if(rs.getString("CustomerID").equals(CustomerID)){
					if(rs.getString("Password").equals(Password)){
						flag = true;
						//System.out.println(rs.getString("AccountNo"));
						par = par + "AccountNo=" + rs.getString("AccountNo");
						balance=rs.getString("Balance");
						HttpSession session=request.getSession(true);
						session.setAttribute("CustomerID", CustomerID);
						session.setAttribute("AccountNo", rs.getString("AccountNo"));
						session.setAttribute("balance", balance);
						session.setAttribute("Bank", "hdfc");
						//request.setAttribute("AccountNo", rs.getString("AccountNo"));
						//request.setAttribute("Balance", rs.getString("Balance"));
						break;
					}
				}
			}
				if(flag){
					//response.sendRedirect("Home.jsp");
					
					requestDispatcher = request.getRequestDispatcher(par);
					requestDispatcher.forward(request, response);
				}
				else
					response.sendRedirect("ABCLogin.jsp");
				return;
			
		} catch (SQLException e) {
			System.out.println("In check details");
			
		}
		
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
