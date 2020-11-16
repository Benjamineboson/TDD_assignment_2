package org.example.managers;

public interface IPurchaseManager {

    float sumOfMonth (int year, int month);
    float[] monthlyAverage (int year);
    float yearlyAverageByCategory(int year);
}
