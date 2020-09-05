package com.text.command;

import com.text.entities.Counter;
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
        Counter counter = new Counter();
        String s = req.getParameter("text");

//        text.setFullText(s);
//        s.length();
//        System.out.println(s.length());
////        s.contains("IPses");
////        System.out.println(s.contains("IPses"));
//
////        String [] SArray = s.split("IPsec");
////        for (int i = 0; i < SArray.length; i++){
////            System.out.println(SArray[i]);
////        }
       // String l = req.getParameter("text");


////        String g = req.getParameter("text");
//        String [] SArray = s.split("\\s+");
//        String repeatedWord = null;
////        int count = 0;
////        int max = 0;
//        String mostRepeatedWord = null;
//        for (int i = 0; i < SArray.length; i++){
//            System.out.println(SArray[i]);
//            repeatedWord = SArray[i];
//
////            text.setWord(SArray.length);
//        }
//        String a = SArray[0];
//        text.setWord(a);
//        text.setNumberWord(SArray.length);



        String [] sArray = s.split("\n");
        for (int i = 0; i < sArray.length; i++){
            System.out.println(sArray[i]);
        }
        counter.setNumberLine(sArray.length);



        int wordStart = 0;
        int wordCount = 0;
        String word = "";
        for (int wordEnd = wordStart; wordEnd < s.length(); wordEnd++) {
            if (wordEnd > s.length() || s.charAt(wordEnd) == ' '){
                String thisWord = s.substring(wordStart, wordEnd);
                int thisWordCount = 0;
                int search = -1;
                while ((search = s.indexOf(thisWord, search + 1)) >= 0){
                    thisWordCount += 1;
                }
                if (thisWordCount > wordCount){
                    word = thisWord;
                    wordCount = thisWordCount;
                }
                wordStart = wordEnd + 1;

            }
        }
        counter.setNumberWord(wordCount);
        counter.setWord(word);
        System.out.println(1);


        int[] frequent = new int[s.length()];
        char maxChar = s.charAt(0);
        int i, j, max;

        char string[] = s.toCharArray();

        for (i = 0; i < string.length; i++) {
            frequent[i] = 1;
            for (j = i + 1; j < string.length; j++) {
                if (string[i] == string[j] && string[i] != ' ' && string[i] != '0') {
                    frequent[i]++;
                    string[j] = '0';

                }
            }
        }
        max = frequent[0];
        for (i=0; i<string.length; i++){
            if (max<frequent[i]){
                max = frequent[i];
                maxChar = string[i];
            }
        }
        System.out.println(max);
        System.out.println(maxChar);
        counter.setLetter(maxChar);
        counter.setNumberLetter(max);
//        int count = 1;
//        int max = 0;
//        char maxChar = 0;
//        for (int i = 1; i < array.length; i++){
//
//            if (array[i] == array [ i-1]){
//                count++;
//            }else {
//                if (count>max){
//                    max=count;
//                    maxChar = array[i-1];
//                }
//                count=1;
//            }
//        }
//        if (count>max){
//            max=count;
//            maxChar = array [ array.length-1];
//            text.setLetter(s);
//        }
//        System.out.println("longest run:"+max+", for the character" + maxChar);




//        String letter = SArray[2];
//        text.setLetter(letter);
//
//        String nl = req.getParameter("text");
//        char [] chars = nl.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            System.out.println();
//        }
//        text.setNumberLetter(chars.length);


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
        session.setAttribute("number", counter);
        session.setAttribute("text", text);
        service.create(text);
        return page;
    }
}
