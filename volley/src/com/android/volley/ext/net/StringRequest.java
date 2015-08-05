package com.android.volley.ext.net;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
/**
 *	封装字符串请求
 */
public class StringRequest extends Request<String> {

	private Listener<String> listener;
	private Map<String, String> params;

	public StringRequest(String url, Listener<String> reponseListener, ErrorListener errorListener) {
		super(Method.GET, url, errorListener);
		this.listener = reponseListener;
	}

	public StringRequest(int method, String url, Map<String, String> params,Listener<String> reponseListener,
			ErrorListener errorListener) throws Exception {
		super(method, url, errorListener);
		this.params = params;
		this.listener = reponseListener;
	}
	
	/**
	 * POST请求设置参数
	 */
	protected Map<String, String> getParams() throws com.android.volley.AuthFailureError {
		return params;
	};

	@Override
	protected Response<String> parseNetworkResponse(NetworkResponse response) {
		try {
			String jsonString = null;
			if(response.data.length>2){
				jsonString = getRealString(response.data);
			}else{
				jsonString = new String(response.data, "UTF-8");
			}
			return Response.success(jsonString, HttpHeaderParser.parseCacheHeaders(response));
		} catch (UnsupportedEncodingException e) {
			return Response.error(new ParseError(e));
		} catch (IOException e) {
			return Response.error(new ParseError(e));
		} 
	}
	private Map<String, String> headers;
	public void setHeaders(Map<String, String> headers){
		this.headers = headers;
	}
	
	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		if(headers == null){
			headers = new HashMap<String, String>(); 
		}
		// 支持gzip压缩		
		headers.put("Charset", "UTF-8");  
//		headers.put("Content-Type", "*/*");  
		headers.put("Accept-Encoding", "gzip,deflate");
		return headers;
	}

	@Override
	protected void deliverResponse(String response) {
		listener.onResponse(response);
	}
}
