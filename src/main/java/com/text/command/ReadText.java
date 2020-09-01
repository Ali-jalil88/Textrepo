package com.text.command;

import com.text.entities.Text;
import com.text.exception.ServiceException;
import com.text.service.Service;
import com.text.service.impl.TextService;

import javax.servlet.http.HttpServletRequest;

public class ReadText implements Command {
    private final Service<Text> service = new TextService();
    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Text text = service.read(1);
        System.out.println(text);
        return null;
    }
}
