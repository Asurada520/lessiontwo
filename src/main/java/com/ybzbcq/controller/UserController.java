package com.ybzbcq.controller;

import com.ybzbcq.entity.UserEntity;
import com.ybzbcq.jpa.UserJPA;
import com.ybzbcq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
@CacheConfig(cacheNames = "user")
public class UserController {

    @Autowired
    private UserJPA userJPA;

    @Autowired
    private UserService userService;

    /**
     * 查询用户列表方法
     * @return 用户列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET/*, produces = "application/json; charset=utf-8"*/)
    public List<UserEntity> list(){
        List<UserEntity> list = userService.list();
        return list;
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public UserEntity save(UserEntity entity){
        return userJPA.save(entity);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public List<UserEntity> delete(Long id){
        Optional<UserEntity> byId = userJPA.findById(id);
        if(byId.isPresent()){
            userJPA.deleteById(id);
        }
        List<UserEntity> list = userJPA.findAll();
        return list;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(UserEntity entity, HttpServletRequest request){

        Optional<UserEntity> one = userJPA.findOne(new Specification<UserEntity>() {
            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.where(criteriaBuilder.equal(root.get("name"), entity.getName()));
                return null;
            }
        });

        if(one.isPresent()){
            UserEntity userEntity = one.get();
            if(userEntity == null){
                return "user is not existed";
            }else{
                String pwd = userEntity.getPwd();
                if(!pwd.equals(entity.getPwd())){
                    return "username or password is error, login failure";
                }
            }
        }else {
            return "user is not existed";
        }

        request.getSession().setAttribute("_session_user", entity);

        return "success";
    }

    @RequestMapping(value = "/logOut", method = RequestMethod.GET)
    public String loginOut(HttpServletRequest request){
        request.getSession().removeAttribute("_session_user");
        return "success";
    }

}
