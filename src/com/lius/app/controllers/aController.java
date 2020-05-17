package com.lius.app.controllers;


import com.lius.app.beans.UserEntity;
import com.lius.app.dao.userDao;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
import java.util.logging.Logger;

public class aController extends ActionSupport {
    //Dao
    private userDao userDao;
    private UserEntity user;
    //日志
    private Logger logger = Logger.getLogger(this.getClass().getName());

    public void setUserDao(com.lius.app.dao.userDao userDao) {
        this.userDao = userDao;
    }
    public UserEntity getUser() {
        return user;
    }
    public void setUser(UserEntity user) {
        this.user = user;
    }

    /**
     *<p>进入首页</p>
     * @return
     */
    public String hello(){
        return SUCCESS;
    }

    /**
     * <p>进入登录页面</p>
     * @return
     * @throws Exception
     */
    public String login_page() throws Exception {
        logger.info("进入index页面");
        return "success";
    }

    /**
     * <p>登录</p>
     * @return
     */
    public String login(){
        logger.info("用户登录信息:"+user.toString());
        return isExistUserInfo()?SUCCESS:ERROR;
    }

    /**
     * <p>用户注册</p>
     * @return
     * @throws Exception
     */
    public String regist() throws Exception {

        if (!isExistUserInfo()) {//数据库不存在该用户,注册用户数据
            logger.info("注册用户数据:"+user.toString());
            userDao.saveUser(user);//注册用户
            logger.info("注册用户数据成功");
            return SUCCESS;//返回注册成功
        }
        return ERROR;//注册失败
    }

    /**
     * <p>根据用户名与密码查询数据库是否存在该用户数据</p>
     * @return
     */
    public boolean isExistUserInfo(){
        //根据用户名与密码到数据库查询
        List<UserEntity> users = userDao.getUser(user.getUsername(), user.getUserpassword());
        //如果数据库存在该用户名与密码返回false，表示数据库已存在该用户
        if(users.size()>0){
            return true;
        }
        //否则返回false,表示数据库不存在该用户
        return false;
    }
}
