package com.shareyi.basespringboot.manager.test.impl;

import com.shareyi.basespringboot.builder.impl.AcProjectBuilder;
import com.shareyi.basespringboot.dao.test.AcProjectDao;
import com.shareyi.basespringboot.domain.test.AcProject;
import com.shareyi.basespringboot.manager.AbstractManager;
import com.shareyi.basespringboot.manager.test.AcProjectManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 测试项目Manager实现类
 *
 * @author MoliCode
 * @date 2018-12-21
 */
@Component("acProjectManager")
public class AcProjectManagerImpl extends AbstractManager<AcProject> implements AcProjectManager {

    @Resource(name = "acProjectBuilder")
    AcProjectBuilder acProjectBuilder;
    @Resource
    private AcProjectDao acProjectDao;

    /** ***** getter and setter ** */
    @Override
    public AcProjectBuilder getBuilder() {
        return acProjectBuilder;
    }

    @Override
    public AcProjectDao getDao() {
        return acProjectDao;
    }
}
