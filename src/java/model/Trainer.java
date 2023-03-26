package model;
public class Trainer {
    private int id;
    private String name;
    private String specialty;
    private String sports;

    public Trainer(int id, String name, String specialty, String sports) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.sports = sports;
    }

    public Trainer(String name, String specialty, String sports) {
        this.name = name;
        this.specialty = specialty;
        this.sports = sports;
    }

    public Trainer() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSports() {
        return sports;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }

    @Override
    public String toString() {
        return "Trainer [id=" + id + ", name=" + name + ", specialty=" + specialty + ", sports=" + sports + "]";
    }
}