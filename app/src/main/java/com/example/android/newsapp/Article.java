package com.example.android.newsapp;

public class Article {

    private String mTitle;

    private String mSection;

    private String mWebUrl;

    private String mDatePublished;

    private String mAuthorName;

    private String mThumbnail;


    // Create a news article object
    public Article(String vTitle, String vSection, String vWebUrl, String vDatePublished, String vAuthorname, String vThumbnail) {
        mTitle = vTitle;
        mSection = vSection;
        mWebUrl = vWebUrl;
        mDatePublished = vDatePublished;
        mAuthorName = vAuthorname;
        mThumbnail = vThumbnail;
    }

    //get the title of the news article
    public String getTitle() {
        return mTitle;
    }

    //get the section of the news article
    public String getSection() {
        return mSection;
    }

    //get the web URL of the news article
    public String getWebUrl() {
        return mWebUrl;
    }

    //get the date of the news article
    public String getDatePublished() {
        return mDatePublished;
    }

    //get the author of the news article
    public String getAuthorname() {
        return mAuthorName;
    }

    //get the thumbnail URL of the article
    public String getThumbnail() {
        return mThumbnail;
    }
}

