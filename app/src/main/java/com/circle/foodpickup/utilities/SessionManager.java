package com.circle.foodpickup.utilities;

import android.content.Context;
import android.content.SharedPreferences;

import com.circle.foodpickup.models.User;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by - Prajwal W. on 22/03/24.
 * Email: prajwalwaingankar@gmail.com
 * Mobile: +917304154312
 **/
public class SessionManager {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context context;
    private int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "Circle";
    private static final String CATEGORY_SELECTED = "CATEGORY_SELECTED";
    private static final String USER_MODEL = "USER_MODEL";
    private static final String LOGGED_IN_USERNAME = "LOGGED_IN_USERNAME";
    public static final String ACCEPTED = "ACCEPTED";
    public static final String INSTAGRAM_ID = "INSTAGRAM_ID";
    public static final String YOUTUBE_ID = "YOUTUBE_ID";
    public static final String ABOUTME_DESC = "ABOUTME_DESC";

    public SessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public boolean isAccepted() {
        return pref.getBoolean(ACCEPTED, false);
    }

    public void setAccepted(Boolean accepted) {
        editor.putBoolean(ACCEPTED, accepted);
        editor.commit();
    }

    public String getLoggedInUsername() {
        return pref.getString(LOGGED_IN_USERNAME, "");
    }

    public void setLoggedInUsername(String username) {
        editor.putString(LOGGED_IN_USERNAME, username);
        editor.commit();
    }

    public String getInstagramId() {
        return pref.getString(INSTAGRAM_ID, "");
    }
    public void setInstagramId(String instagramId) {
        editor.putString(INSTAGRAM_ID, instagramId);
        editor.commit();
    }
    public String getYoutubeId() {
        return pref.getString(YOUTUBE_ID, "");
    }
    public void setYoutubeId(String youtubeId) {
        editor.putString(YOUTUBE_ID, youtubeId);
        editor.commit();
    }
    public String getAboutmeDesc() {
        return pref.getString(ABOUTME_DESC, "");
    }
    public void setAboutmeDesc(String aboutmeDesc) {
        editor.putString(ABOUTME_DESC, aboutmeDesc);
        editor.commit();
    }
    public String getCategorySelected() {
        return pref.getString(CATEGORY_SELECTED, "");
    }

    public void setCategorySelected(String categorySelected) {
        editor.putString(CATEGORY_SELECTED, categorySelected);
        editor.commit();
    }

    public User getUserModel(String key) {
        Gson gson = new Gson();
        String json = pref.getString(key, null);
        Type type = new TypeToken<User>() {}.getType();
        return gson.fromJson(json, type);
    }

    public void setUserModel(User usermodel, String key) {
        SharedPreferences.Editor editor = pref.edit();
        Gson gson = new Gson();
        String json = gson.toJson(usermodel);
        editor.putString(key, json);
        editor.apply();
    }

}
