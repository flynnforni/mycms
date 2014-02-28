package com.flynn.mycms.common.base;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * ��ַ��������<br>
 * ��֤����ε��ú�tostring������ֵ��ԭ<br>
 * ��Ҫ��֤�������������<br>
 * User: yangsiyong@360buy.com<br>
 * Date: 2010-5-5<br>
 * Time: 10:13:18<br>
 * �޸����ڣ�2010-7-2 �޸��ˣ���˼��
 */
public class CmsUrl implements Cloneable {
    private final static Log log = LogFactory.getLog(CmsUrl.class);
    /**
     * ��֤���û���
     */
    private String username;
    /**
     * ��֤������
     */
    private String password;
    /**
     * Э��
     */
    private String protocol = "http";
    /**
     * ����
     */
    private String host;
    /**
     * �˿�
     */
    private int port = -1;

    /**
     * ·��
     */
    private String path;
    /**
     * ������·��
     */
    private String contextPath;

    private boolean reset;
    /**
     * �ǲ��ǹ���null�Ϳմ�
     */
    private boolean filter = true;
    /**
     * ��ѯ����
     */
    private Map<String, Object> query = new LinkedHashMap<String, Object>();

    /**
     * ����һ��
     */
    private CmsUrl CmsUrl;
    /**
     * �Զ�����Ⱦ��
     */
    private CmsUrlIntercept intercept;
    private String charsetName = "gbk";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public CmsUrl addQueryData(String name, String value) {
        query.put(name, value);
        return this;
    }

    /**
     * ֧��list��list�����ɶ������ <br/>
     * ֧�� addQueryData(key,Object[])����������£�key��ͬһ����value�����ɶ��<br/>
     * ֧��addQueryData(key,Map)����������£�ָ����key��Ч��key����map�еġ�<br/>
     * addQueryData(key,List)����������£�key��ͬһ����value�����ɶ������vm�п���������.addQueryData(key,[value1,value2])<br/>
     *
     * @param name
     * @param value
     * @return
     */
    public CmsUrl addQueryData(String name, Object value) {
        query.put(name, value);
        return this;
    }

    public CmsUrl addQueryData(String name, int value) {
        query.put(name, value);
        return this;
    }

    public CmsUrl addQueryData(String name, long value) {
        query.put(name, value);
        return this;
    }

    public CmsUrl addQueryData(String name, float value) {
        query.put(name, value);
        return this;
    }

    public CmsUrl getTarget(String target) {
        this.path = target;
        return this;
    }

    /**
     * ��Ⱦurl�����Ḵλurl��ֵ��
     * ֧��List Map ���ݺ���ͨ����
     *
     * @return
     */
    public String render() {
        CmsUrl url = null;
        try {
            if (intercept != null) {
                url = new CmsUrl();
                url.query = new LinkedHashMap<String, Object>();
                url.query.putAll(this.query);
                setCmsUrlValue(url, this);
            }
            return doIt();
        } finally {
            if (intercept != null && url!=null) {
                setCmsUrlValue(this, url);
                this.query.putAll(url.query);
            }
        }
    }

    private String doIt() {
        String str;
        URL url;
        try {
            if (intercept != null) {
                intercept.doIntercept(this);
            }
            //ͨ��url�����죬
            String path = prefixPath(this.contextPath, this.path);
            //path = this.path == null ? "/" : this.path;
            url = new URL(protocol, host, port, path);
            if (url.getDefaultPort() == url.getPort()) {
                url = new URL(protocol, host, -1, path);
            }
            str = url.toString();
        } catch (Exception e) {
            str = "/";
        }

        StringBuilder builder = new StringBuilder(str);
        if (!query.isEmpty()) {
            for (String key : query.keySet()) {
                Object obj = query.get(key);
                if (obj instanceof List) {
                    List list = (List) obj;
                    for (Object o : list) {
                        setValue(builder, key, o);
                    }
                } else if (obj instanceof Map) {
                    Map map = (Map) obj;
                    for (Object o : map.keySet()) {
                        setValue(builder, o == null ? "" : o.toString(), map.get(o));
                    }
                } else {
                    if (obj != null && obj.getClass().isArray()) {
                        Object[] arrays = (Object[]) obj;
                        for (Object o : arrays) {
                            setValue(builder, key, o);
                        }
                    } else {
                        setValue(builder, key, obj);
                    }
                }
            }
            return builder.replace(str.length(), str.length() + 1, "?").toString();
        } else {
            return str;
        }
//        return builder.toString();
    }

    /**
     * ����urlǰ׺
     *
     * @param contextPath
     * @param path
     * @return
     */
    public String prefixPath(String contextPath, String path) {
        String returnPath;
        if (path == null || contextPath == null) {
            if (path == null && contextPath == null) {
                returnPath = "/";
            } else if (contextPath == null) {
                returnPath = path;
            } else {
                returnPath = contextPath;
            }
        } else {
            if (contextPath.endsWith("/") && path.startsWith("/")) {
                returnPath = contextPath + path.substring(1);
            } else {
                returnPath = contextPath + path;
            }
        }
        return returnPath;
    }

    public void setValue(StringBuilder builder, String key, Object o) {
        String value = o == null ? "" : o.toString();
        if (value.length() > 0) {
            String str1;
            str1 = encodeUrl(value);
            builder.append("&").append(key).append("=").append(str1);
        } else {
            if (!filter) {
                builder.append("&").append(key).append("=");
            }
        }
    }

    /**
     * ���յ�ǰ�ı��뷽ʽ������url
     *
     * @param value ָ����url
     * @return ���������϶����뷽ʽ�����ڣ��򷵻ص�ǰֵ
     */
    public String encodeUrl(String value) {
        String str1;
        if (StringUtils.isNotBlank(charsetName)) {
            try {
                str1 = URLEncoder.encode(value, charsetName);
            } catch (UnsupportedEncodingException e) {
                str1 = value;
            }
        } else {
            str1 = URLEncoder.encode(value);
        }
        return str1;
    }

    /**
     * ��Ⱦurl���Ḵλurl�����ֵ����ʼ״̬
     *
     * @return
     */
    public String toString() {
        String s = render();
        if (!reset) {//����copy propertiesʱ������ѭ��
            reset = true;
            reset();
        }
        reset = false;
        return s;
    }

    /**
     * ��λ
     */
    public void reset() {
        try {
            reset = true;
            query.clear();
            query.putAll(CmsUrl.query);
            CmsUrl.setCmsUrlValue(this, CmsUrl);

        } catch (Exception e) {
            log.error("copyProperties error!", e);
        }
    }

    /**
     * ��url�����path����ӵ�contextpath�С�����Ҳ�����query map�С�
     *
     * @param url
     * @throws MalformedURLException
     */
    public void setUrl(String url) throws MalformedURLException {
        URL a = new URL(url);
        this.protocol = a.getProtocol();
        this.host = a.getHost();
        this.port = a.getPort();
        this.contextPath = a.getPath();
        String queryString = a.getQuery();
        if (!StringUtils.isEmpty(queryString)) {
            query.putAll(getQueryMap(queryString));
        }
    }

    private Map<String, Object> getQueryMap(String query) {
        String[] params = query.split("&");
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        for (String param : params) {
            String[] strings = param.split("=");
            String name = strings[0];
            String value = null;
            if (strings.length > 1) {
                value = strings[1];
            }
            map.put(name, value);
        }
        return map;
    }

    public CmsUrl clone() {
        CmsUrl clone = new CmsUrl();
        setCmsUrlValue(clone, this);
        clone.query = new LinkedHashMap<String, Object>();
        clone.query.putAll(query);
        return clone;
    }

    private void setCmsUrlValue(CmsUrl dest, CmsUrl src) {
        dest.username = src.username;
        dest.password = src.password;
        dest.protocol = src.protocol;
        dest.host = src.host;
        dest.port = src.port;
        dest.contextPath = src.contextPath;
        dest.path = src.path;
        dest.intercept = src.intercept;

    }

    public void cleanQueryMap() {
        if (this.query != null && !this.query.isEmpty()) {
            this.query.clear();
        }
    }

    public void setCharsetName(String charsetName) {
        this.charsetName = charsetName;
    }

    public String getCharsetName() {
        return charsetName;
    }

    public boolean isFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public void setCmsUrl(CmsUrl CmsUrl) {
        this.CmsUrl = CmsUrl;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public void setIntercept(CmsUrlIntercept intercept) {
        this.intercept = intercept;
    }

    public void setQuery(Map<String, Object> query) {
        this.query = query;
    }

    public Map<String, Object> getQuery() {
        return query;
    }
}
