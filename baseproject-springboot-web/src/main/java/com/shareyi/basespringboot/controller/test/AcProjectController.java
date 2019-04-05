package com.shareyi.basespringboot.controller.test;

import com.shareyi.basespringboot.controller.AbstractController;
import com.shareyi.basespringboot.domain.test.AcProject;
import com.shareyi.basespringboot.service.test.AcProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/test/acProject")
public class AcProjectController extends AbstractController<AcProject> {

    @Resource(name = "acProjectService")
    private AcProjectService acProjectService;

    @Override
    public AcProjectService getService() {
        return acProjectService;
    }
}
