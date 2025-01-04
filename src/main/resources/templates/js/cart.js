document.addEventListener("DOMContentLoaded", async function () {
  var accessToken = localStorage.getItem("accessToken");
  var response = await fetchAllCartItem(accessToken);
  displayProduct(accessToken, response);
});

async function fetchAllCartItem(token) {
  try {
    const response = await fetch("http://localhost:8080/cart/items", {
      method: "GET",
      headers: {
        Authorization: `Bearer ${token}`,
      },
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

function displayProduct(token, products) {
  var cartItemContainer = document.getElementById("cart_item_container");
  cartItemContainer.innerHTML = "";
  var subtotal = 0.0;
  products.forEach((product) => {
    var cartItemBox = document.createElement("tr");
    var total = product.productDTO.price * product.qty;
    total = Math.ceil(total * 100) / 100;
    cartItemBox.innerHTML = `<th scope="row">
                                    <div class="d-flex align-items-center">
                                        <img src="../static/images/productImage/${product.image}" class="img-fluid me-5 rounded-circle" style="width: 80px; height: 80px;" alt="">
                                    </div>
                                </th>
                                <td>
                                    <p class="mb-0 mt-4">${product.productDTO.name}</p>
                                </td>
                                <td>
                                    <p class="mb-0 mt-4">${product.productDTO.price}$</p>
                                </td>
                                <td>
                                    <div class="input-group quantity mt-4" style="width: 100px;">
                                        <div class="input-group-btn">
                                            <button class="btn btn-sm btn-minus rounded-circle bg-light border" onclick="changeQty(0,${product.id})">
                                            <i class="fa fa-minus"></i>
                                            </button>
                                        </div>
                                        <div class=" text-center border-0" style="width: 40px;">${product.qty}</div>
                                        <div class="input-group-btn">
                                            <button class="btn btn-sm btn-plus rounded-circle bg-light border" onclick="changeQty(1,${product.id})">
                                                <i class="fa fa-plus"></i>
                                            </button>
                                        </div>
                                    </div>
                                </td>
                                <td>
                                    <p class="mb-0 mt-4">${total} $</p>
                                </td>
                                <td>
                                    <button class="btn btn-md rounded-circle bg-light border mt-4" onclick="deleteCartItem(${product.id})">
                                        <i class="fa fa-times text-danger"></i>
                                    </button>
                                </td>`;
    cartItemContainer.appendChild(cartItemBox);
    subtotal = Math.ceil((subtotal + total) * 100) / 100;
  });
  document.getElementById("cartSubtotal").textContent = `$${subtotal}`;
  document.getElementById("cartTotal").textContent = `$${subtotal + 2.0}`;
}

async function changeQty(index, cartItemId) {
  var accessToken = localStorage.getItem("accessToken");
  if (index == 1) {
    fetchIncreaseQty(cartItemId);
  } else {
    fetchDecreaseQty(cartItemId);
  }
  var response = await fetchAllCartItem(accessToken);
  displayProduct(accessToken, response);
}

async function fetchIncreaseQty(cartItemId) {
  var accessToken = localStorage.getItem("accessToken");
  try {
    const response = await fetch(
      `http://localhost:8080/cart/item/increase/${cartItemId}`,
      {
        method: "POST",
        headers: {
          Authorization: `Bearer ${accessToken}`,
        },
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

async function fetchDecreaseQty(cartItemId) {
  var accessToken = localStorage.getItem("accessToken");
  try {
    const response = await fetch(
      `http://localhost:8080/cart/item/decrease/${cartItemId}`,
      {
        method: "POST",
        headers: {
          Authorization: `Bearer ${accessToken}`,
        },
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

async function deleteCartItem(cartItemId) {
  var accessToken = localStorage.getItem("accessToken");
  fetchDeleteQty(cartItemId);
  var response = await fetchAllCartItem(accessToken);
  displayProduct(accessToken, response);
}

async function fetchDeleteQty(cartItemId) {
  var accessToken = localStorage.getItem("accessToken");
  try {
    const response = await fetch(
      `http://localhost:8080/cart/delete/${cartItemId}`,
      {
        method: "POST",
        headers: {
          Authorization: `Bearer ${accessToken}`,
        },
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

function checkout(){
    window.location.href = `./checkout.html`;
}
