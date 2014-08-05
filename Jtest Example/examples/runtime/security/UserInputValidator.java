
package examples.runtime.security;

import com.parasoft.api.insure.security.IInputValidator;

/**
 * Example input validator.
 */
public class UserInputValidator implements IInputValidator {
    
    /**
     * @see com.parasoft.api.insure.security.IInputValidator#validate(java.lang.Object,
     *      java.lang.String, java.lang.String)
     */
    public Object validate(Object input, String source, String tainting_method) {
        if (input instanceof String) {
            if (((String) input).indexOf("hacked") != -1)
                throw new SecurityException("attack detected: " + input);
        }
        return input;
    }
}
