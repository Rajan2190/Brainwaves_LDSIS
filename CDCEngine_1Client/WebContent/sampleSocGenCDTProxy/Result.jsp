<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleSocGenCDTProxyid" scope="session" class="org.example.www.SocGenCDT.SocGenCDTProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleSocGenCDTProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleSocGenCDTProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleSocGenCDTProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        org.example.www.SocGenCDT.SocGenCDT_PortType getSocGenCDT_PortType10mtemp = sampleSocGenCDTProxyid.getSocGenCDT_PortType();
if(getSocGenCDT_PortType10mtemp == null){
%>
<%=getSocGenCDT_PortType10mtemp %>
<%
}else{
        if(getSocGenCDT_PortType10mtemp!= null){
        String tempreturnp11 = getSocGenCDT_PortType10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String amount_2id=  request.getParameter("amount24");
            java.lang.String amount_2idTemp = null;
        if(!amount_2id.equals("")){
         amount_2idTemp  = amount_2id;
        }
        String bankCode_3id=  request.getParameter("bankCode26");
            java.lang.String bankCode_3idTemp = null;
        if(!bankCode_3id.equals("")){
         bankCode_3idTemp  = bankCode_3id;
        }
        String customerID_4id=  request.getParameter("customerID28");
            java.lang.String customerID_4idTemp = null;
        if(!customerID_4id.equals("")){
         customerID_4idTemp  = customerID_4id;
        }
        String accountID_5id=  request.getParameter("accountID30");
            java.lang.String accountID_5idTemp = null;
        if(!accountID_5id.equals("")){
         accountID_5idTemp  = accountID_5id;
        }
        %>
        <jsp:useBean id="org1example1www1SocGenCDT1CDTRequest_1id" scope="session" class="org.example.www.SocGenCDT.CDTRequest" />
        <%
        org1example1www1SocGenCDT1CDTRequest_1id.setAmount(amount_2idTemp);
        org1example1www1SocGenCDT1CDTRequest_1id.setBankCode(bankCode_3idTemp);
        org1example1www1SocGenCDT1CDTRequest_1id.setCustomerID(customerID_4idTemp);
        org1example1www1SocGenCDT1CDTRequest_1id.setAccountID(accountID_5idTemp);
        org.example.www.SocGenCDT.CDTResponse getCDT13mtemp = sampleSocGenCDTProxyid.getCDT(org1example1www1SocGenCDT1CDTRequest_1id);
if(getCDT13mtemp == null){
%>
<%=getCDT13mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">errorMessage:</TD>
<TD>
<%
if(getCDT13mtemp != null){
java.lang.String typeerrorMessage16 = getCDT13mtemp.getErrorMessage();
        String tempResulterrorMessage16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeerrorMessage16));
        %>
        <%= tempResulterrorMessage16 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">errorCode:</TD>
<TD>
<%
if(getCDT13mtemp != null){
java.lang.String typeerrorCode18 = getCDT13mtemp.getErrorCode();
        String tempResulterrorCode18 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeerrorCode18));
        %>
        <%= tempResulterrorCode18 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">tokenID:</TD>
<TD>
<%
if(getCDT13mtemp != null){
java.lang.String typetokenID20 = getCDT13mtemp.getTokenID();
        String tempResulttokenID20 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typetokenID20));
        %>
        <%= tempResulttokenID20 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>