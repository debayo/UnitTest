/**
 * refer to https://code.google.com/p/powermock/wiki/MockitoUsage13
 */
package org.shiyuan;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(BookStaticUtil.class)
public class PowerMockTest {
	@Test
	public void staticMethodTest() {
		// NOTICE::JDK5 is not work
		// unsupportedclassversionerror
		/*
		 * Add @PrepareForTest at class level.
		 * 
		 * @PrepareForTest(Static.class) // Static.class contains static methods
		 * Call PowerMockito.mockStatic() to mock a static class (use
		 * PowerMockito.spy(class) to mock a specific method):
		 * PowerMockito.mockStatic(Static.class); Just use Mockito.when() to
		 * setup your expectation:
		 * Mockito.when(Static.firstStaticMethod(param)).thenReturn(value);
		 */
		PowerMockito.mockStatic(BookStaticUtil.class);
		Mockito.when(BookStaticUtil.getSize(1)).thenReturn(42);

		int result = BookStaticUtil.getSize(1);

		PowerMockito.verifyStatic(Mockito.times(1));

		Assert.assertEquals(42, result);
		System.out.println("yes");
	}
}
