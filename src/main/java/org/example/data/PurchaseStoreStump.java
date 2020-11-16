package org.example.data;

import org.example.entities.Category;
import org.example.entities.Purchase;

import java.time.LocalDate;
import java.util.List;

public class PurchaseStoreStump extends PurchaseStore {

    private List<Purchase> purchaseList;
    private List<Category> categoryList;

    @Override
    public Purchase[] getPurchases(LocalDate startDate, LocalDate endDate) {
        return super.getPurchases(startDate, endDate);
    }

    @Override
    public Purchase[] getPurchasesByCategory(LocalDate startDate, LocalDate endDate, int categoryId) {
        return super.getPurchasesByCategory(startDate, endDate, categoryId);
    }

    @Override
    public Category[] getAllCategories() {
        return super.getAllCategories();
    }
}
