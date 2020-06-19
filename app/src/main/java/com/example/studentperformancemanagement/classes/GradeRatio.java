package com.example.studentperformancemanagement.classes;

import java.io.Serializable;

public class GradeRatio implements Serializable {
    private double usual,exp,mid,fina;

    public GradeRatio(double usual, double exp, double mid, double fina) {
        this.usual = usual;
        this.exp = exp;
        this.mid = mid;
        this.fina = fina;
    }

    public double getUsual() {
        return usual;
    }

    public double getExp() {
        return exp;
    }

    public double getMid() {
        return mid;
    }

    public double getFina() {
        return fina;
    }
}
