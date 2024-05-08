package com.heima.mapper;
import com.heima.pojo.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Insert("        insert into db1.t_product(shopID, addIDs, productName, price, productType, category, image, lastUpdateBy, createTime, updateTime)\n" +
            "        values (\n" +
            "        #{shopID}, #{addIDs}, #{productName}, #{price}, #{productType}, #{category}, #{image}, #{lastUpdateBy}, NOW(), NOW()\n" +
            "        )")
    @Options(useGeneratedKeys = true, keyProperty = "productID", keyColumn = "productID")
    public void insert(Product product);

    int delete(List<Integer> ids);

    int update(Product product);

    int updateCategory(Integer shopID, String oldCategory, String newCategory);

    List<Product> selectAll();

    List<Product> selectByProductName(String account);

    Product selectByID(Integer productID);

    List<Product> selectByIDs(List<Integer> ids);

    List<Product> selectByShopID(Integer shopID);
}
