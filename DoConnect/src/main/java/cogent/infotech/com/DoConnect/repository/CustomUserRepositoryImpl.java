package cogent.infotech.com.DoConnect.repository;

import cogent.infotech.com.DoConnect.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomUserRepositoryImpl implements CustomUserRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> findUserByName(String name) {
        String sql = "Select * from Users Where name=:name";
        final TypedQuery<User> query =  entityManager.createQuery(sql, User.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}
