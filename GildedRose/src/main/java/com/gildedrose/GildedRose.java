package com.gildedrose;

class GildedRose {
    StockItem[] items;

    public GildedRose(Item[] items) {
        StockItem[] stockItems = new StockItem[items.length];
        for (int i = 0; i < items.length; i++) {
            stockItems[i] = factoItem(items[i]);
        }
        this.items = stockItems;
    }

    public void updateQuality() {
        for (StockItem item : items) {
            handleQuality(item);
        }
    }

    private void handleQuality(StockItem item) {
        item.updateQuality();
    }

    public StockItem factoItem(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new Brie(item.sellIn, item.quality);
            case "Backstage passes":
                return new Backstage(item.sellIn, item.quality);
            case "Sulfuras":
                return new Sulfuras(item.sellIn, item.quality);
            case "Conjured":
                return new Conjured(item.sellIn, item.quality);
            default:
                return new Other(item.name, item.sellIn, item.quality);
        }
    }
}


