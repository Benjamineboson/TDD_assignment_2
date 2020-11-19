package org.example.managers;

import org.example.data.PurchaseStoreStump;
import org.example.exceptions.ListEmptyException;
import org.example.exceptions.PurchaseNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PurchaseManagerTest_mockito {

    private PurchaseManager purchaseManager;

    @BeforeEach
    void setUp() {

    }

    // -------------------------------------------------------- sumOfMonth() --------------------------------------------------------

    @Test
    public void testSumOfMonth(){
    }

    @Test
    public void testSumOfMonth_notFound(){
    }

    @Test
    public void testSumOfMonth_invalidLocalDate_month(){
    }

    @Test
    public void testSumOfMonth_invalidLocalDate_year(){
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
