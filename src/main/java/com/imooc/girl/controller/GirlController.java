package com.imooc.girl.controller;

import com.imooc.girl.domain.Girl;
import com.imooc.girl.repository.GirlRepository;
import com.imooc.girl.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }

    /**
     * 获取指定id的girl
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl getGirl(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * 更新指定id的girl
     * @param id
     * @param cupSize
     * @param age
     */
    @PutMapping(value = "/girls/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl); //这里不能先findOne()后save()?
    }

    /**
     * 删除指定id的girl
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void deleteGirl(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    /**
     * 获取指定年龄的girl
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> getGirlByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void insertTwoGirls(){
        girlService.insertTwo();
    }
}
