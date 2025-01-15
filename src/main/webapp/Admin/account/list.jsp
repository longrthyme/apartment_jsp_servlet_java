<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>User List</title>
    <!-- Bootstrap CSS -->
    <link
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <style>
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
    </style>
  </head>
  <body>
    <div class="container mt-4">
      <h2>User List</h2>

      <%-- Display error message if present --%>
      <c:if test="${not empty sessionScope.errorMessage}">
        <div class="alert alert-danger">${sessionScope.errorMessage}</div>
        <%-- Remove the error message from session after displaying --%>
        <c:remove var="errorMessage" scope="session" />
      </c:if>

      <a href="account?action=add" class="add-new-btn">Add New User </a>

      <!-- Table to display users -->
      <table class="table table-bordered">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>

            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          <!-- Iterate through the 'users' attribute set in the servlet -->
          <c:forEach var="user" items="${users}">
            <tr>
              <td>${user.id}</td>
              <td>${user.name}</td>
              <td>${user.email}</td>
              <td>${user.phone}</td>

              <td>
                <!-- Example: Add edit and delete buttons (you can implement them later) -->
                <a
                  href="account?action=edit&id=${user.id}"
                  class="btn btn-primary btn-sm"
                  >Edit</a
                >
                <a
                  href="account?action=delete&id=${user.id}"
                  class="btn btn-danger btn-sm"
                  >Delete</a
                >
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  </body>
</html>
