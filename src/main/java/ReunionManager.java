import dao.Reunion;
import org.hibernate.Session;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import util.HibernateUtil;

public class ReunionManager {
    public void addReunion(Reunion r) {
        Session
                session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(r);
        session.getTransaction().commit();
    }

    public List listReunions() {
        Session session =
                HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Reunion").list();
        session.getTransaction().commit();
        return result;
    }

    public static void main(String[] args) {
        ReunionManager gestManager = new ReunionManager();
        gestManager.addReunion(new Reunion("conseil", new Date()));
        gestManager.addReunion(new Reunion("Compte rendue", new Date()));
        gestManager.addReunion(new Reunion("délibération", new Date()));
        List listR = gestManager.listReunions();
        Iterator lesR = listR.iterator();
        while (lesR.hasNext()) {
            Reunion r = (Reunion) lesR.next();
            System.out.println(r.getIdReunion() + "--"
                    + r.getTitreReunion() + "--"
                    + r.getDateReunion()
            );
        }
        HibernateUtil.getSessionFactory().close();
    }
}