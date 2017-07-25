package com.wisefn.dls.dls.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by hyungjun on 2017-07-13.
 */

public class MktList implements Serializable{

    @SerializedName("returnCode")
    @Expose
    private Integer returnCode;
    @SerializedName("returnMessage")
    @Expose
    private String returnMessage;
    @SerializedName("data")
    @Expose
    private ArrayList<MktListData> mktListDatas = null;

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

    public ArrayList<MktListData> getData() {
        return mktListDatas;
    }

    public void setData(ArrayList<MktListData> mktListDatas) {
        this.mktListDatas = mktListDatas;
    }

    public class MktListData implements Serializable{

        @SerializedName("Mkt_Write_Title")
        @Expose
        private String mktWriteTitle;
        @SerializedName("Visit_TM")
        @Expose
        private String visitTM;
        @SerializedName("Cus_Cmp_NM")
        @Expose
        private String cusCmpNM;
        @SerializedName("Cus_Mem_NM")
        @Expose
        private String cusMemNM;
        @SerializedName("Product_NM")
        @Expose
        private String productNM;
        @SerializedName("Mkt_Write_ID")
        @Expose
        private int mktWriteID;
        @SerializedName("Visit_TM_Key")
        @Expose
        private String visitTMKey;

        public String getMktWriteTitle() {
            return mktWriteTitle;
        }

        public void setMktWriteTitle(String mktWriteTitle) {
            this.mktWriteTitle = mktWriteTitle;
        }

        public String getVisitTM() {
            return visitTM;
        }

        public void setVisitTM(String visitTM) {
            this.visitTM = visitTM;
        }

        public String getCusCmpNM() {
            return cusCmpNM;
        }

        public void setCusCmpNM(String cusCmpNM) {
            this.cusCmpNM = cusCmpNM;
        }

        public String getCusMemNM() {
            return cusMemNM;
        }

        public void setCusMemNM(String cusMemNM) {
            this.cusMemNM = cusMemNM;
        }

        public String getProductNM() {
            return productNM;
        }

        public void setProductNM(String productNM) {
            this.productNM = productNM;
        }

        public int getMktWriteID() {
            return mktWriteID;
        }

        public void setMktWriteID(Integer mktWriteID) {
            this.mktWriteID = mktWriteID;
        }

        public String getVisitTMKey() {
            return visitTMKey;
        }

        public void setVisitTMKey(String visitTMKey) {
            this.visitTMKey = visitTMKey;
        }

    }

}
