Feature: Gilded Rose quality when using refactored items
    I want to know if the quality is updated properly for the various refactored items

    # For +5 Dexterity Vest
    Scenario: Checking the sell in and quality of +5 Dexterity Vest over 3 day
        Given The item name is "+5 Dexterity Vest" with an initial sell in as 10 and quality as 20
        When I update the quality over 3 days
        Then I should get sell in as 7 and quality as 17

    # For Aged Brie
    Scenario: Checking the sell in and quality of Aged Brie over 1 days
        Given The item name is "Aged Brie" with an initial sell in as 2 and quality as 0
        When I update the quality over 1 days
        Then I should get sell in as 1 and quality as 1

    Scenario Outline: Checking the sell in and quality of Aged Brie over a number of days
        Given The item name is "Aged Brie" with an initial sell in as 2 and quality as 0
        When I update the quality over <days> days
        Then I should get sell in as <sell in> and quality as <quality>
        Examples:
            | days | sell in | quality |
            | 2    | 0       | 2       |
            | 3    | -1      | 4       |
            | 9    | -7      | 16      |
            | 18   | -16     | 34      |
            | 30   | -28     | 50      |

    # For Elixir Of The Mongoose
    Scenario: Checking the sell in and quality of the Elixir of the Mongoose over 1 day
        Given The item name is "Elixir of the Mongoose" with an initial sell in as 5 and quality as 7
        When I update the quality over 1 day
        Then I should get sell in as 4 and quality as 6

    Scenario Outline: Checking the sell in and quality of the Elixir of the Mongoose over a number of days
        Given The item name is "Elixir of the Mongoose" with an initial sell in as 5 and quality as 7
        When I update the quality over <days> days
        Then I should get sell in as <sell in> and quality as <quality>
        Examples:
            | days | sell in | quality |
            | 23   | -18     | 0       |
            | 30   | -25     | 0       |

    # For Sulfuras, Hand Of Ragnaros
    Scenario: Checking the sell in and quality of the Sulfuras, Hand Of Ragnaros over 1 day
        Given The item name is "Sulfuras, Hand of Ragnaros" with an initial sell in as 0 and quality as 80
        When I update the quality over 1 day
        Then I should get sell in as 0 and quality as 80

    Scenario: Checking the sell in and quality of the Sulfuras, Hand Of Ragnaros over 80 days
        Given The item name is "Sulfuras, Hand of Ragnaros" with an initial sell in as 0 and quality as 80
        When I update the quality over 80 days
        Then I should get sell in as 0 and quality as 80

    # For Backstage Concert Passes
    Scenario: Checking the sell in and quality of the Backstage passes to a TAFKAL80ETC concert over 2 days
        Given The item name is "Backstage passes to a TAFKAL80ETC concert" with an initial sell in as 5 and quality as 49
        When I update the quality over 2 days
        Then I should get sell in as 3 and quality as 50

    Scenario: Checking the sell in and quality of the Backstage passes to a TAFKAL80ETC concert over 3 days
        Given The item name is "Backstage passes to a TAFKAL80ETC concert" with an initial sell in as 15 and quality as 20
        When I update the quality over 3 days
        Then I should get sell in as 12 and quality as 23

    Scenario: Checking the sell in and quality of the Backstage passes to a TAFKAL80ETC concert over 5 days
        Given The item name is "Backstage passes to a TAFKAL80ETC concert" with an initial sell in as 10 and quality as 49
        When I update the quality over 5 days
        Then I should get sell in as 5 and quality as 50

    # For Conjured Mana Cake
    Scenario Outline: Checking the sell in and quality of the Conjured Mana Cake over a number of days
        Given The item name is "Conjured Mana Cake" with an initial sell in as 3 and quality as 6
        When I update the quality over <days> days
        Then I should get sell in as <sell in> and quality as <quality>
        Examples:
            | days | sell in | quality |
            | 3    | 0       | 0       |
            | 4    | -1      | 0       |
            | 6    | -3      | 0       |
            | 28   | -25     | 0       |


