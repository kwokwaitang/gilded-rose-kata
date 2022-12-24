package com.gildedrose;

import org.apache.commons.lang3.tuple.Triple;

import java.util.List;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public GildedRose(List<Triple<String /* Name */, Integer /* Sell In */, Integer /* Quality */>> items) {
        this.items = new Item[items.size()];
        int index = 0;
        for (Triple item: items) {
            String name = item.getLeft().toString();
            int sellIn = 0;
            int quality = 0;

            Object middle = item.getMiddle();
            if (middle instanceof Integer) {
                sellIn = (Integer) middle;
            }

            Object right = item.getRight();
            if (right instanceof Integer) {
                quality = (Integer) right;
            }

            this.items[index] = new Item(name, sellIn, quality);
            ++index;
        }
    }

    public void updateQuality(final int days) {
        if (days == 1) {
            updateQuality();
            return;
        }

        for (int i = 0; i < days; i++) {
            updateQuality();
        }
    }

    public String toString(final int days) {
        StringBuilder result = new StringBuilder("\n\n");

        for (int i = 0; i < days; i++) {
            String header = "-------- day " + i + " --------";
            if (i == 0) {
                header = "-------- day " + i + " (set-up) --------";
            }
            result.append(header).append("\n");
            result.append("name, sellIn, quality").append("\n");
            for (Item item : items) {
                result.append(item.toString()).append("\n");
            }
            result.append("\n");
            updateQuality(i);
        }

        return result.toString();
    }

    private void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        int decrementBy = 1;

                        // Fix for "Conjured Mana Cake"
                        if (items[i].name.equals("Conjured Mana Cake")) {
                            decrementBy = 2;
                        }

                        items[i].quality = items[i].quality - decrementBy;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
