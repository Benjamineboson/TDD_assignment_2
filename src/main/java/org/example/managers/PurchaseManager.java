package org.example.managers;
import org.example.data.IPurchaseStore;
import org.example.entities.Category;
import org.example.entities.Purchase;
import org.example.exceptions.ListEmptyException;
import org.example.exceptions.PurchaseNotFoundException;
import java.time.DateTimeException;
import java.time.LocalDate;

public class PurchaseManager implements IPurchaseManager {

    private IPurchaseStore purchaseStore;

    public PurchaseManager(IPurchaseStore purchaseStore) {
        this.purchaseStore = purchaseStore;
    }

    @Override
    public double sumOfMonth(int year, int month) {
        if (purchaseStore.getPurchases(LocalDate.of(2018,1,1), LocalDate.now()).length == 0)
            throw new ListEmptyException("The list of purchases is empty");
        if (month > 12) throw new DateTimeException("Chosen month must be between 1-12");
        if (year < 2018) throw new DateTimeException("Earliest purchases are from 2018");
        LocalDate period = LocalDate.of(year,month,1);
        if (purchaseStore.getPurchases(period,period.plusMonths(1)) == null) throw new NullPointerException();
        Purchase[] purchases = purchaseStore.getPurchases(period,period.plusMonths(1));
        if (purchases.length < 1) throw new PurchaseNotFoundException("No purchases were made that year");
        double sum = 0;
        for (int i = 0; i < purchases.length ; i++) {
            sum += purchases[i].getAmount();
        }
        return sum;
    }

    @Override
    public double[] monthlyAverage(int year) {
        if (purchaseStore.getPurchases(LocalDate.of(2018,1,1), LocalDate.now()).length == 0)
            throw new ListEmptyException("The list of purchases is empty");
        if (year < 2018) throw new DateTimeException("Earliest purchases are from 2018");
        LocalDate period = LocalDate.of(year,1,1);
        if (purchaseStore.getPurchases(period,period.plusYears(1)) == null) throw new NullPointerException();
        Purchase[] purchases = purchaseStore.getPurchases(period,period.plusYears(1));
        if (purchases.length < 1) throw new PurchaseNotFoundException("No purchases were made that year");
        double [] averagesArr = new double[12];
        double [] occurrencesArr = new double[12];
        for (int i = 0; i < purchases.length; i++) {
            for (int j = 1; j < 13; j++) {
                if (purchases[i].getDate().getMonthValue() == j){
                    averagesArr[j-1] += purchases[i].getAmount();
                    occurrencesArr[j-1]++;
                }
            }
        }
        for (int i = 0; i < averagesArr.length; i++) {
            if (occurrencesArr[i] != 0){
                averagesArr[i] = averagesArr[i]/occurrencesArr[i];
            }
        }
        return averagesArr;
    }

    @Override
    public double[] yearlyAverageByCategory(int year) {
        if (purchaseStore.getPurchases(LocalDate.of(2018,1,1), LocalDate.now()).length == 0)
            throw new ListEmptyException("The list of purchases is empty");
        if (purchaseStore.getAllCategories().length == 0) throw new ListEmptyException("The list of categories is empty");
        if (year < 2018) throw new DateTimeException("Earliest purchases are from 2018");
        LocalDate period = LocalDate.of(year,1,1);
        if (purchaseStore.getPurchases(period,period.plusYears(1)) == null) throw new NullPointerException();
        if (purchaseStore.getAllCategories() == null) throw new NullPointerException();
        Purchase[] purchases = purchaseStore.getPurchases(period,period.plusYears(1));
        Category[] categories = purchaseStore.getAllCategories();
        double [] occurrencesArr = new double[categories.length];
        double [] averagesArr = new double[categories.length];
        if (purchases.length < 1) throw new PurchaseNotFoundException("No purchases were made that year");
        for (int i = 0; i < purchases.length; i++) {
            for (int j = 0; j < categories.length; j++) {
                if (purchases[i].getCategoryId() == categories[j].getCategoryId()){
                    averagesArr[j] += purchases[i].getAmount();
                    occurrencesArr[j]++;
                }
            }
        }
        for (int i = 0; i < averagesArr.length ; i++) {
            if (occurrencesArr[i] != 0){
                averagesArr[i] = averagesArr[i]/occurrencesArr[i];
            }
        }
    return averagesArr;
    }
}
