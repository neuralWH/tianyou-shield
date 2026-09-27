package tianyou.shield;

import mindustry.gen.*;
import mindustry.type.*;

public class TianyouUnit {

    public static UnitType tianyou;

    public static void load() {
        tianyou = new UnitType("tianyou") {{
            constructor = MechUnit::create;
            health = 32000f;
            hitSize = 3.5f;
            localizedName = "@unit.tianyou.name";
            description = "@unit.tianyou.description";
        }};
    }
}
