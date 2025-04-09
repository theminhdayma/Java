package business.model;

import java.time.LocalDate;

public class FundTransfer {
    private int fdId;
    private int accSenderId;
    private int accReceiverId;
    private double amount;
    private LocalDate fdCreated;
    private byte status;

    public FundTransfer() {
    }

    public FundTransfer(int fdId, int accSenderId, int accReceiverId, double amount, LocalDate fdCreated, byte status) {
        this.fdId = fdId;
        this.accSenderId = accSenderId;
        this.accReceiverId = accReceiverId;
        this.amount = amount;
        this.fdCreated = fdCreated;
        this.status = status;
    }

    public int getFdId() {
        return fdId;
    }

    public int getAccSenderId() {
        return accSenderId;
    }

    public int getAccReceiverId() {
        return accReceiverId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getFdCreated() {
        return fdCreated;
    }

    public byte getStatus() {
        return status;
    }

    public void setFdId(int fdId) {
        this.fdId = fdId;
    }

    public void setAccSenderId(int accSenderId) {
        this.accSenderId = accSenderId;
    }

    public void setAccReceiverId(int accReceiverId) {
        this.accReceiverId = accReceiverId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setFdCreated(LocalDate fdCreated) {
        this.fdCreated = fdCreated;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FundTransfer{" +
                "fdId=" + fdId +
                ", accSenderId=" + accSenderId +
                ", accReceiverId=" + accReceiverId +
                ", amount=" + amount +
                ", fdCreated=" + fdCreated +
                ", status=" + status +
                '}';
    }
}
