
package examples.runtime;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import junit.framework.TestCase;

/**
 * <code>finally</code> blocks are guaranteed to execute regardless of whether
 * the corresponding <code>try</code> block exited normally or not, the abrupt
 * exit from the <code>finally</code> block can cause the reason for the abrupt
 * exit from the <code>try</code> block to be hidden.
 */
public class ExitingFinallyBlockAbruptly extends TestCase {
    
    public void test() throws IOException {
        InputStream in = null;
        try {
            in = new FileInputStream("non_existing_file.tmp");
        } finally {
            // VIOLATION: NullPointerException thrown here will hide
            // the FileNotFoundException
            in.close();
        }
    }
}
