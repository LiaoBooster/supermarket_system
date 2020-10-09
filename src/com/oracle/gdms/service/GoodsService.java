package com.oracle.gdms.service;

import java.util.List;
import java.util.Map;

import com.oracle.gdms.entity.GoodsEntity;
import com.oracle.gdms.entity.GoodsModel;
import com.oracle.gdms.entity.PageModel;

public interface GoodsService {

	/**
	 * 分页显示商品数据
	 * @param pageNumber 当前页码
	 * @param rows 每页多少条记录
	 * @return 
	 */
	PageModel<GoodsModel> findByPage(int pageNumber, int rows);

	
	/**
	 * 推送指定ID的商品
	 * @param goodsid
	 * @return 成功消息为空串，失败为消息内容
	 */
	String pushGoods(int goodsid);


	/**
	 * 增加一条商品记录
	 * @param goods
	 * @return 受影响的行数
	 */
	int add(GoodsEntity goods);


	/**
	 * 根据关键词搜索商品记录，分页显示
	 * @param kw 关键词
	 * @param p 页码
	 * @param rows 每页行数
	 * @return
	 */
	PageModel<GoodsModel> findByKeywords(String kw, int p, int rows);

	/**
	 * 根据关键词搜索符合条件的所有商品
	 * @param kw  关键词
	 * @return
	 */
	List<Map<String,Object>> findByKeywords(String kw);
	
	/**
	 * 删除一组商品数据（更新状态）
	 * @param gid
	 */
	void delete(String[] gid);
}
