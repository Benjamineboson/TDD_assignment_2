package org.example.data;

import org.example.entities.Category;
import org.example.entities.Purchase;

import java.time.LocalDate;

public class PurchaseStore implements IPurchaseStore {

    @Override
    public Purchase[] getPurchases(LocalDate startDate, LocalDate endDate) {
        return new Purchase[0];
    }

    @Override
    public Purchase[] getPurchasesByCategory(LocalDate startDate, LocalDate endDate, int categoryId) {
        return new Purchase[0];
    }

    @Override
    public Category[] getAllCategories() {
        return new Category[0];
    }


}
