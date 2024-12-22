package model;

import java.util.Objects;

public class Revenue {
    int year;
    int jan;
    int feb;
    int mar;
    int apr;
    int may;
    int jun;
    int jul;
    int aug;
    int sep;
    int oct;
    int nov;
    int dec;

    public Revenue(int year, int jan, int feb, int mar, int apr, int may, int jun, int jul, int aug, int sep, int oct, int nov, int dec) {
        this.year = year;
        this.jan = jan;
        this.feb = feb;
        this.mar = mar;
        this.apr = apr;
        this.may = may;
        this.jun = jun;
        this.jul = jul;
        this.aug = aug;
        this.sep = sep;
        this.oct = oct;
        this.nov = nov;
        this.dec = dec;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getJan() {
        return jan;
    }

    public void setJan(int jan) {
        this.jan = jan;
    }

    public int getFeb() {
        return feb;
    }

    public void setFeb(int feb) {
        this.feb = feb;
    }

    public int getMar() {
        return mar;
    }

    public void setMar(int mar) {
        this.mar = mar;
    }

    public int getApr() {
        return apr;
    }

    public void setApr(int apr) {
        this.apr = apr;
    }

    public int getMay() {
        return may;
    }

    public void setMay(int may) {
        this.may = may;
    }

    public int getJun() {
        return jun;
    }

    public void setJun(int jun) {
        this.jun = jun;
    }

    public int getJul() {
        return jul;
    }

    public void setJul(int jul) {
        this.jul = jul;
    }

    public int getAug() {
        return aug;
    }

    public void setAug(int aug) {
        this.aug = aug;
    }

    public int getSep() {
        return sep;
    }

    public void setSep(int sep) {
        this.sep = sep;
    }

    public int getOct() {
        return oct;
    }

    public void setOct(int oct) {
        this.oct = oct;
    }

    public int getNov() {
        return nov;
    }

    public void setNov(int nov) {
        this.nov = nov;
    }

    public int getDec() {
        return dec;
    }

    public void setDec(int dec) {
        this.dec = dec;
    }

    public Revenue() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Revenue revenue = (Revenue) o;
        return jan == revenue.jan && feb == revenue.feb && mar == revenue.mar && apr == revenue.apr && may == revenue.may && jun == revenue.jun && jul == revenue.jul && aug == revenue.aug && sep == revenue.sep && oct == revenue.oct && nov == revenue.nov && dec == revenue.dec;
    }

    @Override
    public int hashCode() {
        return Objects.hash(jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec);
    }
}
