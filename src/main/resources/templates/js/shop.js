var currentPage = 1;
const size = 18;
var sortType = "null";
var searchPromp = null;

var searchParams = new URLSearchParams(window.location.search);
var categoryId = null;

document.addEventListener("DOMContentLoaded", async function () {
  categoryId = searchParams.get("categoryId");
  searchPromp = searchParams.get("searchPromp");

  var response;
  if (categoryId == null) {
    if(searchPromp == null){
      response = await fetchAllProducts(currentPage, sortType);
    }else{
      response = await fetchFilteredProducts(currentPage, sortType, searchPromp);
    }
    
  } else {
    response = await fetchProductByCategory(categoryId, currentPage);
  }
  displayProduct(response);
});

async function changeSortType() {
  sortType = document.getElementById("sort_type").value;
  let response;
  if (categoryId == null) {
    response = await fetchAllProducts(currentPage);
  } else {
    response = await fetchProductByCategory(categoryId, currentPage);
  }
  displayProduct(response);
}

async function fetchAllProducts(currentPage) {
  let api = ``;
  if (sortType == "null") {
    api = `http://localhost:8080/product/getall?page=${currentPage}&size=${size}&sort=id,asc`;
  } else{
    api = `http://localhost:8080/product/getall?page=${currentPage}&size=${size}&sort=price,${sortType}`;
  };
  try {
    const response = await fetch(api, {
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

function displayProduct(response) {
  var data = response.productDTOList;
  var meta = response.meta;
  var productContainer = document.getElementById("productList");
  productContainer.innerHTML = "";

  data.forEach((product) => {
    var productBox = document.createElement("div");
    productBox.className = "col-md-6 col-lg-6 col-xl-4";
    // productBox.onclick = () => {
    //   window.location.href = `./shop-detail.html?id=${product.id}`;
    // };
    productBox.innerHTML = `
    <div class="rounded position-relative fruite-item">
                                              <div class="fruite-img" id="productImage">
                                                  <a href="./shop-detail.html?id=${product.id}"><img src="../static/images/productImage/${product.image}" class="img-fluid w-100 rounded-top" style="height: 200px; width: 300px; object-fit: cover;"></a>
                                              </div>
                                              
                                              <div class="p-4 border border-secondary border-top-0 rounded-bottom">
                                                  <h4>${product.name}</h4>
                                                  <p>Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt</p>
                                                  <div class="d-flex justify-content-between flex-lg-wrap">
                                                      <p class="text-dark fs-5 fw-bold mb-0">$${product.price} / kg</p>
                                                      <div class="btn border border-secondary rounded-pill px-3 text-primary" onclick = "fetchAdtoCart(${product.id}, 1)"><i class="fa fa-shopping-bag me-2 text-primary"></i> Add to cart</div>
                                                  </div>
                                              </div>
                                          </div>
  `;

    productContainer.appendChild(productBox);

    document.getElementById("productImage").onclick = () => {
      window.location.href = `./shop-detail.html?id=${product.id}`;
    };
  });

  var totalPages = meta.pages;
  var productPage = document.getElementById("paging");
  productPage.innerHTML = "";

  var prevButton = document.createElement("a");
  prevButton.className = "rounded";
  prevButton.innerHTML = "&laquo;";
  prevButton.onclick = function () {
    if (currentPage > 1) changePage(currentPage - 1, totalPages);
  };
  productPage.appendChild(prevButton);

  for (let i = 0; i < totalPages - 1; i++) {
    var pageNumber = document.createElement("a");
    pageNumber.className = "rounded";
    if (i + 1 == currentPage) {
      pageNumber.classList.add("active");
    }

    pageNumber.textContent = `${i + 1}`;
    pageNumber.onclick = function () {
      changePage(i + 1, meta);
    };
    productPage.appendChild(pageNumber);
  }

  var nextButton = document.createElement("a");
  nextButton.className = "rounded";
  nextButton.innerHTML = "&raquo;";
  nextButton.onclick = function () {
    if (currentPage < totalPages - 1) changePage(currentPage + 1, totalPages);
  };
  productPage.appendChild(nextButton);
}

async function changePage(page, totalPages) {
  if (page === "prev") {
    if (currentPage > 1) {
      currentPage--;
    }
  } else if (page === "next") {
    if (currentPage < totalPages) {
      currentPage++;
    }
  } else {
    currentPage = page;
  }
  console.log(currentPage);
  var response;
  if (categoryId == null) {
    response = await fetchAllProducts(currentPage);
  } else {
    response = await fetchProductByCategory(categoryId, currentPage);
  }
  displayProduct(response);
}

async function fetchAdtoCart(id, qty) {
  var accessToken = localStorage.getItem("accessToken");
  try {
    const request = {
      productId: id,
      qty: qty,
    };
    const response = await fetch(`http://localhost:8080/cart/additem`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${accessToken}`,
      },
      body: JSON.stringify(request),
    });
    const data = await response.json();
    if (data.statusCode == 200) {
      alert("add success");
      return data;
    } 
    if(data.statusCode == 401){
      alert("need account for purchase, please login")
    }
    return null;
    
  } catch (error) {
    return null;
  }
}

async function fetchProductByCategory(categoryId, currentPage) {
  let api = ``;
  if (sortType == "null") {
    api = `http://localhost:8080/product/category/${categoryId}?page=${currentPage}&size=${size}&sort=id,asc`;
  } else{
    api = `http://localhost:8080/product/category/${categoryId}?page=${currentPage}&size=${size}&sort=price,${sortType}`;
  };
  try {
    const response = await fetch(
      api,
      {
        method: "POST",
      }
    );

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


async function fetchFilteredProducts(currentPage, sortType, searchPromp) {
  let api = ``;
  if (sortType == "null") {
    api = `http://localhost:8080/product/filter?page=${currentPage}&size=${size}&sort=id,asc&filter=name~'${searchPromp}'`;
  } else{
    api = `http://localhost:8080/product/filter?page=${currentPage}&size=${size}&sort=price,${sortType}&filter=name~'${searchPromp}'`;
  };
  try {
    const response = await fetch(api, {
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

function searchProductsHeader(event) {
  if (event.key === "Enter") {
    let promp = document.getElementById("searchBody").value.toLowerCase();
    searching(promp);
  }
}

function searchProducts() {
  let promp = document.getElementById("searchBody").value.toLowerCase();
  searching(promp);
}

function searching(promp){
  window.location.href = `./shop.html?searchPromp=${promp}`;
}