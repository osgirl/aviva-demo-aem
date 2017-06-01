<%@include file="/libs/fd/af/components/guidesglobal.jsp" %>
<%@include file="/libs/foundation/global.jsp"%>
<%@page import="com.day.cq.wcm.foundation.forms.FormsHelper,
             org.apache.sling.api.resource.ResourceUtil,
             org.apache.sling.api.resource.ValueMap" %>

<%@page import="com.avivademo.aem.core.api.CarQuoteManager" %>

<%@taglib prefix="sling"
                uri="http://sling.apache.org/taglibs/sling/1.0" %>
<%@taglib prefix="cq"
                uri="http://www.day.com/taglibs/cq/1.0"
%>
<cq:defineObjects/>
<sling:defineObjects/>
<%

    String Name = request.getParameter("name");
    String Address = request.getParameter("address");
    String Email = request.getParameter("email");
    String Mobile_no = request.getParameter("mobile_no");
    String Dob = request.getParameter("dob");
    String Vehicle_year = request.getParameter("vehicle_year");
    String Vehicle_make = request.getParameter("vehicle_make");
    String Model = request.getParameter("model");
    String BodyType = request.getParameter("bodyType");
    String EngineType = request.getParameter("engineType");
    String Cb_roadside_assistance = request.getParameter("cb_roadside_assistance");
    String Cb_personal_accident_coverage = request.getParameter("cb_personal_accident_coverage");
    String Rb_2_4_years = request.getParameter("rb_2_4_years");
    String Email = request.getParameter("email");

    Map map = new HashMap(); 
    map.put(name, Name);
    map.put(address, Address);
    map.put(email, Email);
    map.put(mobile_no, Mobile_no);
    map.put(dob, Dob);
    map.put(vehicle_year, Vehicle_year);
    map.put(vehicle_make, Vehicle_make);
    map.put(model, Model);
    map.put(bodyType, BodyType);
    map.put(engineType, EngineType);
    map.put(cb_roadside_assistance, Cb_roadside_assistance);
    map.put(cb_personal_accident_coverage, Cb_personal_accident_coverage);
    map.put(rb_2_4_years, Rb_2_4_years);

    log.info("Data posted from an AEM adaptive form - Name: "+Name +" Address "+Address) ;

	resourceResolver res = slingRequest.getResourceResolver();
    CarQuoteManager m1=Sling.getService(CarQuoteManager.class);

    String response= m1.saveCustomerQuote(res, map);

 
%>