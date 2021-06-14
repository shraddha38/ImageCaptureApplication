package com.ImageCaptureApplications.Service;

public class ApiExtractData {

	private String name;

    private String pancard;

    private String dob;

    private String fatherName;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setPancard(String pancard){
        this.pancard = pancard;
    }
    public String getPancard(){
        return this.pancard;
    }
    public void setDob(String dob){
        this.dob = dob;
    }
    public String getDob(){
        return this.dob;
    }
    public void setFatherName(String fatherName){
        this.fatherName = fatherName;
    }
    public String getFatherName(){
        return this.fatherName;

    
    }
    
    @Override
	public String toString() {
		return " [name=" +name + ", pancard=" + pancard + ", dob=" + dob + ", fatherName=" +fatherName+ "]";

}
}