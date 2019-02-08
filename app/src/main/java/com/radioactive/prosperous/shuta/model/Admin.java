package com.radioactive.prosperous.shuta.model;

import android.util.Log;

public class Admin {
    String admin_id;
    String f_name;
    String m_name;
    String l_name;
    String admin_pwd;

    public Admin(){
    }

    public Admin(String admin_id, String admin_pwd){
        this.admin_id = admin_id;
        this.admin_pwd = admin_pwd;

        Log.d("android:", "admin obj created");
        Log.e("android:", "admin obj created");

    }

    public Admin(String admin_id, String f_name, String m_name, String l_name, String admin_pwd){
        this.admin_id = admin_id;
        this.f_name = f_name;
        this.m_name = m_name;
        this.l_name = l_name;
        this.admin_pwd = admin_pwd;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getAdmin_pwd() {
        return admin_pwd;
    }

    public void setAdmin_pwd(String admin_pwd) {
        this.admin_pwd = admin_pwd;
    }
}
