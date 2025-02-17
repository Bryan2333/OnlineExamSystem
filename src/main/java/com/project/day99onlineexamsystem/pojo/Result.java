package com.project.day99onlineexamsystem.pojo;

import java.util.HashMap;
import java.util.Map;

// 后端处理结果实体类
public class Result extends HashMap<String, Object> {
    public interface HttpStatus {
        int SC_CONTINUE = 100;
        int SC_SWITCHING_PROTOCOLS = 101;
        int SC_PROCESSING = 102;
        int SC_OK = 200;
        int SC_CREATED = 201;
        int SC_ACCEPTED = 202;
        int SC_NON_AUTHORITATIVE_INFORMATION = 203;
        int SC_NO_CONTENT = 204;
        int SC_RESET_CONTENT = 205;
        int SC_PARTIAL_CONTENT = 206;
        int SC_MULTI_STATUS = 207;
        int SC_MULTIPLE_CHOICES = 300;
        int SC_MOVED_PERMANENTLY = 301;
        int SC_MOVED_TEMPORARILY = 302;
        int SC_SEE_OTHER = 303;
        int SC_NOT_MODIFIED = 304;
        int SC_USE_PROXY = 305;
        int SC_TEMPORARY_REDIRECT = 307;
        int SC_BAD_REQUEST = 400;
        int SC_UNAUTHORIZED = 401;
        int SC_PAYMENT_REQUIRED = 402;
        int SC_FORBIDDEN = 403;
        int SC_NOT_FOUND = 404;
        int SC_METHOD_NOT_ALLOWED = 405;
        int SC_NOT_ACCEPTABLE = 406;
        int SC_PROXY_AUTHENTICATION_REQUIRED = 407;
        int SC_REQUEST_TIMEOUT = 408;
        int SC_CONFLICT = 409;
        int SC_GONE = 410;
        int SC_LENGTH_REQUIRED = 411;
        int SC_PRECONDITION_FAILED = 412;
        int SC_REQUEST_TOO_LONG = 413;
        int SC_REQUEST_URI_TOO_LONG = 414;
        int SC_UNSUPPORTED_MEDIA_TYPE = 415;
        int SC_REQUESTED_RANGE_NOT_SATISFIABLE = 416;
        int SC_EXPECTATION_FAILED = 417;
        int SC_INSUFFICIENT_SPACE_ON_RESOURCE = 419;
        int SC_METHOD_FAILURE = 420;
        int SC_UNPROCESSABLE_ENTITY = 422;
        int SC_LOCKED = 423;
        int SC_FAILED_DEPENDENCY = 424;
        int SC_INTERNAL_SERVER_ERROR = 500;
        int SC_NOT_IMPLEMENTED = 501;
        int SC_BAD_GATEWAY = 502;
        int SC_SERVICE_UNAVAILABLE = 503;
        int SC_GATEWAY_TIMEOUT = 504;
        int SC_HTTP_VERSION_NOT_SUPPORTED = 505;
        int SC_INSUFFICIENT_STORAGE = 507;
    }

    private static final Long serialVersionUID = 1L;

    public Result() {
        put("code", HttpStatus.SC_OK);
        put("msg", "success");
    }
    public static Result error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static Result error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static Result error(int code, String msg) {
        Result r = new Result();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static Result ok(String msg) {
        Result r = new Result();
        r.put("code", HttpStatus.SC_OK);
        r.put("msg", msg);
        return r;
    }

    public static Result ok(Map<String, Object> map) {
        Result r = new Result();
        r.putAll(map);
        return r;
    }

    public static Result ok() {
        return new Result();
    }

    public Result put(String key, Object o) {
        super.put(key, o);
        return this;
    }
}
