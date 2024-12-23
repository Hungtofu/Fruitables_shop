const buttons = document.querySelectorAll(".list-group-item-action");
buttons.forEach((button) => {
  button.addEventListener("click", () => {
    const target = button.getAttribute("data-target");

    document.querySelectorAll(".p-3.bg-light").forEach((section) => {
      section.classList.add("d-none");
    });

    buttons.forEach((btn) => btn.classList.remove("active"));

    if (target) {
      document.getElementById(target).classList.remove("d-none");
      button.classList.add("active");
    }
  });
});

document.addEventListener("DOMContentLoaded", async function () {
  var accessToken = localStorage.getItem("accessToken");
  let responseData;

  var userInfoData = await fetchAccount(accessToken);
  showInfo(userInfoData);
});

async function fetchAccount(accessToken) {
  try {
    const response = await fetch("http://localhost:8080/user/account", {
      method: "GET",
      headers: {
        Authorization: `Bearer ${accessToken}`,
      },
      credentials: "include",
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

function showInfo(data) {
  document.getElementById("displayUserName").textContent =
    data.userName || "N/A";
  document.getElementById("displayEmail").textContent = data.email || "N/A";
  document.getElementById("displayGender").textContent =
    capitalizeFirstLetter(data.gender) || "N/A";
  document.getElementById("displayDOB").textContent =
    formatDate(data.dob) || "N/A";
  const image = document.getElementById("displayImageProfile")
  if (image) {
    image.src = `../static/images/userImage/${data.image}`;
  } else {
    console.error("Thẻ <img> không tồn tại trong DOM");
  }
}

function formatDate(dob) {
  const date = new Date(dob); 
  const year = date.getFullYear();
  const month = String(date.getMonth() + 1).padStart(2, "0");
  const day = String(date.getDate()).padStart(2, "0");
  return `${year}-${month}-${day}`;
}

function capitalizeFirstLetter(str) {
  return str.charAt(0).toUpperCase() + str.slice(1).toLowerCase();
}

document
  .getElementById("update_form")
  .addEventListener("submit", function (event) {
    event.preventDefault();

    var userName = document.getElementById("updateName").value;
    var gender = document.getElementById("updateGender").value;
    var dob = document.getElementById("updateDOB").value;
    dob = new Date(dob).toISOString();
    var image = document.getElementById("updateImageProfile").files[0];

    const formData = new FormData();
    formData.append(
      "userUpdate",
      new Blob([JSON.stringify({ userName, dob, gender })], {
        type: "application/json",
      })
    ); // Thông tin người dùng
    if (image) {
      formData.append("file", image); // Ảnh đại diện
    }

    var accessToken = localStorage.getItem("accessToken");

    fetch("http://localhost:8080/user/update", {
      method: "PUT",
      headers: {
        Authorization: `Bearer ${accessToken}`,
      },
      body: formData,
    })
      .then((response) => response.json())
      .then((data) => {
        if (data.statusCode == 200 && data.data != null) {
          alert("Update successful");
          fetchAccount(accessToken);
        } else {
          alert("Update failed");
        }
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  });

function showHistory() {}

function showDeliveryInformation() {}

function logOut() {}
