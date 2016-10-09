package com.hpzc.dao.tms;

import com.hpzc.model.tms.HpzcSupplier;

public interface HpzcSupplierMapper {

    int insert(HpzcSupplier record);

    HpzcSupplier selectByPrimaryKey(String sId);

    int update(HpzcSupplier record);
}