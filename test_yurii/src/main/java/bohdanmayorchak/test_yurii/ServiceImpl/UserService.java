package bohdanmayorchak.test_yurii.ServiceImpl;

import bohdanmayorchak.test_yurii.DAO.ArticleDAO;
import bohdanmayorchak.test_yurii.DAO.UserDAO;
import bohdanmayorchak.test_yurii.Models.Article;
import bohdanmayorchak.test_yurii.Models.User;
import bohdanmayorchak.test_yurii.dto.ArticleDto;
import bohdanmayorchak.test_yurii.dto.UserDto;
import bohdanmayorchak.test_yurii.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static bohdanmayorchak.test_yurii.utils.CollectionUtils.mapToList;

@Service
public class UserService {
    private final UserDAO userDAO;
    private final ArticleDAO articleDAO;

    @Autowired
    public UserService(UserDAO userDAO, ArticleDAO articleDAO) {
        this.userDAO = userDAO;
        this.articleDAO = articleDAO;
    }


    @Transactional
    public UserDto save(UserDto userRequest) {
        assert userRequest.getId() == null;

        User savedUser =
                userDAO.save(new User(userRequest));

        List<Article> savedArticles =
                articleDAO.saveAll(mapToList(userRequest.getArticles(), ar -> new Article(ar, savedUser)));

        savedUser.setArticles(savedArticles);

        return new UserDto(savedUser);
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }

    public List<User> findAllByAge(int age) {
        return userDAO.findAllByAge(age);
    }

    public User getById(int id) {
        return userDAO.getById(id);
    }
}
