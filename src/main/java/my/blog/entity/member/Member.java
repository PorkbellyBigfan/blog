package my.blog.entity.member;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.blog.entity.article.Article;
import my.blog.entity.article.Reply;
import my.blog.entity.etc.DateEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member extends DateEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private String nickname;

    @Column
    private String name;

    @Column(unique = true)
    private String mobile;

    @Column
    private String oauth;

    @Column
    private String memberimg;

    @Builder.Default
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Article> articles = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Reply> reply = new ArrayList<>();

}
