package com.text.controller;


import com.text.command.Command;
import com.text.command.CommandFactory;
import com.text.command.Page;
import com.text.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doWork(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doWork(req, resp);
    }
    private void doWork(HttpServletRequest req , HttpServletResponse resp) throws ServletException,IOException {
        System.out.println("send me message");
        String value =req.getParameter("command");
        Command command = CommandFactory.createCommand(value);

        try {
           Page page = command.execute(req);
            if (page.isRedirect()) {
                redirect(page.getUrl(),req,resp);
            }else {
                forward(page.getUrl(),req,resp);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }
    public void forward(String url , HttpServletRequest req, HttpServletResponse resp ) throws ServletException , IOException {
        RequestDispatcher rd = getServletContext()
                .getRequestDispatcher(url);
        rd.forward(req,resp);
    }
    public void redirect(String url, HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + url);
    }
}
