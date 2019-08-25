package com.sfu.service.Impl;

import com.sfu.beans.Evaluation;
import com.sfu.beans.Owner;
import com.sfu.dao.EvaluationDao;
import com.sfu.dao.OwnerDao;
import com.sfu.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ownerService")
public class OwnerServiceImpl implements IOwnerService {

	@Autowired
	@Qualifier("ownerDao")
	private OwnerDao dao;

	@Autowired
	@Qualifier("evaluationDao")
	private EvaluationDao evaluationDao;


	public void setDao(OwnerDao dao) {
		this.dao = dao;
	}


	@Override
	public Owner selectOwnerById(Integer uid) {
		return dao.quaryOwnerById(uid);
	}

	@Override
	public void insertOwner(Owner owner) {
		dao.addOwner(owner);
	}

	@Override
	public void updateOwner(Owner owner) {
		dao.modifyOwner(owner);
	}

	@Override
	public int selectPendingNumbers() {
		return dao.quaryPendingNumbers();
	}

	@Override
	public List<Owner> selectPendingOwnerByPage(int start, int count) {
		return dao.quaryPendingOwnerByPage(start,count);
	}

	@Override
	public int selectOwnerNumbers() {
		return dao.quaryOwnerNumbers();
	}

	@Override
	public List<Owner> selectOwnerByPage(int start, int count) {
		return dao.quaryOwnerByPage(start,count);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public void judgeIsPassByUid(Integer uid, int is_pass) {
		if(is_pass==0){
			dao.modifyIsPassByUid(uid,is_pass);
		}
		else if(is_pass==1){
			Evaluation evaluation=new Evaluation();
			evaluation.setUid(uid);
			evaluation.setNum_peo(0);
			evaluation.setScore(10);
			evaluationDao.addEvaluation(evaluation);
			dao.modifyIsPassByUid(uid,is_pass);
		}
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public void cancelOwnerByUid(Integer uid) {
		dao.modifyIsPassByUid(uid,0);
		evaluationDao.removeEvaluationByUid(uid);
	}

}
