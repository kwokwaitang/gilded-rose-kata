package com.gildedrose.items;

public class AgedBrie extends GildedRoseItem {

    public AgedBrie(int sellIn, int quality) {
        this("Aged Brie", sellIn, quality);
    }

    public AgedBrie(final String name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void itemRules() {
        if (quality < 50) {
            ++quality;
        }

        --sellIn;

        if (sellIn < 0) {
            if (quality < 50) {
                ++quality;
            }
        }
    }
}
