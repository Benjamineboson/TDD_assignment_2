package org.example.data;

import org.example.entities.Category;
import org.example.entities.Purchase;
import org.example.exceptions.ListEmptyException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

public class PurchaseStoreStump extends PurchaseStore {

    private List<Purchase> purchaseList;
    private List<Category> categoryList;

    public PurchaseStoreStump() {
        this.purchaseList = new ArrayList<>();
        this.categoryList = new ArrayList<>();
    }

    public void addPurchase(int purchaseId, LocalDate date, float amount, String comment, int categoryId){
        purchaseList.add(new Purchase(purchaseId,date,amount,comment,categoryId));
    }

    public void addCategory(int categoryId, String description){
        categoryList.add(new Category(categoryId,description));
    }

    @Override
    public Purchase[] getPurchases(LocalDate startDate, LocalDate endDate) {
        if (purchaseList.isEmpty()) throw new ListEmptyException("The list of purchases is empty");
        Purchase [] purchases = purchaseList.stream()
                .filter(purchase -> purchase.getDate().isAfter(startDate) || purchase.getDate().isEqual(startDate))
                .filter(purchase -> purchase.getDate().isBefore(endDate))
                .toArray(Purchase[]::new);
        return purchases;
    }

    @Override
    public Purchase[] getPurchasesByCategory(LocalDate startDate, LocalDate endDate, int categoryId) {
        return super.getPurchasesByCategory(startDate, endDate, categoryId);
    }

    @Override
    public Category[] getAllCategories() {
        return super.getAllCategories();
    }

    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
