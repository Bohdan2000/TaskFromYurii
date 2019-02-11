package bohdanmayorchak.test_yurii.DAO;

import bohdanmayorchak.test_yurii.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserDAO extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.age>:xxx")
    List<User> findAllByAge(@Param("xxx") int age);

    @Query("select u from User  u where u.id=:xxx")
    User getById(@Param("xxx") int id);

}
