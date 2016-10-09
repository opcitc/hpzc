package com.hpzc.dao.tms;

import com.hpzc.model.tms.HpzcType;

public interface HpzcTypeMapper {

    int insert(HpzcType record);

    HpzcType selectByPrimaryKey(String phoneId);

    int update(HpzcType record);

}