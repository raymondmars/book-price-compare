package com.bookcompare.common;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Raymond on 02/12/2016.
 */

public class UtilityTest {
    @Test
    public void testIsBlank() {
        Assert.assertTrue(Utility.isBlank(null));
        Assert.assertTrue(Utility.isBlank(""));
        Assert.assertTrue(Utility.isBlank("   "));
        Assert.assertFalse(Utility.isBlank("is not empty"));
        Assert.assertFalse(Utility.isBlank("  is not empty  "));
    }
}
