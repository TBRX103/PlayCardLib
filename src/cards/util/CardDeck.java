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
package cards.util;

import cards.Card;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.UUID;

/**
 *
 * @author Benjamin Schellenberger <benrain@gmail.com>
 * @param <T> Set of Cards
 */
public class CardDeck<T extends Card> extends LinkedHashSet<T> {

    private final UUID uuid = UUID.randomUUID();

    /**
     * Safely handles a deck exception and will return a null card if unable to
     * draw.
     *
     * @return
     */
    public synchronized T safeDraw() {
        try {
            return draw();
        } catch (CardDeckException ex) {
            return null;
        }
    }

    public synchronized T draw() throws CardDeckException {
        if (isEmpty()) {
            throw new CardDeckException("Card deck is empty.");
        }
        try {
            T card = iterator().next();
            return card;
        } finally {
            iterator().remove();
        }
    }

    public synchronized boolean safeCut(int index) {
        try {
            cut(index);
            return true;
        } catch (CardDeckException ex) {
            return false;
        }
    }

    public synchronized void cut(int index) throws CardDeckException {
        if (index <= 0) {
            throw new CardDeckException("Invalid cut length.");
        }
        if (index > size()) {
            throw new CardDeckException("Attempting to cut beyond the deck threshold.");
        }

        if (index == size()) {
            throw new CardDeckException("Cutting the deck's length.");
        }

        ArrayList<T> cards = new ArrayList<>(index);
        Iterator<T> it = iterator();

        for (int i = 0; i < index; i++) {
            cards.add(it.next());
            it.remove();
        }

        addAll(cards);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardDeck)) {
            return false;
        }
        return uuid.equals(((CardDeck) obj).uuid);
    }

}
