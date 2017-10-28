package cn.dolphin.action.service;

import cn.dolphin.action.redis.DistributedLock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by LiLinZhi
 * Date: 17/8/3
 * Time: 下午11:16
 * Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class ActionServiceTest {

    @Autowired
    private ActionService actionService;

    @Autowired
    private DistributedLock distributedLock;

    @Test
    public void getActions() throws Exception {
//        Action action = actionService.getAction();
//        System.out.println(action.getId());
        distributedLock.lock("a:b:c.abc");
    }

}