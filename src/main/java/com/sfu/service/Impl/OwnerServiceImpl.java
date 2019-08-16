package com.sfu.service.Impl;

import com.sfu.beans.Owner;
import com.sfu.dao.OwnerDao;
import com.sfu.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ownerService")
public class OwnerServiceImpl implements IOwnerService {

	@Autowired
	@Qualifier("ownerDao")
	private OwnerDao dao;
	
	
	public void setDao(OwnerDao dao) {
		this.dao = dao;
	}


	@Override
	public Owner selectOwnerById(Integer uid) {
		return dao.quaryOwnerById(uid);
	}

}
