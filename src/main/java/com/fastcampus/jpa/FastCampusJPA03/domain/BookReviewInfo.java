package com.fastcampus.jpa.FastCampusJPA03.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)//상속받는 엔티티의 toString 포함여부
@EqualsAndHashCode(callSuper = true)
public class BookReviewInfo extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private Long bookId;
    @OneToOne(optional = false) //1대1 참조//optional = false : 반드시 데이터가 있어야 된다
    private Book book;//ID를 참조하지 않고 Book으로 참조한다.

    private float averageReviewScore;

    private int reviewCount;//NULL을 허용하지 않기 때문에 wrapper 타입으로 하지 않았다.


}
