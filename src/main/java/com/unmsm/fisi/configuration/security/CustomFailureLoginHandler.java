package com.unmsm.fisi.configuration.security;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.unmsm.fisi.service.exception.LoginException;
import com.unmsm.fisi.utilitario.ConstantesExcepciones;
import com.unmsm.fisi.utilitario.ConstantesGenerales;
import com.unmsm.fisi.utilitario.StringsUtils;

@Component
public class CustomFailureLoginHandler extends SimpleUrlAuthenticationFailureHandler
{
    private @Autowired Logger logger;

    public CustomFailureLoginHandler()
    {
        super();
        this.setUseForward(false);
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException
    {
        String mensajeExcepcion = "";
        logger.error(exception.getMessage(), exception);
        if (exception.getClass().isAssignableFrom(LoginException.class))
        {
            mensajeExcepcion = exception.getMessage();
        }
        if (exception.getClass().isAssignableFrom(InternalAuthenticationServiceException.class))
        {
            mensajeExcepcion = exception.getMessage();
        }
        if (exception.getClass().isAssignableFrom(Exception.class))
        {
            mensajeExcepcion = ConstantesExcepciones.ERROR_DESCONOCIDO;
        }
        getRedirectStrategy().sendRedirect(request, response,
                StringsUtils.concatenarCadena("/login?error=true&mensajeExcepcion=",
                        URLEncoder.encode(mensajeExcepcion, ConstantesGenerales.UTF_8)));
    }
}