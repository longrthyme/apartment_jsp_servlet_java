<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Add Apartment</title>
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
    />
  </head>
  <body>
    <div class="container mt-5">
      <h2>Add New Apartment</h2>
      <form action="apartment?action=add" method="POST">
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
          <label for="describe" class="form-label">Description</label>
          <textarea
            class="form-control"
            id="describe"
            name="describe"
            rows="3"
            required
          ></textarea>
        </div>
        <div class="mb-3">
          <label for="price" class="form-label">Price</label>
          <input
            type="number"
            class="form-control"
            id="price"
            name="price"
            step="0.01"
            required
          />
        </div>
        <div class="mb-3">
          <label for="area" class="form-label">Area (sqm)</label>
          <input
            type="number"
            class="form-control"
            id="area"
            name="area"
            step="0.01"
            required
          />
        </div>
        <div class="mb-3">
          <label for="bedroom" class="form-label">Bedroom</label>
          <input
            type="number"
            class="form-control"
            id="bedroom"
            name="bedroom"
            required
          />
        </div>
        <div class="mb-3">
          <label for="bathroom" class="form-label">Bathroom</label>
          <input
            type="number"
            class="form-control"
            id="bathroom"
            name="bathroom"
            required
          />
        </div>
        <div class="mb-3">
          <label for="toilet" class="form-label">Toilet</label>
          <input
            type="number"
            class="form-control"
            id="toilet"
            name="toilet"
            required
          />
        </div>
        <div class="mb-3">
          <label for="interior" class="form-label">Interior</label>
          <input
            type="text"
            class="form-control"
            id="interior"
            name="interior"
            required
          />
        </div>
        <div class="mb-3">
          <label for="legal" class="form-label">Legal</label>
          <input
            type="text"
            class="form-control"
            id="legal"
            name="legal"
            required
          />
        </div>
        <div class="mb-3">
          <label for="legal" class="form-label">Address</label>
          <input
            type="text"
            class="form-control"
            id="nameAddress"
            name="nameAddress"
            required
          />
        </div>
        <button type="submit" class="btn btn-primary">Add Apartment</button>
      </form>
    </div>
  </body>
</html>
