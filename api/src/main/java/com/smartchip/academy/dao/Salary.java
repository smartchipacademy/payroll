package com.smartchip.academy.dao;

import  jakarta.persistence.*;


@Entity
@Table(name = "salary")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column (name = "monthOfPay")
    private String monthOfPay;

    @Column (name = "YearOfPay")
    private String YearOfPay;

    @Column (name = "employeeName")
    private String employeeName;

    @Column (name = "employeeId")
    private String employeeId;

    @Column (name = "designation")
    private String designation ;

    @Column (name = "department")
    private String department;

    @Column (name = "dateOfJoining")
    private String dateOfJoining;

    @Column (name = "grossSalary")
    private String grossSalary;

    @Column (name = "totalWorkingDays")
    private String totalWorkingDays;

    @Column (name = "LOPDays")
    private String LOPDays;

    @Column (name = "paidLeaves")
    private String paidLeaves;

    @Column (name = "bankName")
    private String bankName;

    @Column (name = " bankAccountNo")
    private String  bankAccountNo;

    @Column (name = "basicSalary")
    private String basicSalary;

    @Column (name = "HRA")
    private String HRA;

    @Column (name = "LTA")
    private String LTA;

    @Column (name = "medicalAllowance")
    private String medicalAllowance;

    @Column (name = "specialAllowance")
    private String specialAllowance;

    @Column (name = "providentFund")
    private String providentFund;

    @Column (name = "professionalTax")
    private String professionalTax;

    @Column (name = "netPay")
    private String netPay;


    @Column (name = "amountInWords")
    private String amountInWords;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonthOfPay() {
        return monthOfPay;
    }

    public void setMonthOfPay(String monthOfPay) {
        this.monthOfPay = monthOfPay;
    }

    public String getYearOfPay() {
        return YearOfPay;
    }

    public void setYearOfPay(String yearOfPay) {
        YearOfPay = yearOfPay;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(String grossSalary) {
        this.grossSalary = grossSalary;
    }

    public String getTotalWorkingDays() {
        return totalWorkingDays;
    }

    public void setTotalWorkingDays(String totalWorkingDays) {
        this.totalWorkingDays = totalWorkingDays;
    }

    public String getLOPDays() {
        return LOPDays;
    }

    public void setLOPDays(String LOPDays) {
        this.LOPDays = LOPDays;
    }

    public String getPaidLeaves() {
        return paidLeaves;
    }

    public void setPaidLeaves(String paidLeaves) {
        this.paidLeaves = paidLeaves;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(String basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getHRA() {
        return HRA;
    }

    public void setHRA(String HRA) {
        this.HRA = HRA;
    }

    public String getLTA() {
        return LTA;
    }

    public void setLTA(String LTA) {
        this.LTA = LTA;
    }

    public String getMedicalAllowance() {
        return medicalAllowance;
    }

    public void setMedicalAllowance(String medicalAllowance) {
        this.medicalAllowance = medicalAllowance;
    }

    public String getSpecialAllowance() {
        return specialAllowance;
    }

    public void setSpecialAllowance(String specialAllowance) {
        this.specialAllowance = specialAllowance;
    }

    public String getProvidentFund() {
        return providentFund;
    }

    public void setProvidentFund(String providentFund) {
        this.providentFund = providentFund;
    }

    public String getProfessionalTax() {
        return professionalTax;
    }

    public void setProfessionalTax(String professionalTax) {
        this.professionalTax = professionalTax;
    }

    public String getNetPay() {
        return netPay;
    }

    public void setNetPay(String netPay) {
        this.netPay = netPay;
    }

    public String getAmountInWords() {
        return amountInWords;
    }

    public void setAmountInWords(String amountInWords) {
        this.amountInWords = amountInWords;
    }
}
