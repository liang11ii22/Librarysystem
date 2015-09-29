package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.daos.AnnouncementDao;
import com.daos.impl.AnnounceDaoImpl;
import com.dtos.Admin;
import com.dtos.Announce;

public class AnnounceAction {
	private AnnouncementDao anndao = new AnnounceDaoImpl();
	private Announce announce;
	private int annid;
	
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
		List<Announce> annlist = anndao.queryAll("From Announce");
		ServletActionContext.getRequest().getSession().setAttribute("annlist", annlist);
		return "announcelist";
	}
	
	public String viewAnnDetail(){
		Announce ann = anndao.queryOne("Announce", annid);
		ServletActionContext.getRequest().getSession().setAttribute("ann", ann);
		return "anndetail";
	}

}
