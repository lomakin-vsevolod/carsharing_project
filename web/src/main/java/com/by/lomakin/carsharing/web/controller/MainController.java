package com.by.lomakin.carsharing.web.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.by.lomakin.carsharing.web.tag.I18n;

@Controller
@RequestMapping(value = "/")
public class MainController {

    private static final Locale LOCALE_RU = new Locale("ru");
    private static final Locale LOCALE_EN = new Locale("en");

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(final HttpServletRequest req,
                        @RequestParam(name = "language", required = false) final String lang) {
        if (lang != null) {
            if ("ru".equals(lang)) {
                req.getSession().setAttribute(I18n.SESSION_LOCALE_KEY, LOCALE_RU);
            } else {
                req.getSession().setAttribute(I18n.SESSION_LOCALE_KEY, LOCALE_EN);
            }
        }
        return "index";
    }
}