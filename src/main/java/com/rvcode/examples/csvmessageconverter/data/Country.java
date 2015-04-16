package com.rvcode.examples.csvmessageconverter.data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Volodymyr Rudyi
 */
public class Country implements Serializable{

    private static final long serialVersionUID = 1L;

    private String name;
    private String capital;
    private long population;
    private double totalArea;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }
}
