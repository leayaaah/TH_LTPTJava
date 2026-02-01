/*
 * @ (#) Category        1.0     2/1/2026
 *
 * Copyright (c) 2026 IUH. All rights reserved.
 */

package iuh.fit.entity;

/*
 * @description:
 * @author: Thuy, Ly Thi
 * @version: 1.0
 * @created: 2/1/2026  7:39 AM
 */
public class Category {
    private String categoryId;
    private String name;

    public Category() {
    }

    public Category(String categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }
}

