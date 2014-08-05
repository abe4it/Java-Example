
package examples.runtime.security;

import com.parasoft.api.insure.security.DVMethod;
import com.parasoft.api.insure.security.IDVMethodSpecifier;

/**
 * Example method specifier.
 */
public class UserMethodSpecifier implements IDVMethodSpecifier {
    
    /**
     * @see com.parasoft.api.insure.security.IDVMethodSpecifier#isTainting(com.parasoft.api.insure.security.DVMethod)
     */
    public Boolean isTainting(DVMethod method) {
        if (method
            .matches("examples.runtime.security.MethodSpecifierExample.generateData"))
            return TRUE;
        return null;
    }
    
    /**
     * @see com.parasoft.api.insure.security.IDVMethodSpecifier#isValidating(com.parasoft.api.insure.security.DVMethod)
     */
    public Boolean isValidating(DVMethod method) {
        if (method
            .matches("examples.runtime.security.MethodSpecifierExample.verifyInputIsGood"))
            return TRUE;
        return null;
    }
    
    /**
     * @see com.parasoft.api.insure.security.IDVMethodSpecifier#isDangerous(com.parasoft.api.insure.security.DVMethod)
     */
    public Boolean isDangerous(DVMethod method) {
        if (method
            .matches("examples.runtime.security.MethodSpecifierExample.dangerousMethod"))
            return TRUE;
        return null;
    }
}
