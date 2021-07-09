package annotation;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationTest {

    /**
     * 注解是必须依赖反射，才能实现相关功能的，所以有注解，必定有反射
    * */

    @Test
    public void testAnnotation() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Apple apple = new Apple();
        apple.setAppleName("apple");
        test(apple);
    }

    public void test(Object object) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class c = object.getClass();

        Field appleNameField = c.getDeclaredField("appleName");
        appleNameField.setAccessible(true);
        System.out.println((String) appleNameField.get(object));
        System.out.println(appleNameField.getDeclaredAnnotation(FruitName.class).value());

        Method method = c.getDeclaredMethod("displayName");
        method.setAccessible(true);
        method.invoke(object);
    }
}
