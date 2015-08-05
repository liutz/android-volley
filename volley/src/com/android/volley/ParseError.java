package com.android.volley;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;

/**
 * Indicates that the server's response could not be parsed.
 */
@SuppressWarnings("serial")
public class ParseError extends VolleyError {
    public ParseError() { }

    public ParseError(NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public ParseError(Throwable cause) {
        super(cause);
    }
}
