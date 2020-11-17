package org.example.managers;

import org.example.data.PurchaseStoreStump;
import org.example.exceptions.ListEmptyException;
import org.example.exceptions.PurchaseNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.cglib.core.Local;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PurchaseManagerTest {

    private PurchaseManager purchaseManager;
    private PurchaseStoreStump purchaseStoreStump;

    @BeforeEach
    void setUp() {
        purchaseStoreStump = new PurchaseStoreStump();
        purchaseManager = new PurchaseManager(purchaseStoreStump);

//        purchaseStoreStump.addCategory(20,"Food");
//        purchaseStoreStump.addCategory(21,"Car");
//        purchaseStoreStump.addCategory(22,"Home");
//        purchaseStoreStump.addCategory(23,"Entertainment");
    }

    @Test
    public void testSumOfMonth(){
        purchaseStoreStump.addCategory(24,"Clothes");
        purchaseStoreStump.addPurchase(10, LocalDate.of(2020,3,13),1000,
                "I bought a shirt",24);
        purchaseStoreStump.addPurchase(11, LocalDate.of(2020,3,13),1001,
                "I bought some pants",24);
        assertEquals(2001,purchaseManager.sumOfMonth(2020,3));
    }

    @Test
    public void testSumOfMonth_purchases_notFound(){
        purchaseStoreStump.addPurchase(10, LocalDate.of(2020,3,1),1000,
                "I bought a shirt",24);
        purchaseStoreStump.addPurchase(11, LocalDate.of(2020,5,1),1000,
                "I bought some pants",24);
        assertThrows(PurchaseNotFoundException.class,() -> purchaseManager.sumOfMonth(2020,4));
    }

    @Test
    public void testSumOfMonth_purchases_empty(){
        assertThrows(ListEmptyException.class,() -> purchaseManager.sumOfMonth(2020,3));
    }

    @Test
    public void testSumOfMonth_purchases_null(){
        purchaseStoreStump.setPurchaseList(null);
        assertThrows(NullPointerException.class,() -> purchaseManager.sumOfMonth(2020,3));
    }








}
