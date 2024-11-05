package org.mvnsearch.ffm.rust;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

/**
 * Jar FFM loader test
 *
 * @author linux_china
 */
public class JarFFMLoaderTest {
    @Test
    public void testLoadLib() {
        final Path libPath = JarFFMLoader.loadLib(JarFFMLoaderTest.class, "", "double_number");
        System.out.println(libPath);
    }
}
