package org.eternity.adventure.game;

import org.eternity.adventure.game.item.Carrier;

public class Transfer {
    private Carrier source;
    private Carrier target;
    private String itemName;

    public Transfer(Carrier source, Carrier target, String itemName) {
        this.source = source;
        this.target = target;
        this.itemName = itemName;
    }

    public boolean isPossible() {
        return source.find(itemName).isPresent();
    }

    public void perform() {
        if (!isPossible()) {
            throw new IllegalStateException();
        }

        source.find(itemName).ifPresent(
                item -> {
                    source.remove(item);
                    target.add(item);
        });
    }
}
