package com.text.command;

import com.text.entities.Text;
import com.text.exception.ServiceException;
import com.text.service.impl.TextService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PreviousCommand implements Command{
    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Page page = new Page("/pages/text.jsp", true);
        TextService service = new TextService();
        HttpSession session = req.getSession();
        Text currentText = (Text) session.getAttribute("text");
        Text otherText = (Text) session.getAttribute("oldText");
        if (otherText != null) {
            int otherId = otherText.getId();
            int newId = otherId - 1;
            Text text = service.read(newId);
            session.setAttribute("oldText", text);
        } else {
            int initialId = currentText.getId();
            System.out.println(initialId);
            int newId = initialId - 1;
            System.out.println(newId);
            Text text = service.read(newId);
            System.out.println(text.getId());

            session.setAttribute("oldText", text);
        }
        return page;
    }
}
