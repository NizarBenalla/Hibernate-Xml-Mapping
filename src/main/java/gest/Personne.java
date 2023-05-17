package gest;

import dao.Reunion;
import org.hibernate.Session;
import util.HibernateUtil;


import java.beans.Expression;
import java.util.*;

public class Personne {
    private Long idPersonne;
    private String nomPersonne;
    private String prenomPersonne;
    private int age;
    private Set reunions = new HashSet();







    public Long getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Long idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNomPersonne() {
        return nomPersonne;
    }

    public void setNomPersonne(String nomPersonne) {
        this.nomPersonne = nomPersonne;
    }

    public String getPrenomPersonne() {
        return prenomPersonne;
    }

    public void setPrenomPersonne(String prenomPersonne) {
        this.prenomPersonne = prenomPersonne;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set getReunions() {
        return reunions;
    }

    public void setReunions(Set reunions) {
        this.reunions = reunions;
    }
}