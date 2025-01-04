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
    cartItemBox.innerHTML = ` <th scope="row">
                                                <div class="d-flex align-items-center mt-2">
                                                    <img src="../static/images/productImage/${product.image}" class="img-fluid rounded-circle" style="width: 90px; height: 90px;" alt="">
                                                </div>
                                            </th>
                                            <td class="py-5">${product.productDTO.name}</td>
                                            <td class="py-5">$${product.productDTO.price}</td>
                                            <td class="py-5">${product.qty}</td>
                                            <td class="py-5">$${total}</td>`;
    cartItemContainer.appendChild(cartItemBox);
    subtotal = Math.ceil((subtotal + total) * 100) / 100;
  });
  var cartItemBox = document.createElement("tr");
  cartItemBox.innerHTML = `<th scope="row">
                                            </th>
                                            <td class="py-5">
                                                <p class="mb-0 text-dark text-uppercase py-3">TOTAL</p>
                                            </td>
                                            <td class="py-5"></td>
                                              <td class="py-5"></td>
                                            <td class="py-5">
                                                <div class="py-3 border-bottom border-top">
                                                    <p class="mb-0 text-dark">$${subtotal}</p>
                                                </div>
                                            </td>`;
  cartItemContainer.appendChild(cartItemBox);
  // document.getElementById("cartSubtotal").textContent = `$${subtotal}`;
  // document.getElementById("cartTotal").textContent = `$${subtotal + 2.0}`;
}

async function placeOrder() {
  var accessToken = localStorage.getItem("accessToken");
  var radios = document.getElementsByName("Delivery");

  var shippingMethodId;
  for (var i = 0; i < radios.length; i++) {
    if (radios[i].checked) {
      shippingMethodId = radios[i].value;
    }
  }
  const request = {
    userPaymentMethodId: 1,
    shippingMethodId: parseInt(shippingMethodId),
    deliveryInfomation: {
      firstName: document.getElementById("first_name").value,
      lastName: document.getElementById("last_name").value,
      phoneNumbers: document.getElementById("phone_numbers").value,
      address1: document.getElementById("address_1").value,
      address2: document.getElementById("address_2").value,
      commune: document.getElementById("commune").value,
      district: document.getElementById("district").value,
      province: document.getElementById("province").value,
    },
  };
  var response = await fetchPlaceOrder(accessToken, request);
}

async function fetchPlaceOrder(token, request) {
  try {
    const response = await fetch("http://localhost:8080/shoporder/checkout", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
      },
      body: JSON.stringify(request),
    });
    const data = await response.json();
    if (data.statusCode == 200) {
      alert("palce order successfully");
      window.location.href = `./shop.html`;
      return data.data;
    } else {
      return null;
    }
  } catch (error) {
    console.error("Error:", error);
    return null;
  }
}
