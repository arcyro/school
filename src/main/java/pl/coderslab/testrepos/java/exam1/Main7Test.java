package pl.coderslab.testrepos.java.exam1;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class Main7Test {
	public static Class clazz;

	@Test
	public void given1a23b_whenCalculate_thenEquals5() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		String str = "Wynik dodawania 1 i 2 to 3";
		Method method = clazz.getDeclaredMethod("countNumbers", String.class);
		method.setAccessible(true);
		int result = (int) method.invoke(null, str);
		
		assertEquals(6, result);
	}

}
