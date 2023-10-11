package com.jiata.service;

import com.jiata.entity.TContract;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Jiata
* @description 针对表【t_contract】的数据库操作Service
* @createDate 2023-10-10 12:47:29
*/
public interface TContractService extends IService<TContract> {
    public List<TContract> getAllContract();
    public TContract getContractById(Integer id);
    public Integer insertContract(TContract contract);
    public boolean delContract(Integer id);
    public boolean modifyContract(TContract contract);

    public List<TContract> getByName(String name);
}
