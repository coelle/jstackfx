package io.twasyl.jstackfx.factory;

import io.twasyl.jstackfx.beans.Dump;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * @author Thierry Wasylczenko
 * @since JStackFX 1.0
 */
public class DumpFactoryTests {

    private static File DUMP_FILE = new File("src/test/resources/intellij.txt");

    @Test
    public void jniReferences() throws Exception {
        final Dump dump = DumpFactory.read(DUMP_FILE);

        assertEquals(4957, dump.getNumberOfJNIRefs());
    }

    @Test
    public void correctNumberOfTotalThreads() throws Exception {
        final Dump dump = DumpFactory.read(DUMP_FILE);

        assertEquals(43, dump.getElements().size());
    }

    @Test
    public void correctNumberOfNewThreads() throws Exception {
        final Dump dump = DumpFactory.read(DUMP_FILE);

        assertEquals(1, dump.countNumberOfThreads(Thread.State.NEW));
    }

    @Test
    public void correctNumberOfRunnableThreads() throws Exception {
        final Dump dump = DumpFactory.read(DUMP_FILE);

        assertEquals(20, dump.countNumberOfThreads(Thread.State.RUNNABLE));
    }

    @Test
    public void correctNumberOfWaitingThreads() throws Exception {
        final Dump dump = DumpFactory.read(DUMP_FILE);

        assertEquals(9, dump.countNumberOfThreads(Thread.State.WAITING));
    }

    @Test
    public void correctNumberOfTimedWaitingThreads() throws Exception {
        final Dump dump = DumpFactory.read(DUMP_FILE);

        assertEquals(11, dump.countNumberOfThreads(Thread.State.TIMED_WAITING));
    }

    @Test
    public void correctNumberOfBlockedThreads() throws Exception {
        final Dump dump = DumpFactory.read(DUMP_FILE);

        assertEquals(1, dump.countNumberOfThreads(Thread.State.BLOCKED));
    }

    @Test
    public void correctNumberOfTerminatedThreads() throws Exception {
        final Dump dump = DumpFactory.read(DUMP_FILE);

        assertEquals(1, dump.countNumberOfThreads(Thread.State.TERMINATED));
    }

    @Test
    public void countThreadsWithoutStack() throws Exception {
        final Dump dump = DumpFactory.read(DUMP_FILE);

        assertEquals(9, dump.countThreadsWithoutStack());
    }

    @Test public void toto() {
        System.out.println(String.format("%.0f", 10.21));
    }
}
