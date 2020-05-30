
package com.mbn.sinod.web.security;

import com.mbn.sinod.web.util.ResourceBundles;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import org.picketlink.annotations.PicketLink;
import org.picketlink.authentication.BaseAuthenticator;
import org.picketlink.credential.DefaultLoginCredentials;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.picketlink.Identity;
import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.PartitionManager;

/**
 * A simple PicketLink authenticator that will accept a hard coded
 * username/password value. The
 *
 * @PicketLink annotation is required to indicate to PicketLink that this is the
 * default Authenticator to be used.
 *
 * 
 *
 */

@PicketLink
@Named("authenticator")
@ViewAccessScoped
public class SimpleAuthenticator extends BaseAuthenticator implements Serializable {

    @Inject
    private DefaultLoginCredentials credentials;
    @Inject
    private IdentityManager identityManager;
    @Inject
    private FacesContext facesContext;
    @Inject
    private PartitionManager partitionManager;
    @Inject
    private Identity identity;

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.MESSAGES.getBundleName());
    private static final ResourceBundle CONFIG_BUNDLE = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
 

    @PostConstruct
    public void SimpleAuthenticator() {
             throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    }

    @Override
    public void authenticate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}