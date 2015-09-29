package com.action;

import org.apache.struts2.ServletActionContext;

import com.dtos.Admin;
import com.model.AdminModel;
import com.model.impl.AdminModelImpl;

public class LoginAction {
	private Admin admin;
	private AdminModel amodel = new AdminModelImpl();

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
	public String adminLogin(){
		
		String name = admin.getName();
		String password = admin.getPassword();
		
		Admin a = new Admin();
		a.setName(name);
		a.setPassword(password);
		Admin a1 = amodel.login(a);
		
		//System.out.println("NNNAAME"+a1.getName());
		if(a1 != null){
			System.out.println("NNNAAME"+a1.getName());
			ServletActionContext.getRequest().getSession().setAttribute("admin", a1);
			return "adminlogin";
		}
		else{
		return "loginerror";
		}
		
		
	}

}
