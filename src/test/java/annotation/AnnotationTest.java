package annotation;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import testclass.Apple;
import testclass.ElementChild;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

public class AnnotationTest {

    AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 注解是必须依赖反射，才能实现相关功能的，所以有注解，必定有反射
    * */

    @Test
    public void testAnnotation() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Apple apple = new Apple();
        apple.setAppleName("apple");
        apple.num = 12;
        test(apple);

        atomicInteger.getAndIncrement();
        synchronized (apple) {
            System.out.println(ClassLayout.parseInstance(apple).toPrintable());
        }

    }
    @Test
    public void testDeclaredAnnotation() {
        ElementChild child = new ElementChild();
        for(Annotation annotation : child.getClass().getAnnotations()) {
            System.out.println("getAnnotations " + annotation);
        };

        for(Annotation annotation : child.getClass().getDeclaredAnnotations()) {
            System.out.println("getDeclaredAnnotations " + annotation);
        };
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
