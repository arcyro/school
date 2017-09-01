package pl.coderslab.testrepos.java.exam1;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;


public class Main1Test {

    public static Class clazz;

    private static final int PARAM_A = 4;
    private static final int PARAM_B = 5;
    private static final int EXPECTED_AREA = 20;

    @Test
    public void given4and5_whenCalculate_thenEquals20() throws NoSuchMethodException, SecurityException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = clazz.getDeclaredMethod("rectangle", int.class, int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(null, PARAM_A, PARAM_B);

        assertEquals(EXPECTED_AREA, result);
    }

}