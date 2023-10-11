package com.jiata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiata.entity.TContract;
import com.jiata.mapper.TUserMapper;
import com.jiata.service.TContractService;
import com.jiata.mapper.TContractMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Jiata
* @description 针对表【t_contract】的数据库操作Service实现
* @createDate 2023-10-10 12:47:29
*/
@Service
public class TContractServiceImpl extends ServiceImpl<TContractMapper, TContract>
    implements TContractService{

    @Resource
    private TContractMapper contractMapper;
    @Override
    public List<TContract> getAllContract() {
        List<TContract> contracts = contractMapper.selectAllContract();
        return contracts;
    }

    @Override
    public TContract getContractById(Integer id) {
        TContract contract = contractMapper.selectAllByContractId(id);
        return contract;
    }

    @Override
    public Integer insertContract(TContract contract) {
        Integer flag = contractMapper.insertContract(contract);
        return flag;
    }

    @Override
    public boolean delContract(Integer id) {
        boolean flag = contractMapper.deleteContractById(id);
        return flag;
    }

    @Override
    public boolean modifyContract(TContract contract) {
        boolean flag = contractMapper.modifyContract(contract);
        return flag;
    }

    @Override
    public List<TContract> getByName(String title) {
        return contractMapper.selectAllByName(title);
    }
}




