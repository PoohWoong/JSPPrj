package net.answeris.web.dao;

import java.util.List;

import net.answeris.web.model.Notice;

public interface NoticeDao {
	public List<Notice> getLIst(String field, String query, int page);
	public List<Notice> getList(int page);
	public List<Notice> getList();
	
	public Notice get(String code);
	public Notice getNext(String code);
	public Notice getPrev(String code);
	
	public int add(Notice notice);
	public int update(Notice notice);
	public int delete(Notice notice);	
}
