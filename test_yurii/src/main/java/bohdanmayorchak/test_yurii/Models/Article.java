package bohdanmayorchak.test_yurii.Models;

import bohdanmayorchak.test_yurii.dto.ArticleDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Article_Table")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private Color color;
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private User user;

    public Article(String text, Color color) {
        this.text = text;
        this.color = color;
    }

    public Article(ArticleDto articleDto, User user) {
        this(articleDto.getText(), articleDto.getColor());
        this.user = user;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", color=" + color +
                '}';
    }
}
