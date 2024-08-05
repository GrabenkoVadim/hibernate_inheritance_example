package core.basesyntax.dao.machine;

import core.basesyntax.dao.AbstractDao;
import core.basesyntax.model.machine.Machine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MachineDaoImpl extends AbstractDao implements MachineDao {
    public MachineDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Machine save(Machine machine) {
        Session session = null;
        Transaction tx = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(machine);
            tx.commit();
        }
        catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new RuntimeException("Error saving animal" + machine, e);
        } finally {
            if (session != null) session.close();
        }
        return machine;
    }

    @Override
    public List<Machine> findByAgeOlderThan(int age) {
        try(Session session = sessionFactory.openSession()) {
            Query<Machine> query = session.createQuery("from Machine m where m.year < 2024 - :age", Machine.class);
            query.setParameter("age", age);
            return query.getResultList();
        }
    }
}
