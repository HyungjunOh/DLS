package com.wisefn.dls.dls.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by hyungjun on 2017-07-14.
 */

public class MktDetail implements Serializable{

    @SerializedName("returnCode")
    @Expose
    private Integer returnCode;
    @SerializedName("returnMessage")
    @Expose
    private String returnMessage;
    @SerializedName("data")
    @Expose
    private MktDetailData mktDetailData = null;

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

    public MktDetailData getMktDetailData() {
        return mktDetailData;
    }

    public void setMktDetailData(MktDetailData mktDetailData) {
        this.mktDetailData = mktDetailData;
    }

    public class MktDetailData implements Serializable{

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
        @SerializedName("Mkt_Write_NM")
        @Expose
        private String mktWriteNM;
        @SerializedName("Mkt_Write_Detail")
        @Expose
        private String mktWriteDetail;

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

        public String getMktWriteNM() {
            return mktWriteNM;
        }

        public void setMktWriteNM(String mktWriteNM) {
            this.mktWriteNM = mktWriteNM;
        }

        public String getMktWriteDetail() {
            return mktWriteDetail;
        }

        public void setMktWriteDetail(String mktWriteDetail) {
            this.mktWriteDetail = mktWriteDetail;
        }

    }

}