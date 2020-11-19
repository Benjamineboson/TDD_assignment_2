package org.example.managers;

import org.example.data.PurchaseStore;
import org.example.data.PurchaseStoreStump;
import org.example.entities.Purchase;
import org.example.exceptions.ListEmptyException;
import org.example.exceptions.PurchaseNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class PurchaseManagerTest_mockito {

    private PurchaseManager purchaseManager;
    private PurchaseStore purchaseStore;

    @BeforeEach
    void setUp() {
        purchaseStore = mock(PurchaseStore.class);
        purchaseManager = new PurchaseManager(purchaseStore);
        when(purchaseStore.getPurchases(LocalDate.of(2018,1,1),LocalDate.now()))
                .thenReturn(
                    new Purchase[]{new Purchase(10,LocalDate.of(2020,01,25),20,"Milk",20),
                });
    }

    // -------------------------------------------------------- sumOfMonth() --------------------------------------------------------

    @Test
    public void testSumOfMonth(){
        when(purchaseStore.getPurchases(LocalDate.of(2020,1,1),LocalDate.of(2020,2,1)))
                .thenReturn(new Purchase[] {
                        new Purchase(10,LocalDate.of(2020,01,25),10,"Milk",20),
                        new Purchase(10,LocalDate.of(2020,01,12),10,"Banana",20),
                        new Purchase(10,LocalDate.of(2020,01,25),20,"Bacon",20),
                        new Purchase(10,LocalDate.of(2020,01,25),100,"Eggs",20),
                });
        assertEquals(140,purchaseManager.sumOfMonth(2020,1));
    }

    @Test
    public void testSumOfMonth_notFound(){
        when(purchaseStore.getPurchases(LocalDate.of(2020,2,1),LocalDate.of(2020,3,1)))
                .thenThrow(PurchaseNotFoundException.class);
        assertThrows(PurchaseNotFoundException.class,() -> purchaseManager.sumOfMonth(2020,2));
    }

    @Test
    public void testSumOfMonth_invalidLocalDate_month(){
        assertThrows(DateTimeException.class,() -> purchaseManager.sumOfMonth(2020,0));
    }

    @Test
    public void testSumOfMonth_invalidLocalDate_year(){
        assertThrows(DateTimeException.class,() -> purchaseManager.sumOfMonth(0,2));
    }

    @Test
    public void testSumOfMonth_purchaseList_empty(){

    }

    @Test
    public void testSumOfMonth_purchaseList_null(){
    }


    // -------------------------------------------------------- monthlyAverage() --------------------------------------------------------

    @Test
    public void testMonthlyAverage(){
    }

    @Test
    public void testMonthlyAverage_oneOccurrence(){
    }

    @Test
    public void testMonthlyAverage_notFound(){
    }

    @Test
    public void testMonthlyAverage_invalidLocalDate_year(){
    }

    @Test
    public void testMonthlyAverage_purchaseList_empty(){
    }

    @Test
    public void testMonthlyAverage_purchaseList_null(){
    }


    // -------------------------------------------------------- yearlyAverageByCategory() --------------------------------------------------------

    @Test
    public void testYearlyAverageByCategory(){
    }

    @Test
    public void testYearlyAverageByCategory_oneOccurrence(){
    }

    @Test
    public void testYearlyAverageByCategory_notFound(){
    }

    @Test
    public void testYearlyAverageByCategory_invalidLocalDate_year(){
    }

    @Test
    public void testYearlyAverageByCategory_purchaseList_empty(){
    }

    @Test
    public void testYearlyAverageByCategory_categoryList_empty(){
    }

    @Test
    public void testYearlyAverageByCategory_purchaseList_null(){
    }

    @Test
    public void testYearlyAverageByCategory_categoryList_null(){
    }
}
