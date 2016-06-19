package com.soliman.weathersoliman.utils.webservice;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.soliman.weathersoliman.R;

/**
 * Created by TCIG_PC_54 on 6/16/2016.
 */

public class ViewModel implements WebServiceListener {
    private static ViewModel instance;
    protected Context context;
    protected WebServiceListener webServiceListener;
    protected boolean isProgressDialogEnabled;
    ProgressDialog mProgressDialog;

    public static ViewModel getInstance() {
        if (instance == null) {
            instance = new ViewModel();
        }
        return instance;
    }

    /**
     * to call web service
     *
     * @param context
     * @param webServiceListener      to listen to web service callbacks
     * @param isProgressDialogEnabled to enable and disable calling web service with progress dialog
     */
    public void getData(Context context, final WebServiceListener webServiceListener, boolean isProgressDialogEnabled) {
        this.context = context;
        this.webServiceListener = webServiceListener;
        this.isProgressDialogEnabled = true;
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setMessage(context.getString(R.string.loading));
        mProgressDialog.setIndeterminate(false);
        mProgressDialog.setCancelable(false);
        if (isProgressDialogEnabled)
            mProgressDialog.show();
    }

    @Override
    public void onSuccess(Object response, String apiName) {
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
    }

    @Override
    public void onError(VolleyError error, String apiName) {
        //handle web service call error
        Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();
        webServiceListener.onError(error, apiName);
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
    }

    @Override
    public void update() {
        getData(context, webServiceListener, isProgressDialogEnabled);
    }
}
