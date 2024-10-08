package com.smartchip.academy.controller;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.smartchip.academy.dao.Payslip;
import com.smartchip.academy.dao.Salary;
import com.smartchip.academy.service.SalaryService;
import com.smartchip.academy.utils.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.itextpdf.text.*;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/salaries")

public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @Value("${spring.application.name}")
    private String appName;
    private static boolean isRequiredDirectoriesCreated = false;


    @GetMapping
    public List <Salary>getAllSalaries(){return  salaryService.getAllSalaries();}


    @GetMapping("/{id}")

    public Salary getSalartById(@PathVariable Long id){ return salaryService.getSalaryById(id);}


    @PostMapping("/createsalary")
    public Salary createSalary(@RequestBody Salary salary){
        return salaryService.saveOrUpdateSalary(salary);

    }


    @PutMapping("/{id}")
    public Salary updateSalary(@PathVariable Long id, @RequestBody Salary salary) {

        Salary existingSalary = salaryService.getSalaryById(id);
        if (existingSalary != null) {
            existingSalary.setMonthOfPay(salary.getMonthOfPay());
            existingSalary.setYearOfPay(salary.getYearOfPay());
            existingSalary.setEmployeeName(salary.getEmployeeName());
            existingSalary.setEmployeeId(salary.getEmployeeId());
            existingSalary.setDesignation(salary.getDesignation());
            existingSalary.setDepartment(salary.getDepartment());
            existingSalary.setDateOfJoining(salary.getDateOfJoining());
            existingSalary.setGrossSalary(salary.getGrossSalary());
            existingSalary.setTotalWorkingDays(salary.getTotalWorkingDays());
            existingSalary.setLOPDays(salary.getLOPDays());
            existingSalary.setPaidLeaves(salary.getPaidLeaves());
            existingSalary.setBankName(salary.getBankName());
            existingSalary.setBankAccountNo(salary.getBankAccountNo());
            existingSalary.setBasicSalary(salary.getBasicSalary());
            existingSalary.setHRA(salary.getHRA());
            existingSalary.setLTA(salary.getLTA());
            existingSalary.setMedicalAllowance(salary.getMedicalAllowance());
            existingSalary.setSpecialAllowance(salary.getSpecialAllowance());
            existingSalary.setProvidentFund(salary.getProvidentFund());
            existingSalary.setProfessionalTax(salary.getProfessionalTax());
            existingSalary.setNetPay(salary.getNetPay());
            existingSalary.setAmountInWords(salary.getAmountInWords());
            return salaryService.saveOrUpdateSalary(existingSalary);
        } else {

            return null;

        }
    }
    @DeleteMapping("/{id}")

    public void deleteSalary(@PathVariable Long id) { salaryService.deleteSalary(id);}

    @GetMapping("/sendemail")
    public  void sendMail() {
        File requiredDirectory = new File("./Generated_Payslips");
        if (requiredDirectory.exists()) {
            isRequiredDirectoriesCreated = true;
        } else {
            if (requiredDirectory.mkdirs()) {
                isRequiredDirectoriesCreated = true;
            } else {
                System.out.println("Cannot create Directory Generated_Payslips");
            }
        }

        if (isRequiredDirectoriesCreated) {
            try {
                //call repo
                List<Salary> salary = salaryService.getAllSalaries();
                for (Salary value : salary) {
                    Payslip slipDto = new Payslip();
                    slipDto.setMonthOfPay(value.getMonthOfPay());
                    slipDto.setYearOfPay(value.getYearOfPay());
                    slipDto.setEmployeeName(value.getEmployeeName());
                    slipDto.setEmployeeId(value.getEmployeeId());
                    slipDto.setDesignation(value.getDesignation());
                    slipDto.setDepartment(value.getDepartment());
                    slipDto.setDateOfJoining(value.getDateOfJoining());
                    slipDto.setGrossSalary(value.getGrossSalary());
                    slipDto.setTotalWorkingDays(value.getTotalWorkingDays());
                    slipDto.setLOPDays(value.getLOPDays());
                    slipDto.setPaidLeaves(value.getPaidLeaves());
                    slipDto.setBankName(value.getBankName());
                    slipDto.setBankAccountNo(value.getBankAccountNo());
                    slipDto.setBasicSalary(value.getBasicSalary());
                    slipDto.setHRA(value.getHRA());
                    slipDto.setLTA(value.getLTA());
                    slipDto.setMedicalAllowance(value.getMedicalAllowance());
                    slipDto.setSpecialAllowance(value.getSpecialAllowance());
                    slipDto.setProvidentFund(value.getProvidentFund());
                    slipDto.setProfessionalTax(value.getProfessionalTax());
                    slipDto.setNetPay(value.getNetPay());
                    slipDto.setAmountInWords(value.getAmountInWords());

                    if (generatePaySlip(slipDto)) {
                        System.out.println("Payslip for " + slipDto.getEmployeeName() + " Generated\n\n");

                        EmailSender sender = new EmailSender();
//							sender.sendEmail("smtp.gmail.com", "587", "nareshanother99@gmail.com", "mqec mpha qiuf ptfh",
//									"nareshcontact99@gmail.com", "Sample Message through SMTP",
//									"This is mail triggered using smtp server using java", new File("./Generated_Payslips/" + slipDto.getEmployeeName().replace(" ", "_") + "_" + slipDto.getEmployeeId() + "_" + slipDto.getMonthOfPay() + "_" + slipDto.getYearOfPay() + ".pdf"));
                        sender.sendEmail("smtp.gmail.com", "587", "contact@samsung.in", "qsqh osek ikro pope",
                                "ramisettysandeep003@gmail.com", "Sample Message through SMTP",
                                "This is mail triggered using smtp server using java", new File("./Generated_Payslips/" + slipDto.getEmployeeName().replace(" ", "_") + "_" + slipDto.getEmployeeId() + "_" + slipDto.getMonthOfPay() + "_" + slipDto.getYearOfPay() + ".pdf"));

                        System.out.println("Email to " + slipDto.getEmployeeName() + " sent");
                    } else {
                        System.out.println("Exception in generating payslip of " + value );
                    }
                }
            } catch(Exception ex){
                // System.out.println("Error Message : " + ex.getMessgae());
                ex.printStackTrace();
            }
        }

    }

    public static boolean generatePaySlip(Payslip dto) {
        try {
            // Create a new document
            com.itextpdf.text.Document document = new Document();

            // Create a new PdfWriter instance
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("./Generated_Payslips/" + dto.getEmployeeName().replace(" ", "_") + "_" + dto.getEmployeeId() + "_" + dto.getMonthOfPay() + "_" + dto.getYearOfPay() + ".pdf"));

            // Open the document
            document.open();

            // Set the font
            Font font = new Font(Font.FontFamily.HELVETICA, 12);

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);

            PdfPCell row1cell1 = new PdfPCell(new Paragraph("Samsung R&D Private Limited", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD)));
            row1cell1.setColspan(4); // Merging 2 columns
            row1cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(row1cell1);

            PdfPCell row2cell1 = new PdfPCell();
            row2cell1.setFixedHeight(15f);
            table.addCell(row2cell1);
            PdfPCell address = new PdfPCell(new Paragraph("PHOENIX BULIDING ,\nBAGMANE CONSTELLATION BUSINESS PARK\n2870,Outer Ring Rd,Ferns city,Doddanekkundi\nBenguluru"));
            address.setHorizontalAlignment(Element.ALIGN_CENTER);
            address.setVerticalAlignment(Element.ALIGN_CENTER);
            address.setColspan(2);
            address.setRowspan(3);
            table.addCell(address);
            PdfPCell row2cell4 = new PdfPCell();
            row2cell4.setFixedHeight(15f);
            table.addCell(row2cell4);

            PdfPCell row3cell1 = new PdfPCell();
            row3cell1.setFixedHeight(15f);
            table.addCell(row3cell1);
            PdfPCell row3cell4 = new PdfPCell();
            row3cell4.setFixedHeight(15f);
            table.addCell(row3cell4);

            PdfPCell row4cell1 = new PdfPCell();
            row4cell1.setFixedHeight(15f);
            table.addCell(row4cell1);
            PdfPCell row4cell4 = new PdfPCell();
            row4cell4.setFixedHeight(15f);
            table.addCell(row4cell4);

            PdfPCell row5cell1 = new PdfPCell(new Phrase("Payslip for the month of " + dto.getMonthOfPay() + " " + dto.getYearOfPay(), new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
            row5cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            row5cell1.setColspan(4);
            table.addCell(row5cell1);

            PdfPCell row6cell1 = new PdfPCell();
            row6cell1.setFixedHeight(15f);
            table.addCell(row6cell1);
            PdfPCell row6cell2 = new PdfPCell();
            table.addCell(row6cell2);
            PdfPCell row6cell3 = new PdfPCell();
            table.addCell(row6cell3);
            PdfPCell row6cell4 = new PdfPCell();
            table.addCell(row6cell4);

            PdfPCell row7cell1 = new PdfPCell(new Phrase("Employee Name", new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD)));
            table.addCell(row7cell1);
            PdfPCell row7cell2 = new PdfPCell(new Phrase(dto.getEmployeeName()));
            table.addCell(row7cell2);
            PdfPCell row7cell3 = new PdfPCell(new Phrase("Total Working Days", new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD)));
            table.addCell(row7cell3);
            PdfPCell row7cell4 = new PdfPCell(new Phrase(dto.getTotalWorkingDays()));
            table.addCell(row7cell4);

            PdfPCell row8cell1 = new PdfPCell(new Phrase("Employee ID", new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD)));
            table.addCell(row8cell1);
            PdfPCell row8cell2 = new PdfPCell(new Phrase(dto.getEmployeeId()));
            table.addCell(row8cell2);
            PdfPCell row8cell3 = new PdfPCell(new Phrase("LOP Days", new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD)));
            table.addCell(row8cell3);
            PdfPCell row8cell4 = new PdfPCell(new Phrase(dto.getLOPDays()));
            table.addCell(row8cell4);

            PdfPCell row9cell1 = new PdfPCell(new Phrase("Designation", new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD)));
            table.addCell(row9cell1);
            PdfPCell row9cell2 = new PdfPCell(new Phrase(dto.getDesignation()));
            table.addCell(row9cell2);
            PdfPCell row9cell3 = new PdfPCell(new Phrase("Paid Days", new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD)));
            table.addCell(row9cell3);
            PdfPCell row9cell4 = new PdfPCell(new Phrase(dto.getPaidLeaves()));
            table.addCell(row9cell4);

            PdfPCell row10cell1 = new PdfPCell(new Phrase("Department", new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD)));
            table.addCell(row10cell1);
            PdfPCell row10cell2 = new PdfPCell(new Phrase(dto.getDepartment()));
            table.addCell(row10cell2);
            PdfPCell row10cell3 = new PdfPCell(new Phrase("Bank Name", new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD)));
            table.addCell(row10cell3);
            PdfPCell row10cell4 = new PdfPCell(new Phrase(dto.getBankName()));
            table.addCell(row10cell4);

            PdfPCell row11cell1 = new PdfPCell(new Phrase("Date of Joining", new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD)));
            table.addCell(row11cell1);
            PdfPCell row11cell2 = new PdfPCell(new Phrase(dto.getDateOfJoining()));
            table.addCell(row11cell2);
            PdfPCell row11cell3 = new PdfPCell(new Phrase("Bank A/C No", new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD)));
            table.addCell(row11cell3);
            PdfPCell row11cell4 = new PdfPCell(new Phrase(dto.getBankAccountNo().replace("`", "")));
            table.addCell(row11cell4);

            PdfPCell row12cell1 = new PdfPCell(new Phrase("Gross Salary", new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD)));
            table.addCell(row12cell1);
            PdfPCell row12cell2 = new PdfPCell(new Phrase(dto.getGrossSalary()));
            table.addCell(row12cell2);
            PdfPCell row12cell3 = new PdfPCell();
            table.addCell(row12cell3);
            PdfPCell row12cell4 = new PdfPCell();
            table.addCell(row12cell4);

            PdfPCell row13cell1 = new PdfPCell();
            row13cell1.setFixedHeight(15f);
            row13cell1.setColspan(4);
            table.addCell(row13cell1);

            PdfPCell row14cell1 = new PdfPCell(new Phrase("Earnings", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
            row14cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            row14cell1.setColspan(4);
            table.addCell(row14cell1);

            PdfPCell row15cell1 = new PdfPCell(new Phrase("Basic Salary", new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD)));
            row15cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            row15cell1.setColspan(2);
            table.addCell(row15cell1);
            PdfPCell row15cell2 = new PdfPCell(new Phrase(dto.getBasicSalary()));
            row15cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            row15cell2.setColspan(2);
            table.addCell(row15cell2);

            PdfPCell row16cell1 = new PdfPCell(new Phrase("HRA", new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD)));
            row16cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            row16cell1.setColspan(2);
            table.addCell(row16cell1);
            PdfPCell row16cell2 = new PdfPCell(new Phrase(dto.getHRA()));
            row16cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            row16cell2.setColspan(2);
            table.addCell(row16cell2);

            PdfPCell row17cell1 = new PdfPCell(new Phrase("LTA", new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD)));
            row17cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            row17cell1.setColspan(2);
            table.addCell(row17cell1);
            PdfPCell row17cell2 = new PdfPCell(new Phrase(dto.getLTA()));
            row17cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            row17cell2.setColspan(2);
            table.addCell(row17cell2);

            PdfPCell row18cell1 = new PdfPCell(new Phrase("Medical Allowances", new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD)));
            row18cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            row18cell1.setColspan(2);
            table.addCell(row18cell1);
            PdfPCell row18cell2 = new PdfPCell(new Phrase(dto.getMedicalAllowance()));
            row18cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            row18cell2.setColspan(2);
            table.addCell(row18cell2);

            PdfPCell row19cell1 = new PdfPCell(new Phrase("Special Allowances", new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD)));
            row19cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            row19cell1.setColspan(2);
            table.addCell(row19cell1);
            PdfPCell row19cell2 = new PdfPCell(new Phrase(dto.getSpecialAllowance()));
            row19cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            row19cell2.setColspan(2);
            table.addCell(row19cell2);

            PdfPCell row20cell1 = new PdfPCell(new Phrase("Gross Salary", new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD)));
            row20cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            row20cell1.setColspan(2);
            table.addCell(row20cell1);
            PdfPCell row20cell2 = new PdfPCell(new Phrase(dto.getGrossSalary()));
            row20cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            row20cell2.setColspan(2);
            table.addCell(row20cell2);

            PdfPCell row21cell1 = new PdfPCell(new Phrase("Provident Fund", new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD)));
            row21cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            row21cell1.setColspan(2);
            table.addCell(row21cell1);
            PdfPCell row21cell2 = new PdfPCell(new Phrase(dto.getProvidentFund()));
            row21cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            row21cell2.setColspan(2);
            table.addCell(row21cell2);

            PdfPCell row22cell1 = new PdfPCell(new Phrase("Professional Tax", new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD)));
            row22cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            row22cell1.setColspan(2);
            table.addCell(row22cell1);
            PdfPCell row22cell2 = new PdfPCell(new Phrase(dto.getProfessionalTax()));
            row22cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            row22cell2.setColspan(2);
            table.addCell(row22cell2);

            PdfPCell row23cell1 = new PdfPCell(new Phrase("NET PAY", new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD)));
            row23cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            row23cell1.setColspan(2);
            table.addCell(row23cell1);
            PdfPCell row23cell2 = new PdfPCell(new Phrase(dto.getNetPay()));
            row23cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            row23cell2.setColspan(2);
            table.addCell(row23cell2);

            PdfPCell row24cell1 = new PdfPCell(new Phrase("Amount In Words", new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD)));
            row24cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            row24cell1.setColspan(2);
            table.addCell(row24cell1);
            PdfPCell row24cell2 = new PdfPCell(new Phrase(dto.getAmountInWords()));
            row24cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            row24cell2.setColspan(2);
            table.addCell(row24cell2);

            // Add the table to the document
            document.add(table);

            // Add a blank line
            document.add(new Paragraph(" "));

            // Add the note
            Paragraph note = new Paragraph("Note: This is a computer generated payslip and does not require authentication.", new Font(Font.FontFamily.HELVETICA, 10));
            note.setAlignment(Element.ALIGN_CENTER);
            document.add(note);

            // Close the document
            document.close();

            // System.out.println("Payslip generated successfully.");

            return true;

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            return false;
        }
        // return false;
    }
}






