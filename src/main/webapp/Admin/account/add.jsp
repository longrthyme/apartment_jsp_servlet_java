<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Add New User</title>
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
    />
  </head>
  <body>
    <div class="container mt-5">
      <h2 class="mb-4">Add New User</h2>
      <form
        action="<%= request.getContextPath() %>/admin/account?action=add"
        method="post"
      >
        <div class="mb-3">
          <label for="name" class="form-label">Name</label>
          <input
            type="text"
            class="form-control"
            id="name"
            name="name"
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
            required
          />
        </div>

        <div class="mb-3" hidden>
          <label for="roleID" class="form-label">Role</label>
          <select class="form-select" id="roleID" name="roleID" required>
            <option value="0" selected>Admin</option>
            <option value="1">User</option>
          </select>
        </div>

        <button type="submit" class="btn btn-primary">Add User</button>
        <a
          href="<%= request.getContextPath() %>/admin/account?action=list"
          class="btn btn-secondary"
          >Cancel</a
        >
      </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
