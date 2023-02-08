package my.blog.entity.article;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.blog.entity.etc.DateEntity;
import my.blog.entity.member.Member;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reply extends DateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long id;

    @Column(nullable = false)
    private String replyContext;

    @Column(nullable = false)
    private Long replyGroup;

    @Column(nullable = false)
    private Long replySort;

    @Column
    private boolean hide;

    @ManyToOne //연관관계의 주인 : FK 가 있는 곳
    private Article article;

    @ManyToOne //연관관계의 주인 : FK 가 있는 곳
    private Member member;

}
