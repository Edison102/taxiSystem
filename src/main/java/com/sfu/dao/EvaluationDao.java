package com.sfu.dao;

import com.sfu.beans.Evaluation;
import org.apache.ibatis.annotations.Param;

public interface EvaluationDao {
	void modifyScoreByUid(@Param("uid") Integer uid, @Param("score") double score);
	void addEvaluation(Evaluation evaluation);
	void removeEvaluationByUid(Integer uid);
}
