package com.text.command;

import com.text.entities.Text;
import com.text.exception.ServiceException;
import com.text.service.Service;
import com.text.service.impl.TextService;
import javax.servlet.http.HttpServletRequest;
import java.io.*;


public class CreateText implements Command{
    private TextService service = new TextService();
    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Page page = new Page("/pages/text1.jsp", true);
        Text text = new Text();
        String s = req.getParameter("text");
        s.length();
        System.out.println(s.length());
        service.create(text);
        return page;
    }
}
