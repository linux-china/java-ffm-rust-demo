// Generated by jextract

package org.rust;

import java.lang.invoke.*;
import java.lang.foreign.*;
import java.nio.ByteOrder;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.PathElement.*;

/**
 * {@snippet lang=c :
 * struct Vec_uint8 {
 *     uint8_t *ptr;
 *     size_t len;
 *     size_t cap;
 * }
 * }
 */
public class Vec_uint8 {

    Vec_uint8() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
        RustLib.C_POINTER.withName("ptr"),
        RustLib.C_LONG.withName("len"),
        RustLib.C_LONG.withName("cap")
    ).withName("Vec_uint8");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    private static final AddressLayout ptr$LAYOUT = (AddressLayout)$LAYOUT.select(groupElement("ptr"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * uint8_t *ptr
     * }
     */
    public static final AddressLayout ptr$layout() {
        return ptr$LAYOUT;
    }

    private static final long ptr$OFFSET = 0;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * uint8_t *ptr
     * }
     */
    public static final long ptr$offset() {
        return ptr$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * uint8_t *ptr
     * }
     */
    public static MemorySegment ptr(MemorySegment struct) {
        return struct.get(ptr$LAYOUT, ptr$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * uint8_t *ptr
     * }
     */
    public static void ptr(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(ptr$LAYOUT, ptr$OFFSET, fieldValue);
    }

    private static final OfLong len$LAYOUT = (OfLong)$LAYOUT.select(groupElement("len"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * size_t len
     * }
     */
    public static final OfLong len$layout() {
        return len$LAYOUT;
    }

    private static final long len$OFFSET = 8;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * size_t len
     * }
     */
    public static final long len$offset() {
        return len$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * size_t len
     * }
     */
    public static long len(MemorySegment struct) {
        return struct.get(len$LAYOUT, len$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * size_t len
     * }
     */
    public static void len(MemorySegment struct, long fieldValue) {
        struct.set(len$LAYOUT, len$OFFSET, fieldValue);
    }

    private static final OfLong cap$LAYOUT = (OfLong)$LAYOUT.select(groupElement("cap"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * size_t cap
     * }
     */
    public static final OfLong cap$layout() {
        return cap$LAYOUT;
    }

    private static final long cap$OFFSET = 16;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * size_t cap
     * }
     */
    public static final long cap$offset() {
        return cap$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * size_t cap
     * }
     */
    public static long cap(MemorySegment struct) {
        return struct.get(cap$LAYOUT, cap$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * size_t cap
     * }
     */
    public static void cap(MemorySegment struct, long fieldValue) {
        struct.set(cap$LAYOUT, cap$OFFSET, fieldValue);
    }

    /**
     * Obtains a slice of {@code arrayParam} which selects the array element at {@code index}.
     * The returned segment has address {@code arrayParam.address() + index * layout().byteSize()}
     */
    public static MemorySegment asSlice(MemorySegment array, long index) {
        return array.asSlice(layout().byteSize() * index);
    }

    /**
     * The size (in bytes) of this struct
     */
    public static long sizeof() { return layout().byteSize(); }

    /**
     * Allocate a segment of size {@code layout().byteSize()} using {@code allocator}
     */
    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate(layout());
    }

    /**
     * Allocate an array of size {@code elementCount} using {@code allocator}.
     * The returned segment has size {@code elementCount * layout().byteSize()}.
     */
    public static MemorySegment allocateArray(long elementCount, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(elementCount, layout()));
    }

    /**
     * Reinterprets {@code addr} using target {@code arena} and {@code cleanupAction) (if any).
     * The returned segment has size {@code layout().byteSize()}
     */
    public static MemorySegment reinterpret(MemorySegment addr, Arena arena, Consumer<MemorySegment> cleanup) {
        return reinterpret(addr, 1, arena, cleanup);
    }

    /**
     * Reinterprets {@code addr} using target {@code arena} and {@code cleanupAction) (if any).
     * The returned segment has size {@code elementCount * layout().byteSize()}
     */
    public static MemorySegment reinterpret(MemorySegment addr, long elementCount, Arena arena, Consumer<MemorySegment> cleanup) {
        return addr.reinterpret(layout().byteSize() * elementCount, arena, cleanup);
    }
}

