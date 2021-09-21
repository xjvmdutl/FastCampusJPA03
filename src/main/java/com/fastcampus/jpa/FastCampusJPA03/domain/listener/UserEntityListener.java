package com.fastcampus.jpa.FastCampusJPA03.domain.listener;

import com.fastcampus.jpa.FastCampusJPA03.domain.User;
import com.fastcampus.jpa.FastCampusJPA03.domain.UserHistory;
import com.fastcampus.jpa.FastCampusJPA03.repository.UserHistoryRepository;
import com.fastcampus.jpa.FastCampusJPA03.support.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
@Component
public class UserEntityListener {
    //@Autowired
    //private UserHistoryRepository userHistoryRepository;

    @PostPersist
    @PostUpdate
    public void prePersistAndPreUpdate(Object o){
        //에러 발생
        //why? Spring EntityListener 같은경우 Spring bean을 가지고 올수가 없다.
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);
        User user = (User) o;

        UserHistory userHistory = new UserHistory();
        //userHistory.setUserId(user.getId());
        userHistory.setEmail(user.getEmail());
        userHistory.setName(user.getName());
        userHistory.setUser(user);
        userHistoryRepository.save(userHistory);
    }


}
