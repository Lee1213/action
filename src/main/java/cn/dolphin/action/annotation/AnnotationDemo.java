package cn.dolphin.action.annotation;

/**
 * Created by LiLinZhi
 * Date: 17/8/16
 * Time: 上午12:15
 * Version: 1.0
 */
public class AnnotationDemo {

    @MyTag(name = "audi", size = 99)
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Annotation [car=" + car + "]";
    }
}
