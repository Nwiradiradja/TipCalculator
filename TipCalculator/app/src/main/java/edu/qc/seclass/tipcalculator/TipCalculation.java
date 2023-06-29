package edu.qc.seclass.tipcalculator;

import android.widget.Toast;

public class TipCalculation {
    private double checkAmount;
    private int partySize;
    private final double fifteenTip = .15;
    private final double twentyTip = .20;
    private final double twentyfiveTip = .25;
    private double fifteenTipEach;
    private double twentyTipEach;
    private double twentyfiveTipEach;
    private double fifteenTotal;
    private double twentyTotal;
    private double twentyfiveTotal;



    public TipCalculation(double checkAmount, int partySize){
        this.checkAmount = checkAmount;
        this.partySize = partySize;
        calculatefifteenTip();
        calculatetwentyTip();
        calculatetwentyfiveTip();
        calculatefifteenTotal();
        calculatetwentyTotal();
        calculatetwentyfiveTotal();

    }

    private double getCheckAmount() {return this.checkAmount; }
    private int getPartySize() {return this.partySize; }
    public double getFifteenTip() {return this.fifteenTip; }
    public double getTwentyTip() {return this.twentyTip; }
    public double getTwentyfiveTip() {return this.twentyfiveTip; }
    public double getFifteenTipEach() {return this.fifteenTipEach; }
    public double getTwentyTipEach() {return this.twentyTipEach; }
    public double getTwentyfiveTipEach() {return this.twentyfiveTipEach; }
    public double getFifteenTotal() {return this.fifteenTotal; }
    public double getTwentyTotal() {return this.twentyTotal; }
    public double getTwentyfiveTotal() {return this.twentyfiveTotal; }

    public void setCheckAmount(double checkAmount) {this.checkAmount = checkAmount; }
    public void setPartySize(int partySize) {this.partySize = partySize; }
    private void setFifteenTipEach(double fifteenTipEach) {this.fifteenTipEach = fifteenTipEach; }
    private void setTwentyTipEach(double twentyTipEach) {this.twentyTipEach = twentyTipEach; }
    private void setTwentyfiveTipEach(double twentyfiveTipEach) {this.twentyfiveTipEach = twentyfiveTipEach; }
    private void setFifteenTotal(double fifteenTotal) {this.fifteenTotal = fifteenTotal; }
    private void setTwentyTotal(double twentyTotal) {this.twentyTotal = twentyTotal; }
    private void setTwentyfiveTotal(double twentyfiveTotal) {this.twentyfiveTotal = twentyfiveTotal; }

    public void calculatefifteenTip(){
        double fifteenpercentTip = getCheckAmount() * getFifteenTip();
        setFifteenTipEach(roundDouble(fifteenpercentTip / getPartySize(),2));
    }

    public void calculatetwentyTip(){
        double twentypercentTip = getCheckAmount() * getTwentyTip();
        setTwentyTipEach(roundDouble(twentypercentTip / getPartySize(),2));
    }

    public void calculatetwentyfiveTip(){
        double twentyfivepercentTip = getCheckAmount() * getTwentyfiveTip();
        setTwentyfiveTipEach(roundDouble(twentyfivepercentTip / getPartySize(),2));
    }

    public void calculatefifteenTotal(){
        double fifteenpercentTotal = getCheckAmount() * getFifteenTip();
        setFifteenTotal(roundDouble((fifteenpercentTotal + getCheckAmount()) / getPartySize(),2));
    }

    public void calculatetwentyTotal(){
        double twentypercentTotal = getCheckAmount() * getTwentyTip();
        setTwentyTotal(roundDouble((twentypercentTotal + getCheckAmount()) / getPartySize(), 2));
    }

    public void calculatetwentyfiveTotal(){
        double twentyfivepercentTotal = getCheckAmount() * getTwentyfiveTip();
        setTwentyfiveTotal(roundDouble((twentyfivepercentTotal + getCheckAmount()) / getPartySize(),2));
    }

    public static double roundDouble(double num, int decimalPlaces) {
        double myNum = 1.0;
        for(int i = 0; i < decimalPlaces; i++) {
            myNum *= 10.0;
        }
        double roundNum = Math.round(num * myNum) / myNum;
        return roundNum;

    }
}