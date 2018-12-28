package cn.javaee.utils;

import java.util.ArrayList;
import java.util.List;

import cn.javaee.VO.ResultToiletVO;
import cn.javaee.bean.Toilet;
import cn.javaee.enums.ToiletTypeEnum;

public class Toilet2ResultToiletUtil {

	public static List<ResultToiletVO> change(List<Toilet> toilets) {
		List<ResultToiletVO> list = new ArrayList<>();
		for(Toilet toilet:toilets) {
			ResultToiletVO resultToiletVO = new ResultToiletVO();
			resultToiletVO.setId(toilet.getId());
			resultToiletVO.setName(toilet.getName());
			resultToiletVO.setType(ToiletTypeEnum.getTypeByCode(toilet.getType()));	
			if(toilet.getCleaner()!=null) {
				resultToiletVO.setCleaner_name(toilet.getCleaner().getName());
				resultToiletVO.setCleaner_phone(toilet.getCleaner().getPhone());
			}
			resultToiletVO.setPre_clean(toilet.getLast_cleaned_time());
			resultToiletVO.setNext_clean(toilet.getNext_clean_time());
			if(toilet.isService()) {
				resultToiletVO.setIsServer("是");	
			}else {
				resultToiletVO.setIsServer("否");
			}
			if(toilet.getFloor()!=null) {
				resultToiletVO.setFloor_name(toilet.getFloor().getName());	
			}
			list.add(resultToiletVO);
		}
		return list;
	}
}
