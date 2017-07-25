package com.wisefn.dls.dls.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by hyungjun on 2017-07-14.
 */


public class CustomerList implements Serializable{

    @SerializedName("returnCode")
    @Expose
    private Integer returnCode;
    @SerializedName("returnMessage")
    @Expose
    private String returnMessage;
    @SerializedName("data")
    @Expose
    private ArrayList<CustomerData> customerData = null;

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

    public ArrayList<CustomerData> getCustomerData() {
        return customerData;
    }

    public void setCustomerData(ArrayList<CustomerData> customerData) {
        this.customerData = customerData;
    }

    public class CustomerData implements Serializable{

        @SerializedName("Cus_Cmp_NM")
        @Expose
        private String cusCmpNM;
        @SerializedName("Cus_Mem_Dept")
        @Expose
        private String cusMemDept;
        @SerializedName("Cus_Mem_NM")
        @Expose
        private String cusMemNM;
        @SerializedName("Cus_Mem_PN_Office")
        @Expose
        private String cusMemPNOffice;
        @SerializedName("Cus_Mem_PN_Mobile")
        @Expose
        private String cusMemPNMobile;

        public String getCusCmpNM() {
            return cusCmpNM;
        }

        public void setCusCmpNM(String cusCmpNM) {
            this.cusCmpNM = cusCmpNM;
        }

        public String getCusMemDept() {
            return cusMemDept;
        }

        public void setCusMemDept(String cusMemDept) {
            this.cusMemDept = cusMemDept;
        }

        public String getCusMemNM() {
            return cusMemNM;
        }

        public void setCusMemNM(String cusMemNM) {
            this.cusMemNM = cusMemNM;
        }

        public String getCusMemPNOffice() {
            return cusMemPNOffice;
        }

        public void setCusMemPNOffice(String cusMemPNOffice) {
            this.cusMemPNOffice = cusMemPNOffice;
        }

        public String getCusMemPNMobile() {
            return cusMemPNMobile;
        }

        public void setCusMemPNMobile(String cusMemPNMobile) {
            this.cusMemPNMobile = cusMemPNMobile;
        }

    }

}