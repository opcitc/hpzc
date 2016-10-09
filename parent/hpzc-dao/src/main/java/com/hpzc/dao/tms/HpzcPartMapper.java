package com.hpzc.dao.tms;

import com.hpzc.model.tms.HpzcPart;

public interface HpzcPartMapper {

    int insert(HpzcPart record);

    HpzcPart selectByPrimaryKey(String phonePartsId);

    int update(HpzcPart record);
}