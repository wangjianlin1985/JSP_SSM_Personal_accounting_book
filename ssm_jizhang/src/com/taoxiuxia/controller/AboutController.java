// 
// 
// 

package com.taoxiuxia.controller;

import com.taoxiuxia.model.SessionUser;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/aboutController" })
public class AboutController
{
    @RequestMapping({ "/showAbout" })
    public String showBorrows(final Model model, final HttpSession session) {
        final SessionUser sessionUser = (SessionUser)session.getAttribute("session_user_key");
        model.addAttribute("sessionUser", (Object)sessionUser);
        return "pages/about";
    }
}
