package bohdanmayorchak.test_yurii.dto;

import bohdanmayorchak.test_yurii.Models.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static bohdanmayorchak.test_yurii.utils.CollectionUtils.mapToList;

@Data
public class UserDto {
    private Long id;
    private String name;
    private int age;

    private List<ArticleDto> articles = new ArrayList<>();

    public UserDto() {

    }

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.age = user.getAge();

        this.articles = mapToList(user.getArticles(), ArticleDto::new);
    }
}
