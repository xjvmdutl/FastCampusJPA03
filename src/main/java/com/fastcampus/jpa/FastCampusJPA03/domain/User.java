package com.fastcampus.jpa.FastCampusJPA03.domain;

import com.fastcampus.jpa.FastCampusJPA03.domain.listener.Auditable;
import com.fastcampus.jpa.FastCampusJPA03.domain.listener.UserEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity
@Table(name = "user", indexes = {@Index(columnList = "name")},uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@EntityListeners(value = { UserEntityListener.class})
@ToString(callSuper = true)//toString 재정의
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//순차적 증가
    private Long id;

    @NonNull
    private String name;
    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    //BaseEntity에서 createAt,updateAt을 상속해주기 때문에 주석처리해도 동작한다.

    /*
    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createAt;

    @LastModifiedDate
    private LocalDateTime updateAt;
    */
    //7가지 이벤트 제공
    /*
    @PrePersist// Insert메소드가 호출되기 전에 실행
    @PreUpdate // Merge메소드가 호출되기 전에 실행
    @PreRemove // delete메소드가 호출되기전에 실행
    @PostPersist//Insert메소드가 호출된 후 실행
    @PostUpdate // Merge메소드가 호출된 후 실행
    @PostRemove // delete메소드가 호출된 후 실행
    @PostLoad   // select메소드가 실행된 직후 실행
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
