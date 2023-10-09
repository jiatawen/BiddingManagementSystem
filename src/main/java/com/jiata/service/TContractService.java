package com.jiata.service;

import com.jiata.contract.TContract;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Jiata
* @description 针对表【t_contract】的数据库操作Service
* @createDate 2023-10-09 22:01:06
*/
public interface TContractService extends IService<TContract> {
    public List<TContract> getAllContract();
}
