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
package cards.management;

import cards.Card;
import cards.util.CardDeck;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 *
 * @author Benjamin Schellenberger <benrain@gmail.com>
 * @param <T> - Type of Cards this shoe will contain
 */
public final class Shoe<T extends Card> {

    private final LinkedHashSet<CardDeck<T>> cardReferences;
    private final HashSet<ShoeCard<T>> cards = new HashSet<>();
    private HashMap<Integer, CardDeck<T>> deckNumbers = new HashMap<>();

    private boolean finalized = false;

    public Shoe() {
        this(new CardDeck<>());
    }

    public Shoe(CardDeck<T> deck) {
        cardReferences = new LinkedHashSet<>();
        addDeck(deck);
    }

    public Shoe(LinkedHashSet<CardDeck<T>> cards) {
        this.cardReferences = cards;
    }

    public Shoe(Shoe<T> shoe) {
        this.cardReferences = new LinkedHashSet<>(shoe.cardReferences);
        this.cards.addAll(shoe.cards);
        this.deckNumbers = new HashMap<>(deckNumbers);
        this.finalized = shoe.finalized;
    }

    public void addDeck(CardDeck<T> deck) {
        if (finalized) {
            throw new IllegalStateException("Shoe has been finalized, no cards can be added.");
        }
        cardReferences.add(deck);
    }

    public void removeDeck(CardDeck<T> deck) {
        if (!finalized) {
            cardReferences.remove(deck);
        }
        //Do we want to allow decks to be removed from the shoe..?

    }

    public void shuffle(int operations) {

    }

    public void finalizeDeck() {
        if (finalized) {
            return;
        }

        int deckNumber = 0;
        for (CardDeck<T> deck : cardReferences) {
            deckNumbers.put(deckNumber, deck);
            cards.addAll(createShoeCards(deckNumber, deck));
            deckNumber++;
        }
        finalized = true;
    }

    private LinkedHashSet<ShoeCard<T>> createShoeCards(int deckNumber, CardDeck<T> deck) {
        LinkedHashSet<ShoeCard<T>> shoeCards = new LinkedHashSet<>();
        deck.stream().forEach((card) -> {
            shoeCards.add(new ShoeCard(deckNumber, card));
        });
        return shoeCards;
    }
}
