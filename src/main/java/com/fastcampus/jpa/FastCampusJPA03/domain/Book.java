package com.fastcampus.jpa.FastCampusJPA03.domain;

import com.fastcampus.jpa.FastCampusJPA03.domain.listener.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)//toString 재정의
@EqualsAndHashCode(callSuper = true)
//@EntityListeners(value = AuditingEntityListener.class)
public class Book extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    private Long authorId;
    //private Long publisherId;
    @OneToOne(mappedBy = "book")//소유하지 않는 Entity에 설정하는 옵션//연관키를 해당 테이블에서 제거
    @ToString.Exclude//엔티티 relation을 연관지을 경우 toString 메소드가 순환참조가 걸려 오류가 발생
    private BookReviewInfo bookReviewInfo;

    @OneToMany
    @JoinColumn(name = "book_id")
    @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();

    @ManyToOne
    @ToString.Exclude
    private Publisher publisher;


    /*
        @CreatedDate
        private LocalDateTime createAt;
        @LastModifiedDate
        private LocalDateTime updateAt;
    */
    /*
        @PrePersist
        public void prePersist(){
            this.createAt = LocalDateTime.now();
            this.updateAt = LocalDateTime.now();
        }
        @PreUpdate
        public void PreUpdate(){
            this.updateAt = LocalDateTime.now();
        }
    */
}
