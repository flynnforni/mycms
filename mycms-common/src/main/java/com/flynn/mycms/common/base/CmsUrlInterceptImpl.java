package com.flynn.mycms.common.base;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

public class CmsUrlInterceptImpl implements CmsUrlIntercept {
    private final static Log log = LogFactory.getLog(CmsUrlInterceptImpl.class);
    /**
     * 重写的参数
     */
    protected Map<String, String[]> urlMaps = new HashMap<String, String[]>();
    /**
     * url rewirte到
     */
    protected String urlSeparate = "-";
    /**
     * 后缀
     */
    protected String urlSuffix = ".html";

    public void doIntercept(CmsUrl cmsUrl) {
        String path = cmsUrl.getPath();
        if (StringUtils.isNotBlank(path)) {
            if (urlMaps.containsKey(path)) {
                Object o = urlMaps.get(path);
                int start = path.lastIndexOf('.');
                int start1 = path.lastIndexOf('/');
                StringBuilder builder;

                if (start > start1) {//去掉扩展名。
                    builder = new StringBuilder(path.substring(0, start));
                } else {
                    builder = new StringBuilder(path);
                }
                if (o != null) {
                    String[] parameters = (String[]) o;
                    Map<String, Object> queryMap = cmsUrl.getQuery();
                    for (String parameter : parameters) {
                        builder.append(urlSeparate);
                        if (StringUtils.isNotEmpty(parameter)) {
                            Object o1 = queryMap.get(parameter);
                            if (o1 != null) {
                                builder.append(cmsUrl.encodeUrl(o1.toString()));
                            }
                        }
                        queryMap.remove(parameter);
                    }
                }
                builder.append(urlSuffix);
                cmsUrl.setPath(builder.toString());
            }
        }
    }

    public void setUrlMaps(Map<String, String[]> urlMaps) {
        this.urlMaps = urlMaps;
    }

    public void setUrlSeparate(String urlSeparate) {
        this.urlSeparate = urlSeparate;
    }

    public void setUrlSuffix(String urlSuffix) {
        this.urlSuffix = urlSuffix;
    }
}
