<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@include file="tabLib.jsp"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Web Bán Căn Hộ Nơi Mầm Xanh Phát Triền Số 1 VN </title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="shortcut icon" type="image/x-icon" href="<%= request.getContextPath() %>/User/images/favicon.ico">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/User/css/style.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/User/css/thanhtimkiem.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/User/css/header.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/User/css/Tintuc.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/User/css/home.css">

</head>
<body>


<header class="header-area header-sticky">
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <!--Logo -->
            <a class="navbar-brand" href="User/html/home.html">
                <img src="User/images/LoGo.jpg" height="50" width="50">
                <span class="ms-2 fw-bold">Mầm Xanh Group</span>
            </a>
            <!-- Toggle button for mobile -->
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <!-- Navbar links -->
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <!-- Dropdown: Căn hộ bán -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="banDropdown" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            Căn hộ bán
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="banDropdown">
                            <c:forEach items="${listS}" var="o">
                                <li><a class="dropdown-item" href="categorySell?sid=${o.id}">${o.name}</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                    <!-- Dropdown: Căn hộ thuê -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="thueDropdown" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            Căn hộ thuê
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="thueDropdown">
                            <c:forEach items="${listR}" var="o">
                                <li><a class="dropdown-item" href="categoryRent?rid=${o.id}">${o.name}</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                    <!-- Tin tức -->
                    <li class="nav-item">
                        <a class="nav-link" href="User/html/tin%20tức.html">Tin tức</a>
                    </li>
                    <!-- Mục yêu thích(mục tin đã lưu) -->
                    <li class="nav-item">
                        <a class="nav-link" href="#"><i class="fas fa-heart"></i> Tin đã lưu</a>

                    </li>
                    <!-- Đăng nhập & Đăng ký -->
                    <%@ page session="true" %>
                    <%
                        String username = (String) session.getAttribute("username");
                        Integer role = (Integer) session.getAttribute("role");
                    %>
                    <nav>
                        <ul class="nav">
                            <% if (username == null) { %>
                            <li class="nav-item">
                                <a class="nav-link" href="login.jsp">Đăng nhập</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="signup.jsp">Đăng ký</a>
                            </li>
                            <% } else { %>
                            <% if (role != null && role == 1) { %>
                            <li class="nav-item">
                                <a class="nav-link" href="index.jsp">Quản trị</a>
                            </li>
                            <% } %>
                            <li class="nav-item">
                                <a class="nav-link" href="home.jsp">Trang chủ</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="logout">Đăng xuất</a>
                            </li>
                            <% } %>
                        </ul>
                    </nav>
                </ul>
            </div>
        </nav>
    </div>
</header>

<%-- tìm kiếm ở đây--%>


<div class="container mt-4">
    <div class="card shadow-sm p-4">
        <form action="search" method="GET">
            <div class="row gx-2 align-items-center">
                <!-- Thanh tìm kiếm chính -->
                <div class="col-md-3">
                    <div class="input-group">
                        <span class="input-group-text bg-light">
                            <i class="fas fa-search"></i>
                        </span>
                        <input value="${txts}" name="txt" type="text" class="form-control" placeholder="Trên toàn quốc">
                    </div>
                </div>

                <!-- Dropdown chọn thành phố -->
                <div class="col-md-2">
                    <select name="city" class="form-select">
                        <option selected value="Hồ Chí Minh">Hồ Chí Minh</option>
                        <option value="Hà Nội">Hà Nội</option>
                        <option value="Đà Nẵng">Đà Nẵng</option>
                        <option value="Nha Trang">Nha Trang</option>
                        <option value="Vũng Tàu">Vũng Tàu</option>
                        <option value="Bình Dương">Bình Dương</option>
                    </select>
                </div>

                <!-- Dropdown loại nhà đất -->
                <div class="col-md-2">
                    <select name="type" class="form-select">
                        <option selected value="">Loại nhà đất</option>
                        <option value="Nhà mặt phố">Nhà mặt phố</option>
                        <option value="Chung cư">Chung cư</option>
                        <option value="Chung cư mini">Chung cư mini</option>
                        <option value="Nhà riêng">Nhà riêng</option>
                        <option value="Biệt thự">Biệt thự</option>
                    </select>
                </div>

                <!-- Dropdown mức giá -->
                <div class="col-md-2">
                    <select name="price" class="form-select">
                        <option selected value="">Mức giá</option>
                        <option value="Dưới 500 triệu">Dưới 500 triệu</option>
                        <option value="500-800 triệu">500-800 triệu</option>
                        <option value="Dưới 1 tỷ">Dưới 1 tỷ</option>
                        <option value="1-2 tỷ">1-2 tỷ</option>
                        <option value="3-5 tỷ">3-5 tỷ</option>
                        <option value="5-10 tỷ">5-10 tỷ</option>
                        <option value="Thỏa thuận">Thỏa thuận</option>
                    </select>
                </div>

                <!-- Dropdown diện tích -->
                <div class="col-md-2">
                    <select name="area" class="form-select">
                        <option selected value="">Diện tích</option>
                        <option value="Dưới 50 m²">Dưới 50 m²</option>
                        <option value="50-100 m²">50-100 m²</option>
                        <option value="100-150 m²">100-150 m²</option>
                        <option value="150-200 m²">150-200 m²</option>
                        <option value="200+ m²">200+ m²</option>
                    </select>
                </div>

                <!-- Dropdown phòng ngủ -->
                <div class="col-md-2">
                    <select name="bedroom" class="form-select">
                        <option selected value="">Phòng ngủ</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5+">5+</option>
                    </select>
                </div>

                <!-- Nút tìm kiếm -->
                <div class="col-md-2">
                    <button type="submit" class="btn btn-primary w-100">
                        Tìm kiếm
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>


<!--Slider-->
<div class="slider-container" style="margin-top: 2px; width:1600px">
    <div id="productCarousel" class="carousel slide" data-bs-ride="carousel" data-bs-interval="3000">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="<%= request.getContextPath() %>/User/images/img1.jpg" class="d-block w-100" alt="Căn hộ 1">
                <div class="carousel-caption"></div>
            </div>
            <div class="carousel-item">
                <img src="<%= request.getContextPath() %>/User/images/img3.jpg" class="d-block w-100" alt="Căn hộ 2">
                <div class="carousel-caption"></div>
            </div>
            <div class="carousel-item">
                <img src="<%= request.getContextPath() %>/User/images/img4.jpg" class="d-block w-100" alt="Căn hộ 3">
                <div class="carousel-caption"></div>
            </div>
            <div class="carousel-item">
                <img src="<%= request.getContextPath() %>/User/images/img5.jpg" class="d-block w-100" alt="Căn hộ 4">
                <div class="carousel-caption"></div>
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#productCarousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#productCarousel" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</div>


<!--Tin Tức -->
<div class="news-main">
    <div class="tabs">
        <div class="tab">Tin Tức</div>
        <a href="../../../../../../../webapp/<%= request.getContextPath() %>/User/html/tin%20tức.html" class="view-more">Xem thêm →</a>
    </div>
    <div class="two-item">
        <div class="main-news">
            <img src="../../../../../../../webapp/<%= request.getContextPath() %>/User/images/img4.jpg" alt="Main News" class="main-image">
            <div class="main-title">Tận Hưởng Cuộc Sống Phong Cách Nhật, Đậm “Chất” Hạ Long Tại Misaki Tower</div>
            <div class="time">10 giờ trước</div>
        </div>
        <ul class="news-list">
            <li><a href="#">Giải Thưởng Bất Động Sản Việt Nam PropertyGuru Cán Mốc 10 Năm Vinh Danh Các “Biểu
                Tượng”…</a></li>
            <li><a href="#">Tận Hưởng Cuộc Sống Phong Cách Nhật, Đậm “Chất” Hạ Long Tại Misaki Tower</a></li>
            <li><a href="#">Phân khu căn hộ hạng sang duy nhất của Vinhomes Grand Park, được kiến tạo bởi Vinhomes và
                ông lớn Samty - Tập đoàn BĐS lâu đời nhất Nhật Bản với những giá trị độc bản không thể tìm kiếm được ở
                dự khác: Căn hộ hạng sang đầu tiên tại Việt Nam có công viên Vinwonders ngay trước nhà và còn hơn
                thế: </a></li>
            <li><a href="#">Thị Trường Thuê Trọ Ngã Tư Sở Và Những Thông Tin Liên Quan Cần Biết</a></li>
            <li><a href="#">Căn Hộ Chung Cư – Điểm Nóng Của Thị Trường Bất Động Sản Việt Nam Năm 2024</a></li>
            <li><a href="#">Thị Trường BĐS Đà Nẵng: Dự Báo Xu Hướng Và Cơ Hội Đầu Tư</a></li>
        </ul>
    </div>

    <div class="two-item">
        <div class="main-news">
            <img src="../../../../../../../webapp/<%= request.getContextPath() %>/User/images/img6.jpg" alt="Main News" class="main-image">
            <div class="main-title">Toàn cảnh Vinhome về đêm, được cho là một đô thị thu nhỏ</div>
            <div class="time">10 giờ trước</div>
        </div>
        <ul class="news-list">
            <li><a href="#">Giải Thưởng Bất Động Sản Việt Nam PropertyGuru Cán Mốc 10 Năm Vinh Danh Các “Biểu
                Tượng”…</a></li>
            <li><a href="#">Tận Hưởng Cuộc Sống Phong Cách Nhật, Đậm “Chất” Hạ Long Tại Misaki Tower</a></li>
            <li><a href="#">Phân khu căn hộ hạng sang duy nhất của Vinhomes Grand Park, được kiến tạo bởi Vinhomes và
                ông lớn Samty - Tập đoàn BĐS lâu đời nhất Nhật Bản với những giá trị độc bản không thể tìm kiếm được ở
                dự khác: Căn hộ hạng sang đầu tiên tại Việt Nam có công viên Vinwonders ngay trước nhà và còn hơn
                thế: </a></li>
            <li><a href="#">Thị Trường Thuê Trọ Ngã Tư Sở Và Những Thông Tin Liên Quan Cần Biết</a></li>
            <li><a href="#">Căn Hộ Chung Cư – Điểm Nóng Của Thị Trường Bất Động Sản Việt Nam Năm 2024</a></li>
            <li><a href="#">Thị Trường BĐS Đà Nẵng: Dự Báo Xu Hướng Và Cơ Hội Đầu Tư</a></li>
        </ul>
    </div>
</div>



<!-- Main content -->
<div class="news-container">

        <h2 class="mt-5 mb-4">Danh sách căn hộ bán</h2>
        <div class="row">
            <c:forEach items="${listP}" var="o">
                <div class="col-md-4">
                    <div class="card">
                        <img src="/User/images/${o.img}" class="card-img-top" alt="Căn hộ 1">
                        <div class="card-body">
                            <h5 class="card-title">${o.name}</h5>
                            <p class="card-text">${o.describe}</p>
                            <p>
                                <i class="fas fa-eye text-muted"></i>
                                <span class="text-muted">${o.view} lượt xem</span>
                            </p>
                            <p>
                                <i class="fas fa-calendar-alt text-muted"></i>
                                <span class="text-muted">Ngày đăng: ${o.postedDate}</span>
                            </p>
                            <div class="d-flex justify-content-between align-items-center">
                                <a href="details?aid=${o.id}" class="btn btn-primary">Xem chi tiết</a>
                                <i  class="fas fa-heart text-muted heart-icon" onclick="toggleFavorite(this)"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>


        <h2 class="mt-5 mb-4">Danh sách căn hộ thuê</h2>
            <div class="row">
                <c:forEach items="${listPP}" var="o">
                    <div class="col-md-4">
                        <div class="card">
                            <img src="/User/images/${o.img}" class="card-img-top" alt="Căn hộ 1">
                            <div class="card-body">
                                <h5 class="card-title">${o.name}</h5>
                                <p class="card-text">${o.describe}</p>
                                <p>
                                    <i class="fas fa-eye text-muted"></i>
                                    <span class="text-muted">${o.view} lượt xem</span>
                                </p>
                                <p>
                                    <i class="fas fa-calendar-alt text-muted"></i>
                                    <span class="text-muted">Ngày đăng: ${o.postedDate}</span>
                                </p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <a href="details?aid=${o.id}" class="btn btn-primary">Xem chi tiết</a>
                                    <i class="fas fa-heart text-muted heart-icon" onclick="toggleFavorite(this)"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <div class="container mt-5">
            <h2 class="mb-4">Căn hộ được đăng mới nhất</h2>
            <div class="row">
                <c:forEach items="${listN}" var="o">
                    <div class="col-md-4">
                        <div class="card">
                            <img src="<%= request.getContextPath() %>/User/images/${o.img}" class="card-img-top" alt="Căn hộ 1">
                            <div class="card-body">
                                <h5 class="card-title">${o.name}</h5>
                                <p class="card-text">${o.describe}</p>
                                <p>
                                    <i class="fas fa-eye text-muted"></i>
                                    <span class="text-muted">3500 lượt xem</span>
                                </p>
                                <p>
                                    <i class="fas fa-calendar-alt text-muted"></i>
                                    <span class="text-muted">Ngày đăng: ${o.postedDate}</span>
                                </p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <a href="<%= request.getContextPath() %>/User/html/product-details.html" class="btn btn-primary">Xem chi tiết</a>
                                    <i class="fas fa-heart text-muted heart-icon" onclick="toggleFavorite(this)"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>




                <div class="container mt-5">
                    <h2 class="mb-4">${res}</h2>
                    <div class="row">

                        <c:forEach items="${listS}" var="o">
                            <div class="col-md-4">
                                <div class="card">
                                    <img src="/User/images/${o.img}" class="card-img-top" alt="Căn hộ 1">
                                    <div class="card-body">
                                        <h5 class="card-title">${o.name}</h5>
                                        <p class="card-text">${o.describe}</p>
                                        <p>
                                            <i class="fas fa-eye text-muted"></i>
                                            <span class="text-muted">3500 lượt xem</span>
                                        </p>
                                        <p>
                                            <i class="fas fa-calendar-alt text-muted"></i>
                                            <span class="text-muted">Ngày đăng: ${o.postedDate}</span>
                                        </p>
                                        <div class="d-flex justify-content-between align-items-center">
                                            <a href="<%= request.getContextPath() %>/User/html/product-details.html" class="btn btn-primary">Xem chi tiết</a>
                                            <i class="fas fa-heart text-muted heart-icon" onclick="toggleFavorite(this)"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>





                        <div class="container mt-5">
                            <h2 class="mb-4">Danh sách căn hộ theo khu vực HCM</h2>
                            <div class="row">
                                <c:forEach items="${listHCM}" var="o">
                                    <div class="col-md-4">
                                        <div class="card">
                                            <img src="<%= request.getContextPath() %>/User/images/${o.img}" class="card-img-top" alt="Căn hộ 1">
                                            <div class="card-body">
                                                <h5 class="card-title">${o.name}</h5>
                                                <p class="card-text">${o.describe}</p>
                                                <p>
                                                    <i class="fas fa-eye text-muted"></i>
                                                    <span class="text-muted">3500 lượt xem</span>
                                                </p>
                                                <p>
                                                    <i class="fas fa-calendar-alt text-muted"></i>
                                                    <span class="text-muted">Ngày đăng: ${o.postedDate}</span>
                                                </p>
                                                <div class="d-flex justify-content-between align-items-center">
                                                    <a href="<%= request.getContextPath() %>/User/html/product-details.html" class="btn btn-primary">Xem chi tiết</a>
                                                    <i class="fas fa-heart text-muted heart-icon" onclick="toggleFavorite(this)"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>

    </div>
</div>


<footer class="footer">
    <div class="footer-section top">
        <div class="footer-brand">
            <img src="..LoGo.jpg" alt="Logo" class="footer-logo">
            <div>
                <p class="company-name">CÔNG TY CỔ PHẦN PROPERTYGURU VIỆT NAM</p>
                <address>
                    S1803, Vinhome grandpark Quận 9, Thủ Đức<br>
                    (84) 3562 5939 - (84) 3562 5940
                </address>
            </div>
            <div class="download-links">
                <img src="..google.pnj.png" alt="Google Play" class="app-icon">
                <img src="..app-store.jpg" alt="App Store" class="app-icon">
            </div>
        </div>
        <div class="footer-links">
            <div>
                <div>
                    Hotline<br>
                    <b>1900 1881 <br><br></b>
                </div>
                <h4>HƯỚNG DẪN</h4>
                <ul>
                    <li><a href="#">Về chúng tôi</a></li>
                    <li><a href="#">Báo giá và hỗ trợ</a></li>
                    <li><a href="#">Câu hỏi thường gặp</a></li>
                    <li><a href="#">Góp ý báo lỗi</a></li>
                    <li><a href="#">Sitemap</a></li>
                </ul>
            </div>
            <div>
                <div>
                    Hỗ trợ khách hàng<br>
                    <b>trogiup.mamxanhgroup.com.vn<br><br></b>
                </div>
                <h4>QUY ĐỊNH</h4>
                <ul>
                    <li><a href="#">Quy định đăng tin</a></li>
                    <li><a href="#">Quy chế hoạt động</a></li>
                    <li><a href="#">Điều khoản thỏa thuận</a></li>
                    <li><a href="#">Chính sách bảo mật</a></li>
                    <li><a href="#">Giải quyết khiếu nại</a></li>
                </ul>
            </div>
        </div>
        <div class="footer-subscribe">
            <div>
                Chăm sóc khách hàng<br>
                <b>hotro@mamxanhgroup.com.vn<br><br></b>
            </div>
            <h4>ĐĂNG KÝ NHẬN TIN</h4>
            <form>
                <input type="email" placeholder="Nhập email của bạn">
                <button type="submit">&#9654;</button>
            </form>
            <div class="language-select">
                <span>QUỐC GIA & NGÔN NGỮ</span>
                <select>
                    <option>Việt Nam</option>
                    <option>Singapo</option>
                    <option>Malaysia</option>
                    <option>Thailand</option>
                    <option>Indonesia</option>
                    <option>Australia</option>
                </select>
            </div>
        </div>
    </div>
    <hr>
    <div class="footer-section branches">
        <p><strong>Chi nhánh của Mamxanhgroup.com.vn</strong></p>
        <div class="branch-info">
            <div>
                <p><strong>Chi nhánh TP. Hồ Chí Minh</strong><br>S1803, Vinhome grandpark , Q.9, TP. Thủ Đức<br>Hotline:
                    1900 1881 - Mobile: 0904 893 279</p>
                <p><strong>Chi nhánh Đà Nẵng</strong><br>Tầng 9, Tòa nhà Vĩnh Trung Plaza, 255 - 257 Hùng Vương, Q.Thanh
                    Khê, TP. Đà Nẵng<br>Hotline: 1900 1881 - Mobile: 0904 907 279</p>
            </div>
            <div>
                <p><strong>Chi nhánh Hà Nội</strong><br>Đường Chu Huy Mân, Phường Phúc Lợi, Quận Long Biên, Hà Nội<br>Hotline:
                    1900 1881 - Mobile: 0903 456 322</p>
                <p><strong>Chi nhánh Vũng Tàu</strong><br>Tầng 4, Tòa nhà ACB, Hoàng Hoa Thám, P.2, TP. Vũng Tàu<br>Hotline:
                    1900 1881 - Mobile: 0904 509 293</p>
            </div>
            <div>
                <p><strong>Chi nhánh Bình Dương</strong><br>Phòng 10, tầng 16, Becamex Tower, ĐL Bình Dương, TP. Thủ Dầu
                    Một<br>Hotline: 1900 1881 - Mobile: 0919 255 580</p>
                <p><strong>Chi nhánh Nha Trang</strong><br>Tầng 6, Tòa nhà Điện Lực Khánh Hòa, Lý Thánh Tôn, TP. Nha
                    Trang<br>Hotline: 1900 1881 - Mobile: 0902 169 295</p>
            </div>
        </div>
    </div>
    <hr>
    <div class="footer-section bottom">
        <p>Copyright © 2007 - 2024 mamxanhgroup.com.vn <br>

            Giấy ĐKKD số 0104630479 do Sở KHĐT TP Hà Nội cấp lần đầu ngày 02/06/2010 <br>
            Giấy phép thiết lập trang thông tin điện tử tổng hợp trên mạng số 191/GP-TTĐT do<br>
            Sở TTTT Thành phố Hồ Chí Minh cấp ngày 31/08/2020</p>
        <p>Chịu trách nhiệm nội dung GP ICP: Bà Cao Bich Thùy<br>
            Chịu trách nhiệm sàn GDTMĐT: Ông Đặng Thành <br>
            Quy chế, quy định giao dịch có hiệu lực từ 08/08/2020<br>
            Ghi rõ nguồn "manxanhgroup.com.vn" khi phát hành lại thông tin từ website này.
        </p>
        <img src="..registered-icon.jpg" alt="Registered" class="social-icon"
             style="width: 100px; height: 40px;">
        <div class="social-icons">
            <img src="..face.pnj.jpg" alt="Facebook" class="social-icon">
            <img src="..youtube-icon.jpg" alt="YouTube" class="social-icon">
            <img src="..zalo-icon.jpg" alt="Facebook" class="social-icon">
        </div>
    </div>
</footer>
<script src="User/js/home.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>


