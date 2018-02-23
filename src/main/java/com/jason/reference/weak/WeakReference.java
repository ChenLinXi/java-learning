package com.jason.reference.weak;

import com.jason.reference.Reference;
import java.util.concurrent.TimeUnit;

public class WeakReference {

    public static void main(String[] args) throws Exception {

        // weak reference
        Reference weakReference = new Reference("weak reference");
        java.lang.ref.WeakReference<Reference> referenceWeakReference = new java.lang.ref.WeakReference<Reference>(
            weakReference);
        System.out.println(referenceWeakReference.get().getReference());

        // sleep 5 second till gc
        referenceWeakReference.clear();
        TimeUnit.SECONDS.sleep(5);
        // after clear weak reference, throw java.lang.NullPointerException
        System.out.println(referenceWeakReference.get().getReference());
    }
}
