package com.flynn.mycms.common.base;

/**
 * url��Ⱦ������ <br/>
 * Date: 2010-7-7 <br/>
 * Time: 16:40:39 <br/>
 */
public interface CmsUrlIntercept {

    /**
     * ������Ⱦ����
     * @param jdUrl ��Ҫ��Ⱦ������
     */
    void doIntercept(CmsUrl cmsUrl);
}
