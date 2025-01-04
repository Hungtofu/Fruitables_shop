document.addEventListener("DOMContentLoaded", async function () {
  var searchParams = new URLSearchParams(window.location.search);
  var productId = searchParams.get("id");

  var response = await fetchProductDetail(productId);
  displayProductInfo(response.data);
  response = await fetchProductReviews(productId);
  dispayReview(response.data);
});

async function fetchProductDetail(id) {
  try {
    const response = await fetch(`http://localhost:8080/product/${id}`, {
      method: "POST",
    });
    const data = await response.json();
    if (data.statusCode == 200) {
      return data;
    } else {
      alert("Fetch failed");
      return null;
    }
  } catch (error) {
    console.error("Error:", error);
    return null;
  }
}

async function fetchProductReviews(id) {
  try {
    const response = await fetch(`http://localhost:8080/review/product/${id}`, {
      method: "POST",
    });
    data = await response.json();
    if (data.statusCode == 200) {
      return data;
    } else {
      alert("Fetch failed");
      return null;
    }
  } catch (error) {
    console.error("Error:", error);
    return null;
  }
}

function displayProductInfo(data) {
  document.getElementById("product_name").textContent = data.name;
  document.getElementById("product_category").textContent = data.category.name;
  document.getElementById("product_price").textContent = `${data.price}$`;
  document.getElementById("product_description").textContent =
    data.description || "Không có mô tả.";
  document.getElementById(
    "mainImage"
  ).src = `../static/images/productImage/${data.image[0]}`;

  var imageContainer = document.getElementById("product_images");
  imageContainer.innerHTML = "";
  data.image.forEach((image) => {
    imageTag = document.createElement("img");
    imageTag.classList.add("thumbnail");
    imageTag.src = `../static/images/productImage/${image}`;
    imageTag.setAttribute("onclick", "changeMainImage(this)");
    imageContainer.appendChild(imageTag);
  });
}

function changeMainImage(thumbnail) {
  const mainImage = document.getElementById("mainImage");
  mainImage.src = thumbnail.src;
  document
    .querySelectorAll(".thumbnail")
    .forEach((img) => img.classList.remove("active"));
  thumbnail.classList.add("active");
}

async function dispayReview(reviews) {
  document.getElementById("avg_stars").innerHTML = generateAVGStars(
    reviews.avgRatingPoint
  );

  var reviewContainer = document.getElementById("review_container");
  reviewContainer.innerHTML = "";
  reviews.reviewsList.forEach((review) => {
    var reviewDiv = document.createElement("div");
    reviewDiv.classList.add("d-flex");
    reviewDiv.innerHTML = `
        <img src="img/avatar.jpg" class="img-fluid rounded-circle p-3" style="width: 100px; height: 100px;" alt="">
        <div style="width: 100%;">
        <p class="mb-2" style="font-size: 14px;">April 12, 2024</p>
          <div class="d-flex flex-row justify-content-between" >
            <h5>${review.name}</h5>
            <div class="d-flex mb-3">
              ${generateStars(review.ratingPoint)}
            </div>
          </div>
          <p >${review.comment}</p>
        </div>
      `;
    reviewContainer.appendChild(reviewDiv);
  });
  generateAVGStars();
}

function generateStars(rating) {
  let starsHTML = "";
  for (let i = 1; i <= 5; i++) {
    starsHTML += `<i class="fa fa-star ${
      i <= rating ? "text-secondary" : ""
    }"></i>`;
  }
  return starsHTML;
}

function generateAVGStars(rating) {
  const fullStars = Math.floor(rating);
  const halfStars = rating % 1 >= 0.5 ? 1 : 0;
  const emptyStars = 5 - fullStars - halfStars;

  let starsHTML = "";

  for (let i = 0; i < fullStars; i++) {
    starsHTML += '<i class="fa fa-star text-secondary"></i>';
  }

  if (halfStars === 1) {
    starsHTML += '<i class="fa fa-star-half text-secondary"></i>';
  }

  for (let i = 0; i < emptyStars; i++) {
    starsHTML += '<i class="fa fa-star"></i>';
  }

  return starsHTML;
}

function addToCart(event) {
  event.preventDefault();
  var searchParams = new URLSearchParams(window.location.search);
  var productId = searchParams.get("id");
  var qty = document.getElementById("product_qty").value;
  var accessToken = localStorage.getItem("accessToken");

  var response = fetchAdtoCart(productId, accessToken, qty);
}

async function fetchAdtoCart(productId, token, qty) {
  try {
    const request = {
      productId: productId,
      qty: qty,
    };
    const response = await fetch(`http://localhost:8080/cart/additem`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
      },
      body: JSON.stringify(request),
    });
    const data = await response.json();
    if (data.statusCode == 200) {
      alert("add successfully")
      return data;
    }
    if (data.statusCode == 401) {
      alert("require signin for purchase!");
    }
    return null;
  } catch (error) {
    return null;
  }
}

async function postReview(){
  var searchParams = new URLSearchParams(window.location.search);
  var productId = searchParams.get("id");
  const request = {
    productId: productId,
    name: document.getElementById("usrer_review_name").value,
    email: document.getElementById("usrer_review_email").value,
    ratingValue: document.getElementById("rating_point").value,
    cmt: document.getElementById("user_review").value
  }
  console.log(request);
  try {
    const response = await fetch(`http://localhost:8080/review/post`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(request),
    });
    const data = await response.json();
    if (data.statusCode == 200) {
      alert("post successful")
      return data;
    }
    if (data.statusCode == 401) {
      alert("error");
    }
    return null;
  } catch (error) {
    return null;
  }
}