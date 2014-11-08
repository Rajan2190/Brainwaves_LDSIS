package Controller;

import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.example.www.SocGenCDT.CDTRequest;
import org.example.www.SocGenCDT.CDTResponse;
import org.example.www.SocGenCDT.SocGenCDTProxy;

import database.DBConnection;

/**
 * Servlet implementation class DigitalToken
 */
@WebServlet("/DigitalToken")
public class DigitalToken extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DigitalToken() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String amount=request.getParameter("Amount");
		String accountID=request.getParameter("AccNo");
		RequestDispatcher rd=null;
		System.out.println("HELLO");
		System.out.println("HEllo");
		HttpSession session=request.getSession(true);
		String bankCode=(String)session.getAttribute("Bank");
		String balance=(String)session.getAttribute("balance");
		int bal=Integer.parseInt(balance);
		CDTRequest cdtReq=new CDTRequest();
		cdtReq.setCustomerID(accountID);
		cdtReq.setAccountID(accountID);
		cdtReq.setBankCode(bankCode);
		cdtReq.setAmount(amount);
		SocGenCDTProxy sg=new SocGenCDTProxy();
		CDTResponse cr=null;
		String par="Home.jsp?";
		RequestDispatcher requestDispatcher=null;
		try {
			cr=sg.getCDT(cdtReq);
			String token=null;
			if(cr.getErrorCode()!=null && cr.getErrorCode().equalsIgnoreCase("0"))
			{	token=cr.getTokenID();
				System.out.println(token);
			}
			//token="[@b12340";
			request.setAttribute("tokenID", token);
			if(token!=null){
				session.removeAttribute("balance");
				bal=bal-Integer.parseInt(amount);
				Integer n=new Integer(bal);
				session.setAttribute("balance",n.toString());
				try {
					Connection c = DBConnection.getConnection();
					Statement st = c.createStatement();
					String sql = "update hdfcbank set Balance=" + bal + " where accountno='" + accountID + "';";
					System.out.println("Update sql===>"+sql);
					st.execute(sql);
				} catch (Exception e) {
					System.out.println("Error in manageaccount");
				}
				
			}
			requestDispatcher = request.getRequestDispatcher("Home.jsp");
			requestDispatcher.forward(request, response);
//			requestDispatcher = request.getRequestDispatcher(par);
//			requestDispatcher.forward(request, response);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
