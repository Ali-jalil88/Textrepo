package com.text.command;

import com.text.entities.Text;
import com.text.exception.ServiceException;
import com.text.service.Service;
import com.text.service.impl.TextService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.io.*;
import java.util.Enumeration;


public class CreateText implements Command{
    private TextService service = new TextService();
    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Page page = new Page("/pages/text1.jsp", true);
        Text text = new Text();
        String s = req.getParameter("text");
        s.length();
        System.out.println(s.length());
//        s.contains("IPses");
//        System.out.println(s.contains("IPses"));

//        String [] SArray = s.split("IPsec");
//        for (int i = 0; i < SArray.length; i++){
//            System.out.println(SArray[i]);
//        }
        String l = req.getParameter("text");
        String [] sArray = l.split("\n");
        for (int i = 0; i < sArray.length; i++){
            System.out.println(sArray[i]);
        }
        text.setNumberLine(sArray.length);

        String g = req.getParameter("text");
        String [] SArray = g.split("\\s+");
        for (int i = 0; i < SArray.length; i++){
            System.out.println(SArray[i]);
//            text.setWord(SArray.length);
        }
        String a = SArray[0];
        text.setWord(a);
        text.setNumberWord(SArray.length);
        String letter = SArray[2];
        text.setLetter(letter);

        String nl = req.getParameter("text");
        char [] chars = nl.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println();
        }
        text.setNumberLetter(chars.length);


//        char letter = chars[2];



//        String [] FArray = s.split("-",3);
//        for (String temp : FArray){
//            System.out.println(temp);
//        }
//        byte b []= s.getBytes();
//        for (int i = 0; i < b.length; i++){
//            System.out.println(b[i]);
//        }
        HttpSession session = req.getSession();
        session.setAttribute("number", text);
        service.create(text);
        return page;
    }
}
