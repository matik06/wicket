package com.mlubanski.wicket;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see com.mycompany.Start#main(String[])
 */
public class WicketApplication extends WebApplication {

    private static final String DEFAULT_ENCODING = "UTF-8";
    
    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<HomePage> getHomePage()
    {
            return HomePage.class;
    }

    /**
     * @see org.apache.wicket.Application#init()
     */
    @Override
    public void init()
    {
        super.init();
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));

        getMarkupSettings().setDefaultMarkupEncoding(DEFAULT_ENCODING);
        getRequestCycleSettings().setResponseRequestEncoding(DEFAULT_ENCODING);        
    }
}
