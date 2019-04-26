package com.buba.pojo;



public class Goods {
	private String id;
	private String num_goods;
	private String client_goods;
	private int num_month;
	private String pic_url;

	private String createtime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNum_goods() {
		return num_goods;
	}
	public void setNum_goods(String num_goods) {
		this.num_goods = num_goods;
	}
	public String getClient_goods() {
		return client_goods;
	}
	public void setClient_goods(String client_goods) {
		this.client_goods = client_goods;
	}
	public int getNum_month() {
		return num_month;
	}
	public void setNum_month(int num_month) {
		this.num_month = num_month;
	}
	public String getPic_url() {
		return pic_url;
	}
	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", num_goods=" + num_goods + ", client_goods=" + client_goods + ", num_month="
				+ num_month + ", pic_url=" + pic_url + ", createtime=" + createtime + "]";
	}
}
