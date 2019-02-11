package bohdanmayorchak.test_yurii.dto;

import bohdanmayorchak.test_yurii.Models.Article;
import bohdanmayorchak.test_yurii.Models.Color;
import lombok.Data;

@Data
public class ArticleDto {
    private int id;
    private String text;
    private Color color;

    private long userId;

    public ArticleDto() {

    }

    public ArticleDto(Article article) {
        this.id = article.getId();
        this.text = article.getText();
        this.color = article.getColor();

        this.userId = article.getUser().getId();
    }
}
