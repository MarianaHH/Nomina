/**
 *
 */
package com.mbn.sinod.web.security;

import javax.enterprise.event.Observes;
import org.picketlink.config.SecurityConfigurationBuilder;
import org.picketlink.event.SecurityConfigurationEvent;

public class HttpSecurityConfiguration {

    public void configureHttpSecurity(@Observes SecurityConfigurationEvent event) {
        SecurityConfigurationBuilder builder = event.getBuilder();
        builder
                .http()
                .allPaths()
                //.authenticateWith()
                //.form()
                //.authenticationUri("/home.xhtml")
                //.loginPage("/home.xhtml")
                .unprotected();
    }
}
