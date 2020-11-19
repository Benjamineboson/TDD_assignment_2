package org.example.managers;

public interface IPurchaseManager {

    double sumOfMonth (int year, int month);
    double[] monthlyAverage (int year);
    double[] yearlyAverageByCategory(int year);
}
