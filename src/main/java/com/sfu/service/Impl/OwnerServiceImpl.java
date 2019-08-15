package com.sfu.service.Impl;

import com.sfu.beans.Owner;
import com.sfu.dao.OwnerDao;
import com.sfu.service.IOwnerService;

public class OwnerServiceImpl implements IOwnerService {

	private OwnerDao dao;
	
	
	public void setDao(OwnerDao dao) {
		this.dao = dao;
	}


	@Override
	public Owner selectOwnerById(Integer uid) {
		return dao.quaryOwnerById(uid);
	}

}
