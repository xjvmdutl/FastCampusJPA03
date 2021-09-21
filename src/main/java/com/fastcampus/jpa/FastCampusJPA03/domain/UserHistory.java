package com.fastcampus.jpa.FastCampusJPA03.domain;

import com.fastcampus.jpa.FastCampusJPA03.domain.listener.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)//toString 재정의
@EqualsAndHashCode(callSuper = true)
//@EntityListeners(value = AuditingEntityListener.class)
public class UserHistory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name="user_id", insertable = false,updatable = false)
    //private Long userId;

    private String name;

    private String email;

    @ManyToOne
    private User user;


    /*
        @CreatedDate
        private LocalDateTime createAt;

        @LastModifiedDate
        private LocalDateTime updateAt;
    */
}
