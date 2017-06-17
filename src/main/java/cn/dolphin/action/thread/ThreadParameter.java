
package cn.dolphin.action.thread;

/**
 * Created by LiLinZhi on 17/6/15.
 */

/**
 * 与线程相关的公共参数
 */
public class ThreadParameter {
    private static ThreadLocal<String> name = new ThreadLocal<String>();
    private static ThreadLocal<Integer> age = new ThreadLocal<Integer>();

    public static String getName() {
        return name.get();
    }

    public static void setName(String value) {
        name.set(value);
    }

    public static Integer getAge() {
        return age.get();
    }

    public static void setAge(Integer value) {
        age.set(value);
    }

    public static void clear() {
        name.set(null);
        age.set(null);
    }

}
