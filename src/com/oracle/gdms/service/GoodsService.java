package com.oracle.gdms.service;

import java.util.List;
import java.util.Map;

import com.oracle.gdms.entity.GoodsEntity;
import com.oracle.gdms.entity.GoodsModel;
import com.oracle.gdms.entity.PageModel;

public interface GoodsService {

	/**
	 * ��ҳ��ʾ��Ʒ����
	 * @param pageNumber ��ǰҳ��
	 * @param rows ÿҳ��������¼
	 * @return 
	 */
	PageModel<GoodsModel> findByPage(int pageNumber, int rows);

	
	/**
	 * ����ָ��ID����Ʒ
	 * @param goodsid
	 * @return �ɹ���ϢΪ�մ���ʧ��Ϊ��Ϣ����
	 */
	String pushGoods(int goodsid);


	/**
	 * ����һ����Ʒ��¼
	 * @param goods
	 * @return ��Ӱ�������
	 */
	int add(GoodsEntity goods);


	/**
	 * ���ݹؼ���������Ʒ��¼����ҳ��ʾ
	 * @param kw �ؼ���
	 * @param p ҳ��
	 * @param rows ÿҳ����
	 * @return
	 */
	PageModel<GoodsModel> findByKeywords(String kw, int p, int rows);

	/**
	 * ���ݹؼ�����������������������Ʒ
	 * @param kw  �ؼ���
	 * @return
	 */
	List<Map<String,Object>> findByKeywords(String kw);
	
	/**
	 * ɾ��һ����Ʒ���ݣ�����״̬��
	 * @param gid
	 */
	void delete(String[] gid);
}