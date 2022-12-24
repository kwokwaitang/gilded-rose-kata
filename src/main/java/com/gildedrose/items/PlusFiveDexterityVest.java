package com.gildedrose.items;

public class PlusFiveDexterityVest extends GildedRoseItem {

    public PlusFiveDexterityVest(int sellIn, int quality) {
        this("+5 Dexterity Vest", sellIn, quality);
    }

    public PlusFiveDexterityVest(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    // Same rule as "Elixir of the Mongoose"
    @Override
    public void itemRules() {
        if (quality > 0) {
            --quality;
        }

        --sellIn;

        if (sellIn < 0) {
            if (quality > 0) {
                --quality;
            }
        }
    }
}
