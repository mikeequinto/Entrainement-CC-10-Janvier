package domaine;

import java.util.Objects;

public class Personne implements Comparable{

    String name;
    String email;
    int age;
    Sexe sexe;
    String etatCivil;

    public Personne(String name, String email, int age, Sexe sexe, String etatCivil) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.sexe = sexe;
        this.etatCivil = etatCivil;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public String getEtatCivil() {
        return etatCivil;
    }

    public void setEtatCivil(String etatCivil) {
        this.etatCivil = etatCivil;
    }

    public int compareTo(Object obj){

        if(sexe.compareTo(((Personne)obj).sexe) == 0 ){
            return age - ((Personne) obj).age;
        }else{
            return sexe.name().compareTo(((Personne)obj).sexe.name());
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return age == personne.age &&
                Objects.equals(name, personne.name) &&
                Objects.equals(email, personne.email) &&
                sexe == personne.sexe &&
                Objects.equals(etatCivil, personne.etatCivil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, age, sexe, etatCivil);
    }

    @Override
    public String toString() {
        return "Personne{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", sexe=" + sexe +
                ", etatCivil='" + etatCivil + '\'' +
                '}';
    }
}
