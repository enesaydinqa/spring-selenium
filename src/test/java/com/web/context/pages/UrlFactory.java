package com.web.context.pages;

public enum UrlFactory
{

    BASE_URL("https://twitter.com"),
    LOGIN_PAGE(BASE_URL, "/login"),
    HOME_PAGE(BASE_URL, "/home");

    public final String pageUrl;

    UrlFactory(String pageUrl)
    {
        this.pageUrl = pageUrl;
    }

    UrlFactory(UrlFactory baseUrl, String pageUrl)
    {
        this.pageUrl = baseUrl.pageUrl + pageUrl;
    }

}
