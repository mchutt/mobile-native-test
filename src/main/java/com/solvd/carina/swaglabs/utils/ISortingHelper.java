package com.solvd.carina.swaglabs.utils;

import java.util.List;

public interface ISortingHelper {
    default <T extends Comparable<T>> boolean isSortedInAscendingOrder(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    default <T extends Comparable<T>> boolean isSortedInDescendingOrder(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) < 0) {
                return false;
            }
        }
        return true;
    }
}
