package com.epam.task;

import java.util.*;

public class CollectionsGenerator {

    static List<Integer> generateList(int number, int leftBound, int rightBound) {
        List<Integer> list = new ArrayList<>();
        int range = rightBound - leftBound;
        for (int i = 0; i < number; i++) {
            list.add(i % range + leftBound);
        }
        return list;
    }

    static Set<Integer> generateSet(int number, int leftBound, int rightBound) throws InvalidRangeException {
        Set<Integer> list = new LinkedHashSet<>();
        int range = rightBound - leftBound;

        if (range < number) throw new InvalidRangeException(
                number + " elements can't fit in range: [" + leftBound + ", " + rightBound + "]");

        for (int i = 0; i < number; i++) {
            list.add(i + leftBound);
        }
        return list;
    }
}
