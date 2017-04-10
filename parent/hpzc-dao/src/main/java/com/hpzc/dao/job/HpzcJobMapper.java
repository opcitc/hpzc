package com.hpzc.dao.job;

import com.hpzc.model.job.HpzcJob;

public interface HpzcJobMapper {
	
    int deleteByKey(Integer jobId);

    int insert(HpzcJob record);

    HpzcJob selectByKey(Integer jobId);

    int update(HpzcJob record);
}