package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.daos.AnnouncementDao;
import com.daos.impl.AnnounceDaoImpl;
import com.dtos.Admin;
import com.dtos.Announce;
import com.dtos.Users;
import com.util.HibernatePage;

public class AnnounceAction {
	private AnnouncementDao anndao = new AnnounceDaoImpl();
	private Announce announce;
	private int annid;
	private int cpage;
	
	public int getCpage() {
		return cpage;
	}

	public void setCpage(int cpage) {
		this.cpage = cpage;
	}

	public Announce getAnnounce() {
		return announce;
	}

	public void setAnnounce(Announce announce) {
		this.announce = announce;
	}

	public int getAnnid() {
		return annid;
	}

	public void setAnnid(int annid) {
		this.annid = annid;
	}

	public String addAnnouncement(){
		Admin a = (Admin)ServletActionContext.getRequest().getSession().getAttribute("admin");
		Announce ann = new Announce();
		ann.setAdmin(a);
		ann.setContents(announce.getContents());
		Date now = new Date(); 
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
  	    String time1 = dateFormat.format( now ); 
  	    ann.setUpdatetime(time1);
  	    ann.setName(announce.getName());
  	    anndao.add(ann);
  	    ServletActionContext.getRequest().setAttribute("msg","Add announcement success!");
  	    return "mainpage";
		
	}
	
	public String annList(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		if (cpage <= 0) {
			cpage = 1;
		}
		int curpage = cpage;// 当前页
		int pagesize = 2;// 每页显示数
		
		
		List<Announce> annlist = HibernatePage.findOnePage(session, "select u from Announce u order by name", curpage, pagesize);
		ServletActionContext.getRequest().getSession().setAttribute("annlist", annlist);
		Users u = (Users) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(u !=null){
			return "front_annlist";
		}
		return "announcelist";
	}
	
	
	public String viewAnnDetail(){
		Announce ann = anndao.queryOne("Announce", annid);
		ServletActionContext.getRequest().getSession().setAttribute("ann", ann);
		Users u = (Users) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(u !=null){
			return "front_anndetail";
		}
		return "anndetail";
	}
	
	
}
