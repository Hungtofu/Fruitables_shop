document
  .getElementById("signin_form")
  .addEventListener("submit", function (event) {
    event.preventDefault();

    var email = document.getElementById("loginEmail").value;
    var password = document.getElementById("loginPassword").value;

    var request = {
      email: email, 
      password: password,
    };

    fetch("http://localhost:8080/login/signin", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },  
      body: JSON.stringify(request),
    })
      .then(response => response.json())
      .then(data => {
        console.log(data);
        if (data.statusCode == 200 && data.data != null) {
          alert("Login successful");
          document.getElementById("signin_form").reset();
          localStorage.setItem("accessToken", data.data.access_token);
          // window.location = "../templates/index.html";
        } else {
          alert("Login failed");
        }
      })
      .catch((error) => {
        console.error("Error:", error);
      });

  });
