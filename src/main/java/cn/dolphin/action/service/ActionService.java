package cn.dolphin.action.service;

import cn.dolphin.action.domain.Action;
import cn.dolphin.action.mapper.ActionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LiLinZhi on 17/6/15.
 */
@Service
public class ActionService {

    @Autowired
    private ActionMapper actionMapper;

    @Transactional
    public Action getAction() throws Exception {
        getAct();

        Thread.sleep(1000 * 10);

//        int a = 1 / 0;
        actionMapper.updateAction2();

        return null;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void getAct() {
        actionMapper.updateAction1();
    }
}
