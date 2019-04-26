package com.buba.dao;

import java.util.List;

import com.buba.pojo.Goods;


public interface GoodsDAO {
	public List<Object> findAllGoods(int pages,int count);
	public boolean addGoods(Goods goo);
	public Goods findOne(String id);
	public boolean updateGoods(Goods goo);
	public boolean delGoods(String id);
	public int getAllcount();
}
