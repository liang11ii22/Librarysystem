package com.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.daos.LibraryDao;
import com.daos.impl.LibraryDaoImpl;
import com.dtos.SchoolLib;

public class LibraryAction {

	private LibraryDao ldao = new LibraryDaoImpl();
	private int lid;
	
	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String showAllLibrary(){
		List<SchoolLib> libraryList = ldao.queryAll("from SchoolLib");
		
		System.out.println("SIZE"+libraryList.size());
		ServletActionContext.getRequest().getSession().setAttribute("librarylist", libraryList);
		return "liblist";
	}
	
	public String viewLibDetail(){
		
		SchoolLib library = ldao.queryOne("SchoolLib", lid);
		ServletActionContext.getRequest().getSession().setAttribute("lib", library);
		return "libdetail";
		
	}
}
