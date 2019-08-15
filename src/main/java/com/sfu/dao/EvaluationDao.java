package com.sfu.dao;

import org.apache.ibatis.annotations.Param;

public interface EvaluationDao {
	void modifyScoreByUid(@Param("uid") Integer uid, @Param("score") double score);
}
