package com.supinfo.store;

import com.supinfo.common.DataModel;
import com.supinfo.store.inventory.Inventory;
import com.supinfo.store.inventory.InventoryController;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class StoreModel implements DataModel<Store> {
    private final List<Store> stores = new ArrayList<>();
    private final InventoryController inventoryController;

    @Override
    public Store load(UUID id) {
        Store store = null;
        for(Store storedStore : this.stores) {
            if(storedStore.getId() == id) {
                store = storedStore;
                break;
            }
        }
        return store;
    }

    @Override
    public Store create(Object... args) {
        Store store = new Store((Inventory) args[0], (String) args[1], (UUID) args[2]);
        this.stores.add(store);
        return store;
    }

    @Override
    public boolean delete(Store store) {
        return this.stores.remove(store);
    }

    @Override
    public boolean update(Store store) {
        return false;
    }
}