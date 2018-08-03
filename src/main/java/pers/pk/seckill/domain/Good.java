package pers.pk.seckill.domain;

/**
 * @author panke
 * @date created in 8/3/18 1:57 PM
 */
public class Good {

    private Integer id;
    private String name;
    private String cover;
    private Integer stock;
    private Double price;
    private String description;

    public Good() {
    }

    public Good(Integer id, String name, String cover, Integer stock, Double price, String description) {
        this.id = id;
        this.name = name;
        this.cover = cover;
        this.stock = stock;
        this.price = price;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
