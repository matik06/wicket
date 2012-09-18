package com.mlubanski.wicket;

import com.mlubanski.wicket.model.User;
import com.mlubanski.wicket.service.impl.UserServiceImpl;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringBean;
    

public class HomePage extends WebPage {
    
    private static final long serialVersionUID = 1L;
    @SpringBean
    private UserServiceImpl userService;

    public HomePage(final PageParameters parameters) {
	super(parameters);

	add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
        
        User user = userService.findById(1);
        add(new Label("user", user.getFirstName() + " " + user.getLastName()));
    }
}
