package com.text.command;

import com.text.exception.ServiceException;


import javax.servlet.http.HttpServletRequest;

public interface Command {
    Page execute(HttpServletRequest req)throws ServiceException;

}
