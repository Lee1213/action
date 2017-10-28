package cn.dolphin.action.email;

import java.util.Timer;

/**
 * Created by LiLinZhi
 * Date: 17/8/2
 * Time: 下午10:18
 * Version: 1.0
 */
public class EmailTaskTimer {

    public static void main(String[] args) {
        Timer timer = new Timer();
        //在60秒后执行此任务, 每次间隔2h执行一次,如果传递一个Data参数,就可以在某个固定的时间执行这个任务.
        timer.schedule(new MyTask(), 5000, 1000 * 60 * 60);

    }

    static class MyTask extends java.util.TimerTask {
        int count = 1;

        public void run() {
            try {
                EmailService.sendEmail();
                System.out.println("＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃");
                System.out.println("已发送邮件数: [ " + count++ + " ]");
                System.out.println("＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}