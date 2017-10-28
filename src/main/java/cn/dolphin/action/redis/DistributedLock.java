package cn.dolphin.action.redis;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class DistributedLock {

    private static RedissonClient redisson1 = Redisson.create();

    /**
     * 尝试加锁，返回成功/失败
     */
    public boolean tryLock(String key) {
        boolean tryLock = false;
        try {
            tryLock = tryLock(key, 120, 30);
        } catch (InterruptedException e) {
            log.error("Try lock failed, key:" + key, e);
        }
        return tryLock;
    }

    /**
     * 尝试加锁，返回成功/失败
     *
     * @throws InterruptedException
     */
    public boolean tryLock(String key, long waitTime, long leaseTime) throws InterruptedException {
        RLock lock1 = redisson1.getLock(key + ".lock1");
        RedissonRedLock lock = new RedissonRedLock(lock1);
        return lock.tryLock(waitTime, leaseTime, TimeUnit.SECONDS);
    }

    /**
     * 最通用的加锁方式
     *
     * @param key 加锁的键值
     * @return 锁对象，可以调用解锁unlock
     */
    public RedissonRedLock lock(String key) {
        return lock(key, 30);
    }

    /**
     * 可以设置超时时间的加锁方式
     *
     * @param key     加锁的键值
     * @param timeout 超时时间，秒单位
     * @return 锁对象，可以调用解锁unlock
     */
    public RedissonRedLock lock(String key, Integer timeout) {
        RLock lock1 = redisson1.getLock(key + ".lock1");
        RedissonRedLock lock = new RedissonRedLock(lock1);
        lock.lock(timeout, TimeUnit.SECONDS);
        return lock;
    }

    /**
     * 解锁键值
     *
     * @param key 解锁的键值
     */
    public void unlock(String key) {
        RLock lock1 = redisson1.getLock(key + ".lock1");
        RedissonRedLock lock = new RedissonRedLock(lock1);
        lock.unlock();
    }

}
