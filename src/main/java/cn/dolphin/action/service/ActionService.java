package cn.dolphin.action.service;

import cn.dolphin.action.domain.Action;
import cn.dolphin.action.mapper.ActionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LiLinZhi on 17/6/15.
 */
@Service
public class ActionService {

    @Autowired
    private ActionMapper actionMapper;

    public Action getAction() {
        Action action = actionMapper.getAction();
        return action;
    }
}
