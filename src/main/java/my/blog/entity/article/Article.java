package my.blog.entity.article;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.blog.entity.Enum.Menu;
import my.blog.entity.etc.DateEntity;
import my.blog.entity.member.Member;

import java.nio.charset.Charset;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article extends DateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="article_id")
    private Long id;

    @Column
    private byte[] articleContext;

    @Column
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY) //연관관계의 주인 : FK 가 있는 곳
    @JoinColumn(name="member_id")
    private Member member;

    @Builder.Default
    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY, orphanRemoval = true)
    @OrderBy("reply_id asc")
    private Set<Reply> replies = new LinkedHashSet<>();

    public String updateArticleContextToString(byte[] byteString) {
        return new String(byteString, Charset.forName("utf8"));
    }

}
