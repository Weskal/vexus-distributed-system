using API_Produtos.Models;
using Microsoft.AspNetCore.Mvc;

namespace API_Produtos.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class ProductController : ControllerBase
    {
        private static List<Product> products = new List<Product>();

        [HttpPost]
        public void AddProduct([FromBody] Product product)
        {
            products.Add(product);
        }
    }
}
