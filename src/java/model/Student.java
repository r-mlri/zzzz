/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Thomas Jefferson Qiu
 */
public class Student implements Serializable{
    protected String SN;
    protected String ENTRYTYPE;
    protected String TIMESTAMP;
    protected String EQUIPMENTS;
    
    public Student(String SN, String ENTRYTYPE, String TIMESTAMP){
        super();
        this.SN = SN;
        this.ENTRYTYPE = ENTRYTYPE;
        this.TIMESTAMP = TIMESTAMP;
    }
    
    public Student(String SN, String ENTRYTYPE, String TIMESTAMP, String EQUPMENTS){
        super();
        this.SN = SN;
        this.ENTRYTYPE = ENTRYTYPE;
        this.TIMESTAMP = TIMESTAMP;
        this.EQUIPMENTS = EQUPMENTS;
    }

    public String getSN(){
        return SN;
    }
    
    public void setSN(String SN){
        this.SN = SN;
    }    
    
    public String getENTRYTYPE(){
        return ENTRYTYPE;
    }
    
    public void setENTRYTYPE(String ENTRYTYPE){
        this.ENTRYTYPE = ENTRYTYPE;
    }
    
    public String getTIMESTAMP(){
        return TIMESTAMP;
    }
    
    public void setTIMESTAMP(String TIMESTAMP){
        this.TIMESTAMP = TIMESTAMP;
    }
    
        public String getEQUIPMENTS(){
        return EQUIPMENTS;
    }
    
    public void setEQUIPMENTS(String EQUIPMENTS){
        this.EQUIPMENTS = EQUIPMENTS;
    }
}
