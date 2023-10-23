package lk.ijse.thogakade.dto.tm;

/*
    @author DanujaV
    @created 10/23/23 - 3:05 PM   
*/

import javafx.scene.control.Button;

public class ItemTm {
    private String code;
    private String description;
    private double unitPrice;
    private int qtyOnHand;
    private Button btn;

    public ItemTm() {
    }

    public ItemTm(String code, String description, int qtyOnHand, double unitPrice, Button btn) {
        this.code = code;
        this.description = description;
        this.qtyOnHand = qtyOnHand;
        this.unitPrice = unitPrice;
        this.btn = btn;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "ItemTm{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", qty=" + qtyOnHand +
                ", unitPrice=" + unitPrice +
                ", btn=" + btn +
                '}';
    }
}
