document.addEventListener("DOMContentLoaded", async function () {
  const data = await fetchCategories();
  generateCategories(data);
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

async function generateCategories(categories) {
  var categoryContainer = document.getElementById("category_container");
  categoryContainer.innerHTML = "";

  categories.forEach((category) => {
    var categoryTag = document.createElement("a");
    categoryTag.href = `../templates/shop.html?categoryId=${category.id}`;
    categoryTag.className = 'dropdown-item';
    categoryTag.textContent = `${category.name}`;
    categoryContainer.appendChild(categoryTag);
  });
}
