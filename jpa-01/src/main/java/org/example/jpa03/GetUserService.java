package org.example.jpa03;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.domain.User;
import org.example.EMF;

public class GetUserService {
    public User getUser(String email) {
        EntityManager em = EMF.createEntityManager();

        try {
            User user = em.find(User.class, email);
            if (user == null) {
                throw new IllegalArgumentException("유저가 없습니다.");
            }

            return user;
        } finally {
            em.close();
        }
    }
}
