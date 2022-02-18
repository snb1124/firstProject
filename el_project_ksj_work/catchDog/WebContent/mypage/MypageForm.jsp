<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.catchdog.common.K_Session" %>
<%@ page import="java.util.Map" %>
<%
	K_Session ks = K_Session.getInstance();
	Map<String,Object> ssMap = ks.getSession(request);
	if(ssMap.get("ssMid") != null){
		ssMap.get("ssMname");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
  padding: 0 !important;
  margin: 0 !important;
}
div{
  box-sizing: border-box !important;
}

/* alert badge */
.circle{
  display: inline-block;
  width: 5px;
  height: 5px;
  border-radius: 2.5px;
  background-color: #ff0000;
  position: absolute;
  top: -5px;
  left: 110%;
}

/* 녹색 텍스트 */
.green{
  color: #24855b;
}

.wrap{
  background-color: #F8F8F8;  
}
/* 녹색배경 */
.greenContainer{  
  height: 80px;
  background-color: #F7AA58;    
  
  display: flex;
  align-items: flex-end;
  padding: 16px;
}

.greenContainer .name{
   font-size: 20px;
  font-weight: bold;
  color: #ffffff;
  padding-bottom: 8px;
} 
.greenContainer .modify{
  margin-left: auto;
}

/* 단골상점 , 상품후기 , 적립금 박스 */
.summaryContainer{
  background-color: white;  
  display: flex;  
  padding: 21px 16px;  
  height: 90px;
  margin-bottom: 10px;
}
/* 단골상점 , 상품후기 , 적립금 */
.summaryContainer .item{
  flex-grow: 1
}
/* 녹색 숫자 */
.summaryContainer .number{
  font-size: 19px;
  font-weight: bold;
  color: #24855b;
}
/* 텍스트 */
.summaryContainer .item > div:nth-child(2){
  font-size: 13px;
}

/* ================== 주문/배송조회 박스 시작 ==================== */
.shippingStatusContainer{
  padding: 21px 16px;
  background-color: white;
  margin-bottom: 10px;
}

/* 주문/배송조회 타이틀 */
.shippingStatusContainer .title{
  font-size: 16px;
  font-weight: bold;
  margin-bottom: 15px;
}

/* 장바구니 결제완료 배송중 구매확정 [로우] */
.shippingStatusContainer .status{
  display: flex;
  justify-content: space-between;
  margin-bottom: 21px;
}
/* 장바구니 결제완료 배송중 구매확정 [아이템]  */
.shippingStatusContainer .item{
  display: flex;
}

.shippingStatusContainer .number{
  font-size: 31px;
  font-weight: 500;
  text-align: center;
}
.shippingStatusContainer .text{
  font-size: 12px;
  font-weight: normal;
  color: #c2c2c2;
  text-align: center;
}
.shippingStatusContainer .icon{
  display: flex;
  align-items: center;
  padding: 20px;
  width: 16px;
  height: 16px;
}


/*=================== 주문목록 ~ 찜한상품 리스트 ==================*/
.listContainer{  
  padding: 0;
  background-color: #ffffff;
  margin-bottom: 10px;
}
.listContainer .item{  
  display: flex;
  align-items: center;
  padding: 16px;
  color: black;
  text-decoration: none;  
  height: 56px;
  box-sizing: border-box;
}
.listContainer .icon{  
  margin-right: 14px;
}
.listContainer .text{
  font-size: 16px;
  position: relative;
}
.listContainer .right{
  margin-left: auto;
}

</style>
</head>
<body>
	<div class="wrap">
	  <div class="greenContainer">
	      <div class="name"><%= ssMap.get("ssMname") %>님 환영합니다</div>
	      <img src="/image/mypage/—Pngtree—soles_6083038.png" width="60" height="60" alt="발바닥">      
	  </div>
	  <div class="summaryContainer">
	    <div class="item">	        
	        <div class="number"><a href="memSelect.cd">회원정보 수정</a></div>
	      </div>
	      <div class="item">
	        <div class="number">354</div>
	        <div>상품후기</div>
	      </div>
	  </div>  
	  <div class="shippingStatusContainer">
	    <div class="title">
	      주문/배송조회
	    </div>
	    <div class="status">
	      
	      <div class="item">
	        <div>
	          <div class="green number">6</div>
	          <div class="text">장바구니</div>
	        </div>
	        <div class="icon"> > </div>
	      </div>     
	      <div class="item">
	        <div>
	          <div class="number">0</div>
	          <div class="text">결제완료</div>
	        </div>
	        <div class="icon"> > </div>
	      </div>     
	      <div class="item">
	        <div>
	          <div class="green number">1</div>
	          <div class="text">배송중</div>
	        </div>
	        <div class="icon"> > </div>
	      </div>     
	      <div class="item">
	        <div>
	          <div class="green number">3</div>
	          <div class="text">구매확정</div>
	        </div>
	      </div>     
	      
	    </div>
	    
	  </div>  
	  <div class="listContainer">
	    <a href="#" class="item">
	        <div class="icon">ii</div>
	        <div class="text">주문목록<span class="circle"></span></div>
	        <div class="right"> > </div>
	    </a>
	    <a href="#" class="item">
	        <div class="icon">ii</div>
	        <div class="text">상품후기</div>
	        <div class="right"> > </div>
	    </a>
	    <a href="#" class="item">
	        <div class="icon">ii</div>
	        <div class="text">상품문의</div>
	        <div class="right"> > </div>
	    </a>
	    <a href="#" class="item">
	        <div class="icon">ii</div>
	        <div class="text">단골상점</div>
	        <div class="right"> > </div>
	    </a>
	    <a href="#" class="item">
	        <div class="icon">ii</div>
	        <div class="text">찜한상품</div>
	        <div class="right"> > </div>
	    </a>
	  </div>
	
	</div>
</body>
</html>