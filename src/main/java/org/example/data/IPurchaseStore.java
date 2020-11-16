package org.example.data;

import org.example.entities.Category;
import org.example.entities.Purchase;

import java.time.LocalDate;

public interface IPurchaseStore {
    Purchase[] getPurchases (LocalDate startDate, LocalDate endDate);
    Purchase[] getPurchasesByCategory (LocalDate startDate, LocalDate endDate, int categoryId);
    Category[] getAllCategories();
}
