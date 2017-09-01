package com.jason.singleton;

/**
 * DCL: Double check lock
 */
public class DCL {
    // volatile: initialize DCL only once in project (java version >= 1.5)
    private static volatile DCL dclsingleton;

    // default constructor
    private DCL() {
    }

    public static DCL getInstance() {
        // check singleton whether exists firstly
        if (dclsingleton == null) {
            // synchronized: load threads serially
            synchronized (DCL.class) {
                // check singleton whether exists secondly
                if (dclsingleton == null) {
                    dclsingleton = new DCL();
                }
            }
        }
        return dclsingleton;
    }
}
