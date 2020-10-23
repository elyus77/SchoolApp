/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Elyus77
 */
@WebServlet(name = "UploadImage",urlPatterns = {"/UploadImage"})
@MultipartConfig(maxFileSize = 647088640)//1.5mb
/*
I have added the following in the my.cnf as follows

[mysqld]
max_allowed_packet=32M
[mysql]
max_allowed_packet=32M


*/

public class UploadImage extends HttpServlet{
    
    PrintWriter out;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
        int result = 0;
        Part part = request.getPart("image");
        if(part != null){
            try {
                Connection con = DB.getConnection();
                PreparedStatement ps = con.prepareStatement("insert into data(image,nom) values(?,?)");
                //INSERT INTO `date` (`img`, `date`) VALUES ('','6')
                InputStream is = part.getInputStream();
                ps.setBlob(1, is);
                ps.setString(2, "XXXXXXXXXX");
                result = ps.executeUpdate();
                if(result > 0){
                    response.sendRedirect("view.jsp");
                }else{
                    response.sendRedirect("index.jsp?message=Some+Error+Occured");
                }
            } catch (Exception e) {
                out.println(e);
            }
        
        
    }
        
    }
    
    
    
}
