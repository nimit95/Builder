package com.uhack.builder.model;

/**
 * Created by nimit on 14/10/17.
 */

public class Inventory {
    public String InventoryId, InventoryName, InventoryQty;

    public Inventory(String inventoryId, String inventoryName, String inventoryQty) {

        InventoryId = inventoryId;
        InventoryName = inventoryName;
        InventoryQty = inventoryQty;
    }

    public String getInventoryId() {
        return InventoryId;
    }

    public String getInventoryName() {
        return InventoryName;
    }

    public String getInventoryQty() {
        return InventoryQty;
    }

    public void setInventoryId(String inventoryId) {
        InventoryId = inventoryId;
    }

    public void setInventoryName(String inventoryName) {
        InventoryName = inventoryName;
    }

    public void setInventoryQty(String inventoryQty) {
        InventoryQty = inventoryQty;
    }
}
