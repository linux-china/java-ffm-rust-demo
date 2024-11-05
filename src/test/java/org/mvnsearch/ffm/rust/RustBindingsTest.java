package org.mvnsearch.ffm.rust;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RustBindingsTest {

    @Test
    public void testDoubleNumber() {
        assertEquals(20, RustBindings.doubleNumber(10));
    }
}
