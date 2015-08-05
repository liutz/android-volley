package com.android.volley;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;

/**
 * Indicates that the error responded with an error response.
 */
@SuppressWarnings("serial")
public class ServerError extends VolleyError {
    public ServerError(NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public ServerError() {
        super();
    }
}