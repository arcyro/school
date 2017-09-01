package pl.coderslab.testrepos.java.exam1;

/**
 * @Todo dodać test -  sprawdzać warunki na podzielność
 */
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.Test;


public class Main3Test {

	public static Class clazz;

	@Test
	public void givenSize20andInterval10_whenCalculate_thenSizeEquals10() throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int size = 10;
		int interval = 20;
		Method method = clazz.getDeclaredMethod("div", int.class, int.class);
		method.setAccessible(true);
		int[] result = (int[]) method.invoke(null, size, interval);
		assertEquals(10, result.length);
	}

	@Test
	public void givenSize20andInterval10_whenCalculate_thenArrayNotContain0() throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int size = 10;
		int interval = 20;
		Method method = clazz.getDeclaredMethod("div", int.class, int.class);
		method.setAccessible(true);
		int[] result = (int[]) method.invoke(null, size, interval);
		System.out.println(Arrays.toString(result));
		Integer[] what = Arrays.stream(result).boxed().toArray(Integer[]::new);
		assertThat(what, not(hasItemInArray(0)));
	}

}
