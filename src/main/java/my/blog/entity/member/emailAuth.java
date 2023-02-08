package my.blog.entity.member;

import jakarta.persistence.*;
import lombok.*;
import my.blog.entity.etc.DateEntity;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class emailAuth extends DateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="eauth_id")
    Long id;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    Integer authNum;

    @ColumnDefault("0")
    Boolean isAuthorized;
}
