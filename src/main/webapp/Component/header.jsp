
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>--%>
<header class="header-area header-sticky">
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <!-- Logo -->
            <a class="navbar-brand" href="<%= request.getContextPath() %>/User/html/home.html">
                <img src="<%= request.getContextPath() %>/User/images/LoGo.jpg" style="width: 50px; height: 50px">
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
                            <%--                            <c:forEach items="${listS}" var="o">--%>
                            <%--                                <li><a class="dropdown-item" href="categorySell?sid=${o.id}">${o.name}</a></li>--%>
                            <%--                            </c:forEach>--%>
                            <li><a class="dropdown-item" href="<%= request.getContextPath() %>/Căn%20hộ%20bán.jsp">Thuê căn hộ chung cư</a></li>
                            <li><a class="dropdown-item" href="#">Thuê chung cư mini</a></li>
                            <li><a class="dropdown-item" href="#">Thuê nhà riêng</a></li>
                            <li><a class="dropdown-item" href="#">Thuê biệt thự</a></li>
                            <li><a class="dropdown-item" href="#">Thuê nhà mặt phố</a></li>
                            <li><a class="dropdown-item" href="#">Thuê phòng trọ</a></li>
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
                        <a class="nav-link" href="<%= request.getContextPath() %>/User/html/tin%20tức.html">Tin tức</a>
                    </li>
                    <!-- Mục yêu thích(mục tin đã lưu) -->
                    <li class="nav-item">
                        <a class="nav-link" href="<%= request.getContextPath() %>/User/html/tindaluu.html"><i class="fas fa-heart"></i> Tin đã lưu</a>
                    </li>
                    <!-- Đăng nhập & Đăng ký -->
                    <li class="nav-item">
                        <a class="login.jsp" href="<%= request.getContextPath() %>/login.jsp">Đăng nhập</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%= request.getContextPath() %>/signup.jsp">Đăng ký</a>
                    </li>

                </ul>
            </div>
        </nav>
    </div>
</header>
