package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.daos.UserDao;
import com.daos.impl.UserDaoImpl;
import com.dtos.Category;
import com.dtos.SchoolLib;
import com.dtos.Users;

public class UserAction {
	private Users user;
	private File myfile;
	private String myfileContentType;
	private String myfileFileName;
	private String realPath; 
	private String savepath;
	
	private UserDao udao = new UserDaoImpl();

	
	
	public Users getUser() {
		return user;
	}



	public void setUser(Users user) {
		this.user = user;
	}



	public File getMyfile() {
		return myfile;
	}



	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}



	public String getMyfileContentType() {
		return myfileContentType;
	}



	public void setMyfileContentType(String myfileContentType) {
		this.myfileContentType = myfileContentType;
	}



	public String getMyfileFileName() {
		return myfileFileName;
	}



	public void setMyfileFileName(String myfileFileName) {
		this.myfileFileName = myfileFileName;
	}



	public String getRealPath() {
		return realPath;
	}



	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}



	public String getSavepath() {
		return savepath;
	}



	public void setSavepath(String savepath) {
		this.savepath = savepath;
	}



	public String uploadUser(){
		Users u = new Users();
		realPath = ServletActionContext.getServletContext().getRealPath("/pics");
		System.out.println("sdfdfsdfdsfdsrealPath"+realPath);
		
		File file = new File(realPath);

		if (!file.exists()) {
			file.mkdir();
		}

		File newfile = new File(file, myfileFileName);

		
		u.setName(user.getName());
		u.setEmail(user.getEmail());
		u.setPassword(user.getPassword());
		u.setTel(user.getTel());
		
		
	    
		try {
			FileUtils.copyFile(myfile, new File(file, myfileFileName));
			FileInputStream fin = new FileInputStream(newfile);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path = ServletActionContext.getRequest().getContextPath();
		u.setAttachment(ServletActionContext.getRequest().getScheme() + "://"
				+ ServletActionContext.getRequest().getServerName() + ":"
				+ ServletActionContext.getRequest().getServerPort() + path
				+ "/pics" + "/" + myfileFileName);
		udao.add(u);
		ServletActionContext.getRequest().getSession()
		.setAttribute("user", u);
		return "addusers";
	}
	
	public String addNewUser(){
		ServletActionContext.getRequest().getSession().getAttribute("user");
		return "newuser";
	}
	

}
