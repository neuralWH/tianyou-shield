package tianyou.shield;

import arc.struct.Seq;
import mindustry.content.UnitTypes;
import mindustry.type.PayloadStack;
import mindustry.world.blocks.units.UnitAssembler;

public class TianyouAssembler {

    public static UnitAssembler tianyouAssembler;

    public static void load() {
        tianyouAssembler = new UnitAssembler("tianyou-assembler") {{
            localizedName = "@block.tianyou-assembler.name";
            size = 5;
            health = 2400;
            consumePower(15f);

            plans.add(new AssemblerUnitPlan(
                TianyouUnit.tianyou,
                60f * 120f,
                Seq.with(
                    new PayloadStack(UnitTypes.merui, 6),
                    new PayloadStack(UnitTypes.cleroi, 8)
                )
            ));
        }};
    }
}
