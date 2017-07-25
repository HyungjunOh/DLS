package com.wisefn.dls.dls.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by hyungjun on 2017-07-21.
 */

public class CustomerSrchList implements Serializable
{

    @SerializedName("returnCode")
    @Expose
    private Integer returnCode;
    @SerializedName("returnMessage")
    @Expose
    private String returnMessage;
    @SerializedName("data")
    @Expose
    private ArrayList<CustomerSrchListData> data = null;
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

    public ArrayList<CustomerSrchListData> getData() {
        return data;
    }

    public void setData(ArrayList<CustomerSrchListData> data) {
        this.data = data;
    }

    public class CustomerSrchListData implements Serializable
    {

        @SerializedName("WAT_SEARCH")
        @Expose
        private String wATSEARCH;
        @SerializedName("WAT_TEXT")
        @Expose
        private String wATTEXT;
//        @SerializedName("WAT_LIST")
//        @Expose
//        private String wATLIST;
        @SerializedName("Cus_Cmp_NM")
        @Expose
        private String cusCmpNM;
        @SerializedName("Cus_Mem_ID")
        @Expose
        private Integer cusMemID;
        private final static long serialVersionUID = 4124631572782715223L;

        public String getWATSEARCH() {
            return wATSEARCH;
        }

        public void setWATSEARCH(String wATSEARCH) {
            this.wATSEARCH = wATSEARCH;
        }

        public String getWATTEXT() {
            return wATTEXT;
        }

        public void setWATTEXT(String wATTEXT) {
            this.wATTEXT = wATTEXT;
        }

//        public String getWATLIST() {
//            return wATLIST;
//        }
//
//        public void setWATLIST(String wATLIST) {
//            this.wATLIST = wATLIST;
//        }

        public String getCusCmpNM() {
            return cusCmpNM;
        }

        public void setCusCmpNM(String cusCmpNM) {
            this.cusCmpNM = cusCmpNM;
        }

        public Integer getCusMemID() {
            return cusMemID;
        }

        public void setCusMemID(Integer cusMemID) {
            this.cusMemID = cusMemID;
        }

    }
}