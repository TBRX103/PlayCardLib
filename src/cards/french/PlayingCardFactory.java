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

import cards.util.CardDeck;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import static java.util.concurrent.ThreadLocalRandom.current;

/**
 *
 * @author Benjamin Schellenberger <benrain@gmail.com>
 */
public class PlayingCardFactory {

    /**
     * Returns a standard 52 Card deck, excluding Jokers.
     *
     * @return
     */
    public static CardDeck<PlayingCard> getDeck() {
        return getDeck(false);
    }

    /**
     * Returns either a 52 or 54 card deck, Jokers depending.
     *
     * @param includeJokers - Whether or not to include Jokers.
     * @return
     */
    public static CardDeck<PlayingCard> getDeck(boolean includeJokers) {
        CardDeck<PlayingCard> deck = new CardDeck<>();

        PlayingCardUtils.getSuitOrder().stream().forEach((currentSuit) -> {
            PlayingCardUtils.getRankedOrder().stream().forEach((rank) -> {
                deck.add(new PlayingCard(rank, currentSuit));
            });
        });

        if (includeJokers) {
            //Variety is the spice of life. Even? Clubs. Odd? Spades 1-50 Diamonds, 51-100 Hearts
            int determinant = ThreadLocalRandom.current().nextInt(1, 101);
            deck.add(new PlayingCard(PlayingCard.Rank.JOKER, determinant % 2 == 0 ? PlayingCard.Suit.CLUBS : PlayingCard.Suit.SPADES));
            deck.add(new PlayingCard(PlayingCard.Rank.JOKER, determinant > 50 ? PlayingCard.Suit.HEARTS : PlayingCard.Suit.DIAMONDS));
        }
        return deck;
    }
}
