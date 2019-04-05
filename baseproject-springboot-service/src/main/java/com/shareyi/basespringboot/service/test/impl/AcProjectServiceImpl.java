package com.shareyi.basespringboot.service.test.impl;

import com.shareyi.basespringboot.builder.impl.AcProjectBuilder;
import com.shareyi.basespringboot.domain.test.AcProject;
import com.shareyi.basespringboot.manager.test.AcProjectManager;
import com.shareyi.basespringboot.service.AbstractService;
import com.shareyi.basespringboot.service.test.AcProjectService;
import com.shareyi.basespringboot.validate.provide.AcProjectValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 测试项目 service实现
 *
 * @author MoliCode
 * @date 2018-12-21
 */
@Service("acProjectService")
public class AcProjectServiceImpl extends AbstractService<AcProject> implements AcProjectService {

    protected static final Logger LOGGER = LoggerFactory.getLogger(AcProjectServiceImpl.class);

    @Resource(name = "acProjectValidator")
    private AcProjectValidator acProjectValidator;

    @Resource(name = "acProjectManager")
    private AcProjectManager acProjectManager;

    @Resource(name = "acProjectBuilder")
    private AcProjectBuilder acProjectBuilder;

    /** ***** getter and setter ** */
    @Override
    public AcProjectManager getManager() {
        return acProjectManager;
    }

    @Override
    public AcProjectValidator getValidator() {
        return acProjectValidator;
    }

    @Override
    public AcProjectBuilder getBuilder() {
        return acProjectBuilder;
    }
}
