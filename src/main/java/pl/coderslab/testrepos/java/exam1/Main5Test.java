package pl.coderslab.testrepos.java.exam1;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;


public class Main5Test {
	public static Class clazz;

	@Before
	public void setData() {
		String input = "3";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	}

	@Test
	public void given3_when_calculate_thenEqual113() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Method method = clazz.getDeclaredMethod("ball");
		method.setAccessible(true);
		double result = (double) method.invoke(null);

		assertEquals(113, result, 1);
	}

//	@Test
//	public void given3_when_calculate_thenEqual84() {
//		double v = Main5.ball();
//		assertEquals(84, v, 1);
//	}

}
