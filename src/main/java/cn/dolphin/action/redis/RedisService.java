package cn.dolphin.action.redis;

import org.redisson.Redisson;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

/**
 * @author LiLinZhi
 * @date 2017-11-05 下午10:06
 */
public class RedisService extends Thread {

    public static void main(String[] args) throws Exception {
//        Config config = new Config();
//        config.useSingleServer().setAddress("127.0.0.1:6379");
//        RedissonClient redisson = Redisson.create(config);
//
//        RLock lock = redisson.getLock("anyLock");
//        lock.lock(10, TimeUnit.SECONDS);
//        // Wait for 100 seconds and automatically unlock it after 10 seconds
//        boolean res = lock.tryLock(10, 10, TimeUnit.SECONDS);
//        System.out.println(res);
//
//        lock.unlock();

//        RedissonClient redissonInstance1 = Redisson.create();
//        RedissonClient redissonInstance2 = Redisson.create();
//        RedissonClient redissonInstance3 = Redisson.create();
//        RLock lock1 = redissonInstance1.getLock("lock1");
//        RLock lock2 = redissonInstance2.getLock("lock2");
//        RLock lock3 = redissonInstance3.getLock("lock3");
//        RedissonMultiLock lock = new RedissonMultiLock(lock1, lock2, lock3);
//        lock.lock(10, TimeUnit.SECONDS);
//        System.out.println(1);
//        lock.unlock();

        test();
//        new RedisService().start();

    }

    public static void test() throws Exception {
        RedissonClient redisson = Redisson.create();

        RLock lock1 = redisson.getLock("a:lock1");
        RedissonRedLock lock = new RedissonRedLock(lock1);
        lock.lock(30, TimeUnit.SECONDS);

        try {
            System.out.println("lock1");
        } finally {
//            lock.unlock();
        }

//        redisson.shutdown();

    }

    @Override
    public void run() {
        RedissonClient redisson = Redisson.create();

        RLock lock = redisson.getLock("lock1");
        lock.lock();

        System.out.println(lock.isLocked());
        try {
            Thread.sleep(1000);//休眠1s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
