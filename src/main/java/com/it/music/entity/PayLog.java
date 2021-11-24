package com.it.music.entity;

/**
 * @author 羡羡
 */
public class PayLog {
    public int paylogid;
    public int usid;
    public String amt;
    public String ordernumber;
    public String transactionnumber;
    public String tradingtime;

    public int getPaylogid() {
        return paylogid;
    }

    public void setPaylogid(int paylogid) {
        this.paylogid = paylogid;
    }

    public int getUsid() {
        return usid;
    }

    public void setUsid(int usid) {
        this.usid = usid;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getTransactionnumber() {
        return transactionnumber;
    }

    public void setTransactionnumber(String transactionnumber) {
        this.transactionnumber = transactionnumber;
    }

    public String getTradingtime() {
        return tradingtime;
    }

    public void setTradingtime(String tradingtime) {
        this.tradingtime = tradingtime;
    }

    public PayLog() {
    }

    public PayLog(int usid, String amt, String ordernumber, String transactionnumber, String tradingtime) {
        this.usid = usid;
        this.amt = amt;
        this.ordernumber = ordernumber;
        this.transactionnumber = transactionnumber;
        this.tradingtime = tradingtime;
    }

    public PayLog(int paylogid, int usid, String amt, String ordernumber, String transactionnumber, String tradingtime) {
        this.paylogid = paylogid;
        this.usid = usid;
        this.amt = amt;
        this.ordernumber = ordernumber;
        this.transactionnumber = transactionnumber;
        this.tradingtime = tradingtime;
    }


    @Override
    public String toString() {
        return "PayLog{" +
                "paylogid=" + paylogid +
                ", usid=" + usid +
                ", amt='" + amt + '\'' +
                ", ordernumber='" + ordernumber + '\'' +
                ", transactionnumber='" + transactionnumber + '\'' +
                ", tradingtime='" + tradingtime + '\'' +
                '}';
    }
}
