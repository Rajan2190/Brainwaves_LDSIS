/**
 * SocGenCDT_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.example.www.SocGenCDT;

public class SocGenCDT_ServiceLocator extends org.apache.axis.client.Service implements org.example.www.SocGenCDT.SocGenCDT_Service {

    public SocGenCDT_ServiceLocator() {
    }


    public SocGenCDT_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SocGenCDT_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SocGenCDTSOAP
    private java.lang.String SocGenCDTSOAP_address = "http://localhost:8080/CDCEngine_1/services/SocGenCDTSOAP";

    public java.lang.String getSocGenCDTSOAPAddress() {
        return SocGenCDTSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SocGenCDTSOAPWSDDServiceName = "SocGenCDTSOAP";

    public java.lang.String getSocGenCDTSOAPWSDDServiceName() {
        return SocGenCDTSOAPWSDDServiceName;
    }

    public void setSocGenCDTSOAPWSDDServiceName(java.lang.String name) {
        SocGenCDTSOAPWSDDServiceName = name;
    }

    public org.example.www.SocGenCDT.SocGenCDT_PortType getSocGenCDTSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SocGenCDTSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSocGenCDTSOAP(endpoint);
    }

    public org.example.www.SocGenCDT.SocGenCDT_PortType getSocGenCDTSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.example.www.SocGenCDT.SocGenCDTSOAPStub _stub = new org.example.www.SocGenCDT.SocGenCDTSOAPStub(portAddress, this);
            _stub.setPortName(getSocGenCDTSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSocGenCDTSOAPEndpointAddress(java.lang.String address) {
        SocGenCDTSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.example.www.SocGenCDT.SocGenCDT_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                org.example.www.SocGenCDT.SocGenCDTSOAPStub _stub = new org.example.www.SocGenCDT.SocGenCDTSOAPStub(new java.net.URL(SocGenCDTSOAP_address), this);
                _stub.setPortName(getSocGenCDTSOAPWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SocGenCDTSOAP".equals(inputPortName)) {
            return getSocGenCDTSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.example.org/SocGenCDT/", "SocGenCDT");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.example.org/SocGenCDT/", "SocGenCDTSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SocGenCDTSOAP".equals(portName)) {
            setSocGenCDTSOAPEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
