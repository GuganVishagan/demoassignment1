package org.demoassignment1.demoassignment1;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Notification {
    private String id;
    private String message;
    private double btcPrice;
    private double marketRate;
    private double volume;
    private double intradayHigh;
    private double marketCap;

    public Notification(String message, double intradayHigh, double marketCap, double volume, double btcPrice, double marketRate) {
        this.id = UUID.randomUUID().toString();
        this.message = message;
        this.intradayHigh = intradayHigh;
        this.marketRate = marketRate;
        this.volume = volume;
        this.btcPrice = btcPrice;
        this.marketCap = marketCap;
    }
}
