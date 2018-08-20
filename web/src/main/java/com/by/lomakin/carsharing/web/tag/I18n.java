package com.by.lomakin.carsharing.web.tag;

import com.by.lomakin.carsharing.web.util.XMLResourceBundleControl;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

public class I18n extends SimpleTagSupport {

	public static final String SESSION_LOCALE_KEY = "current-locale";

	private final Locale DEFAULT_LOCALE = new Locale("en");

	private String key;

	@Override
	public void doTag() throws JspException, IOException {

		final JspContext jspContext = getJspContext();

		Locale locale = ((Locale) jspContext.findAttribute(SESSION_LOCALE_KEY));

		if (locale == null) {
			locale = DEFAULT_LOCALE;
		}

		jspContext.getOut().println(getLocalized(key, locale));
	}

	private String getLocalized(final String key, final Locale locale) {

		final HashMap<String, ResourceBundle> bundleMap = new HashMap<>();

		loadBundleIfNecessery(bundleMap, locale);
		ResourceBundle bundle = bundleMap.get(locale.getLanguage());
		return bundle.getString(key);

	}

	private void loadBundleIfNecessery(final HashMap<String, ResourceBundle> bundleMap, final Locale locale) {
		String langKey = locale.getLanguage();
		if (!bundleMap.containsKey(langKey)) {
			final ResourceBundle bundleLang = ResourceBundle.getBundle("i18n/translations", locale,
					new XMLResourceBundleControl());
			bundleMap.put(langKey, bundleLang);
		}
	}

	public void setKey(final String key) {
		this.key = key;
	}

}
