package com.buba.web;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.buba.pojo.Goods;
import com.buba.pojo.Page;
import com.buba.service.GoodsService;

@RequestMapping("/goods")
@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	//展示
	@RequestMapping("/findAllGoods")
	public String queryGoods(String currentPageNo,HttpServletRequest request) {
		String page=request.getParameter("currentPageNo");
		int pagess=1;
		if(page!=null) {
			pagess=Integer.parseInt(page);
		}
		Page p = goodsService.findAllGoods(pagess);
		String url=request.getRequestURI();
		p.setUrl(url);
		request.setAttribute("p", p);
		return "goodslist";
	}
	//详情
	@RequestMapping("/findOneGoods")
	public String findOneGoods(String id,Model model) {
		Goods goo = goodsService.findOne(id);
		model.addAttribute("goo", goo);
		return "goodsview";
	}
	//修改
	@RequestMapping("/findOneGoods2")
	public String findOneGoods2(String id,Model model) {
		Goods goo = goodsService.findOne(id);
		model.addAttribute("goo", goo);
		return "goodsupdate";
	}
	@RequestMapping("/goodsUpdate")
	public String goodsUpdate(Goods goods,@RequestParam("picurl") MultipartFile picurl,HttpServletRequest request) throws IllegalStateException, IOException {
		String filename = picurl.getOriginalFilename();
		picurl.transferTo(new File("D:/upload/"+filename));
		goods.setPic_url(filename);
		boolean b = goodsService.updateGoods(goods);
		if(b) {
			return "redirect:/goods/findAllGoods?currentPageNo=1";
		}else {
			request.setAttribute("msg", "修改失败");
			return "goodsupdate";
		}
		
	}
	//添加
	@RequestMapping("/addGoods")
	public String addGoods(Goods goods,@RequestParam("picurl") MultipartFile picurl,HttpServletRequest request) throws IllegalStateException, IOException {
		String filename = picurl.getOriginalFilename();
		picurl.transferTo(new File("D:/upload/"+filename));
		goods.setPic_url(filename);
		boolean b = goodsService.addGoods(goods);
		if(b) {
			return "redirect:/goods/findAllGoods?currentPageNo=1";
		}else {
			request.setAttribute("msg", "添加失败");
			return "goodsadd";
		}		
	}
	//删除
	@RequestMapping("/delGoods")
	public String delGoods(String id) {
		boolean b = goodsService.delGoods(id);
		if(b) {
			return "redirect:/goods/findAllGoods?currentPageNo=1";
		}
		else {
			return "redirect:/user/logout";
		}
	}
}
