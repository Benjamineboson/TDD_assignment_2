package org.example.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Purchase {

    private int purchaseId;
    private LocalDate date;
    private float amount;
    private String comment;
    private int categoryId;

    public Purchase(int purchaseId, LocalDate date, float amount, String comment, int categoryId) {
        this.purchaseId = purchaseId;
        this.date = date;
        this.amount = amount;
        this.comment = comment;
        this.categoryId = categoryId;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return purchaseId == purchase.purchaseId &&
                Float.compare(purchase.amount, amount) == 0 &&
                categoryId == purchase.categoryId &&
                Objects.equals(date, purchase.date) &&
                Objects.equals(comment, purchase.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseId, date, amount, comment, categoryId);
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseId=" + purchaseId +
                ", date=" + date +
                ", amount=" + amount +
                ", comment='" + comment + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}
