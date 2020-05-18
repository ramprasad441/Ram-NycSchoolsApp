package com.ramprasad.nycschools.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ramprasad on 4/23/20.
 */
public class Schools {

    @SerializedName("dbn")
    private String dbn;

    @SerializedName("school_name")
    private String schoolNameString;

    @SerializedName("total_students")
    private String totalStudents;

    @SerializedName("neighborhood")
    private String neighborhood;

    @SerializedName("location")
    private String location;

    @SerializedName("state_code")
    private String stateCode;

    @SerializedName("zip")
    private String zip;

    @SerializedName("interest1")
    private String interest1;

    @SerializedName("method1")
    private String method1;

    @SerializedName("nta")
    private String nta;

    @SerializedName("offer_rate1")
    private String offerRate1;

    @SerializedName("overview_paragraph")
    private String overviewParagraph;

    @SerializedName("website")
    private String website;

    @SerializedName("phone_number")
    private String phoneNumber;

    @SerializedName("borough")
    private String borough;

    @SerializedName("grades2018")
    private String grades2018;

    @SerializedName("extracurricular_activities")
    private String extracurricularActivities;

    @SerializedName("school_sports")
    private String schoolSports;

    @SerializedName("graduation_rate")
    private String graduationRate;

    @SerializedName("school_email")
    private String schoolEmail;


    public Schools(String dbn, String schoolNameString, String totalStudents, String neighborhood, String location, String stateCode, String zip, String interest1, String method1, String nta, String offerRate1, String overviewParagraph, String website, String phoneNumber, String borough, String grades2018, String extracurricularActivities, String schoolSports, String graduationRate) {
        this.dbn = dbn;
        this.schoolNameString = schoolNameString;
        this.totalStudents = totalStudents;
        this.neighborhood = neighborhood;
        this.location = location;
        this.stateCode = stateCode;
        this.zip = zip;
        this.interest1 = interest1;
        this.method1 = method1;
        this.nta = nta;
        this.offerRate1 = offerRate1;
        this.overviewParagraph = overviewParagraph;
        this.website = website;
        this.phoneNumber = phoneNumber;
        this.borough = borough;
        this.grades2018 = grades2018;
        this.extracurricularActivities = extracurricularActivities;
        this.schoolSports = schoolSports;
        this.graduationRate = graduationRate;
    }

    public String getDbn() {
        return dbn;
    }

    public void setDbn(String dbn) {
        this.dbn = dbn;
    }

    public String getSchoolNameString() {
        return schoolNameString;
    }

    public void setSchoolNameString(String schoolNameString) {
        this.schoolNameString = schoolNameString;
    }

    public String getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(String totalStudents) {
        this.totalStudents = totalStudents;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getInterest1() {
        return interest1;
    }

    public void setInterest1(String interest1) {
        this.interest1 = interest1;
    }

    public String getMethod1() {
        return method1;
    }

    public void setMethod1(String method1) {
        this.method1 = method1;
    }

    public String getNta() {
        return nta;
    }

    public void setNta(String nta) {
        this.nta = nta;
    }

    public String getOfferRate1() {
        return offerRate1;
    }

    public void setOfferRate1(String offerRate1) {
        this.offerRate1 = offerRate1;
    }

    public String getOverviewParagraph() {
        return overviewParagraph;
    }

    public void setOverviewParagraph(String overviewParagraph) {
        this.overviewParagraph = overviewParagraph;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public String getGrades2018() {
        return grades2018;
    }

    public void setGrades2018(String grades2018) {
        this.grades2018 = grades2018;
    }

    public String getExtracurricularActivities() {
        return extracurricularActivities;
    }

    public void setExtracurricularActivities(String extracurricularActivities) {
        this.extracurricularActivities = extracurricularActivities;
    }

    public String getSchoolSports() {
        return schoolSports;
    }

    public void setSchoolSports(String schoolSports) {
        this.schoolSports = schoolSports;
    }

    public String getGraduationRate() {
        return graduationRate;
    }

    public void setGraduationRate(String graduationRate) {
        this.graduationRate = graduationRate;
    }

    public String getSchoolEmail() {
        return schoolEmail;
    }

    public void setSchoolEmail(String schoolEmail) {
        this.schoolEmail = schoolEmail;
    }
}
