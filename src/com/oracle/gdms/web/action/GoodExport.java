package com.oracle.gdms.web.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.gdms.entity.GoodsEntity;
import com.oracle.gdms.service.GoodsService;
import com.oracle.gdms.service.impl.GoodsServiceImpl;
import com.oracle.gdms.util.GDMSUtil;
import com.uplooking.excel.ExcelTools;


@WebServlet("/admin/goods/export.php")
public class GoodExport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收客户端传递过来的参数，为了使文能正确获取，，必须先设置字符集
		String str=request.getParameter("keywords");//表单提交过来的元素名
		
		System.out.println("要搜索的关键词===="+str);
		
		
		//调用业务层搜索商品的方法，获取数据
		GoodsService service =new GoodsServiceImpl();
		List<Map<String,Object>> list=service.findByKeywords(str);
		//System.out.println("找到记录"+ list.size()+"条");
		
		String[] columns=GDMSUtil.parseColumn(list);
//		for(String string : columns) {
//			System.out.println(string);
//		}
		//String[] data =  ;
		String[][] data =GDMSUtil.parseColumn(list,columns);
		
		String path = request.getServletContext().getRealPath("/WEB-INF");
		String filename = path + "/doc/商品搜索结果.xls";
		
		ExcelTools.writeToExcel(columns, data, filename, "商品数据搜索结果");
		System.out.println(filename);
		
		try {
			GDMSUtil.download(response, new File(filename));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
