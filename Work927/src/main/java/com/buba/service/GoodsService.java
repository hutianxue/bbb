package com.buba.service;



import com.buba.pojo.Goods;
import com.buba.pojo.Page;

public interface GoodsService {
	public Page findAllGoods(int pages);
	public boolean addGoods(Goods goo);
	public Goods findOne(String id);
	public boolean updateGoods(Goods goo);
	public boolean delGoods(String id);
}
