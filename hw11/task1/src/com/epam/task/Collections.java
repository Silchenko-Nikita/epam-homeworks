package com.epam.task;

import java.util.List;
import java.util.Set;

public class Collections {
    private List<Integer> list;
    private Set<Integer> set;

    public Collections(List<Integer> list, Set<Integer> set) {
        this.list = list;
        this.set = set;
    }

    public void displayList() {
        System.out.println("List: ");
        System.out.println(list);
    }

    public void displaSet() {
        System.out.println("Set: ");
        System.out.println(set);
    }
}
