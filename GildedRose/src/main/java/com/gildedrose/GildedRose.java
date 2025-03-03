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
        } else {
            if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes")) {
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras")) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals("Backstage passes")) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals("Sulfuras")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                }
            }
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
}


