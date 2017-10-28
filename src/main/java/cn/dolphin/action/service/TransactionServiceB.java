package cn.dolphin.action.service;

import cn.dolphin.action.domain.User;
import cn.dolphin.action.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author LiLinZhi
 * @date 2017-11-03 上午12:28
 */
@Service
public class TransactionServiceB {

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void insertUser() {
        User user = new User();
        user.setName("INSERT");
        user.setAge(25);
        userMapper.insertSelective(user);
    }
}
