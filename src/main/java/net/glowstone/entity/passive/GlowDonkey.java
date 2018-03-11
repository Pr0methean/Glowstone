package net.glowstone.entity.passive;

import net.glowstone.inventory.GlowHorseInventory;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Donkey;
import org.bukkit.entity.EntityType;

public class GlowDonkey extends GlowChestedHorse<GlowHorseInventory> implements Donkey {

    public GlowDonkey(Location location) {
        super(location, EntityType.DONKEY, 15);
    }

    @Override
    protected Sound getHurtSound() {
        return Sound.ENTITY_DONKEY_HURT;
    }

    @Override
    protected Sound getDeathSound() {
        return Sound.ENTITY_DONKEY_DEATH;
    }

    @Override
    protected Sound getAmbientSound() {
        return Sound.ENTITY_DONKEY_AMBIENT;
    }

    @Override
    protected void createNewInventory() {
        GlowHorseInventory oldInventory = inventory;
        inventory = new GlowHorseInventory(this);
        if (oldInventory != null) {
            inventory.setSaddle(oldInventory.getSaddle());
        }
    }
}
