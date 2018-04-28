package net.glowstone.io.entity;

import java.util.function.Function;
import net.glowstone.entity.monster.GlowSlime;
import net.glowstone.util.nbt.CompoundTag;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;

class SlimeStore<T extends GlowSlime> extends MonsterStore<T> {

    public SlimeStore(Class<T> clazz, EntityType type, Function<Location, ? extends T> creator) {
        super(clazz, type, creator);
    }

    @Override
    public void load(T entity, CompoundTag tag) {
        super.load(entity, tag);
        if (!tag.readInt(entity::setSize, "Size")) {
            entity.setSize(1);
        }
        entity.setOnGround(tag.getBoolDefaultFalse("wasOnGround"));
    }

    @Override
    public void save(T entity, CompoundTag tag) {
        super.save(entity, tag);
        tag.putInt("Size", entity.getSize());
        tag.putBool("wasOnGround", entity.isOnGround());
    }

}
