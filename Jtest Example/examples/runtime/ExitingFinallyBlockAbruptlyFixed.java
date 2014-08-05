
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
public class ExitingFinallyBlockAbruptlyFixed extends TestCase {
    
    public void test() throws IOException {
        InputStream in = null;
        try {
            in = new FileInputStream("non_existing_file.tmp");
        } finally {
            // FIX: make sure exception is not thrown
            if (in != null)
                in.close();
        }
    }
}
