package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BackstageConcertPasses;
import com.gildedrose.items.ConjuredManaCake;
import com.gildedrose.items.ElixirOfTheMongoose;
import com.gildedrose.items.GildedRoseItem;
import com.gildedrose.items.PlusFiveDexterityVest;
import com.gildedrose.items.SulfurasHandOfRagnaros;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TextTestFixture {

    private static final Logger LOGGER = Logger.getGlobal();

    public static void main(String[] args) {
        LOGGER.info("OMGHAI!");

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        List<GildedRoseItem> items = new ArrayList<>();
        items.add(new PlusFiveDexterityVest(10, 20));
        items.add(new AgedBrie(2, 0));
        items.add(new ElixirOfTheMongoose(5, 7));
        items.add(new SulfurasHandOfRagnaros(0, 80));
        items.add(new SulfurasHandOfRagnaros(-1, 80));
        items.add(new BackstageConcertPasses(15, 20));
        items.add(new BackstageConcertPasses(10, 49));
        items.add(new BackstageConcertPasses(5, 49));
        items.add(new ConjuredManaCake(3, 6));

        StringBuilder result = new StringBuilder("\n\n");

        for (int i = 0; i < days; i++) {
            String header = "-------- day " + i + " --------";
            if (i == 0) {
                header = "-------- day " + i + " (set-up) --------";
            }
            result.append(header).append("\n");
            result.append("name, sellIn, quality").append("\n");

            for (GildedRoseItem item : items) {
                result.append(item.toString()).append("\n");
                item.updateQuality();
            }

            result.append("\n");
        }

        String output = result.toString();
        LOGGER.info(output);
    }
}
