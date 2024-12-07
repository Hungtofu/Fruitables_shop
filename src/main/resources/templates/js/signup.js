document
  .getElementById("signup_form")
  .addEventListener("submit", function (event) {
    event.preventDefault();

    var email = document.getElementById("registerEmail").value;
    var userName = document.getElementById("registerUsername").value;
    var password = document.getElementById("registerPassword").value;
    var repeatPassword = document.getElementById(
      "registerRepeatPassword"
    ).value;

    if (!userName) {
      alert("Username can not be blank.");
      return;
    }

    if (password.length < 8) {
      alert("Password must be at least 8 characters.");
      return;
    }

    if (password !== repeatPassword) {
      alert("Password and Repeat Password mismatch.");
      return;
    }

    const request = {
      username: userName,
      email: email,
      password: password,
    };

    fetch("http://localhost:8080/login/signup", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(request),
    })
      .then(response => response.json())
      .then(data =>{
        if (data.statusCode == 200 && data.data != null) {
          alert("Registration successful");
          document.getElementById("signup_form").reset();
          window.location = "../templates/signin.html";
        } else {
          alert("Registration failed");
        }
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  });
