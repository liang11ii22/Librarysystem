package com.daos;

import java.util.List;

import com.dtos.Users;

public interface UserDao extends BaseDao<Users> {
	public Users loginUser(Users user);
	public List<Users>listUsers(int bid);

}
