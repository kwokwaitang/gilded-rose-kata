package com.gildedrose.items;

public class ConjuredManaCake extends GildedRoseItem {

    public ConjuredManaCake(int sellIn, int quality) {
        this("Conjured Mana Cake", sellIn, quality);
    }

    public ConjuredManaCake(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void initialRule() {
        if (quality > 0) {
            quality -= 2;
        }
    }

    @Override
    public void endRule() {
        --sellIn;

        if (sellIn < 0) {
            if (quality > 0) {
                --quality;
            }
        }
    }
}
