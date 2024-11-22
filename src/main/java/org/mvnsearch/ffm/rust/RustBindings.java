package org.mvnsearch.ffm.rust;

import org.rust.RustLib;
import org.rust.Vec_uint8;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.nio.charset.StandardCharsets;

public class RustBindings {
    private static final MethodHandle doubleNumberMethodHandler;
    private static final MethodHandle welcomeMethodHandler;
    private static final GroupLayout StringLayout = MemoryLayout.structLayout(
            RustLib.C_POINTER.withName("ptr"),
            RustLib.C_LONG.withName("len"),
            RustLib.C_LONG.withName("cap")
    ).withName("Vec_uint8");

    static {
        var linker = Linker.nativeLinker(); // Initializes the native linker
        // load from classpath
        //var lib = SymbolLookup.libraryLookup(JarFFMLoader.loadLib(RustBindings.class, "", "double_number"), Arena.global()); // Loads the Rust library
        var lib = SymbolLookup.libraryLookup(System.mapLibraryName("double_number"), Arena.global()); // Loads the Rust library
        // Link the Rust functions
        doubleNumberMethodHandler = linker.downcallHandle(lib.find("doubleNumber").orElseThrow(),
                FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
        welcomeMethodHandler = linker.downcallHandle(lib.find("welcome").orElseThrow(),
                FunctionDescriptor.of(StringLayout, StringLayout));
    }

    public static int doubleNumber(int i) {
        try {
            return (int) doubleNumberMethodHandler.invokeExact(i);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static String welcome(String name) {
        try (Arena arena = Arena.ofConfined()) {
            final MemorySegment paramSegment = Vec_uint8.allocate(arena);
            Vec_uint8.ptr(paramSegment, arena.allocateFrom(name));
            Vec_uint8.len(paramSegment, name.getBytes().length);
            Vec_uint8.cap(paramSegment, name.getBytes().length);
            final MemorySegment result = (MemorySegment) welcomeMethodHandler.invokeExact((SegmentAllocator) arena, paramSegment);
            final long len = Vec_uint8.len(result);
            byte[] bytes = new byte[(int) len];
            final MemorySegment stringSegment = Vec_uint8.ptr(result).asSlice(0, len);
            stringSegment.asByteBuffer().get(bytes);
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}