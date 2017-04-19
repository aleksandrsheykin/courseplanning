package main.models.pojo;

import java.util.Date;

/**
 * Created by admin on 19.04.2017.
 */
public class Plan {
    private Integer id_plan;
    private Date datePlan;
    private int quantity;
    private int cost;
    private int user_id;
    private int product_id;

    public Plan(Integer id_plan, Date datePlan, int quantity, int cost, int user_id, int product_id) {
        this.id_plan = id_plan;
        this.datePlan = datePlan;
        this.quantity = quantity;
        this.cost = cost;
        this.user_id = user_id;
        this.product_id = product_id;
    }

    public Integer getId_plan() {
        return id_plan;
    }

    public void setId_plan(Integer id_plan) {
        this.id_plan = id_plan;
    }

    public Date getDatePlan() {
        return datePlan;
    }

    public void setDatePlan(Date datePlan) {
        this.datePlan = datePlan;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user) {
        this.user_id = user;
    }

    public int getProductId() {
        return product_id;
    }

    public void setProductId(int product_id) {
        this.product_id = product_id;
    }
}
