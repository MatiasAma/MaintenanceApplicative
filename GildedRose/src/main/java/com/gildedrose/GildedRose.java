package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            handleQuality(item);
        }
    }

    private void handleQuality(Item item) {
        if (item.name.equals("Aged Brie")) {
            handleBrie(item);
        } else if (item.name.equals("Backstage passes")) {
            handleBackstage(item);
        } else if (item.name.equals("Sulfuras")) {
            handleSulfuras(item);
        } else {
            handleOther(item);

        }
    }

    private void handleBrie(Item item) {
        if (item.name.equals("Aged Brie")) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
                item.sellIn = item.sellIn - 1;
                if (item.quality < 50 && item.sellIn < 0) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }

    private void handleBackstage(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
                if (item.sellIn < 6) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void handleSulfuras(Item item) {
    }

    private void handleOther(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
            item.sellIn = item.sellIn - 1;
            if (item.sellIn < 0) {
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }
            }
        }

    }
}


