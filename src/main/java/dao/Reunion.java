package dao;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Reunion {
    private Long idReunion;
    private Set personnes = new HashSet();
    public Set getPersonnes() {
        return personnes;
    }
    public void setPersonnes(Set personnes) {
        this.personnes = personnes;
    }
    public Long getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(Long idReunion) {
        this.idReunion = idReunion;
    }

    private String titre;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    private Date dateReunion;

    public Date getDateReunion() {
        return dateReunion;
    }

    public void setDateReunion(Date dateReunion) {
        this.dateReunion = dateReunion;
    }

    public Reunion() {
    }
    public Reunion(String titre, Date dateReunion) {
        this.titre = titre;
        this.dateReunion = dateReunion;
    }

    public String getTitreReunion() {
        return titre;
    }
}