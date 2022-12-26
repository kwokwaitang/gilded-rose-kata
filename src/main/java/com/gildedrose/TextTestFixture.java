package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BackstageConcertPasses;
import com.gildedrose.items.ConjuredManaCake;
import com.gildedrose.items.ElixirOfTheMongoose;
import com.gildedrose.items.GildedRoseItem;
import com.gildedrose.items.PlusFiveDexterityVest;
import com.gildedrose.items.SulfurasHandOfRagnaros;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class TextTestFixture {

    private static final Logger LOGGER = Logger.getGlobal();

    public static void main(String[] args) {
        LOGGER.info("OMGHAI!");

        int days = 3;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]);
        }

        List<? /* any object that */ extends GildedRoseItem> items = Arrays.asList(
            new PlusFiveDexterityVest(10, 20),
            new AgedBrie(2, 0),
            new ElixirOfTheMongoose(5, 7),
            new SulfurasHandOfRagnaros(0, 80),
            new SulfurasHandOfRagnaros(-1, 80),
            new BackstageConcertPasses(15, 20),
            new BackstageConcertPasses(10, 49),
            new BackstageConcertPasses(5, 49),
            new ConjuredManaCake(3, 6)
        );

        String output = generateOutput(days, items);
        LOGGER.info(output);
    }

    public static String generateOutput(final int days, final List<? /* any object that */ extends GildedRoseItem> items) {
        StringBuilder result = new StringBuilder("\n\n");
        StringBuilder header = new StringBuilder();

        for (int i = 0; i < days; i++) {
            header.setLength(0);
            header.append("-------- day ").append(i).append(" --------");
            if (i == 0) {
                header.setLength(i);
                header.append("-------- day ").append(i).append(" (set-up) --------");
            }
            result.append(header).append("\n");
            result.append("name, sellIn, quality").append("\n");

            for (GildedRoseItem item : items) {
                result.append(item.toString()).append("\n");
                item.updateQuality();
            }

            result.append("\n");
        }

       return result.toString();
    }
}
