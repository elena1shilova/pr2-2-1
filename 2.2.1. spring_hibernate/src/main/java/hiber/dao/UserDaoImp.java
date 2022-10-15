package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }
   /*@Override
   public void add(Car car) {
      sessionFactory.getCurrentSession().save(car);
   }*/
   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listGetUser(String model, int series){
      Query query = sessionFactory.getCurrentSession().createQuery("FROM User " + "where car.model= :modelParam and car.series= :seriesParam ");
      query.setParameter("modelParam", model);
      query.setParameter("seriesParam", series);
      List<User> users = query.list();
      return users;
   }
   /*@Override
   public void getUser(String model, int series) {
      sessionFactory.getCurrentSession()
   }*/

}
