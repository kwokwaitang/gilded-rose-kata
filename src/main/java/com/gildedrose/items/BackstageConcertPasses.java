package com.gildedrose.items;

public class BackstageConcertPasses extends GildedRoseItem {

    public BackstageConcertPasses(int sellIn, int quality) {
        this("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    public BackstageConcertPasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void itemRules() {
        if (quality < 50) {
            ++quality;
            if (sellIn < 11) {
                if (quality < 50) {
                    ++quality;
                }

                if (sellIn < 6) {
                    if (quality < 50) {
                        ++quality;
                    }
                }
            }
        }

        --sellIn;

        if (sellIn < 0) {
            if (quality > 0) {
                quality -= quality;
            }
        }
    }
}
