package cn.dolphin.action.service;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

/**
 * @author LiLinZhi
 * @date 2017-11-02 上午10:53
 */
public class MockitoTest {

    @Test
    public void mockObj() {
        /* 模拟对象 */
        ArrayList mockList = Mockito.mock(ArrayList.class);

        /* 模拟方法调用的返回值 */
//        Mockito.when(mockList.get(0)).thenReturn("first");
//        System.out.println(mockList.get(0));

        /* 模拟方法调用抛出异常 */
//        Mockito.when(mockList.get(1)).thenThrow(new RuntimeException());
//        mockList.get(1);

        /* 如果一个函数没有返回值类型，那么可以使用此方法模拟异常抛出 */
//        Mockito.doThrow(new RuntimeException("clear exception")).when(mockList).clear();
//        mockList.clear();

        /* 模拟调用方法时的参数匹配 */
//        Mockito.when(mockList.get(Mockito.anyInt())).thenReturn("element");
//        System.out.println(mockList.get(999));

        /* 模拟方法调用次数 */
//        mockList.add("once");
//        Mockito.verify(mockList).add("once");
//        Mockito.verify(mockList, Mockito.times(2)).add("once");

        /* 校验行为 */
//        mockList.add("one");
//        mockList.clear();
//        Mockito.verify(mockList).add("one");
//        Mockito.verify(mockList).clear();

        /* 模拟方法调用(Stubbing) */
//        Mockito.when(mockList.get(0)).thenReturn("first");
//        Mockito.when(mockList.get(1)).thenReturn(new RuntimeException());
//        System.out.println(mockList.get(0));
//        System.out.println(mockList.get(1));
//        System.out.println(mockList.get(999));
//        Mockito.verify(mockList).get(0);

        /* 参数匹配 */
//        Mockito.when(mockList.get(Mockito.anyInt())).thenReturn("element");
//        System.out.println(mockList.get(999));
//        Mockito.verify(mockList).get(Mockito.anyInt());

        /* 校验方法调用顺序 */
        // A. Single mock whose methods must be invoked in a particular order
//        List singleMock = Mockito.mock(List.class);
//        singleMock.add("was added first");
//        singleMock.add("was added two");
//        InOrder inOrder = Mockito.inOrder(mockList);
//        inOrder.verify(singleMock).add("was added first");
//        inOrder.verify(singleMock).add("was added two");

        // B. Multiple mocks that must be used in a particular order
//        List firstMock = Mockito.mock(List.class);
//        List secondMock = Mockito.mock(List.class);
//        firstMock.add("was called first");
//        secondMock.add("was called second");
//        InOrder inOrder = Mockito.inOrder(firstMock, secondMock);
//        inOrder.verify(firstMock).add("was called first");
//        inOrder.verify(secondMock).add("was called two");

        /* 校验方法是否从未调用 */
        Mockito.verify(mockList, Mockito.never()).add("1");

    }

    @Test
    public void mockException() {

    }
}
