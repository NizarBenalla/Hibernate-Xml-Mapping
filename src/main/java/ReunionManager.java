import dao.Reunion;
import gest.Personne;
import org.hibernate.Session;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import util.HibernateUtil;

import org.hibernate.query.Query;


public class ReunionManager {
    public void addReunion(Reunion r) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(r);
        session.getTransaction().commit();
    }

    public List listReunions() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Reunion").list();
        session.getTransaction().commit();
        return result;
    }

    public void addPersonne(String nom, String prenom, int age) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Personne p = new Personne();
        p.setNomPersonne(nom);
        p.setPrenomPersonne(prenom);
        p.setAge(age);
        session.save(p);
        session.getTransaction().commit();
    }

    public void addReunionToPersonne(Long idPersonne, Long idReunion) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Personne p = (Personne) session.load(Personne.class, idPersonne);
        Reunion r = (Reunion) session.load(Reunion.class, idReunion);
        p.getReunions().add(r);
        session.getTransaction().commit();
    }

    public Personne getPersonne(Long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        String queryString = "SELECT p FROM Personne p WHERE p.idPersonne = :id";
        Query<Personne> query = session.createQuery(queryString, Personne.class);
        query.setParameter("id", id);

        Personne personne = query.uniqueResult();

        session.getTransaction().commit();

        return personne;
    }

    public static void main(String[] args) {
        ReunionManager gestManager = new ReunionManager();
        gestManager.addReunion(new Reunion("conseil", new Date()));
        gestManager.addReunion(new Reunion("Compte rendue", new Date()));
        gestManager.addReunion(new Reunion("délibération", new Date()));
        gestManager.addPersonne("Jihad", "hassan", 25);
        gestManager.addPersonne("mandari", "Youness", 22);
        gestManager.addPersonne("Karimi", " yassine", 23);

        gestManager.addReunionToPersonne(new Long(1), new Long(1));
        gestManager.addReunionToPersonne(new Long(2), new Long(1));
        gestManager.addReunionToPersonne(new Long(3), new Long(1));
        gestManager.addReunionToPersonne(new Long(1), new Long(2));
        gestManager.addReunionToPersonne(new Long(3), new Long(2));
        List listR = gestManager.listReunions();
        Iterator lesR = listR.iterator();
        while (lesR.hasNext()) {
            Reunion r = (Reunion) lesR.next();
            System.out.println(r.getIdReunion() + "--" + r.getTitreReunion() + "--" + r.getDateReunion());
        }
        HibernateUtil.getSessionFactory().close();
    }
}