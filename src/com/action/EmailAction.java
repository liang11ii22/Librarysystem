package com.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

import com.daos.BorrowReturnDao;
import com.daos.UserDao;
import com.daos.impl.BorrowReturnDaoImpl;
import com.daos.impl.UserDaoImpl;
import com.dtos.BorrowReturn;
import com.dtos.Users;

public class EmailAction extends HttpServlet implements ServletContextListener{
	private UserDao udao = new UserDaoImpl();
	private BorrowReturnDao brdao = new BorrowReturnDaoImpl();
	
	public String sendEmail() throws MessagingException, ParseException{
		List<Date> listdate = new ArrayList<Date>();
		List<String> liststr = new ArrayList<String>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date now = new Date();
		//int flag = 0;
		
		
		 Properties props = new Properties();  
	        props.setProperty("mail.smtp.auth", "true");  
	        props.setProperty("mail.transport.protocol", "smtp");  
	          
	        Session session = Session.getInstance(props);  
	        session.setDebug(true);  
	          
	        Message msg = new MimeMessage(session);  
	        
	        List<Users>listusers = udao.queryAll("from Users");
	        List<String> listemail = new ArrayList<String>();
	        List<BorrowReturn> listborrret = new ArrayList<BorrowReturn>();
	        List<Integer> listm = new ArrayList<Integer>();
	        
	        for(int i = 0;i<listusers.size(); i++){
	        	List<BorrowReturn>listbr = brdao.ListBorrowBook(listusers.get(i).getId());
	        	for(int j = 0; j<listbr.size(); j++){
	        		if(listbr != null && listbr.size()>0){
	        			for(int k = 0; k<listbr.size(); k++){
	    					listdate.add(dateFormat.parse(listbr.get(k).getBDate()));	
	    					
	    					int days = (int) Math.abs((now.getTime() - listdate.get(0)
	    							.getTime()) / (24 * 60 * 60 * 1000)) + 1;
	    					if (days >= 55) {
	    						listm.add(listbr.get(i).getUsers().getId());
	    					}
	    					
	    					
	    				}
	        			
	        		if(listm != null &&listm.size()>0){
	        			BorrowReturn b = brdao.queryOne("BorrowReturn",listm.get(i));
	        			listborrret.add(b);
	        		}else{
	        			break;
	        		}
	        		
	        		if(listborrret!= null && listborrret.size()>0){
	        			listemail.add(listborrret.get(i).getUsers().getEmail());
	        		}else{
	        			break;
	        		}
	        	}
	        		
	        		
	        	}
	        	
	        	
	        
	        }
	        if(listemail != null && listemail.size() >0){
	        	for(int i = 0;i<listemail.size();i++){
	        		for(int j = 0;j<listemail.size()-1;j++){
	        			if(listemail.get(i).equals(listemail.get(j))){
	        				listemail.remove(j);
	        			}
	        	}
	        	}
	        	for(int n = 0; n<listemail.size(); n++){
	        		 msg.setSubject("Public Library Notification");  
	 	 	        msg.setText("Hello, please return books to the Public Library on time");  
	 	 	        msg.setFrom(new InternetAddress("836418927@qq.com"));  
	 	 	  
	 	 	        Transport transport = session.getTransport();  
	 	 	        transport.connect("smtp.qq.com", 25, "836418927@qq.com", "sun19880507");  
	 	 	        transport.sendMessage(msg,new Address[]{new InternetAddress(listemail.get(n))});  
	 	 	  
	 	 	        System.out.println("Email sending success!");  
	 	 	        transport.close();
	        	}
	        	  
	        }
	       
		return "success";
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		try {
			this.sendEmail();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


