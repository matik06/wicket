/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlubanski.wicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.wicket.extensions.ajax.markup.html.autocomplete.AutoCompleteTextField;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.string.Strings;

/**
 *
 * @author mlubanski
 */
public final class Login extends Panel {

    public Login(String id) {
        super(id);
        add(new Label("title","I am a reusable component!"));
        add(getAutoCompleteTextField());
    }

    public AutoCompleteTextField getAutoCompleteTextField() {
        final AutoCompleteTextField field = new AutoCompleteTextField("countries", new Model("")) {
            @Override
            protected Iterator getChoices(String input) {
                if (Strings.isEmpty(input)) {
                    return Collections.EMPTY_LIST.iterator();
                }
                List choices = new ArrayList(10);
                Locale[] locales = Locale.getAvailableLocales();
                for (int i = 0; i < locales.length; i++) {
                    final Locale locale = locales[i];
                    final String country = locale.getDisplayCountry();
                    if (country.toUpperCase().startsWith(input.toUpperCase())) {
                        choices.add(country);
                        if (choices.size() == 10) {
                            break;
                        }
                    }
                }
                return choices.iterator();
            }
        };
        return field;
    }
}
