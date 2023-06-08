<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--20230608 김기한 작성-->
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <title> PICKCOM 관리자 페이지 대시보드 </title>
    <link rel="stylesheet" href="adminpage.css">
    <link rel="stylesheet" href="footer.css">
    <!-- Boxicons CDN Link를 사용 -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
<body>
  <div class="sidebar">
    <div class="logo-details">
      <i class='bx bxl-c-plus-plus'></i>
      <span class="logo_name">Pickcom</span>
    </div>
      <ul class="nav-links">
        <li>
          <a href="#" class="active">
            <i class='bx bx-grid-alt' ></i>
            <span class="links_name">관리자 대시보드</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class='bx bx-box' ></i>
            <span class="links_name">상품</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class='bx bx-list-ul' ></i>
            <span class="links_name">주문 목록</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class='bx bx-pie-chart-alt-2' ></i>
            <span class="links_name">분석</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class='bx bx-coin-stack' ></i>
            <span class="links_name">제고</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class='bx bx-book-alt' ></i>
            <span class="links_name">전체 주문</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class='bx bx-user' ></i>
            <span class="links_name">Team</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class='bx bx-message' ></i>
            <span class="links_name">Messages</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class='bx bx-heart' ></i>
            <span class="links_name">좋아요한 상품</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class='bx bx-cog' ></i>
            <span class="links_name">설정</span>
          </a>
        </li>
        <li class="log_out">
          <a href="#">
            <i class='bx bx-log-out'></i>
            <span class="links_name">로그아웃</span>
          </a>
        </li>
      </ul>
  </div>
  <section class="home-section">
    <nav>
      <div class="sidebar-button">
        <i class='bx bx-menu sidebarBtn'></i>
        <span class="dashboard">관리자 대시보드</span>
      </div>
      <div class="search-box">
        <input type="text" placeholder="Search...">
        <i class='bx bx-search' ></i>
      </div>
      <div class="profile-details">
        <img src="프로필 이미지 구조" alt="프로필">
        <span class="admin_name">아이디</span>
        <i class='bx bx-chevron-down' ></i>
      </div>
    </nav>
    <div class="home-content">
      <div class="overview-boxes">
        <div class="box">
          <div class="right-side">
            <div class="box-topic">전체 주문량</div>
            <div class="number">12,345</div>
            <div class="indicator">
              <i class='bx bx-up-arrow-alt'></i>
              <span class="text">증가</span>
            </div>
          </div>
          <i class='bx bx-cart-alt cart'></i>
        </div>
        <div class="box">
          <div class="right-side">
            <div class="box-topic">전체 판매량</div>
            <div class="number">34,576</div>
            <div class="indicator">
              <i class='bx bx-up-arrow-alt'></i>
              <span class="text">증가</span>
            </div>
          </div>
          <i class='bx bxs-cart-add cart two' ></i>
        </div>
        <div class="box">
          <div class="right-side">
            <div class="box-topic">전체 이윤</div>
            <div class="number">16,770,859</div>
            <div class="indicator">
              <i class='bx bx-up-arrow-alt'></i>
              <span class="text">증가</span>
            </div>
          </div>
          <i class='bx bx-cart cart three' ></i>
        </div>
        <div class="box">
          <div class="right-side">
            <div class="box-topic">전체 환불량</div>
            <div class="number">10,008</div>
            <div class="indicator">
              <i class='bx bx-down-arrow-alt down'></i>
              <span class="text">감소</span>
            </div>
          </div>
          <i class='bx bxs-cart-download cart four' ></i>
        </div>
      </div>
      <div class="sales-boxes">
        <div class="recent-sales box">
          <div class="title">최근 판매</div>
          <div class="sales-details">
            <ul class="details">
              <li class="topic">Date</li>
              <li><a href="#">2023.06.08</a></li>
              <li><a href="#">2023.06.08</a></li>
              <li><a href="#">2023.06.08</a></li>
              <li><a href="#">2023.06.08</a></li>
              <li><a href="#">2023.06.08</a></li>
              <li><a href="#">2023.06.08</a></li>
              <li><a href="#">2023.06.08</a></li>
            </ul>
            <ul class="details">
            <li class="topic">고객</li>
            <li><a href="#">김기한</a></li>
            <li><a href="#">이병준</a></li>
            <li><a href="#">이원빈</a></li>
            <li><a href="#">홍길동</a></li>
            <li><a href="#">김철수</a></li>
            <li><a href="#">김영희</a></li>
            <li><a href="#">김갑돌</a></li>
            <li><a href="#">김갑순</a></li>
            <li><a href="#">손흥민</a></li>
          </ul>
          <ul class="details">
            <li class="topic">판매</li>
            <li><a href="#">배송완료</a></li>
            <li><a href="#">배송중</a></li>
            <li><a href="#">환불</a></li>
            <li><a href="#">배송완료</a></li>
            <li><a href="#">배송중</a></li>
            <li><a href="#">환불</a></li>
            <li><a href="#">배송완료</a></li>
            <li><a href="#">배송중</a></li>
            <li><a href="#">배송완료</a></li>
          </ul>
          <ul class="details">
            <li class="topic">총합</li>
            <li><a href="#">210,000</a></li>
            <li><a href="#">24,000</a></li>
            <li><a href="#">26,000</a></li>
            <li><a href="#">180,000</a></li>
            <li><a href="#">70,000</a></li>
            <li><a href="#">55,000</a></li>
            <li><a href="#">75,000</a></li>
            <li><a href="#">32,000</a></li>
            <li><a href="#">24,000</a></li>
          </ul>
          </div>
          <div class="button">
            <a href="#">더 보기</a>
          </div>
        </div>
        <div class="top-sales box">
          <div class="title">판매 상품 랭킹</div>
          <ul class="top-sales-details">
            <li>
            <a href="#">
              <img src="//img.danawa.com/prod_img/500000/280/640/img/18640280_1.jpg?shrink=130:130&_v=20230206110955" alt="">
              <span class="product">인텔 코어i5-13세대 13400F (랩터레이크)</span>
            </a>
            <span class="price">262,220</span>
          </li>
          <li>
            <a href="#">
              <img src="//img.danawa.com/prod_img/500000/808/627/img/19627808_1.jpg?shrink=130:130&_v=20230502094419" alt="">
              <span class="product">AMD 라이젠7-5세대 7800X3D (라파엘)</span>
            </a>
            <span class="price">636,410</span>
          </li>
          <li>
            <a href="#">
              <img src="//img.danawa.com/prod_img/500000/599/751/img/11751599_1.jpg?shrink=130:130&_v=20210803143844" alt="">
              <span class="product">GIGABYTE B550M AORUS ELITE 피씨디렉트</span>
            </a>
            <span class="price">123,080</span>
          </li>
          <li>
            <a href="#">
              <img src="//img.danawa.com/prod_img/500000/880/652/img/18652880_1.jpg?shrink=130:130&_v=20230215143253" alt="">
              <span class="product">MSI MAG B760M 박격포 맥스 WIFI</span>
            </a>
            <span class="price">258,990</span>
          </li>
          <li>
            <a href="#">
              <img src="//img.danawa.com/prod_img/500000/078/545/img/6545078_1.jpg?shrink=130:130&_v=20220629141246" alt="">
              <span class="product">Seagate BarraCuda 7200/256M</span>
            </a>
            <span class="price">76,120</span>
          </li>
          <li>
            <a href="#">
              <img src="//img.danawa.com/prod_img/500000/675/927/img/14927675_1.jpg?shrink=130:130&_v=20220808090643" alt="">
              <span class="product">AMD 라이젠5-4세대 5600G (세잔)</span>
            </a>
            <span class="price">156,080</span>
          <li>
            <a href="#">
              <img src="//img.danawa.com/prod_img/500000/568/276/img/13276568_1.jpg?shrink=130:130&_v=20221017171819" alt="">
              <span class="product">삼성전자 PM9A1 M.2 NVMe 병행수입</span>
            </a>
            <span class="price">172890</span>
          </li>
          <li>
            <a href="#">
            <img src="//img.danawa.com/prod_img/500000/050/001/img/17001050_1.jpg?shrink=130:130&_v=20221213154339" alt="">
              <span class="product">SK하이닉스 Platinum P41 M.2 NVMe</span>
            </a>
            <span class="price">139,000</span>
          </li>
          </ul>
        </div>
      </div>
    </div>
    <footer> <!--푸터 코드 부분 시작-->
      <div>
          <p>
              <img src="./footer_logo.png" alt="로고">
          </p>
          <p>
              <strong>(주) Love And Rock </strong>
              <br> 서울특별시 강남구 테헤란로 강남건물
              <br> 대표이사 : 김갑똘
              <br> 사업자등록번호: 220-81-12345 사업자정보확인
              <br> 통신판매업신고: 강남 12345호 Fax: 02-123-1234
          </p>
          <p>
              <strong>고객센터</strong>
              <br> Tel: 1234-5678 (평일: 09:00~18:00)
              <br> 경기도 의정부시 서부로 545 효행관 405호
              <br> Fax: 031-123-4567 | Mail: kimshin5619@gmail.com
          </p>
      </div>
    </footer>
  </section>
  <script>
let sidebar = document.querySelector(".sidebar");
let sidebarBtn = document.querySelector(".sidebarBtn");
sidebarBtn.onclick = function() {
  sidebar.classList.toggle("active");
  if(sidebar.classList.contains("active")){
  sidebarBtn.classList.replace("bx-menu" ,"bx-menu-alt-right");
}else
  sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
}
</script>
</body>
</html>