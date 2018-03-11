package net.glowstone.entity.passive;

import net.glowstone.inventory.GlowHorseInventory;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mule;
import org.bukkit.inventory.AbstractHorseInventory;

public class GlowMule extends GlowChestedHorse<GlowHorseInventory> implements Mule {

    public GlowMule(Location location) {
        super(location, EntityType.MULE, 15);
    }

    @Override
    protected Sound getDeathSound() {
        return Sound.ENTITY_MULE_DEATH;
    }

    @Override
    protected Sound getHurtSound() {
        return Sound.ENTITY_MULE_HURT;
    }

    @Override
    protected Sound getAmbientSound() {
        return Sound.ENTITY_MULE_AMBIENT;
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
