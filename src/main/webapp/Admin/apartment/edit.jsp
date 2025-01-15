<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Edit Apartment</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
  </head>
  <body>
    <div class="container mt-4">
      <h1>Edit Apartment</h1>

      <form action="apartment?action=update" method="post">
        <input type="hidden" name="id" value="${apartment.id}" />

        <div class="mb-3">
          <label for="name" class="form-label">Name:</label>
          <input
            type="text"
            class="form-control"
            name="name"
            value="${apartment.name}"
            required
          />
        </div>

        <div class="mb-3">
          <label for="describe" class="form-label">Description:</label>
          <input
            type="text"
            class="form-control"
            name="describe"
            value="${apartment.describe}"
            required
          />
        </div>

        <div class="mb-3">
          <label for="price" class="form-label">Price:</label>
          <input
            type="number"
            class="form-control"
            name="price"
            value="${apartment.price}"
            required
          />
        </div>

        <div class="mb-3">
          <label for="area" class="form-label">Area:</label>
          <input
            type="number"
            class="form-control"
            name="area"
            value="${apartment.area}"
            required
          />
        </div>

        <div class="mb-3">
          <label for="bedroom" class="form-label">Bedroom:</label>
          <input
            type="number"
            class="form-control"
            name="bedroom"
            value="${apartment.bedroom}"
            required
          />
        </div>

        <div class="mb-3">
          <label for="bathroom" class="form-label">Bathroom:</label>
          <input
            type="number"
            class="form-control"
            name="bathroom"
            value="${apartment.bathroom}"
            required
          />
        </div>

        <div class="mb-3">
          <label for="toilet" class="form-label">Toilet:</label>
          <input
            type="number"
            class="form-control"
            name="toilet"
            value="${apartment.toilet}"
            required
          />
        </div>

        <div class="mb-3">
          <label for="interior" class="form-label">Interior:</label>
          <input
            type="text"
            class="form-control"
            name="interior"
            value="${apartment.interior}"
            required
          />
        </div>

        <div class="mb-3">
          <label for="legal" class="form-label">Legal:</label>
          <input
            type="text"
            class="form-control"
            name="legal"
            value="${apartment.legal}"
            required
          />
        </div>

        <!-- <div class="mb-3">
          <label for="postedDate" class="form-label">Posted Date:</label>
          <input
            type="datetime-local"
            class="form-control"
            name="postedDate"
            value="${apartment.postedDate}"
            required
          />
        </div> -->

        <!-- <div class="mb-3">
          <label for="viewCount" class="form-label">View Count:</label>
          <input
            type="number"
            class="form-control"
            name="viewCount"
            value="${apartment.viewCount}"
            required
          />
        </div> -->

        <div class="mb-3">
          <label for="nameAddress" class="form-label">Address:</label>
          <input
            type="text"
            class="form-control"
            name="nameAddress"
            value="${apartment.nameAddress}"
            required
          />
        </div>

        <button type="submit" class="btn btn-primary">Update Apartment</button>
      </form>

      <a href="/admin/apartment?action=list" class="btn btn-secondary mt-3"
        >Back to List</a
      >
    </div>

    <!-- Bootstrap JS (Optional) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
