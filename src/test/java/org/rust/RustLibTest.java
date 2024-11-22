package org.rust;

import org.junit.jupiter.api.Test;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

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
        System.out.println(RustLib.doubleNumber(10));
    }

    @Test
    public void testWelcome() {
        String name = "Jackie";
        try (Arena arena = Arena.ofShared()) {
            final MemorySegment memorySegment = Vec_uint8.allocate(arena);
            Vec_uint8.ptr(memorySegment, arena.allocateFrom(name));
            Vec_uint8.len(memorySegment, name.getBytes().length);
            Vec_uint8.cap(memorySegment, name.getBytes().length);
            final MemorySegment result = RustLib.welcome(arena, memorySegment);
            final long len = Vec_uint8.len(result);
            byte[] bytes = new byte[(int) len];
            final MemorySegment stringSegment = Vec_uint8.ptr(result).asSlice(0, len);
            stringSegment.asByteBuffer().get(bytes);
            System.out.println(new String(bytes));
        }
    }
}
