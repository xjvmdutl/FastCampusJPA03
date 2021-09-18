package com.fastcampus.jpa.FastCampusJPA03.domain.listener;

import java.time.LocalDateTime;

public interface Auditable {
    //반드시 updateAt,createAt 맴버변수를 가지는 클래스에 적용시킬거이기 떄문에
    //인터페이스 형식을 updateAt,createAt getter,setter를 정의 해둔다.
    LocalDateTime getCreateAt();
    LocalDateTime getUpdateAt();
    void setCreateAt(LocalDateTime createAt);
    void setUpdateAt(LocalDateTime updateAt);
}
