package bohdanmayorchak.test_yurii.DAO;

import bohdanmayorchak.test_yurii.Models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleDAO extends JpaRepository<Article, Integer> {
}
