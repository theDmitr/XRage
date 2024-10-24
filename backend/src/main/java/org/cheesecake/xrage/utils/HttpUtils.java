package org.cheesecake.xrage.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.cheesecake.xrage.utils.StringUtils.isEmpty;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

public class HttpUtils {

    public static HttpServletRequest getCurrentHttpRequest(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            return ((ServletRequestAttributes)requestAttributes).getRequest();
        }
        return null;
    }

    public static String getJwtTokenFromCurrentRequest() {
        HttpServletRequest request = getCurrentHttpRequest();
        if (request == null) {
            return null;
        }
        String header = request.getHeader(AUTHORIZATION);
        return !isEmpty(header) && header.startsWith("Bearer ") ? header.substring(7) : null;
    }
}
