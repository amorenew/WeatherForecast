package com.soliman.weathersoliman.utils.webservice;


import android.content.Context;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sabouelsouod on 8/25/2015.
 */
public class VolleyRequestManager {
    private static int RESULT_LOAD_IMG = 1;
    private static VolleyRequestManager instance;
    private String tag_json_arry = "jarray_req";
    private String tag_json_obj = "jobj_req";
    private String tag_str_obj = "strobj_req";
    private Context context;

    private VolleyRequestManager(Context context) {
        this.context = context;
    }

    public static VolleyRequestManager getInstance(Context context) {
        if (instance == null) {
            instance = new VolleyRequestManager(context);
        }
        return instance;
    }

    /**
     * request json object
     *
     * @param apiName        web service name
     * @param requestType    type of request Request.Method.POST or Request.Method.GET
     * @param volleyListener listen to web service call backs
     * @param webServiceUrl  web service url
     * @param param          parameters of web service request
     */
    public void pullJsonObject(final String apiName, int requestType, final VolleyListener volleyListener, String webServiceUrl, final Map<String, String> param) {
        int MethodType;
        Log.d(this.getClass().getSimpleName(), webServiceUrl);
        if (param != null) {
            for (Map.Entry<String, String> entry : param.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                Log.d(this.getClass().getSimpleName(), "Key:" + key + " Value:" + value);
            }
        }
        if (requestType == Request.Method.POST)
            MethodType = Request.Method.POST;
        else
            MethodType = Request.Method.GET;

        JSONObject objectParams;
        if (param != null) {
            objectParams = new JSONObject(param);
        } else {
            objectParams = new JSONObject();
        }

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(MethodType,
                webServiceUrl, objectParams,
                new com.android.volley.Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("onResponse", "ApiName: " + apiName);
                        Log.d("onResponse", "Response: " + response.toString());
                        volleyListener.onJsonResponse(response, apiName);

                    }
                }, new com.android.volley.Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("onErrorResponse", "ApiName: " + apiName);
                Log.d("onErrorResponse", "VolleyError: " + error.getMessage());

                volleyListener.onError(error, apiName);
                NetworkResponse response = error.networkResponse;
                if (error instanceof ServerError && response != null) {
                    try {
                        String res = new String(response.data,
                                HttpHeaderParser.parseCharset(response.headers, "utf-8"));
                        Toast.makeText(context, "Service Error: " + res, Toast.LENGTH_LONG).show();
                        Log.d("onErrorResponse", "Service Error: " + res);
                        // Now you can use any deserializer to make sense of data
                        JSONObject obj = new JSONObject(res);
                    } catch (UnsupportedEncodingException e1) {
                        // Couldn't properly decode data to string
                        e1.printStackTrace();
                    } catch (JSONException e2) {
                        // returned data is not JSONObject?
                        e2.printStackTrace();
                    }
                }
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put(
                        "Authorization",
                        String.format("Basic %s", Base64.encodeToString(
                                String.format("%s:%s", "emx", "emx@2016").getBytes(), Base64.DEFAULT)));
                return params;
            }

            @Override
            protected String getParamsEncoding() {
                return "utf-8";
            }
            /*
             * Passing some request headers
             */
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                HashMap<String, String> headers = new HashMap<String, String>();
//                 headers.put("Content-Type", "application/x-www-form-urlencoded");
//                // headers.put("Content-Type", "application/json");
//                //headers.put("Content-Type", "application/json; charset=utf-8");
//
//
//                return headers;
//            }

//            @Override
//            protected Map<String, String> getParams() {
//                Map<String, String> params = param;
//                return params;
//            }

        };
        int socketTimeout = 60000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        jsonObjReq.setRetryPolicy(policy);

        // Adding request to request queue
        VolleyController.getInstance(context).addToRequestQueue(jsonObjReq,
                tag_json_obj);
    }

    /**
     * request json String
     *
     * @param apiName        web service name
     * @param requestType    type of request Request.Method.POST or Request.Method.GET
     * @param volleyListener listen to web service call backs
     * @param webServiceUrl  web service url
     * @param param          parameters of web service request
     */
    public void pullJsonString(final String apiName, int requestType, final VolleyListener volleyListener, String webServiceUrl, final Map<String, String> param) {
        int MethodType;
        Log.d(this.getClass().getSimpleName(), webServiceUrl);
        if (param != null) {
            for (Map.Entry<String, String> entry : param.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                Log.d(this.getClass().getSimpleName(), "Key:" + key + " Value:" + value);
            }
        }
        if (requestType == Request.Method.POST)
            MethodType = Request.Method.POST;
        else
            MethodType = Request.Method.GET;

        JSONObject objectParams = null;
        if (param != null) {
            objectParams = new JSONObject(param);
        } else {
            objectParams = new JSONObject();
        }

        StringRequest jsonObjReq = new StringRequest(MethodType,
                webServiceUrl,
                new com.android.volley.Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Log.d("onResponse", "ApiName: " + apiName);
                        Log.d("onResponse", "Response: " + response.toString());
                        volleyListener.onJsonResponse(response, apiName);

                    }
                }, new com.android.volley.Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("onErrorResponse", "ApiName: " + apiName);
                Log.d("onErrorResponse", "VolleyError: " + error.getMessage());

                volleyListener.onError(error, apiName);
                NetworkResponse response = error.networkResponse;
                if (error instanceof ServerError && response != null) {
                    try {
                        String res = new String(response.data,
                                HttpHeaderParser.parseCharset(response.headers, "utf-8"));
                        Log.d("onErrorResponse", "Service Error: " + res);
                        Toast.makeText(context, "Service Error: " + res, Toast.LENGTH_LONG).show();
                        // Now you can use any deserializer to make sense of data
                        JSONObject obj = new JSONObject(res);
                    } catch (UnsupportedEncodingException e1) {
                        // Couldn't properly decode data to string
                        e1.printStackTrace();
                    } catch (JSONException e2) {
                        // returned data is not JSONObject?
                        e2.printStackTrace();
                    }
                }
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            protected String getParamsEncoding() {
                return "utf-8";
            }
            /*
             * Passing some request headers
             */
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                HashMap<String, String> headers = new HashMap<String, String>();
//                 headers.put("Content-Type", "application/x-www-form-urlencoded");
//                // headers.put("Content-Type", "application/json");
//                //headers.put("Content-Type", "application/json; charset=utf-8");
//
//
//                return headers;
//            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (param == null) {
                    return super.getParams();
                } else {
                    return param;
                }
            }
        };
        int socketTimeout = 60000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        jsonObjReq.setRetryPolicy(policy);

        // Adding request to request queue
        VolleyController.getInstance(context).addToRequestQueue(jsonObjReq,
                tag_str_obj);
    }


    /**
     * request json Array
     *
     * @param apiName        web service name
     * @param requestType    type of request Request.Method.POST or Request.Method.GET
     * @param volleyListener listen to web service call backs
     * @param webServiceUrl  web service url
     * @param param          parameters of web service request
     */
    public void pullJsonArray(final String apiName, int requestType, final VolleyListener volleyListener, String webServiceUrl, final Map<String, String> param) {
        int MethodType;

        if (requestType == Request.Method.POST)
            MethodType = Request.Method.POST;
        else
            MethodType = Request.Method.GET;

        JSONArray objectParams = new JSONArray();

        JsonArrayRequest jsonObjReq = new JsonArrayRequest(MethodType,
                webServiceUrl, objectParams,
                new com.android.volley.Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("onResponse", "ApiName: " + apiName);
                        Log.d("onResponse", "Response: " + response.toString());
                        volleyListener.onJsonResponse(response, apiName);

                    }
                }, new com.android.volley.Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("onErrorResponse", "ApiName: " + apiName);
                Log.d("onErrorResponse", "VolleyError: " + error.getMessage());

                volleyListener.onError(error, apiName);
                NetworkResponse response = error.networkResponse;
                if (error instanceof ServerError && response != null) {
                    try {
                        String res = new String(response.data,
                                HttpHeaderParser.parseCharset(response.headers, "utf-8"));
                        Log.d("onErrorResponse", "Service Error: " + res);
                        Toast.makeText(context, "Service Error: " + res, Toast.LENGTH_LONG).show();
                        // Now you can use any deserializer to make sense of data
                        JSONObject obj = new JSONObject(res);
                    } catch (UnsupportedEncodingException e1) {
                        // Couldn't properly decode data to string
                        e1.printStackTrace();
                    } catch (JSONException e2) {
                        // returned data is not JSONObject?
                        e2.printStackTrace();
                    }
                }
            }
        }) {
            /*
             * Passing some request headers
             */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                // headers.put("Content-Type", "application/x-www-form-urlencoded");
                // headers.put("Content-Type", "application/json");
                // headers.put("Content-Type", "application/json; charset=utf-8");


                return headers;
            }

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = param;
                return params;
            }

        };
        int socketTimeout = 60000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        jsonObjReq.setRetryPolicy(policy);

        // Adding request to request queue
        VolleyController.getInstance(context).addToRequestQueue(jsonObjReq,
                tag_json_arry);
    }
  /*  public void pullImage(final ImageView imageView, String urlImage) {
        ImageLoader imageLoader = VolleyController.getInstance(context).getImageLoader();


        // Loading image with placeholder and error image
        imageLoader.get(urlImage, new ImageLoader.ImageListener() {

            public void onErrorResponse(VolleyError arg0) {
                imageView.setAnimation(null);

                imageView.setImageResource(R.drawable.error_image); // set an error image if the download fails
            }

            public void onResponse(ImageLoader.ImageContainer response, boolean arg1) {
                if (response.getBitmap() != null) {
                    imageView.setAnimation(null);

                    imageView.setImageBitmap(response.getBitmap());
                    Bitmap original = response.getBitmap();
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    original.compress(Bitmap.CompressFormat.JPEG, 30, out);
                    Bitmap decoded = BitmapFactory.decodeStream(new ByteArrayInputStream(out.toByteArray()));

                    Log.e("Original   dimensions", original.getDensity() + " " + original.getHeight());
                    Log.e("Compressed dimensions", decoded.getDensity() + " " + decoded.getHeight());
                    imageView.setImageBitmap(decoded);

                } else {

                    RotateAnimation anim = new RotateAnimation(0f, 358f, 50f, 50f);
                    anim.setInterpolator(new LinearInterpolator());
                    anim.setRepeatCount(Animation.INFINITE);
                    anim.setDuration(1000);

                    imageView.setImageResource(R.drawable.loading_image);
                    imageView.startAnimation(anim);

                }
            }
        });


        Cache cache = VolleyController.getInstance(context).getRequestQueue().getCache();
        Cache.Entry entry = cache.get(urlImage);
        if (entry != null) {
            try {
                String data = new String(entry.data, "UTF-8");
                // handle data, like converting it to xml, json, bitmap etc.,
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            // cach ed response doesn't exists. Make a network call here
        }
    }*/

    /**
     * API call for upload selected image from gallery to the server
     */
//    public void uploadImage(String url,ErrorListener errorListener,Listener listener,File imageFile) {
//        RequestQueue mQueue = VolleyController.getInstance(context).getRequestQueue();
//        PhotoMultipartRequest imageUploadReq = new PhotoMultipartRequest(url, errorListener, listener, imageFile);
//        mQueue.add(imageUploadReq);
//    }
    public void uploadImage(final String apiName, String requestType, final VolleyListener volleyListener, String webServiceUrl, final Map<String, String> param) {
        int MethodType;

        if (requestType.equalsIgnoreCase("post"))
            MethodType = Request.Method.POST;
        else
            MethodType = Request.Method.GET;


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                webServiceUrl, new JSONObject(param),
                new com.android.volley.Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        volleyListener.onJsonResponse(response, apiName);

                    }
                }, new com.android.volley.Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                volleyListener.onError(error, apiName);


            }
        }) {
            /*
             * Passing some request headers
             */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }

        };

        // Adding request to request queue
        VolleyController.getInstance(context).addToRequestQueue(jsonObjReq,
                tag_json_obj);

    }
}
