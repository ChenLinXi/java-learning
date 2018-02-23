package com.jason.singleton;

/**
 * DCL: Double check lock
 *
 * Hello Abhinav, if you notice, first null check is outside of synchronization block and second one is inside
 * synchronization block. If you remember the purpose of double checked locking idiom was to improve performance of
 * getInstance() method which was used to a synchronized method.
 *
 * In reality you need synchronization only when you create instance, and that's why first check is without
 * synchronization it check and return instance without synchronization if already initialized.
 *
 * The second check is inside the synchronization to avoid thread-safety issue, if you don't use synchronization, if two
 * thread access getInstance() same time, they might see different value or half initialized value of Singleton.
 *
 * In short, 1st check to speed up, 2nd check to avoid thread-safety issue.
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
