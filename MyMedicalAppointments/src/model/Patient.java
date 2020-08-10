package model;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {
    //Atributos
    private String birthday;
    private double weight;
    private double height;
    private String blood;

    private ArrayList<AppointmentDoctor> appointmentDoctors = new ArrayList<>();
    private ArrayList<AppointmentNurse> appointmentNurses = new ArrayList<>();

    public ArrayList<AppointmentDoctor> getAppointmentDoctors() {
        return appointmentDoctors;
    }

    public void addAppointmentDoctors(Doctor doctor, Date date, String time) {
        AppointmentDoctor appointmentDoctor = new AppointmentDoctor(this, doctor);
        appointmentDoctor.schedule(date, time);
        appointmentDoctors.add(appointmentDoctor);
    }

    public ArrayList<AppointmentNurse> getAppointmentNurses() {
        return appointmentNurses;
    }

    public void setAppointmentNurses(ArrayList<AppointmentNurse> appointmentNurses) {
        this.appointmentNurses = appointmentNurses;
    }

    public Patient(String name, String email) {
        super(name, email);
    }

    //Set se usa para asignar el valor a una variable privada
    public void setWeight(double weight) {
        this.weight = weight;
    }

    //Get devuelve un valor, en este caso el valor asignado en Set
    // mas un formato que representara la unidad correcta del valor
    //asigando en Set, el valor de retorno se asigna como String para
    // poder representar la unidad.
    public String getWeight() {
        return this.weight + " Kg.";
    }

    public String getHeight() {
        return this.height + " Mts.";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAge: " + birthday + "\nWeight: " +
                getWeight() + "\nHeight: " + getHeight() + "\nBlood: " +
                blood;
    }

    @Override
    public void showDataUser() {
        System.out.println("Paciente: " + super.getName());
        System.out.println("Historial Medico completo desde el nacimiento");
    }

    @Override
    public void addAvailableAppointment(Date date) {

    }
}
