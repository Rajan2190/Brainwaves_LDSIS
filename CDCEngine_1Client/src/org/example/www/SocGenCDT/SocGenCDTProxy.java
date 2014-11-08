package org.example.www.SocGenCDT;

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
    if (socGenCDT_PortType == null)
      _initSocGenCDTProxy();
    
    return socGenCDT_PortType.getCDT(CDTRequest);
  }
  
  
}