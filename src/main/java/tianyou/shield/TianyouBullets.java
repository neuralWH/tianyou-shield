package tianyou.shield;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.entities.bullet.*;

public class TianyouBullets {

    public static BulletType plasmaHoming;
    public static BulletType plasmaMissile;
    public static BulletType pointDefense;

    public static void load() {
        plasmaHoming = new BasicBulletType() {{
            speed = 8f;
            damage = 200f;
            lifetime = 60f;
            width = 10f;
            height = 10f;
            homingPower = 0.2f;
            homingRange = 240f;
            homingDelay = 4f;
            splashDamage = 200f;
            splashDamageRadius = 4f;
            hitEffect = Fx.hitLaserBlast;
            frontColor = Color.valueOf("ffd7a0");
            backColor = Color.valueOf("ffb054");
            despawnEffect = Fx.hitLaserBlast;
        }};

        plasmaMissile = new MissileBulletType() {{
            speed = 6f;
            damage = 800f;
            lifetime = 90f;
            homingPower = 0.15f;
            homingRange = 200f;
            splashDamage = 800f;
            splashDamageRadius = 12f;
            hitEffect = Fx.blastExplosion;
            trailEffect = Fx.missileTrail;
            trailParam = 4f;
            weaveScale = 6f;
            weaveMag = 2f;
            frontColor = Color.valueOf("ffd7a0");
            backColor = Color.valueOf("ffb054");
        }};

        pointDefense = new BasicBulletType() {{
            speed = 16f;
            damage = 1f;
            lifetime = 20f;
            width = 6f;
            height = 6f;
            maxRange = 38f * 8f;
            hitEffect = Fx.hitLaserBlast;
        }};
    }
}