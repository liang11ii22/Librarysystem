package com.action;



import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.daos.MessageDao;
import com.daos.UserDao;
import com.daos.impl.MessageDaoImpl;
import com.daos.impl.UserDaoImpl;
import com.dtos.Messages;
import com.dtos.Users;

public class MessageAction {
	
	private Messages messages;
	private MessageDao mdao = new MessageDaoImpl();
	private UserDao udao = new UserDaoImpl();
	
	
	
	public Messages getMessages() {
		return messages;
	}



	public void setMessages(Messages messages) {
		this.messages = messages;
	}



	public String addMessage(){
		Messages mgs = new Messages();
		Users u = (Users) ServletActionContext.getRequest().getSession().getAttribute("user");
		Date now = new Date(); 
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
  	    String time1 = dateFormat.format( now ); 
  	    
  	    System.out.println(messages.getContents());
  	    mgs.setContents(messages.getContents());
  	    
  	    mgs.setUsers(u);
  	    mgs.setMDate(time1);
  	    mdao.add(mgs);
  	    return "addmsg";
  	    
	}

}
