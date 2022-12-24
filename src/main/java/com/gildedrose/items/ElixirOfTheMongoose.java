package com.gildedrose.items;

public class ElixirOfTheMongoose extends GildedRoseItem {

    public ElixirOfTheMongoose(int sellIn, int quality) {
        this("Elixir of the Mongoose", sellIn, quality);
    }

    public ElixirOfTheMongoose(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void initialRule() {
        if (quality > 0) {
            --quality;
        }
    }

    @Override
    public void endRule() {
        --sellIn;

        if (sellIn < 0 && quality > 0) {
            --quality;
        }
    }
}
