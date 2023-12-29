package com.Beelab.Service;

import java.awt.print.Pageable;
import java.util.List;

import com.Beelab.Entity.Category;
import com.Beelab.Response.PageResponse;
import org.springframework.data.domain.Page;

import com.Beelab.Entity.Size;

public interface SizeService {
	public Size createSize(Size size);

	public List<Size> getListSize();

	public Size findOneById(int id);

	public Size findOneByName(String name);

	public Size updateSize(Size size);


	//public PageResponse<Size> search(String name, String description, int page, int size);

	///public PageResponse<Size> search(String name, String description, int page, int size);
	

}
