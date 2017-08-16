package com.slamgig.android.utilities;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.slamgig.android.R;
import com.slamgig.android.model.EntertainerType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adaobifrank on 8/16/17.
 */

public class DataUtil {

    public static ArrayList<EntertainerType> readEntertainerTypeFromResources(Context context )
            throws IOException, JSONException {
        StringBuilder builder = new StringBuilder();
        InputStream in = context.getResources().openRawResource(R.raw.data);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }

        //Parse resource into key/values
        final String rawJson = builder.toString();

        JSONObject allDataObj = new JSONObject(rawJson);
        JSONArray entertainerTypeObj = allDataObj.getJSONArray("entertainer_type");

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<EntertainerType>>(){}.getType();
        ArrayList<EntertainerType> entertainerTypeArrayList = gson.fromJson(entertainerTypeObj.toString(), type);
        return entertainerTypeArrayList;
    }
}
