document.addEventListener("DOMContentLoaded", async function () {
  const data = await fetchCategories();
  displayCategories(data);
});

async function fetchCategories() {
    try {
      const response = await fetch("http://localhost:8080/category/getall", {
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

async function displayCategories(categories) {
    var categoryContainer = document.getElementById("list_category");
    categoryContainer.innerHTML = "";
  
    categories.forEach((category) => {
      var categoryTag = document.createElement("li");
      categoryTag.classList.add("nav-item")
      categoryTag.innerHTML = `<li class="nav-item">
                                    <a class="d-flex m-2 py-2 bg-light rounded-pill" data-bs-toggle="pill" href="#tab-1">
                                        <span class="text-dark" style="width: 130px;">${category.name}</span>
                                    </a>
                                </li>`;
      categoryContainer.appendChild(categoryTag);
    });
  }