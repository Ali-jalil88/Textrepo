package com.text.command;

import com.text.entities.Text;
import com.text.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sound.sampled.Line;
import java.util.List;

public class SelectedText implements Command {

    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Page page = new Page("/" , true);
        HttpSession session = req.getSession();
        int i =Integer.parseInt((req.getParameter("index")));
        List<Text> textList = (List<Text>)session.getAttribute("filtered");
        Text text = textList.get(i);
        session.setAttribute("selectedText",text);
        page.setUrl("/pages/text1.jsp");
        return page;
    }
}
