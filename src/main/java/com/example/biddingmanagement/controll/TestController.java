package com.example.biddingmanagement.controll;

import com.example.model.DeclarationInfo;
import com.example.model.TenderInfo;
import com.example.service.TenderService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("biddingmanagement")
public class TestController {

    private static final Logger LOG= LoggerFactory.getLogger(TestController.class);
    @Autowired
    private TenderService tenderService;

    @PostConstruct
    public void init(){
        LOG.info("TestController 启动啦");
        LOG.info("tenderService 注入啦");

        LOG.info("查询执行啦");
    }
    @RequestMapping("/login")
    public String list(Model model){
        List<DeclarationInfo> list = tenderService.listAction();
        model.addAttribute("list",list);
        return "ProjectList";
    }

    @GetMapping("/view")
    public String table(@RequestParam String projectId,Model model){
        model.addAttribute("projectId",projectId);
        boolean projectExists = tenderService.isProjectExists(projectId);
        if(projectExists){
            TenderInfo tenderInfo = tenderService.tenderListAction(projectId);
            model.addAttribute("table",tenderInfo);
        }

        return "application";
    }

    @PostMapping("/summit")
    @ResponseBody
    public Map verify(@ModelAttribute TenderInfo tenderInfo){
        Map map=new HashMap();
        boolean projectExists = tenderService.isProjectExists(tenderInfo.getProjectId());

        if(projectExists){
            boolean count=tenderService.tenderUpdateAction(tenderInfo);
            if(count){
                map.put("result","success");
            }else{
                map.put("result","fail");
            }
        }else{
            boolean count=tenderService.tenderInsertAction(tenderInfo);
            if(count){
                map.put("result","success");
            }else{
                map.put("result","fail");
            }
        }
        return map;
    }

}
