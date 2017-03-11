package com.framework.base.util.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yuanjinglin on 15/12/11.
 */
public class CollectionsTest {
    public void jdk6SortTest(){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
    }
    public void jdk8SortTest(){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        //other
        Collections.sort(names, (a,b) -> {
            return b.compareTo(a);
        });
        //other
        Collections.sort(names, (a,b) -> b.compareTo(a));
    }
}
