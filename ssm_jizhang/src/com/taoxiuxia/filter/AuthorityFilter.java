// 
// 
// 

package com.taoxiuxia.filter;

import javax.servlet.FilterConfig;
import java.util.HashMap;
import java.util.Map;
import com.taoxiuxia.model.User;
import javax.servlet.http.Cookie;
import com.taoxiuxia.model.SessionUser;
import java.net.URLDecoder;
import com.taoxiuxia.service.impl.UserServiceImpl;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;
import org.apache.commons.lang.ArrayUtils;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.FilterChain;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import org.slf4j.LoggerFactory;
import java.text.SimpleDateFormat;
import com.taoxiuxia.service.IUserService;
import org.slf4j.Logger;
import javax.servlet.Filter;

public class AuthorityFilter implements Filter
{
    private static final String[] static_ext;
    private static final String action_ext = "action";
    private static String absolutePath;
    private Logger logger;
    private IUserService userService;
    private final SimpleDateFormat formate;
    
    static {
        static_ext = new String[] { "js", "css", "jpg", "png", "gif", "html", "ico", "vm", "swf" };
        AuthorityFilter.absolutePath = null;
    }
    
    public AuthorityFilter() {
        this.logger = LoggerFactory.getLogger((Class)AuthorityFilter.class);
        this.formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    
    private IUserService getUserService() {
        return this.userService;
    }
    
    public void doFilter(final ServletRequest req, final ServletResponse resp, final FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest)req;
        final HttpServletResponse response = (HttpServletResponse)resp;
        final ServletContext application = request.getSession().getServletContext();
        final String req_uri = request.getRequestURI();
        final HttpSession session = request.getSession();
        final String type = req_uri.substring(req_uri.lastIndexOf(46) + 1);
        if (ArrayUtils.contains((Object[])AuthorityFilter.static_ext, (Object)type)) {
            chain.doFilter(req, resp);
            return;
        }
        if (AuthorityFilter.absolutePath == null) {
            AuthorityFilter.absolutePath = this.getRealPath(request);
        }
        if (application.getAttribute("absolutePath") == null) {
            application.setAttribute("absolutePath", (Object)AuthorityFilter.absolutePath);
        }
        Object sessionUserObj = session.getAttribute("session_user_key");
        if (sessionUserObj == null) {
            this.autoLogin(request, response);
        }
        if (!"action".equals(type)) {
            sessionUserObj = session.getAttribute("session_user_key");
            if (sessionUserObj == null) {
                response.setContentType("text/html;charset=utf-8");
                final PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<script>");
                out.println("alert('\u60a8\u7684\u767b\u5f55\u5df2\u8fc7\u671f\uff0c\u8bf7\u91cd\u65b0\u767b\u5f55')");
                out.println("parent.location.href = ('" + request.getContextPath() + "/userController/showUserLogin.action')");
                out.println("</script>");
                out.println("</html>");
                return;
            }
        }
        chain.doFilter((ServletRequest)request, resp);
    }
    
    private void autoLogin(final HttpServletRequest req, final HttpServletResponse resp) {
        final ServletContext sc = req.getSession().getServletContext();
        final XmlWebApplicationContext cxt = (XmlWebApplicationContext)WebApplicationContextUtils.getWebApplicationContext(sc);
        if (cxt != null && cxt.getBean("userService") != null && this.userService == null) {
            this.userService = (UserServiceImpl)cxt.getBean("userService");
        }
        try {
            final Cookie cookieInfo = this.getCookieByName(req, "cookie4UserInfo");
            if (cookieInfo != null) {
                final String info = URLDecoder.decode(cookieInfo.getValue(), "utf-8");
                if (info != null && !"".equals(info)) {
                    final String[] infos = info.split("\\|");
                    final IUserService userService1 = this.getUserService();
                    final User user = userService1.login(infos[0], infos[1], true);
                    if (user != null) {
                        final SessionUser loginUser = new SessionUser();
                        loginUser.setUserId(user.getId());
                        loginUser.setUserName(user.getName());
                        req.getSession().setAttribute("session_user_key", (Object)loginUser);
                        req.getSession().setAttribute("useId", (Object)user.getId());
                        this.userService.update(user);
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            this.logger.info("====> \u81ea\u52a8\u767b\u5f55\u5931\u8d25");
        }
    }
    
    private String getRealPath(final HttpServletRequest request) {
        final String port = (request.getServerPort() == 80) ? "" : (":" + request.getServerPort());
        final String realPath = "http://" + request.getServerName() + port + request.getContextPath();
        return realPath;
    }
    
    public Cookie getCookieByName(final HttpServletRequest request, final String name) {
        final Map<String, Cookie> cookieMap = this.ReadCookieMap(request);
        if (cookieMap.containsKey(name)) {
            final Cookie cookie = cookieMap.get(name);
            return cookie;
        }
        return null;
    }
    
    private Map<String, Cookie> ReadCookieMap(final HttpServletRequest request) {
        final Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        final Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Cookie[] array;
            for (int length = (array = cookies).length, i = 0; i < length; ++i) {
                final Cookie cookie = array[i];
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
    
    public void destroy() {
    }
    
    public void init(final FilterConfig config) throws ServletException {
    }
}
