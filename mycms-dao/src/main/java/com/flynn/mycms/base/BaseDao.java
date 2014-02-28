package com.flynn.mycms.base;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseDao extends SqlMapClientTemplate {
    public final static Logger log = LogManager.getLogger(BaseDao.class);

    /**
     * ��Ҫ��������1+n�Ĳ�ѯ�����ڲ�ѯѧ���б�ʱ��Ҫ�õ�ѧ���İ�������Ϣ��<br/>
     * �������left join�ķ�ʽ����Ȼ�ᵼ�´�db��web�����������󡣰����α�����join������<br/>
     * ����õ�ѧ���б����ȥһ������ѯ��������Ϣ����Ȼ�ᵼ��1+n�Ĳ�ѯ<br/>
     * �����˼���ǣ��Ȳ�ѧ���б�Ȼ���ٰ�ѧ����Ϣ�еİ����ε�idƴװ���ַ�������in�ķ�ʽ��ѯ(��Ȼ�и���Ч�ķ�ʽ)<br/>
     * �õ��������б����һ��������ѧ����list<br/>
     * <p/>
     * ��ѯ���ϣ��������ü����е����Զ���<br/>
     *
     * @param statementName      ��ѯ�ļ�������
     * @param getFieldName       ��ȡ��ID
     * @param setFieldname       ��Ҫ���õĶ���
     * @param mergeFieldKeyName  �����ϵĶ�Ӧ����
     * @param mergeStatementName ��ѯ�����ϵ�sqlmap��id
     * @return �������Եļ���
     * @throws DataAccessException when
     */
    public List queryForListMerge(String statementName, String getFieldName, String setFieldname, String mergeFieldKeyName, String mergeStatementName) throws DataAccessException {
        return queryForListMerge(statementName, null, getFieldName, setFieldname, mergeFieldKeyName, mergeStatementName);
    }


    /**
     * @see #queryForListMerge(String, Object, String, String, String, String)
     */
    public List queryForListMerge(String statementName, Object parameterObject, String getFieldName, String setFieldname, String mergeFieldKeyName, String mergeStatementName) throws DataAccessException {
        List list = queryForList(statementName, parameterObject); //��ѯ�Ӽ���
        merge(list, getFieldName, setFieldname, mergeFieldKeyName, mergeStatementName);

        return list;
    }

    /**
     * @see #queryForListMerge(String, Object, String, String, String, String)
     */
    public void merge(List list, String getFieldName, String setFieldname, String mergeFieldKeyName, String mergeStatementName) {
        Set<String> values = new HashSet<String>(); //�ŵ��ǲ�ѯ���ļ��ϵ�������
        try {
            //������
            for (Object o : list) {
                String property = BeanUtils.getProperty(o, getFieldName);
                if (!StringUtils.isEmpty(property)) {
                    values.add(property);
                }
            }
            //��ѯ���ĸ���Ϊ��
            if (!values.isEmpty()) {
                StringBuilder builder = new StringBuilder();
                //ƴװ���ַ���
                for (String value : values) {
                    builder.append(',');
                    builder.append(value);
                }
                //��ѯ������
                List merges = queryForList(mergeStatementName, builder.substring(1));
                for (Object obj : list) {
                    String val = BeanUtils.getProperty(obj, getFieldName);
                    //����ȥ
                    if (!StringUtils.isEmpty(val)) {
                        for (Object merge : merges) {
                            if (val.equals(BeanUtils.getProperty(merge, mergeFieldKeyName))) {
                                BeanUtils.setProperty(obj, setFieldname, merge);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("merge error!",e);
            throw new RuntimeException("merge error!", e);
        }
    }
}
