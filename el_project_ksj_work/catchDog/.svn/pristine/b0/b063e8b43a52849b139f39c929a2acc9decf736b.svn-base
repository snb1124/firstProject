package com.catchdog.common;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.catchdog.adoption.vo.AdoptionVO;

public abstract class ReceiveAPIData {
	
	
	
	private static String getTagValue(String tag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		if(nValue == null) return null;
		return nValue.getNodeValue();
	}

	public static ArrayList<AdoptionVO> getData() {
		// TODO Auto-generated method stub
		
		String serviceKey = "ServiceKey=1ZUPc%2BJmDiSiYavXUDMa1%2BbIXXZlyQjE1y%2FPZpJ88HsW28VvHpu7Sc4SS8DFMCrJlufba3pK3sf2JQtSvQ80Gg%3D%3D";
		String baseUrl = "http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/";
		// 시도 조회 - url
		String sido = "sido?";
		// 시도 조회 - querystring
		
		// 시군구 조회 - url
		String sigungu = "sigungu?";
		// 시군구 조회 - querystring
		String upr_cd_sigungu = "upr_cd="; // 시도코드
		
		// 보호소 조회 - url
		String shelter = "shelter?";
		// 보호소 조회 - querystring
		String upr_cd_shelter = "upr_cd="; // 시도코드
		String org_cd_shelter = "org_cd="; // 시군구코드
		
		// 품종 조회 - url
		String kind = "kind?";
		// 품종 조회 - querystring
		String up_kind_cd_kind = "up_kind_cd="; // 축종코드
		
		// 유기동물 조회 - url
		String abandonmentPublic = "abandonmentPublic?";
		// 유기동물 조회 - querystring
		String bgnde_abd = "bgnde="; // 검색 시작일
		String endde_abd = "endde="; // 검색 종료일
		String upkind_abd = "upkind="; // 축종 코드
		String kind_abd = "kind="; // 품종코드
		String upr_cd_abd = "upr_cd="; // 시도 코드
		String org_cd_abd = "org_cd="; // 시군구코드
		String care_reg_no_abd = "care_reg_no="; // 보호소번호
		String state_abd = "state="; // 상태
		String neuter_yn_abd = "neuter_yn="; // 중성화 여부
		String pageNo_abd = "pageNo_abd="; // 페이지번호
		String numOfRows_abd = "numOfRows="; // 페이지당 보여줄 개수
 					
		// 축종 코드
		String dog = "417000";
		String cat = "422400";
		
		String url = baseUrl + abandonmentPublic + serviceKey 
						+ "&" + bgnde_abd + "20211001" 
						+ "&" + pageNo_abd + "1" 
						+ "&" + numOfRows_abd + "5";
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		Document doc = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("document error >>> : " + e);
		}
		
		doc.getDocumentElement().normalize();
		System.out.println("root element >>> : " + doc.getDocumentElement().getNodeName());
		
		NodeList nList = doc.getElementsByTagName("item");
		System.out.println("nList.size >>> : " + nList.getLength());
		ArrayList<AdoptionVO> aList = new ArrayList<AdoptionVO>();
		
		for(int i=0; i<nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) nNode;
				String adno = getTagValue("noticeNo", e);
				String akind = getTagValue("kindCd", e);
				String aupkind = null;
				if(akind.contains("[개]")) aupkind = "01";
				else	aupkind = "02";
				
				String aneut = getTagValue("neuterYn", e);
				String aage = getTagValue("age", e);
				String aimage = getTagValue("popfile", e);
				String agender = getTagValue("sexCd", e);
				String ainsertdate = getTagValue("happenDt", e);
				String acaresite = getTagValue("careAddr", e);
				String acaretel = getTagValue("careTel", e);
				String acolor = getTagValue("colorCd", e);
				
				String happenPlace = getTagValue("happenPlace", e);
				String aspecial = getTagValue("specialMark", e);
				aspecial.concat(" " + happenPlace + " 에서 발견");
				
				String processState = getTagValue("processState", e);
				if(!processState.contains("종료")) {
					AdoptionVO avo = new AdoptionVO();
					avo.setAdno(adno);
					avo.setAkind(akind);
					avo.setAupkind(aupkind);
					avo.setAneut(aneut);
					avo.setAage(aage);
					avo.setAimage(aimage);
					avo.setAgender(agender);
					avo.setAinsertdate(ainsertdate);
					avo.setAcaresite(acaresite);
					avo.setAcaretel(acaretel);
					avo.setAcolor(acolor);
					avo.setAspecial(aspecial);
					avo.setMnum(null);
					avo.setAnum("A" + DateFormatUtil.ymdFormat() + DateFormatUtil.numPad(i));
					avo.setAsubject(null);
					avo.setAname(null);
					aList.add(avo);
				}
				/*
				System.out.println("age >>> : " + getTagValue("age", e));
				System.out.println("careAddr >>> : " + getTagValue("careAddr", e));
				System.out.println("careTel >>> : " + getTagValue("careTel", e));
				System.out.println("colorCd >>> : " + getTagValue("colorCd", e));
				System.out.println("popfile >>> : " + getTagValue("popfile", e));
				System.out.println("happenDt >>> : " + getTagValue("happenDt", e));
				System.out.println("happenPlace >>> : " + getTagValue("happenPlace", e));
				System.out.println("kindCd >>> : " + getTagValue("kindCd", e));
				System.out.println("neuterYn >>> : " + getTagValue("neuterYn", e));
				System.out.println("processState >>> : " + getTagValue("processState", e));
				System.out.println("noticeNo >>> : " + getTagValue("noticeNo", e));
				System.out.println("sexCd >>> : " + getTagValue("sexCd", e));
				System.out.println("specialMark >>> : " + getTagValue("specialMark", e));
				System.out.println("weight >>> : " + getTagValue("weight", e));
				*/
			}
		}
		if(aList != null)System.out.println("list.size >>> : " + aList.size());
		return aList;
	}

}

