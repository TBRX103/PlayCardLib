/*
 * Copyright 2015 Benjamin Schellenberger <benrain@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cards.french;

import cards.Card;
import cards.CardType;
import java.util.Objects;

/**
 *
 * @author Benjamin Schellenberger <benrain@gmail.com>
 */
public final class PlayingCard extends Card {

    private final Rank rank;
    private final Suit suit;

    private PlayingCard() {
        this(null, null);
    }

    PlayingCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String getPrintableName() {
        return new StringBuilder(rank.getDisplayName()).append(" of ").append(suit.getSuitName()).toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayingCard)) {
            return false;
        }

        PlayingCard card = ((PlayingCard) obj);
        return card.getRank() == getRank() && card.getSuit() == getSuit();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.rank);
        hash = 97 * hash + Objects.hashCode(this.suit);
        return hash;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public CardType getCardType() {
        return CardType.FRENCH_PLAYING_CARD;
    }

    public enum Suit {

        SPADES("Spades"), DIAMONDS("Diamonds"), CLUBS("Clubs"), HEARTS("Hearts");

        private final String suitName;

        private Suit(String suitName) {
            this.suitName = suitName;
        }

        public String getSuitName() {
            return suitName;
        }

    }

    public enum Rank {

        ACE(1, "Ace"), TWO(2, "Two"), THREE(3, "Three"), FOUR(4, "Four"),
        FIVE(5, "Five"), SIX(6, "Six"), SEVEN(7, "Seven"), EIGHT(8, "Eight"),
        NINE(9, "Nine"), TEN(10, "Ten"), JACK(11, "Jack"), QUEEN(12, "Queen"),
        KING(13, "King"), JOKER(14, "Joker");
        private final String displayName;
        private final int value;

        private Rank(int value, String displayName) {
            this.value = value;
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }

        public int getValue() {
            return value;
        }

    }

}
