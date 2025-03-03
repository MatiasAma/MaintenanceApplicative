package com.gildedrose;

public abstract class StockItem extends Item {
    public StockItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public abstract void updateQuality();
}
