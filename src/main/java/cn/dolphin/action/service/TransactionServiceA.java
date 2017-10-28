package cn.dolphin.action.service;

import cn.dolphin.action.domain.Action;
import cn.dolphin.action.domain.User;
import cn.dolphin.action.mapper.ActionMapper;
import cn.dolphin.action.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author LiLinZhi
 * @date 2017-10-30 上午1:30
 */
@Slf4j
@Service
public class TransactionServiceA {

    @Autowired
    private ActionMapper actionMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TransactionServiceB transactionServiceB;

    @Autowired
    private DataSourceTransactionManager txManager;

    @Transactional(rollbackFor = Exception.class)
    public void combineTransactions() {
        insertAction();
        // int result = 1 / 0;
        updateAction();
    }

    @Transactional(rollbackFor = Exception.class)
    public void invokeMethodInSameClass() {
        insertAction();
        insertUser();
        int result = 1 / 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public void invokeMethodInDiffClass() {
        insertAction();
        transactionServiceB.insertUser();
        int result = 1 / 0;
    }

    /**
     * 单独提交某一个方法
     */
    @Transactional(rollbackFor = Exception.class)
    public void selfCommitInSameClass() {
        insertAction();
        selfInsertUser();
//        int result = 1 / 0;
    }

    public void insertAction() {
        Action action = new Action();
        action.setActionName("INSERT");
        action.setStatus("SUCCESS");
        actionMapper.insertSelective(action);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void insertUser() {
        User user = new User();
        user.setName("INSERT");
        user.setAge(25);
        userMapper.insertSelective(user);
    }

    public void selfInsertUser() {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus status = txManager.getTransaction(def);
        try {
            User user = new User();
            user.setName("INSERT");
            user.setAge(25);
            userMapper.insertSelective(user);
            txManager.commit(status);
        } catch (Exception e) {
            txManager.rollback(status);
            log.error("事务回滚:" + this.getClass().getName(), e);
        }

    }

    public void updateAction() {
        Action action = new Action();
        action.setId(1);
        action.setActionName("UPDATE");
        action.setStatus("SUCCESS");
        actionMapper.updateByPrimaryKeySelective(action);
    }

    private void updateUser() {
        User user = new User();
        user.setId(1);
        user.setName("update");
        user.setAge(25);
        userMapper.updateByPrimaryKeySelective(user);
    }
}
