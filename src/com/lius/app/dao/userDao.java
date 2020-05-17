package com.lius.app.dao;

import com.lius.app.beans.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
public class userDao{

    private static String findUserByNameAndPassword="from %s where username=:username and userpassword=:userpassword";
    private  SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * 获取Session
     * @return
     */
    private Session getSession(){
        return sessionFactory.openSession();
    }
    /**
     * 关闭Session
     * @return
     */
    private boolean closeSession(Session session){
        session.close();
        return true;
    }

    /**
     * 保存用户信息
     * @param userInfo
     * @return
     */
    public boolean saveUser(UserEntity userInfo){
        Session session = getSession();//获取session
        Transaction tran = session.beginTransaction();
//        tran.begin();//开启事务
        session.save(userInfo);//保存
        session.flush();//刷新事务
        tran.commit();//提交事务
        closeSession(session);//关闭session
        return true;
    }

    /**
     * <p>通过用户名和密码查询用户表信息</p>
     * @param name
     * @param password
     * @return
     */
    public List getUser(String name,String password){
        Session session = getSession();//获取session
        String sql =String.format(findUserByNameAndPassword,UserEntity.class.getSimpleName());
//        System.out.println(sql);
        Query query = session.createQuery(sql)
                .setParameter("username",name)
                .setParameter("userpassword",password);//创建查询
        List results = query.list();//获取查询结果
        closeSession(session);//关闭session
        return results;//返回结果集合
    }
}
