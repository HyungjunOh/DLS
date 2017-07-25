package com.wisefn.dls.dls.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by hyungjun on 2017-07-24.
 */

public class InsertMkt implements Serializable
{

    @SerializedName("returnCode")
    @Expose
    private Integer returnCode;
    @SerializedName("returnMessage")
    @Expose
    private String returnMessage;
    @SerializedName("data")
    @Expose
    private InsertCheck insertCheck;
    private final static long serialVersionUID = 6230050740404192916L;

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

    public InsertCheck getData() {
        return insertCheck;
    }

    public void setData(InsertCheck data) {
        this.insertCheck = data;
    }

    public class InsertCheck implements Serializable
    {

        @SerializedName("RESULT")
        @Expose
        private Integer rESULT;
        private final static long serialVersionUID = 8779093904320659519L;

        public Integer getRESULT() {
            return rESULT;
        }

        public void setRESULT(Integer rESULT) {
            this.rESULT = rESULT;
        }

    }
}