
package examples.runtime;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import junit.framework.TestCase;

/**
 * Accessing a file at the same time other than for writing is probably not the
 * intended behavior and will most likely cause problems and unexpected results.
 */
public class AccessingFileSimultaneously extends TestCase {
    
    public void test() throws IOException {
        File file = new File("AFS.txt");
        file.delete();
        
        // open for write
        FileOutputStream out1 = new FileOutputStream(file);
        out1.write("Through out1: line 1\n".getBytes());
        
        // VIOLATION: open for writing again while still open
        FileOutputStream out2 = new FileOutputStream(file);
        out2.write("Through out2: line 1\n".getBytes());
        
        out1.write("Through out1: line 2\n".getBytes());
        out2.write("Through out2: line 2\n".getBytes());
        
        out1.close();
        out2.close();
        
        // result: file contains only one file output
        ExamplesUtil.showFileContents(file);
    }
}
