Feature: Gilded Rose quality when using refactored items
  I want to know if the quality is updated properly for the various refactored items

  # For +5 Dexterity Vest
  Scenario: Checking +5 Dexterity Vest over 3 day
    Given The item name is "+5 Dexterity Vest" with an initial sell in as 10 and quality as 20
    When I update the quality over 3 days
    Then I should get sell in as 7 and quality as 17

  # For Aged Brie
  Scenario: Checking Aged Brie over 1 day
    Given The item name is "Aged Brie" with an initial sell in as 2 and quality as 0
    When I update the quality over 1 day
    Then I should get sell in as 1 and quality as 1

  Scenario: Checking Aged Brie over 1 days
    Given The item name is "Aged Brie" with an initial sell in as 2 and quality as 0
    When I update the quality over 1 days
    Then I should get sell in as 1 and quality as 1

  Scenario: Checking Aged Brie over 2 days
    Given The item name is "Aged Brie" with an initial sell in as 2 and quality as 0
    When I update the quality over 2 days
    Then I should get sell in as 0 and quality as 2

  Scenario: Checking Aged Brie over 3 days
    Given The item name is "Aged Brie" with an initial sell in as 2 and quality as 0
    When I update the quality over 3 days
    Then I should get sell in as -1 and quality as 4

  Scenario: Checking Aged Brie over 9 days
    Given The item name is "Aged Brie" with an initial sell in as 2 and quality as 0
    When I update the quality over 9 days
    Then I should get sell in as -7 and quality as 16

  Scenario: Checking Aged Brie over 18 days
    Given The item name is "Aged Brie" with an initial sell in as 2 and quality as 0
    When I update the quality over 18 days
    Then I should get sell in as -16 and quality as 34

  Scenario: Checking Aged Brie over 30 days
    Given The item name is "Aged Brie" with an initial sell in as 2 and quality as 0
    When I update the quality over 30 days
    Then I should get sell in as -28 and quality as 50

  # For Elixir Of The Mongoose
  Scenario: Checking the Elixir of the Mongoose over 1 day
    Given The item name is "Elixir of the Mongoose" with an initial sell in as 5 and quality as 7
    When I update the quality over 1 day
    Then I should get sell in as 4 and quality as 6

  Scenario: Checking the Elixir of the Mongoose over 23 days
    Given The item name is "Elixir of the Mongoose" with an initial sell in as 5 and quality as 7
    When I update the quality over 23 days
    Then I should get sell in as -18 and quality as 0

  Scenario: Checking the Elixir of the Mongoose over 30 days
    Given The item name is "Elixir of the Mongoose" with an initial sell in as 5 and quality as 7
    When I update the quality over 30 days
    Then I should get sell in as -25 and quality as 0

  # For Sulfuras, Hand Of Ragnaros
  Scenario: Checking the Sulfuras, Hand Of Ragnaros over 1 day
    Given The item name is "Sulfuras, Hand of Ragnaros" with an initial sell in as 0 and quality as 80
    When I update the quality over 1 day
    Then I should get sell in as 0 and quality as 80

  Scenario: Checking the Sulfuras, Hand Of Ragnaros over 80 days
    Given The item name is "Sulfuras, Hand of Ragnaros" with an initial sell in as 0 and quality as 80
    When I update the quality over 80 days
    Then I should get sell in as 0 and quality as 80

  # For Backstage Concert Passes
  Scenario: Checking the Backstage passes to a TAFKAL80ETC concert over 2 days
    Given The item name is "Backstage passes to a TAFKAL80ETC concert" with an initial sell in as 5 and quality as 49
    When I update the quality over 2 days
    Then I should get sell in as 3 and quality as 50

  Scenario: Checking the Backstage passes to a TAFKAL80ETC concert over 3 days
    Given The item name is "Backstage passes to a TAFKAL80ETC concert" with an initial sell in as 15 and quality as 20
    When I update the quality over 3 days
    Then I should get sell in as 12 and quality as 23

  Scenario: Checking the Backstage passes to a TAFKAL80ETC concert over 5 days
    Given The item name is "Backstage passes to a TAFKAL80ETC concert" with an initial sell in as 10 and quality as 49
    When I update the quality over 5 days
    Then I should get sell in as 5 and quality as 50

  # For Conjured Mana Cake
  Scenario: Checking the Conjured Mana Cake over 3 days
    Given The item name is "Conjured Mana Cake" with an initial sell in as 3 and quality as 6
    When I update the quality over 3 days
    Then I should get sell in as 0 and quality as 0

  Scenario: Checking the Conjured Mana Cake over 4 days
    Given The item name is "Conjured Mana Cake" with an initial sell in as 3 and quality as 6
    When I update the quality over 4 days
    Then I should get sell in as -1 and quality as 0

  Scenario: Checking the Conjured Mana Cake over 6 days
    Given The item name is "Conjured Mana Cake" with an initial sell in as 3 and quality as 6
    When I update the quality over 6 days
    Then I should get sell in as -3 and quality as 0

  Scenario: Checking the Conjured Mana Cake over 28 days
    Given The item name is "Conjured Mana Cake" with an initial sell in as 3 and quality as 6
    When I update the quality over 28 days
    Then I should get sell in as -25 and quality as 0

