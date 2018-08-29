package com.imooc.girl.service;

import com.imooc.girl.domain.Girl;
import com.imooc.girl.exception.GirlException;
import com.imooc.girl.repository.GirlRepository;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
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

    public Girl getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age < 10){
            throw new GirlException(100, "上小学");
        }else if(10 < age && age < 16){
            throw new GirlException(101, "上初中");
        }
        return girl;
    }
}
