
package com.example.android.newsapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * An {@link ArticleAdapter} knows how to create a list item layout for each article
 * in the data source (a list of {@link Article} objects).
 * <p>
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class ArticleAdapter extends ArrayAdapter<Article> {

    /**
     * Constructs a new {@link ArticleAdapter}.
     *
     * @param context  of the app
     * @param articles is the list of articles, which is the data source of the adapter
     */
    public ArticleAdapter(Context context, List<Article> articles) {
        super(context, 0, articles);
    }

    /**
     * Returns a list item view that displays information about the articles at the given position
     * in the list of articles.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Find the article at the given position in the list of articles
        Article currentArticle = getItem(position);

        String webtitle = currentArticle.getTitle();
        String section = currentArticle.getSection();
        String authorname = currentArticle.getAuthorname();
        String thumbnail = currentArticle.getThumbnail();

        // Find the ImageView with view ID thumbnail
        ImageView thumbnailView = (ImageView) listItemView.findViewById(R.id.thumbnail);
        // Display the thumbnail that is provided via a URL making use of the Glide library
        Glide
                .with(getContext())
                .load(thumbnail)
                .into(thumbnailView);

        // Find the TextView with view ID location
        TextView webtitleView = (TextView) listItemView.findViewById(R.id.webtitle);
        // Display the location of the current article in that TextView
        webtitleView.setText(webtitle);

        // Find the TextView with view ID location offset
        TextView sectionView = (TextView) listItemView.findViewById(R.id.section);
        // Display the location offset of the current article in that TextView
        sectionView.setText(section);

        // Find the TextView with view ID location offset
        TextView authorView = (TextView) listItemView.findViewById(R.id.author);
        // Display the location offset of the current article in that TextView
        authorView.setText(authorname);

        // Find the TextView with view ID date
        TextView dateView = listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(currentArticle.getDatePublished());
        // Display the date of the current news item in that TextView
        dateView.setText(formattedDate);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(String dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");
        try {
            Date date = dateFormat.parse(dateObject);
            SimpleDateFormat trimmedDateFormat = new SimpleDateFormat("MMM dd, yyyy");
            dateObject = trimmedDateFormat.format(date);
            return dateObject;
        } catch (ParseException e) {
            Log.v("NewsAdapter", " " + e);
            return null;
        }
    }

}