package tianyou.shield;

import mindustry.content.*;
import mindustry.type.*;
import mindustry.world.blocks.units.UnitAssembler;

public class TianyouAssembler {

    public static UnitAssembler tianyouAssembler;

    public static void load() {
        tianyouAssembler = new UnitAssembler("tianyou-assembler") {{
            localizedName = "机甲组装厂";
            size = 5;
            health = 2400;
            consumePower(15f);

            plans.add(new AssemblerUnitPlan(
                TianyouUnit.tianyou,
                60f * 120f,
                new PayloadStack[]{
                    new PayloadStack(UnitTypes.merui, 6),
                    new PayloadStack(UnitTypes.cleroi, 8)
                }
            ));
        }};
    }
}