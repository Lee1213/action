package cn.dolphin.action.util;

import cn.dolphin.action.bo.XmlRequestBo;
import cn.dolphin.action.bo.XmlResponseBo;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

import java.util.List;
import java.util.Map;

/**
 * @author LiLinZhi
 * @date 2018-04-05 下午8:39
 */
public class XmlUtils {

    private static final ImmutableMap<Class<?>, XStream> TO_XML_CLASS_X_STREAM_MAP;
    private static final ImmutableMap<Class<?>, XStream> FROM_XML_CLASS_X_STREAM_MAP;

    static {
        /**
         * 因为new XStream, 内部会new一个CompositeClassLoader,并且不会被回收.
         * 如果每次都生成一个XStream对象，会造成内存泄漏.
         * 顾针对每个需要转化的对象,在系统初始化的时候只生成一个对应的XStream.
         */
        List<Class<?>> toXmlClassList = Lists.newArrayList(XmlRequestBo.class, String.class);
        Map<Class<?>, XStream> toXmlClassMap = Maps.newHashMap();
        for (Class<?> toXmlClass : toXmlClassList) {
            toXmlClassMap.put(toXmlClass, getToXmlXStream(toXmlClass));
        }
        TO_XML_CLASS_X_STREAM_MAP = ImmutableMap.copyOf(toXmlClassMap);

        List<Class<?>> fromXmlClassList = Lists.newArrayList(XmlResponseBo.class, String.class);
        Map<Class<?>, XStream> fromXmlClassMap = Maps.newHashMap();
        for (Class<?> fromXmlClass : fromXmlClassList) {
            fromXmlClassMap.put(fromXmlClass, getFromXMLXStream(fromXmlClass));
        }
        FROM_XML_CLASS_X_STREAM_MAP = ImmutableMap.copyOf(fromXmlClassMap);
    }

    /**
     * 获取转化成XML的XStream
     *
     * @param clz 序列化的类
     * @return
     */
    public static <T> XStream getToXmlXStream(Class<T> clz) {
        XStream xStream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));
        xStream.processAnnotations(clz);
        xStream.aliasSystemAttribute(null, "class");
        return xStream;
    }

    /**
     * 获取XML转化成Obj的XStream
     *
     * @param clz 序列化的类
     * @return
     */
    public static <T> XStream getFromXMLXStream(Class<T> clz) {
        XStream xStream = new XStream();
        xStream.processAnnotations(clz);
        xStream.ignoreUnknownElements();
        return xStream;
    }

    public static void main(String[] args) {
        XmlRequestBo xmlRequestBo = XmlRequestBo.builder().userId("1").userName("Jack").userAge(25).build();
        XStream toXStream = TO_XML_CLASS_X_STREAM_MAP.get(XmlRequestBo.class);
        String toXMLStr = toXStream.toXML(xmlRequestBo);

        System.out.println("xmlRequestBo:" + JSON.toJSONString(xmlRequestBo));
        System.out.println("xmlRequestBoStr: \n" + toXMLStr);


        String xmlStr = toXMLStr;
        XStream fromXStream = FROM_XML_CLASS_X_STREAM_MAP.get(XmlResponseBo.class);
        XmlResponseBo xmlResponseBo = (XmlResponseBo) fromXStream.fromXML(xmlStr);
        System.out.println("responseBo:" + JSON.toJSONString(xmlResponseBo));
    }
}
