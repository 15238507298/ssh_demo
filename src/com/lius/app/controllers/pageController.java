package com.lius.app.controllers;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class pageController extends ActionSupport {

    private void dispatcherA(String path) {

        try {
            //ServletActionContext获取当前Request对象
            HttpServletRequest request = ServletActionContext.getRequest();
            request.getRequestDispatcher(path).forward(request,
                    ServletActionContext.getResponse());
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String login()throws Exception {
        dispatcherA("/pages/login.jsp");
        return SUCCESS;
    }
    public String regist()throws Exception {
        dispatcherA("/pages/regist.jsp");
        return SUCCESS;
    }
    public String index()throws Exception {
        dispatcherA("/pages/index.jsp");
        return SUCCESS;
    }
    public String error()throws Exception {
        dispatcherA("/pages/error.jsp");
        return SUCCESS;
    }

}
