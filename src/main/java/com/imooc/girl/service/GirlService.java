package com.imooc.girl.service;

import com.imooc.girl.domain.Girl;
import com.imooc.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    /**
     * 即使是只有一个save, 最好也使用事务
     */
    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(19);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("CCCCC");
        girlB.setAge(29);
        girlRepository.save(girlB);

    }
}
