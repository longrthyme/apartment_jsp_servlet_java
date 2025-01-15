<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1.0, user-scalable=0"
    />
    <title>Bảng Quản Lý Căn Hộ</title>
    <link
      rel="shortcut icon"
      type="image/x-icon"
      href="assets/img/favicon.png"
    />
    <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
    <link
      rel="stylesheet"
      href="assets/plugins/fontawesome/css/fontawesome.min.css"
    />
    <link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css" />
    <link
      rel="stylesheet"
      href="assets/plugins/datatables/datatables.min.css"
    />
    <link rel="stylesheet" href="assets/css/feathericon.min.css" />
    <link rel="stylesheet" href="assets/plugins/morris/morris.css" />
    <link rel="stylesheet" href="assets/css/style.css" />
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"
      rel="stylesheet"
    />

    <style>
      body {
        font-family: "Arial", sans-serif;
        background-color: #f4f4f9;
      }

      h1 {
        text-align: center;
        margin-top: 20px;
        color: #333;
        font-size: 28px;
      }

      a.add-new-btn {
        display: inline-block;
        background-color: #28a745;
        color: white;
        padding: 10px 20px;
        margin: 20px 0;
        border-radius: 5px;
        text-decoration: none;
      }

      a.add-new-btn:hover {
        background-color: #218838;
      }

      table {
        width: 100%;
        margin: 20px 0;
        border-collapse: collapse;
        background-color: #ffffff;
        border-radius: 8px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
      }

      th,
      td {
        padding: 12px;
        text-align: left;
        border-bottom: 1px solid #ddd;
      }

      th {
        background-color: #007bff;
        color: white;
      }

      tr:nth-child(even) {
        background-color: #f9f9f9;
      }

      tr:hover {
        background-color: #f1f1f1;
      }

      .actions a {
        margin: 0 5px;
        padding: 6px 12px;
        border-radius: 5px;
        color: white;
        text-decoration: none;
      }

      .actions a.edit {
        background-color: #007bff;
      }

      .actions a.delete {
        background-color: #dc3545;
      }

      .actions a:hover {
        opacity: 0.8;
      }

      .actions a.delete:hover {
        background-color: #c82333;
      }

      .delete {
        margin-top: 5px;
        display: block;
      }
    </style>
  </head>

  <body>
    <div class="container">
      <!-- Page Title -->
      <h1>Apartment List</h1>

      <!-- Add New Apartment Button -->
      <a href="apartment?action=add" class="add-new-btn">Add New Apartment</a>

      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Area</th>
            <th>Bedroom</th>
            <th>Bathroom</th>
            <th>Toilet</th>
            <th>Interior</th>
            <th>Legal</th>
            <th>Posted Date</th>
            <th>URL</th>
            <th>View Count</th>
            <th>Address</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="apartment" items="${apartments}">
            <tr>
              <td>${apartment.id}</td>
              <td>${apartment.name}</td>
              <td>${apartment.describe}</td>
              <td>${apartment.price}</td>
              <td>${apartment.area}</td>
              <td>${apartment.bedroom}</td>
              <td>${apartment.bathroom}</td>
              <td>${apartment.toilet}</td>
              <td>${apartment.interior}</td>
              <td>${apartment.legal}</td>
              <td>${apartment.postedDate}</td>
              <!-- Use formattedPostedDate -->
              <td><a href="${apartment.url}" target="_blank">View Image</a></td>
              <td>${apartment.viewCount}</td>
              <td>${apartment.nameAddress}</td>
              <td class="actions">
                <a href="apartment?action=edit&id=${apartment.id}" class="edit"
                  >Edit</a
                >
                <a
                  href="apartment?action=delete&id=${apartment.id}"
                  class="delete"
                  >Delete</a
                >
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>

    <script
      data-cfasync="false"
      src="../../../cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"
    ></script>
    <script src="assets/js/jquery-3.5.1.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="assets/plugins/datatables/datatables.min.js"></script>
    <script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="assets/plugins/raphael/raphael.min.js"></script>
    <script src="assets/js/script.js"></script>
  </body>
</html>
