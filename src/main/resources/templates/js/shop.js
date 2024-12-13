document.addEventListener('DOMContentLoaded', async function(){

    var searchParams = new URLSearchParams(window.location.search);
    var categoryId = searchParams.get("categoryId");
    console.log(categoryId);
    if(categoryId  == null){
        var page = document.getElementById().value;
        var data = await fetchAllProducts(page, size);
        console.log(data);
    }

})

async function fetchAllProducts(page, size){
    try {
        const response = await fetch("http://localhost:8080/product/getall", {
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

async function fetchProductByCategory(categoryId){
    
}