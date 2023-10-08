package com.example.service;

import com.example.model.DeclarationInfo;
import com.example.model.TenderInfo;

import java.util.List;

public interface TenderService {
    public List<DeclarationInfo> listAction();
    public TenderInfo tenderListAction(String projectId);
    public boolean tenderInsertAction(TenderInfo tenderInfo);
    public boolean isProjectExists(String projectId);
    public boolean tenderUpdateAction(TenderInfo tenderInfo);

}
