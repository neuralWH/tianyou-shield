package tianyou.shield;

import arc.math.Mathf;
import arc.struct.Seq;
import arc.util.Time;
import mindustry.gen.Groups;
import mindustry.gen.MechUnit;
import mindustry.gen.Unit;

public class MechTianyouUnit extends MechUnit {

    public static MechTianyouUnit create() {
        return new MechTianyouUnit();
    }

    private float stompTimer = 0f;
    private boolean shieldsInitialized = false;

    @Override
    public void update() {
        super.update();

        if (!shieldsInitialized && !dead) {
            shieldsInitialized = true;
            initShields();
        }

        stompTimer += Time.delta;
        if (stompTimer >= 0.5f) {
            stompTimer = 0f;
            applyStompDamage();
        }
    }

    private void initShields() {
        ShieldSystem.initUnitPaths(this);

        Seq<Shield> shields = new Seq<>();
        for (int i = 0; i < 5; i++) {
            shields.add(new Shield(i, this));
        }
        for (int i = 0; i < 3; i++) {
            shields.get(i).currentPath = ShieldSystem.getPathA(this);
        }
        for (int i = 3; i < 5; i++) {
            shields.get(i).currentPath = ShieldSystem.getPathB(this);
        }
        ShieldSystem.registerShields(this, shields);
    }

    private void applyStompDamage() {
        if (dead) return;
        float stompRange = 4f * 8f;
        for (Unit other : Groups.unit) {
            if (other == this || other.team == team || other.dead) continue;
            float dx = other.x - x;
            float dy = other.y - y;
            float d = (float) Math.sqrt(dx * dx + dy * dy);
            if (d <= stompRange) {
                other.damage(50f);
                float angle = Mathf.atan2(dy, dx);
                other.impulse(Mathf.cos(angle) * 3f, Mathf.sin(angle) * 3f);
            }
        }
    }
}