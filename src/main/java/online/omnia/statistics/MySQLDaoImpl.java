package online.omnia.statistics;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by lollipop on 26.09.2017.
 */
public class MySQLDaoImpl {
    private static Configuration configuration;
    private static SessionFactory sessionFactory;
    private static MySQLDaoImpl instance;

    static {
        configuration = new Configuration()
                .addAnnotatedClass(AccountsEntity.class)
                .addAnnotatedClass(CampaignEntity.class)
                .addAnnotatedClass(AffiliatesEntity.class)
                .addAnnotatedClass(TrackersEntity.class)
                .configure("/hibernate.cfg.xml");
        Map<String, String> properties = Utils.iniFileReader();
        configuration.setProperty("hibernate.connection.password", properties.get("password"));
        configuration.setProperty("hibernate.connection.username", properties.get("username"));
        String jdbcURL = (properties.get("url")
                .startsWith("jdbc:mysql://") ? properties.get("url") : "jdbc:mysql://" + properties.get("url"));
        String url = (!jdbcURL.endsWith("/") ? jdbcURL + "/" : jdbcURL) + properties.get("dbname");
        configuration.setProperty("hibernate.connection.url", url);

        while (true) {
            try {
                sessionFactory = configuration.buildSessionFactory();
                break;
            } catch (PersistenceException e) {

                try {
                    System.out.println("Can't connect to db");
                    System.out.println("Waiting for 30 seconds");
                    Thread.sleep(30000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
    public void addCampaignEntity(CampaignEntity campaignEntity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(campaignEntity);
        session.getTransaction().commit();
        session.close();
    }
    public List<TrackersEntity> getTrackers() {
        Session session = sessionFactory.openSession();
        List<TrackersEntity> trackersEntities = session.createQuery("from TrackersEntity", TrackersEntity.class)
                .getResultList();
        session.close();
        return trackersEntities;
    }
    public CampaignEntity getCampaignEntity(int trackerId, int campaignId, java.util.Date date) {
        Session session = sessionFactory.openSession();
        CampaignEntity campaignEntity = null;
        try {
            campaignEntity = session.createQuery("from CampaignEntity where campaign_id=:campaignId and prefix=:trackerId and date=:date", CampaignEntity.class)
                    .setParameter("campaignId", campaignId)
                    .setParameter("trackerId", trackerId)
                    .setParameter("date", date)
                    .getSingleResult();
            session.close();
        } catch (NoResultException e) {
            session.close();
            return null;
        }
        return campaignEntity;
    }
    public void updateCampagnEntuty(CampaignEntity campaignEntity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(campaignEntity);
        session.getTransaction().commit();
        session.close();
    }
    public AffiliatesEntity getAffiliateByAfid(int afid) {
        Session session = sessionFactory.openSession();
        AffiliatesEntity affiliatesEntity = session.createQuery("from AffiliatesEntity where afid=:afid", AffiliatesEntity.class)
                .setParameter("afid", afid)
                .getSingleResult();
        session.close();
        return affiliatesEntity;
    }

    public List<AccountsEntity> getAccountsEntities(String type) {
        Session session = sessionFactory.openSession();
        List<AccountsEntity> accountsEntities;
        while (true) {
            try {
                accountsEntities = session.createQuery("from AccountsEntity acc where acc.type like:accType", AccountsEntity.class)
                        .setParameter("accType", type)
                        .getResultList();
                break;
            } catch (PersistenceException e) {
                try {
                    System.out.println("Can't connect to db");
                    System.out.println("Waiting for 30 seconds");
                    Thread.sleep(30000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
        session.close();
        return accountsEntities;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static MySQLDaoImpl getInstance() {
        if (instance == null) instance = new MySQLDaoImpl();
        return instance;
    }
}
