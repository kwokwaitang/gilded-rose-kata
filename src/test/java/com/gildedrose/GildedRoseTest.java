package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// TODO Don't forget to set-up a parameterized test

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality(1);
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void usingItemForPlus5DexterityVestOver1Day() {
        // Given...
        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20)
        };

        // When...
        GildedRose app = new GildedRose(items);
        app.updateQuality(2);

        // Then...
        Item item = app.items[0];
        assertThat(item.name, is("+5 Dexterity Vest"));
        assertThat(item.sellIn, is(8));
        assertThat(item.quality, is(18));
    }

    @Test
    void usingItemForPlus5DexterityVestOver3Days() {
        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20)
        };

        GildedRose app = new GildedRose(items);

        Item item = app.items[0];

        assertThat(item.name, is("+5 Dexterity Vest"));

        // On the 1st day...
        app.updateQuality(1);
        assertThat(item.sellIn, is(9));
        assertThat(item.quality, is(19));

        // On the 2nd day...
        app.updateQuality(1);
        assertThat(item.sellIn, is(8));
        assertThat(item.quality, is(18));

        // On the 3rd day...
        app.updateQuality(1);
        assertThat(item.sellIn, is(7));
        assertThat(item.quality, is(17));
    }

    @Test
    void usingItemForPlus5DexterityVestOver21ays() {
        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20)
        };

        GildedRose app = new GildedRose(items);

        Item item = app.items[0];

        assertThat(item.name, is("+5 Dexterity Vest"));

        // On the 11th day...
        app.updateQuality(11);
        assertThat(item.sellIn, is(-1));
        assertThat(item.quality, is(8));

        // Plus another 9 more days
        app.updateQuality(9);
        assertThat(item.sellIn, is(-10));
        assertThat(item.quality, is(0));

        // Just one more extra day
        app.updateQuality(1);
        assertThat(item.sellIn, is(-11));
        assertThat(item.quality, is(0));
    }

    @Test
    void UsingItemForAgedBrieOver3Days() {
        Item[] items = new Item[] {
            new Item("Aged Brie", 2, 0)
        };

        GildedRose app = new GildedRose(items);

        Item item = app.items[0];

        assertEquals("Aged Brie", item.name);

        // On the 1st day...
        app.updateQuality(1);
        assertEquals(1, item.sellIn);
        assertEquals(1, item.quality);

        // On the 2nd day...
        app.updateQuality(1);
        assertEquals(0, item.sellIn);
        assertEquals(2, item.quality);

        // On the 3rd day...
        app.updateQuality(1);
        assertEquals(-1, item.sellIn);
        assertEquals(4, item.quality);
    }

    @Test
    void UsingItemForAgedBrieOver9Days() {
        Item[] items = new Item[] {
            new Item("Aged Brie", 2, 0)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality(9);

        Item item = app.items[0];
        assertEquals("Aged Brie", item.name);
        assertThat(item.sellIn, is(-7));
        assertThat(item.quality, is(16));
    }

    @Test
    void usingItemForElixirOfTheMongooseOver1Day() {
        Item[] items = new Item[] {
            new Item("Elixir of the Mongoose", 5, 7)
        };

        GildedRose app = new GildedRose(items);

        Item item = app.items[0];

        assertEquals("Elixir of the Mongoose", item.name);

        // On the 1st day...
        app.updateQuality(1);
        assertEquals(4, item.sellIn);
        assertEquals(6, item.quality);
    }

    @Test
    void usingItemForElixirOfTheMongooseOver3Days() {
        // Given...
        Item[] items = new Item[] {
            new Item("Elixir of the Mongoose", 5, 7)
        };

        // When...
        GildedRose app = new GildedRose(items);
        app.updateQuality(3);

        // Then...
        Item item = app.items[0];
        assertThat(item.name, is("Elixir of the Mongoose"));
        assertThat(item.sellIn, is(2));
        assertThat(item.quality, is(4));
    }

    @Test
    void usingItemForElixirOfTheMongooseOver7Days() {
        Item[] items = new Item[] {
            new Item("Elixir of the Mongoose", 5, 7)
        };

        GildedRose app = new GildedRose(items);

        Item item = app.items[0];

        assertEquals("Elixir of the Mongoose", item.name);

        // On the 1st day...
        app.updateQuality(1);
        assertEquals(4, item.sellIn);
        assertEquals(6, item.quality);

        // On the 2nd day...
        app.updateQuality(1);
        assertEquals(3, item.sellIn);
        assertEquals(5, item.quality);

        // On the 3rd day...
        app.updateQuality(1);
        assertEquals(2, item.sellIn);
        assertEquals(4, item.quality);

        // On the 4th day...
        app.updateQuality(1);
        assertEquals(1, item.sellIn);
        assertEquals(3, item.quality);

        // On the 5th day...
        app.updateQuality(1);
        assertEquals(0, item.sellIn);
        assertEquals(2, item.quality);

        // On the 6th day...
        app.updateQuality(1);
        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);

        // On the 7th day...
        app.updateQuality(1);
        assertEquals(-2, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void noChangeInQualityForOneLegendaryItemSulfurasOver8Days() {
        Item[] items = new Item[] {
            new Item("Sulfuras, Hand of Ragnaros", 0, 80)
        };

        GildedRose app = new GildedRose(items);

        Item item = app.items[0];

        assertEquals("Sulfuras, Hand of Ragnaros", item.name);

        app.updateQuality(1);
        assertEquals(0, item.sellIn);
        assertEquals(80, item.quality);

        app.updateQuality(8);
        assertEquals(0, item.sellIn);
        assertEquals(80, item.quality);
    }

    @Test
    void noChangeInQualityForTwoLegendaryItemSulfurasOver88Days() {
        Item[] items = new Item[] {
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80)
        };

        GildedRose app = new GildedRose(items);

        Item sulfuras1 = app.items[0];
        Item sulfuras2 = app.items[1];

        assertEquals("Sulfuras, Hand of Ragnaros", sulfuras1.name);
        assertEquals("Sulfuras, Hand of Ragnaros", sulfuras2.name);

        app.updateQuality(1);
        assertEquals(0, sulfuras1.sellIn);
        assertEquals(80, sulfuras1.quality);
        assertEquals(-1, sulfuras2.sellIn);
        assertEquals(80, sulfuras2.quality);

        app.updateQuality(8);
        assertEquals(0, sulfuras1.sellIn);
        assertEquals(80, sulfuras1.quality);
        assertEquals(-1, sulfuras2.sellIn);
        assertEquals(80, sulfuras2.quality);

        app.updateQuality(88);
        assertEquals(0, sulfuras1.sellIn);
        assertEquals(80, sulfuras1.quality);
        assertEquals(-1, sulfuras2.sellIn);
        assertEquals(80, sulfuras2.quality);
    }

    @Test
    void usingItemForBackstagePassesToATAFKAL80ETCConcertOver1Day() {
        // Given...
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)
        };

        // When...
        GildedRose app = new GildedRose(items);
        app.updateQuality(1);

        // Then...
        Item item = app.items[0];

        assertThat(item.name, is("Backstage passes to a TAFKAL80ETC concert"));
        assertThat(item.sellIn, is(14));
        assertThat(item.quality, is(21));
    }

    @Test
    void backstagePassesBetterQualityWhenNearerDayOfConcertOver5Days() {
        List<Item> backstagePasses = new ArrayList<>(3);

        final String name = "Backstage passes to a TAFKAL80ETC concert";
        backstagePasses.add(new Item(name, 15, 20));
        backstagePasses.add(new Item(name, 10, 49));
        backstagePasses.add(new Item(name, 5, 49));

        GildedRose app = new GildedRose(backstagePasses.stream().filter(Objects::nonNull).toArray(Item[]::new));

        Item backstagePass1 = app.items[0];
        Item backstagePass2 = app.items[1];
        Item backstagePass3 = app.items[2];

        List<String> backstagePassNames = Arrays.asList(backstagePass1.name, backstagePass2.name, backstagePass3.name);
        assertTrue(backstagePassNames.stream().allMatch(backstagePassName -> backstagePassName.equals("Backstage passes to a TAFKAL80ETC concert")));

        // Run for 3 days...
        app.updateQuality(3);
        assertEquals(12,backstagePass1.sellIn);
        assertEquals(23, backstagePass1.quality);
        assertEquals(7,backstagePass2.sellIn);
        assertEquals(50, backstagePass2.quality);
        assertEquals(2,backstagePass3.sellIn);
        assertEquals(50, backstagePass3.quality);

        // On the 5th day...
        app.updateQuality(2);
        assertEquals(10,backstagePass1.sellIn);     // 10 days, so quality is increased by 2
        assertEquals(25, backstagePass1.quality);
        assertEquals(5,backstagePass2.sellIn);
        assertEquals(50, backstagePass2.quality);   // Until the day of the concert, quality stays at 50
        assertEquals(0,backstagePass3.sellIn);      // On the day of the concert...
        assertEquals(50, backstagePass3.quality);

        // On the 6th day...
        app.updateQuality(1);
        assertEquals(9,backstagePass1.sellIn);
        assertEquals(27, backstagePass1.quality);
        assertEquals(4,backstagePass2.sellIn);      // Until the day of the concert, quality stays at 50
        assertEquals(50, backstagePass2.quality);
        assertEquals(-1,backstagePass3.sellIn);     // After concert scenario...
        assertEquals(0, backstagePass3.quality);

        // On the 11th day...
        app.updateQuality(5);
        assertEquals(4,backstagePass1.sellIn);
        assertEquals(38, backstagePass1.quality);
        assertEquals(-1,backstagePass2.sellIn);     // A day after the concert
        assertEquals(0, backstagePass2.quality);
        assertEquals(-6,backstagePass3.sellIn);     // 6 days after the concert
        assertEquals(0, backstagePass3.quality);
    }

    @Test
    void conjuredManaCakeOver6Days() {
        Item[] items = new Item[] {
            new Item("Conjured Mana Cake", 3, 6)
        };

        GildedRose app = new GildedRose(items);

        Item item = app.items[0];

        assertEquals("Conjured Mana Cake", item.name);

        // On the 3rd day...
        app.updateQuality(3);
        assertEquals(0, item.sellIn);
        assertEquals(0, item.quality);

        // On the 4th day...
        app.updateQuality(1);
        assertEquals(-1, item.sellIn); // So 1 day pass its sell by date and...
        assertEquals(0, item.quality); // quality is still 0

        // And on the 6th day...
        app.updateQuality(2);
        assertEquals(-3, item.sellIn); // So 3 days pass its sell by date and...
        assertEquals(0, item.quality); // quality is still 0
    }
}
