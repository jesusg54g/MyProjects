package model;

import java.util.Date;

public class Nurse extends User {

    private String speciality;

    public Nurse(String name, String email) {
        super(name, email);
        System.out.println("Nurse: " + super.getName());
    }

    @Override
    public void showDataUser() {
        System.out.println("Empleado del Hospital: Cruz Verde");
        System.out.println("Departamentos: Nutriologia, Pediatria");
    }

    @Override
    public void addAvailableAppointment(Date date) {

    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
