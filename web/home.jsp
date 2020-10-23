<%-- 
    Document   : home
    Created on : 21 oct. 2020, 07:55:17
    Author     : Elyus77
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="p1.DB"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>PROGRAMME TEST</h1>
        <img src="images/FR.jpg" width="168" height="153" alt="FR"/>

        <table 
        id="people"
        class="table table-bordered text-yellow  table-bordered table-striped table-condensed"
        data-toggle="table"
        data-search-align="left"
        data-search="true"
        
        data-show-toggle="true"
        data-show-fullscreen="true"
        
        data-toolbar="#toolbar"
        data-click-to-select="true"
        >
        <thead style="background-color: #ffffff; border: solid #222;">
           
            <tr >
                <th data-field="id" data-sortable="true" data-switchable="false">nom</th>
                <th data-field="nomPrenom" data-sortable="true" data-switchable="false">numero</th>
            </tr>
        </thead>
        <tbody>
        
            <%
    try{
        int i=1;
        Connection con = DB.getConnection();
        PreparedStatement pss = con.prepareStatement("SELECT * FROM tab1 order by nom");
        ResultSet rs = pss.executeQuery();
        
        while(rs.next()){
            
 %>   
<tr>
    <td style="font-size: 12pt;"><label><%=rs.getString("nom")%></label></td>
    <td style="font-size: 12pt;"><label><%=rs.getString("numero")%></label></td>
</tr>

<% 
i++;
}
    }catch(Exception e){
        e.printStackTrace();
    }
%>
        </tbody>
    </table>
    </body>
</html>
