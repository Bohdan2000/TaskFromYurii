package bohdanmayorchak.test_yurii.ServiceImpl;

import bohdanmayorchak.test_yurii.DAO.ArticleDAO;

import bohdanmayorchak.test_yurii.Models.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleDAO articleDAO;

    public ArticleService(ArticleDAO articleDAO) {
        this.articleDAO=articleDAO;
    }
    public void save(Article article){
        articleDAO.save(article);
    }

    public List<Article> findAll() {
        return articleDAO.findAll();
    }
}
