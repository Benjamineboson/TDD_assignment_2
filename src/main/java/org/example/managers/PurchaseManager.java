package org.example.managers;

import org.example.data.IPurchaseStore;

public class PurchaseManager implements IPurchaseManager {

    private IPurchaseStore purchaseStore;

    public PurchaseManager(IPurchaseStore purchaseStore) {
        this.purchaseStore = purchaseStore;
    }

    @Override
    public float sumOfMonth(int year, int month) {
        return 0;
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
