package cn.dolphin.action.annotation;

import java.lang.reflect.Field;

/**
 * Created by LiLinZhi
 * Date: 17/8/16
 * Time: 上午12:17
 * Version: 1.0
 */
public class AnnotationProccessor {

    public static void annoProcess(AnnotationDemo annotation) {

        for (Field field : annotation.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(MyTag.class)) {  //如果存在MyTag标签
                MyTag myTag = field.getAnnotation(MyTag.class);
                annotation.setCar(new Car(myTag.name(), myTag.size()));
            }
        }
    }

    public static void main(String[] args) {
        AnnotationDemo ann = new AnnotationDemo();
        annoProcess(ann);
        System.out.println(ann.getCar());
    }
}
