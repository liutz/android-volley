package com.android.volley.ext.net;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;

/**
 * 封装JSON数组对象请求
 */
public class JSONArrayRequest extends Request<JSONArray> {
	private Listener<JSONArray> listener;
	private Map<String, String> params;

	public JSONArrayRequest(String url, Map<String, String> params, Listener<JSONArray> reponseListener, ErrorListener errorListener) {
		super(Method.GET, url, errorListener);
		this.listener = reponseListener;
		this.params = params;
	}

	public JSONArrayRequest(int method, String url, Map<String, String> params, Listener<JSONArray> reponseListener, ErrorListener errorListener) {
		super(method, url, errorListener);
		this.listener = reponseListener;
		this.params = params;
	}

	/**
	 * POST请求设置参数
	 */
	protected Map<String, String> getParams() throws com.android.volley.AuthFailureError {
		return params;
	};

	@Override
	protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
		try {
			String jsonString = getRealString(response.data);
			return Response.success(new JSONArray(jsonString), HttpHeaderParser.parseCacheHeaders(response));
		} catch (UnsupportedEncodingException e) {
			return Response.error(new ParseError(e));
		} catch (JSONException je) {
			return Response.error(new ParseError(je));
		} catch (IOException e) {
			return Response.error(new ParseError(e));
		}
	}

	@Override
	protected void deliverResponse(JSONArray response) {
		listener.onResponse(response);
	}

	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		// 支持gzip压缩
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Charset", "UTF-8");
		// headers.put("Content-Type", "*/*");
		headers.put("Accept-Encoding", "gzip,deflate");
		return headers;
	}
}
