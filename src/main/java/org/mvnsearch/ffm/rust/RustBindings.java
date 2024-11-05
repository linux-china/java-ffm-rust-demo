package org.mvnsearch.ffm.rust;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

public class RustBindings {
    private static final MethodHandle doubleNumberMethodHandler;

    static {
        var linker = Linker.nativeLinker(); // Initializes the native linker
        // load from classpath
        //var lib = SymbolLookup.libraryLookup(JarFFMLoader.loadLib(RustBindings.class, "", "double_number"), Arena.global()); // Loads the Rust library
        var lib = SymbolLookup.libraryLookup(System.mapLibraryName("double_number"), Arena.global()); // Loads the Rust library
        // Link the Rust functions
        doubleNumberMethodHandler = linker.downcallHandle(lib.find("doubleNumber").orElseThrow(),
                FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    }

    public static int doubleNumber(int i) {
        try {
            return (int) doubleNumberMethodHandler.invokeExact(i);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}