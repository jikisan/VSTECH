package com.jikisan.vstech.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PatientModel {

    private String name;
    private String caseNumber;
    private String age;
    private String diagnosis;
    private String photo;
    private DateListModel date;

    public PatientModel(String name, String caseNumber, String age, String diagnosis, String photo) {
        this.name = name;
        this.caseNumber = caseNumber;
        this.age = age;
        this.diagnosis = diagnosis;
        this.photo = photo;
        this.date = new DateListModel(generateDates());
    }

    public String getName() {
        return name;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public String getAge() {
        return age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public DateListModel getData() {
        return date;
    }

    private String[] generateDates() {
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MMM d");
        String[] days = new String[5];
        LocalDate currentDate = LocalDate.now();

        for (int i = 0; i < 5; i++) {
            days[i] = currentDate.plusDays(i).format(FORMATTER).toString();
            System.out.println(days[i]);
        }

        return days;
    }

}
