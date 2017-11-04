package com.jyj019.persistence;

import java.io.Serializable;
import java.util.List;

/**
 * ͨ��Dao�ӿ�
 * @author jinyu
 *�����Ͳ����ǳ����е�Ӳ����  ���� �� �ӿ�
 * @param <E> ʵ��
 * @param <K> ����
 */
public interface BaseDao<E,K extends Serializable> {
	/**
	 * ����
	 * @param entity ʵ�����
	 * @return �����Ƿ�ɹ�
	 */
	default K save(E entity) {return null;};
	
	/**
	 * ��������ɾ��
	 * @param id ��ʶ�ֶ�
	 * @return ɾ���ɹ�����true���򷵻�false
	 */
	default boolean deleteById(K id){return false;};
	
	/**
	 * ���ݶ���ɾ��
	 * @param id ��ʶ�ֶ�
	 * @return ɾ���ɹ�����true���򷵻�false
	 */
	default boolean delete(E entity){return false;};
	
	/**
	 * ����
	 * @param entity ʵ�����
	 * @return ���³ɹ�����true���򷵻�false
	 */
	default E update(E entity){return null;};
	
	/**
	 * ����������ѯ
	 * @param id ��ʶ�ֶκ�
	 * @return �����null
	 */
	default E findById(K id){return null;};
	
	/**
	 * ��ѯ����
	 * @return ���������б�����
	 */
	default List<E> findAll(){return null;};
}
