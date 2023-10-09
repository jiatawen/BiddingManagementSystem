package com.jiata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiata.contract.TContract;
import com.jiata.service.TContractService;
import com.jiata.mapper.TContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Jiata
* @description 针对表【t_contract】的数据库操作Service实现
* @createDate 2023-10-09 22:01:06
*/
@Service
public class TContractServiceImpl extends ServiceImpl<TContractMapper, TContract>
    implements TContractService{
    @Autowired
    private TContractMapper contractMapper;

    @Override
    public List<TContract> getAllContract() {
        List<TContract> tContracts = contractMapper.selectAllContract();
        System.out.println(tContracts);
        return tContracts;
    }
}




