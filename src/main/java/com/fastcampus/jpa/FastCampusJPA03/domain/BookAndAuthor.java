package com.fastcampus.jpa.FastCampusJPA03.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BookAndAuthor extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //기존 Many-Many 관계를 1-N 1-N 관계로 풀었다.
    @ManyToOne
    private Book book;

    @ManyToOne
    private Author author;

}
