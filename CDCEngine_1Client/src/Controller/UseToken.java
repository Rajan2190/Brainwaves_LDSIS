package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DBConnection;
import database.ManageAccount;

/**
 * Servlet implementation class UseToken
 */
@WebServlet("/UseToken")
public class UseToken extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UseToken() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String token=request.getParameter("token");
		ManageAccount m=new ManageAccount();
		HttpSession session=request.getSession();
		String accountID=(String)session.getAttribute("AccountNo");
		System.out.println("Inside usetoken==>"+accountID);
		String bankCode=(String)session.getAttribute("Bank");
		String arr=m.verifyToken(token,bankCode,accountID);
		System.out.println("Inside arr===>"+arr);
		String balance=(String)session.getAttribute("balance");
		int bal=Integer.parseInt(balance);
			session.removeAttribute("balance");
			bal=bal+(int)Double.parseDouble(arr);
			Integer n=new Integer(bal);
			session.setAttribute("balance",n.toString());
			RequestDispatcher requestDispatcher=null;
			try {
				Connection c = DBConnection.getConnection();
				Statement st = c.createStatement();
				String sql = "update hdfcbank set Balance=" + bal + " where accountno='" + accountID + "';";
				System.out.println("Update sql===>"+sql);
				st.execute(sql);
			} catch (Exception e) {
				System.out.println("Error in manageaccount");
			}
			requestDispatcher = request.getRequestDispatcher("Home.jsp");
			requestDispatcher.forward(request, response);
		}

}
