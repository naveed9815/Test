package com.test_1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("NXT")
    @Expose
    private Double nXT;
    @SerializedName("ETC")
    @Expose
    private Double eTC;
    @SerializedName("XMR")
    @Expose
    private Double xMR;
    @SerializedName("DOGE")
    @Expose
    private Double dOGE;

    public Double getNXT() {
        return nXT;
    }

    public void setNXT(Double nXT) {
        this.nXT = nXT;
    }

    public Double getETC() {
        return eTC;
    }

    public void setETC(Double eTC) {
        this.eTC = eTC;
    }

    public Double getXMR() {
        return xMR;
    }

    public void setXMR(Double xMR) {
        this.xMR = xMR;
    }

    public Double getDOGE() {
        return dOGE;
    }

    public void setDOGE(Double dOGE) {
        this.dOGE = dOGE;
    }

}