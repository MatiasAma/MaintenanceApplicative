package com.gildedrose;

public class Brie extends StockItem {

    public Brie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (this.quality < 50) {
            this.quality = this.quality + 1;
            this.sellIn = this.sellIn - 1;
            if (this.quality < 50 && this.sellIn < 0) {
                this.quality = this.quality + 1;
            }
        }

    }
}
