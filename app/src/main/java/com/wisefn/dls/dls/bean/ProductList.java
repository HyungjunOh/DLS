package com.wisefn.dls.dls.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by hyungjun on 2017-07-21.
 */

public class ProductList implements Serializable
{

    @SerializedName("returnCode")
    @Expose
    private Integer returnCode;
    @SerializedName("returnMessage")
    @Expose
    private String returnMessage;
    @SerializedName("data")
    @Expose
    private ArrayList<ProductListItem> data = null;
    private final static long serialVersionUID = 1711237769764604945L;

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public ArrayList<ProductListItem> getData() {
        return data;
    }

    public void setData(ArrayList<ProductListItem> data) {
        this.data = data;
    }

    public class ProductListItem implements Serializable
    {

        @SerializedName("Product_NM")
        @Expose
        private String productNM;
        @SerializedName("Product_CD")
        @Expose
        private String productCD;
        private final static long serialVersionUID = -9213588628189847926L;

        public String getProductNM() {
            return productNM;
        }

        public void setProductNM(String productNM) {
            this.productNM = productNM;
        }

        public String getProductCD() {
            return productCD;
        }

        public void setProductCD(String productCD) {
            this.productCD = productCD;
        }

    }

}