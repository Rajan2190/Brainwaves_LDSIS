/**
 * SocGenCDTSOAPSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.example.www.SocGenCDT;

import databaseManager.ProjDAO;

public class SocGenCDTSOAPSkeleton implements org.example.www.SocGenCDT.SocGenCDT_PortType, org.apache.axis.wsdl.Skeleton {
    private org.example.www.SocGenCDT.SocGenCDT_PortType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CDTRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.example.org/SocGenCDT/", "CDTRequest"), org.example.www.SocGenCDT.CDTRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getCDT", _params, new javax.xml.namespace.QName("", "CDTResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.example.org/SocGenCDT/", "CDTResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "GetCDT"));
        _oper.setSoapAction("http://www.example.org/SocGenCDT/GetCDT");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getCDT") == null) {
            _myOperations.put("getCDT", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getCDT")).add(_oper);
    }

    public SocGenCDTSOAPSkeleton() {
        this.impl = new org.example.www.SocGenCDT.SocGenCDTSOAPImpl();
    }

    public SocGenCDTSOAPSkeleton(org.example.www.SocGenCDT.SocGenCDT_PortType impl) {
        this.impl = impl;
    }
    public org.example.www.SocGenCDT.CDTResponse getCDT(org.example.www.SocGenCDT.CDTRequest CDTRequest) throws java.rmi.RemoteException
    {
    	System.out.println("Inside");
  	  String token=null;
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
      	try {
			token=p.getCDToken(custid, accid, bankCode, Double.parseDouble(amount));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      	if(token!=null){
      		resMessage.setTokenID(token);
      		resMessage.setErrorCode("0");
      		resMessage.setErrorMessage("SUCESS");
      	}else{
      		resMessage.setTokenID("");
      		resMessage.setErrorCode("1");
          	resMessage.setErrorMessage("Invalid inputs");
      	}
      }
      System.out.println(token);
      return resMessage;
    }

}
