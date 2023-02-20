package shop.mtcoding.blog.model;

import java.security.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Love {
    private Integer id;
    private Integer boardId;
    private Integer userId;
    private Timestamp created_at;
}
