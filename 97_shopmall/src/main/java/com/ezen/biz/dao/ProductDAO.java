package com.ezen.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.ProductVO;

@Repository
public class ProductDAO{
//"product-mapping.xml"매핑 파일을 호출하는 메소드 작성
	//메소드명은 매핑 ID와 동일함.
	@Autowired
	SqlSessionTemplate mybatis;
	
	public List<ProductVO> getNewProductList() {
		return mybatis.selectList("ProductMapper.getNewProductList");
	}
	
	public List<ProductVO> getBestProductList() {
		return mybatis.selectList("ProductMapper.getBestProductList");
	}
	
	public ProductVO getProduct(ProductVO vo) {
		return mybatis.selectOne("ProductMapper.getProduct", vo);
	}
	
	public List<ProductVO> getProductListByKind(String kind) {
		return mybatis.selectList("ProductMapper.getProductListByKind",kind);
	}
	
	////////////////////////////////////////////////////////////////////////////
	
	//총 상품 목록 개수 조회
	//파라미터 name : 검색할 상품명
	//이름을 기준으로 전체 상품 목록에 대한 상품 객수 조회(값이 ""인 경우 전체 상품 갯수 조회)
	public int countProductList(String name) {
		return mybatis.selectOne("ProductMapper.countProductList", name);
	}
	
	//상품 목록 조회
	public List<ProductVO> listProduct(String name) {
		return mybatis.selectList("ProductMapper.listProduct", name);
	}
	
	//상품 추가
	public void insertProduct(ProductVO vo) {
		mybatis.insert("ProductMapper.insertProduct", vo);
	}
	
	//상품 수정
	public void updateProduct(ProductVO vo) {
		mybatis.update("ProductMapper.updateProduct", vo);
	}
	
}
