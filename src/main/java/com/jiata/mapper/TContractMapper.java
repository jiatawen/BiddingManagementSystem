package com.jiata.mapper;

import com.jiata.entity.TContract;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Jiata
* @description 针对表【t_contract】的数据库操作Mapper
* @createDate 2023-10-09 22:01:06
* @Entity com.jiata.contract.TContract
*/
@Mapper
public interface TContractMapper extends BaseMapper<TContract> {

    public List<TContract> selectAllContract();
    public TContract selectAllByContractId(Integer id);

    public Integer insertContract(TContract tContract);

    public boolean deleteContractById(Integer id);

    public boolean modifyContract(TContract tContract);

    public List<TContract> selectAllByName(String title);
}




