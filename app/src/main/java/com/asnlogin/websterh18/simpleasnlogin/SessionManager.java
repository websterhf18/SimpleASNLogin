package com.asnlogin.websterh18.simpleasnlogin;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by websterh18 on 27/12/15.
 */
public class SessionManager {
    // LogCat tag
    private static String TAG = SessionManager.class.getSimpleName();

    // Shared Preferences
    SharedPreferences pref;

    SharedPreferences.Editor editor;
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "AndroidASNLogin";

    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";
    private String USER_NAME_TAG = "";
    private String ACCESS_TOKEN_TAG = "";

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    // put name of rest api
    public void setNameuser(String nameuser){

        editor.putString(USER_NAME_TAG, nameuser);
        editor.commit();

        //Log.d("Nombre sesion", nameuser);

    }
    public String getNameuser(){
        return pref.getString(USER_NAME_TAG, "");
    }
    //variables de sesiones
    public void setLogin(boolean isLoggedIn) {

        editor.putBoolean(KEY_IS_LOGGEDIN, isLoggedIn);

        // commit changes
        editor.commit();

        Log.d(TAG, "User login session modified!");
    }

    public boolean isLoggedIn(){
        return pref.getBoolean(KEY_IS_LOGGEDIN, false);
    }
}
