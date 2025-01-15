<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Edit User</title>
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
    />
  </head>
  <body>
    <div class="container mt-5">
      <h2>Edit User</h2>
      <form action="account?action=update" method="post" class="mt-4">
        <input type="hidden" name="id" value="${apartment.id}" />

        <div class="mb-3">
          <label for="name" class="form-label">Name</label>
          <input
            type="text"
            class="form-control"
            id="name"
            name="name"
            value="${apartment.name}"
            required
          />
        </div>

        <div class="mb-3" hidden>
          <label for="roleID" class="form-label">Role ID</label>
          <input
            type="number"
            class="form-control"
            id="roleID"
            name="roleID"
            value="${apartment.roleID}"
            required
          />
        </div>

        <div class="mb-3">
          <label for="email" class="form-label">Email</label>
          <input
            type="email"
            class="form-control"
            id="email"
            name="email"
            value="${apartment.email}"
            required
          />
        </div>

        <div class="mb-3">
          <label for="password" class="form-label">Password</label>
          <input
            type="password"
            class="form-control"
            id="password"
            name="password"
            value="${apartment.password}"
            required
          />
        </div>

        <div class="mb-3">
          <label for="phone" class="form-label">Phone</label>
          <input
            type="text"
            class="form-control"
            id="phone"
            name="phone"
            value="${apartment.phone}"
            required
          />
        </div>

        <button type="submit" class="btn btn-primary">Update</button>
        <a href="account?action=list" class="btn btn-secondary">Cancel</a>
      </form>
    </div>
  </body>
</html>
