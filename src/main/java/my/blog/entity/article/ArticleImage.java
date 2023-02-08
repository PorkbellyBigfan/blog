package my.blog.entity.article;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="article_image_id")
    private Long id;

    @Column(nullable = false)
    private String img;

    @ManyToOne
    private Article article;
}
