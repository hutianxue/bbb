package com.buba.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buba.dao.GoodsDAO;
import com.buba.pojo.Goods;
import com.buba.pojo.Page;
import com.buba.service.GoodsService;
@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsDAO goodsDAO;
	@Override
	public Page findAllGoods(int pages) {
		int count=3;
		int allCount=goodsDAO.getAllcount();
		int allPages=(int) Math.ceil(1.0*allCount/count);
		int pageCount=(pages-1)*count;
		List<Object> findAllGoods = goodsDAO.findAllGoods(pageCount, count);
		Page p=new Page();
		p.setCount(count);
		p.setCurrentPageNo(pages);
		p.setTotalCount(allCount);
		p.setTotalPageCount(allPages);
		p.setQuery(findAllGoods);
		return p;
				
	}

	@Override
	public boolean addGoods(Goods goo) {
		// TODO Auto-generated method stub
		return goodsDAO.addGoods(goo);
	}

	@Override
	public Goods findOne(String id) {
		// TODO Auto-generated method stub
		return goodsDAO.findOne(id);
	}

	@Override
	public boolean updateGoods(Goods goo) {
		// TODO Auto-generated method stub
		return goodsDAO.updateGoods(goo);
	}

	@Override
	public boolean delGoods(String id) {
		// TODO Auto-generated method stub
		return goodsDAO.delGoods(id);
	}

}
