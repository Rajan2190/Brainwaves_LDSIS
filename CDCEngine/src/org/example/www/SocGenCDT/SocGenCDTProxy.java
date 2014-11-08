package org.example.www.SocGenCDT;

import databaseManager.ProjDAO;

public class SocGenCDTProxy implements org.example.www.SocGenCDT.SocGenCDT_PortType {
  private String _endpoint = null;
  private org.example.www.SocGenCDT.SocGenCDT_PortType socGenCDT_PortType = null;
  
  public SocGenCDTProxy() {
    _initSocGenCDTProxy();
  }
  
  public SocGenCDTProxy(String endpoint) {
    _endpoint = endpoint;
    _initSocGenCDTProxy();
  }
  
  private void _initSocGenCDTProxy() {
    try {
      socGenCDT_PortType = (new org.example.www.SocGenCDT.SocGenCDT_ServiceLocator()).getSocGenCDTSOAP();
      if (socGenCDT_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)socGenCDT_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)socGenCDT_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (socGenCDT_PortType != null)
      ((javax.xml.rpc.Stub)socGenCDT_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.example.www.SocGenCDT.SocGenCDT_PortType getSocGenCDT_PortType() {
    if (socGenCDT_PortType == null)
      _initSocGenCDTProxy();
    return socGenCDT_PortType;
  }
  
  public org.example.www.SocGenCDT.CDTResponse getCDT(org.example.www.SocGenCDT.CDTRequest CDTRequest) throws java.rmi.RemoteException{
	  String token=null;
	  if (socGenCDT_PortType == null)
      _initSocGenCDTProxy();
    String custid=CDTRequest.getCustomerID();
    String accid=CDTRequest.getAccountID();
    String amount=CDTRequest.getAmount();
    String bankCode=CDTRequest.getBankCode();
    CDTResponse resMessage=new CDTResponse();
    if(custid==null || accid==null || amount==null || bankCode==null){
    	resMessage.setErrorCode("1");
    	resMessage.setErrorMessage("Invalid inputs");
    }else{
    	ProjDAO p=new ProjDAO();
    	token=p.getCDToken(custid, accid, bankCode, Double.parseDouble(amount));
    	if(token!=null){
    		resMessage.setTokenID(token);
    		resMessage.setErrorCode("0");
    		resMessage.setErrorMessage("SUCESS");
    	}else{
    		resMessage.setErrorCode("1");
        	resMessage.setErrorMessage("Invalid inputs");
    	}
    }
    return resMessage;
  }
  
  
}