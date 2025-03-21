package com.project.demo.controller;

import com.project.demo.entity.InformationCenter;
import com.project.demo.service.InformationCenterService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 信息中心：(InformationCenter)表控制层
 *
 */
@RestController
@RequestMapping("/information_center")
public class InformationCenterController extends BaseController<InformationCenter, InformationCenterService> {

    /**
     * 信息中心对象
     */
    @Autowired
    public InformationCenterController(InformationCenterService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
