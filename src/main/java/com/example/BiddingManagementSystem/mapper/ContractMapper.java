package com.example.BiddingManagementSystem.mapper;

import com.example.BiddingManagementSystem.entity.Controller;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContractMapper {
    public Controller SelectConById(Integer id);
}
