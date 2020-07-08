package com.smic.weather.bmodel;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @autor Smogevscih Yuri
 * 08.07.2020
 **/
@Entity
public class City {
    @PrimaryKey
    private int id;
    private String name;
    private String typeCity;
    public double tJanuary;
    public double tFebruary;
    public double tMarch;
    public double tApril;
    public double tMay;
    public double tJune;
    public double tJuly;
    public double tAugust;
    public double tSeptember;
    public double tOctober;
    public double tNovember;
    public double tDecember;

    @Override
    public String toString() {
        return name;
    }

    public City() {
    }

    public String getTypeCity() {
        return typeCity;
    }

    public void setTypeCity(String typeCity) {
        this.typeCity = typeCity;
    }

    public double gettJanuary() {
        return tJanuary;
    }

    public double gettFebruary() {
        return tFebruary;
    }

    public double gettMarch() {
        return tMarch;
    }

    public double gettApril() {
        return tApril;
    }

    public double gettMay() {
        return tMay;
    }

    public double gettJune() {
        return tJune;
    }

    public double gettJuly() {
        return tJuly;
    }

    public double gettAugust() {
        return tAugust;
    }

    public double gettSeptember() {
        return tSeptember;
    }

    public double gettOctober() {
        return tOctober;
    }

    public double gettNovember() {
        return tNovember;
    }

    public double gettDecember() {
        return tDecember;
    }

    public void settJanuary(double tJanuary) {
        this.tJanuary = tJanuary;
    }

    public void settFebruary(double tFebruary) {
        this.tFebruary = tFebruary;
    }

    public void settMarch(double tMarch) {
        this.tMarch = tMarch;
    }

    public void settApril(double tApril) {
        this.tApril = tApril;
    }

    public void settMay(double tMay) {
        this.tMay = tMay;
    }

    public void settJune(double tJune) {
        this.tJune = tJune;
    }

    public void settJuly(double tJuly) {
        this.tJuly = tJuly;
    }

    public void settAugust(double tAugust) {
        this.tAugust = tAugust;
    }

    public void settSeptember(double tSeptember) {
        this.tSeptember = tSeptember;
    }

    public void settOctober(double tOctober) {
        this.tOctober = tOctober;
    }

    public void settNovember(double tNovember) {
        this.tNovember = tNovember;
    }

    public void settDecember(double tDecember) {
        this.tDecember = tDecember;
    }

    public City(int id, String name, String typeCity, double tJanuary,
                double tFebruary, double tMarch, double tApril,
                double tMay, double tJune, double tJuly, double tAugust,
                double tSeptember, double tOctober, double tNovember, double tDecember) {
        this.id = id;
        this.name = name;
        this.typeCity = typeCity;

        this.tJanuary = tJanuary;
        this.tFebruary = tFebruary;
        this.tMarch = tMarch;
        this.tApril = tApril;
        this.tMay = tMay;
        this.tJune = tJune;
        this.tJuly = tJuly;
        this.tAugust = tAugust;
        this.tSeptember = tSeptember;
        this.tOctober = tOctober;
        this.tNovember = tNovember;
        this.tDecember = tDecember;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
