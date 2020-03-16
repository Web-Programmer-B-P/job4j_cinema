package ru.job4j.model;

import java.util.Objects;

public class Hall {
    private int id;
    private int row;
    private int seat;
    private boolean status;
    private int accountId;

    public Hall() {
    }

    public Hall(int row, int seat, boolean status, int accountId) {
        this.row = row;
        this.seat = seat;
        this.status = status;
        this.accountId = accountId;
    }

    public Hall(int id, int row, int seat, boolean status, int accountId) {
        this.id = id;
        this.row = row;
        this.seat = seat;
        this.status = status;
        this.accountId = accountId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Hall hall = (Hall) o;
        return id == hall.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Hall{id=" + id
                + ", row=" + row
                + ", seat=" + seat
                + ", status=" + status
                + ", accountId=" + accountId
                + '}';
    }
}
