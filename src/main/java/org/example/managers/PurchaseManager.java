package org.example.managers;

import org.example.data.IPurchaseStore;
import org.example.entities.Purchase;
import org.example.exceptions.ListEmptyException;
import org.example.exceptions.PurchaseNotFoundException;

import java.time.LocalDate;
import java.util.List;

public class PurchaseManager implements IPurchaseManager {

    private IPurchaseStore purchaseStore;

    public PurchaseManager(IPurchaseStore purchaseStore) {
        this.purchaseStore = purchaseStore;
    }

    @Override
    public float sumOfMonth(int year, int month) {
        LocalDate period = LocalDate.of(year,month,1);
        if (purchaseStore.getPurchases(period,period.plusMonths(1)) == null) throw new NullPointerException();
        Purchase[] purchases = purchaseStore.getPurchases(period,period.plusMonths(1));
        if (purchases.length < 1) throw new PurchaseNotFoundException("There were no purchases made that year");
        float sum = 0;
        for (int i = 0; i < purchases.length ; i++) {
            sum += purchases[i].getAmount();
        }
        return sum;
    }

    @Override
    public float[] monthlyAverage(int year) {
        return new float[0];
    }

    @Override
    public float yearlyAverageByCategory(int year) {
        return 0;
    }
}
