package automation.base;

import org.testng.Assert;

public class Verify {

    public static void equals(
            String actual,
            String expected,
            String message) {

        Assert.assertEquals(
                actual,
                expected,
                message
        );
    }

    public static void isTrue(
            boolean condition,
            String message) {

        Assert.assertTrue(
                condition,
                message
        );
    }

    public static void isFalse(
            boolean condition,
            String message) {

        Assert.assertFalse(
                condition,
                message
        );
    }
}
