package CDCApp;

import java.rmi.RemoteException;

import org.example.www.SocGenCDT.CDTRequest;
import org.example.www.SocGenCDT.CDTResponse;
import org.example.www.SocGenCDT.SocGenCDTProxy;

public class TestWebService {

	public static void main(String[] args) {
		System.out.println("HELLO");
		System.out.println("HEllo");
				String customerID="12";
		String accountID="12";
		String bankCode="12";
		String amount="12";
		CDTRequest cdtReq=new CDTRequest();
		cdtReq.setCustomerID(customerID);
		cdtReq.setAccountID(accountID);
		cdtReq.setBankCode(bankCode);
		cdtReq.setAmount(amount);
		SocGenCDTProxy sg=new SocGenCDTProxy();
		CDTResponse cr=null;
		try {
			cr=sg.getCDT(cdtReq);
			String token=null;
			if(cr.getErrorCode()!=null && cr.getErrorCode().equalsIgnoreCase("0"))
			{	token=cr.getTokenID();
				System.out.println(token);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}