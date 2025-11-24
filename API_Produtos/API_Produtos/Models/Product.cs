namespace API_Produtos.Models;

public class Product
{
    public string name { get; set; }
    public string category { get; set; }
    public string description { get; set; }
    public float price { get; set; }
    public int stock { get; set; }
    public char restriction { get; set; }
}
