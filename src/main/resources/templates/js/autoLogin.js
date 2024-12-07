document.addEventListener("DOMContentLoaded", async function () {
  var accessToken = localStorage.getItem("accessToken");
  let responseData;

  if (accessToken != null) {
    try {
      responseData = await fetchAccount(accessToken);

      if (responseData != null) {
        setAccountProfile(responseData);
      }
    } catch {
      console.error("Error fetching account data:", error);
    }

    responseData = fetchRefreshAccessToken();
    console.log(responseData);


    // if (responseData == null) {

    //   responseData = fetchRefreshAccessToken();
    //   console.log(responseData);

    // }
  }
});

function setAccountProfile(data) {
  const userProfile = document.getElementById("user_image_profile");
  userProfile.href = "./account.html";
  userProfile.innerHTML = `<img src="../static/images/userImage/${data.img}">`;
}

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

async function fetchRefreshAccessToken() {
  try {
    const response = await fetch("http://localhost:8080/login/refresh", {
      method: "GET",
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
