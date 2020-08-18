package com.yc.canteen.email;  
  
import java.io.IOException;  
import java.util.Date;  
import java.util.Properties;  
  
import javax.mail.Address;  
import javax.mail.Authenticator;  
import javax.mail.Message.RecipientType;  
import javax.mail.MessagingException;  
import javax.mail.Transport;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
  
@WebServlet("/reg")  
public class RegisterServlet extends HttpServlet {  
    private static final long serialVersionUID = 1L;  
  
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        String toMail = request.getParameter("email");  
        String registerName = request.getParameter("userName");  
          
        String userName = "a604263076@163.com";  
        String password = "CZELTVNFVEAVAEKW";  
          
        String registerId = "" + Math.random() * Math.random();  
        String url = "w8z8" ;
          
        HttpSession httpSession = request.getSession();  
        httpSession.setAttribute(registerId, registerName);  
        httpSession.setMaxInactiveInterval(600);  
          
        Properties props = new Properties();  
        props.setProperty("mail.smtp.host", "smtp.163.com");  
        props.setProperty("mail.smtp.auth", "true");  
          
        Authenticator authenticator = new MyAuthenticator(userName, password);  
          
        javax.mail.Session session = javax.mail.Session.getDefaultInstance(props,authenticator);  
        session.setDebug(true);  
          
        try{  
            Address from = new InternetAddress(userName);  
            Address to = new InternetAddress(toMail);  
              
            MimeMessage msg = new MimeMessage(session);  
            msg.setFrom(from);  
            msg.setSubject("一家餐厅注册");  
            msg.setSentDate(new Date());  
            msg.setContent("注册验证码为:" + url, "text/html;charset=utf-8");  
            msg.setRecipient(RecipientType.TO, to);  
            /* 
            Transport transport = session.getTransport("smtp"); 
            transport.connect("smtp.163.com", userName, password); 
            transport.sendMessage(msg,msg.getAllRecipients()); 
            transport.close(); 
            */  
            Transport.send(msg);  
        } catch(MessagingException e){  
            e.printStackTrace();  
        }  
          
        request.getRequestDispatcher("/register.html").forward(request, response);  
    }  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        doGet(request, response);  
    }  
} 