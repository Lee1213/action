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
    public Action getAction() {
        // Thread.sleep(1000 * 10);

        Action action = new Action();
        action.setActionName("INSERT");
        action.setStatus("SUCCESS");
        actionMapper.insertSelective(action);

        updateAction(1);

        return action;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateAction(Integer id) {
        Action updateAction = new Action();
        updateAction.setActionName("UPDATE");
        updateAction.setStatus("SUCCESS");
        actionMapper.updateByPrimaryKey(updateAction);
    }
}
