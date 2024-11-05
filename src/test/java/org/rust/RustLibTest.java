package org.rust;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * RustLib test
 *
 * @author linux_china
 */
public class RustLibTest {
    @Test
    public void testDoubleNumber() {
        assertEquals(20, RustLib.doubleNumber(10));
    }
}
