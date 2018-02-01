package net.glowstone.util;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.bukkit.NamespacedKey;
import org.junit.jupiter.api.Test;

public class NamespacedKeyTest {

    @org.junit.jupiter.api.Test
    public void testFromStringWithKey() {
        String keyRaw = "minecraft:abc";
        NamespacedKey key = new NamespacedKey(keyRaw.substring(0, keyRaw.indexOf(':')),
            keyRaw.substring(keyRaw.indexOf(':') + 1, keyRaw.length()));
        assertThat(key.toString(), equalTo(keyRaw));
    }

    @org.junit.jupiter.api.Test
    public void testFromStringWithoutKey() {
        String keyRaw = "abc";
        NamespacedKey key = new NamespacedKey(NamespacedKey.MINECRAFT, keyRaw);
        assertThat(key.toString(), equalTo("minecraft:" + keyRaw));
    }
}
