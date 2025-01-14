package com.solvd.carina.swaglabs.utils;

import com.solvd.carina.swaglabs.components.common.ProductCardComponentBase;
import com.solvd.carina.swaglabs.enums.SortType;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;
import java.util.stream.Collectors;

public interface ISortingHelper {

    default boolean isProductListSorted(List<? extends ProductCardComponentBase> list, SortType type) {

        switch (type) {
            case NAME_A_TO_Z: {
                List<String> productNameList = list.stream().map(ProductCardComponentBase::getProductName).collect(Collectors.toList());
                return isSortedInAscendingOrder(productNameList);
            }
            case NAME_Z_TO_A: {
                List<String> productNameList = list.stream().map(ProductCardComponentBase::getProductName).collect(Collectors.toList());
                return isSortedInDescendingOrder(productNameList);
            }
            case PRICE_LOW_TO_HIGH: {
                List<Double> productPriceList = list.stream().map(ProductCardComponentBase::getPriceWithoutDollarSymbol).collect(Collectors.toList());
                return isSortedInAscendingOrder(productPriceList);
            }
            case PRICE_HIGH_TO_LOW: {
                List<Double> productPriceList = list.stream().map(ProductCardComponentBase::getPriceWithoutDollarSymbol).collect(Collectors.toList());
                return isSortedInDescendingOrder(productPriceList);
            }
            default:
                throw new NotImplementedException("sorting type not implemented: " + type);
        }
    }

    private <T extends Comparable<T>> boolean isSortedInAscendingOrder(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    private <T extends Comparable<T>> boolean isSortedInDescendingOrder(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) < 0) {
                return false;
            }
        }
        return true;
    }
}
