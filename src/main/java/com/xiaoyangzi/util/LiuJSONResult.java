package com.xiaoyangzi.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * 自定义响应数据结构
 * 这个类是提供给门户，IOS，安卓，微信商城用的
 * 门户接收此类数据后需要使用本类的方法转换成对应的数据类型格式（类，或list）
 * 其他自行处理
 * 200：表示成功
 * 500：表示错误，错误信息在msg字段中
 * 501：bean验证错误，不管多少个错误都以map形式返回
 * 502：拦截器拦截到用户token出错
 * 555：异常抛出信息
 * @Author: liuyang
 * @Date: 20180421 21:20
 */
public class LiuJSONResult {
    //定义Jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();
    //响应业务状态
    private Integer status;
    //响应消息
    private String msg;
    //响应中的数据
    private Object data;

    private String ok; //不使用

    public static LiuJSONResult build(Integer status, String msg, Object data) {
        return new LiuJSONResult(status, msg, data);
    }

    public static LiuJSONResult ok(Object data) {
        return new LiuJSONResult(data);
    }

    public static LiuJSONResult ok() {
        return new LiuJSONResult(null);
    }

    public static LiuJSONResult errorMsg(String msg){
        return new LiuJSONResult(500, msg, null);
    }

    public static LiuJSONResult errorMap(Object data) {
        return new LiuJSONResult(501, "error", data);
    }

    public static LiuJSONResult errorTokenMsg(String msg) {
        return new LiuJSONResult(555, msg, null);
    }

    public LiuJSONResult() {
    }

    public LiuJSONResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public LiuJSONResult(Integer status) {
        this.status = status;
    }

    public LiuJSONResult(Object data) {
        this.status = 200;
        this.msg = "ok";
        this.data = data;
    }

    public boolean isOk() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    /**
     * 将json结果集转换为LiuJsonResult对象，需要转换的对象是一个类
     * @param jsonData
     * @param clazz
     * @return
     */
    public static LiuJSONResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, LiuJSONResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isObject()) {
                obj = MAPPER.readValue(data.traverse(), clazz);
            } else if (data.isTextual()) {
                obj = MAPPER.readValue(data.asText(), clazz);
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * 没有Object对象的转换
     * @param json
     * @return
     */
    public static LiuJSONResult format(String json) {
        try {
            return MAPPER.readValue(json, LiuJSONResult.class);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Object是集合转化，需要转换的对象是一个List
     * @param jsonData
     * @param clazz
     * @return
     */
    public static LiuJSONResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(), MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (IOException e) {
            return null;
        }
    }
}
