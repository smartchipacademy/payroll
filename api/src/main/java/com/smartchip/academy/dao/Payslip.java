package com.smartchip.academy.dao;


public class Payslip {

    // Fields
    private String monthOfPay;
    private String yearOfPay;
    private String employeeName;
    private String employeeId;
    private String designation;
    private String department;
    private String dateOfJoining;
    private String grossSalary;
    private String totalWorkingDays;
    private String LOPDays;
    private String paidLeaves;
    private String bankName;
    private String bankAccountNo;
    private String basicSalary;
    private String HRA;
    private String LTA;
    private String medicalAllowance;
    private String specialAllowance;
    private String providentFund;
    private String professionalTax;
    private String netPay;
    private String amountInWords;

    // Empty Constructor
    public Payslip() {
    }

    // Parameterized Constructor
    public Payslip(String monthOfPay, String yearOfPay, String employeeName, String employeeId,
                      String designation, String department, String dateOfJoining, String grossSalary,
                      String totalWorkingDays, String LOPDays, String paidLeaves, String bankName,
                      String bankAccountNo, String basicSalary, String HRA, String LTA,
                      String medicalAllowance, String specialAllowance, String providentFund,
                      String professionalTax, String netPay, String amountInWords) {
        this.monthOfPay = monthOfPay;
        this.yearOfPay = yearOfPay;
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.designation = designation;
        this.department = department;
        this.dateOfJoining = dateOfJoining;
        this.grossSalary = grossSalary;
        this.totalWorkingDays = totalWorkingDays;
        this.LOPDays = LOPDays;
        this.paidLeaves = paidLeaves;
        this.bankName = bankName;
        this.bankAccountNo = bankAccountNo;
        this.basicSalary = basicSalary;
        this.HRA = HRA;
        this.LTA = LTA;
        this.medicalAllowance = medicalAllowance;
        this.specialAllowance = specialAllowance;
        this.providentFund = providentFund;
        this.professionalTax = professionalTax;
        this.netPay = netPay;
        this.amountInWords = amountInWords;
    }

    // Getters and Setters
    public String getMonthOfPay() {
        return monthOfPay;
    }

    public void setMonthOfPay(String monthOfPay) {
        this.monthOfPay = monthOfPay;
    }

    public String getYearOfPay() {
        return yearOfPay;
    }

    public void setYearOfPay(String yearOfPay) {
        this.yearOfPay = yearOfPay;
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





