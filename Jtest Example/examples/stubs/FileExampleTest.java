/*
 * Test class for FileExample
 */
package examples.stubs;

import java.io.File;
import java.lang.reflect.Member;

import jtest.Stubs;
import junit.framework.TestCase;

/**
 * FileExampleTest is a unit test class for class FileExample.
 * @see examples.stubs.FileExample
 */
public class FileExampleTest extends TestCase {
    
    /**
     * Test for method: static analyze(java.io.File)
     * @see FileExample#analyze(java.io.File)
     */
    public void testAnalyze () {
        String result = FileExample.analyze (new File ("ignore_this_value"));
        assertEquals ("Z:\\tmp\\X001.txt:true:10:0:", result);
    }

    /**
     * Stubs method for testAnalyze.
     */
    public Object stubsAnalyze (
        Member member,
        Object _this,
        Object [] args)
    {
        String method_name = member.getName ();

        if (Stubs.matches (member, File.class)) {
            if (Stubs.matches (member, "getAbsolutePath"))
                return "Z:\\tmp\\X001.txt";

            if (Stubs.matches (member, "setLastModified")) {
                // primitive "args" are wrapped in an Object, unwrap "time"
                long time = ((Long) args [0]).longValue ();
                if (time < 0) {
                    // note that one can specify an exception to be thrown
                    // in the stub
                    throw new IllegalArgumentException ("time is: " + time);
                }
                return new Boolean (true); // wrap primitive return type
            }

            if (Stubs.matches (member, "compareTo")) {
                File file = (File) args [0];
                if (file.getName ().equals ("X001.txt"))
                    return new Integer (10);
                return new Integer (0);
            }
        }

        return Stubs.NO_STUB_GENERATED;
    }
}