package org.example.managers;

import org.example.data.PurchaseStoreStump;
import org.example.exceptions.ListEmptyException;
import org.example.exceptions.PurchaseNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PurchaseManagerTest_stump {

    private PurchaseManager purchaseManager;
    private PurchaseStoreStump purchaseStoreStump;

    @BeforeEach
    void setUp() {
        purchaseStoreStump = new PurchaseStoreStump();
        purchaseManager = new PurchaseManager(purchaseStoreStump);

        purchaseStoreStump.addPurchase(10, LocalDate.of(2020,3,1),310,
                "I bought a shirt",24);
        purchaseStoreStump.addPurchase(11, LocalDate.of(2020,3,1),4000,
                "I bought some pants",24);

        purchaseStoreStump.addPurchase(12, LocalDate.of(2020,4,1),1100,
                "I bought some speakers",22);

        purchaseStoreStump.addPurchase(13, LocalDate.of(2020,4,1),1050,
                "I bought a hat...",24);


        purchaseStoreStump.addCategory(20,"Food");
        purchaseStoreStump.addCategory(21,"Car");
        purchaseStoreStump.addCategory(22,"Home");
        purchaseStoreStump.addCategory(23,"Entertainment");
        purchaseStoreStump.addCategory(24,"Clothes");

    }

    // -------------------------------------------------------- sumOfMonth() --------------------------------------------------------

    @Test
    public void testSumOfMonth(){
        assertEquals(4310,purchaseManager.sumOfMonth(2020,3));
    }

    @Test
    public void testSumOfMonth_notFound(){
        assertThrows(PurchaseNotFoundException.class,() -> purchaseManager.sumOfMonth(2020,8));
    }

    @Test
    public void testSumOfMonth_invalidLocalDate_month(){
        assertThrows(DateTimeException.class,() -> purchaseManager.sumOfMonth(2020,0));
    }

    @Test
    public void testSumOfMonth_invalidLocalDate_year(){
        assertThrows(DateTimeException.class,() -> purchaseManager.sumOfMonth(0,9));
    }

    @Test
    public void testSumOfMonth_purchaseList_empty(){
        purchaseStoreStump.setPurchaseList(new ArrayList<>());
        assertThrows(ListEmptyException.class,() -> purchaseManager.sumOfMonth(2020,3));
    }

    @Test
    public void testSumOfMonth_purchaseList_null(){
        purchaseStoreStump.setPurchaseList(null);
        assertThrows(NullPointerException.class,() -> purchaseManager.sumOfMonth(2020,3));
    }


    // -------------------------------------------------------- monthlyAverage() --------------------------------------------------------

    @Test
    public void testMonthlyAverage(){
        double[] expected = {0,0,2155,1075,0,0,0,0,0,0,0,0};
        assertArrayEquals(expected,purchaseManager.monthlyAverage(2020));
    }

    @Test
    public void testMonthlyAverage_oneOccurrence(){
        purchaseStoreStump.setPurchaseList(new ArrayList<>());
        purchaseStoreStump.addPurchase(13, LocalDate.of(2020,8,31),1050,
                "I bought some food",20);
        double[] expected = {0,0,0,0,0,0,0,1050,0,0,0,0};
        assertArrayEquals(expected,purchaseManager.monthlyAverage(2020));
    }

    @Test
    public void testMonthlyAverage_notFound(){
        assertThrows(PurchaseNotFoundException.class,() -> purchaseManager.monthlyAverage(2019));
    }

    @Test
    public void testMonthlyAverage_invalidLocalDate_year(){
        assertThrows(DateTimeException.class,() -> purchaseManager.monthlyAverage(0));
    }

    @Test
    public void testMonthlyAverage_purchaseList_empty(){
        purchaseStoreStump.setPurchaseList(new ArrayList<>());
        assertThrows(ListEmptyException.class,() -> purchaseManager.monthlyAverage(2020));
    }

    @Test
    public void testMonthlyAverage_purchaseList_null(){
        purchaseStoreStump.setPurchaseList(null);
        assertThrows(NullPointerException.class,() -> purchaseManager.monthlyAverage(2020));
    }


    // -------------------------------------------------------- yearlyAverageByCategory() --------------------------------------------------------

    @Test
    public void testYearlyAverageByCategory(){
        double[] expected = {0,0,1100,0,1786.6666666666667};
        assertArrayEquals(expected,purchaseManager.yearlyAverageByCategory(2020));
    }

    @Test
    public void testYearlyAverageByCategory_oneOccurrence(){
        purchaseStoreStump.setPurchaseList(new ArrayList<>());
        purchaseStoreStump.addPurchase(13, LocalDate.of(2020,4,1),1050,
                "I bought a hat...",24);
        double[] expected = {0,0,0,0,1050};
        assertArrayEquals(expected,purchaseManager.yearlyAverageByCategory(2020));
    }

    @Test
    public void testYearlyAverageByCategory_notFound(){
        assertThrows(PurchaseNotFoundException.class,() -> purchaseManager.yearlyAverageByCategory(2019));
    }

    @Test
    public void testYearlyAverageByCategory_invalidLocalDate_year(){
        assertThrows(DateTimeException.class,() -> purchaseManager.yearlyAverageByCategory(0));
    }

    @Test
    public void testYearlyAverageByCategory_purchaseList_empty(){
        purchaseStoreStump.setPurchaseList(new ArrayList<>());
        assertThrows(ListEmptyException.class,() -> purchaseManager.yearlyAverageByCategory(2020));
    }

    @Test
    public void testYearlyAverageByCategory_categoryList_empty(){
        purchaseStoreStump.setCategoryList(new ArrayList<>());
        assertThrows(ListEmptyException.class,() -> purchaseManager.yearlyAverageByCategory(2020));
    }

    @Test
    public void testYearlyAverageByCategory_purchaseList_null(){
        purchaseStoreStump.setPurchaseList(null);
        assertThrows(NullPointerException.class,() -> purchaseManager.yearlyAverageByCategory(2020));
    }

    @Test
    public void testYearlyAverageByCategory_categoryList_null(){
        purchaseStoreStump.setCategoryList(null);
        assertThrows(NullPointerException.class,() -> purchaseManager.yearlyAverageByCategory(2020));
    }


}
