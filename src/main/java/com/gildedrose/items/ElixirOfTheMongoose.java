package com.gildedrose.items;

public class ElixirOfTheMongoose extends GildedRoseItem {

    public ElixirOfTheMongoose(int sellIn, int quality) {
        this("Elixir of the Mongoose", sellIn, quality);
    }

    public ElixirOfTheMongoose(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    // Same rule as "+5 Dexterity Vest"
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
