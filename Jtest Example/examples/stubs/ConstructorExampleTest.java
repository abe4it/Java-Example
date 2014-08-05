/*
 * Test class for ConstructorExample
 */
package examples.stubs;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Member;

import jtest.Stubs;
import junit.framework.TestCase;

/**
 * ConstructorExampleTest is a unit test class for class ConstructorExample.
 * @see examples.stubs.ConstructorExample
 */
public class ConstructorExampleTest extends TestCase {
    
    /**
     * Test for method: static getFileLength(java.lang.String)
     * @throws IOException
     * @see ConstructorExample#getFileLength(java.lang.String)
     */
    public void testGetFileLength () throws IOException {
        // jtest_tested_method
        long RETVAL = ConstructorExample.getFileLength ("ignore this arg");
        assertEquals (10000000000000L, RETVAL);
    }

    /**
     * Stubs for testGetFileLength.
     */
    public Object stubsGetFileLength (
        Member member,
        Object _this,
        Object [] args)
    {
        if (Stubs.matches (member, RandomAccessFile.class)) {
            Class [] argument_types = new Class [] {String.class, String.class};
            if (Stubs.matches (member, argument_types)) {
                String path = (String) args [0];
                if (path.equals (null))
                    throw new NullPointerException ("null path");
                return Stubs.makeStubObject (RandomAccessFile.class);
            }
            if (Stubs.matches (member, "length"))
                return new Long (10000000000000L);
        }

        return Stubs.NO_STUB_GENERATED;
    }
}