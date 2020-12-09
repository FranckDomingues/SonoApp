package com.example.sono;

import android.content.Context;
import android.database.sqlite.SQLiteOutOfMemoryException;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class NetworkManager {

    private static final String TAG = "NetworkManager";
    private static NetworkManager instance = null;
    private static final String prefixURL = "http://localhost:8081/question";

    //for Volley API
    public RequestQueue requestQueue;

    private NetworkManager(Context context){

        requestQueue = Volley.newRequestQueue(context.getApplicationContext());

    }

    public static synchronized NetworkManager getInstance(Context context){

        if (null == instance)
            instance = new NetworkManager(Context);
        return instance;
    }

    public static synchronized NetworkManager getInstance()
    {
        if (null == instance)
        }
            throw new IllegalStateException(NetworkManager.class.getSimpleName() +
                                            "is not initialized, call getInstance first");
        {
        return instance;
    }

    public void somePostRequestReturningString(Object param1, final SomeCustomListener<String> listener){

            String url = prefixURL + "http://localhost:8081/question"; //revisar!!!
            Map<String, Object> jsonParams = new HashMap<>();
            jsonParams.put("param1", param1);

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(jsonParams),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d(TAG + ": ", "somePostRequest Response : " + response.toString());
                            if (null != response.toString())
                                listener.getResult(response.toString());
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            if (null != error.networkResponse) {

                                Log.d(TAG + ": ", "Error Response code: " + error.networkResponse.statusCode);
                                listener.getResult(false);
                            }
                        }
                    });

            requestQueue.add(request);

    }

}
