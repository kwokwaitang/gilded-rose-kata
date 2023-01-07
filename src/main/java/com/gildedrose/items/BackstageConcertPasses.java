package com.gildedrose.items;

import com.gildedrose.Item;

public class BackstageConcertPasses extends GildedRoseItem {

    public BackstageConcertPasses(Item item) {
        super(item);
    }

    public BackstageConcertPasses(int sellIn, int quality) {
        this(new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality));
    }

    @Override
    public void initialRule() {
        if (item.quality < 50) {
            ++item.quality;
            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    ++item.quality;
                }

                if (item.sellIn < 6 && item.quality < 50) {
                    ++item.quality;
                }
            }
        }
    }

    @Override
    public void endRule() {
        --item.sellIn;

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality -= item.quality;
        }
    }
}
