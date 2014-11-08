package Controller;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.www.SocGenCDT.CDTRequest;
import org.example.www.SocGenCDT.CDTResponse;
import org.example.www.SocGenCDT.SocGenCDTProxy;

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
		String bankCode="12";
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
			par = par + "AccountNo=" + "12345" + "&Balance=" + 10000;
			//token="[@b12340";
			request.setAttribute("tokenID", token);
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
