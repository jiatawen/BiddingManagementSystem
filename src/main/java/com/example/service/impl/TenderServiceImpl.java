package com.example.service.impl;

import com.example.model.DeclarationInfo;
import com.example.model.TenderInfo;
import com.example.service.TenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TenderServiceImpl implements TenderService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<DeclarationInfo> listAction() {
        String sql="select * from declareform";
        List<DeclarationInfo> list=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(DeclarationInfo.class));
        if(list!=null&&!list.isEmpty()) {
            return list;
        }
        return null;
    }

    @Override
    public TenderInfo tenderListAction(String projectId) {
        String sql="select * from applyform where ProjectId=?";
        TenderInfo table=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(TenderInfo.class),projectId);
        TenderInfo noTable=null;
        if(table!=null){
            return table;
        }else{
            return noTable;
        }
    }

    @Override
    public boolean tenderInsertAction(TenderInfo tenderInfo) {

        String sql="insert into applyform(No,company,ProjectId,principal,Opdate,Userid)values(?,?,?,?,?,?)";
        int result=jdbcTemplate.update(sql,tenderInfo.getNo(),tenderInfo.getCompany(),tenderInfo.getProjectId(),tenderInfo.getPrincipal()
        ,tenderInfo.getOpDate(),tenderInfo.getUserid());

        return result>0;


    }

    @Override
    public boolean isProjectExists(String projectId) {
        String sql="select count(*) from applyform where ProjectId=?";
        int count=jdbcTemplate.queryForObject(sql,Integer.class,projectId);
        return count>0;
    }

    @Override
    public boolean tenderUpdateAction(TenderInfo tenderInfo) {
        String sql="update applyform set No=?,company=?,principal=?,Opdate=?,Userid=? where ProjectId=?";
        int update = jdbcTemplate.update(
                sql,
                tenderInfo.getNo(),
                tenderInfo.getCompany(),
                tenderInfo.getPrincipal(),
                tenderInfo.getOpDate(),
                tenderInfo.getUserid(),
                tenderInfo.getProjectId());
        return update>0;

    }


}
