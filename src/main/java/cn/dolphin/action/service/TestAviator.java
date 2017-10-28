package cn.dolphin.action.service;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by LiLinZhi on 17/5/15.
 */
public class TestAviator {

    public static void main(String[] args) {
//        Long result = (Long) AviatorEvaluator.execute("1+2+3");
//
//        String name = "Lee";
//        Map<String, Object> env = new HashMap<String, Object>();
//        env.put("name", name);
//        String result1 = (String) AviatorEvaluator.execute(" 'hello :' +  name", env);
//
//        String name1 = "lee";
//        String name2 = "li";
//        String result2 = (String) AviatorEvaluator.exec(" 'hello ' + name + ': ' + n", name, name2);
//
//
//        double random = new Random().nextDouble() * 100;
//
//        System.out.println(random);

//        DateTime today = new DateTime().withTimeAtStartOfDay();
//        int observationDays = 3 + 1 + 0; //1:同步时间晚一天; offset:偏移天数,补数据使用.
//        if (new DateTime().isAfter(today.plusDays(-observationDays))) {
//            System.out.println(111);
//        }

//        DateTime nowTime = new DateTime();
//
//        DateTime futureTime = new DateTime(2017, 8, 10, 20, 0, 0);
//
//        int days = Days.daysBetween(nowTime, futureTime).getDays();
//        System.out.println(days);

//        int spreadDays = 5;
//        int observationDays = 3;
//
//        DateTime today = new DateTime().withTimeAtStartOfDay();
//
//        System.out.println(today);
//        System.out.println(today.plusDays(spreadDays).toDate());
//        System.out.println(today.plusDays(spreadDays + observationDays).toDate());

//        String str = new DateTime().toString("yyyyMMddHHmmss");
//        System.out.println(str);
//
//        str = new DateTime().plusDays(-1).withTimeAtStartOfDay().toString("yyyyMMddHHmmss");
//        System.out.println(str);
//
//        str = new DateTime().withTimeAtStartOfDay().toString("yyyyMMddHHmmss");
//        System.out.println(str);

//        String dateStr = "20170910";
//        DateTimeFormatter format = DateTimeFormat.forPattern("yyyyMMdd");
//        Date startDate = DateTime.parse(dateStr, format).plusDays(-1).toDate();
//        Date endDate = DateTime.parse(dateStr, format).plusSeconds(-1).toDate();
//        System.out.println(startDate);
//        System.out.println(endDate);
//
//        System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(startDate));
//        System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(endDate));
//
//        BigDecimal bigDecimal = new BigDecimal(100.504343);
//        System.out.println(bigDecimal);
//        System.out.println(String.valueOf(bigDecimal));

        System.out.println(Integer.parseInt(null));

    }

}
