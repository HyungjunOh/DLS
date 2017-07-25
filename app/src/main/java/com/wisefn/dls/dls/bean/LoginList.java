package com.wisefn.dls.dls.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hyungjun on 2017-07-17.
 */

public class LoginList implements Serializable {

    @SerializedName("data0")
    @Expose
    private List<Data0> data0 = null;
    @SerializedName("data1")
    @Expose
    private List<Data1> data1 = null;
    private final static long serialVersionUID = 6505614724334824344L;

    public List<Data0> getData0() {
        return data0;
    }

    public void setData0(List<Data0> data0) {
        this.data0 = data0;
    }

    public List<Data1> getData1() {
        return data1;
    }

    public void setData1(List<Data1> data1) {
        this.data1 = data1;
    }

    public class Data0 implements Serializable
    {

        @SerializedName("Login_YN")
        @Expose
        private String loginYN;
        @SerializedName("Login_Desc")
        @Expose
        private String loginDesc;
        private final static long serialVersionUID = 5990722104200432052L;

        public String getLoginYN() {
            return loginYN;
        }

        public void setLoginYN(String loginYN) {
            this.loginYN = loginYN;
        }

        public String getLoginDesc() {
            return loginDesc;
        }

        public void setLoginDesc(String loginDesc) {
            this.loginDesc = loginDesc;
        }

    }

    public class Data1 implements Serializable
    {

        @SerializedName("UserName")
        @Expose
        private String userName;
        @SerializedName("UserEMail")
        @Expose
        private String userEMail;
        @SerializedName("DeptName")
        @Expose
        private String deptName;
        @SerializedName("PositionName")
        @Expose
        private String positionName;
        @SerializedName("GW_MemberKey")
        @Expose
        private String gWMemberKey;
        private final static long serialVersionUID = -8241925557654567537L;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserEMail() {
            return userEMail;
        }

        public void setUserEMail(String userEMail) {
            this.userEMail = userEMail;
        }

        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public String getPositionName() {
            return positionName;
        }

        public void setPositionName(String positionName) {
            this.positionName = positionName;
        }

        public String getGWMemberKey() {
            return gWMemberKey;
        }

        public void setGWMemberKey(String gWMemberKey) {
            this.gWMemberKey = gWMemberKey;
        }

    }

}


