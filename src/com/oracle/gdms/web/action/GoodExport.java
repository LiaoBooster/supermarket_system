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
		//���տͻ��˴��ݹ����Ĳ�����Ϊ��ʹ������ȷ��ȡ���������������ַ���
		String str=request.getParameter("keywords");//���ύ������Ԫ����
		
		System.out.println("Ҫ�����Ĺؼ���===="+str);
		
		
		//����ҵ���������Ʒ�ķ�������ȡ����
		GoodsService service =new GoodsServiceImpl();
		List<Map<String,Object>> list=service.findByKeywords(str);
		//System.out.println("�ҵ���¼"+ list.size()+"��");
		
		String[] columns=GDMSUtil.parseColumn(list);
//		for(String string : columns) {
//			System.out.println(string);
//		}
		//String[] data =  ;
		String[][] data =GDMSUtil.parseColumn(list,columns);
		
		String path = request.getServletContext().getRealPath("/WEB-INF");
		String filename = path + "/doc/��Ʒ�������.xls";
		
		ExcelTools.writeToExcel(columns, data, filename, "��Ʒ�����������");
		System.out.println(filename);
		
		try {
			GDMSUtil.download(response, new File(filename));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
