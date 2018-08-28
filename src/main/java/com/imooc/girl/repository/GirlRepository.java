package com.imooc.girl.repository;

import com.imooc.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl, Integer> {
    /**
     * 必须是findByXxx这种形式
     * @param age
     * @return
     */
    List<Girl> findByAge(Integer age);
}
