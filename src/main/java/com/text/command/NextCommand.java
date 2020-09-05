package com.text.command;

import com.text.entities.Text;
import com.text.exception.ServiceException;
import com.text.service.impl.TextService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class NextCommand implements Command{
    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Page page = new Page("/pages/text.jsp", true);
        TextService service = new TextService();

        HttpSession session = req.getSession();
        Text currentText = (Text) session.getAttribute("savedText");
        Text otherText = (Text) session.getAttribute("oldText");

        int otherId = otherText.getId();
        int initialId = currentText.getId();


        for (int i = otherId; i <= initialId; i++) {
            int newId = i;
            Text text = service.read(newId);
            session.setAttribute("newText", text);
        }
        return page;
    }
}