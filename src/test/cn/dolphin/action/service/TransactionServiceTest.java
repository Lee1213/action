package cn.dolphin.action.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author LiLinZhi
 * @date 2017-11-03 上午12:49
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class TransactionServiceTest {

    @Autowired
    private TransactionServiceA transactionServiceA;

    /**
     * 多个数据库操作在同一个方法中
     * 1. 加事物没有异常：插入1成功和插入2成功
     * 2. 加事物抛异常：  插入1和插入2都失败,回滚
     * 3. 没有事物没有异常：插入1成功和插入2成功
     * 4. 没有事物有异常：  插入1成功和插入2失败
     *
     * @throws Exception
     */
    @Test
    public void combineTransactions() throws Exception {
        transactionServiceA.combineTransactions();
    }

    /**
     * 多个数据库操作在同一个方法中,同类中方法调用
     * 1. 加事物没有异常：插入1成功和插入2成功
     * 2. 加事物抛异常：  正常插入1、插入2失败
     * 3. 没有事物没有异常：插入1成功和插入2成功
     * 4. 没有事物有异常：  插入1成功和插入2失败
     * <p>
     * 5. 入口方法加事物抛异常,被调用方法加入同一事物: 插入1失败和插入2失败
     * 6. 入口方法加事物抛异常,被调用方法加独立事物:   插入1失败和插入2失败
     * <p>
     * summary: 同类中调用加事物的方法,事物不起作用.
     *
     * @throws Exception
     */
    @Test
    public void invokeMethodInSameClass() throws Exception {
        transactionServiceA.invokeMethodInSameClass();
    }

    /**
     * 解决同类方法(不回滚)调用事物不起作用
     * 1. 方法写在不同类中
     * (1)A异常，B正常，B独立事物：A回滚，B不回滚；
     * 2. 编程式事物
     *
     * @throws Exception
     */
    @Test
    public void invokeMethodInDiffClass() throws Exception {
        transactionServiceA.invokeMethodInDiffClass();
    }

    @Test
    public void selfCommitInSameClass() throws Exception {
        transactionServiceA.selfCommitInSameClass();
    }

}