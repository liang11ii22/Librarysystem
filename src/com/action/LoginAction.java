package com.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.daos.AdminDao;
import com.daos.BorrowReturnDao;
import com.daos.UserDao;
import com.daos.impl.AdminDaoImpl;
import com.daos.impl.BorrowReturnDaoImpl;
import com.daos.impl.UserDaoImpl;
import com.dtos.Admin;
import com.dtos.BorrowReturn;
import com.dtos.Users;
import com.model.AdminModel;
import com.model.impl.AdminModelImpl;

public class LoginAction {
	private Admin admin;
	// private AdminModel amodel = new AdminModelImpl();
	private Users user;
	private UserDao udao = new UserDaoImpl();
	private AdminDao adao = new AdminDaoImpl();
	private BorrowReturnDao brdao = new BorrowReturnDaoImpl();

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String adminLogin() {

		String name = admin.getName();
		String password = admin.getPassword();

		Admin a = new Admin();
		a.setName(name);
		a.setPassword(password);
		Admin a1 = adao.login(a);

		// System.out.println("NNNAAME"+a1.getName());
		if (a1 != null) {
			System.out.println("NNNAAME" + a1.getName());
			ServletActionContext.getRequest().getSession()
					.setAttribute("admin", a1);
			return "adminlogin";
		} else {
			return "loginerror";
		}
	}

	public String userLogin() throws ParseException {

		String name = user.getName();
		String password = user.getPassword();

		Users u = new Users();
		u.setName(name);
		u.setPassword(password);
		Users u1 = udao.loginUser(u);
		if (u1 != null) {
			int flag = 0;
			ServletActionContext.getRequest().getSession()
					.setAttribute("user", u1);
			List<BorrowReturn> brlist = brdao.ListBorrowBook(u1.getId());
			System.out.println("SIZE" + brlist.size());
			List<Date> listdate = new ArrayList<Date>();
			List<String> liststr = new ArrayList<String>();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date now = new Date();
			System.out.println(brlist.get(0).getBDate());
			if (brlist.size() != 0 && brlist != null) {
				for (int i = 0; i < brlist.size(); i++) {
					listdate.add(dateFormat.parse(brlist.get(i).getBDate()));
				}

				for (int j = 0; j < listdate.size(); j++) {
					int days = (int) Math.abs((now.getTime() - listdate.get(j)
							.getTime()) / (24 * 60 * 60 * 1000)) + 1;
					if (days >= 55) {
						flag = 1;
					}
					System.out.println("DAY" + days);

				}
				if (flag == 1) {
					String alertRegister = "notify";
					ServletActionContext.getRequest().setAttribute(
							"alertRegister", alertRegister);
				}

			}
			return "userlogin";
		}
		ServletActionContext.getRequest().setAttribute("msg",
				"Username or password error!");
		return "userloginerror";

	}
}
