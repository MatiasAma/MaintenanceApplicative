package com.gildedrose;

public class Conjured extends StockItem {

    public Conjured(int sellIn, int quality) {
        super("Conjured", sellIn, quality);
    }

    @Override
    public void updateQuality() {
        this.quality = this.quality - 2;
        this.sellIn = this.sellIn - 1;
        if (this.sellIn < 0) {
            this.quality = this.quality - 2;
        }
        if (this.quality < 0) {
            this.quality = 0;
        }
    }
}
