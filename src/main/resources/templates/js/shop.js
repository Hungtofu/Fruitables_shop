const size = 18;

document.addEventListener("DOMContentLoaded", async function () {
  var searchParams = new URLSearchParams(window.location.search);
  var categoryId = searchParams.get("categoryId");
  var response;
  console.log(categoryId);
  if (categoryId == null) {
    response = await fetchAllProducts(1);
  }
  var meta = response.meta;
  var products = response.productDTOList;

  displayProduct(products);

});

async function fetchAllProducts(page) {
  try {
    const response = await fetch(`http://localhost:8080/product/getall?page=${page}&size=${size}&sort=id,asc`, {
      method: "GET",
    });

    const data = await response.json();

    if (data.statusCode == 200) {
      return data.data;
    } else {
      return null;
    }
  } catch (error) {
    console.error("Error:", error);
    return null;
  }
}

function displayProduct(data) {
  console.log(data)
  var productContainer = document.getElementById("productList");
  productContainer.innerHTML = "";
  data.forEach((product) => {
    var productBox = document.createElement("div");
    productBox.className = "col-md-6 col-lg-6 col-xl-4";
    productBox.onclick = () => {
      window.location.href = `./shop-detail.html?id=${product.id}`;
    };
    productBox.innerHTML = `
  <div class="rounded position-relative fruite-item">
                                            <div class="fruite-img">
                                                <img src="../static/images/productImage/${product.image}" class="img-fluid w-100 rounded-top" style="height: 200px; width: 300px; object-fit: cover;">
                                            </div>
                                            <div class="text-white bg-secondary px-3 py-1 rounded position-absolute" style="top: 10px; left: 10px;">Fruits</div>
                                            <div class="p-4 border border-secondary border-top-0 rounded-bottom">
                                                <h4>${product.name}</h4>
                                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt</p>
                                                <div class="d-flex justify-content-between flex-lg-wrap">
                                                    <p class="text-dark fs-5 fw-bold mb-0">$${product.price} / kg</p>
                                                    <a href="#" class="btn border border-secondary rounded-pill px-3 text-primary"><i class="fa fa-shopping-bag me-2 text-primary"></i> Add to cart</a>
                                                </div>
                                            </div>
                                        </div>
  `;
  productContainer.appendChild(productBox);
  });
}

async function fetchProductByCategory(categoryId) {}
