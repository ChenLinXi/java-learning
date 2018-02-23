package com.jason.reference.strong;

import com.jason.reference.Reference;
import java.util.concurrent.TimeUnit;

public class StrongReference {

    public static void main(String[] args) throws Exception {

        // strong reference
        Reference strongReference = new Reference("strong reference");
        System.out.println(strongReference);

        // sleep 5 second till gc
        TimeUnit.SECONDS.sleep(5);
        System.out.println(strongReference);
    }
}
