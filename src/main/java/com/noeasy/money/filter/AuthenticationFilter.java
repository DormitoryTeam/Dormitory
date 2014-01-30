package com.noeasy.money.filter;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.noeasy.money.service.IAuthenticationService;

public class AuthenticationFilter implements Filter {

    public final static String                 SERVICE_NAME_AUTHENTICATION_SERVICE = "authenticationService";
    public final static String                 SESSION_KEY_USER_ID                 = "USER_ID";
    private volatile Map<String, Set<Integer>> authenticationData;
    private volatile IAuthenticationService    authenticationService;



    @Override
    public void destroy() {
        setAuthenticationData(null);
        setAuthenticationService(null);
    }



    @Override
    public void doFilter(ServletRequest pRequest, ServletResponse pResponse, FilterChain pChain) throws IOException,
            ServletException {

        //
        HttpServletRequest request = (HttpServletRequest) pRequest;
        HttpServletResponse response = (HttpServletResponse) pResponse;
        String userIdStr = (String) request.getSession().getAttribute(SESSION_KEY_USER_ID);
        String servletPathInfo = request.getServletPath() + request.getPathInfo();
        Integer userId = null == userIdStr ? null : Integer.valueOf(userIdStr);
        boolean passAccess = getAuthenticationService().passAccess(userId, servletPathInfo, getAuthenticationData());
        if (passAccess) {
            pChain.doFilter(pRequest, pResponse);
        }
        response.sendRedirect("/AccessDenied.jsp");
    }



    @Override
    public void init(FilterConfig pConfig) throws ServletException {

        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(pConfig.getServletContext());

        IAuthenticationService authenticationService = context.getBean(SERVICE_NAME_AUTHENTICATION_SERVICE,
                IAuthenticationService.class);
        setAuthenticationService(authenticationService);

        Map<String, Set<Integer>> authenticationData = authenticationService.getAuthenticationData();
        setAuthenticationData(authenticationData);
    }



    public Map<String, Set<Integer>> getAuthenticationData() {
        return authenticationData;
    }



    public void setAuthenticationData(Map<String, Set<Integer>> pAuthenticationData) {
        authenticationData = pAuthenticationData;
    }



    public IAuthenticationService getAuthenticationService() {
        return authenticationService;
    }



    public void setAuthenticationService(IAuthenticationService pAuthenticationService) {
        authenticationService = pAuthenticationService;
    }

}
